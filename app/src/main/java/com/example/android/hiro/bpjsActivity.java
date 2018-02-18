package com.example.android.hiro;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class bpjsActivity extends AppCompatActivity {
    Button btn_daftarbpjs, btn_batalbpjs;
    TextView title_bpjs, tvnama_bpjs, tvumur_bpjs, tvnomor_bpjs, tvalamat_bpjs, tvkeluhan_bpjs;
    EditText et_namabpjs, et_umurbpjs, et_nomorbpjs, et_alamatbpjs, et_keluhanbpjs;
    DatabaseHelper myDb;

    private void setupView() {
        btn_daftarbpjs = findViewById(R.id.btn_daftarbpjs);
        btn_batalbpjs = findViewById(R.id.btn_batalbpjs);
        et_namabpjs = findViewById(R.id.et_namabpjs);
        et_umurbpjs = findViewById(R.id.et_umurbpjs);
        et_nomorbpjs = findViewById(R.id.et_nomorbpjs);
        et_alamatbpjs = findViewById(R.id.et_alamatbpjs);
        et_keluhanbpjs = findViewById(R.id.et_keluhanbpjs);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bpjs);
        myDb = new DatabaseHelper(this);
        setupView();

        final AntrianClass antrian = new AntrianClass();


        btn_daftarbpjs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_namabpjs.getText().toString().length() == 0) {
                    et_namabpjs.setError("Nama Tidak Boleh Kosong");
                } else if (et_umurbpjs.getText().toString().length() == 0) {
                    et_umurbpjs.setError("Umur Tidak Boleh Kosong");
                } else if (et_nomorbpjs.getText().toString().length() == 0) {
                    et_nomorbpjs.setError("Nomor Telepon Tidak Boleh Kosong");
                } else if (et_alamatbpjs.getText().toString().length() == 0) {
                    et_alamatbpjs.setError("Alamat Telepon Tidak Boleh Kosong");
                } else if (et_keluhanbpjs.getText().toString().length() == 0) {
                    et_keluhanbpjs.setError("Keluhan Tidak Boleh Kosong");
                } else {


                    SQLiteDatabase db = myDb.getWritableDatabase();
                    db.execSQL("insert into biodatabpjs(nama_pasienbpjs, umur_pasienbpjs, notlp_pasienbpjs, alamat_pasienbpjs, keluhan_pasienbpjs) values('" +
                            et_namabpjs.getText().toString() + "','" +
                            et_umurbpjs.getText().toString() + "','" +
                            et_nomorbpjs.getText().toString() + "','" +
                            et_alamatbpjs.getText().toString() + "','" +
                            et_keluhanbpjs.getText().toString() + "')");

                    antrian.setNama(et_namabpjs.getText().toString());
                    antrian.setUmur(et_umurbpjs.getText().toString());
                    antrian.setNotlp(et_nomorbpjs.getText().toString());
                    antrian.setAlamat(et_alamatbpjs.getText().toString());
                    antrian.setKeluhan(et_keluhanbpjs.getText().toString());
                    Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                    antrian.bpjsTambah();
                    antrian.setBpjs("BPJS");

                    Intent outputbpjs = new Intent(bpjsActivity.this, outputActivity.class);
                    outputbpjs.putExtra("nama_pasien", antrian.getNama());
                    outputbpjs.putExtra("umur_pasien", antrian.getUmur());
                    outputbpjs.putExtra("nomor_telepon", antrian.getNotlp());
                    outputbpjs.putExtra("alamat_pasien", antrian.getAlamat());
                    outputbpjs.putExtra("keluhan_pasien", antrian.getKeluhan());
                    outputbpjs.putExtra("antrian",antrian.getAntrianbpjs());
                    outputbpjs.putExtra("tipeantrian",antrian.getBpjs());



                    startActivity(outputbpjs);
                }
            }
        });


        btn_batalbpjs.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                Intent balikbpjs = new Intent(bpjsActivity.this, LoginActivity.class);

                startActivity(balikbpjs);
            }
        });
    }
}
