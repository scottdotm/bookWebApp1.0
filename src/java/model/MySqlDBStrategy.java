/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Scott
 */
public class MySqlDBStrategy implements DBStrategy {
    private Connection conn;
    
    public MySqlDBStrategy(String driverClass, String url, String userName, String password) throws ClassNotFoundException,SQLException{
        
        Class.forName (driverClass);
        conn = DriverManager.getConnection(url,userName,password);
        
        
    }
    public void closeConnection() throws SQLException{
        
    }
}
