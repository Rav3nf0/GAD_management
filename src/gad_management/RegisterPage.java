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

public class RegisterPage extends JFrame {

	Container c;
	JLabel label1,label2,label3,label4,label5,label6,label7,label8;
	JPasswordField password,confpassword;
	JTextField firstname,lastname,username,phoneno,emailid;
	JButton add_registerdetails;
	
	RegisterPage(){
		setTitle("Register");
		setSize(1920,1080);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	     
	    c=getContentPane();
	    c.setLayout(null);
	    
	    label1=new JLabel("First Name");
	    label1.setFont(new Font("Dialog", Font.BOLD, 26));
        label2=new JLabel("Last Name");
        label2.setFont(new Font("Dialog", Font.BOLD, 26));
        label3=new JLabel("Username");
        label3.setFont(new Font("Dialog", Font.BOLD, 26));
        label7=new JLabel("Password");
        label7.setFont(new Font("Dialog", Font.BOLD, 26));
        label8=new JLabel("Confirm Password");
        label8.setFont(new Font("Dialog", Font.BOLD, 26));
        label4=new JLabel("Phone Number");
        label4.setFont(new Font("Dialog", Font.BOLD, 26));
        label5=new JLabel("Email Id");
        label5.setFont(new Font("Dialog", Font.BOLD, 26));
        label6=new JLabel("Register");
        
        label6.setFont(new Font("Castellar", Font.BOLD | Font.ITALIC, 42));
        
        label1.setBounds(738,324,218,34);
        label2.setBounds(738,401,218,34);
        label3.setBounds(738,469,207,34);
        label4.setBounds(781,696,218,34);
        label5.setBounds(800,753,156,34);
        label6.setBounds(850,193,294,99);
        label7.setBounds(738,532,218,20);
        label8.setBounds(706,590,250,34);

        
        
        c.add(label1);
        c.add(label2);
        c.add(label3);
        c.add(label4);
        c.add(label5);
        c.add(label6);
        c.add(label7);
        c.add(label8);

        
        firstname=new JTextField();
        firstname.setFont(new Font("Dialog", Font.PLAIN, 26));
        firstname.setBounds(1030,324,207,34);
        c.add(firstname);
        
        lastname=new JTextField();
        lastname.setFont(new Font("Dialog", Font.PLAIN, 26));
        lastname.setBounds(1030,401,207,34);
        c.add(lastname);
		    
        
        username=new JTextField();
        username.setFont(new Font("Dialog", Font.PLAIN, 26));
        username.setBounds(1030,469,207,34);
        c.add(username);
        
        phoneno=new JTextField();
        phoneno.setFont(new Font("Dialog", Font.PLAIN, 26));
        phoneno.setBounds(1030,696,207,34);
        c.add(phoneno);
        
        emailid=new JTextField();
        emailid.setFont(new Font("Dialog", Font.PLAIN, 26));
        emailid.setBounds(1030,753,207,34);
        c.add(emailid);

        password=new JPasswordField();
        password.setFont(new Font("Dialog", Font.PLAIN, 26));
        password.setBounds(1030,532,207,34);
        c.add(password);
        
        confpassword=new JPasswordField();
        confpassword.setFont(new Font("Dialog", Font.PLAIN, 26));
        confpassword.setBounds(1030,590,207,34);
        c.add(confpassword);
  
        add_registerdetails=new JButton();
        add_registerdetails.setFont(new Font("Dialog", Font.PLAIN, 26));
        add_registerdetails.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		addregisterdetail(e);
        	}
        });
        add_registerdetails.setBackground(Color.CYAN);
        add_registerdetails.setText("Submit");
        add_registerdetails.setBounds(800,849,131,59);
        c.add(add_registerdetails);
        
        JButton add_registerdetails_1 = new JButton();
        add_registerdetails_1.setText("Reset");
        add_registerdetails_1.setFont(new Font("Dialog", Font.PLAIN, 26));
        add_registerdetails_1.setBackground(Color.CYAN);
        add_registerdetails_1.setBounds(1076, 849, 131, 59);
        getContentPane().add(add_registerdetails_1);
        
        ImageIcon background_image=new ImageIcon("E:\\inventory.png");
        Image img=background_image.getImage();
        Image tempimag=img.getScaledInstance(1920,1080,Image.SCALE_SMOOTH);
        background_image=new ImageIcon(tempimag);
        JLabel background=new JLabel("",background_image,JLabel.CENTER);
        background.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 10));
        background.setForeground(new Color(255, 255, 255));
        background.setBounds(0,0,1920,1080);
        c.add(background);
		//f.getContentPane().setBackground(Color.white);
		c.setLayout(null);
		c.setVisible(true);
        
        setVisible(true);
        
	}
	public void addregisterdetail(ActionEvent e) {
		try{

            try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gad_management","root","rav3nf0@sql");
		    } catch (ClassNotFoundException e1) {
		        e1.printStackTrace();
		    } 
		    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gad_management","root","rav3nf0@sql");
		    String first_name=firstname.getText();
		    String last_name=lastname.getText();
		    String user_name=username.getText();
		    String pass_word=password.getText();
		    String phone_no=phoneno.getText();
		    String email_id=emailid.getText();
		    String confirm_password=confpassword.getText();
		    PreparedStatement ps=conn.prepareStatement("INSERT INTO USER_INFO VALUES (?,?,?,?,?,?);");
		    if(pass_word.equals(confirm_password)) {
			    ps.setString(1, first_name);
			    ps.setString(2, last_name);
			    ps.setString(3, user_name);
			    ps.setString(4, pass_word);
			    ps.setString(5, email_id);
			    ps.setString(6, phone_no);
			    int i=ps.executeUpdate();
			    JOptionPane.showMessageDialog(this,i+" records updated");
			    LoginPage lp=new LoginPage();
			    lp.show();
			    firstname.setText("");
			    lastname.setText("");
			    username.setText("");
			    password.setText("");
			    confpassword.setText("");
			    phoneno.setText("");
			    emailid.setText("");

		    }
		    else {
			    JOptionPane.showMessageDialog(this,"Your password Doesnt Match");
			    password.setText("");
			    confpassword.setText("");
		    }
		    
    	}
		    catch(SQLException et)
	        {
	            System.out.println(et.getMessage());
	        }
	}
}
