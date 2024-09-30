/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.ChiTietHoaDon;
import java.util.Vector;

/**
 *
 * @author hc
 */
public interface DataChiTietHoaDon_Interface {
     public Vector<String> getColumnNames();
     public Vector<Vector<Object>> getData();
     public boolean insertChiTietHoaDon(ChiTietHoaDon chiTietHoaDon);
     public boolean updateChiTietHoaDon(ChiTietHoaDon chiTietHoaDon);
     public boolean deleteChiTietHoaDon(int Ma);
     public int taoMaHoaDonTuDong();
     public Vector<Vector<Object>> searchChiTietHoaDon(int maHoaDon) ;
     public boolean deleteAllChiTietHoaDon();
     public void exportToExcel(String filePath, float totalAmount);

}
