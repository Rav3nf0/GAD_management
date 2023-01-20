package gad_management;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class UpdateProduuct extends JFrame {
	Container c;
    JLabel label1,label2,label3,label4,label5;
    JTextField airline_id,airline_type,airline_capacity,airline_price;
    JButton update_airlinetype,update_airlinecapacity,update_airlineprice;
    UpdateProduuct(){
    	setTitle("Update Airline");
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
        
        airline_id=new JTextField();
        airline_id.setBounds(1069,343,162,37);
        c.add(airline_id);
        
        airline_type=new JTextField();
        airline_type.setBounds(994,459,127,31);
        c.add(airline_type);
        
        airline_capacity=new JTextField();
        airline_capacity.setBounds(994,550,127,31);
        c.add(airline_capacity);
        
        airline_price=new JTextField();
        airline_price.setBounds(994,647,127,31);
        c.add(airline_price);
        
        
        update_airlinetype=new JButton();
        update_airlinetype.setForeground(new Color(240, 255, 240));
        update_airlinetype.setFont(new Font("Tahoma", Font.PLAIN, 20));
        update_airlinetype.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		update_airlinetype(e);
        	}
        });
        
        update_airlinetype.setText("Update");
        update_airlinetype.setBackground(new Color(165, 42, 42));
        update_airlinetype.setBounds(1194,453,114,37);
        c.add(update_airlinetype);
        
        update_airlinecapacity=new JButton();
        update_airlinecapacity.setForeground(new Color(240, 255, 240));
        update_airlinecapacity.setFont(new Font("Tahoma", Font.PLAIN, 20));
        update_airlinecapacity.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		update_airlinecapacity(e);
        	}
        });
        
        update_airlinecapacity.setText("Update");
        update_airlinecapacity.setBackground(new Color(165, 42, 42));
        update_airlinecapacity.setBounds(1193,546,115,31);
        c.add(update_airlinecapacity);
        
        update_airlineprice=new JButton();
        update_airlineprice.setForeground(new Color(240, 255, 240));
        update_airlineprice.setFont(new Font("Tahoma", Font.PLAIN, 20));
        update_airlineprice.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		update_airlineprice(e);
        	}
        });
        
        update_airlineprice.setText("Update");
        update_airlineprice.setBackground(new Color(165, 42, 42));
        update_airlineprice.setBounds(1194,643,114,31);
        c.add(update_airlineprice);
        
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
	
    public void update_airlinetype(ActionEvent e) {
    	try{

            try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/flight_management","Amal","AmalKrishna@7736");
		    	} catch (ClassNotFoundException e1) {
		    		e1.printStackTrace();
		    	} 
	        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/flight_management","Amal","AmalKrishna@7736");

			
			    String airlineid=airline_id.getText();
			    String airlinetype=airline_type.getText();
			    PreparedStatement ps=conn.prepareStatement("Update airline_details set airline_type=? where airline_id=?");
			    ps.setString(2,airlineid );
			    ps.setString(1,airlinetype );
			    int i=ps.executeUpdate();
			    if(i>0) {
			    	JOptionPane.showMessageDialog(this,i+" records updated");
			    	airline_type.setText("");
			    }
			    else {
			    	JOptionPane.showMessageDialog(this, "Airline Id Not Found");
			    }
			    conn.close();
			}
			catch(SQLException et)
			{
				System.out.println(et.getMessage());
			}
    }
    
    
	public void update_airlinecapacity(ActionEvent e) {
		try{

            try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/flight_management","Amal","AmalKrishna@7736");
		    	} catch (ClassNotFoundException e1) {
		    		e1.printStackTrace();
		    	} 
	        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/flight_management","Amal","AmalKrishna@7736");

			
			    String airlineid=airline_id.getText();
			    String airlinecapacity=airline_capacity.getText();
			    PreparedStatement ps=conn.prepareStatement("Update airline_details set airline_capacity=? where airline_id=?");
			    ps.setString(2,airlineid );
			    ps.setString(1,airlinecapacity );
			    int i=ps.executeUpdate();
			    if(i>0) {
			    	JOptionPane.showMessageDialog(this,i+" records updated");
			    	airline_capacity.setText("");
			    }
			    else {
			    	JOptionPane.showMessageDialog(this, "Airline Id Not Found");
			    }
			    conn.close();
			}
			catch(SQLException et)
			{
				System.out.println(et.getMessage());
			}
	 }
	
	
	public void update_airlineprice(ActionEvent e) {
		try{

            try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/flight_management","Amal","AmalKrishna@7736");
		    	} catch (ClassNotFoundException e1) {
		    		e1.printStackTrace();
		    	} 
	        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/flight_management","Amal","AmalKrishna@7736");

			
			    String airlineid=airline_id.getText();
			    String airlineprice=airline_price.getText();
			    PreparedStatement ps=conn.prepareStatement("Update airline_details set airline_price=? where airline_id=?");
			    ps.setString(2,airlineid );
			    ps.setString(1,airlineprice );
			    int i=ps.executeUpdate();
			    if(i>0) {
			    	JOptionPane.showMessageDialog(this,i+" records updated");
			    	airline_price.setText("");
			    }
			    else {
			    	JOptionPane.showMessageDialog(this, "Airline Id Not Found");
			    }
			    conn.close();
			}
			catch(SQLException et)
			{
				System.out.println(et.getMessage());
			}
	}
	
}
