/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.NhaCungCap;
import java.util.Vector;

/**
 *
 * @author hc
 */
public interface DataNhaCungCap_Interface {
     public Vector<String> getColumnNames();
     public Vector<Vector<Object>> getData();
     public boolean insertNhaCungCap(NhaCungCap nhaCungCap);
     public boolean updateNhaCungCap(NhaCungCap nhaCungCap);
     public boolean deleteNhaCungCap(int MaNCC);
     public Vector<Vector<Object>> timNhaCungCap(String tuKhoa);
}
