/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainsys.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import trainsys.entity.Ve;
import trainsys.utils.XJdbc;
/**
 *
 * @author Administrator
 */
public class VeDAO {
   
    // Lấy tất cả dữ liệu từ bảng VeTau
    public List<Ve> getAllVeTau() {
        List<Ve> list = new ArrayList<>();
        String sql = "SELECT MaVe, MaChuyenDi, SoToa, SoGhe, MaKH FROM VeTau";

        try {
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                Ve ve = new Ve(
                    rs.getString("MaVe"),
                    rs.getString("MaChuyenDi"),
                    rs.getInt("SoToa"),
                    rs.getInt("SoGhe"),
                    rs.getString("MaKH")
                );
                list.add(ve);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    // Tìm kiếm vé theo MaChuyenDi
    public List<Ve> searchVeTau(String maChuyenDi) {
        List<Ve> list = new ArrayList<>();
        String sql = "SELECT MaVe, MaChuyenDi, SoToa, SoGhe, MaKH FROM VeTau WHERE MaChuyenDi = ?";

        try {
            ResultSet rs = XJdbc.query(sql, maChuyenDi);
            while (rs.next()) {
                Ve ve = new Ve(
                    rs.getString("MaVe"),
                    rs.getString("MaChuyenDi"),
                    rs.getInt("SoToa"),
                    rs.getInt("SoGhe"),
                    rs.getString("MaKH")
                );
                list.add(ve);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    // Lọc danh sách vé theo mã tàu
    public List<Ve> filterByMaTau(String maTau) {
        List<Ve> list = new ArrayList<>();
        String sql = "SELECT v.MaVe, v.MaChuyenDi, v.SoToa, v.SoGhe, v.MaKH FROM VeTau v " +
                     "JOIN ChuyenDi c ON v.MaChuyenDi = c.MaChuyenDi " +
                     "WHERE c.MaTau = ?";

        try {
            ResultSet rs = XJdbc.query(sql, maTau);
            while (rs.next()) {
                Ve ve = new Ve(
                    rs.getString("MaVe"),
                    rs.getString("MaChuyenDi"),
                    rs.getInt("SoToa"),
                    rs.getInt("SoGhe"),
                    rs.getString("MaKH")
                );
                list.add(ve);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    // Lấy danh sách tất cả các mã tàu
    public List<String> getAllMaTau() {
        List<String> list = new ArrayList<>();
        String sql = "SELECT DISTINCT MaTau FROM ChuyenDi";

        try {
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                list.add(rs.getString("MaTau"));
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
