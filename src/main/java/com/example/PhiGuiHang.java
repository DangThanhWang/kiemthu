package com.example;

public class PhiGuiHang {
    public static String tinhPhiGuiHang(double trongLuong, int khoangCach, String loaiDichVu, boolean baoHiem) {
        // Kiểm tra đầu vào
        if (trongLuong <= 0 || khoangCach < 0) {
            return "Lỗi: Đầu vào không hợp lệ";
        }
        if (!loaiDichVu.equals("thường") && !loaiDichVu.equals("nhanh") && !loaiDichVu.equals("hỏa tốc")) {
            return "Lỗi: Đầu vào không hợp lệ";
        }

        // Tính phí cơ bản theo trọng lượng
        int phiCoBan;
        if (trongLuong <= 5) {
            phiCoBan = 20000;
        } else if (trongLuong <= 20) {
            phiCoBan = 40000;
        } else if (trongLuong <= 50) {
            phiCoBan = 60000;
        } else {
            phiCoBan = 80000;
        }

        // Tính phí theo khoảng cách
        int phiKhoangCach;
        if (khoangCach <= 50) {
            phiKhoangCach = 0;
        } else if (khoangCach <= 200) {
            phiKhoangCach = (int) Math.ceil((khoangCach - 50) / 50.0) * 5000;
        } else {
            phiKhoangCach = 15000 + (int) Math.ceil((khoangCach - 200) / 100.0) * 10000;
        }

        // Tính tổng phí cơ bản
        double tongPhi = phiCoBan + phiKhoangCach;

        // Áp dụng phí theo loại dịch vụ
        switch (loaiDichVu) {
            case "nhanh":
                tongPhi *= 1.3;
                break;
            case "hỏa tốc":
                tongPhi *= 1.5;
                break;
        }

        // Thêm phí bảo hiểm nếu có
        if (baoHiem) {
            tongPhi += 10000;
        }

        return String.valueOf((int) tongPhi);
    }

    public static void main(String[] args) {
        // Kiểm tra hàm
        System.out.println(tinhPhiGuiHang(10, 150, "thường", false));  // Kết quả mong đợi: 55000
        System.out.println(tinhPhiGuiHang(30, 250, "nhanh", true));  // Kết quả mong đợi: 117000
        System.out.println(tinhPhiGuiHang(0, 100, "hỏa tốc", true));  // Kết quả mong đợi: Lỗi: Trọng lượng và khoảng cách phải là số dương
    }
}
