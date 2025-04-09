/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainsys.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Dien
 */
public class ChuyenDi {
    private String MaCD;
    private String MaTau;
    private String GaDi;
    private String GaDen;
    private String GioDi;
    private Date NgayDi = new Date();

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return MaCD + " | " + GaDi + " -> " + GaDen + " | " + sdf.format(NgayDi) + " " + GioDi;
    }
    public String getMaCD() {
        return MaCD;
    }

    public void setMaCD(String MaCD) {
        this.MaCD = MaCD;
    }
    public String getMaTau() {
        return MaTau;
    }

    public void setMaTau(String MaTau) {
        this.MaTau = MaTau;
    }

    public String getGaDi() {
        return GaDi;
    }

    public void setGaDi(String GaDi) {
        this.GaDi = GaDi;
    }

    public String getGaDen() {
        return GaDen;
    }

    public void setGaDen(String GaDen) {
        this.GaDen = GaDen;
    }

    public String getGioDi() {
        return GioDi;
    }

    public void setGioDi(String GioDi) {
        this.GioDi = GioDi;
    }

    public Date getNgayDi() {
        return NgayDi;
    }

    public void setNgayDi(Date NgayDi) {
        this.NgayDi = NgayDi;
    }
}
