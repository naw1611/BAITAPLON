/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlymaytinh;

/**
 *
 * @author luong
 */
public class HoaDon {
    private static HoaDon instance;
    private String maHoaDon;
    private HoaDon() {
    }
    public static HoaDon getInstance() {
        if (instance == null) {
            instance = new HoaDon();
        }
        return instance;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }
    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }
}
