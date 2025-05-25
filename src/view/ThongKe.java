/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Connect.Connect;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import  java.sql.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ThongKe extends javax.swing.JPanel {

    /**
     * Creates new form ThongKe
     */
    public ThongKe() {
        initComponents();
        ngaybatdau.setDate(new java.util.Date()); // Ngày hiện tại
        ngayketthuc.setDate(new java.util.Date());
        thongkesanpham();
        thongkeTheoNgay();
    }
     public int Dem(String name) throws ClassNotFoundException {
        int dem = 0;
        try {
            Connect pt = new Connect();
            ResultSet rs = pt.GetData(name);
            while (rs.next()) {
                dem++;//Đếm số dòng trong table Products
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return dem;
    }
    public void thongkesanpham()
    {
         try {
             Connect cn = new Connect();
             Statement statement = cn.con.createStatement();
             String tong ="";
             String sql = "SELECT SUM(SoLuongTon) AS TongSoLuongTon FROM SanPham";
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
             tong = rs.getString("TongSoLuongTon");
             }
            
            txtSoLuongSanPham.setText(tong);
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void thongkenhacungcap()
    {
         try {
             Connect cn = new Connect();
             Statement statement = cn.con.createStatement();
             String tong ="";
             String sql = "SELECT SUM(SoLuongTon) AS TongSoLuongTon FROM SanPham";
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
             tong = rs.getString("TongSoLuongTon");
             }
            
            txtSoLuongBan.setText(tong);
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void thongkeTheoNgay() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate =    ngaybatdau.getDate();
            Date endDate =     ngayketthuc.getDate();
            
            System.out.println("ngay bat dau");
            System.out.println(startDate);
            if (startDate == null || endDate == null) {
                return; // Nếu chưa chọn đủ ngày, không thực hiện thống kê
            }

            String startDateStr = sdf.format(startDate);
            String endDateStr = sdf.format(endDate);

            Connect cn = new Connect();
            Statement statement = cn.con.createStatement();

            // Thống kê doanh thu theo ngày
            String sqlDoanhThu = "SELECT SUM(TongDoanhThu) AS DoanhThu FROM BaoCao WHERE NgayBaoCao BETWEEN ? AND ?";
            PreparedStatement psDoanhThu = cn.con.prepareStatement(sqlDoanhThu);
            psDoanhThu.setString(1, startDateStr);
            psDoanhThu.setString(2, endDateStr);
            ResultSet rsDoanhThu = psDoanhThu.executeQuery();
            DecimalFormat df = new DecimalFormat("#,###"); // Định dạng số đầy đủ, thêm dấu phẩy
           if (rsDoanhThu.next()) {
               java.math.BigDecimal doanhThu = rsDoanhThu.getBigDecimal("DoanhThu");
             txtDoanhThu.setText(doanhThu != null ? df.format(doanhThu) : "0");
           } else {
        txtDoanhThu.setText("0");
           }

            // Thống kê số lượng bán theo ngày
            String sqlBan = "SELECT SUM(SoLuong) AS TongSoLuongBan "
             + "FROM ChiTietHoaDon cthd "
             + "JOIN HoaDon hd "
             + "ON cthd.MaHoaDon = hd.MaHoaDon "
             + "WHERE hd.NgayLapHoaDon BETWEEN ? AND ?";
            PreparedStatement psBan = cn.con.prepareStatement(sqlBan);
            psBan.setString(1, startDateStr);
            psBan.setString(2, endDateStr);
            ResultSet rsBan = psBan.executeQuery();
            if (rsBan.next()) {
                String tongBan = rsBan.getString("TongSoLuongBan");
                txtSoLuongBan.setText(tongBan != null ? tongBan : "0"); 
            }

            // Thống kê số lượng nhập theo ngày
            String sqlNhap = "SELECT SUM(SoLuong) AS TongSoLuongNhap "
             + "FROM ChiTietPhieuNhap ctpn "
             + "Join PhieuNhap pn "
             + " ON ctpn.maphieunhap = pn.maphieunhap"
             + " WHERE pn.NgayNhap BETWEEN ? AND ?";
            PreparedStatement psNhap = cn.con.prepareStatement(sqlNhap);
            psNhap.setString(1, startDateStr);
            psNhap.setString(2, endDateStr);
            ResultSet rsNhap = psNhap.executeQuery();
            if (rsNhap.next()) {
                String tongNhap = rsNhap.getString("TongSoLuongNhap");
                txtSoLuongNhap.setText(tongNhap != null ? tongNhap : "0");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel13 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtSoLuongKhachHang2 = new javax.swing.JLabel();
        txtThongKeKhachHang2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtSoLuongKhachHang4 = new javax.swing.JLabel();
        txtThongKeKhachHang4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        txtSoLuongSanPham = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtSoLuongBan = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtSoLuongNhap = new javax.swing.JLabel();
        txt = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtDoanhThu = new javax.swing.JLabel();
        txtThongKeNhaCungCap1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        ngaybatdau = new com.toedter.calendar.JDateChooser();
        ngayketthuc = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnResetThongKePr = new javax.swing.JButton();
        btnResetThongKePr1 = new javax.swing.JButton();

        jPanel13.setBackground(new java.awt.Color(0, 204, 204));

        txtSoLuongKhachHang2.setFont(new java.awt.Font("SF Pro Display", 1, 36)); // NOI18N
        txtSoLuongKhachHang2.setForeground(new java.awt.Color(255, 255, 255));
        txtSoLuongKhachHang2.setText("100");

        txtThongKeKhachHang2.setFont(new java.awt.Font("SF Pro Display", 0, 18)); // NOI18N
        txtThongKeKhachHang2.setForeground(new java.awt.Color(255, 255, 255));
        txtThongKeKhachHang2.setText("Sản Phẩm Đã Bán");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-sell-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoLuongKhachHang2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtThongKeKhachHang2))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuongKhachHang2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtThongKeKhachHang2))
                    .addComponent(jLabel5))
                .addGap(55, 55, 55))
        );

        jPanel15.setBackground(new java.awt.Color(0, 204, 204));

        txtSoLuongKhachHang4.setFont(new java.awt.Font("SF Pro Display", 1, 36)); // NOI18N
        txtSoLuongKhachHang4.setForeground(new java.awt.Color(255, 255, 255));
        txtSoLuongKhachHang4.setText("100");

        txtThongKeKhachHang4.setFont(new java.awt.Font("SF Pro Display", 0, 18)); // NOI18N
        txtThongKeKhachHang4.setForeground(new java.awt.Color(255, 255, 255));
        txtThongKeKhachHang4.setText("Sản Phẩm Đã Bán");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-sell-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoLuongKhachHang4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txtThongKeKhachHang4))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuongKhachHang4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtThongKeKhachHang4))
                    .addComponent(jLabel7))
                .addGap(55, 55, 55))
        );

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Thống Kê"));

        jPanel9.setBackground(new java.awt.Color(255, 204, 0));

        txtSoLuongSanPham.setFont(new java.awt.Font("SF Pro Display", 1, 24)); // NOI18N
        txtSoLuongSanPham.setForeground(new java.awt.Color(255, 255, 255));
        txtSoLuongSanPham.setText("100");

        jLabel10.setFont(new java.awt.Font("SF Pro Display", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Sản phẩm trong kho");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-product-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel12))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtSoLuongSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(64, 64, 64))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(txtSoLuongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addGap(81, 81, 81))))
        );

        jPanel10.setBackground(new java.awt.Color(255, 102, 0));

        txtSoLuongBan.setFont(new java.awt.Font("SF Pro Display", 1, 24)); // NOI18N
        txtSoLuongBan.setForeground(new java.awt.Color(255, 255, 255));
        txtSoLuongBan.setText("100");

        txtSoLuong.setFont(new java.awt.Font("SF Pro Display", 0, 18)); // NOI18N
        txtSoLuong.setForeground(new java.awt.Color(255, 255, 255));
        txtSoLuong.setText("Số Lượng Bán");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-sell-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel13))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuongBan, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(txtSoLuongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSoLuong))
                    .addComponent(jLabel1))
                .addGap(68, 68, 68))
        );

        jPanel11.setBackground(new java.awt.Color(0, 204, 204));

        txtSoLuongNhap.setFont(new java.awt.Font("SF Pro Display", 1, 24)); // NOI18N
        txtSoLuongNhap.setForeground(new java.awt.Color(255, 255, 255));
        txtSoLuongNhap.setText("100");

        txt.setFont(new java.awt.Font("SF Pro Display", 0, 18)); // NOI18N
        txt.setForeground(new java.awt.Color(255, 255, 255));
        txt.setText("Số Lượng Nhập");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-buy-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(txt)
                        .addGap(0, 87, Short.MAX_VALUE))
                    .addComponent(txtSoLuongNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel15)
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(txtSoLuongNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(txt))
                    .addComponent(jLabel3))
                .addGap(85, 85, 85))
        );

        jPanel12.setBackground(new java.awt.Color(0, 204, 102));

        txtDoanhThu.setFont(new java.awt.Font("SF Pro Display", 1, 24)); // NOI18N
        txtDoanhThu.setForeground(new java.awt.Color(255, 255, 255));
        txtDoanhThu.setText("100");

        txtThongKeNhaCungCap1.setFont(new java.awt.Font("SF Pro Display", 0, 18)); // NOI18N
        txtThongKeNhaCungCap1.setForeground(new java.awt.Color(255, 255, 255));
        txtThongKeNhaCungCap1.setText("Doanh Thu");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-money-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel14))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtThongKeNhaCungCap1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(txtDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtThongKeNhaCungCap1))
                    .addComponent(jLabel4))
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc theo ngày"));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ngaybatdau.setBackground(new java.awt.Color(255, 255, 255));
        ngaybatdau.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ngaybatdauPropertyChange(evt);
            }
        });
        ngaybatdau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ngaybatdauKeyReleased(evt);
            }
        });
        jPanel17.add(ngaybatdau, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 170, -1));

        ngayketthuc.setBackground(new java.awt.Color(255, 255, 255));
        ngayketthuc.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ngayketthucPropertyChange(evt);
            }
        });
        ngayketthuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ngayketthucKeyReleased(evt);
            }
        });
        jPanel17.add(ngayketthuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 170, -1));

        jLabel9.setText("Đến");
        jPanel17.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 40, 20));

        jLabel11.setText("Từ");
        jPanel17.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 20, 20));

        btnResetThongKePr.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnResetThongKePr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-analytics-32.png"))); // NOI18N
        btnResetThongKePr.setText("Thống Kê");
        btnResetThongKePr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetThongKePrActionPerformed(evt);
            }
        });
        jPanel17.add(btnResetThongKePr, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 140, 40));

        btnResetThongKePr1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnResetThongKePr1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-reset-32.png"))); // NOI18N
        btnResetThongKePr1.setText("Làm mới");
        btnResetThongKePr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetThongKePr1ActionPerformed(evt);
            }
        });
        jPanel17.add(btnResetThongKePr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 30, 140, 40));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 88, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jDateChooserFromPr1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserFromPr1PropertyChange
        
    }//GEN-LAST:event_jDateChooserFromPr1PropertyChange

    private void jDateChooserFromPr1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserFromPr1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooserFromPr1KeyReleased

    private void ngaybatdauPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ngaybatdauPropertyChange
        
        
    }//GEN-LAST:event_ngaybatdauPropertyChange

    private void ngaybatdauKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ngaybatdauKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ngaybatdauKeyReleased

    private void ngayketthucPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ngayketthucPropertyChange
      
    }//GEN-LAST:event_ngayketthucPropertyChange

    private void ngayketthucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ngayketthucKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ngayketthucKeyReleased

    private void btnResetThongKePrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetThongKePrActionPerformed
         // TODO add your handling code here:
        thongkeTheoNgay();
        ngaybatdau.setCalendar(null);
        ngayketthuc.setCalendar(null);
        
        
    }//GEN-LAST:event_btnResetThongKePrActionPerformed

    private void btnResetThongKePr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetThongKePr1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetThongKePr1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnResetThongKePr;
    private javax.swing.JButton btnResetThongKePr1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private com.toedter.calendar.JDateChooser ngaybatdau;
    private com.toedter.calendar.JDateChooser ngayketthuc;
    private javax.swing.JLabel txt;
    private javax.swing.JLabel txtDoanhThu;
    private javax.swing.JLabel txtSoLuong;
    private javax.swing.JLabel txtSoLuongBan;
    private javax.swing.JLabel txtSoLuongKhachHang2;
    private javax.swing.JLabel txtSoLuongKhachHang4;
    private javax.swing.JLabel txtSoLuongNhap;
    private javax.swing.JLabel txtSoLuongSanPham;
    private javax.swing.JLabel txtThongKeKhachHang2;
    private javax.swing.JLabel txtThongKeKhachHang4;
    private javax.swing.JLabel txtThongKeNhaCungCap1;
    // End of variables declaration//GEN-END:variables

  
}
