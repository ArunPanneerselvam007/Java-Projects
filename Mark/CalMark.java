package awt_prg;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CalMark extends GetMark implements ActionListener
{	
	private JFrame frm;
	private TextField tx1,tx2,tx3,tx4,tx5,tx6,tx7,tx8;
	private Label la1,la2,la3,la4,la5,la6,la7,la8,la9;
	private Font hf,fi;
	private Button b1,b2;
	String Grade;
	String ma1,ma2,ma3,ma4,ma5,tot1;
	double avg1;
	String nam;

public void res()
{
	ma1=txt3.getText();
	ma2=txt4.getText();
	System.out.println(ma1);
	System.out.println(ma2);
	
	hf=new Font("Argerian",Font.BOLD,50);
	fi=new Font("Arial",Font.BOLD,20);
	GraphicsEnvironment eg=GraphicsEnvironment.getLocalGraphicsEnvironment();
	Rectangle s = eg.getMaximumWindowBounds();
	int w=s.width;
	int h=s.height;
	
	la1=new Label(na+" ,Your Result....");
	la1.setFont(hf);
	la1.setForeground(Color.MAGENTA);
		
	la3=new Label("Tamil");
	la3.setFont(fi);
	la3.setForeground(Color.black);
	la4=new Label("English");
	la4.setFont(fi);
	la4.setForeground(Color.black);
	la5=new Label("Maths");
	la5.setFont(fi);
	la5.setForeground(Color.black);
	la6=new Label("Science");
	la6.setFont(fi);
	la6.setForeground(Color.black);
	la7=new Label("Computer Science");
	la7.setFont(fi);
	la7.setForeground(Color.black);
	la8=new Label("Total");
	la8.setFont(fi);
	la8.setForeground(Color.black);
	la9=new Label("Average");
	la9.setFont(fi);
	la9.setForeground(Color.black);
	la2=new Label("Grade");
	la2.setFont(fi);
	la2.setForeground(Color.blue);

	
	
	
	tx1=new TextField(20);
	tx1.setFont(fi);
	tx1.setForeground(Color.RED);
	tx1.setText(Integer.toString(m1));
	
	tx2=new TextField(20);
	tx2.setFont(fi);
	tx2.setForeground(Color.RED);
	tx2.setText(Integer.toString(m2));
	
	tx3=new TextField(20);
	tx3.setFont(fi);
	tx3.setForeground(Color.RED);
	tx3.setText(Integer.toString(m3));
	tx4=new TextField(20);
	tx4.setFont(fi);
	tx4.setForeground(Color.RED);
	tx4.setText(Integer.toString(m4));
	tx5=new TextField(20);
	tx5.setFont(fi);
	tx5.setForeground(Color.RED);
	tx5.setText(Integer.toString(m5));
	tx6=new TextField(20);
	tx6.setFont(fi);
	tx6.setForeground(Color.RED);
	tx6.setText(Integer.toString(tot));
	tx7=new TextField(20);
	tx7.setFont(fi);
	tx7.setForeground(Color.RED);
	tx7.setText(Double.toString(avg));
	
	tx8=new TextField(20);
	tx8.setFont(fi);
	tx8.setForeground(Color.RED);
	tx8.setText((grade(avg)));
	
	
	b1=new Button("Back");
	b1.setFont(fi);
	b1.setForeground(Color.GREEN);
	b1.setBackground(Color.YELLOW);
	
	b2=new Button("Exit");
	b2.setFont(fi);
	b2.setForeground(Color.GREEN);
	b2.setBackground(Color.YELLOW);
		
	frm=new JFrame("Result");
	frm.setSize(w, h);
	frm.setLayout(null);
	frm.getContentPane().setBackground(Color.cyan);
	frm.add(la1);
	frm.add(la2);
	frm.add(la3);
	frm.add(la4);
	frm.add(la5);
	frm.add(la6);
	frm.add(la7);
	frm.add(la8);
	frm.add(la9);
	frm.add(tx1);
	frm.add(tx2);
	frm.add(tx3);
	frm.add(tx4);
	frm.add(tx5);
	frm.add(tx6);
	frm.add(tx7);
	frm.add(tx8);
	frm.add(b1);
	frm.add(b2);
	
	la1.setBounds(650,20, 600, 70);
	la3.setBounds(650,100, 200, 70);
	la4.setBounds(650,200, 200, 70);
	la5.setBounds(650,300, 200, 70);
	la6.setBounds(650,400, 200, 70);
	la7.setBounds(650,500, 200, 70);
	la8.setBounds(650,600, 200, 70);
	la9.setBounds(650,700, 200, 70);
	la2.setBounds(650,800, 200, 70);
	
	tx1.setBounds(850,100, 200, 40);
	tx2.setBounds(850,200, 200, 40);
	tx3.setBounds(850,300, 200, 40);
	tx4.setBounds(850,400, 200, 40);
	tx5.setBounds(850,500, 200, 40);
	tx6.setBounds(850,600, 200, 40);
	tx7.setBounds(850,700, 200, 40);
	tx8.setBounds(850,800, 200, 40);
	
	b1.setBounds(500,900, 200, 40);
	b2.setBounds(750,900, 200, 40);
		
	b1.addActionListener(this);
	b2.addActionListener(this);
	
	frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
	frm.setVisible(true);
}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			calcMeth();
			frm.dispose();
		}
		if(e.getActionCommand()=="Exit")
		{
			JOptionPane.showMessageDialog(null, "Thanks For Visiting....! \n Come Again....!");
			System.exit(0);
		}
		
	}
	public String grade(double x)
	{
		if(avg==100)
			Grade="O";
		else if(avg>=90 && avg<100)
			Grade="A";
		else if(avg>=70 && avg<90)
			Grade="B";
		else if(avg>=50 && avg<70)
			Grade="C";
		else
			Grade="F";
		return Grade;
		
	}

}
