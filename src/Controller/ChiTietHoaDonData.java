/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import Model.ChiTietHoaDon;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;
import Interface.DataChiTietHoaDon_Interface;

public class ChiTietHoaDonData implements DataChiTietHoaDon_Interface {
    private Connection connection;

    public ChiTietHoaDonData(Connection connection) {
        this.connection = connection;
    }

    public Vector<String> getColumnNames() {
        Vector<String> columnNames = new Vector<>();
        try {
            String sql = "SELECT * FROM ChiTietHoaDon";
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

    public Vector<Vector<Object>> getData() {
        Vector<Vector<Object>> data = new Vector<>();
        try {
            String sql = "SELECT * FROM ChiTietHoaDon";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getInt("STT"));
                row.add(resultSet.getInt("MaHD"));
                row.add(resultSet.getInt("MaSP"));
                row.add(resultSet.getString("TenSP"));
                row.add(resultSet.getInt("SoLuong"));
                row.add(resultSet.getFloat("GiaBan"));
                data.add(row);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public boolean insertChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        try {
            String sql = "INSERT INTO ChiTietHoaDon (STT ,MaHD, MaSP,TenSP, SoLuong, GiaBan) VALUES (?,?,?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setInt(1, chiTietHoaDon.getSTT());
            preparedStatement.setInt(2, chiTietHoaDon.getMaHD());
            preparedStatement.setInt(3, chiTietHoaDon.getMaSP());
            preparedStatement.setString(4, chiTietHoaDon.getTenSP());
            preparedStatement.setInt(5, chiTietHoaDon.getSoLuong());
            preparedStatement.setFloat(6, chiTietHoaDon.getGiaBan());

            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        try {
            String sql = "UPDATE ChiTietHoaDon SET  MaHD = ?,MaSP = ?, TenSP = ?, SoLuong = ?, GiaBan = ? WHERE STT = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(6, chiTietHoaDon.getSTT());
            preparedStatement.setInt(4, chiTietHoaDon.getSoLuong());
            preparedStatement.setFloat(5, chiTietHoaDon.getGiaBan());
             preparedStatement.setString(3, chiTietHoaDon.getTenSP());
            preparedStatement.setInt(1, chiTietHoaDon.getMaHD());
            preparedStatement.setInt(2, chiTietHoaDon.getMaSP());

            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteChiTietHoaDon(int Ma) {
        try {
            String sql = "DELETE FROM ChiTietHoaDon WHERE MaSP = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Ma); 
            
            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public int taoMaHoaDonTuDong() {
    int maHoaDon = 0;
    try {
        // Truy vấn cơ sở dữ liệu để tìm mã hóa đơn lớn nhất
        String sql = "SELECT MAX(MaHD) AS MaxMaHD FROM HoaDon";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            maHoaDon = resultSet.getInt("MaxMaHD");
            maHoaDon++; // Tăng mã hóa đơn lên 1 để tạo mã mới
        }

        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return maHoaDon;
}
    public Vector<Vector<Object>> searchChiTietHoaDon(int maHoaDon) {
    Vector<Vector<Object>> data = new Vector<>();
    try {
        String sql = "SELECT * FROM ChiTietHoaDon WHERE MaHD = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, maHoaDon);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Vector<Object> row = new Vector<>();
            row.add(resultSet.getInt("STT"));
            row.add(resultSet.getInt("MaHD"));
            row.add(resultSet.getInt("MaSP"));
            row.add(resultSet.getString("TenSP"));
            row.add(resultSet.getInt("SoLuong"));
            row.add(resultSet.getFloat("GiaBan"));
            data.add(row);
        }

        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return data;
}
    public boolean deleteAllChiTietHoaDon() {
    try {
        String sql = "DELETE FROM ChiTietHoaDon";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        int rowsAffected = preparedStatement.executeUpdate();
        preparedStatement.close();

        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}    

public void exportToExcel(String filePath, float totalAmount) {
    try {
        // Create a new Excel workbook and sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("HoaDon");

        // Create a header row
        Row headerRow = sheet.createRow(0);
        String[] headers = {"STT", "Mã Hóa Đơn", "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Đơn Giá"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Populate the data rows
        Vector<Vector<Object>> data = getData();
        int rowIdx = 1;
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

        // Create a row for the total amount
        Row totalRow = sheet.createRow(rowIdx);
        Cell totalLabelCell = totalRow.createCell(4);
        totalLabelCell.setCellValue("Tổng Tiền:");

        Cell totalAmountCell = totalRow.createCell(5);
        totalAmountCell.setCellValue(totalAmount);

        // Auto-size columns
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the workbook to the file
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        }

        workbook.close();

        
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error exporting data to Excel.", "Export Error", JOptionPane.ERROR_MESSAGE);
    }
}
}