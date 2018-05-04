package com.nt.jdbc;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ScrollFrame extends JFrame implements ActionListener {
    private JLabel lno,lname,laddrs;
    private JTextField tsno,tsname,tsaddrs;
    private JButton bfirst,bnext,bprevious,blast;
    
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public ScrollFrame(){
     super("Scroll Frame App");
     setSize(400,500);
     setBackground(Color.CYAN);
     setLayout(new FlowLayout());
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     
     lno=new JLabel("student  no:");
     add(lno);
     tsno=new JTextField(10);
     add(tsno);
     
     lname=new JLabel("student  name:");
     add(lname);
     tsname=new JTextField(10);
     add(tsname);
     
     laddrs=new JLabel("Student Address:");
     add(laddrs);
     tsaddrs=new JTextField(10);
     add(tsaddrs);
     
     bfirst=new JButton("First");
     bfirst.addActionListener(this);
     add(bfirst);
     
     bnext=new JButton("next");
     bnext.addActionListener(this);
     add(bnext);
     
     bprevious=new JButton("Previous");
     bprevious.addActionListener(this);
     add(bprevious);
     
     blast=new JButton("Last");
     blast.addActionListener(this);
     add(blast);
     
    setVisible(true);
    
    makeConnection();
   }//constructor
    
   public void makeConnection(){
	   try{
	   //create jdbc con
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
	  //Create PreparedStatment obj with type,mode
	  ps=con.prepareStatement("select * from student",
			                                    ResultSet.TYPE_SCROLL_SENSITIVE,
			                                    ResultSet.CONCUR_READ_ONLY);
	  rs=ps.executeQuery();
	   }
	   catch(Exception e){
		   e.printStackTrace();
	   }
   }
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
	try{
		
        boolean flag=false;
		System.out.println(ae.getActionCommand());
		if(ae.getSource()==bfirst){
			rs.first();
			flag=true;
		}
		else if(ae.getSource()==bnext){
			if(!rs.isLast()){
				rs.next();
				flag=true;
			}
		}
		else if(ae.getSource()==bprevious){
			if(!rs.isFirst()){
				rs.previous();
				flag=true;
			}
		}
		else{
			rs.last();
			flag=true;
		}
		
		if(flag==true){
			tsno.setText(rs.getString(1));
			tsname.setText(rs.getString(2));
			tsaddrs.setText(rs.getString(3));
		}//if
	}//try
	catch(Exception e){
		e.printStackTrace();
	}
 }//actionPerformed(-)
  public static void main(String[] args) {
	new ScrollFrame();
 }//class
}//main
	