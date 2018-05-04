//SelectTest.java
import java.sql.Connection; // jdbc api
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger; // log4j api
import org.apache.log4j.xml.XMLLayout;

public class  SelectTest1
{
	public static void main(String[] args) throws Exception
	{

		//logger obj is ready pointing to SelectTest class
		Logger logger=Logger.getLogger(SelectTest.class);

		//layout object
        XMLLayout layout=new XMLLayout();
		//appender object
		FileAppender appender=new FileAppender(layout,"mylog.xml",true);

		//add appender to logger
		logger.addAppender(appender);

		//set logger level for retrieving log messages
		logger.setLevel((Level)Level.DEBUG); 

         // write jdbc code here
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		logger.debug("Proj1.mod1.App1.SelectTest.Driver is Loaded");

		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		logger.info("Proj1.mod1.App1.SelectTest.Conection established");

		 Statement  st=con.createStatement();
		 logger.info("Proj1.mod1.App1.SelectTest.Satement obj is ready");

		 ResultSet rs=st.executeQuery("select * from emp");
		 if(rs==null)
		{
			 logger.warn("Proj1.mod1.App1.SelectTest.empty ResultSet has come");
		}
		else
		{
			logger.info("Proj1.mod1.App1.SelectTest.ResultSet geneated");
		}

		 while(rs.next())
		{
			 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}//while
		logger.debug("Proj1.mod1.App1.SelectTest.ResuletSet obj processed");

	   rs.close();
	   st.close();
	   con.close();
	   logger.debug("Proj1.mod1.App1.SelectTest.all jdbc streams are closed");
		}
		catch(SQLException se)
		{
			logger.error("Proj1.mod1.App1.SelectTest.DB Exception ");
			se.printStackTrace();
		}
		catch(Exception e)
		{
			logger.fatal("Proj1.mod1.App1.SelectTest.Unknown problem");
			e.printStackTrace();
		}
		logger.debug("Proj1.mod1.App1.SelectTest.end of the Application");

	}//main
}//class

//add log4-version.jar , odbc6.jar files to classpath
//>javac SelectTest.java
//>java SelectTest  