package gad_management;

import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class ViewProduct extends JFrame {

	Container c;
    JLabel label1,label2;
    JButton search_location;
    private JTable table;
    String[] locations= {"Mumbai","Chennai","Kochi","Kolkata","Patna","Telangana","Amritsar","Guwahati","Bhubaneswar","Gaya","New Delhi","Ahmedabad","Bengaluru","Mangalore","Kozhikode","Thiruvananthapuram","Nagpur","Jaipur","Lucknow","Kannur","Surat"};
	JComboBox<?> combo=new JComboBox<Object>(locations);
	
    
    ViewProduct(){
    	setTitle("User Page");
		setSize(800,600);
		setLocation(100,100);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	     
	    c=getContentPane();
	    c.setLayout(null);
    	
    	combo.setForeground(Color.BLACK);
    	combo.setBounds(95, 171, 115, 20);
    	c.add(combo);
    	
    	label1=new JLabel("Product Details");
    	label1.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 20));
    	label2=new JLabel("Location");
    	label1.setBounds(295,29,357,100);
    	label2.setBounds(112,129,85,31);
    	c.add(label1);
    	c.add(label2);
    	
    	search_location=new JButton("Search");
    	search_location.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try {
					searchlocation(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    		}
    	});
    	search_location.setBounds(183,129,85,31);
    	c.add(search_location);
    	
    	table = new JTable();
    	table.setBounds(0, 202, 784, 359);
    	getContentPane().add(table);
    	
    	
    	
        setVisible(true);

    }
    public void searchlocation(ActionEvent e) throws SQLException {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/flight_management","Amal","AmalKrishna@7736");
    	} catch (ClassNotFoundException e1) {
    		e1.printStackTrace();
    		
    	} 
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/flight_management","Amal","AmalKrishna@7736");
		String location=(String)combo.getSelectedItem();
    	Statement st= conn.createStatement();
    	String sql="SELECT * FROM FLIGHT_SCHEDULE WHERE to_location='"+location+"' or from_location='"+location+"';";
    	ResultSet rs=st.executeQuery(sql);
    	if (rs.next()) {
    		String flightno=rs.getString("flight_id");
	        String airlineno=rs.getString("airline_id");
	        String airportno=rs.getString("airport_id");
	        String date=rs.getString("date_of_departure");
	        String forlocation=rs.getString("from_location");
	        String tolocation=rs.getString("to_location");
	        String price=String.valueOf(rs.getInt("price"));
	        String tbData[]= {flightno,airlineno,airportno,date,forlocation,tolocation,price};
	        DefaultTableModel tbModel=(DefaultTableModel) table.getModel();
	        tbModel.addRow(tbData);
    	}
    }
}
 