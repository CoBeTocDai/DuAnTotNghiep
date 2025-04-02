/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainsys.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trainsys.entity.KhachHang;
import trainsys.utils.XJdbc;

/**
 *
 * @author Tien
 */
public class KhachHangDAO extends TrainSysDAO<KhachHang, String> {

    public void insert(KhachHang model){
        String sql="INSERT INTO KhachHang (MaKH, HoTen, Email, SDT) VALUES (?, ?, ?, ?)";
        XJdbc.update(sql, 
                model.getMaKH(), 
                model.getHoTen(), 
                model.getEmail(),
                model.getSDT());
    }
    
    public void update(KhachHang model){
        String sql="UPDATE KhachHang SET HoTen=?, Email=?, SDT=? WHERE MaKH=?";
        XJdbc.update(sql, 
                model.getHoTen(), 
                model.getEmail(), 
                model.getSDT(), 
                model.getMaKH());
    }
    
    public void delete(String id){
        String sql="DELETE FROM KhachHang WHERE MaKH=?";
        XJdbc.update(sql, id);
    }
    
    public List<KhachHang> selectAll(){
        String sql="SELECT * FROM KhachHang";
        return selectBySql(sql);
    }
    
    public KhachHang selectById(String manh){
        String sql="SELECT * FROM KhachHang WHERE MaKH=?";
        List<KhachHang> list = selectBySql(sql, manh);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    protected List<KhachHang> selectBySql(String sql, Object...args){
        List<KhachHang> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    KhachHang entity=new KhachHang();
                    entity.setMaKH(rs.getString("MaKH"));
                    entity.setHoTen(rs.getString("HoTen"));
                    entity.setEmail(rs.getString("Email"));
                    entity.setSDT(rs.getString("SDT"));
                    list.add(entity);
                }
            } 
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    public List<KhachHang> selectByKeyword(String keyword){
        String sql="SELECT * FROM KhachHang WHERE MaKH LIKE ?";
        return this.selectBySql(sql, "%"+keyword+"%");
    }
}
