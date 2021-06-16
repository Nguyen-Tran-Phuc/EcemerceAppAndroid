package hcmute.edu.vn.id18110339.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import hcmute.edu.vn.id18110339.DTO.UserDTO;
import hcmute.edu.vn.id18110339.Database.DatabaseHandle;

public class UserDAO {
    SQLiteDatabase database;
    SQLiteDatabase database2;

    public UserDAO(Context context){
        DatabaseHandle databaseHandle = new DatabaseHandle(context);
        database = databaseHandle.Open();
        database2 = databaseHandle.getWritableDatabase();
    }

    public long AddUser(String username, String password, String phonenumber){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHandle.TB_USER_NAME, username);
        contentValues.put(DatabaseHandle.TB_USER_PASSWORD, password);
        contentValues.put(DatabaseHandle.TB_USER_PHONENUMBER, phonenumber);
        if(database.insert(DatabaseHandle.TB_USER, null, contentValues)<0){
            return -1;
        }
        else {
            return 1;
        }
    }

    public UserDTO CheckLogin(String username, String password){
        UserDTO userDTO = null;
        try{
            Cursor cursor = database.rawQuery("select * from " + DatabaseHandle.TB_USER + " where USERNAME = ? and PASSWORD = ?", new  String[]{username,password});
            if(cursor.moveToFirst()){
                userDTO = new UserDTO();
                userDTO.set_UserId(cursor.getInt(0));
                userDTO.set_UserName(cursor.getString(1));
                userDTO.set_Password(cursor.getString(2));
                userDTO.set_UserPhone(cursor.getString(3));
            }
        } catch (Exception e){
            userDTO = null;
        }
        return userDTO;
    }
    public long update (String username, String phone, String password, int userId){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHandle.TB_USER_NAME, username);
        contentValues.put(DatabaseHandle.TB_USER_PASSWORD, password);
        contentValues.put(DatabaseHandle.TB_USER_PHONENUMBER, phone);
        long check = database.update(DatabaseHandle.TB_USER, contentValues,"USERID=?", new String[]{String.valueOf(userId)});
        if(check == -1){
            return -1;
        }else {
            return 1;
        }
        /*String sql = "UPDATE " + DatabaseHandle.TB_USER + " SET USERNAME = '" + username + "' , PHONENUMBER = '" + phone + "', PASSWORD = '" + password + "' WHERE USERID = " + userId;
        database.execSQL(sql);
        return 1;*/
    }
}
