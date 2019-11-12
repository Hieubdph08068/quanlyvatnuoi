package com.example.duan1.model;

public class VatNuoi {
    private String Mavatnuoi;
    private String Tenvatnuoi;
    private String Loai;
    private String Tenchu;
    private String Sodienthoai;
    private String Dacdiem;

    public VatNuoi(){
        this.Mavatnuoi = "abc";
        this.Tenvatnuoi = "abc";
        this.Loai = "abc";
        this.Tenchu = "abc";
        this.Sodienthoai = "abc";
        this.Dacdiem = "abc";
    }
    public VatNuoi(String mavatnuoi, String tenvatnuoi, String loai, String tenchu, String sodienthoai, String dacdiem) {
        this.Mavatnuoi = mavatnuoi;
        this.Tenvatnuoi = tenvatnuoi;
        this.Loai = loai;
        this.Tenchu = tenchu;
        this.Sodienthoai = sodienthoai;
        this.Dacdiem = dacdiem;
    }

    public String getMavatnuoi() {
        return Mavatnuoi;
    }

    public void setMavatnuoi(String mavatnuoi) {
        Mavatnuoi = mavatnuoi;
    }

    public String getTenvatnuoi() {
        return Tenvatnuoi;
    }

    public void setTenvatnuoi(String tenvatnuoi) {
        Tenvatnuoi = tenvatnuoi;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String loai) {
        Loai = loai;
    }

    public String getTenchu() {
        return Tenchu;
    }

    public void setTenchu(String tenchu) {
        Tenchu = tenchu;
    }

    public String getSodienthoai() {
        return Sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        Sodienthoai = sodienthoai;
    }

    public String getDacdiem() {
        return Dacdiem;
    }

    public void setDacdiem(String dacdiem) {
        Dacdiem = dacdiem;
    }
}

