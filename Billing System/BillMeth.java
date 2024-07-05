 package Shivashri_prg;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.border.CompoundBorder;

public class BillMeth 
{
	JFrame frm;
	JWindow win;
	Font hf,fi;
	JButton wb;
	Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	String sql,date,sdate,ddate,corse,name,address;
	JTextField t1,t2,t3,t4,t5,t7,t8,t9,t10,bn;
	int bno,fee,received,balance,paid,rr,b;
	long phone;
	Choice t6;
	Date d;
	SimpleDateFormat sdf;
	
	
	public void receipt()
	 {
		 String title="         SHIVASHRI ACADEMY <br>"+"54-H,Hasthampatty Main Road,<br>"+"Hasthampatty,Salem - 636007";
		 JLabel ti1,iml;
		 Image img;
		 ImageIcon imc;
		 JPanel p1,p2,p3;
		 
		 hf=new Font("Arial",Font.BOLD,20);
		 fi=new Font("Arial",Font.BOLD,20);
			
		 img=Toolkit.getDefaultToolkit().getImage("pic1.png");
		 img=img.getScaledInstance(150,80,Image.SCALE_SMOOTH);
		 imc=new ImageIcon(img);
		 iml=new JLabel(imc);
		 
		 ti1=new JLabel("<html>"+title+"</html>");
		 ti1.setFont(fi);
		 ti1.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.black),BorderFactory.createLineBorder(Color.black)));		 
		 p1=new JPanel();
		 p1.setPreferredSize(new Dimension(750,450));
		 p1.setBackground(Color.white);
		 p1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		 
		 p2=new JPanel();
		 p2.setPreferredSize(new Dimension(700,100));
		 p2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		 p2.add(iml);
		 p2.add(ti1);
		 
		 p3=new JPanel();
		 p3.setPreferredSize(new Dimension(700,300));
		 p3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		 
		 p1.add(p2);
		 p1.add(p3);
		 wb=new JButton("Print");
		 win=new JWindow(frm);
		 win.setSize(800,600);
		 win.setLocationRelativeTo(win);
		 win.setLayout(new FlowLayout());
		 win.add(p1);
		 win.add(wb);
		 
		 win.setVisible(true);
		 return;
	 }
	 
	 
	 public void getData(int b)
		{
		 
		 
			try
			{
			sdf=new SimpleDateFormat("dd-MM-yyyy");
			rs=st.executeQuery("select * from bill where bno="+b+"");
			rs.next();
			ddate=sdf.format(rs.getString(2));
			t1.setText(Integer.toString(rs.getInt(1)));
			t2.setText(ddate);
			t3.setText(rs.getString(3));
			t4.setText(rs.getString(4));
			t5.setText(Long.toString(rs.getLong(5)));
			t6.setName(rs.getString(6));
			t7.setText(Integer.toString(rs.getInt(7)));
			t8.setText(Integer.toString(rs.getInt(8)));
			t9.setText(Integer.toString(rs.getInt(9)));
			t10.setText(Integer.toString(rs.getInt(10)));
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	 public String setData()
	 {
		 name=t3.getText();
		 address=t4.getText();
		 phone=Long.parseLong(t5.getText());
		 sdf=new SimpleDateFormat("yyyy-MM-dd");
		 sdate=sdf.format(d);
		 try
			{
			sql="insert into bill(bno,dop,name,address,phone,course,fees,paid,received,balance) values (?,?,?,?,?,?,?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setInt(1, bno);
			pst.setString(2,sdate);
			pst.setString(3,name);
			pst.setString(4,address );
			pst.setLong(5, phone);
			pst.setString(6, corse);
			pst.setInt(7,fee);
			pst.setInt(8,paid);
			pst.setInt(9,received);
			pst.setInt(10, balance);
			rr = pst.executeUpdate();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			 
		 if(rr==1)
			return "Record Saved...";
		else
			return "Record Not Saved...";
			
	 }


}
