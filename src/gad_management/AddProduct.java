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

public class AddProduct extends JFrame {

	Container c;
	JLabel label1,label2,label3,label4,label5,label6;
	JTextField product_id,product_name,product_type,product_capacity,product_price;
	JButton add_productdetail;
	
	JButton HomePage,SignOut;
	
	AddProduct(){
		setTitle("Add product");
		setSize(1920,1080);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	     
	    c=getContentPane();
	    c.setLayout(null);
	    
	    Color col=new Color(255, 182, 193);
        getContentPane().setBackground(col);
        
	    label1=new JLabel("Product Id");
	    label1.setForeground(new Color(165, 42, 42));
	    label1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        label2=new JLabel("Product Name");
        label2.setForeground(new Color(165, 42, 42));
        label2.setFont(new Font("Tahoma", Font.PLAIN, 23));
        label3=new JLabel("Product Type");
        label3.setForeground(new Color(165, 42, 42));
        label3.setFont(new Font("Tahoma", Font.PLAIN, 23));
        label4=new JLabel("Product Stock");
        label4.setForeground(new Color(165, 42, 42));
        label4.setFont(new Font("Tahoma", Font.PLAIN, 23));
        label5=new JLabel(" Price");
        label5.setForeground(new Color(165, 42, 42));
        label5.setFont(new Font("Tahoma", Font.PLAIN, 25));
        label6=new JLabel("Add Product");
        label6.setFont(new Font("Castellar", Font.BOLD, 35));
        
        label1.setBounds(787,316,137,28);
        label2.setBounds(787,407,152,28);
        label3.setBounds(787,485,143,28);
        label4.setBounds(787,567,168,28);
        label5.setBounds(787,642,168,28);
        label6.setBounds(826,183,331,67);
        
        c.add(label1);
        c.add(label2);
        c.add(label3);
        c.add(label4);
        c.add(label5);
        c.add(label6);
        
        product_id=new JTextField();
        product_id.setBounds(1054,316,129,29);
        c.add(product_id);
        
        product_name=new JTextField();
        product_name.setBounds(1054,412,129,28);
        c.add(product_name);
        
        product_type=new JTextField();
        product_type.setBounds(1054,485,129,29);
        c.add(product_type);
        
        product_capacity=new JTextField();
        product_capacity.setBounds(1054,567,129,29);
        c.add(product_capacity);
        
        product_price=new JTextField();
        product_price.setBounds(1054,641,129,29);
        c.add(product_price);
  
        add_productdetail=new JButton();
        add_productdetail.setForeground(new Color(240, 248, 255));
        add_productdetail.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add_productdetail.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		add_productdetail(e);
        	}
        });
        add_productdetail.setBackground(new Color(165, 42, 42));
        add_productdetail.setText("Add");
        add_productdetail.setBounds(921,730,152,54);
        c.add(add_productdetail);
        
        
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
        
        
        HomePage=new JButton("Home");
        HomePage.setForeground(new Color(240, 248, 255));
        HomePage.setBackground(new Color(165, 42, 42));
        HomePage.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		homepage(e);
        	}
        });
        HomePage.setBounds(1671,22,100,47);
        c.add(HomePage);
        SignOut=new JButton("Signout");
        SignOut.setForeground(new Color(240, 248, 255));
        SignOut.setBackground(new Color(165, 42, 42));
        SignOut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		signout(e);
        	}
        });
        SignOut.setBounds(1781,22,100,47);
        c.add(SignOut);
        
        ImageIcon background_image=new ImageIcon("E:\\add.jpg");
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
	public void add_productdetail(ActionEvent e) {
		try{

            try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gad_management","Root","AmalKrishna@7736");
		    } catch (ClassNotFoundException e1) {
		        e1.printStackTrace();
		    } 
		    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gad_management","Root+","AmalKrishna@7736");
		
		    String productid=product_id.getText();
		    String productname=product_name.getText();
		    String producttype=product_type.getText();
		    int productcapacity=Integer.parseInt(product_capacity.getText());
		    int productprice=Integer.parseInt(product_price.getText());
		    PreparedStatement ps=conn.prepareStatement("INSERT INTO product_DETAILS VALUES(?,?,?,?,?);");
		    ps.setString(1,productid );
		    ps.setString(2,productname );
		    ps.setString(3,producttype );
		    ps.setInt(4,productcapacity );
		    ps.setInt(5,productprice );
		    int i=ps.executeUpdate();
		    JOptionPane.showMessageDialog(this,i+" records updated");
		    product_id.setText("");
		    product_name.setText("");
		    product_type.setText("");
		    product_capacity.setText("");
		    product_price.setText("");
		    conn.close();
			}
			catch(SQLException e1)
			{
				System.out.println(e1.getMessage());
			}
		    	
		                                                    

	}
	 
}
