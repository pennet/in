package com.penchal;

import com.penchal.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Status extends HttpServlet {
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws 
IOException {


try{
PrintWriter out = res.getWriter();

String name = req.getParameter("filename");
File file = new File(name);
if (file.exists()) {
BufferedReader input = new BufferedReader(new FileReader(file));
String line = "";
while ((line = input.readLine()) != null) {
out.println(line);
}
}
}
catch (Throwable t) 
{ 
t.printStackTrace(); 
} 


finally { 

} }

}