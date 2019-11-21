package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
        lvVatnuoi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent(QL_VatNuoiActivity.this, SuaVatNuoiActivity.class);
                Bundle b = new Bundle();
                b.putString("MAVATNUOI", dsVatnuoi.get(position).getMavatnuoi());
                b.putString("TENVATNUOI", dsVatnuoi.get(position).getTenvatnuoi());
                b.putString("LOAI", dsVatnuoi.get(position).getLoai());
                b.putString("TENCHU", dsVatnuoi.get(position).getTenchu());
                b.putString("SODIENTHOAI", dsVatnuoi.get(position).getSodienthoai());
                b.putString("DACDIEM", dsVatnuoi.get(position).getDacdiem());
                intent.putExtras(b);
                startActivity(intent);
            }
        });

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
