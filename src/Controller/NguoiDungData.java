/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.NguoiDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Interface.DataNguoiDung_Interface;

public class NguoiDungData implements DataNguoiDung_Interface  {
    // Đối tượng kết nối đến cơ sở dữ liệu
    private Connection connection;
    
    public NguoiDungData() {
        // Khởi tạo kết nối đến cơ sở dữ liệu
        ConnectDB connectDB = new ConnectDB();
        connection = connectDB.getConnection();
    }
    
    // Phương thức kiểm tra đăng nhập
    public boolean kiemTraDangNhap(String taiKhoan, String matKhau) {
        try {
            // Tạo truy vấn SQL để kiểm tra đăng nhập
            String sql = "SELECT * FROM NguoiDung WHERE TaiKhoan = ? AND MatKhau = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, taiKhoan);
            preparedStatement.setString(2, matKhau);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            // Nếu có bất kỳ dòng dữ liệu nào trả về từ cơ sở dữ liệu, đăng nhập thành công
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

