/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainsys.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dien
 */
public class XJdbc {
    private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl="jdbc:sqlserver://localhost:1433;databaseName=EduSys;trustServerCertificate=true;";
    private static String username ="khanh";
    private static String password ="khanh.2007";
    
    static{
        try {            
            Class.forName(driver);
            System.out.println("Driver loaded successfully!");
        } 
        catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static PreparedStatement getStmt(String sql, Object...args) throws SQLException{
        Connection connection = DriverManager.getConnection(dburl, username, password);
        System.out.println("connection established: " + connection);
        PreparedStatement pstmt = null;
        if(sql.trim().startsWith("{")){
            pstmt = connection.prepareCall(sql);
        }
        else{
            pstmt = connection.prepareStatement(sql);
        }
        for(int i=0;i<args.length;i++){
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;
    }

    public static void update(String sql, Object...args) {
        try {
            PreparedStatement stmt = XJdbc.getStmt(sql, args);
            try {
                stmt.executeUpdate();
                System.out.println("update executed");
            } 
            finally{
                stmt.getConnection().close();
                System.out.println("connection closed!");
            }
        } 
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet query(String sql, Object...args) {
        try {
            PreparedStatement stmt = XJdbc.getStmt(sql, args);
            return stmt.executeQuery();
        } 
        catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
    public static Object value(String sql, Object...args) {
        try {
            ResultSet rs = XJdbc.query(sql, args);
            if(rs.next()){
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
