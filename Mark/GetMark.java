package awt_prg;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GetMark implements ActionListener,KeyListener
{
	
	private JFrame frm;
	public JTextField txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8;
	private Label la1,la2,la3,la4,la5,la6,la7,la8,la9;
	private Font hf,fi;
	private JButton b1,b2,b3;
	public int m1,m2,m3,m4,m5,tot;
	public String na;
	public double avg;
	
	public void calcMeth()
	{
		
		hf=new Font("Argerian",Font.BOLD,50);
		fi=new Font("Arial",Font.BOLD,20);
		GraphicsEnvironment eg=GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle s = eg.getMaximumWindowBounds();
		int w=s.width;
		int h=s.height;
		
		la1=new Label("Shivashri Academy");
		la1.setFont(hf);
		la1.setForeground(Color.MAGENTA);
		la2=new Label("Mark Calculating Application");
		la2.setFont(hf);
		la2.setForeground(Color.blue);
		
		la3=new Label("Name");
		la3.setFont(fi);
		la3.setForeground(Color.black);
		la4=new Label("Roll No");
		la4.setFont(fi);
		la4.setForeground(Color.black);
		la5=new Label("Tamil");
		la5.setFont(fi);
		la5.setForeground(Color.black);
		la6=new Label("English");
		la6.setFont(fi);
		la6.setForeground(Color.black);
		la7=new Label("Maths");
		la7.setFont(fi);
		la7.setForeground(Color.black);
		la8=new Label("Science");
		la8.setFont(fi);
		la8.setForeground(Color.black);
		la9=new Label("Computer Science");
		la9.setFont(fi);
		la9.setForeground(Color.black);
		
		txt1=new JTextField(20);
		txt1.setFont(fi);
		txt1.setForeground(Color.RED);
		
		txt2=new JTextField(20);
		txt2.setFont(fi);
		txt2.setForeground(Color.RED);
		
		txt3=new JTextField(20);
		txt3.setFont(fi);
		txt3.setForeground(Color.RED);
		txt4=new JTextField(20);
		txt4.setFont(fi);
		txt4.setForeground(Color.RED);
		txt5=new JTextField(20);
		txt5.setFont(fi);
		txt5.setForeground(Color.RED);
		txt6=new JTextField(20);
		txt6.setFont(fi);
		txt6.setForeground(Color.RED);
		txt7=new JTextField(20);
		txt7.setFont(fi);
		txt7.setForeground(Color.RED);	
		
		b1=new JButton("New");
		b1.setFont(fi);
		b1.setForeground(Color.GREEN);
		b1.setBackground(Color.YELLOW);
		
		b2=new JButton("Calculate");
		b2.setFont(fi);
		b2.setForeground(Color.GREEN);
		b2.setBackground(Color.YELLOW);
		
		b3=new JButton("Exit");
		b3.setFont(fi);
		b3.setForeground(Color.GREEN);
		b3.setBackground(Color.YELLOW);
		
		
		frm=new JFrame("Mark Calculation");
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
		frm.add(txt1);
		frm.add(txt2);
		frm.add(txt3);
		frm.add(txt4);
		frm.add(txt5);
		frm.add(txt6);
		frm.add(txt7);
		frm.add(b1);
		frm.add(b2);
		frm.add(b3);
		
		la1.setBounds(650,20, 600, 70);
		la2.setBounds(500,100, 800, 70);
		la3.setBounds(650,200, 200, 70);
		la4.setBounds(650,300, 200, 70);
		la5.setBounds(650,400, 200, 70);
		la6.setBounds(650,500, 200, 70);
		la7.setBounds(650,600, 200, 70);
		la8.setBounds(650,700, 200, 70);
		la9.setBounds(650,800, 200, 70);
		
		txt1.setBounds(850,200, 200, 40);
		txt2.setBounds(850,300, 200, 40);
		txt3.setBounds(850,400, 200, 40);
		txt4.setBounds(850,500, 200, 40);
		txt5.setBounds(850,600, 200, 40);
		txt6.setBounds(850,700, 200, 40);
		txt7.setBounds(850,800, 200, 40);
		
		b1.setBounds(500,900, 200, 40);
		b2.setBounds(750,900, 200, 40);
		b3.setBounds(1000,900, 200, 40);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		txt1.addKeyListener(this);
		txt2.addKeyListener(this);
		txt3.addKeyListener(this);
		txt4.addKeyListener(this);
		txt5.addKeyListener(this);
		txt6.addKeyListener(this);
		txt7.addKeyListener(this);
		
		frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
		frm.setVisible(true);
		
	}
	
	public void clrTxt()
	{
		txt1.setText(" ");
		txt2.setText(" ");
		txt3.setText(" ");
		txt4.setText(" ");
		txt5.setText(" ");
		txt6.setText(" ");
		txt7.setText(" ");
		txt8.setText(" ");
		
		txt1.requestFocus();
		return;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{
			clrTxt();
		}
		
		if(e.getSource()==b2)
		{
			try
			{
			na=txt1.getText();
			m1 = Integer.parseInt(txt3.getText());
			m2 = Integer.parseInt(txt4.getText());
			m3 = Integer.parseInt(txt5.getText());
			m4 = Integer.parseInt(txt6.getText());
			m5 = Integer.parseInt(txt7.getText());
			tot=m1+m2+m3+m4+m5;
			avg=tot/5;
			//System.out.println(tot);
			//System.out.println(avg);
			CalMark cm=new CalMark();
			cm.res();
			frm.dispose();
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, "Invalid Input");
				clrTxt();
			}
			
		}
		
		if(e.getActionCommand()=="Exit")
		{
			JOptionPane.showMessageDialog(null, "Thanks For Visiting....! \n Come Again....!");
			frm.dispose();
		}
		
	}
	public static void main(String[] args)
	{
		GetMark Gm=new GetMark();
		Gm.calcMeth();

	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		
		if(e.getSource()==txt1 && e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			txt2.requestFocus();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
