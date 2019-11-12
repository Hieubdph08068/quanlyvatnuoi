package com.example.duan1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1.database.databasehelper;
import com.example.duan1.model.VatNuoi;

import java.util.ArrayList;
import java.util.List;

public class VatNuoiDao {
    public static final String TABLE_NAME = "vatnuoi";
    public static final String SQL_VAT_NUOI = "" + "CREATE TABLE vatnuoi(mavatnuoi text primary key," + "ten text,loai text,tenchu text,sodienthoai text,dacdiem text);";
    public static final String TAG = "VatNuoi";

    private SQLiteDatabase db;
    private databasehelper dbHelper;

    public VatNuoiDao(Context context) {
        dbHelper = new databasehelper(context);
        db = dbHelper.getWritableDatabase();
    }


    public boolean insertVatNuoi(VatNuoi vn) {
        ContentValues values = new ContentValues();
        values.put("mavatnuoi", vn.getMavatnuoi());
        values.put("ten", vn.getTenvatnuoi());
        values.put("loai", vn.getLoai());
        values.put("tenchu", vn.getTenchu());
        values.put("sodienthoai", vn.getSodienthoai());
        values.put("dacdiem", vn.getDacdiem());
        long result = db.insert(TABLE_NAME, null, values);
        try {
            if (result == -1) {
                return false;
            }
        } catch (Exception ex) {
            Log.e(TAG, ex.toString());
            return false;
        }
        return true;
    }

    public int updateVatnuoi(VatNuoi vn) {
        ContentValues values = new ContentValues();
        values.put("mavatnuoi", vn.getMavatnuoi());
        values.put("ten", vn.getTenvatnuoi());
        values.put("loai", vn.getLoai());
        values.put("tenchu", vn.getTenchu());
        values.put("sodienthoai", vn.getSodienthoai());
        values.put("dacdiem", vn.getDacdiem());
        int result = db.update(TABLE_NAME, values, "mavatnuoi=?", new String[]{vn.getMavatnuoi()});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int deleteVatnuoi(String mavatnuoi) {
        int result = db.delete(TABLE_NAME, "mavatnuoi=?", new String[]{mavatnuoi});
        if (result == 0)
            return -1;
        return 1;
    }

    public List<VatNuoi> getAllVatNuoi() {
        List<VatNuoi> dsVatnuoi = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            VatNuoi vn = new VatNuoi();
            vn.setMavatnuoi(c.getString(0));
            vn.setTenvatnuoi(c.getString(1));
            vn.setLoai(c.getString(2));
            vn.setTenchu(c.getString(3));
            vn.setSodienthoai(c.getString(4));
            vn.setDacdiem(c.getString(5));
            dsVatnuoi.add(vn);
            Log.d("//=====", vn.toString());
            c.moveToNext();
        }
        c.close();
        return dsVatnuoi;

    }
}
