/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.sql.*;

/**
 *
 * @author hc
 */
public class ConnectDB  {
    public Connection getConnection() {
        Connection conn = null;
        try {
            // Đăng ký driver JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String DB_URL =  "jdbc:mysql://localhost:3306/QLBanBK1";
            String USER = "root";
            String PASS = "chung0803@";
            // Tạo kết nối đến cơ sở dữ liệu
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            if(conn!=null)
                System.out.println(" ket noi thanh cong toi mysql ");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
    }
     return conn;
   }

   
}

 