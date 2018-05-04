package test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.nt.beans.StudentService;

public class ClientApp {

	public static void main(String[] args) {
		// Activate BF
		XmlBeanFactory factory=new XmlBeanFactory(new FileSystemResource("src/com/nt/cfgs/applicationContext.xml"));
	   // get ServiceBean obj
		StudentService service=(StudentService)factory.getBean("service");
		//Call B.method
		System.out.println("Result="+service.generateResult(132,"raja",90,36,45));
	}//main
}//class

