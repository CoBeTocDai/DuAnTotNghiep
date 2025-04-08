/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainsys.dao;

import trainsys.entity.TaoTK;
import trainsys.utils.XJdbc;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class TaoTKDAO {
    public void insert(TaoTK tk) {
        String sql = "INSERT INTO KhachHang (MaKH, TenTaiKhoan, HoTen, SDT, Email, MatKhau) VALUES (?, ?, ?, ?, ?, ?)";
        XJdbc.update(sql,
                tk.getMaKH(),
                tk.getTenTaiKhoan(),
                tk.getHoTen(),
                tk.getSdt(),
                tk.getEmail(),
                tk.getMatKhau());
    }

    public boolean isUsernameTaken(String tenTaiKhoan) {
        String sql = "SELECT * FROM TaoTK WHERE TenTaiKhoan = ?";
        try (ResultSet rs = XJdbc.query(sql, tenTaiKhoan)) {
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
