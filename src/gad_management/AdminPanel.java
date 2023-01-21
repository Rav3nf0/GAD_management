package gad_management;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import gad_management.DeleteProduct;

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
	 JButton addproduct,deleteproduct,updateproduct;
	 AdminPanel()
	 {
		 setTitle("AdminPage");
		 setSize(1920,1080);
	     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	     
	     c=getContentPane();
	     c.setLayout(null);
	     
	     Color col=new Color(255, 182, 193);
	        getContentPane().setBackground(Color.CYAN);
	        
	     addproduct=new JButton("Add Product");
	     addproduct.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		AddProduct da=new AddProduct();
	     		da.show();
	     	}
	     });
	     addproduct.setForeground(Color.WHITE);
	     addproduct.setFont(new Font("Tahoma", Font.PLAIN, 18));
	     
	     
	     addproduct.setBackground(new Color(0, 100, 0));
	     addproduct.setBounds(545,305,180,47);
	     c.add(addproduct);
	     
	     
	     
	     updateproduct=new JButton("Update Products");
	     updateproduct.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		UpdateProduct du=new UpdateProduct();
	     		du.show();
	     	}
	     });
	     updateproduct.setForeground(Color.WHITE);
	     updateproduct.setFont(new Font("Tahoma", Font.PLAIN, 18));
	     
	     updateproduct.setBackground(new Color(0, 100, 0));
	     updateproduct.setBounds(814,305,189,47);
	     c.add(updateproduct);
	     
	     
	     
	     deleteproduct=new JButton("Delete Products");
	     deleteproduct.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		 DeleteProduct da=new DeleteProduct() ;
	    		 da.show();
	     	}
	     });
	     deleteproduct.setForeground(Color.WHITE);
	     deleteproduct.setFont(new Font("Tahoma", Font.PLAIN, 18));
	     
	     deleteproduct.setBackground(new Color(0, 100, 0));
	     deleteproduct.setBounds(1080,305,189,47);
	     c.add(deleteproduct);
	        
	        label1=new JLabel("Admin Page");
	        label1.setBounds(728, 168, 374, 98);
	        getContentPane().add(label1);
	        label1.setForeground(new Color(0, 0, 0));
	        label1.setBackground(new Color(0, 0, 128));
	        label1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD | Font.ITALIC, 50));
	        
	        ImageIcon background_image=new ImageIcon("E:\\admin.jpg");
	        Image img=background_image.getImage();
	        Image tempimag=img.getScaledInstance(1920,1080,Image.SCALE_SMOOTH);
	        background_image=new ImageIcon(tempimag);
	        JLabel background=new JLabel("",background_image,JLabel.CENTER);
	        background.setBounds(0,0,1920,1080);
	        c.add(background);
			//f.getContentPane().setBackground(Color.white);
			c.setLayout(null);
			c.setVisible(true);
		
	        setVisible(true);
	     
	     setVisible(true);

	 }
	
	}

	


