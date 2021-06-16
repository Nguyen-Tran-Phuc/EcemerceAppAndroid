package hcmute.edu.vn.id18110339.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import hcmute.edu.vn.id18110339.DTO.UserDTO;

public class DatabaseHandle extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 5;
    private static final String DATABASE_NAME = "Ministop_ver5";

    public static final String TB_USER = "USER";
    public static final String TB_CATEGORY = "CATEGORY";
    public static final String TB_PRODUCT = "PRODUCT";
    public static final String TB_ORDER = "ODER";
    private static final String TB_BILLDETAIL = "BILLDETAIL";

    private static final String TB_USER_USERID = "USERID";
    public static final String TB_USER_NAME = "USERNAME";
    public static final String TB_USER_PASSWORD = "PASSWORD";
    public static final String TB_USER_PHONENUMBER = "PHONENUMBER";


    private static final String TB_CATEGORY_CATEGORYID = "CATEGORYID";
    public static final String TB_CATEGORY_NAME = "CATEGORYNAME";


    public static final String TB_PRODUCT_PRODUCTID = "PRODUCTID";
    public static final String TB_PRODUCT_CATEGORYID = "CATEGORYID";
    public static final String TB_PRODUCT_NAME = "PRODUCTNAME";
    public static final String TB_PRODUCT_PRICE = "PRICE";
    public static final String TB_PRODUCT_IMAGE = "IMAGE";


    private static final String TB_ORDER_ORDERID = "ORDERID";
    public static final String TB_ORDER_STATUS = "ORDERSTATUS";
    public static final String TB_ORDER_USERID = "USERID";
    public static final String TB_ORDER_PRODUCTNAME = "PRODUCTNAME";
    public static final String TB_ORDER_QUANTITY = "QUANTITY";
    public static final String TB_ORDER_COST = "COST";
    public static final String TB_ORDER_IMAGE = "IMAGE";

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
                + TB_PRODUCT_PRODUCTID + " INTEGER PRIMARY KEY AUTOINCREMENT," + TB_PRODUCT_NAME + " TEXT,"
                + TB_PRODUCT_PRICE + " INTEGER," + TB_PRODUCT_CATEGORYID + " INTEGER, "+ TB_PRODUCT_IMAGE + " INTEGER "+ ")";
        db.execSQL(CREATE_TABLE_PRODUCT);

        String CREATE_TABLE_ORDER = "CREATE TABLE " + TB_ORDER + "("
                + TB_ORDER_ORDERID + " INTEGER PRIMARY KEY AUTOINCREMENT," + TB_ORDER_STATUS + " INTEGER,"
                + TB_ORDER_USERID + " INTEGER," + TB_ORDER_PRODUCTNAME + " TEXT, "+ TB_ORDER_QUANTITY + " INTEGER, "+ TB_ORDER_COST + " INTEGER, " + TB_ORDER_IMAGE + " INTEGER " + ")";
        db.execSQL(CREATE_TABLE_ORDER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TB_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TB_CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS " + TB_PRODUCT);
        db.execSQL("DROP TABLE IF EXISTS "+ TB_ORDER);
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
