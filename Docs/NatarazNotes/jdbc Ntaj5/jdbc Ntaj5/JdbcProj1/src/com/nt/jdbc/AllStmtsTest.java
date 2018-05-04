package com.nt.jdbc;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AllStmtsTest extends JFrame implements ActionListener{
	private JLabel lno,lname,lm1,lm2,lm3,lres;
	private JTextField tname,tm1,tm2,tm3,tres;
	private JButton  bdetails,bresult;
	private JComboBox tno;
	private Connection con;
	private Statement st;
	private PreparedStatement ps;
	private CallableStatement cs;
	private ResultSet rs1,rs2;
	
	//constructor
	public AllStmtsTest(){
		System.out.println("Constructor");
	  setSize(400,400);
	  setBackground(Color.cyan);
	  setLayout(new FlowLayout());
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  //prpeare and Add comps
	  lno=new JLabel("sno");
	  add(lno);
	  tno=new JComboBox();
	  add(tno);
	  
	  bdetails=new JButton("details");
	  bdetails.addActionListener(this);
	  add(bdetails);
	  
	  lname=new JLabel("sname");
	  add(lname);
	  tname=new JTextField(10);
	  add(tname);
	  
	  lm1=new JLabel("Marks1");
	  add(lm1);
	  tm1=new JTextField(10);
	  add(tm1);
	  
	  lm2=new JLabel("Marks2");
	  add(lm2);
	  tm2=new JTextField(10);
	  add(tm2);
	  
	  lm3=new JLabel("Marks3");
	  add(lm3);
	  tm3=new JTextField(10);
	  add(tm3);
	  
	  bresult=new JButton("Result");
	  bresult.addActionListener(this);
	  add(bresult);
	  
	  lres=new JLabel("Result");
	  add(lres);
	  tres=new JTextField(10);
	  add(tres);
	  
	  setVisible(true);

	   myInit();	
		 
	}//constructor
	
	private void myInit(){
		System.out.println("myInit()");
		try{
        //register driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
        //create Statement obj
		st=con.createStatement();
		//exeute logic to get sno values into combo box
		rs1=st.executeQuery("select sno from All_student");
		while(rs1.next()){
			tno.addItem(rs1.getString(1));
		}//while
		rs1.close();
		st.close();
		//create PrparedStatement obj
		ps=con.prepareStatement("select * from All_Student where sno=?");
		//create CallableStatement obj
		cs=con.prepareCall("{call FIND_PASS_FAIL(?,?,?,?)}");
		cs.registerOutParameter(4,Types.VARCHAR);
		}//try
		catch(Exception e){
			e.printStackTrace();
		}
	}//myInit()
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println("action Performed");
		if(ae.getSource()==bdetails){
			System.out.println("Details btn is clicked");
			//get selected item from combo box 
			String tsno=(String)tno.getSelectedItem();
			int no=Integer.parseInt(tsno);
			try{
			//set value to PrepareStatement obj Query
			ps.setInt(1,no);
			//execute the Query
			rs2=ps.executeQuery();
			//set values to text boxes
			 if(rs2.next()){
			  tname.setText(rs2.getString(2));
			  tm1.setText(rs2.getString(3));
			  tm2.setText(rs2.getString(4));
			  tm3.setText(rs2.getString(5));
			 }//if
		 
			
			}//try
			catch(Exception e){
				e.printStackTrace();
			}
		}//if
		else{
		try{ 
		System.out.println("Result Btn is clicked");
		 //read values from marks text boxes and set them IN param values
		 cs.setInt(1,Integer.parseInt(tm1.getText()));
		 cs.setInt(2,Integer.parseInt(tm2.getText()));
		 cs.setInt(3,Integer.parseInt(tm3.getText()));
		 //call pl/sql procedure
		 cs.execute();
		 //gather result from OUT param and set to text box
		 tres.setText(cs.getString(4));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	   }//else
    }//actionPerformed(-)
		

	
	public static void main(String[] args) {
		System.out.println("main(-)");
		 AllStmtsTest stmts=new AllStmtsTest();
		
	}
	
	

	
}
