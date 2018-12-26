package com.DP;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;





import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Container;
	
public class Login extends JFrame implements ActionListener{
	JOptionPane jp=new JOptionPane();
	JLabel l1,l2;
	JTextField t1;
	JPasswordField t2;
	String UserName;
	String Password;
	
	 Login()
	
	{
		JFrame f=new JFrame("UserLogin");
		  
		l1=new JLabel("UserName:");  
		l1.setBounds(50,50, 100,30);  
		l2=new JLabel("Password:");  
		l2.setBounds(50,100, 100,30);    
		  
	    t1=new JTextField("");  
	    t1.setBounds(130,50, 200,30); 
	     
	    t2=new JPasswordField("");  
	    t2.setBounds(130,100, 200,30);
	    
		JButton b=new JButton("login");
		b.setBounds(200,160,100, 40);
		
		f.add(l1);
		f.add(l2);
		f.add(t1);
		f.add(t2);
		f.add(b);
		f.setSize(1000,500);
		f.setLayout(null); 
		f.setVisible(true); 
		b.addActionListener(new java.awt.event.ActionListener(){  
				public void actionPerformed(java.awt.event.ActionEvent evt){  
				        bActionPerformed(evt); 
				}
		});
		}
				private void bActionPerformed(ActionEvent evt)
				{
			try
			{
						
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			  Connection cn=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
			 java.sql.Statement st=cn.createStatement();
		
			 ResultSet r =st.executeQuery("select * from login");
							
			 while(r.next())
				{
					
                 UserName = r.getString("username");
				 Password = r.getString("password");
				    
				}
					if((UserName.equals(t1.getText()))&&(Password.equals(t2.getText())))
                 { 
						jp.showMessageDialog(jp, "successful done");                   
						HomePage h=new HomePage();
						//h.setSize(1035,790);
						//h.setVisible(true);
						h.call();
		
                  }
					else
					{
						
						jp.showMessageDialog(jp, "unsuccessful-due incorrect password or username ");
					}
					
			}
			

								
					catch(Exception sql)
					{
						jp.showMessageDialog(this,sql,"EXCEPTION",jp.ERROR_MESSAGE, null);
					    System.out.println(sql.getMessage());
					}
					}	


public void actionPerformed(ActionEvent e) 
{
}
public void Home() {
	
}

public static void main(String[] args)
{
new Login();

}
public void  Login() {
}
}






