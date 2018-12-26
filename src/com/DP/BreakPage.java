package com.DP;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.image.*;
//import javax.imageio.stream.*;

public class BreakPage extends JFrame implements ActionListener
{
	
	private JLabel code_label,picture_label;
	private JTextField code_text,picture_text;
	private JButton picture_load_button,break_button,home_button;
	//String filepath="",secret_code="",secret_info="";
	JLabel jl;
	byte img_byte[]=new byte[6000];
	FileDialog fd;
	

	//////// Variables for creating an image from an integer array  ///////////////////////////

	Image img;
	Dimension d;
	int iw,ih;
	int w=10,h=10;
	int pix[];
	int hist[]=new int[256];
	int t[];
	int max_hist=0;
	boolean ok;
	Image newimg;
	int key,k;
	String user_key="";

	BreakPage()
	{
		super("Break");
		JFrame con=new JFrame("BreakPage");
		//con=getContentPane();
		con.setLayout(null);

		code_label=new JLabel("Security Code");
		code_label.setBounds(230,200,150,50);
		code_text=new JTextField(200);
		code_text.setBounds(400,200,250,40);
		
		picture_label=new JLabel("Picture");
		picture_label.setBounds(230,300,250,40);
		picture_text=new JTextField(200);
		picture_text.setBounds(400,300,250,50);
		picture_load_button=new JButton("Load");	
		picture_load_button.setBounds(700,300,150,30);
		//picture_load_button.addActionListener(this);
	
		break_button=new JButton("Break");
		break_button.setBounds(400,400,150,30);
		//break_button.addActionListener(this);
		home_button=new JButton("Home");
		home_button.setBounds(700,400,150,30);
		//home_button.addActionListener(this);
		
		jl=new JLabel();
		jl.setBounds(700,500,150,30);

		fd=new FileDialog(new JFrame());

		con.add(code_label);
		con.add(code_text);
		con.add(picture_label);
		con.add(picture_text);
		
		con.add(picture_load_button);
		con.add(break_button);
		con.add(home_button);
		con.add(jl);
		con.setSize(1035,740);

		con.setVisible(true);
		
	
	home_button.addActionListener(new ActionListener() {
		 public void actionPerformed(java.awt.event.ActionEvent evt) { 
			HomePage h = new HomePage(); 	
		 }
		});
	
	break_button.addActionListener(new java.awt.event.ActionListener(){  	
		public void actionPerformed(java.awt.event.ActionEvent evt){  
			break_buttonActionPerformed(evt); 
	}
});
	picture_load_button.addActionListener(new ActionListener() {
		 public void actionPerformed(java.awt.event.ActionEvent evt) { 
			 FileDialog fd = new FileDialog(new JFrame());
			 fd.show();
 		      System.out.println(fd.getFile());
 		    System.out.println(fd.getDirectory());
 		    picture_text.setText(fd.getDirectory() + fd.getFile());
		 }
	     });


}
	private void break_buttonActionPerformed(ActionEvent evt)
	{
try
{
			System.out.println("in try");
  Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection cn=DriverManager.getConnection
		("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
 java.sql.Statement st=cn.createStatement();
 System.out.println("in try before rs");
 ResultSet r =st.executeQuery("select secret_information from message where secret_code= '" +  code_text.getText() + "' and picture= '" + picture_text.getText() + "'");
  if (r.next()) 
	{
	  System.out.println("in try in if");
		JOptionPane.showMessageDialog(null, r.getString(1));
	}
 

		else
		{
			System.out.println("in try in else");
			JOptionPane.showMessageDialog(null, "Secret message not found ");
		}
		
}
					
		catch(Exception sql)
		{
			JOptionPane.showMessageDialog(this,sql.getMessage());
		    System.out.println(sql.getMessage());
		}
		}



public static void main(String args[])
	{
		BreakPage bp=new BreakPage();
		//bp.setSize(1035,740);
		//bp.setVisible(true);
	}

	public void BreakPage() {
		// TODO Auto-generated method stub
		
	}
	

public void call() {
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}