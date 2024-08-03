package com.mycompany.btl;

public abstract class TaiKhoan {

    private String soTaiKhoan;
    private double soDu;

    public TaiKhoan(String soTaiKhoan, double soDu) {
        this.soTaiKhoan = soTaiKhoan;
        this.soDu = soDu;
    }

    public void napTien(double st) {
        if (isDaoHan()) {
            this.setSoDu(this.getSoDu() + st);
        }
    }

    public void rutTien(double st) {
        if (this.getSoDu() >= st) {
            this.setSoDu(this.getSoDu() - st);
        }
    }

    public abstract double tinhLaiSuat();

    public abstract void hienThiTk();

    public abstract boolean isDaoHan();

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public double getSoDu() {
        return soDu;
    }

    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }
}
