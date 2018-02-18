package com.example.android.hiro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "datapasien.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table biodataumum(no_pasienumum integer primary key autoincrement, nama_pasienumum text null, umur_pasienumum text null, notlp_pasienumum text null,alamat_pasienumum text null, keluhan_pasienumum text null);";
        Log.d("Data UMUM", "onCreate: " + sql);
        db.execSQL(sql);

        String sql1 = "create table biodatabpjs(no_pasienbpjs integer primary key, nama_pasienbpjs text null, umur_pasienbpjs text null, notlp_pasienbpjs text null,alamat_pasienbpjs text null, keluhan_pasienbpjs text null);";
        Log.d("Data BPJS", "onCreate: " + sql1);
        db.execSQL(sql1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
    }
}