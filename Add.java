/**
 * Add information into a file
 */

//Import utilities needed to execute the program successfully
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.util.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Add {
	
	//Declare variables
	public JFrame frame;
	private JTextField textField_name;
	private JTextField textField_number;
	private JTextField textField_month;
	private JTextField textField_day;
	private JTextField textField_year;
	private JTextField textField_email;
	private JLabel lblDisplay;
	List<Serialization> list = new ArrayList<Serialization>();
	JLabel lblNewLabel;
	private JButton btnBack;

	//Launch application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add window = new Add();
					window.frame.setVisible(true);
				} 
				
				//Catch exception
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Create application
	public Add() {

		initialize();
		Serialization demo = new Serialization();
		list = demo.ReadData();

		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(28, 252, 396, 27);
		frame.getContentPane().add(lblNewLabel);

		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Homework11 demo = new Homework11();
				frame.setVisible(false);
				demo.frame.setVisible(true);
			}
		});
		
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBackground(Color.WHITE.darker());
		btnBack.setForeground(Color.BLACK);
		btnBack.setBounds(259, 290, 98, 25);
		frame.getContentPane().add(btnBack);
	}

	//Initialize frame contents
	private void initialize() {
		frame = new JFrame("ADD INFORMATION");
		frame.setBounds(500, 100, 450, 376);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(42, 78, 126, 27);
		frame.getContentPane().add(lblName);

		JLabel lblNumber = new JLabel("Phone Number");
		lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumber.setBounds(41, 116, 174, 27);
		frame.getContentPane().add(lblNumber);

		JLabel lblDOB = new JLabel("Date of Birth");
		lblDOB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDOB.setBounds(42, 168, 151, 27);
		frame.getContentPane().add(lblDOB);

		JLabel lblEmail = new JLabel("Email Address");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(42, 214, 151, 27);
		frame.getContentPane().add(lblEmail);

		textField_name = new JTextField();
		textField_name.setBounds(225, 81, 132, 25);
		frame.getContentPane().add(textField_name);
		textField_name.setColumns(10);

		textField_number = new JTextField();
		textField_number.setColumns(10);
		textField_number.setBounds(225, 119, 132, 25);
		frame.getContentPane().add(textField_number);

		textField_month = new JTextField();
		textField_month.setColumns(10);
		textField_month.setBounds(225, 171, 30, 25);
		frame.getContentPane().add(textField_month);

		textField_day = new JTextField();
		textField_day.setColumns(10);
		textField_day.setBounds(285, 171, 30, 25);
		frame.getContentPane().add(textField_day);

		textField_year = new JTextField();
		textField_year.setColumns(10);
		textField_year.setBounds(343, 171, 60, 25);
		frame.getContentPane().add(textField_year);

		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(225, 217, 170, 25);
		frame.getContentPane().add(textField_email);

		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {

				try {
					String name = textField_name.getText();
					String number = textField_number.getText();
					String DOB = textField_month.getText() + "/" + textField_day.getText() + "/" + textField_year.getText();
					String email = textField_email.getText();

					Serialization demo = new Serialization(name, number, DOB, email);
					list.add(demo);
					Serialization temp = new Serialization();
					temp.WriteData(list);

					lblNewLabel.setText("      User added successfully");
					lblNewLabel.setForeground(Color.GREEN);
				} 
				
				//Catch exception
				catch (Exception ex) {
					lblNewLabel.setText("Unable to add user. Retry");
					lblNewLabel.setForeground(Color.RED);
				} 
				
				finally {
					textField_name.setText("");
					textField_number.setText("");
					textField_month.setText("");
					textField_day.setText("");
					textField_year.setText("");
					textField_email.setText("");
				}
			}
		});
		
		btnAddUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddUser.setBackground(Color.WHITE.darker());
		btnAddUser.setForeground(Color.BLACK);
		btnAddUser.setBounds(104, 290, 114, 23);
		frame.getContentPane().add(btnAddUser);

		//Display message
		lblDisplay = new JLabel("Enter information:");
		lblDisplay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDisplay.setBounds(129, 30, 240, 26);
		frame.getContentPane().add(lblDisplay);

		//DOB labels
		JLabel lblMonth = new JLabel("MM");
		lblMonth.setBounds(255, 174, 24, 19);
		frame.getContentPane().add(lblMonth);

		JLabel lblDay = new JLabel("DD");
		lblDay.setBounds(315, 176, 24, 14);
		frame.getContentPane().add(lblDay);

		JLabel lblYear = new JLabel("YY");
		lblYear.setBounds(411, 176, 46, 14);
		frame.getContentPane().add(lblYear);
	}
}