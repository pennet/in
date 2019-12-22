/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swathi.test;

import java.sql.*;

/**
 *
 * @author HOME
 */
public class JdbcConnections {
   private static Connection con;
    public static Connection getconnect(){
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
            con=DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;DatabaseName=swathi","sa","dwmafas123" );
           
        }
        catch (Exception e){
            
        }
       return con;
    }
    
}
