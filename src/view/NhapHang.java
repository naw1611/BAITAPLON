/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Connect.Connect;
import java.io.Console;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import quanlymaytinh.LuuMaNhanVien;
import java.sql.PreparedStatement;
import quanlymaytinh.PhieuNhap;
/**
 *
 * @author luong
 */
public class NhapHang extends javax.swing.JPanel {

    /**
     * Creates new form NhapHang
     */

    private String maNhanVien;

    // Constructor mặc định (có thể bị loại bỏ nếu không cần thiết)
       public NhapHang() throws ClassNotFoundException, SQLException {
       this.maNhanVien = LuuMaNhanVien.getInstance().getMaNhanVien();// Gán null, chỉ dùng nếu cần khởi tạo không tham số
        initComponents();
        ShowTablePhieuNhap();
        ShowTableSanPham();
        if (maNhanVien == null) {
            JOptionPane.showMessageDialog(this, "MaNhanVien không được cung cấp!");
        }
    }
    public NhapHang(String maNhanVien) throws ClassNotFoundException, SQLException {
        if (maNhanVien == null || maNhanVien.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "MaNhanVien không hợp lệ (null hoặc rỗng)!");
            this.maNhanVien = null; // Gán null để báo lỗi hoặc xử lý tiếp
        } else {
            this.maNhanVien = maNhanVien.trim(); // Lưu giá trị hợp lệ
        }
        initComponents();
        ShowTablePhieuNhap();
        ShowTableSanPham();
    }
    
    public int Dem( String name) throws ClassNotFoundException {
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
    public void ShowTableSanPham() throws ClassNotFoundException ,SQLException 
    {
        DefaultTableModel model = (DefaultTableModel) tbSanPham.getModel();
        model.setRowCount(0);
        model.setRowCount(Dem("sanpham"));
        DecimalFormat df = new DecimalFormat("#,###");
        try {
             Connect cn = new Connect();
             Statement statement = cn.con.createStatement();
             String sql = "SELECT MaSanPham, TenSanPham, TenNhaCungCap, GiaBan, SoLuongTon " +
                           "FROM sanpham "
                           + "JOIN nhacungcap  "
                           + "ON sanpham.MaNhaCungCap = nhacungcap.MaNhaCungCap  ";
             ResultSet rs = statement.executeQuery(sql);
             int i = 0;
            while (rs.next()) {                
                tbSanPham.setValueAt(rs.getString("MaSanPham"), i, 0);
                tbSanPham.setValueAt(rs.getString("TenSanPham"), i, 1);
                tbSanPham.setValueAt( df.format(rs.getDouble("GiaBan")), i, 2);
                tbSanPham.setValueAt( rs.getString("SoLuongTon"), i, 3);
                
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ShowTablePhieuNhap() throws ClassNotFoundException ,SQLException 
    {
        DefaultTableModel model = (DefaultTableModel) tbPhieuNhap.getModel();
        model.setRowCount(0);
        model.setRowCount(Dem("phieunhap"));
        DecimalFormat df = new DecimalFormat("#,###");
        try {
             Connect cn = new Connect();
             Statement statement = cn.con.createStatement();
            String sql = "SELECT pn.MaPhieuNhap, ctpn.MaSanPham, sp.TenSanPham, ctpn.SoLuong, ctpn.DonGiaNhap, ncc.TenNhaCungCap " +
             "FROM phieunhap pn " +
             "JOIN nhacungcap ncc ON pn.MaNhaCungCap = ncc.MaNhaCungCap " +
             "JOIN chitietphieunhap ctpn ON pn.MaPhieuNhap = ctpn.MaPhieuNhap " +
             "JOIN sanpham sp ON ctpn.MaSanPham = sp.MaSanPham";
           
             ResultSet rs = statement.executeQuery(sql);
             int i = 0;
            while (rs.next()) {                
                tbPhieuNhap.setValueAt(rs.getString("MaPhieuNhap"), i, 0);
                tbPhieuNhap.setValueAt(rs.getString("MaSanPham"), i, 1);
                tbPhieuNhap.setValueAt(rs.getString("TenSanPham"), i, 2);
                tbPhieuNhap.setValueAt( df.format(rs.getDouble("SoLuong")), i, 3);
                tbPhieuNhap.setValueAt(df.format(rs.getDouble("dongianhap")), i, 4);
                 tbPhieuNhap.setValueAt(rs.getString("TenNhaCungCap"), i, 5);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPhieuNhap = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaSanPham = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMaNhaCungCap = new javax.swing.JTextField();
        btnNhapHang = new javax.swing.JButton();
        txtThanhTien = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbSanPham = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Phiếu Nhập"));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Phiếu Nhập");

        tbPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Phiếu Nhập", "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Đơn Giá", "Nhà Cung Cấp"
            }
        ));
        jScrollPane1.setViewportView(tbPhieuNhap);

        jButton1.setBackground(new java.awt.Color(0, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Chi Tiết Phiếu Nhập");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(jLabel8))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(270, 270, 270))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhập Hàng"));

        jLabel2.setText("Mã Sản Phẩm");

        jLabel3.setText("Tên Sản Phẩm");

        jLabel4.setText("Số Lượng");

        jLabel5.setText("Giá ");

        jLabel6.setText("Mã Nhà Cung Cấp");

        btnNhapHang.setBackground(new java.awt.Color(0, 204, 204));
        btnNhapHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNhapHang.setForeground(new java.awt.Color(255, 255, 255));
        btnNhapHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-add-to-shopping-basket-32.png"))); // NOI18N
        btnNhapHang.setText("Nhập Hàng");
        btnNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapHangActionPerformed(evt);
            }
        });

        txtThanhTien.setEditable(false);
        txtThanhTien.setBackground(new java.awt.Color(255, 255, 255));
        txtThanhTien.setForeground(new java.awt.Color(255, 0, 0));
        txtThanhTien.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtThanhTien.setEnabled(false);

        jButton2.setBackground(new java.awt.Color(0, 204, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Thành Tiền");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tbSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Giá", "Số Lượng"
            }
        ));
        tbSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbSanPham);

        jButton3.setBackground(new java.awt.Color(0, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setText("Mã Tìm Kiếm");

        jButton4.setBackground(new java.awt.Color(0, 204, 204));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Tìm Kiếm");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1))
                            .addComponent(jLabel7)
                            .addComponent(jButton2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(btnNhapHang))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(49, 49, 49))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaSanPham)
                                    .addComponent(txtTen)
                                    .addComponent(txtSoLuong)
                                    .addComponent(txtGia)
                                    .addComponent(txtMaNhaCungCap)
                                    .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMaNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhapHang))
                .addGap(74, 74, 74))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(txtMaSanPham.getText().isEmpty() ||txtMaNhaCungCap.getText().isEmpty() ||txtTen.getText().isEmpty() ||txtGia.getText().isEmpty() ||txtSoLuong.getText().isEmpty())
        {

          JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
        }
        else
        {
           try 
          {
           double gia = Double.parseDouble(txtGia.getText());
           double soluong = Double.parseDouble(txtSoLuong.getText());
           double thanhtien = gia * soluong;
           DecimalFormat df = new DecimalFormat("#,###");
           txtThanhTien.setText(df.format(thanhtien) + " VNĐ");
          } 
          catch (NumberFormatException e) 
          {
           JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ cho Giá và Số lượng.");
          }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapHangActionPerformed
        // TODO add your handling code here:
        
      if (txtMaSanPham.getText().isEmpty() || txtMaNhaCungCap.getText().isEmpty() || 
    txtTen.getText().isEmpty() || txtGia.getText().isEmpty() || txtSoLuong.getText().isEmpty()) {

    JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");

} else {
    try { 
        Connect cn = new Connect(); 
        Statement st = cn.con.createStatement();
        boolean chekNcc = false;
        boolean checkMsp = false;
        boolean checkTen = false;
        String sql1 = "SELECT * FROM nhacungcap";
        ResultSet rs = st.executeQuery(sql1);

        while (rs.next()) {
            if (rs.getString("MaNhaCungCap").equalsIgnoreCase(txtMaNhaCungCap.getText())) {
                chekNcc = true;
                break;
            }
        }

        if (!chekNcc) {
            JOptionPane.showMessageDialog(this, "Đây là nhà cung cấp mới, hãy thêm nhà cung cấp để nhập hàng");
        } else {
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String maphieu = "PN" + (Dem("phieunhap") + 1);
            String machitiet = "CTPN" + (Dem("chitietphieunhap") + 1);
            boolean maSpDaCo = false;
            String sqlCheckSP = "SELECT * FROM sanpham WHERE MaSanPham = '" + txtMaSanPham.getText() + "'";
           rs = st.executeQuery(sqlCheckSP);
           if (rs.next()) {
            maSpDaCo = true;
           }
            System.out.println(maNhanVien);
            String sql2 = "INSERT INTO phieunhap VALUES ('" + maphieu + "', '" 
                            + txtMaNhaCungCap.getText() + "', '" + time + "', " + txtGia.getText() + ")";

            String sql3 = "INSERT INTO chitietphieunhap VALUES ('" + machitiet + "', '" 
                            + maphieu + "', '"+txtMaSanPham.getText() +"','"+maNhanVien+"' ," + txtSoLuong.getText() + ", " + txtGia.getText() + ")";

            String sql4 = "INSERT INTO sanpham VALUES ('" + txtMaSanPham.getText() + "', '" 
                            + txtTen.getText() + "', '" + txtMaNhaCungCap.getText() + "', " 
                            + txtGia.getText() + ", " + txtSoLuong.getText() + ", 'Đang Bán')";

          st.executeUpdate(sql2);
        st.executeUpdate(sql3);

        // 6. Cập nhật hoặc thêm sản phẩm
        if (maSpDaCo) {
            // Nếu đã có: cập nhật số lượng
            String sqlUpdate = "UPDATE sanpham SET SoLuongTon = SoLuongTon + " + txtSoLuong.getText()
                               + " WHERE MaSanPham = '" + txtMaSanPham.getText() + "'";
            st.executeUpdate(sqlUpdate);
        } else {
            // Nếu chưa có: thêm mới
            st.executeUpdate(sql4);
        }

        JOptionPane.showMessageDialog(this, "Nhập hàng thành công.");
        ShowTablePhieuNhap();

            JOptionPane.showMessageDialog(this, "Thêm phiếu nhập và sản phẩm thành công.");
            ShowTablePhieuNhap();
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
    }
}
    }//GEN-LAST:event_btnNhapHangActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            ShowTableSanPham();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NhapHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NhapHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamMouseClicked
        // TODO add your handling code here:
        int row = tbSanPham.getSelectedRow();
        if (row < 0) {
    JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm từ bảng!");
    return;
}
        String masp = tbSanPham.getValueAt(row, 0).toString();
        System.out.println(masp);
        try {
            DecimalFormat df = new DecimalFormat("#,###");
            Connect cn = new Connect();
           String sql = "SELECT sp.MaSanPham, sp.TenSanPham, sp.GiaNhap, sp.MaNhaCungCap " +
             "FROM sanpham sp " +
             "WHERE sp.MaSanPham = '" + masp + "'";
            Statement st = cn.con.createStatement();
            ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
        txtMaSanPham.setText(rs.getString("MaSanPham"));
        txtTen.setText(rs.getString("TenSanPham"));
        txtGia.setText(String.valueOf((long)rs.getDouble("GiaNhap")));
        txtMaNhaCungCap.setText(rs.getString("MaNhaCungCap"));// Định dạng số với dấu phân cách hàng nghìn
    } else {
        JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin cho sản phẩm: " + masp);
        txtMaSanPham.setText("");
        txtTen.setText("");
        txtGia.setText("");
    }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }//GEN-LAST:event_tbSanPhamMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
       
        try {
        String mtk = txtTimKiem.getText().trim();
        DecimalFormat df = new DecimalFormat("#,###");
        Connect cn = new Connect();

        String sql = "SELECT sp.MaSanPham, sp.TenSanPham,  sp.GiaBan,ncc.TenNhaCungCap, sp.SoLuongTon " +
                     "FROM sanpham sp " +
                     "JOIN nhacungcap ncc ON sp.MaNhaCungCap = ncc.MaNhaCungCap " +
                     "WHERE sp.MaSanPham = ?";

        PreparedStatement pst = cn.con.prepareStatement(sql);
        pst.setString(1, mtk); // tránh lỗi SQL Injection
        ResultSet rs = pst.executeQuery();

        DefaultTableModel model = (DefaultTableModel) tbSanPham.getModel();
        model.setRowCount(0); // xóa dữ liệu cũ

      while (rs.next()) {
    model.addRow(new Object[]{
        rs.getString("MaSanPham"),
        rs.getString("TenSanPham"),
        df.format(rs.getDouble("GiaBan")),
        rs.getString("SoLuongTon")
    });
}


    } catch (Exception e) {
        e.printStackTrace(); // in lỗi nếu có
        JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi tìm kiếm.");
    }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
             int index = tbPhieuNhap.getSelectedRow();
             String mpn = tbPhieuNhap.getValueAt(index,0).toString();
             PhieuNhap.getInstance().setMaPhieuNhap(mpn);
             System.out.println(PhieuNhap.getInstance().getMaPhieuNhap() );
             ChiTietNhap ct = new ChiTietNhap();
             ct.show();
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNhapHang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbPhieuNhap;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaNhaCungCap;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
