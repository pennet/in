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
  
public class UpdationForm extends HttpServlet {
    
{ 
    public static void main(String args[]) 
    { 
//        String sid = "101"; 
//        String sname = "name4"; 
//        String sbranch = "cse"; 
//        String saddress = "Bangalore"; 
//        String sphonenum = "677"; 
//          
        try
        { 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 
            Connection con=DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;DatabaseName=swathi","sa","dwmafas123" );
            Statement stmt = con.createStatement(); 
              
          
            
            String q1 = "UPDATE student set saddress = '" + "newsaddress"+  
                    "' WHERE sid = '" +sid+ "' AND saddress = '" + saddress + "'"; 
            ResultSet rs = stmt.executeQuery(q1); 
            while (rs.next()) 
            { 
                System.out.println("sid : " + rs.getString(1)); 
                System.out.println("sname :" + rs.getString(3)); 
                System.out.println("sbranch :" + rs.getString(4)); 
                System.out.println("sphonenum :" + rs.getString(5)); 
                System.out.println("saddress :" + rs.getString(2)); 
            } 
            int x = stmt.executeUpdate(q1); 
              
            if (x > 0)             
                System.out.println("Saddress Successfully Updated");             
            else            
                System.out.println("ERROR OCCURED :("); 
              
            con.close(); 
        } 
        catch(Exception e) 
        { 
            System.out.println(e); 
        }
    }
}