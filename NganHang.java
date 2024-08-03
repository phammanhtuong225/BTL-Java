package com.mycompany.btl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NganHang {

    private List<KhachHang> danhSachKhachHang;

    public NganHang() {
        this.danhSachKhachHang = new ArrayList<>();
    }

    public boolean kiemTraTaiKhoan(String kw) {
        for (KhachHang kh : danhSachKhachHang) {
            if (kh.getUsername().equals(kw) || kh.getSoCCCD().equals(kw)) {
                return true;
            }
        }
        return false;
    }

    public List<KhachHang> timKiemTheoTenHoacMaSo(String kw) {
        String keywordLowerCase = kw.trim().toLowerCase().replaceAll("\\s+", " ");
        return this.danhSachKhachHang.stream()
                .filter(h -> h.getHoTen().toLowerCase().equals(keywordLowerCase) || h.getMaSo().equals(kw))
                .collect(Collectors.toList());
    }

    public KhachHang kiemTraDangNhap(String username, String password) {
        for (KhachHang khachHang : danhSachKhachHang) {
            if (khachHang.getUsername().equals(username) && khachHang.getPassword().equals(password)) {
                return khachHang;
            }
        }
        return null;
    }

    public KhachHang timKiemTheoMaSo(String kw) {
        return this.danhSachKhachHang.stream()
                .filter(h -> h.getMaSo().equals(kw))
                .findFirst()
                .orElse(null);
    }

    public void themKhachHang(KhachHang khachHang) {
        String username = khachHang.getUsername();
        String soCCCD = khachHang.getSoCCCD();
        if (kiemTraTaiKhoan(username)) {
            System.out.println("Da ton tai username");
        }
        if (kiemTraTaiKhoan(soCCCD)) {
            System.out.println("Da ton tai so CCCD");
        } else if (!kiemTraTaiKhoan(username) && !kiemTraTaiKhoan(soCCCD)) {
            danhSachKhachHang.add(khachHang);
            System.out.println("Dang ky thong tin thanh cong!");
            System.out.printf("Tai khoan dang nhap: %s\nMat khau dang nhap: %s\n", khachHang.getUsername(), khachHang.getPassword());
        }
    }

    public void hienThiDanhSachKhachHang() {
        System.out.println("===== Danh Sach Khach Hang =====");
        for (KhachHang khachHang : danhSachKhachHang) {
            khachHang.hienThi();
            khachHang.hienThiDsTk();
            System.out.println("------------------------------");
        }
    }

    public void sapXepKhachHangTheoTongSoTienGui() {
        danhSachKhachHang = danhSachKhachHang.stream()
                .sorted((kh1, kh2) -> {
                    double tongSoTienGui1 = kh1.getDanhSachTaiKhoan().stream().mapToDouble(TaiKhoan::getSoDu).sum();
                    double tongSoTienGui2 = kh2.getDanhSachTaiKhoan().stream().mapToDouble(TaiKhoan::getSoDu).sum();
                    return Double.compare(tongSoTienGui2, tongSoTienGui1);
                })
                .toList();
    }

    public List<KhachHang> getDanhSachKhachHang() {
        return danhSachKhachHang;
    }

    public void setDanhSachKhachHang(List<KhachHang> danhSachKhachHang) {
        this.danhSachKhachHang = danhSachKhachHang;
    }
}
