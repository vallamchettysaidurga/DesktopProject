package com.DP;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.image.*;
import com.sun.image.codec.jpeg.*;

import javafx.scene.text.Text;

 public class ComposePage extends JFrame implements ActionListener      
{
	JOptionPane jp=new JOptionPane();

	private JLabel code_label,secret_label,picture_label;
	private JTextField code_text,secret_text,picture_text;
	private JButton load_button,hide_button,home_button;
	//String secret_code="",secret_information="",user_key="";
	JLabel jl;
	byte img_byte[]=new byte[6000];
	ComposePage()
	{
		JFrame con=new JFrame("ComposePage");
		con.setLayout(null);
		code_label=new JLabel("Security Code");
		code_label.setBounds(230,100,150,50);
		code_text=new JTextField(200);
		code_text.setBounds(400,100,250,40);
		
		
		secret_label=new JLabel("Secret Information");
		secret_label.setBounds(230,200,150,50);
		secret_text=new JTextField(200);
		secret_text.setBounds(400,200,250,40);
        
		
		picture_label=new JLabel("Picture");
		picture_label.setBounds(230,300,250,40);
		picture_text=new JTextField(200);
		picture_text.setBounds(400,300,250,50);
		
		load_button=new JButton("Load");	
		load_button.setBounds(700,300,150,30);
		//load_button.addActionListener(this);
	    hide_button=new JButton("Hide");
		hide_button.setBounds(400,400,150,30);
		//hide_button.addActionListener(this);
		home_button=new JButton("Home");
		home_button.setBounds(700,400,150,30);
		//home_button.addActionListener(this);
         
		jl=new JLabel();
		jl.setBounds(700,500,150,30);

		

		con.add(code_label);
		con.add(secret_label);
		con.add(picture_label);
		
		con.add(code_text);
		con.add(secret_text);
		con.add(picture_text);
		
		con.add(load_button);
		con.add(hide_button);
		con.add(home_button);
		con.add(jl);
		System.out.println("in const after adding");
		con.setSize(1000,500);

		con.setVisible(true);		
		System.out.println("in const after visible");
       
		home_button.addActionListener(new ActionListener() {
		 public void actionPerformed(java.awt.event.ActionEvent evt) { 
			HomePage h = new HomePage(); 	
		 }
		});
		
		     load_button.addActionListener(new ActionListener() {
			 public void actionPerformed(java.awt.event.ActionEvent evt) { 
				 //ImageIcon image = new ImageIcon("C:/images/image.png");
				   // JLabel imagelabel = new JLabel(image);
				 FileDialog fd = new FileDialog(new JFrame());
				 fd.show();
	  		      System.out.println(fd.getFile());
	  		    System.out.println(fd.getDirectory());
	  		    picture_text.setText(fd.getDirectory() + fd.getFile());
			 }
		     });
	
	hide_button.addActionListener(new ActionListener() {
	    	public void actionPerformed(java.awt.event.ActionEvent evt){  
 	    		hide_buttonactionPerformed(evt);
	    	}
				
	    		public void hide_buttonactionPerformed(ActionEvent evt) {
                  String secret_code=code_text.getText();
                  String secret_information=secret_text.getText();
                  String picture=picture_text.getText();
	    			try
					{
						
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			  Connection cn=DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
			  java.sql.Statement st=cn.createStatement();

			  ResultSet r =st.executeQuery("insert into message values('"+secret_code+"','"+secret_information+"','"+picture+"')");
			 	if(r.next()) 
			  jp.showMessageDialog(jp, "successful");
			 	
			 	 code_text.setText(" ");
		         secret_text.setText(" ");
		         picture_text.setText(" ");
		         
				}
			 catch(ClassNotFoundException cnf)
		       {
				 Throwable e=null;
				 System.out.println(e.getMessage());
		       }
					
		     catch(SQLException sql) 
		     	 { 
					jp.showMessageDialog(jp,"unsuccessful");
				}
			 }
	    		private void dispose(ActionEvent evt) {
	       	

	    		}});
	
	}		   
    public static void main(String args[])
	{
		System.out.println("in main");
	    new ComposePage();
		
		
	}
	
	public void call() {
	}
  






	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}//end of class