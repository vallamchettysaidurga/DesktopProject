package com.DP;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.io.*;
import java.awt.image.*;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class test extends JFrame
{
	
	public test(String filepath) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
	JFrame frame = new JFrame(filepath);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	BufferedImage img=null;
	try
	{
		img=ImageIO.read(new File(filepath));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    JLabel lb1=new JLabel();
    lb1.setIcon(new ImageIcon(img));
    frame.getContentPane().add(lb1, BorderLayout.CENTER);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}
		});
	}//
public static void main(String[] args)
{
	new test("c:\\budha9.jpg");
	
}
}

/*frame.setSize(1035,790);
    ImageIcon icon = new ImageIcon("");
    JLabel label = new JLabel();
    label.setBounds(700,500,150,30);

label.setIcon(icon);
frame.add(label);
frame.setDefaultCloseOperation
       (JFrame.EXIT_ON_CLOSE);
frame.pack();
frame.setVisible(true);

}
 ImageIcon image = new ImageIcon("C:/images/image.png");
 */
  //  JLabel imagelabel = new JLabel(image);
//ImageIcon image = new ImageIcon("C:/images/image.png");
    //JLabel imagelabel = new JLabel(image);
    
    /*Image newimg;
	test()
	{
	}
	test(Image m)
	{
		newimg=m;
	}
	public void paint(Graphics g)
	{
		g.drawImage(newimg,100,100,null);
	}

	public static void main(String args[])
	{
		test bp=new test();
		bp.setSize(1035,740);
		bp.setVisible(true);
	}
}*/