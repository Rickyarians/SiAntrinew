package com.example.android.hiro;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UmumActivity extends AppCompatActivity {
    Button btn_daftarumum, btn_batalumum;
    TextView title_umum, tvnama_umum, tvumur_umum, tvnomor_umum, tvalamat_umum, tvkeluhan_umum;
    EditText etnama_umum, etumur_umum, etnomor_umum, etalamat_umum, etkeluhan_umum;
    DatabaseHelper myDb;


    private void setupView() {
        btn_daftarumum = findViewById(R.id.btn_daftarumum);
        btn_batalumum = findViewById(R.id.btn_batalumum);
        etnama_umum = findViewById(R.id.etnama_umum);
        etumur_umum = findViewById(R.id.etumur_umum);
        etnomor_umum = findViewById(R.id.etnomor_umum);
        etalamat_umum = findViewById(R.id.etalamat_umum);
        etkeluhan_umum = findViewById(R.id.etkeluhan_umum);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umum);
        myDb = new DatabaseHelper(this);
        setupView();

        final AntrianClass antrian = new AntrianClass();


        btn_daftarumum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etnama_umum.getText().toString().length() == 0) {
                    etnama_umum.setError("Nama Tidak Boleh Kosong");
                } else if (etumur_umum.getText().toString().length() == 0) {
                    etumur_umum.setError("Umur Tidak Boleh Kosong");
                } else if (etnomor_umum.getText().toString().length() == 0) {
                    etnomor_umum.setError("Nomor Telepon Tidak Boleh Kosong");
                } else if (etalamat_umum.getText().toString().length() == 0) {
                    etalamat_umum.setError("Alamat Telepon Tidak Boleh Kosong");
                } else if (etkeluhan_umum.getText().toString().length() == 0) {
                    etkeluhan_umum.setError("Keluhan Tidak Boleh Kosong");
                } else {


                    SQLiteDatabase db = myDb.getWritableDatabase();
                    db.execSQL("insert into biodataumum(nama_pasienumum, umur_pasienumum, notlp_pasienumum, alamat_pasienumum, keluhan_pasienumum) values('" +
                            etnama_umum.getText().toString() + "','" +
                            etumur_umum.getText().toString() + "','" +
                            etnomor_umum.getText().toString() + "','" +
                            etalamat_umum.getText().toString() + "','" +
                            etkeluhan_umum.getText().toString() + "')");

                    antrian.setNama(etnama_umum.getText().toString());
                    antrian.setUmur(etumur_umum.getText().toString());
                    antrian.setNotlp(etnomor_umum.getText().toString());
                    antrian.setAlamat(etalamat_umum.getText().toString());
                    antrian.setKeluhan(etkeluhan_umum.getText().toString());
                    Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                    antrian.umumTambah();
                    antrian.setUmum("UMUM");

                    Intent outputumum = new Intent(UmumActivity.this, outputActivity.class);
                    outputumum.putExtra("nama_pasien", antrian.getNama());
                    outputumum.putExtra("umur_pasien", antrian.getUmur());
                    outputumum.putExtra("nomor_telepon", antrian.getNotlp());
                    outputumum.putExtra("alamat_pasien", antrian.getAlamat());
                    outputumum.putExtra("keluhan_pasien", antrian.getKeluhan());
                    outputumum.putExtra("antrian",antrian.getAntrianumum());
                    outputumum.putExtra("tipeantrian",antrian.getUmum());

                    startActivity(outputumum);
                }
            }
        });


        btn_batalumum.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                Intent balikumum = new Intent(UmumActivity.this, LoginActivity.class);

                startActivity(balikumum);
            }
        });
    }
}


