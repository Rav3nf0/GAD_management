package gad_management;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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


public class DeleteProduct extends JFrame {
	Container c;
	JLabel label1,label2;
	JTextField airline_id;
	JButton delete_airlinedetail;
	DeleteProduct()
	{
		setTitle("Delete Airline");
		setSize(1920,1080);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	     
	    c=getContentPane();
	    c.setLayout(null);
	    
	    Color col=new Color(255, 182, 193);
        getContentPane().setBackground(col);
        
	    label1=new JLabel("Product Id");
	    label1.setForeground(new Color(165, 42, 42));
	    label1.setFont(new Font("Tahoma", Font.PLAIN, 21));
        label2=new JLabel("Delete Product");
        label2.setFont(new Font("Castellar", Font.PLAIN, 43));
        
        label1.setBounds(739,373,120,39);
        label2.setBounds(772,178,521,105);
        
        
        c.add(label1);
        c.add(label2);
      
        airline_id=new JTextField();
        airline_id.setBounds(988,377,186,39);
        c.add(airline_id);
        
       
  
        delete_airlinedetail=new JButton();
        delete_airlinedetail.setForeground(new Color(240, 255, 240));
        delete_airlinedetail.setFont(new Font("Tahoma", Font.PLAIN, 30));
        delete_airlinedetail.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		deleteairline(e);
        	}
        });
        delete_airlinedetail.setBackground(new Color(165, 42, 42));
        delete_airlinedetail.setText("Delete");
        delete_airlinedetail.setBounds(842,476,172,49);
        c.add(delete_airlinedetail);
        
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
	
	public void deleteairline(ActionEvent e) {
		try{

            try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gad_management","root","rav3nf0@sql");
		    	} catch (ClassNotFoundException e1) {
		    		e1.printStackTrace();
		    	} 
            	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gad_management","root","rav3nf0@sql");

			
			    String airlineid=airline_id.getText();
			    PreparedStatement ps=conn.prepareStatement("DELETE FROM AIRLINE_DETAILS WHERE AIRLINE_ID=?");
			    ps.setString(1,airlineid );
			    int i=ps.executeUpdate();
			    if(i>0) {
			    	JOptionPane.showMessageDialog(this,i+" records updated");
			    	airline_id.setText("");
			    }
			    else {
			    	JOptionPane.showMessageDialog(this, "Product Id Not Found");
			    }
			    conn.close();
			}
			catch(SQLException et)
			{
				System.out.println(et.getMessage());
			}
	}
	
}