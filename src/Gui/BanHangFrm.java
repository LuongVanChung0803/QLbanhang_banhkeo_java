/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Gui;

import Controller.ChiTietHoaDonData;
import Controller.ConnectDB;
import Controller.HoaDonData;
import Controller.SanPhamData;
import Model.ChiTietHoaDon;
import Model.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author hc
 */
public class BanHangFrm extends javax.swing.JPanel {
  private ConnectDB connectDB;
  private SanPhamData sanPhamData;
  private ChiTietHoaDonData chiTietHoaDonData;
  private HoaDonData hoaDonData;
  Connection conn;
  
    public BanHangFrm() {
        initComponents();
        connectDB = new ConnectDB();
        hoaDonData = new HoaDonData(connectDB.getConnection());
        sanPhamData=new SanPhamData(connectDB.getConnection());
        chiTietHoaDonData =new ChiTietHoaDonData(connectDB.getConnection());
        loadDataToTableSANPHAM();
        loadDataToTableCTHD();
        loadMaNV();
        txtMaHoaDon.setEditable(false);
        txtMaSanPham.setVisible(false);
        
        txtTenSP.setEditable(false);
        txtDonGia.setEditable(false);
        
    }
    private void loadDataToTableCTHD(){
        Vector<Vector<Object>> data = chiTietHoaDonData.getData();
        Vector<String> columnNames = chiTietHoaDonData.getColumnNames();
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table_ChiTietHoaDon.setModel(model);
        table_ChiTietHoaDon.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        @Override
        public void valueChanged(ListSelectionEvent e){
           if(table_ChiTietHoaDon.getSelectedRow() >= 0){
               txtMaHoaDon.setText(table_ChiTietHoaDon.getValueAt(table_ChiTietHoaDon.getSelectedRow(),1)+"");
               txtMaSanPham.setText(table_ChiTietHoaDon.getValueAt(table_ChiTietHoaDon.getSelectedRow(),2)+"");
              /* txtTenSP.setText(table_ChiTietHoaDon.getValueAt(table_ChiTietHoaDon.getSelectedRow(),2)+"");
               txtDonGia.setText(table_ChiTietHoaDon.getValueAt(table_ChiTietHoaDon.getSelectedRow(),4)+"");
               txtSoLuong.setText(table_ChiTietHoaDon.getValueAt(table_ChiTietHoaDon.getSelectedRow(),3)+"");*/              
         }
       }
        
    });
    }
    
    public void loadMaNV() {
    try {
        conn = connectDB.getConnection();
        String sql = "SELECT MaNV FROM NhanVien";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        cb_MaNhanVien.removeAllItems();
        while (rs.next()) {
            String maNV = rs.getString("MaNV");
            cb_MaNhanVien.addItem(maNV);
        }
        st.close();
        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
    } 
}
     private void clearTextFields() {
    txtMaHoaDon.setText("");
    txtMaSanPham.setText("");
    txtTenSP.setText("");
    txtSoLuong.setText("");
    txtDonGia.setText("");
 }
     private void clear() {
    txtMaSanPham.setText("");
    txtTenSP.setText("");
    txtSoLuong.setText("");
    txtDonGia.setText("");
 }
     private void loadDataToTableSANPHAM() {
       Vector<Vector<Object>> data = sanPhamData.getData();
       Vector<String> columnNames = sanPhamData.getColumnNames();
       DefaultTableModel model = new DefaultTableModel(data, columnNames);
       table_SanPham.setModel(model);
       table_SanPham.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        @Override
        public void valueChanged(ListSelectionEvent e){
           if(table_SanPham.getSelectedRow() >= 0){
               txtMaSanPham.setText(table_SanPham.getValueAt(table_SanPham.getSelectedRow(),0)+"");
               txtTenSP.setText(table_SanPham.getValueAt(table_SanPham.getSelectedRow(),1)+"");
               txtDonGia.setText(table_SanPham.getValueAt(table_SanPham.getSelectedRow(),3)+"");
            }
        }
    });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnKT = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnTaoHD = new javax.swing.JButton();
        txtSTT = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_SanPham = new javax.swing.JTable();
        txtTim = new javax.swing.JTextField();
        btnTim1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_ChiTietHoaDon = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnThanhToan = new javax.swing.JButton();
        btnLuuHoaDonThanhToan = new javax.swing.JButton();
        txtTongTien = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dateNgayLap = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb_MaNhanVien = new javax.swing.JComboBox<>();
        btnInHoaDon = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtMaSanPham = new javax.swing.JTextField();
        txtXoaToanBo = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 204, 255)));
        jPanel3.setForeground(new java.awt.Color(0, 51, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(555, 555));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("Mã Hóa Đơn");

        txtMaHoaDon.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtMaHoaDon.setForeground(new java.awt.Color(51, 0, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel6.setText("Số Lượng");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel7.setText("Đơn Giá");

        txtSoLuong.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtSoLuong.setForeground(new java.awt.Color(51, 0, 255));

        txtDonGia.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtDonGia.setForeground(new java.awt.Color(51, 0, 255));
        txtDonGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonGiaActionPerformed(evt);
            }
        });

        txtTenSP.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtTenSP.setForeground(new java.awt.Color(51, 0, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel10.setText("Tên Sản Phẩm");

        btnThem.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-add-30.png"))); // NOI18N
        btnThem.setText("  Thêm b or k  vào HD     ");
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnKT.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnKT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-eye-24.png"))); // NOI18N
        btnKT.setText("   Xem Chi Tiet hóa đơn  ");
        btnKT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKTMouseClicked(evt);
            }
        });

        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-update-30.png"))); // NOI18N
        btnLamMoi.setText("          Refresh            ");
        btnLamMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLamMoiMouseClicked(evt);
            }
        });

        btnTaoHD.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnTaoHD.setText("Tạo Hóa Đơn");
        btnTaoHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaoHDMouseClicked(evt);
            }
        });

        txtSTT.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtSTT.setForeground(new java.awt.Color(51, 0, 255));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel13.setText("STT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSTT, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(txtDonGia)
                            .addComponent(txtMaHoaDon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTaoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTaoHD))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel8)
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnKT, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        table_SanPham.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table_SanPham.setForeground(new java.awt.Color(51, 51, 255));
        table_SanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_SanPham.setRowHeight(40);
        table_SanPham.setShowGrid(true);
        jScrollPane1.setViewportView(table_SanPham);

        txtTim.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        txtTim.setForeground(new java.awt.Color(51, 51, 255));

        btnTim1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnTim1.setForeground(new java.awt.Color(51, 51, 255));
        btnTim1.setText("Tìm Kiếm");
        btnTim1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTim1MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 255));
        jLabel9.setText("Nhập Tên Món Ăn Cần Tìm");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTim1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(btnTim1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        table_ChiTietHoaDon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        table_ChiTietHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        table_ChiTietHoaDon.setForeground(new java.awt.Color(0, 0, 255));
        table_ChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa Đơn", "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng ", "Đơn Gía"
            }
        ));
        table_ChiTietHoaDon.setRowHeight(40);
        jScrollPane2.setViewportView(table_ChiTietHoaDon);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 204, 204));
        jLabel11.setText("List of confectionery in the invoice");

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(255, 51, 51));
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-online-payment-30.png"))); // NOI18N
        btnThanhToan.setText("Tính Tiền Hóa Đơn");
        btnThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThanhToanMouseClicked(evt);
            }
        });

        btnLuuHoaDonThanhToan.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnLuuHoaDonThanhToan.setForeground(new java.awt.Color(255, 51, 51));
        btnLuuHoaDonThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-credit-control-30.png"))); // NOI18N
        btnLuuHoaDonThanhToan.setText("Thanh Toán           ");
        btnLuuHoaDonThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLuuHoaDonThanhToanMouseClicked(evt);
            }
        });

        txtTongTien.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        txtTongTien.setForeground(new java.awt.Color(255, 51, 51));
        txtTongTien.setText(":.....................................");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("Tổng Tiền ");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("VNĐ");

        dateNgayLap.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        dateNgayLap.setForeground(new java.awt.Color(255, 51, 51));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("Ngày Lập ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Mã Nhân Viên");

        cb_MaNhanVien.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        cb_MaNhanVien.setForeground(new java.awt.Color(255, 51, 51));
        cb_MaNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_MaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_MaNhanVienActionPerformed(evt);
            }
        });

        btnInHoaDon.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnInHoaDon.setForeground(new java.awt.Color(255, 51, 51));
        btnInHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-print-30.png"))); // NOI18N
        btnInHoaDon.setText("IN HÓA ĐƠN        ");
        btnInHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInHoaDonMouseClicked(evt);
            }
        });
        btnInHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLuuHoaDonThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateNgayLap)
                            .addComponent(cb_MaNhanVien, 0, 123, Short.MAX_VALUE))
                        .addGap(181, 181, 181)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnInHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cb_MaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(btnLuuHoaDonThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Danh Sách Bánh Kẹo");

        txtXoaToanBo.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        txtXoaToanBo.setForeground(new java.awt.Color(153, 153, 255));
        txtXoaToanBo.setText(" clean all");
        txtXoaToanBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXoaToanBoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txtXoaToanBo))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(txtMaSanPham)
                        .addGap(12, 12, 12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(970, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(413, 413, 413))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtXoaToanBo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1535, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        int sTT = Integer.parseInt(txtSTT.getText());
        int maHD = Integer.parseInt(txtMaHoaDon.getText());
        int maSP = Integer.parseInt(txtMaSanPham.getText());
        String tenSP = txtTenSP.getText();
        int soluong = Integer.parseInt(txtSoLuong.getText());
        float Gia = Float.parseFloat(txtDonGia.getText());
        ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(sTT,maHD, maSP, tenSP, soluong, Gia);
        int dialogResult = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thêm sản phẩm này vào hóa đơn không?", "Xác nhận thêm sản phẩm", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            if (chiTietHoaDonData.insertChiTietHoaDon(chiTietHoaDon)) {
            JOptionPane.showMessageDialog(this, "Thêm vào thành công.");
            loadDataToTableCTHD();
            clear();   
        } else {
               JOptionPane.showMessageDialog(this, "Thêm vào thất bại.");
        }
        } else {
         clearTextFields();
}
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnKTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKTMouseClicked
     ChiTietHoaDonFrm runFrm = new ChiTietHoaDonFrm();
     runFrm.setVisible(true);
    }//GEN-LAST:event_btnKTMouseClicked

    private void btnLamMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLamMoiMouseClicked
         clearTextFields();
         loadDataToTableCTHD();
    }//GEN-LAST:event_btnLamMoiMouseClicked

    private void btnThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThanhToanMouseClicked

    String selectedMaHoaDon = txtMaHoaDon.getText();
    if (selectedMaHoaDon.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn mã hóa đơn cần thanh toán. ");
        return;
    }
    String ngayLap = dateNgayLap.getText();
    if (ngayLap.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày lập hóa đơn.");
        return;
    }
    int maHoaDon = Integer.parseInt(selectedMaHoaDon);
    float tongTien = hoaDonData.tinhTongTienTheoMaHoaDon(maHoaDon);
    JOptionPane.showMessageDialog(this, "Tổng tiền của Hóa Đơn có Mã " + maHoaDon + " là: " + tongTien + " VNĐ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    txtTongTien.setText(String.valueOf(tongTien));
    }//GEN-LAST:event_btnThanhToanMouseClicked

    private void btnTaoHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaoHDMouseClicked
        int maHoaDon = chiTietHoaDonData.taoMaHoaDonTuDong();
        txtMaHoaDon.setText(String.valueOf(maHoaDon));
    }//GEN-LAST:event_btnTaoHDMouseClicked

    private void btnLuuHoaDonThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuHoaDonThanhToanMouseClicked
        // TODO add your handling code here:
        int maHD = Integer.parseInt(txtMaHoaDon.getText());
        int maNV = Integer.parseInt(cb_MaNhanVien.getSelectedItem().toString());
         String ngayLapStr = dateNgayLap.getText();  
        float tongTien = Float.parseFloat(txtTongTien.getText()); 
        java.util.Date ngayLapUtil = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
        ngayLapUtil = dateFormat.parse(ngayLapStr);
        } catch (ParseException ex) {
        JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ. Vui lòng nhập ngày theo định dạng dd/MM/yyyy Để Thanh Toán");
        return;
} 
        java.sql.Date ngayLap = new java.sql.Date(ngayLapUtil.getTime());
        HoaDon hoaDon = new HoaDon(maHD, maNV,ngayLap,tongTien);
        int dialogResult = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thanh toán hóa đơn này không?", "Xác nhận Thanh Toán", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            if (hoaDonData.insertHoaDon(hoaDon)) {
            JOptionPane.showMessageDialog(this, "Thanh toán thành công.");
            loadDataToTableCTHD();
        } else {
               JOptionPane.showMessageDialog(this, "Hóa Đơn Này Đã Thanh Toán.");
        }
        } else {
         clearTextFields();
     }    
    }//GEN-LAST:event_btnLuuHoaDonThanhToanMouseClicked

    private void btnInHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInHoaDonMouseClicked
     InHoaDonFrm runFrm = new InHoaDonFrm();
     runFrm.setVisible(true);
    }//GEN-LAST:event_btnInHoaDonMouseClicked

    private void cb_MaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_MaNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_MaNhanVienActionPerformed

    private void btnInHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInHoaDonActionPerformed

    private void txtXoaToanBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXoaToanBoActionPerformed
        // TODO add your handling code here:
                int choice = JOptionPane.showConfirmDialog(
                        null,
                        "Bạn có chắc chắn muốn làm mới toàn bộ danh sách mua hàng?",
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION);

                if (choice == JOptionPane.YES_OPTION) {
                    chiTietHoaDonData.deleteAllChiTietHoaDon();
                    loadDataToTableCTHD();
                    JOptionPane.showMessageDialog(null, "Đã làm mới toàn bộ dữ liệu.");
                }
    }//GEN-LAST:event_txtXoaToanBoActionPerformed

    private void txtDonGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDonGiaActionPerformed

    private void btnTim1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTim1MouseClicked
    String tuKhoa = txtTim.getText();
    Vector<Vector<Object>> data = sanPhamData.timSanPham(tuKhoa);

    if (!data.isEmpty()) {
        // Cập nhật dữ liệu cho bảng
        DefaultTableModel model = (DefaultTableModel) table_SanPham.getModel();
        model.setRowCount(0); // Xóa tất cả dòng trong bảng

        for (Vector<Object> row : data) {
            model.addRow(row); // Thêm từng dòng tìm được vào bảng
        }
    } else {
        JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả nào.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_btnTim1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInHoaDon;
    private javax.swing.JButton btnKT;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLuuHoaDonThanhToan;
    private javax.swing.JButton btnTaoHD;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim1;
    private javax.swing.JComboBox<String> cb_MaNhanVien;
    private javax.swing.JTextField dateNgayLap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_ChiTietHoaDon;
    private javax.swing.JTable table_SanPham;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextField txtSTT;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTim;
    private javax.swing.JLabel txtTongTien;
    private javax.swing.JButton txtXoaToanBo;
    // End of variables declaration//GEN-END:variables
}
