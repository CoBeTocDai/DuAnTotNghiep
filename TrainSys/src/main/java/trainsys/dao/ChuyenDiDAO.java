/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainsys.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trainsys.entity.ChuyenDi;
import trainsys.utils.XJdbc;

/**
 *
 * @author Tien
 */
public class ChuyenDiDAO extends TrainSysDAO<ChuyenDi, String> {
    public void insert(ChuyenDi model){
        String sql="INSERT INTO ChuyenDi (MaChuyenDi, MaTau, GaDi, GaDen, GioDi, NgayDi) VALUES (?, ?, ?, ?, ?, ?)";
        XJdbc.update(sql, 
                model.getMaCD(),
                model.getMaTau(),
                model.getGaDi(),
                model.getGaDen(),
                model.getGioDi(),
                model.getNgayDi()
        );
    }
    
    public void update(ChuyenDi model){
        String sql="UPDATE ChuyenDi SET MaTau=?, GaDi=?, GaDen=?, GioDi=?, NgayDi=? WHERE MaChuyenDi=?";
        XJdbc.update(sql, 
                model.getMaTau(),
                model.getGaDi(),
                model.getGaDen(),
                model.getGioDi(),
                model.getNgayDi(),                
                model.getMaCD()
        );
    }
    
    public void delete(String id){
        String sql="DELETE FROM ChuyenDi WHERE MaChuyenDi=?";
        XJdbc.update(sql, id);
    }
    
    public List<ChuyenDi> selectAll(){
        String sql="SELECT * FROM ChuyenDi";
        return selectBySql(sql);
    }
    
    public ChuyenDi selectById(String macd){
        String sql="SELECT * FROM ChuyenDi WHERE MaChuyenDi=?";
        List<ChuyenDi> list = selectBySql(sql, macd);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    protected List<ChuyenDi> selectBySql(String sql, Object...args){
        List<ChuyenDi> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    ChuyenDi entity=new ChuyenDi();
                    entity.setMaCD(rs.getString("MaChuyenDi"));
                    entity.setMaTau(rs.getString("MaTau"));
                    entity.setGaDi(rs.getString("GaDi"));
                    entity.setGaDen(rs.getString("GaDen"));
                    entity.setGioDi(rs.getString("GioDi"));
                    entity.setNgayDi(rs.getDate("NgayDi"));
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
    public List<ChuyenDi> selectByChuyenDi(int maCD) {
        String sql="SELECT * FROM ChuyenDi WHERE MaChuyenDi=?";
        return this.selectBySql(sql, maCD);
    }
}
