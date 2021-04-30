/**
 * Delete information
 */

//Import utilities needed to execute the program successfully
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Delete {
	
	//Declare variables
	int found;
	boolean ifFound;
	ArrayList<Serialization> list = new ArrayList<Serialization>();
	public JFrame frame;
	JLabel lbl_name;
	JLabel lbl_number;
	JLabel lbl_DOB;
	JLabel lbl_email;
	private JTextField textField;

	//Launch the application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete window = new Delete();
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
	public Delete() {
		initialize();
	}

	//Initialize frame contents
	private void initialize() {
		frame = new JFrame("DELETE INFORMATION");
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.setBounds(350, 100, 793, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblDelete = new JLabel("Enter email address");
		lblDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDelete.setForeground(Color.RED);
		lblDelete.setBounds(153, 33, 535, 29);
		frame.getContentPane().add(lblDelete);

		textField = new JTextField();
		textField.setBounds(295, 85, 160, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnRetrieve = new JButton("Retrieve");
		btnRetrieve.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				ifFound = false;
				found = -1;
				String Email = textField.getText();
				Serialization demo = new Serialization();
				list = demo.ReadData();

				for (int x = 0; x < list.size(); x++) {
					if (list.get(x).GetEmail().equals(Email)) {
						ifFound = true;
						found = x;
					}
				}
				
				textField.setText("");
				if (ifFound) {
					lblDelete.setText("                          User found");
					lblDelete.setForeground(Color.GREEN);

					lbl_name.setText(list.get(found).GetName());
					lbl_number.setText(list.get(found).GetNumber());
					lbl_DOB.setText(list.get(found).GetDOB());
					lbl_email.setText(list.get(found).GetEmail());
				} 
				
				else {
					lblDelete.setText("                    User not found. Retry");
					lblDelete.setForeground(Color.RED);
					textField.setText("");
				}
			}
		});
		
		btnRetrieve.setBackground(Color.WHITE.darker());
		btnRetrieve.setForeground(Color.BLACK);
		btnRetrieve.setBounds(153, 239, 176, 38);
		frame.getContentPane().add(btnRetrieve);

		lbl_name = new JLabel("");
		lbl_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_name.setBounds(64, 164, 110, 20);
		frame.getContentPane().add(lbl_name);

		lbl_number = new JLabel("");
		lbl_number.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_number.setBounds(223, 164, 110, 20);
		frame.getContentPane().add(lbl_number);

		lbl_DOB = new JLabel("");
		lbl_DOB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_DOB.setBounds(389, 164, 110, 20);
		frame.getContentPane().add(lbl_DOB);

		lbl_email = new JLabel("");
		lbl_email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_email.setBounds(569, 164, 198, 20);
		frame.getContentPane().add(lbl_email);

		JButton btnDeleteUser = new JButton("Delete");
		btnDeleteUser.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {

				if (ifFound) {
					list.remove(found);
					Serialization demo = new Serialization();
					demo.WriteData(list);
					lblDelete.setText("                       User deleted successfully");
					lblDelete.setForeground(Color.GREEN);
					textField.setText("");
					lbl_name.setText("");
					lbl_number.setText("");
					lbl_DOB.setText("");
					lbl_email.setText("");
				} 
				
				else {
					lblDelete.setText("Retrieve user and select Delete");
					lblDelete.setForeground(Color.RED);
				}
			}
		});
		
		btnDeleteUser.setBackground(Color.WHITE.darker());
		btnDeleteUser.setForeground(Color.BLACK);
		btnDeleteUser.setBounds(350, 239, 133, 38);
		frame.getContentPane().add(btnDeleteUser);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Homework11 demo = new Homework11();
				frame.setVisible(false);
				demo.frame.setVisible(true);
			}
		});
		
		btnBack.setBackground(Color.WHITE.darker());
		btnBack.setForeground(Color.BLACK);
		btnBack.setBounds(500, 239, 133, 38);
		frame.getContentPane().add(btnBack);
	}
}