/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlymaytinh;

/**
 *
 * @author luong
 */
public class PhieuNhap {
    private static PhieuNhap instance;
    private String maPhieuNhap;
    private PhieuNhap() {
    }
    public static PhieuNhap getInstance() {
        if (instance == null) {
            instance = new PhieuNhap();
        }
        return instance;
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }
    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

}
