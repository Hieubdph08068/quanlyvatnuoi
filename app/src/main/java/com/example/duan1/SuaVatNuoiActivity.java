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

public class SuaVatNuoiActivity extends AppCompatActivity {
    String MaVn;
    EditText edTenVn;
    EditText edLoai;
    EditText edTenChu;
    EditText edSdt;
    EditText edDacdiem;
    Button btnshow, btnhuy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_vat_nuoi);
        edTenVn = (EditText) findViewById(R.id.edtenvn);
        edLoai = (EditText) findViewById(R.id.edloai);
        edTenChu = (EditText) findViewById(R.id.edtenchu);
        edSdt = (EditText) findViewById(R.id.edsdt);
        edDacdiem = (EditText) findViewById(R.id.eddacdiem);

        btnhuy=findViewById(R.id.btnhuy);
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SuaVatNuoiActivity.this,QL_VatNuoiActivity.class);
                startActivity(intent);
            }
        });
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SuaVatNuoiActivity.this, QL_VatNuoiActivity.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if (b != null) {
            MaVn=b.getString("MAVATNUOI");
            edTenVn.setText(b.getString("TENVATNUOI"));
            edLoai.setText(b.getString("LOAI"));
            edTenChu.setText(b.getString("TENCHU"));
            edSdt.setText(b.getString("SODIENTHOAI"));
            edDacdiem.setText(b.getString("DACDIEM"));
        }
    }

    public void updateVN(View view) {
        VatNuoiDao vatNuoiDao=new VatNuoiDao(SuaVatNuoiActivity.this);

        try {
            VatNuoi vatNuoi = new VatNuoi(MaVn, edTenVn.getText().toString(), edLoai.getText().toString(), edTenChu.getText().toString(),edSdt.getText().toString(),edDacdiem.getText().toString());
            if (vatNuoiDao.updatevn(vatNuoi) > 0) {
                Toast.makeText(this, "Sửa thành công", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Sửa thất bại", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {

        }
    }

}
