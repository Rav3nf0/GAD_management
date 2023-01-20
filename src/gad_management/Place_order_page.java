package gad_management;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class Place_order_page extends storage {

	public JFrame P_O_frame;
	private JTextField quantity;
	//JDBC_table_printer jdbcobj = new JDBC_table_printer();
	private JTable table;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Place_order_page() {
		order_count();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		P_O_frame = new JFrame();
		P_O_frame.setBounds(100, 100, 798, 524);
		P_O_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		P_O_frame.setResizable(false);
		P_O_frame.getContentPane().setLayout(null);

		JPanel Header = new JPanel();
		Header.setBackground(Color.BLACK);
		Header.setBounds(0, 0, 784, 68);
		P_O_frame.getContentPane().add(Header);
		Header.setLayout(null);

		JLabel heading = new JLabel("MyPharma");
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
		P_O_frame.getContentPane().add(Nav);

		JButton Nav_btn1 = new JButton("Order Details");
		Nav_btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Order_detail po = new Order_detail();
				po.Order_frame.setVisible(true);
				P_O_frame.dispose();
			}
		});
		Nav_btn1.setBounds(8, 25, 165, 39);
		Nav.add(Nav_btn1);

		JButton Nav_btn3 = new JButton("Billing");
		Nav_btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bill_page po = new Bill_page();
				po.Bill_frame.setVisible(true);
				P_O_frame.dispose();
			}
		});
		Nav_btn3.setBounds(388, 25, 165, 39);
		Nav.add(Nav_btn3);

		Button Nav_btn2 = new Button("Place Order");
		Nav_btn2.setBackground(new Color(0, 206, 209));
		Nav_btn2.setBounds(195, 25, 165, 39);
		Nav.add(Nav_btn2);

		JButton Nav_btn4 = new JButton("Profile");
//		Nav_btn4.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				front_page f1 = new front_page();
//				f1.F_pg.setVisible(true);
//				P_O_frame.dispose();
//			}
//		});
		Nav_btn4.setBounds(582, 25, 165, 39);
		Nav.add(Nav_btn4);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(0, 139, 784, 348);
		P_O_frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(153, 0, 204));
		panel_2.setBounds(0, 0, 135, 348);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Place Order");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(27, 38, 94, 20);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\javaEclipse\\graphics\\src\\img\\pic7.jpeg"));
		lblNewLabel_3.setBounds(8, 99, 113, 105);
		panel_2.add(lblNewLabel_3);

		JLabel lblNewLabel_1 = new JLabel("Place your order");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(143, 0, 173, 39);
		panel.add(lblNewLabel_1);

		quantity = new JTextField();
		quantity.setColumns(10);
		quantity.setBounds(432, 287, 107, 19);
		panel.add(quantity);

		JLabel lblNewLabel_2 = new JLabel("Medicine");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(143, 280, 76, 31);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Quantity");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(371, 280, 90, 31);
		panel.add(lblNewLabel_2_1);

		//jdbcobj.med_names("mypharma");
		JComboBox comboBox = new JComboBox(jdbcobj.med_collect);
		comboBox.setBounds(214, 286, 117, 21);

		panel.add(comboBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(153, 49, 600, 197);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
//		jdbcobj.print_specific_attribute_table("orders", "mypharma", table, main_id,
//				"medicine_id, medicine_name ,order_quantity,final_amount", String.valueOf(client_order_id));
		JButton add_med_purchase = new JButton(" Add for purchase");

		add_med_purchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//jdbcobj.med_price("mypharma", String.valueOf(comboBox.getItemAt(comboBox.getSelectedIndex())));
				int qty = Integer.valueOf(quantity.getText());
				Float total_qty_price = jdbcobj.med_price_collector * qty;
				System.out.println();
				//jdbcobj.addorder("mypharma", String.valueOf(client_order_id), main_id,
						//jdbcobj.med_id_collector, String.valueOf(comboBox.getItemAt(comboBox.getSelectedIndex())),
						String.valueOf(qty), "20/2/2020", String.valueOf(total_qty_price));

//				jdbcobj.print_specific_attribute_table("orders", "mypharma", table, main_id,
//						"medicine_id, medicine_name ,order_quantity,final_amount", String.valueOf(client_order_id));
//
//			}
//		});
		add_med_purchase.setBounds(601, 286, 152, 21);
		panel.add(add_med_purchase);

		JButton btnNewButton = new JButton("remove from puchase");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jdbcobj.remove_from_order("orders", table, "mypharma", String.valueOf(client_order_id));
				jdbcobj.print_specific_attribute_table("orders", "mypharma", table, main_id,
						"medicine_id, medicine_name ,order_quantity,final_amount", String.valueOf(client_order_id));
			}
		});
		btnNewButton.setBounds(601, 317, 152, 21);
		panel.add(btnNewButton);

	}

	public static void main(String[] args) {
		Place_order_page window = new Place_order_page();
		window.P_O_frame.setVisible(true);
	}

}