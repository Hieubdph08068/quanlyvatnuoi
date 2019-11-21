package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duan1.dao.VatNuoiDao;
import com.example.duan1.model.VatNuoi;

public class ThemVatNuoiActivity extends AppCompatActivity {
    EditText edMaVn;
    EditText edTenVn;
    EditText edLoai;
    EditText edTenChu;
    EditText edSdt;
    EditText edDacdiem;
    String MaVn;
    VatNuoiDao vatNuoiDao;
    Button btnshow, btnhuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Thêm Vật Nuôi");
        setContentView(R.layout.activity_them_vat_nuoi);
        edMaVn = (EditText) findViewById(R.id.edmavn);
        edTenVn = (EditText) findViewById(R.id.edtenvn);
        edLoai = (EditText) findViewById(R.id.edloai);
        edTenChu = (EditText) findViewById(R.id.edtenchu);
        edSdt = (EditText) findViewById(R.id.edsdt);
        edDacdiem = (EditText) findViewById(R.id.eddacdiem);
        btnshow = findViewById(R.id.btnshow);
        btnhuy=findViewById(R.id.btnhuy);
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemVatNuoiActivity.this,QL_VatNuoiActivity.class);
                startActivity(intent);
            }
        });



        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemVatNuoiActivity.this, QL_VatNuoiActivity.class);
                startActivity(intent);
            }
        });
    }

    public void addNewVN(View view) {
        vatNuoiDao = new VatNuoiDao(ThemVatNuoiActivity.this);
        try {
            if (ValidateForm() > 0) {
                VatNuoi vatNuoi = new VatNuoi(edMaVn.getText().toString(), edTenVn.getText().toString(), edLoai.getText().toString(), edTenChu.getText().toString(), edSdt.getText().toString(), edDacdiem.getText().toString());
                boolean isInsertTrue = vatNuoiDao.insertVatNuoi(vatNuoi);
                if (isInsertTrue) {
                    Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Thêm thất bại", Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception e) {

        }

    }

    public void updateVN(View view) {
        if (vatNuoiDao.updateVatnuoi(MaVn, edTenVn.getText().toString(), edLoai.getText().toString(), edTenChu.getText().toString(), edSdt.getText().toString(), edDacdiem.getText().toString()) > 0) {
            Toast.makeText(getApplicationContext(), "Sửa thành công", Toast.LENGTH_SHORT).show();

        }
    }


    public int ValidateForm() {
        int check = 1;
        if (edMaVn.getText().length() == 0 || edTenVn.getText().length() == 0 || edLoai.getText().length() == 0 || edTenChu.getText().length() == 0 || edSdt.getText().length() == 0 || edDacdiem.getText().length() == 0) {
            Toast.makeText(this, "Không được để trống", Toast.LENGTH_SHORT).show();
            check = -1;
        } else {
            check = 1;
        }
        return check;
    }
}
