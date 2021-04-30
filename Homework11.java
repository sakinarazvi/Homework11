/**
 * Sakina Razvi
 * CPSC 24500
 * 4/11/21
 * Serialization
 * This program uses serialization to collect the following information from the user: name, phone number, 
 * date of birth, and email address. It then uses GUI to display a menu driven program with the following
 * options: add information into a file, retrieve information from a file and display them, delete information,
 * update information, and exit. These actions are completed by their respective classes.
 */

//Import utilities needed to execute the program successfully
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Homework11 {

	public JFrame frame;

	//Launch application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homework11 window = new Homework11();
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
	public Homework11() {
		initialize();
	}

	//Initialize frame contents
	private void initialize() {
		
		frame = new JFrame("MENU");
		frame.setBounds(500, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//Add information into a file
		JButton btnAdd = new JButton("Add information");
		btnAdd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Add demo = new Add();
				frame.setVisible(false);
				demo.frame.setVisible(true);
			}
		});
		
		//Add information
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setBackground(Color.WHITE.darker());
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setBounds(60, 75, 150, 40);
		frame.getContentPane().add(btnAdd);

		//Retrieve information from a file and display them
		JButton btnRetrieve = new JButton("Retrieve information");
		btnRetrieve.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Retrieve demo = new Retrieve();
				frame.setVisible(false);
				demo.frame.setVisible(true);

			}
		});
		
		//Retrieve information
		btnRetrieve.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRetrieve.setBackground(Color.WHITE.darker());
		btnRetrieve.setForeground(Color.BLACK);
		btnRetrieve.setBounds(250, 75, 150, 40);
		frame.getContentPane().add(btnRetrieve);

		//Update information
		JButton btnUpdate = new JButton("Update information");
		btnUpdate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Update demo = new Update();
				frame.setVisible(false);
				demo.frame_1.setVisible(true);
			}
		});
		
		//Update information
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdate.setBackground(Color.WHITE.darker());
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setBounds(60, 160, 150, 40);
		frame.getContentPane().add(btnUpdate);

		//Delete information
		JButton btnDelete = new JButton("Delete information");
		btnDelete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Delete demo = new Delete();
				frame.setVisible(false);
				demo.frame.setVisible(true);
			}
		});
		
		//Delete information
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setBackground(Color.WHITE.darker());
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setBounds(250, 160, 150, 40);
		frame.getContentPane().add(btnDelete);

		//Display message
		JLabel lblDisplay = new JLabel("Please select from the menu options:");
		lblDisplay.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDisplay.setBounds(75, 25, 350, 20);
		frame.getContentPane().add(lblDisplay);

		//Exit
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(Color.WHITE.darker());
		btnExit.setForeground(Color.BLACK);
		btnExit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		
		//Exit
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExit.setBounds(150, 250, 150, 40);
		frame.getContentPane().add(btnExit);
	}
}