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
public class Insert1 {
     public static void main(String args[]) 
    { 
        System.out.println("In Insertion Page");
//        String sid = "101"; 
//        String sname = "aa"; 
//        String sbranch = "cse"; 
//        String saddress = "rajampet"; 
//        String sphonenum = "76554"; 
          
        try
        { 
            System.out.println("in try block");
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 
            Connection con=DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;DatabaseName=swathi","sa","dwmafas123" );
            Statement stmt = con.createStatement(); 
            System.out.println("stmt" +stmt);
            
           
           
            String q1 = "select * from student WHERE sid=102";
            ResultSet rs = stmt.executeQuery(q1); 
            while (rs.next()) 
            { 
                System.out.println("sid : " + rs.getString(1)); 
                System.out.println("sname :" + rs.getString(3)); 
                System.out.println("sbranch :" + rs.getString(4)); 
                System.out.println("sphonenum :" + rs.getString(5)); 
                System.out.println("saddress :" + rs.getString(2)); 
            } 
//            int x = stmt.executeUpdate(q1); 
//            if (x > 0)             
//                System.out.println("Successfully Inserted");             
//            else            
//                System.out.println("Insert Failed"); 
////              
            con.close(); 
        } 
        catch(Exception e) 
        { 
            System.out.println(e.getMessage()); 
        } 
    } 
} 