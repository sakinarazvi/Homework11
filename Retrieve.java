/**
 * Retrieve information from a file and display them
 */

//Import utilities needed to execute the program successfully
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Retrieve {

	ArrayList<Serialization> list = new ArrayList<Serialization>();
	public JFrame frame;

	//Launch the application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Retrieve window = new Retrieve();
					window.frame.setVisible(true);
				} 
				
				//Catch exception
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Create the application
	public Retrieve() {
		initialize();
	}

	//Initialize frame contents
	private void initialize() {
		frame = new JFrame("RETRIEVE INFORMATION");
		frame.setBounds(350, 100, 703, 424);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JEditorPane editorPane_name = new JEditorPane();
		editorPane_name.setBounds(10, 89, 140, 217);
		frame.getContentPane().add(editorPane_name);

		JEditorPane editorPane_number = new JEditorPane();
		editorPane_number.setBounds(168, 89, 140, 217);
		frame.getContentPane().add(editorPane_number);

		JEditorPane editorPane_DOB = new JEditorPane();
		editorPane_DOB.setBounds(334, 89, 150, 217);
		frame.getContentPane().add(editorPane_DOB);

		JEditorPane editorPane_email = new JEditorPane();
		editorPane_email.setBounds(512, 89, 165, 217);
		frame.getContentPane().add(editorPane_email);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(45, 37, 105, 25);
		frame.getContentPane().add(lblName);

		JLabel lblNumber = new JLabel("Phone Number");
		lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumber.setBounds(168, 37, 150, 25);
		frame.getContentPane().add(lblNumber);

		JLabel lblDOB = new JLabel("Date Of Birth");
		lblDOB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDOB.setBounds(344, 37, 140, 25);
		frame.getContentPane().add(lblDOB);

		JLabel lblEmail = new JLabel("Email Address");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(512, 37, 140, 25);
		frame.getContentPane().add(lblEmail);

		JButton btnBack = new JButton("Back");
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
		btnBack.setBounds(224, 340, 250, 34);
		frame.getContentPane().add(btnBack);

		Serialization demo = new Serialization();
		list = demo.ReadData();

		for (int x = 0; x < list.size(); x++) {
			Serialization temp = list.get(x);
			System.out.println("Name:" + temp.GetName());
			
			editorPane_name.setText(editorPane_name.getText() + temp.GetName() + "\n");
			editorPane_number.setText(editorPane_number.getText() + temp.GetNumber() + "\n");
			editorPane_DOB.setText(editorPane_DOB.getText() + temp.GetDOB() + "\n");
			editorPane_email.setText(editorPane_email.getText() + temp.GetEmail() + "\n");
		}
	}
}