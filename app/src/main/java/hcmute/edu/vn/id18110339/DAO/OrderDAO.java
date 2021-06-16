package hcmute.edu.vn.id18110339.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import hcmute.edu.vn.id18110339.DTO.OrderDTO;
import hcmute.edu.vn.id18110339.DTO.ProductDTO;
import hcmute.edu.vn.id18110339.Database.DatabaseHandle;

public class OrderDAO {
    SQLiteDatabase database;

    public OrderDAO(Context context){
        DatabaseHandle databaseHandle = new DatabaseHandle(context);
        database = databaseHandle.Open();
    }
    public long AddOrder(int orderStatus, int userId, String productName,int quantity, int cost,int image){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHandle.TB_ORDER_STATUS, orderStatus);
        contentValues.put(DatabaseHandle.TB_ORDER_USERID, userId);
        contentValues.put(DatabaseHandle.TB_ORDER_PRODUCTNAME, productName);
        contentValues.put(DatabaseHandle.TB_ORDER_QUANTITY, quantity);
        contentValues.put(DatabaseHandle.TB_ORDER_COST, cost);
        contentValues.put(DatabaseHandle.TB_ORDER_IMAGE, image);
        if(database.insert(DatabaseHandle.TB_ORDER, null, contentValues)<0){
            return -1;
        }
        else {
            return 1;
        }
    }

    public ArrayList<OrderDTO> ListOrder(int userId, int status){
        ArrayList<OrderDTO> ls = new ArrayList<>();
        Cursor cursor = database.rawQuery("select * from " + DatabaseHandle.TB_ORDER + " where USERID = ? and ORDERSTATUS = ?", new  String[]{String.valueOf(userId),String.valueOf(status)});
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOderId(cursor.getInt(0));
            orderDTO.setStatus(cursor.getInt(1));
            orderDTO.setUserId(cursor.getInt(2));
            orderDTO.setProductId(cursor.getString(3));
            orderDTO.setQuantity(cursor.getInt(4));
            orderDTO.setCost(cursor.getInt(5));
            orderDTO.setProductImage(cursor.getInt(6));
            ls.add(orderDTO);
            cursor.moveToNext();
        }
        cursor.close();
        return ls;
    }

    public int NumberOfOrder(int userId, int status){
        ArrayList<OrderDTO> ls = new ArrayList<>();
        Cursor mCount = database.rawQuery("select count(*) from " + DatabaseHandle.TB_ORDER + " where USERID = ? and ORDERSTATUS = ?", new  String[]{String.valueOf(userId),String.valueOf(status)});
        mCount.moveToFirst();
        int count= mCount.getInt(0);
        mCount.close();
        return count;
    }

    public Boolean Payment_Cancel(int orderId , int orderStatus) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHandle.TB_ORDER_STATUS, orderStatus);
        database.update(DatabaseHandle.TB_ORDER, contentValues, "ORDERID = ?",new String[] { String.valueOf(orderId) });
        return true;
    }
}
