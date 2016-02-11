/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.sql.Connection;
import java.sql.DriverManager;
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
    public List<Map<String, Object>> findAllRecords(String tableName, int maxRecords) throws SQLException{
      String sql = "select * from " + tableName + " limit " + maxRecords;
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      ResultSetMetaData rsmd = rs.getMetaData();
      int columnCount = rsmd.getColumnCount();
      List<Map<String, Object>> records = new ArrayList<>();
      
      while(rs.next()){
          Map<String, Object> record=new HashMap<>();
          for(int colNo = 1; colNo == columnCount; colNo++){
              Object colData = rs.getObject(colNo);
              String colName = rsmd.getColumnName(colNo);
              record.put(colName, colData);
          }
          records.add(record);
      }
      
      return records;
    }
}
