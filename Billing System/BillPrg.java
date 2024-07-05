package Shivashri_prg;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

public class BillPrg extends BillMeth implements ActionListener,KeyListener
{
	 JFrame frm;
	 JTextField t1,t2,t3,t4,t5,t7,t8,t9,t10,bn;
	 JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,cb;
	 Choice t6;
	 Font hf,fi;
	 JButton b1,b2,b3,b4;
	 Connection con;
	 Statement st;
	 ResultSet rs;
	 PreparedStatement pst;
	 String sql,date,sdate,ddate,corse,name,address;
	 Date d;
	 SimpleDateFormat sdf;
	 int bno,fee,received,balance,paid,rr,b;
	 long phone;
	 
	 
	 public BillPrg()
		{
			d=new Date();
			sdf=new SimpleDateFormat("dd-MM-yyyy");
			date=sdf.format(d);
			
			hf=new Font("Argerian",Font.BOLD,50);
			fi=new Font("Arial",Font.BOLD,20);
			
			l1=new JLabel("Payment Detail");
			l1.setFont(hf);
			l1.setForeground(Color.YELLOW);
			l2=new JLabel("Bill No");
			l2.setFont(fi);
			l2.setForeground(Color.black);
			
			l3=new JLabel("Date");
			l3.setFont(fi);
			l3.setForeground(Color.black);
			l4=new JLabel("Name");
			l4.setFont(fi);
			l4.setForeground(Color.black);
			l5=new JLabel("Address");
			l5.setFont(fi);
			l5.setForeground(Color.black);
			l6=new JLabel("Phone No");
			l6.setFont(fi);
			l6.setForeground(Color.black);
			l7=new JLabel("Courses");
			l7.setFont(fi);
			l7.setForeground(Color.black);
			l8=new JLabel("Fees");
			l8.setFont(fi);
			l8.setForeground(Color.black);
			l9=new JLabel("Paid");
			l9.setFont(fi);
			l9.setForeground(Color.black);
			l10=new JLabel("Received");
			l10.setFont(fi);
			l10.setForeground(Color.black);
			l11=new JLabel("Balance");
			l11.setFont(fi);
			l11.setForeground(Color.black);
			
			cb=new JLabel("Bill Details");
			cb.setFont(fi);
			cb.setForeground(Color.black);
			
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shivashridb","root","");
			st=con.createStatement();
			rs=st.executeQuery("select bno from bill");
			while(rs.next())
			{
			  bno=rs.getInt(1)+1;
			}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			t1=new JTextField(20);
			t1.setFont(fi);
			t1.setForeground(Color.RED);
			t1.setEditable(false);
			t1.setText(Integer.toString(bno));
			
			t2=new JTextField(20);
			t2.setFont(fi);
			t2.setForeground(Color.RED);
			t2.setEditable(false);
			t2.setText(date);
			t3=new JTextField(20);
			t3.setFont(fi);
			t3.setForeground(Color.RED);
			t4=new JTextField(20);
			t4.setFont(fi);
			t4.setForeground(Color.RED);
			t5=new JTextField(20);
			t5.setFont(fi);
			t5.setForeground(Color.RED);
			t6=new Choice();
			t6.add("Java-J2SE(console)");
			t6.add("Java-J2SE(GUI)");
			t6.add("C/C++");
			t6.add("Web Development");
			t7=new JTextField(20);
			t7.setFont(fi);
			t7.setForeground(Color.RED);
			t7.setEditable(false);
			t8=new JTextField(20);
			t8.setFont(fi);
			t8.setForeground(Color.RED);
			t9=new JTextField(20);
			t9.setFont(fi);
			t9.setForeground(Color.RED);
			t9.setEditable(false);
			t10=new JTextField(20);
			t10.setFont(fi);
			t10.setForeground(Color.RED);
			t10.setEditable(false);
			
			bn=new JTextField(20);
			bn.setFont(fi);
			bn.setForeground(Color.RED);
			
			b1=new JButton("New");
			b1.setFont(fi);
			b1.setForeground(Color.GREEN);
			b1.setBackground(Color.YELLOW);
			
			b2=new JButton("Save");
			b2.setFont(fi);
			b2.setForeground(Color.GREEN);
			b2.setBackground(Color.YELLOW);
			
			b3=new JButton("Print");
			b3.setFont(fi);
			b3.setForeground(Color.GREEN);
			b3.setBackground(Color.YELLOW);
			
			b4=new JButton("Exit");
			b4.setFont(fi);
			b4.setForeground(Color.GREEN);
			b4.setBackground(Color.YELLOW);
			
			
			frm=new JFrame("Payment Page");
			frm.setSize(800,1200);
			frm.setResizable(false);
			frm.setLayout(null);
			frm.getContentPane().setBackground(new Color(204,37,217));
			frm.setLocationRelativeTo(frm);
			frm.add(l1);
			frm.add(l2);
			frm.add(l3);
			frm.add(l4);
			frm.add(l5);
			frm.add(l6);
			frm.add(l7);
			frm.add(l8);
			frm.add(l9);
			frm.add(l10);
			frm.add(l11);
			frm.add(cb);
			frm.add(t1);
			frm.add(t2);
			frm.add(t3);
			frm.add(t4);
			frm.add(t5);
			frm.add(t6);
			frm.add(t7);
			frm.add(t8);
			frm.add(t9);
			frm.add(t10);
			frm.add(bn);
			frm.add(b1);
			frm.add(b2);
			frm.add(b3);
			frm.add(b4);
			
			l1.setBounds(200,20,800,70);
			l2.setBounds(150,120,200,50);
			l3.setBounds(150,190,200,50);
			l4.setBounds(150,260,200,50);
			l5.setBounds(150,330,200,50);
			l6.setBounds(150,400,200,50);
			l7.setBounds(150,470,200,50);
			l8.setBounds(150,540,200,50);
			l9.setBounds(150,610,200,50);
			l10.setBounds(150,680,200,50);
			l11.setBounds(150,750,200,50);
			cb.setBounds(150,820,200,50);
			
			t1.setBounds(350,120,200,40);
			t2.setBounds(350,190,200,40);
			t3.setBounds(350,260,200,40);
			t4.setBounds(350,330,200,40);
			t5.setBounds(350,400,200,40);
			t6.setBounds(350,470,200,40);
			t7.setBounds(350,540,200,40);
			t8.setBounds(350,610,200,40);
			t9.setBounds(350,680,200,40);
			t10.setBounds(350,750,200,40);
			bn.setBounds(350,820,200,40);
			
			b1.setBounds(100,900, 150, 40);
			b2.setBounds(260,900, 150, 40);
			b3.setBounds(430,900, 150, 40);
			b4.setBounds(600,900, 150, 40);
			
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);
			
			
			t3.addKeyListener(this);
			t4.addKeyListener(this);
			t5.addKeyListener(this);
			t6.addKeyListener(this);
			t7.addKeyListener(this);
			t8.addKeyListener(this);
			bn.addKeyListener(this);
			
			
			frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
			frm.setVisible(true);
			
		}
	 
	 
	 public void resetMet()
		{
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t7.setText("");
			t8.setText("");
			t9.setText("");
			t10.setText("");
			bn.setText("");
			t3.requestFocus();
			t1.setText(Integer.toString(bno));
			t2.setText(date);
			return;
		}
	 
	 public void fee()
	 {
		 corse=t6.getSelectedItem();
		 if(corse=="C/C++" ||corse=="Java-J2SE(console)"|| corse=="Java-J2SE(GUI)")
		 {
			 t7.setText("10000");
		 }
		 else if(corse=="Web Development")
		 {
			 t7.setText("20000");
		 }
		 fee=Integer.parseInt(t7.getText());
		 t8.requestFocus();
		 return;
	 }
	public static void main(String[] args) 
	{
		BillPrg bp=new BillPrg();
		BillMeth bm=new BillMeth();

	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		
		if(e.getSource()==t3 && e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			t4.requestFocus();
		}
		if(e.getSource()==t4 && e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			t5.requestFocus();
		}
		if(e.getSource()==t5 && e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			t6.requestFocus();
		}
		if(e.getSource()==t6 && e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			fee();
		}
		
		if(e.getSource()==t8 && e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			try
			{
			 paid=Integer.parseInt(t8.getText());
			 if(paid<=fee)
			 {
				 received=Integer.parseInt(t9.getText());
				 t9.setText(Integer.toString(paid));
				 balance=fee-paid;
				 t10.setText(Integer.toString(balance));
			 }
			 else
			 {
				 JOptionPane.showMessageDialog(frm,"Enter a valid amount");
				 t8.setText("");				 
			 }
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
			b2.requestFocus();
		}
		if(e.getSource()==b2 && e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			setData();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		
		//
		
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		if(e.getSource()==bn)
		{
			try
			{
			b=Integer.parseInt(bn.getText());
			getData(b);
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand()=="New")
		{
			resetMet();
		}
		if(e.getActionCommand()=="Exit")
		{
			frm.dispose();
		}
		if(e.getSource()==b2)
		{
			setData();
		}
		if(e.getSource()==b3)
		{
			receipt();
			//frm.dispose();
		}
		
	}

}
