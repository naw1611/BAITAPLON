/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlymaytinh;

/**
 *
 * @author luong
 */
public class PhieuXuat {
    private static PhieuXuat instance;
    private String maPhieuXuat;
    private PhieuXuat() {
    }
    public static PhieuXuat getInstance() {
        if (instance == null) {
            instance = new PhieuXuat();
        }
        return instance;
    }

    public String getMaPhieuXuat() {
        return maPhieuXuat;
    }
    public void setMaPhieuNhap(String maPhieuXuat) {
        this.maPhieuXuat = maPhieuXuat;
    }
}
