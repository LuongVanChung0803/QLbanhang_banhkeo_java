/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hc
 */
public class SanPham {
     private int MaSP;
    private String TenSP;
    private String MoTa;
    private float Gia;
    private int SoLuong;
    private int MaNCC;

    // Constructor
    public SanPham(int MaSP, String TenSP, String MoTa, float Gia, int SoLuong, int MaNCC) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.MoTa = MoTa;
        this.Gia = Gia;
        this.SoLuong = SoLuong;
        this.MaNCC = MaNCC;
    }

    public SanPham() {
    }
    

    // Các phương thức getter và setter
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

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public float getGia() {
        return Gia;
    }

    public void setGia(float Gia) {
        this.Gia = Gia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(int MaNCC) {
        this.MaNCC = MaNCC;
    }
}
