package gad_management;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminPanel extends JFrame {

	 Container c;
	 JLabel label1;
	 JButton addairline,deleteairline,updateairline;
	 AdminPanel()
	 {
		 setTitle("AdminPage");
		 setSize(1920,1080);
	     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	     
	     c=getContentPane();
	     c.setLayout(null);
	     
	     Color col=new Color(255, 182, 193);
	        getContentPane().setBackground(Color.CYAN);
	        
	     addairline=new JButton("Add Product");
	     addairline.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     	}
	     });
	     addairline.setForeground(Color.WHITE);
	     addairline.setFont(new Font("Tahoma", Font.PLAIN, 18));
	     
	     
	     addairline.setBackground(new Color(0, 100, 0));
	     addairline.setBounds(545,305,174,39);
	     c.add(addairline);
	     
	     
	     
	     updateairline=new JButton("Update Products");
	     updateairline.setForeground(Color.WHITE);
	     updateairline.setFont(new Font("Tahoma", Font.PLAIN, 18));
	     
	     updateairline.setBackground(new Color(0, 100, 0));
	     updateairline.setBounds(814,305,180,39);
	     c.add(updateairline);
	     
	     
	     
	     deleteairline=new JButton("Delete Products");
	     deleteairline.setForeground(Color.WHITE);
	     deleteairline.setFont(new Font("Tahoma", Font.PLAIN, 18));
	     
	     deleteairline.setBackground(new Color(0, 100, 0));
	     deleteairline.setBounds(1080,305,180,39);
	     c.add(deleteairline);
	        
	        label1=new JLabel("Admin Page");
	        label1.setBounds(727, 175, 374, 98);
	        getContentPane().add(label1);
	        label1.setForeground(new Color(0, 0, 0));
	        label1.setBackground(new Color(0, 0, 128));
	        label1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD | Font.ITALIC, 48));
	        
	        
	     
	     setVisible(true);

	 }/*
	 private void addairline(ActionEvent e) {
		 AddAirline ar=new AddAirline();
		 ar.show();
	 }
	 
	 private void updateairline(ActionEvent e) {
		 UpdateAirline ua=new UpdateAirline();
		 ua.show();
	 }
	 
	 private void deleteairline(ActionEvent e) {
		 DeleteAirline da=new DeleteAirline() ;
		 da.show();
	 }

	 private void addairport(ActionEvent e) {
		 AddAirport aa=new AddAirport();
		 aa.show();
	 }

	 private void updateairport(ActionEvent e) {
		 UpdateAirport uaa=new UpdateAirport();
		 uaa.show();
	 }

	 private void deleteairport(ActionEvent e) {
		 DeleteAirport daa=new DeleteAirport();
		 daa.show();
	 }
*/
	
	}

	


