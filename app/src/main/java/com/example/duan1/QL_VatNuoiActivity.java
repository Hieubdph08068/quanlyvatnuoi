package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.duan1.adapter.VatNuoiAdapter;
import com.example.duan1.dao.VatNuoiDao;
import com.example.duan1.model.VatNuoi;

import java.util.ArrayList;
import java.util.List;

public class QL_VatNuoiActivity extends AppCompatActivity {
    public static List<VatNuoi> dsVatnuoi = new ArrayList<>();

    ListView lvVatnuoi;
    VatNuoiAdapter adapter = null;
    VatNuoiDao vatNuoiDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Vật Nuôi");
        setContentView(R.layout.activity_ql__vat_nuoi);
        lvVatnuoi = findViewById(R.id.lvVatnuoi);
        vatNuoiDao = new VatNuoiDao(QL_VatNuoiActivity.this);
        dsVatnuoi = vatNuoiDao.getAllVatNuoi();
        adapter = new VatNuoiAdapter(this, dsVatnuoi);
        lvVatnuoi.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void AddVatNuoi(MenuItem item) {
        Intent intent = new Intent(QL_VatNuoiActivity.this, ThemVatNuoiActivity.class);
        startActivity(intent);
    }
}
