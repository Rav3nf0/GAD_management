package gad_management;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

//import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import java.sql.*;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Order_detail extends storage {

	public JFrame Order_frame;
	private JTable table;

	public void display_order_detail(String databasename, String tablename, String order_id, String client_id,
			JTextArea order_address, JTable table) {
		try {
			Connection con = null;
			Statement stmt = null;
			Statement stmt1 = null;
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + databasename, "postgres",
					"admin");
			stmt = con.createStatement();
			stmt1 = con.createStatement();

			String sql1 = " Select client_address from client where client_id = " + client_id + ";";
			String sql = "select distinct(medicine_name) from " + tablename + " AS  _  where order_id = " + order_id
					+ " and client_id = "
					+ client_id + " IS NOT NULL;";
			// Select id, fname , city from client;
			ResultSet res1 = stmt1.executeQuery(sql1);
			ResultSet res = stmt.executeQuery(sql);
			//table.setModel(DbUtils.resultSetToTableModel(res));

			if (res1.next()) {
				order_address.setText(res1.getString(1));
			}

			stmt.close();
			if (con != null) {
				System.out.println("Connected");
			}

		} catch (Exception es) {
			System.out.println(es.getMessage());

		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		order_count();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order_detail window = new Order_detail();
					window.Order_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Order_detail() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Order_frame = new JFrame();
		Order_frame.setBounds(100, 100, 798, 524);
		Order_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Order_frame.setResizable(false);
		Order_frame.getContentPane().setLayout(null);

		JPanel Header = new JPanel();
		Header.setBackground(Color.BLACK);
		Header.setBounds(0, 0, 784, 68);
		Order_frame.getContentPane().add(Header);
		Header.setLayout(null);

		JLabel heading = new JLabel("GAD Management");
		heading.setBounds(164, 0, 436, 58);
		Header.add(heading);
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setForeground(Color.WHITE);
		heading.setFont(new Font("Tahoma", Font.PLAIN, 29));
		heading.setBackground(Color.WHITE);

		JPanel Nav = new JPanel();
		Nav.setLayout(null);
		Nav.setForeground(Color.WHITE);
		Nav.setBackground(Color.PINK);
		Nav.setBounds(0, 66, 784, 74);
		Order_frame.getContentPane().add(Nav);
		JButton Nav_btn1 = new JButton("Billing");
		Nav_btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*Bill_page po = new Bill_page();
				po.Bill_frame.setVisible(true);
				Order_frame.dispose();
			*/}
		});
		Nav_btn1.setBounds(383, 25, 165, 39);
		Nav.add(Nav_btn1);

		Button Nav_btn2 = new Button("Order Detail");
		Nav_btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Nav_btn2.setBackground(new Color(0, 206, 209));
		Nav_btn2.setBounds(8, 25, 165, 39);
		Nav.add(Nav_btn2);

		JButton Nav_btn4 = new JButton("Profile");
		Nav_btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage f1 = new LoginPage();
				f1.setVisible(true);
				Order_frame.dispose();
			}
		});
		Nav_btn4.setBounds(582, 25, 165, 39);
		Nav.add(Nav_btn4);

		JButton Nav_btn3 = new JButton("Place Order");
		Nav_btn3.setBounds(195, 25, 165, 39);
		Nav.add(Nav_btn3);
//		Nav_btn3.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Place_order_page po = new Place_order_page();
//				po.P_O_frame.setVisible(true);
//				Order_frame.dispose();
//			}
//		});

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(0, 140, 784, 347);
		Order_frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Order ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(182, 42, 112, 31);
		panel.add(lblNewLabel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(148, 0, 211));
		panel_2.setBounds(0, 0, 161, 347);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Order Details");
		lblNewLabel.setBounds(21, 31, 106, 20);
		lblNewLabel.setForeground(Color.WHITE);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 16));

		JLabel lblNewLabel_1_2 = new JLabel("Delivery Address");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(182, 166, 112, 31);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("Contents");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_1.setBounds(182, 83, 112, 31);
		panel.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_2_2 = new JLabel("Delivery Status");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_2.setBounds(182, 248, 112, 31);
		panel.add(lblNewLabel_1_2_2);

		JLabel lblNewLabel_1_2_2_1 = new JLabel("Possible delivery ");
		lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_2_1.setBounds(182, 303, 143, 31);
		panel.add(lblNewLabel_1_2_2_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\javaEclipse\\graphics\\src\\img\\java_img2.jpg"));

		lblNewLabel_2.setBounds(513, 42, 226, 209);
		panel.add(lblNewLabel_2);

		JTextArea Delivery_area = new JTextArea();
		Delivery_area.setEditable(false);
		Delivery_area.setLineWrap(true);
		Delivery_area.setBounds(342, 170, 163, 68);
		panel.add(Delivery_area);

		JTextArea order_id_area = new JTextArea();
		order_id_area.setWrapStyleWord(true);
		order_id_area.setLineWrap(true);
		order_id_area.setEditable(false);
		order_id_area.setBounds(342, 46, 163, 31);
		order_id_area.setText(String.valueOf(client_order_id));
		panel.add(order_id_area);

		JTextArea status = new JTextArea();
		status.setText("In progress");
		status.setLineWrap(true);
		status.setEditable(false);
		status.setBounds(342, 252, 163, 31);
		panel.add(status);

		JTextArea order_date = new JTextArea();
		order_date.setText("within 7 days");
		order_date.setLineWrap(true);
		order_date.setEditable(false);
		order_date.setBounds(342, 307, 163, 31);
		panel.add(order_date);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(342, 92, 163, 68);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		display_order_detail("mypharma", "orders", String.valueOf(client_order_id), main_id, Delivery_area, table);
	}
}

