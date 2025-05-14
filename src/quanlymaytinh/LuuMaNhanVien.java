/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlymaytinh;

/**
 *
 * @author luong
 */
public class LuuMaNhanVien {
    private static LuuMaNhanVien instance;
    private String maNhanVien;

    // Constructor private để ngăn khởi tạo từ bên ngoài
    private LuuMaNhanVien() {
    }

    // Phương thức lấy instance duy nhất
    public static LuuMaNhanVien getInstance() {
        if (instance == null) {
            instance = new LuuMaNhanVien();
        }
        return instance;
    }

    // Getter và Setter cho maNhanVien
    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    // Phương thức xóa giá trị khi đăng xuất (nếu cần)
    public void clearMaNhanVien() {
        this.maNhanVien = null;
    }
}
