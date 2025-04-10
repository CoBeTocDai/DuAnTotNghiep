/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainsys.dao;

import trainsys.entity.TaoTK;
import trainsys.utils.XJdbc;
import java.sql.*;
import java.util.*;

/**
 *
 * @author ADMIN
 */
public class TaoTKDAO {
    public void insert(TaoTK tk) {
        String sql = "INSERT INTO TaiKhoanKH (MaKH, TenTaiKhoan, MatKhau) VALUES (?, ?, ?)";
        XJdbc.update(sql,
            tk.getMaKH(),
            tk.getTenTaiKhoan(),
            tk.getMatKhau());
    }

    public TaoTK selectById(String tentaikhoan){
        String sql="SELECT * FROM TaiKhoanKH WHERE TenTaiKhoan=?";
        List<TaoTK> list = this.selectBySql(sql, tentaikhoan);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    protected List<TaoTK> selectBySql(String sql, Object...args){
        List<TaoTK> list= new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    TaoTK entity=new TaoTK();
                    entity.setMaKH(rs.getString("MaKH"));
                    entity.setTenTaiKhoan(rs.getString("TenTaiKhoan"));
                    entity.setMatKhau(rs.getString("MatKhau"));
                    list.add(entity);
                }
            } 
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
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
