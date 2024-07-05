package LibPrg;

//import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LoginPrg implements ActionListener
{
	JFrame frm;
	JButton b1,b2,b3;
	JTextField t1,t2,t3;
	Choice ch;
	Font f1,f2;
	Image img;
	ImageIcon imc;
	JLabel l1,l2,l3,l4,l5,iml;
	public void frame()
	{
		
		f1=new Font("Arial",Font.CENTER_BASELINE,50);
		f2=new Font("Arial",Font.BOLD,30);
		
		img=Toolkit.getDefaultToolkit().getImage("logo.png");
		img=img.getScaledInstance(800,500 , Image.SCALE_SMOOTH);
		imc=new ImageIcon(img);
		iml=new JLabel(imc);
		
		l1=new JLabel("Login Here....");
		l1.setFont(f1);
		l1.setBounds(50,100,1100,100);
		l1.setForeground(Color.magenta);
		l2=new JLabel("User Name");
		l2.setFont(f2);
		l2.setBounds(100,250,300,100);
		l2.setForeground(Color.BLACK);
		l3=new JLabel("Password");
		l3.setFont(f2);
		l3.setBounds(100,350,300,100);
		l3.setForeground(Color.BLACK);
		l4=new JLabel("Type");
		l4.setFont(f2);
		l4.setBounds(100,450,300,100);
		l4.setForeground(Color.BLACK);
		
		t1=new JTextField(20);
		t1.setBounds(400,265,400,50);
		t2=new JTextField(20);
		t2.setBounds(400,365,400,50);
		
		ch=new Choice();
		ch.add("Admin");
		ch.add("User");
		ch.setBounds(400,480,400,80);
		
		b1=new JButton("Sign In");
		b2=new JButton("Reset");
		b3=new JButton("Sign Out");
		
		b1.setBounds(50,600,200,50);
		b2.setBounds(350,600,200,50);
		b3.setBounds(650,600,200,50);
		
		iml.setBounds(850,250,600,350);
		
		frm=new JFrame("Library Management System");
		frm.setSize(1500,1000);
		frm.setLocationRelativeTo(frm);
		frm.setLayout(null);
		frm.add(l1);
		frm.add(l2);
		frm.add(t1);
		frm.add(l3);
		frm.add(t2);
		frm.add(l4);
		frm.add(ch);
		frm.add(iml);
		frm.add(b1);
		frm.add(b2);
		frm.add(b3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		frm.getContentPane().setBackground(Color.cyan);
		frm.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		LoginPrg lp=new LoginPrg();
		lp.frame();
		

	}

	public void actionPerformed(ActionEvent e) 
	{
		 String x=t1.getText();
		 String y=t2.getText();
		if(e.getSource()==b1)
		{
			try
			{
			if(x.equals("") && y.equals(""))
			{
				JOptionPane.showMessageDialog(frm,"Enter the Username & Password..");
			}
			
			else if(x.equals("Arun") && y.equals("Arun@123"))
			{
				
				HomePrg hp=new HomePrg();
				hp.homefrm();
				frm.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(frm,"Enter the valid Username & Password..");
			}
			}
			catch(Exception e1)
			{
					JOptionPane.showMessageDialog(frm,e1);
			}
		}
		
		if(e.getSource()==b2)
		{
			t1.setText(" ");
			t2.setText(" ");
			t1.setFocusable(true);
		}
		if(e.getSource()==b3)
		{
			JOptionPane.showMessageDialog(frm,"Thank You...");
			frm.dispose();
		}
	}

}
