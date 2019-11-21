package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duan1.dao.DichVuDao;
import com.example.duan1.dao.VatNuoiDao;
import com.example.duan1.model.DichVu;
import com.example.duan1.model.VatNuoi;

public class ThemDichVuActivity extends AppCompatActivity {
EditText edMaDichVu,edTenDichVu,edMoTa,edGia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Thêm Dịch Vụ");
        setContentView(R.layout.activity_them_dich_vu);
        edMaDichVu=findViewById(R.id.edMaDichVu);
        edTenDichVu=findViewById(R.id.edTenDichVu);
        edMoTa=findViewById(R.id.edMoTa);
        edGia=findViewById(R.id.edGia);
    }
    public void addNewDV(View view) {
        DichVuDao dichVuDao = new DichVuDao(ThemDichVuActivity.this);
        try {
            if (ValidateForm() > 0) {
                DichVu dichVu = new DichVu(edMaDichVu.getText().toString(), edTenDichVu.getText().toString(), edMoTa.getText().toString(), edGia.getText().toString());
                boolean isInsertTrue = dichVuDao.insertDichVu(dichVu);
                if (isInsertTrue) {
                    Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Thêm thất bại", Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception e) {

        }

    }
    public int ValidateForm() {
        int check = 1;
        if (edMaDichVu.getText().length() == 0 || edTenDichVu.getText().length() == 0 || edMoTa.getText().length() == 0 || edGia.getText().length() == 0) {
            Toast.makeText(this, "Không được để trống", Toast.LENGTH_SHORT).show();
            check = -1;
        } else {
            check = 1;
        }
        return check;
}}
