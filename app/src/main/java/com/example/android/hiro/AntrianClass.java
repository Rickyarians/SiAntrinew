package com.example.android.hiro;

/**
 * Created by Armstrong on 2/8/2018.
 */

public class AntrianClass {

    private String mNama;
    private String mUmur;
    private String mNotlp;
    private String mAlamat;
    private String mKeluhan;
    private int antrianumum;
    private int antrianbpjs;
    private String tipeumum;
    private String tipebpjs;


    public void setNama(String nama) {

        mNama = nama;

    }

    public String getNama() {

        return mNama;
    }

    public void setUmum (String namaumum) {

        tipeumum = namaumum;

    }

    public String getUmum() {

        return tipeumum;
    }
    public void setBpjs(String namabpjs) {

        tipebpjs = namabpjs;

    }


    public String getBpjs() {

        return tipebpjs;
    }

    public void setUmur(String umur) {

        mUmur = umur;
    }

    public String getUmur() {

        return mUmur;
    }

    public void setNotlp(String notelepon) {

        mNotlp = notelepon;


    }

    public String getNotlp() {

        return mNotlp;
    }

    public void setAlamat(String alamat) {

        mAlamat = alamat;
    }

    public String getAlamat() {

        return mAlamat;
    }

    public void setKeluhan(String keluhan) {

        mKeluhan = keluhan;
    }

    public String getKeluhan() {

        return mKeluhan;
    }

    public void umumTambah() {

        antrianumum++;

    }

    public int getAntrianumum(){

        return antrianumum;
    }

    public void bpjsTambah() {

        antrianbpjs++;
    }

    public int getAntrianbpjs(){

        return antrianbpjs;
    }


}




