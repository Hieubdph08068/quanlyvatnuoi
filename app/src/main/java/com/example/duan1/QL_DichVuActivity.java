package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class QL_DichVuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Dịch Vụ");
        setContentView(R.layout.activity_ql__dich_vu);
    }@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public void AddVatNuoi(MenuItem item) {
        Intent intent = new Intent(QL_DichVuActivity.this, ThemDichVuActivity.class);
        startActivity(intent);
    }
}
