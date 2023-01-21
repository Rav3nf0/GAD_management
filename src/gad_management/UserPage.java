package gad_management;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserPage extends JFrame {

	Container c;
    JLabel label1;
    JButton booking_button,viewProduct_button;
    UserPage(){
    	setTitle("User Page");
		setSize(1920,1080);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	     
	    c=getContentPane();
	    c.setLayout(null);
	    
	    label1=new JLabel("GAD Management System");
	    
	    label1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 36));
	    booking_button=new JButton("Orders");
	    booking_button.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    booking_button.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		bookingbutton(e);
	    	}
	    });
	    
	    booking_button.setBackground(Color.CYAN);
	    viewProduct_button=new JButton("Check Products");
	    viewProduct_button.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    viewProduct_button.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		viewProductbutton(e);
	    	}
	    });
	    viewProduct_button.setBackground(Color.CYAN);
	    
	    
        label1.setBounds(706,147,901,90);
        booking_button.setBounds(727,311,175,69);
        viewProduct_button.setBounds(1037,311,175,69);
        
        c.add(label1);
        c.add(booking_button);
        c.add(viewProduct_button);
        
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
        
        ImageIcon background_image=new ImageIcon("E:\\user.jpg");
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
    private void bookingbutton(ActionEvent e) {
    	Order_detail fb=new Order_detail();
//    	fb.show();
    }
    
    private void viewProductbutton(ActionEvent e) {
    	ViewProduct vf=new ViewProduct();
    	vf.show();
    }
}