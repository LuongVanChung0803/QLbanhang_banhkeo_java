/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.NhanVien;
import java.util.Vector;

/**
 *
 * @author hc
 */
public interface DataNhanVien_Interface {
    public Vector<String> getColumnNames();
    public Vector<Vector<Object>> getData();
    public boolean insertNhanVien(NhanVien nhanVien);
    public boolean updateNhanVien(NhanVien nhanVien);
    public boolean deleteNhanVien(int MaNV);
    public Vector<Vector<Object>> timNhanVien(String tuKhoa);
    public float tinhTongLuongNhanVien();
}
