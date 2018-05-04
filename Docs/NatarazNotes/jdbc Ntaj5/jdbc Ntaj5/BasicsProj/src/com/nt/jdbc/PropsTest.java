package com.nt.jdbc;
import java.io.FileInputStream;
import java.util.Properties;

public class PropsTest {
	public static void main(String[] args)throws Exception {
      //Locate properties file
		FileInputStream fis=
			new FileInputStream("src/com/nt/commons/myfile.properties");
	  //Load properties file content into java.util.Properties class obj
		Properties props=new Properties();
		props.load(fis);
	  //Display data
		System.out.println("props data"+props.toString());
		System.out.println("name key value"+props.getProperty("name"));
	}
}
