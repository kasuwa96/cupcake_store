
package com.example.thecuppy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "my3.db";
    private static final String TABLE_NAME_USERS = "users";
    private static final String COL_NAME = "name";
    private static final String COL_EMAIL = "email";
    private static final String COL_PASSWORD = "password";

    private static final String TABLE_NAME_ORDERS = "orderTable";
    private static final String COL_ID = "id";
    private static final String COL_CONTACT_NUMBER = "contact_number";
    private static final String COL_ADDRESS = "address";
    private static final String COL_AMOUNT = "amount";
    private static final String COL_QUANTITY = "quantity";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTableQuery = "CREATE TABLE " + TABLE_NAME_USERS + " (" +
                COL_NAME + " TEXT PRIMARY KEY, " +
                COL_EMAIL + " TEXT, " +
                COL_PASSWORD + " TEXT)";
        db.execSQL(createUserTableQuery);

        String createOrderTableQuery = "CREATE TABLE " + TABLE_NAME_ORDERS + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_EMAIL + " TEXT, " +
                COL_CONTACT_NUMBER + " TEXT, " +
                COL_ADDRESS + " TEXT, " +
                COL_AMOUNT + " REAL, " +
                COL_QUANTITY + " INTEGER)";
        db.execSQL(createOrderTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_ORDERS);
        onCreate(db);
    }

    public boolean insertUser(String name, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_EMAIL, email);
        contentValues.put(COL_PASSWORD, password);
        long result = db.insert(TABLE_NAME_USERS, null, contentValues);
        return result != -1;
    }

    public boolean checkEmail(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME_USERS + " WHERE " + COL_EMAIL + " = ?", new String[]{email});
        return cursor.getCount() > 0;
    }

    public boolean checkEmailPassword(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME_USERS + " WHERE " + COL_EMAIL + " = ? AND " + COL_PASSWORD + " = ?", new String[]{email, password});
        return cursor.getCount() > 0;
    }

    public String getName(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME_USERS + " WHERE " + COL_EMAIL + " = ?", new String[]{email});
        if (cursor.moveToFirst()) {
            String name = cursor.getString(cursor.getColumnIndex(COL_NAME));
            cursor.close();
            return name;
        }
        return null;
    }
    public boolean insertOrder(String email, String contactNumber, String address, double amount, int quantity) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_EMAIL, email);
        contentValues.put(COL_CONTACT_NUMBER, contactNumber);
        contentValues.put(COL_ADDRESS, address);
        contentValues.put(COL_AMOUNT, amount);
        contentValues.put(COL_QUANTITY, quantity);
        long result = db.insert(TABLE_NAME_ORDERS, null, contentValues);
        return result != -1;
    }


    }

