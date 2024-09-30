/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;
import Interface.DataNhanVien_Interface;

public class NhanVienData implements DataNhanVien_Interface{
    private Connection connection;

    public NhanVienData(Connection connection) {
        this.connection = connection;
    }

    public Vector<String> getColumnNames() {
        Vector<String> columnNames = new Vector<>();
        try {
            String sql = "SELECT * FROM NhanVien";
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
            String sql = "SELECT * FROM NhanVien";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getInt("MaNV"));
                row.add(resultSet.getString("TenNV"));
                row.add(resultSet.getString("DiaChi"));
                row.add(resultSet.getString("Luong"));
                row.add(resultSet.getString("Email"));
                row.add(resultSet.getDate("NgaySinh"));
                row.add(resultSet.getString("GioiTinh"));
                row.add(resultSet.getString("ChucVu"));
                data.add(row);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public boolean insertNhanVien(NhanVien nhanVien) {
        try {
            String sql = "INSERT INTO NhanVien (MaNV, TenNV, DiaChi,Luong, Email, NgaySinh, GioiTinh, ChucVu) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, nhanVien.getMaNV());
            preparedStatement.setString(2, nhanVien.getTenNV());
            preparedStatement.setString(3, nhanVien.getDiaChi());
            preparedStatement.setFloat(4, nhanVien.getLuong());
            preparedStatement.setString(5, nhanVien.getEmail());
            preparedStatement.setDate(6, new java.sql.Date(nhanVien.getNgaySinh().getTime()));
            preparedStatement.setString(7, nhanVien.getGioiTinh());
            preparedStatement.setString(8, nhanVien.getChucVu());

            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateNhanVien(NhanVien nhanVien) {
        try {
            String sql = "UPDATE NhanVien SET TenNV = ?, DiaChi = ?, Luong = ?, Email = ?, NgaySinh = ?, GioiTinh = ?, ChucVu = ? WHERE MaNV = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nhanVien.getTenNV());
            preparedStatement.setString(2, nhanVien.getDiaChi());
            preparedStatement.setFloat(3, nhanVien.getLuong());
            preparedStatement.setString(4, nhanVien.getEmail());
            preparedStatement.setDate(5, new java.sql.Date(nhanVien.getNgaySinh().getTime()));
            preparedStatement.setString(6, nhanVien.getGioiTinh());
            preparedStatement.setString(7, nhanVien.getChucVu());
            preparedStatement.setInt(8, nhanVien.getMaNV());

            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteNhanVien(int MaNV) {
        try {
            String sql = "DELETE FROM NhanVien WHERE MaNV = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, MaNV);

            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Vector<Vector<Object>> timNhanVien(String tuKhoa) {
        Vector<Vector<Object>> data = new Vector<>();
        try {
            String sql = "SELECT * FROM NhanVien WHERE TenNV LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + tuKhoa + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getInt("MaNV"));
                row.add(resultSet.getString("TenNV"));
                row.add(resultSet.getString("DiaChi"));
                row.add(resultSet.getString("Luong"));
                row.add(resultSet.getString("Email"));
                row.add(resultSet.getDate("NgaySinh"));
                row.add(resultSet.getString("GioiTinh"));
                row.add(resultSet.getString("ChucVu"));
                data.add(row);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
    public float tinhTongLuongNhanVien() {
    float tongLuong = 0.0f;
    try {
        String sql = "SELECT SUM(Luong) AS TongLuong FROM NhanVien";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            tongLuong = resultSet.getFloat("TongLuong");
        }

        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return tongLuong;
}

}




