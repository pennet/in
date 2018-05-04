package com.ds;

//SelectTest.java 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class  SelectTest
{
	public static void main(String[] args) throws Exception
	{
		
		//logger obj is ready
		Logger logger=Logger.getLogger(com.ds.SelectTest.class);
        DOMConfigurator.configure(".\\src\\details.xml");
		
		
		logger.debug("Begining of the App");

		//Jdbc code...
        try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		logger.debug("Porj1.mod1.SelectTest.Driver class loaded");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		logger.info("Proj1.mod1.SelectTest.Connection established");
		
		Statement st=con.createStatement();
		logger.info("Proj1.mod1.SelectTest.statement obj is created");

		ResultSet rs=st.executeQuery("select * from student");
		logger.info("Proj1.mod1.SelectTest.Resuletset obj is ready");
		
		if(rs==null)
			logger.warn("Proj1.mod1.SelectTest.ResultSet obj must not be empty");
		
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"  "+rs.getString(2)+" "+rs.getString(3));
		}
		logger.info("Proj1.mod1.SelectTest.ResultSet obj is processed");
	
		rs.close();
		st.close();
		con.close();
		logger.info("Proj1.mod1.SelectTest: All jdbc objs are closed");
		}//try
		catch(SQLException e)
		{
			logger.error("Proj1.mod1.SelctTest.probem in db connectivity");
			e.printStackTrace();
		}
        catch(Exception e )
        {
		logger.fatal("Proj1.mod1.SelctTest.Unknown Problem");
        }
        logger.debug("End of the App");
	}//main
}//class




