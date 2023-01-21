package gad_management;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateProduct extends JFrame {
	Container c;
    JLabel label1,label2,label3,label4,label5;
    JTextField product_id,product_type,product_capacity,product_price;
    JButton update_producttype,update_productcapacity,update_productprice;
    UpdateProduct(){
    	setTitle("Update product");
		setSize(1920,1080);

	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	     
	    c=getContentPane();
	    c.setLayout(null);
	    Color col=new Color(255, 182, 193);
        getContentPane().setBackground(col);
        
	    label1=new JLabel("Product Id");
	    label1.setForeground(new Color(165, 42, 42));
	    label1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        label2=new JLabel("Update Product");
        label2.setFont(new Font("Castellar", Font.PLAIN, 42));
        label3=new JLabel("Type");
        label3.setForeground(new Color(165, 42, 42));
        label3.setFont(new Font("Tahoma", Font.PLAIN, 25));
        label4=new JLabel("Stock ");
        label4.setForeground(new Color(165, 42, 42));
        label4.setFont(new Font("Tahoma", Font.PLAIN, 25));
        label5=new JLabel(" Price");
        label5.setForeground(new Color(165, 42, 42));
        label5.setFont(new Font("Tahoma", Font.PLAIN, 24));
        
        
        label1.setBounds(781,335,145,37);
        label2.setBounds(765,199,464,88);
        label3.setBounds(846,453,100,31);
        label4.setBounds(851,550,82,31);
        label5.setBounds(846,646,100,20);
       
        
        c.add(label1);
        c.add(label2);
        c.add(label3);
        c.add(label4);
        c.add(label5);
        
        product_id=new JTextField();
        product_id.setBounds(1069,343,162,37);
        c.add(product_id);
        
        product_type=new JTextField();
        product_type.setBounds(994,459,127,31);
        c.add(product_type);
        
        product_capacity=new JTextField();
        product_capacity.setBounds(994,550,127,31);
        c.add(product_capacity);
        
        product_price=new JTextField();
        product_price.setBounds(994,647,127,31);
        c.add(product_price);
        
        
        update_producttype=new JButton();
        update_producttype.setForeground(new Color(240, 255, 240));
        update_producttype.setFont(new Font("Tahoma", Font.PLAIN, 20));
        update_producttype.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		update_producttype(e);
        	}
        });
        
        update_producttype.setText("Update");
        update_producttype.setBackground(new Color(165, 42, 42));
        update_producttype.setBounds(1194,453,114,37);
        c.add(update_producttype);
        
        update_productcapacity=new JButton();
        update_productcapacity.setForeground(new Color(240, 255, 240));
        update_productcapacity.setFont(new Font("Tahoma", Font.PLAIN, 20));
        update_productcapacity.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		update_productcapacity(e);
        	}
        });
        
        update_productcapacity.setText("Update");
        update_productcapacity.setBackground(new Color(165, 42, 42));
        update_productcapacity.setBounds(1193,546,115,31);
        c.add(update_productcapacity);
        
        update_productprice=new JButton();
        update_productprice.setForeground(new Color(240, 255, 240));
        update_productprice.setFont(new Font("Tahoma", Font.PLAIN, 20));
        update_productprice.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		update_productprice(e);
        	}
        });
        
        update_productprice.setText("Update");
        update_productprice.setBackground(new Color(165, 42, 42));
        update_productprice.setBounds(1194,643,114,31);
        c.add(update_productprice);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setBounds(0, 0, 21, 1041);
        getContentPane().add(panel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.BLACK);
        panel_1.setBounds(21, 0, 1883, 20);
        getContentPane().add(panel_1);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.BLACK);
        panel_2.setBounds(1883, 0, 21, 1030);
        getContentPane().add(panel_2);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(Color.BLACK);
        panel_3.setBounds(21, 1020, 1896, 21);
        getContentPane().add(panel_3);
        
        
        JButton HomePage=new JButton("Home");
        HomePage.setForeground(new Color(240, 248, 255));
        HomePage.setBackground(new Color(165, 42, 42));
        HomePage.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		homepage(e);
        	}
        });
        HomePage.setBounds(1671,22,100,47);
        c.add(HomePage);
        JButton SignOut=new JButton("Signout");
        SignOut.setForeground(new Color(240, 248, 255));
        SignOut.setBackground(new Color(165, 42, 42));
        SignOut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		signout(e);
        	}
        });
        SignOut.setBounds(1781,22,100,47);
        c.add(SignOut);
        
        ImageIcon background_image=new ImageIcon("E:\\update.jpg");
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
      
	    
    }
    public void homepage(ActionEvent e) {
		AdminPanel ap=new AdminPanel();
		ap.show();
	}
	public void signout(ActionEvent e) {
		LoginPage lp=new LoginPage();
		lp.show();
	}
	
    public void update_producttype(ActionEvent e) {
    	try{

            try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/product_management","Amal","AmalKrishna@7736");
		    	} catch (ClassNotFoundException e1) {
		    		e1.printStackTrace();
		    	} 
	        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/product_management","Amal","AmalKrishna@7736");

			
			    String productid=product_id.getText();
			    String producttype=product_type.getText();
			    PreparedStatement ps=conn.prepareStatement("Update product_details set product_type=? where product_id=?");
			    ps.setString(2,productid );
			    ps.setString(1,producttype );
			    int i=ps.executeUpdate();
			    if(i>0) {
			    	JOptionPane.showMessageDialog(this,i+" records updated");
			    	product_type.setText("");
			    }
			    else {
			    	JOptionPane.showMessageDialog(this, "product Id Not Found");
			    }
			    conn.close();
			}
			catch(SQLException et)
			{
				System.out.println(et.getMessage());
			}
    }
    
    
	public void update_productcapacity(ActionEvent e) {
		try{

            try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/product_management","Amal","AmalKrishna@7736");
		    	} catch (ClassNotFoundException e1) {
		    		e1.printStackTrace();
		    	} 
	        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/product_management","Amal","AmalKrishna@7736");

			
			    String productid=product_id.getText();
			    String productcapacity=product_capacity.getText();
			    PreparedStatement ps=conn.prepareStatement("Update product_details set product_capacity=? where product_id=?");
			    ps.setString(2,productid );
			    ps.setString(1,productcapacity );
			    int i=ps.executeUpdate();
			    if(i>0) {
			    	JOptionPane.showMessageDialog(this,i+" records updated");
			    	product_capacity.setText("");
			    }
			    else {
			    	JOptionPane.showMessageDialog(this, "product Id Not Found");
			    }
			    conn.close();
			}
			catch(SQLException et)
			{
				System.out.println(et.getMessage());
			}
	 }
	
	
	public void update_productprice(ActionEvent e) {
		try{

            try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gad_management","root","rav3nf0@sql");
		    	} catch (ClassNotFoundException e1) {
		    		e1.printStackTrace();
		    	} 
	        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gad_management","root","rav3nf0@sql");

			
			    String productid=product_id.getText();
			    String productprice=product_price.getText();
			    PreparedStatement ps=conn.prepareStatement("Update product_details set product_price=? where product_id=?");
			    ps.setString(2,productid );
			    ps.setString(1,productprice );
			    int i=ps.executeUpdate();
			    if(i>0) {
			    	JOptionPane.showMessageDialog(this,i+" records updated");
			    	product_price.setText("");
			    }
			    else {
			    	JOptionPane.showMessageDialog(this, "product Id Not Found");
			    }
			    conn.close();
			}
			catch(SQLException et)
			{
				System.out.println(et.getMessage());
			}
	}
	
}
