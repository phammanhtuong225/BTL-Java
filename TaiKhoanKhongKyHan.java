package com.mycompany.btl;

public class TaiKhoanKhongKyHan extends TaiKhoan {

    private double laiSuat = 0.2;

    public TaiKhoanKhongKyHan(String soTaiKhoan, double soDu) {
        super(soTaiKhoan, soDu);
    }

    @Override
    public void hienThiTk() {
        System.out.printf("\tSo tai khoan: %s\n\t*Tai khoan khong ky han*\n\tSo du: %.0f\n\tLai suat: %.0f\n", this.getSoTaiKhoan(), this.getSoDu(), this.tinhLaiSuat());
    }

    @Override
    public double tinhLaiSuat() {
        return this.getSoDu() * this.laiSuat / 100 / 12;
    }

    @Override
    public boolean isDaoHan() {
        return true;
    }

    public double getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(double laiSuat) {
        this.laiSuat = laiSuat;
    }
}
