/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.HoaDon;
import java.util.Vector;

/**
 *
 * @author hc
 */
public interface DataHoaDon_Interface {
    public boolean insertHoaDon(HoaDon hoaDon);
    public boolean updateHoaDon(HoaDon hoaDon);
    public boolean deleteHoaDon(int maHoaDon);
    public Vector<String> getColumnNames();
    public Vector<Vector<Object>> getHoaDonData();
    public float tinhTongTienTheoMaHoaDon(int maHoaDon);
    public float tinhTongTienTheoThang(int year, int month);
    public Vector<HoaDon> searchHoaDonByMaHoaDon(int maHoaDon);
}
