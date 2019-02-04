package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Customer.db";
    public static final String TABLE_NAME = "customer";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "MONTH";
    public static final String COL_3 = "DATE";
    public static final String COL_4 = "CUSTOMER_NAME";
    public static final String COL_5 = "PHONE_NUMBER";
    public static final String COL_6 = "COUNTRY";
    public static final String COL_7 = "CITY";
    public static final String COL_8 = "BOOKING_NUMBER";
    public static final String COL_9 = "TRAVEL_DATE";
    public static final String COL_10 = "HOTEL_NAME";
    public static final String COL_11 = "KIND_OF_ROOM";
    public static final String COL_12 = "GUESTS";
    public static final String COL_13 = "EXCHANGE_RATE";
    public static final String COL_14 = "BRUTTO";
    public static final String COL_15 = "NETTO";
    public static final String COL_16 = "COMPANY_COMMISSION";
    public static final String COL_17 = "PERSONEL_COMMISSION";
    public static final String COL_18 = "NOTE";
    public static final String COL_19 = "COMPANY_NAME";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, MONTH TEXT, DATE TEXT, CUSTOMER_NAME TEXT, " +
                "PHONE_NUMBER TEXT, COUNTRY TEXT, CITY TEXT, BOOKING_NUMBER TEXT, TRAVEL_DATE TEXT, HOTEL_NAME TEXT, KIND_OF_ROOM TEXT, " +
                "GUESTS TEXT, EXCHANGE_RATE TEXT, BRUTTO INTEGER, NETTO INTEGER, COMPANY_COMMISSION INTEGER, PERSONEL_COMMISSION INTEGER, NOTE TEXT, COMPANY_NAME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String month, String customer_name, String company_name, String country, String city, String travel_dates, String record_date, String kind_of_room, String guests, String customer_phone, String exchange_rate, int brutto, int netto, int company_commission, int your_commission, String notes, String booking_number, String hotel_name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, month);
        contentValues.put(COL_3, record_date);
        contentValues.put(COL_4, customer_name);
        contentValues.put(COL_5, customer_phone);
        contentValues.put(COL_6, country);
        contentValues.put(COL_7, city);
        contentValues.put(COL_8, booking_number);
        contentValues.put(COL_9, travel_dates);
        contentValues.put(COL_10, hotel_name);
        contentValues.put(COL_11, kind_of_room);
        contentValues.put(COL_12, guests);
        contentValues.put(COL_13, exchange_rate);
        contentValues.put(COL_14, brutto);
        contentValues.put(COL_15, netto);
        contentValues.put(COL_16, company_commission);
        contentValues.put(COL_17, your_commission);
        contentValues.put(COL_18, notes);
        contentValues.put(COL_19, company_name);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result == -1 ? false : true;
    }

    public Cursor getAllData(String month) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from " + TABLE_NAME + " where MONTH = '" + month + "'", null);
        return result;
    }

    public Cursor getUserInfo(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from " + TABLE_NAME + " where ID = " + id, null);
        return result;
    }

    public Integer deleteRecord(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID  = ?", new String[] {id+""});
    }

    public boolean updateData(int id, String month, String customer_name, String company_name, String country, String city, String travel_dates, String record_date, String kind_of_room, String guests, String customer_phone, String exchange_rate, int brutto, int netto, int company_commission, int your_commission, String notes, String booking_number, String hotel_name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, month);
        contentValues.put(COL_3, record_date);
        contentValues.put(COL_4, customer_name);
        contentValues.put(COL_5, customer_phone);
        contentValues.put(COL_6, country);
        contentValues.put(COL_7, city);
        contentValues.put(COL_8, booking_number);
        contentValues.put(COL_9, travel_dates);
        contentValues.put(COL_10, hotel_name);
        contentValues.put(COL_11, kind_of_room);
        contentValues.put(COL_12, guests);
        contentValues.put(COL_13, exchange_rate);
        contentValues.put(COL_14, brutto);
        contentValues.put(COL_15, netto);
        contentValues.put(COL_16, company_commission);
        contentValues.put(COL_17, your_commission);
        contentValues.put(COL_18, notes);
        contentValues.put(COL_19, company_name);
        long result = db.update(TABLE_NAME,  contentValues, "ID = ?", new String[] {id+""});
        return true;
    }

}
