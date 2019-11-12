package com.example.duan1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.duan1.dao.VatNuoiDao;

public class databasehelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dbvatnuoi";
    public static final int VERSION = 1;

    public databasehelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(VatNuoiDao.SQL_VAT_NUOI);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(VatNuoiDao.SQL_VAT_NUOI);
    }
}
