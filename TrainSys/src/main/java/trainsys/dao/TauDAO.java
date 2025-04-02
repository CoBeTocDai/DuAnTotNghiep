/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainsys.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trainsys.entity.Tau;
import trainsys.utils.XJdbc;

/**
 *
 * @author dien
 */
public class TauDAO extends TrainSysDAO<Tau, String>{
    public void insert(Tau model){
        String sql="INSERT INTO Tau (MaTau, SoLuongToa, SoLuongGhe, TrangThai) VALUES (?, ?, ?, ?)";
        XJdbc.update(sql, 
                model.getMaTau(), 
                model.getSoLT(), 
                model.getSoLG(), 
                model.getTrangThai());
    }
    
    public void update(Tau model){
        String sql="UPDATE Tau SET SoLuongToa=?, SoLuongGhe=?, TrangThai=? WHERE MaTau=?";
        XJdbc.update(sql, 
                model.getMaTau(), 
                model.getSoLT(), 
                model.getSoLG(), 
                model.getTrangThai());
    }
    
    public void delete(String MaTau){
        String sql="DELETE FROM Tau WHERE MaTau=?";
        XJdbc.update(sql, MaTau);
    }
    
    public List<Tau> selectAll(){
        String sql="SELECT * FROM Tau";
        return this.selectBySql(sql);
    }
    
    public Tau selectById(String MaTau){
        String sql="SELECT * FROM Tau WHERE MaTau=?";
        List<Tau> list = this.selectBySql(sql, MaTau);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    protected List<Tau> selectBySql(String sql, Object...args){
        List<Tau> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    Tau entity=new Tau();
                    entity.setMaTau(rs.getString("MaTau"));
                    entity.setSoLT(rs.getString("SoLuongToa"));
                    entity.setSoLG(rs.getString("SoLuongGhe"));
                    entity.setTrangThai(rs.getString("TrangThai"));
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
}
