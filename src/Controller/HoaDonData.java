/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author hc
 */


import Model.HoaDon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import Interface.DataHoaDon_Interface;
import java.awt.List;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HoaDonData implements DataHoaDon_Interface{
    private Connection connection;

    public HoaDonData(Connection connection) {
        this.connection = connection;
    }
    
    public boolean insertHoaDon(HoaDon hoaDon) {
       try {
            String sql = "INSERT INTO HoaDon (MaHD, MaNV, NgayLap, TongTien) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, hoaDon.getMaHD());
            preparedStatement.setInt(2, hoaDon.getMaNV());
            preparedStatement.setDate(3, (Date) hoaDon.getNgayLap()); // Supposing NgayLap is of type java.sql.Date
            preparedStatement.setDouble(4, hoaDon.getTongTien());
            
            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateHoaDon(HoaDon hoaDon) {
    try {
        String sql = "UPDATE HoaDon SET MaNV = ?, NgayLap = ?, TongTien = ? WHERE MaHD = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, hoaDon.getMaNV());
        preparedStatement.setDate(2, (Date) hoaDon.getNgayLap()); // Supposing NgayLap is of type java.sql.Date
        preparedStatement.setFloat(3, hoaDon.getTongTien());
        preparedStatement.setInt(4, hoaDon.getMaHD());
        
        int rowsAffected = preparedStatement.executeUpdate();
        preparedStatement.close();
        
        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}


    public boolean deleteHoaDon(int maHoaDon) {
        try {
            String sql = "DELETE FROM HoaDon WHERE MaHD = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, maHoaDon);
            
            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
     public Vector<String> getColumnNames() {
        Vector<String> columnNames = new Vector<>();
        try {
            String sql = "SELECT * FROM HoaDon";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                columnNames.add(columnName);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columnNames;
    }

    public Vector<Vector<Object>> getHoaDonData() {
        Vector<Vector<Object>> data = new Vector<>();
        try {
            String sql = "SELECT * FROM HoaDon";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getInt("MaHD"));
                row.add(resultSet.getInt("MaNV"));
                row.add(resultSet.getDate("NgayLap")); // Supposing NgayLap is of type java.sql.Date
                row.add(resultSet.getDouble("TongTien"));
                data.add(row);
            }
            
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
    public float tinhTongTienTheoMaHoaDon(int maHoaDon) {
    
    float tongTien = 0.0f;
    try {
        // Truy vấn dữ liệu từ bảng ChiTietHoaDon
        String sql = "SELECT MaSP, SoLuong, GiaBan FROM ChiTietHoaDon WHERE MaHD = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, maHoaDon);
        ResultSet resultSet = preparedStatement.executeQuery();

        // Tính tổng tiền dựa trên dữ liệu từ bảng ChiTietHoaDon
        while (resultSet.next()) {
            int maSanPham = resultSet.getInt("MaSP");
            int soLuong = resultSet.getInt("SoLuong");
            float giaBan = resultSet.getFloat("GiaBan");
            float giaTriSanPham = soLuong * giaBan;
            tongTien += giaTriSanPham;
        }

        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return tongTien;
}
    public float tinhTongTienTheoThang(int year, int month) {
    float tongTien = 0.0f;
    try {
        // Truy vấn dữ liệu từ bảng HoaDon
        String sql = "SELECT TongTien FROM HoaDon WHERE YEAR(NgayLap) = ? AND MONTH(NgayLap) = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, year);
        preparedStatement.setInt(2, month);
        ResultSet resultSet = preparedStatement.executeQuery();

        // Tính tổng tiền dựa trên dữ liệu từ bảng HoaDon
        while (resultSet.next()) {
            float giaTriHoaDon = resultSet.getFloat("TongTien");
            tongTien += giaTriHoaDon;
        }

        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return tongTien;
}
   public Vector<HoaDon> searchHoaDonByMaHoaDon(int maHoaDon) {
    Vector<HoaDon> danhSachHoaDon = new Vector<>();
    try {
        String sql = "SELECT * FROM HoaDon WHERE MaHD = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, maHoaDon);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            HoaDon hoaDon = new HoaDon();
            hoaDon.setMaHD(resultSet.getInt("MaHD"));
            hoaDon.setMaNV(resultSet.getInt("MaNV"));
            hoaDon.setNgayLap(resultSet.getDate("NgayLap"));
            hoaDon.setTongTien((float) resultSet.getDouble("TongTien"));
            danhSachHoaDon.add(hoaDon);
        }

        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return danhSachHoaDon;
}
  
public void exportToExcel(String filePath, float doanhThuThang, float luongNhanVien, DefaultTableModel tableModel) {
    try {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("BaoCao");

        // Add total revenue and total employee salary to the Excel file
        Row totalRevenueRow = sheet.createRow(0);
        totalRevenueRow.createCell(0).setCellValue("Tổng Doanh Thu Tháng");
        totalRevenueRow.createCell(1).setCellValue(doanhThuThang);
        Row totalSalaryRow = sheet.createRow(1);
        totalSalaryRow.createCell(0).setCellValue("Tổng Lương Nhân Viên");
        totalSalaryRow.createCell(1).setCellValue(luongNhanVien);
        Row Row2 = sheet.createRow(2);
        Row2.createCell(0).setCellValue("Lịch Sử Giao Dịch");
        // Create headers for the HoaDon table
        Row headerRow = sheet.createRow(3);
        String[] headers = {"Mã Hóa Đơn", "Tên Nhân Viên", "Ngày Lập", "Tổng Tiền"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Populate HoaDon table data
        Vector<Vector<Object>> data = getHoaDonData();
        int rowIdx = 4; // Start from the 5th row
        for (Vector<Object> rowData : data) {
            Row row = sheet.createRow(rowIdx++);
            int colIdx = 0;
            for (Object value : rowData) {
                Cell cell = row.createCell(colIdx++);
                if (value instanceof Integer) {
                    cell.setCellValue((Integer) value);
                } else if (value instanceof Float) {
                    cell.setCellValue((Float) value);
                } else {
                    cell.setCellValue(value.toString());
                }
            }
        }

        // Auto-size columns
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Save the Excel report to the specified file path
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}


}