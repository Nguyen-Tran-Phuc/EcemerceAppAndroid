package hcmute.edu.vn.id18110339.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import hcmute.edu.vn.id18110339.DTO.UserDTO;

public class DatabaseHandle extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "Ministop_ver2";

    public static final String TB_USER = "USER";
    private static final String TB_CATEGORY = "CATEGORY";
    private static final String TB_PRODUCT = "PRODUCT";
    private static final String TB_BILL = "BILL";
    private static final String TB_BILLDETAIL = "BILLDETAIL";

    private static final String TB_USER_USERID = "USERID";
    public static final String TB_USER_NAME = "USERNAME";
    public static final String TB_USER_PASSWORD = "PASSWORD";
    public static final String TB_USER_PHONENUMBER = "PHONENUMBER";


    private static final String TB_CATEGORY_CATEGORYID = "CATEGORYID";
    private static final String TB_CATEGORY_NAME = "CATEGORYNAME";


    private static final String TB_PRODUCT_PRODUCTID = "PRODUCTID";
    private static final String TB_PRODUCT_CATEGORYID = "CATEGORYID";
    private static final String TB_PRODUCT_NAME = "PRODUCTNAME";
    private static final String TB_PRODUCT_PRICE = "PRICE";


    private static final String TB_BILL_BILLID = "BILLID";
    private static final String TB_BILL_COST = "COST";


    private static final String TABLE_CATEGORY = "category";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";

    public DatabaseHandle(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_USER = "CREATE TABLE " + TB_USER + "("
                + TB_USER_USERID + " INTEGER PRIMARY KEY AUTOINCREMENT," + TB_USER_NAME + " TEXT,"
                + TB_USER_PASSWORD + " TEXT," + TB_USER_PHONENUMBER + " TEXT "+ ")";
        db.execSQL(CREATE_TABLE_USER);

        String CREATE_TABLE_CATEGORY = "CREATE TABLE " + TB_CATEGORY + "("
                + TB_CATEGORY_CATEGORYID + " INTEGER PRIMARY KEY AUTOINCREMENT," + TB_CATEGORY_NAME + " TEXT "+ ")";
        db.execSQL(CREATE_TABLE_CATEGORY);

        String CREATE_TABLE_PRODUCT = "CREATE TABLE " + TB_PRODUCT + "("
                + TB_PRODUCT_PRODUCTID + " INTEGER PRIMARY KEY AUTOINCREMENT," + TB_CATEGORY_NAME + " TEXT,"
                + TB_PRODUCT_PRICE + " INTEGER," + TB_PRODUCT_CATEGORYID + " INTEGER "+ ")";
        db.execSQL(CREATE_TABLE_PRODUCT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TB_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TB_CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS " + TB_PRODUCT);
        // Create tables again
        onCreate(db);
    }
    public SQLiteDatabase Open()
    {
        return this.getWritableDatabase();
    }

    public void addUser(UserDTO UserDTO) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TB_USER_NAME, UserDTO.get_UserName()); // Contact Name
        values.put(TB_USER_PASSWORD, UserDTO.get_Password()); // Contact Phone
        values.put(TB_USER_PHONENUMBER, UserDTO.get_UserPhone());
        // Inserting Row
        db.insert(TB_USER, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }
}
