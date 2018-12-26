package com.DP;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HomePage extends JFrame implements ActionListener {
	 
		HomePage()
		{
		JFrame f=new JFrame("Home Page");
		JButton btnCompose=new JButton("Compose");
		btnCompose.setBounds(300,350,150,50);
	    JButton btnBreak=new JButton("Break");
	    btnBreak.setBounds(550,350,150,50);
		
	    f.add(btnCompose);
		f.add(btnBreak);
		f.setSize(1035,790);
		f.setLayout(null);
		f.setVisible(true);


	btnCompose.addActionListener(new java.awt.event.ActionListener(){  
			public void actionPerformed(java.awt.event.ActionEvent evt){  
				btnComposeActionPerformed(evt); 
			}

			private void btnComposeActionPerformed(ActionEvent evt) {
				ComposePage c = new ComposePage();
			}
	});
	
	
		btnBreak.addActionListener(new java.awt.event.ActionListener(){ 
			public void actionPerformed(java.awt.event.ActionEvent evt){  
				btnBreakActionPerformed(evt); 
		}
			private void btnBreakActionPerformed(ActionEvent evt) {
				BreakPage b=new BreakPage();
				
			}
		
	});	
		}
public static void main(String args[]) {
	HomePage h=new HomePage();
	
}
public void call() {
}
{
}
public void HomePage() {
	// TODO Auto-generated method stub
	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
	
}

	
	


