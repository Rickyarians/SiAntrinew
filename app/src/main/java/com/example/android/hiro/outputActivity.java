package com.example.android.hiro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class outputActivity extends AppCompatActivity {
    TextView tipe_antrian, nomer_antrian, tvoutput_pasien, tvoutput_umur, tvoutput_notlp, tvoutput_alamat, tvoutput_keluhan;

    String namapasien;
    String umurpasien;
    String nomortelepon;
    String alamatpasien;
    String keluhanpasien;
    String tipeantrian;
    int nomorantrian;


    private void SetupView() {
        nomer_antrian = findViewById(R.id.nomer_antrian);
        tvoutput_pasien = findViewById(R.id.tvoutput_pasien);
        tvoutput_umur = findViewById(R.id.tvoutput_umur);
        tvoutput_notlp = findViewById(R.id.tvoutput_notlp);
        tvoutput_alamat = findViewById(R.id.tvoutput_alamat);
        tvoutput_keluhan = findViewById(R.id.tvoutput_keluhan);
        tipe_antrian = findViewById(R.id.tipe_antrian);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        SetupView();
        getData();


        tvoutput_pasien.setText("" + namapasien);
        tvoutput_umur.setText("" + umurpasien);
        tvoutput_notlp.setText("" + nomortelepon);
        tvoutput_alamat.setText("" + alamatpasien);
        tvoutput_keluhan.setText("" + keluhanpasien);
        nomer_antrian.setText("" + nomorantrian);
        tipe_antrian.setText("" + tipeantrian );

    }

    private void getData() {
        Intent outputumum = getIntent();
        namapasien = outputumum.getStringExtra("nama_pasien");
        umurpasien = outputumum.getStringExtra("umur_pasien");
        nomortelepon= outputumum.getStringExtra("nomor_telepon");
        alamatpasien = outputumum.getStringExtra("alamat_pasien");
        keluhanpasien = outputumum.getStringExtra("keluhan_pasien");
        nomorantrian = outputumum.getIntExtra("antrian",0);
        tipeantrian = outputumum.getStringExtra("tipeantrian");
    }

}
