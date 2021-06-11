package hcmute.edu.vn.id18110339.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import hcmute.edu.vn.id18110339.DTO.UserDTO;
import hcmute.edu.vn.id18110339.Database.DatabaseHandle;

public class CategoryDAO {
    SQLiteDatabase database;

    public CategoryDAO(Context context){
        DatabaseHandle databaseHandle = new DatabaseHandle(context);
        database = databaseHandle.Open();
    }

    public void AddCategory(String categoryname){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHandle.TB_CATEGORY_NAME, categoryname);
        database.insert(DatabaseHandle.TB_CATEGORY, null, contentValues);
    }
}
