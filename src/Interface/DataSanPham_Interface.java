/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.SanPham;
import java.util.Vector;

/**
 *
 * @author hc
 */
public interface DataSanPham_Interface {
    public Vector<String> getColumnNames();
    public  Vector<Vector<Object>> getData();
    public boolean insertSanPham(SanPham sanPham);
    public boolean updateSanPham(SanPham sanPham);
    public  boolean deleteSanPham(int MaSP);
    public Vector<Vector<Object>> timSanPham(String tuKhoa);
}
