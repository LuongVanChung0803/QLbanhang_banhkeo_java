/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Model.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.ResultSetMetaData;
import Interface.DataSanPham_Interface;

public class SanPhamData implements DataSanPham_Interface {
    private Connection connection;

    public SanPhamData(Connection connection) {
        this.connection = connection;
    }

    public Vector<String> getColumnNames() {
        Vector<String> columnNames = new Vector<>();
        try {
            String sql = "SELECT * FROM SanPham";
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
            String sql = "SELECT * FROM SanPham";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getInt("MaSP"));
                row.add(resultSet.getString("TenSP"));
                row.add(resultSet.getString("MoTa"));
                row.add(resultSet.getFloat("Gia"));
                row.add(resultSet.getInt("SoLuong"));
                row.add(resultSet.getInt("MaNCC"));
               
                data.add(row);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public boolean insertSanPham(SanPham sanPham) {
        try {
            String sql = "INSERT INTO SanPham (MaSP, TenSP,MoTa, Gia,SoLuong,MaNCC) VALUES (?, ?, ?, ?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, sanPham.getMaSP());
            preparedStatement.setString(2, sanPham.getTenSP());
            preparedStatement.setString(3, sanPham.getMoTa());
            preparedStatement.setFloat(4, sanPham.getGia());
            preparedStatement.setInt(5, sanPham.getSoLuong());
            preparedStatement.setInt(6, sanPham.getMaNCC());

            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateSanPham(SanPham sanPham) {
        try {
            String sql = "UPDATE SanPham SET TenSP = ?,MoTa=?, Gia = ?,SoLuong=?,MaNCC=? WHERE MaSP = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sanPham.getTenSP());
            preparedStatement.setString(2, sanPham.getMoTa());
            preparedStatement.setFloat(3, sanPham.getGia());
            preparedStatement.setInt(4, sanPham.getSoLuong());
            preparedStatement.setInt(5, sanPham.getMaNCC());
            preparedStatement.setInt(6, sanPham.getMaSP());

            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteSanPham(int MaSP) {
        try {
            String sql = "DELETE FROM SanPham WHERE MaSP = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, MaSP);

            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Vector<Vector<Object>> timSanPham(String tuKhoa) {
        Vector<Vector<Object>> data = new Vector<>();
        try {
            String sql = "SELECT * FROM SanPham WHERE TenSP LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + tuKhoa + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getInt("MaSP"));
                row.add(resultSet.getString("TenSP"));
                row.add(resultSet.getString("MoTa"));
                row.add(resultSet.getFloat("Gia"));
                row.add(resultSet.getInt("SoLuong"));
                row.add(resultSet.getInt("MaNCC"));
                
                // Add other columns as needed
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


