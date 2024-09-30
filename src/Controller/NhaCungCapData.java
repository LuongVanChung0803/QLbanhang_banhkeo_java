package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Model.NhaCungCap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.ResultSetMetaData;
import Interface.DataNhaCungCap_Interface;

public class NhaCungCapData implements DataNhaCungCap_Interface{
    private Connection connection;

    public NhaCungCapData(Connection connection) {
        this.connection = connection;
    }
    public Vector<String> getColumnNames() {
        Vector<String> columnNames = new Vector<>();
        try {
            String sql = "SELECT * FROM NhaCungCap";
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
            String sql = "SELECT * FROM NhaCungCap";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getInt("MaNCC"));
                row.add(resultSet.getString("TenNCC"));
                row.add(resultSet.getString("DiaChi"));
                row.add(resultSet.getString("DienThoai"));
                row.add(resultSet.getString("Email"));
                data.add(row);
            }
            
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public boolean insertNhaCungCap(NhaCungCap nhaCungCap) {
        try {
            String sql = "INSERT INTO NhaCungCap (MaNCC, TenNCC, DiaChi, DienThoai, Email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, nhaCungCap.getMaNCC());
            preparedStatement.setString(2, nhaCungCap.getTenNCC());
            preparedStatement.setString(3, nhaCungCap.getDiaChi());
            preparedStatement.setString(4, nhaCungCap.getDienThoai());
            preparedStatement.setString(5, nhaCungCap.getEmail());
            
            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateNhaCungCap(NhaCungCap nhaCungCap) {
        try {
            String sql = "UPDATE NhaCungCap SET TenNCC = ?, DiaChi = ?, DienThoai = ?, Email = ? WHERE MaNCC = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nhaCungCap.getTenNCC());
            preparedStatement.setString(2, nhaCungCap.getDiaChi());
            preparedStatement.setString(3, nhaCungCap.getDienThoai());
            preparedStatement.setString(4, nhaCungCap.getEmail());
            preparedStatement.setInt(5, nhaCungCap.getMaNCC());
            
            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteNhaCungCap(int MaNCC) {
        try {
            String sql = "DELETE FROM NhaCungCap WHERE MaNCC = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, MaNCC);
            
            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public Vector<Vector<Object>> timNhaCungCap(String tuKhoa) {
    Vector<Vector<Object>> data = new Vector<>();
    try {
        String sql = "SELECT * FROM NhaCungCap WHERE TenNCC LIKE ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "%" + tuKhoa + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
        
        while (resultSet.next()) {
            Vector<Object> row = new Vector<>();
            row.add(resultSet.getInt("MaNCC"));
            row.add(resultSet.getString("TenNCC"));
            row.add(resultSet.getString("DiaChi"));
            row.add(resultSet.getString("DienThoai"));
            row.add(resultSet.getString("Email"));
            data.add(row);
        }
        
        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return data;
}
}
