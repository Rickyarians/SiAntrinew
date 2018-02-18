package com.example.android.hiro;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LoginActivity extends AppCompatActivity {
    Button btn_pasien_umum, btn_pasien_bpjs;
    Cursor cursor;
    String[] daftar;
    DatabaseHelper dbcenter;

    private void setupView() {
        btn_pasien_umum = findViewById(R.id.btn_pasien_umum);
        btn_pasien_bpjs = findViewById(R.id.btn_pasien_bpjs);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupView();


        //intent ke activity pasien umum
        btn_pasien_umum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentumum = new Intent(LoginActivity.this, UmumActivity.class);

                startActivity(intentumum);
            }
        });


        //Intent ke activity pasien BPJS
        btn_pasien_bpjs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentbpjs = new Intent(LoginActivity.this, bpjsActivity.class);

                startActivity(intentbpjs);
            }
        });


        //Get Waktu dan Tanggal
        TextView tv = (TextView) findViewById(R.id.Date);
        String ct = DateFormat.getDateInstance().format(new Date());
        tv.setText(ct);
    }


}
