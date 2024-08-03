package com.mycompany.btl;

import java.time.LocalDate;

public enum KyHan {
    MOT_TUAN(7, 2) {
        @Override
        public LocalDate tinhDaoHan(LocalDate d) {
            return d.plusDays(this.khoangTg);
        }

        @Override
        public double tinhLai(double st) {
            return (st * this.laiSuat) / 100 / 12 / 4;
        }
    },
    MOT_THANG(1, 5.5) {
        @Override
        public LocalDate tinhDaoHan(LocalDate d) {
            return d.plusMonths(this.khoangTg);
        }

        @Override
        public double tinhLai(double st) {
            return (st * this.laiSuat) / 100 / 12;
        }
    },
    SAU_THANG(6, 7.5) {
        @Override
        public LocalDate tinhDaoHan(LocalDate d) {
            return d.plusMonths(this.khoangTg);
        }

        @Override
        public double tinhLai(double st) {
            return (st * this.laiSuat) / 100 / 12;
        }
    },
    MOT_NAM(1, 7.9) {
        @Override
        public LocalDate tinhDaoHan(LocalDate d) {
            return d.plusYears(this.khoangTg);
        }

        @Override
        public double tinhLai(double st) {
            return (st * this.laiSuat) / 100;
        }
    };
    protected int khoangTg;
    protected double laiSuat;

    private KyHan(int khoangTg, double laiSuat) {
        this.khoangTg = khoangTg;
        this.laiSuat = laiSuat;
    }

    public abstract LocalDate tinhDaoHan(LocalDate d);

    public abstract double tinhLai(double st);

    public int getKhoangTg() {
        return khoangTg;
    }

    public void setKhoangTg(int khoangTg) {
        this.khoangTg = khoangTg;
    }

    public double getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(double laiSuat) {
        this.laiSuat = laiSuat;
    }
}
