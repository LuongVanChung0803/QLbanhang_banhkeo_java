/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hc
 */
public class ChiTietHoaDon  {
     private int STT;
    private int MaHD;
    private int MaSP;
    private String TenSP;
    private int SoLuong;
   
    private float GiaBan;

    public ChiTietHoaDon() { 
    }

    
    

    // Constructor để khởi tạo đối tượng ChiTietHoaDon
    public ChiTietHoaDon(int STT,int MaHD, int MaSP,String TenSP, int SoLuong, float GiaBan) {
        this.STT=STT;
        this.MaHD = MaHD;
        this.MaSP = MaSP;
        this.TenSP=TenSP;
        this.SoLuong = SoLuong;
        this.GiaBan = GiaBan;
    }
    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }
    // Getter và Setter cho các thuộc tính
    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(float GiaBan) {
        this.GiaBan = GiaBan;
    }
 
    
}

