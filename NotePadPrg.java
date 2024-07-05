package awt_prg;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class NotePadPrg implements ActionListener
{

	JPanel j1,j2,j3;
	JFrame frm;
	Button b1,b2,b3,b4,b5;
	Font f1;
	Label l1,l2;
	TextArea t1;
	TextField txt1;
	JMenuBar mb;
	JMenu m1,m2,m3;
	JMenuItem mi1,mi2,mi3,mi4,mi5;
	String fn,fd,fo;
	File fi;
	
	public void padMeth()
	{
		GraphicsEnvironment gs = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle ss = gs.getMaximumWindowBounds();
		int a=ss.width;
		int b=ss.height;
		
		m1=new JMenu("File");
		mi1=new JMenuItem("Open");
		mi2=new JMenuItem("Close");
		m1.add(mi1);
		m1.add(mi2);
		
		m2=new JMenu("Edit");
		mi3=new JMenuItem("Undo");
		mi4=new JMenuItem("Redo");
		m2.add(mi3);
		m2.add(mi4);
		
		m3=new JMenu("Help");
		mi5=new JMenuItem("Browse");
		m3.add(mi5);
		
		mb=new JMenuBar();
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		
		b1=new Button("New");
		b2=new Button("Save");
		b3=new Button("Open");
		b4=new Button("Print");
		b5=new Button("Exit");
		
		b1.setPreferredSize(new Dimension(250,100));
		b2.setPreferredSize(new Dimension(250,100));
		b3.setPreferredSize(new Dimension(250,100));
		b4.setPreferredSize(new Dimension(250,100));
		b5.setPreferredSize(new Dimension(250,100));
		
		b2.setEnabled(false);
		b3.setEnabled(false);
		b4.setEnabled(false);
		b5.setEnabled(false);
		
		j1=new JPanel();
		j1.setLayout(new FlowLayout());
		j1.add(b1);
		j1.add(b2);
		j1.add(b3);
		j1.add(b4);
		j1.add(b5);
		j1.setPreferredSize(new Dimension(300,30));
		j1.setBackground(Color.YELLOW);
		
		t1=new TextArea();
		t1.setPreferredSize(new Dimension(1600,800));
		j2=new JPanel();
		j2.add(t1);
		j2.setVisible(false);
		
		f1=new Font("Arial",Font.BOLD,30);
		l1=new Label("File Name");
		l1.setFont(f1);
		l1.setForeground(Color.magenta);
		txt1=new TextField(30);
		j3=new JPanel();
		j3.add(l1);
		j3.add(txt1);
		j3.setLayout(new FlowLayout());
		j3.setBackground(Color.lightGray);
		j3.setPreferredSize(new Dimension(10,150));
		
		frm=new JFrame("Your Notes");
		frm.setSize(a,b);
		frm.getContentPane().setBackground(Color.CYAN);
		frm.setLayout(new BorderLayout());
		frm.setJMenuBar(mb);
		frm.add(j1,BorderLayout.WEST);
		frm.add(j2,BorderLayout.CENTER);
		frm.add(j3,BorderLayout.SOUTH);
		b1.addActionListener(this);	
		b2.addActionListener(this);
		b3.addActionListener(this);
		b5.addActionListener(this);
		frm.setVisible(true);
		
		
	}
	public static void main(String[] args) 
	{
		NotePadPrg np=new NotePadPrg();
		np.padMeth();

	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		fn=txt1.getText();
		fd=t1.getText();
		
		if(e.getSource()==b1)
		{
			j2.setVisible(true);
			b2.setEnabled(true);
			b3.setEnabled(true);
			b4.setEnabled(true);
			b5.setEnabled(true);
			t1.setText(" ");
			t1.requestFocus();
		}
		if(e.getSource()==b5)
		{
			j2.setVisible(false);
			b2.setEnabled(false);
			b3.setEnabled(false);
			b4.setEnabled(false);
			b5.setEnabled(false);
		}
		
		if(e.getSource()==b2)
		{
			fi=new File(fn);
			
			try
			{
				FileWriter fw=new FileWriter(fi);
				fw.write(fd);
				System.out.println("File Saved");
				fw.close();
			}
			catch(Exception e2)
			{
				System.out.println(e2);
			}
		}
		
		if(e.getSource()==b3)
		{
			j2.setVisible(true);
			t1.setText(" ");
			fi=new File(fn);
			try
			{
			FileReader fr=new FileReader(fi);
			long size = fi.length();
			char[] data=new char[(int) size];
			fr.read(data);
			System.out.println("File Opened");
			//System.out.println(data);
			fo=new String(data);
			t1.append(fo);
			fr.close();	
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
			
			
		}
		
		
	}
	
	
}
