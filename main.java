package com.mycompany.btl;

import java.util.List;

public class main {

    public static void main(String[] args) {

        NganHang nh = new NganHang();
        while (true) {
            System.out.println("===== Menu =====");
            System.out.println("1. Mo tai khoan.");
            System.out.println("2. Dang nhap.");
            System.out.println("3. Tinh tien lai theo STK.");
            System.out.println("4. Tra cuu khach hang.");
            System.out.println("5. Tra cuu danh sach tai khoan cua 1 khach hang.");
            System.out.println("6. Sap xep danh sach khach hang.");
            System.out.println("7. Thoat.");
            System.out.print("Nhap lua chon: ");
            int choice = CauHinh.sc.nextInt();
            CauHinh.sc.nextLine();
            switch (choice) {
                case 1 -> {
                    KhachHang kh = new KhachHang();
                    kh.nhap1KhachHang();
                    nh.themKhachHang(kh);
                    System.out.println("Nhap phim bat ky de tiep tuc");
                    CauHinh.sc.nextLine();
                }
                case 2 -> {
                    if (!nh.getDanhSachKhachHang().isEmpty()) {
                        System.out.print("Nhap tai khoan dang nhap: ");
                        String username = CauHinh.sc.nextLine();
                        System.out.print("Nhap mat khau dang nhap: ");
                        String password = CauHinh.sc.nextLine();
                        KhachHang khachHang = nh.kiemTraDangNhap(username, password);
                        if (khachHang != null) {
                            System.out.println("Dang nhap thanh cong.");
                            System.out.println("Nhap phim bat ky de tiep tuc");
                            CauHinh.sc.nextLine();
                            boolean returnMenu = false;
                            while (!returnMenu) {
                                System.out.println("===== Menu =====");
                                System.out.println("1. Doi mat khau.");
                                System.out.println("2. Mo tai khoan ky han.");
                                System.out.println("3. Nap tien.");
                                System.out.println("4. Rut tien tai khoan khong ky han.");
                                System.out.println("5. Rut tien tai khoan ky han.");
                                System.out.println("6. Xem thong tin.");
                                System.out.println("7. Quay lai.");
                                int choice2 = CauHinh.sc.nextInt();
                                CauHinh.sc.nextLine();
                                switch (choice2) {
                                    case 1 -> {
                                        khachHang.doiMatKhau();
                                        System.out.println("Nhap phim bat ky de tiep tuc");
                                        CauHinh.sc.nextLine();
                                    }
                                    case 2 -> {
                                        boolean returnMenu2 = false;
                                        while (!returnMenu2) {
                                            System.out.println("1. Ky han MOT TUAN");
                                            System.out.println("2. Ky han MOT THANG.");
                                            System.out.println("3. Ky han SAU THANG.");
                                            System.out.println("4. Ky han MOT NAM.");
                                            System.out.println("5. Quay lai.");
                                            int choice3 = CauHinh.sc.nextInt();
                                            CauHinh.sc.nextLine();
                                            switch (choice3) {
                                                case 1 ->
                                                    khachHang.moTaiKhoanKyhan(KyHan.MOT_TUAN);
                                                case 2 ->
                                                    khachHang.moTaiKhoanKyhan(KyHan.MOT_THANG);
                                                case 3 ->
                                                    khachHang.moTaiKhoanKyhan(KyHan.SAU_THANG);
                                                case 4 ->
                                                    khachHang.moTaiKhoanKyhan(KyHan.MOT_NAM);
                                                case 5 ->
                                                    returnMenu2 = true;
                                                default ->
                                                    System.out.println("Du lieu khong hop le. Vui long nhap lai.");
                                            }
                                        }
                                    }
                                    case 3 -> {
                                        Double soTienNap;
                                        System.out.print("Nhap so tien nap vao tai khoan: ");
                                        soTienNap = CauHinh.sc.nextDouble();
                                        if (soTienNap > 0) {
                                            khachHang.napTienChoTaiKhoan(soTienNap);
                                            System.out.println("Nap thanh cong.");
                                        } else {
                                            System.out.println("So tien khong hop le.");
                                        }
                                    }
                                    case 4 -> {
                                        Double soTienRut;
                                        System.out.print("Nhap so tien can rut tai khoan: ");
                                        soTienRut = CauHinh.sc.nextDouble();
                                        if (soTienRut > 0 && soTienRut < khachHang.getSoTienGui()) {
                                            khachHang.rutTienChoTaiKhoan(soTienRut);
                                            System.out.println("Rut thanh cong");
                                        } else {
                                            System.out.println("So tien khong hop le.");
                                        }
                                    }
                                    case 5 -> {
                                        boolean returnMenu3 = false;
                                        while (!returnMenu3) {
                                            System.out.println("1. Rut tien ky han MOT TUAN");
                                            System.out.println("2. Rut tien ky han MOT THANG.");
                                            System.out.println("3. Rut tien ky han SAU THANG.");
                                            System.out.println("4. Rut tien ky han MOT NAM.");
                                            System.out.println("5. Quay lai.");
                                            int choice3 = CauHinh.sc.nextInt();
                                            CauHinh.sc.nextLine();
                                            switch (choice3) {
                                                case 1 ->
                                                    khachHang.rutTienChoTaiKhoanKyHan(KyHan.MOT_TUAN);
                                                case 2 ->
                                                    khachHang.rutTienChoTaiKhoanKyHan(KyHan.MOT_THANG);
                                                case 3 ->
                                                    khachHang.rutTienChoTaiKhoanKyHan(KyHan.SAU_THANG);
                                                case 4 ->
                                                    khachHang.rutTienChoTaiKhoanKyHan(KyHan.MOT_NAM);
                                                case 5 ->
                                                    returnMenu3 = true;
                                                default ->
                                                    System.out.println("Du lieu khong hop le. Vui long nhap lai.");
                                            }
                                        }
                                    }
                                    case 6 -> {
                                        khachHang.hienThi();
                                        khachHang.hienThiDsTk();
                                        System.out.println("Nhap phim bat ky de tiep tuc");
                                        CauHinh.sc.nextLine();
                                    }
                                    case 7 ->
                                        returnMenu = true;
                                    default ->
                                        System.out.println("Du lieu khong hop le. Vui long nhap lai.");
                                }
                            }
                        } else {
                            System.out.println("Tai khoan hoac mat khau khong chinh xac.");
                        }
                    } else {
                        System.out.println("Chua co thong tin ve khach hang.");
                    }
                }
                case 3 -> {
                    if (!nh.getDanhSachKhachHang().isEmpty()) {
                        System.out.print("Nhap ma so khach hang: ");
                        String s = CauHinh.sc.nextLine();
                        KhachHang kh = nh.timKiemTheoMaSo(s);
                        if (kh != null) {
                            System.out.printf("Tong tien lai cua tai khoan %s: %.0f\n", s, kh.tinhTongTienLai());
                        } else {
                            System.out.println("Ma so khach hang khong ton tai.");
                        }
                    } else {
                        System.out.println("Chua co thong tin ve khach hang.");
                    }
                    System.out.println("Nhap phim bat ky de tiep tuc");
                    CauHinh.sc.nextLine();
                    break;
                }
                case 4 -> {
                    if (!nh.getDanhSachKhachHang().isEmpty()) {
                        System.out.print("Nhap ho ten hoac ma so khach hang: ");
                        String s = CauHinh.sc.nextLine();
                        List<KhachHang> ketQuaTimKiem = nh.timKiemTheoTenHoacMaSo(s);
                        if (!ketQuaTimKiem.isEmpty()) {
                            for (KhachHang khachHang : ketQuaTimKiem) {
                                khachHang.hienThi();
                                System.out.println("--------------------------------------");
                            }
                        } else {
                            System.out.println("Khong tim thay khach hang.");
                        }
                    } else {
                        System.out.println("Chua co thong tin ve khach hang.");
                    }
                    System.out.println("Nhap phim bat ky de tiep tuc");
                    CauHinh.sc.nextLine();
                    break;
                }
                case 5 -> {
                    if (!nh.getDanhSachKhachHang().isEmpty()) {
                        String s1;
                        System.out.print("Nhap ma so khach hang: ");
                        s1 = CauHinh.sc.nextLine();
                        if (nh.timKiemTheoMaSo(s1) != null) {
                            nh.timKiemTheoMaSo(s1).hienThiDsTk();
                        } else {
                            System.out.println("Khong tim thay ma so khach hang.");
                        }
                    } else {
                        System.out.println("Chua co thong tin ve khach hang.");
                    }
                    System.out.println("Nhap phim bat ky de tiep tuc");
                    CauHinh.sc.nextLine();
                    break;
                }
                case 6 -> {
                    if (!nh.getDanhSachKhachHang().isEmpty()) {
                        nh.sapXepKhachHangTheoTongSoTienGui();
                        nh.hienThiDanhSachKhachHang();
                    } else {
                        System.out.println("Chua co thong tin ve khach hang.");
                    }
                    System.out.println("Nhap phim bat ky de tiep tuc");
                    CauHinh.sc.nextLine();
                    break;
                }
                case 7 -> {
                    System.out.println("Thoat thanh cong");
                    System.exit(0);
                }
                default ->
                    System.out.println("Du lieu khong hop le. Vui long nhap lai.");
            }
        }
    }
}
