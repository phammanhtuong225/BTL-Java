package com.mycompany.btl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class KhachHang {

    private String hoTen;
    private String gioiTinh;
    private LocalDate ngaySinh;
    private String queQuan;
    private String soCCCD;
    private double soTienGui;
    private List<TaiKhoan> danhSachTaiKhoan = new ArrayList<>();
    private String username;
    private String password;
    private String maSo;
    private static int dem;
    private LocalDate ngayHienTai = LocalDate.now();

    {

        String ngayHienTaiHienThi = ngayHienTai.format(DateTimeFormatter.ofPattern(CauHinh.DATE_PATTERN2));
        maSo = String.format("%s%04d", ngayHienTaiHienThi, ++dem);
        int maSoRandom = (int) (Math.random() * 900000) + 100000;
        this.password = String.valueOf(maSoRandom);
    }

    public KhachHang() {
    }

    public String nhapLaiKhiBoTrong() {
        String giaTri;
        do {
            giaTri = CauHinh.sc.nextLine();
            if (giaTri.trim().isEmpty()) {
                System.out.println("Khong duoc bo trong. Vui long nhap lai.");
            } else {
                break;
            }
        } while (true);
        return giaTri.trim().replaceAll("\\s+", " ");
    }

    public void moTaiKhoanKyhan(KyHan kyHan) {
        double soTienCanTru;
        System.out.print("Nhap so tien nap vao tai khoan: ");
        soTienCanTru = CauHinh.sc.nextDouble();
        TaiKhoanKhongKyHan t1 = (TaiKhoanKhongKyHan) this.danhSachTaiKhoan.get(0);
        if (t1.getSoDu() >= (soTienCanTru + 50000) && soTienCanTru >= 100000) {
            t1.rutTien(soTienCanTru);
            TaiKhoan t = new TaiKhoanKyHan(this.maSo, soTienCanTru, kyHan);
            this.danhSachTaiKhoan.add(t);
            System.out.println("Mo tai khoan thanh cong.");
        } else {
            System.out.println("So tien khong du de thuc hien.");
        }
    }

    public String chuyenHoaKiTuDau(String hoTen) {
        String[] arrTen = hoTen.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String ten : arrTen) {
            if (!ten.isEmpty()) {
                String kyTuDau = ten.substring(0, 1).toUpperCase();
                String kyTuConLai = ten.substring(1).toLowerCase();

                sb.append(kyTuDau).append(kyTuConLai).append(" ");
            }
        }

        return sb.toString();
    }

    public void hienThi() {
        System.out.printf("***Thong tin khach hang***\n");
        System.out.printf("\tHo ten: %s\n", chuyenHoaKiTuDau(this.hoTen));
        System.out.printf("\tGioi tinh: %s\n", chuyenHoaKiTuDau(this.gioiTinh));
        System.out.printf("\tNgay sinh: %s\n", this.ngaySinh);
        System.out.printf("\tQue quan: %s\n", chuyenHoaKiTuDau(this.queQuan));
        System.out.printf("\tSo CCCD: %s\n", this.soCCCD);
    }

    public void hienThiDsTk() {
        System.out.printf("**Danh sach tai khoan**\n");
        this.danhSachTaiKhoan.forEach(t -> t.hienThiTk());
    }

    public void nhap1KhachHang() {
        boolean nhapNgaySinhThanhCong = false;
        System.out.print("Nhap ho ten: ");
        this.hoTen = nhapLaiKhiBoTrong();
        this.gioiTinh = "";
        System.out.print("Nhap gioi tinh(Nam/Nu): ");
        while (this.gioiTinh.trim().isEmpty() || (!this.gioiTinh.equalsIgnoreCase("nam") && !this.gioiTinh.equals("nu"))) {
            this.gioiTinh = CauHinh.sc.nextLine().trim().toLowerCase();
            if (this.gioiTinh.isEmpty() || (!this.gioiTinh.equalsIgnoreCase("nam") && !this.gioiTinh.equalsIgnoreCase("nu"))) {
                System.out.println("Gioi tinh khong hop le hoac trong vui long nhap lai: ");
            }
        }
        do {
            System.out.print("Nhap ngay sinh (dd/MM/yyyy): ");
            String ngay = CauHinh.sc.nextLine();
            try {
                this.ngaySinh = LocalDate.parse(ngay, DateTimeFormatter.ofPattern(CauHinh.DATE_PATTERN));
                nhapNgaySinhThanhCong = true;
            } catch (DateTimeParseException e) {
                System.out.println("Ngay sinh khong hop le. Vui long nhap lai.");
            }
        } while (!nhapNgaySinhThanhCong);
        System.out.print("Nhap que quan: ");
        this.queQuan = nhapLaiKhiBoTrong();
        System.out.print("Nhap so CCCD(12 so): ");
        this.soCCCD = "";
        while (this.soCCCD.length() != 12 || this.soCCCD.trim().isEmpty()) {
            this.soCCCD = CauHinh.sc.nextLine().trim();
            if (this.soCCCD.length() != 12 || this.soCCCD.trim().isEmpty()) {
                System.out.println("So CCCD dang trong hoac khong hop le vui long nhap lai: ");
            }
        }
        do {
            System.out.print("Nhap so tien gui: ");
            this.soTienGui = CauHinh.sc.nextDouble();
            if (this.soTienGui < 50000) {
                System.out.println("So tien khong hop le. Vui long nhap lai.");
            }
        } while (this.soTienGui < 50000);
        CauHinh.sc.nextLine();
        System.out.print("Nhap username cho tai khoan: ");
        this.username = CauHinh.sc.nextLine();
        TaiKhoan t = new TaiKhoanKhongKyHan(this.maSo, this.soTienGui);
        this.danhSachTaiKhoan.add(t);
    }

    public double tinhTongTienLai() {
        double tongTienLai = 0.0;
        for (TaiKhoan taiKhoan : danhSachTaiKhoan) {
            tongTienLai += taiKhoan.tinhLaiSuat();
        }
        return tongTienLai;
    }

    public void rutTienChoTaiKhoan(double st) {
        for (TaiKhoan tk : this.danhSachTaiKhoan) {
            if (tk instanceof TaiKhoanKhongKyHan) {
                tk.rutTien(st);
                soTienGui -= st;
                break;
            }
        }
    }

    public void rutTienChoTaiKhoanKyHan(KyHan kyHan) {
        Double soTienRut;
        Double soTienNap = null;
        Double soNgay;
        Double laiSuat = null;
        System.out.print("Nhap so tien can rut tai khoan: ");
        soTienRut = CauHinh.sc.nextDouble();
        boolean found = false;
        for (TaiKhoan tk : this.danhSachTaiKhoan) {
            if (tk instanceof TaiKhoanKhongKyHan taiKhoanKhongKyHan) {
                laiSuat = taiKhoanKhongKyHan.getLaiSuat();
                break;
            }
        }
        for (TaiKhoan taiKhoan : danhSachTaiKhoan) {
            if (taiKhoan instanceof TaiKhoanKyHan tk) {
                if (tk.getKyHan() == kyHan) {
                    found = true;
                    soNgay = tk.tinhSoNgayTuTaoDenRut();
                    if (LocalDate.now().isBefore(tk.getNgayDaoHan())) {
                        soTienNap = soTienRut + laiSuat * tk.getSoDu() / 100 / 365 * soNgay;
                        tk.rutTien(soTienRut);
                    } else {
                        soTienNap = soTienRut + tk.tinhLaiSuat();
                        tk.rutTien(soTienRut);
                    }
                    soTienGui -= soTienRut;
                    break;

                }
            }
        }
        if (!found) {
            System.out.println("Khong co tai khoan ky han");
        } else {
            napTienChoTaiKhoan(soTienNap);
            System.out.println("Rut tien thanh cong.");
        }
    }

    public void napTienChoTaiKhoan(double st) {
        for (TaiKhoan tk : this.danhSachTaiKhoan) {
            if (tk instanceof TaiKhoanKhongKyHan) {
                tk.napTien(st);
            }
        }
    }

    public void doiMatKhau() {
        String oldPassword;
        String newPassword;
        boolean nhapMatKhauCuThanhCong = false;
        do {
            System.out.print("Nhap mat khau cu hoac nhan Enter de huy: ");
            oldPassword = CauHinh.sc.nextLine();
            if (oldPassword.isEmpty()) {
                System.out.println("Da huy thay doi mat khau.");
                return;
            }
            if (!this.password.equals(oldPassword)) {
                System.out.println("Mat khau cu khong chinh xac. Vui long nhap lai.");
            } else {
                nhapMatKhauCuThanhCong = true;
            }
        } while (!nhapMatKhauCuThanhCong);
        do {
            System.out.print("Nhap mat khau moi: ");
            newPassword = CauHinh.sc.nextLine();
            if (newPassword.isEmpty()) {
                System.out.println("Mat khau moi khong duoc de trong. Vui long nhap lai.");
            }
        } while (newPassword.isEmpty());
        this.password = newPassword;
        System.out.println("Doi mat khau thanh cong!");
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getSoCCCD() {
        return soCCCD;
    }

    public void setSoCCCD(String soCCCD) {
        this.soCCCD = soCCCD;
    }

    public double getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui(double soTienGui) {
        this.soTienGui = soTienGui;
    }

    public List<TaiKhoan> getDanhSachTaiKhoan() {
        return danhSachTaiKhoan;
    }

    public void setDanhSachTaiKhoan(List<TaiKhoan> danhSachTaiKhoan) {
        this.danhSachTaiKhoan = danhSachTaiKhoan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }
}
