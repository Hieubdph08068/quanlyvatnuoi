package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class QL_ThongTinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Thông Tin");
        setContentView(R.layout.activity_ql__thong_tin);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public void AddVatNuoi(MenuItem item) {
        Intent intent = new Intent(QL_ThongTinActivity.this, ThemThongTinActivity.class);
        startActivity(intent);
    }
}
