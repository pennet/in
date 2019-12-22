/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HOME
 */
import java.sql.*; 
  
public class Select1  
{ 
    public static void main(String args[]) 
    { 
        String sid = "101"; 
        String sbranch = "cse"; 
        try
        { 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 
            Connection con=DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;DatabaseName=swathi","sa","dwmafas123" );
            Statement stmt = con.createStatement(); 
               
              
           
            String q1 = "select * from student WHERE sid = '" + sid +  
                                    "' AND sbranch '" + sbranch + "'"; 
            ResultSet rs = stmt.executeQuery(q1); 
            if (rs.next()) 
            { 
                System.out.println("sid : " + rs.getString(1)); 
                System.out.println("sname :" + rs.getString(3)); 
                System.out.println("saddress :" + rs.getString(4)); 
            } 
            else
            { 
                System.out.println("No such student id is already registered"); 
            } 
            con.close(); 
        } 
        catch(Exception e) 
        { 
            System.out.println(e); 
        } 
    } 
} 