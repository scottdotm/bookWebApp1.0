/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Scott
 */
public class MySqlDBStrategy implements DBStrategy {
    private Connection conn;
    
    @Override
    public void openConnection(String driverClass, String url, 
            String userName, String password) throws ClassNotFoundException, SQLException {
        
        Class.forName (driverClass);
        conn = DriverManager.getConnection(url,userName, password);
        
    }
    
    @Override
    public void closeConnection() throws SQLException {
        conn.close();
    }
    
    /**
     *  Make sure you open and close connection when using method.
     * Future optimization may include change the return type of an Array.
     * @param tableName
     * @param maxRecords - limit records found to first maxRecords or if maxRecords is zero (0)
     * then no limit.
     * @throws java.sql.SQLException
     * @return records
     */
    @Override
    public List<Map<String, Object>> findAllRecords(String tableName, int maxRecords) throws SQLException{
        String sql;
        if(maxRecords <= 1){
                sql = "select * from " + tableName;
                }else{
                sql = "select * from " + tableName + " limit " + maxRecords;
                }
   
      //String sql = "select * from " + tableName + " limit " + maxRecords;
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      ResultSetMetaData rsmd = rs.getMetaData();
      int columnCount = rsmd.getColumnCount();
      List<Map<String, Object>> records = new ArrayList<>();
      
      while(rs.next()){
          Map<String, Object> record=new HashMap<>();
          for(int colNo = 1; colNo <= columnCount; colNo++){
              Object colData = rs.getObject(colNo);
              String colName = rsmd.getColumnName(colNo);
              record.put(colName, colData);
          }
          records.add(record);
      }
      
      return records;
    }
    
    @Override
    public void deleteById(String tableName, String id) throws ClassNotFoundException, SQLException {
       // Validate the parameters here.
        
       // String sql = "DELETE FROM " + tableName + " WHERE " + column + "=" + value;
        String pKeyColumnName = "";
       // Statement stmt = conn.createStatement();
        
        
        DatabaseMetaData dmd = conn.getMetaData();
        ResultSet rs = null;
      
        // was told this is expensive. Could maybe solve this with an ENUM.
        rs = dmd.getPrimaryKeys(null, null, tableName);
        

        // this works only if there is only one PK... in a parent child relationship I may want to 
        // test for how many PKs I get back... if this is going to work for any table. 
       
            
        while(rs.next()){
        pKeyColumnName = rs.getString("COLUMN_NAME");
       // System.out.println("PK column name is " + pKeyColumnName);
        
        //String sql = "delete from " + tableName + " where " + pKeyColumnName + "=" + id;
        
        String sql2 = "delete from " + tableName + " where " + pKeyColumnName + "=?";
        
        PreparedStatement pstmt = conn.prepareStatement(sql2);
       
        pstmt.setInt(1, Integer.parseInt(id));
        
        pstmt.executeUpdate(); 
        }

    }
    
    
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        DBStrategy db = new MySqlDBStrategy();
        db.openConnection("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/books", "root", "admin");
        System.out.println(db.findAllRecords("author", 0).toString());
        db.deleteById("author", "2");
        System.out.println(db.findAllRecords("author", 0).toString());
        db.closeConnection();
        
    }
    
}
//    public static void main(String[] args) throws SQLException, ClassNotFoundException{
//DBStrategy db = new MySqlDBStrategy();
//db.openConnection("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/books","root","admin");
//List<Map<String,Object>> rawData=db.findAllRecords("author",0);
//db.closeConnection();
//System.out.println(rawData);
//}
//
//}

