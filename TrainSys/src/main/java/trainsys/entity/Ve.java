/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainsys.entity;

/**
 *
 * @author Administrator
 */
public class Ve {
   private String maVe;
    private String maChuyenDi;
    private int soToa;
    private int soGhe;
    private String maKH; 
    
    
    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getMaChuyenDi() {
        return maChuyenDi;
    }

    public void setMaChuyenDi(String maChuyenDi) {
        this.maChuyenDi = maChuyenDi;
    }

    public int getSoToa() {
        return soToa;
    }

    public void setSoToa(int soToa) {
        this.soToa = soToa;
    }

    public int getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }
    
     @Override
    public String toString() {
        return "VeTau{" +
                "maVe='" + maVe + '\'' +
                ", maChuyenDi='" + maChuyenDi + '\'' +
                ", soToa=" + soToa +
                ", soGhe=" + soGhe +
                ", maKH='" + maKH + '\'' +
                '}';
    }
}
