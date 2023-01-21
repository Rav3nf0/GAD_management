package gad_management;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.border.LineBorder;

public class LoginPage extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container c;
    JLabel label1,label2;
    JTextField user;
    JPasswordField pass;
    JButton btn,registerbtn;
    private JPanel panel_3;

    LoginPage(){
        setTitle("Login Page");
        setSize(1920,1080);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        c=getContentPane();
        c.setLayout(null);

        Color col=new Color(255, 182, 193);
        getContentPane().setBackground(Color.CYAN);
        
        label1=new JLabel("USERNAME\r\n");
        label1.setForeground(new Color(67, 42, 42));
        label1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        label2=new JLabel("PASSWORD");
        label2.setForeground(new Color(165, 42, 42));
        label2.setFont(new Font("Tahoma", Font.PLAIN, 22));

        label1.setBounds(742,352,144,20);
        label2.setBounds(742,422,144,20);

        c.add(label1);
        c.add(label2);

        user=new JTextField();
        user.setBounds(1017,352,144,32);
        c.add(user);

        pass=new JPasswordField();
        pass.setBounds(1017,422,144,32);
        c.add(pass);

        btn=new JButton("Login");
        btn.setForeground(new Color(240, 248, 255));
        btn.setFont(new Font("Castellar", Font.BOLD, 18));
        btn.setBackground(new Color(165, 42, 42));
        btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		loginbuttonactionperformed(e);
        	}
        });
        btn.setBounds(874,513,151,57);
        c.add(btn);
        
        registerbtn=new JButton("Register");
        registerbtn.setForeground(new Color(240, 248, 255));
        registerbtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		registerbutton(e);
        	}
        });
        registerbtn.setFont(new Font("Castellar", Font.BOLD, 13));
        registerbtn.setBackground(new Color(165, 42, 42));
        registerbtn.setBounds(1136,623,120,32);
        c.add(registerbtn);
        
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
        
        panel_3 = new JPanel();
        panel_3.setBackground(Color.BLACK);
        panel_3.setBounds(21, 1020, 1896, 21);
        getContentPane().add(panel_3);
        
     
        
        ImageIcon background_image=new ImageIcon("E:\\login2.jpg");
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
    public void loginbuttonactionperformed(ActionEvent e) {
    

    	try{

            try {
            	Class.forName("com.mysql.cj.jdbc.Driver");
            	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gad_management","root","rav3nf0@sql");
        		JOptionPane.showMessageDialog(this,"SQL");

            } catch (ClassNotFoundException e1) {
            	e1.printStackTrace();
            } 
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gad_management","root","rav3nf0@sql");

            String username=user.getText();
            @SuppressWarnings("deprecation")
			String password=pass.getText();
            Statement st=conn.createStatement();

            String sql="SELECT * FROM admin_users where username='"+username+"' and password='"+password+"';";

            ResultSet rs=st.executeQuery(sql);
            if(rs.next()) {
        		JOptionPane.showMessageDialog(this,"AdminPage");
        		AdminPanel ap=new AdminPanel();
        		ap.show();

            }
            else{
            	String sql1="SELECT * FROM user_info where user_name='"+username+"' and pass_word='"+password+"';";
            	ResultSet rss=st.executeQuery(sql1);
            	if(rss.next())
            	{
            		dispose();
            		UserPage up=new UserPage();
            		PreparedStatement ps=conn.prepareStatement("INSERT INTO USER_LOG VALUES(default,?,?);");
            		ps.setString(1,username);
            		ps.setString(2, password);
            		int i=ps.executeUpdate();
            		System.out.println(i);
            		up.show();
            	}
            	else {
            		JOptionPane.showMessageDialog(this,"Username OR Password Invalid...");
            		user.setText("");
            		pass.setText("");
            	}
            }
            conn.close();
    	}
    	catch(SQLException e1)
    	{
    		System.out.println(e1.getMessage());
    	}
    }
    
    private void registerbutton(ActionEvent e) {
    	RegisterPage rp=new RegisterPage();
    	rp.show();
    }
}