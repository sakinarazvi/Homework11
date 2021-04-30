/**
 * Update information
 */

//Import utilities needed to execute the program successfully
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Update {
	
	//Declare variables
	int found;
	boolean ifFound;
	ArrayList<Serialization> list = new ArrayList<Serialization>();
	public JFrame frame;
	public JFrame frame_1;
	JLabel lbl_name;
	JLabel lbl_number;
	JLabel lbl_DOB;
	JLabel lbl_email;
	private JTextField textField_email;
	private JLabel lblNewLabel;
	private JTextField textField_name;
	private JTextField textField_number;
	private JTextField textField_month;
	private JTextField textField_day;
	private JTextField textField_year;
	private JTextField textField_address;

	//Launch application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update window = new Update();
					window.frame_1.setVisible(true);
				} 
				
				//Catch exception
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Create application
	public Update() {
		initialize();
	}

	//Initialize frame contents
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame_1 = new JFrame("UPDATE INFORMATION");
		frame_1.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame_1.setBounds(100, 100, 793, 491);
		frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_1.getContentPane().setLayout(null);

		JLabel lblUpdate = new JLabel("Enter email address");
		lblUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUpdate.setBounds(153, 33, 535, 29);
		frame_1.getContentPane().add(lblUpdate);

		textField_email = new JTextField();
		textField_email.setBounds(294, 85, 200, 29);
		frame_1.getContentPane().add(textField_email);
		textField_email.setColumns(10);

		JButton btnNewButton = new JButton("Retrieve Information");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ifFound = false;
				found = -1;
				String Email = textField_email.getText();
				Serialization demo = new Serialization();
				list = demo.ReadData();

				for (int x = 0; x < list.size(); x++) {
					if (list.get(x).GetEmail().equals(Email)) {
						ifFound = true;
						found = x;
					}
				}
				
				textField_email.setText("");
				if (ifFound) {
					lblUpdate.setText("                          User found");
					lblUpdate.setForeground(Color.GREEN);

					lbl_name.setText(list.get(found).GetName());
					lbl_number.setText(list.get(found).GetNumber());
					lbl_DOB.setText(list.get(found).GetDOB());
					lbl_email.setText(list.get(found).GetEmail());
				} 
				
				else {
					lblUpdate.setText("                    User not found. Retry");
					lblUpdate.setForeground(Color.RED);
					textField_email.setText("");
				}
			}
		});
		
		btnNewButton.setBackground(Color.WHITE.darker());
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(120, 343, 155, 38);
		frame_1.getContentPane().add(btnNewButton);

		lbl_name = new JLabel("");
		lbl_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_name.setBounds(31, 164, 198, 20);
		frame_1.getContentPane().add(lbl_name);

		lbl_number = new JLabel("");
		lbl_number.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_number.setBounds(223, 164, 110, 20);
		frame_1.getContentPane().add(lbl_number);

		lbl_DOB = new JLabel("");
		lbl_DOB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_DOB.setBounds(389, 164, 110, 20);
		frame_1.getContentPane().add(lbl_DOB);

		lbl_email = new JLabel("");
		lbl_email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_email.setBounds(569, 164, 198, 20);
		frame_1.getContentPane().add(lbl_email);

		JButton btnUpdateUser = new JButton("Update User");
		btnUpdateUser.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {

				if (ifFound) {
					String name = textField_name.getText();
					String number = textField_number.getText();
					String DOB = textField_month.getText() + "/" + textField_day.getText() + "/" + textField_year.getText();
					String email = textField_address.getText();
					
					if (!name.equals("")) {
						list.get(found).SetName(name);
					}
					if (!number.equals("")) {
						list.get(found).SetNumber(number);
					}
					if (!DOB.equals("//")) {
						list.get(found).SetDOB(DOB);
					}
					if (!email.equals("")) {
						list.get(found).SetEmail(email);
					}

					Serialization demo = new Serialization();
					demo.WriteData(list);
					lblUpdate.setText("       	          User updated sucessfully");
					lblUpdate.setForeground(Color.GREEN);

					lbl_name.setText("");
					lbl_number.setText("");
					lbl_DOB.setText("");
					lbl_email.setText("");
				} 
				
				else {
					lblUpdate.setText(" Retrieve user and select Update");
					lblUpdate.setForeground(Color.RED);
				}

				textField_name.setText("");
				textField_number.setText("");
				textField_month.setText("");
				textField_day.setText("");
				textField_year.setText("");
				textField_address.setText("");

			}
		});
		
		btnUpdateUser.setBackground(Color.WHITE.darker());
		btnUpdateUser.setForeground(Color.BLACK);
		btnUpdateUser.setBounds(320, 343, 150, 38);
		frame_1.getContentPane().add(btnUpdateUser);

		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.WHITE.darker());
		btnBack.setForeground(Color.BLACK);
		btnBack.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Homework11 demo = new Homework11();
				frame_1.setVisible(false);
				demo.frame.setVisible(true);
			}
		});
		
		
		btnBack.setBounds(530, 343, 133, 38);
		frame_1.getContentPane().add(btnBack);

		lblNewLabel = new JLabel("Enter updated value in fields");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(200, 228, 633, 29);
	
		frame_1.getContentPane().add(lblNewLabel);

		textField_name = new JTextField();
		textField_name.setColumns(10);
		textField_name.setBounds(31, 283, 152, 29);
		frame_1.getContentPane().add(textField_name);

		textField_number = new JTextField();
		textField_number.setColumns(10);
		textField_number.setBounds(209, 283, 152, 29);
		frame_1.getContentPane().add(textField_number);

		textField_month = new JTextField();
		textField_month.setColumns(10);
		textField_month.setBounds(389, 283, 38, 29);
		frame_1.getContentPane().add(textField_month);

		textField_day = new JTextField();
		textField_day.setColumns(10);
		textField_day.setBounds(456, 283, 38, 29);
		frame_1.getContentPane().add(textField_day);

		textField_year = new JTextField();
		textField_year.setColumns(10);
		textField_year.setBounds(525, 283, 38, 29);
		frame_1.getContentPane().add(textField_year);

		textField_address = new JTextField();
		textField_address.setColumns(10);
		textField_address.setBounds(591, 283, 152, 29);
		frame_1.getContentPane().add(textField_address);
	}
}