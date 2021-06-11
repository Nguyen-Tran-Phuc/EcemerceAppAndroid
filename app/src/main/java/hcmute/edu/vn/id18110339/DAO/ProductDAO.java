package hcmute.edu.vn.id18110339.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import hcmute.edu.vn.id18110339.DTO.ProductDTO;
import hcmute.edu.vn.id18110339.Database.DatabaseHandle;

public class ProductDAO {
    SQLiteDatabase database;

    public ProductDAO(Context context){
        DatabaseHandle databaseHandle = new DatabaseHandle(context);
        database = databaseHandle.Open();
    }

    public void AddProduct(int categoryId, String productName, int productPrice,int image){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHandle.TB_PRODUCT_CATEGORYID, categoryId);
        contentValues.put(DatabaseHandle.TB_PRODUCT_NAME, productName);
        contentValues.put(DatabaseHandle.TB_PRODUCT_PRICE, productPrice);
        contentValues.put(DatabaseHandle.TB_PRODUCT_IMAGE, image);
        database.insert(DatabaseHandle.TB_PRODUCT, null, contentValues);
    }

    public ArrayList<ProductDTO> productDTOS(int categoryId){
        ArrayList<ProductDTO> ls = new ArrayList<>();
        Cursor cursor = database.rawQuery("select * from " + DatabaseHandle.TB_PRODUCT + " where CATEGORYID = ? ", new  String[]{String.valueOf(categoryId)});
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            ProductDTO productDTO = new ProductDTO();
            productDTO.set_ProductId(cursor.getInt(0));
            productDTO.set_ProductName(cursor.getString(1));
            productDTO.set_ProductPrice(cursor.getInt(2));
            productDTO.set_ProductCategoryId(cursor.getInt(3));
            productDTO.set_ProductImage(cursor.getInt(4));
            ls.add(productDTO);
            cursor.moveToNext();
        }
        cursor.close();
        return ls;
    }
}
