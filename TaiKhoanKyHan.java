package com.mycompany.btl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaiKhoanKyHan extends TaiKhoan {

    private LocalDate ngayDaoHan;
    private KyHan kyHan;
    private LocalDate ngayTaoTaiKhoan;

    public TaiKhoanKyHan(String soTaiKhoan, double soDu, KyHan kyHan) {
        super(soTaiKhoan, soDu);
        this.kyHan = kyHan;
        this.ngayDaoHan = kyHan.tinhDaoHan(LocalDate.now());
        this.ngayTaoTaiKhoan = LocalDate.now();
    }

    public double tinhSoNgayTuTaoDenRut() {
        LocalDate d1 = LocalDate.now();
        LocalDate d2 = this.ngayTaoTaiKhoan;
        return d1.toEpochDay() - d2.toEpochDay();
    }

    @Override
    public double tinhLaiSuat() {
        return this.kyHan.tinhLai(this.getSoDu());
    }

    @Override
    public boolean isDaoHan() {
        return LocalDate.now().equals(this.ngayDaoHan);
    }

    @Override
    public void hienThiTk() {
        System.out.printf("\t*Tai Khoan Ky Han*\n\tKy han: %s\n\tNgay dao han: %s\n\tSo du: %.0f\n\tLai suat: %.0f\n",
                this.kyHan, this.ngayDaoHan.format(DateTimeFormatter.ofPattern(CauHinh.DATE_PATTERN)), this.getSoDu(), this.tinhLaiSuat());
    }

    public LocalDate getNgayDaoHan() {
        return ngayDaoHan;
    }

    public void setNgayDaoHan(LocalDate ngayDaoHan) {
        this.ngayDaoHan = ngayDaoHan;
    }

    public KyHan getKyHan() {
        return kyHan;
    }

    public void setKyHan(KyHan kyHan) {
        this.kyHan = kyHan;
    }

    public LocalDate getNgayTaoTaiKhoan() {
        return ngayTaoTaiKhoan;
    }

    public void setNgayTaoTaiKhoan(LocalDate ngayTaoTaiKhoan) {
        this.ngayTaoTaiKhoan = ngayTaoTaiKhoan;
    }
}
