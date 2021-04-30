//Import utilities needed to execute the program successfully
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serialization implements java.io.Serializable {

	//Declare variables
	private String name;
	private String number;
	private String DOB;
	private String email;

	Serialization(String N, String P, String D, String E) {
		name = N;
		number = P;
		DOB = D;
		email = E;
	}

	Serialization() {
	}

	//Write Data
	public void WriteData(java.util.List<Serialization> list) {
		try {
			
			//Output stream
			FileOutputStream file = new FileOutputStream("user.txt");
			ObjectOutputStream output = new ObjectOutputStream(file);

			for (int x = 0; x < list.size(); x++)
				output.writeObject(list.get(x));
			
			//Close
			output.close();
			file.close();
		} 
		
		//Catch exception
		catch (IOException i) {
			i.printStackTrace();
		}
	}

	//Read data
	public ArrayList<Serialization> ReadData() {
		
		//Create an ArrayList
		ArrayList<Serialization> list = new ArrayList<Serialization>();
		try {

			//Input stream
			FileInputStream file = new FileInputStream("user.txt");
			ObjectInputStream input = new ObjectInputStream(file);

			Serialization object = (Serialization) input.readObject();
			while (object != null) {
				list.add(object);
				object = (Serialization) input.readObject();
			}
			
			//Close
			file.close();
			input.close();
		} 
		
		//Catch exception
		catch (Exception ex) {
			System.out.println("Complete");
		}
		return list;
	}

	//Getter methods
	String GetName() {
		return name;
	}

	public String GetNumber() {
		return number;
	}

	public String GetDOB() {
		return DOB;
	}

	public String GetEmail() {
		return email;
	}

	//Setter methods
	public void SetName(String s) {
		name = s;
	}

	public void SetNumber(String n) {
		number = n;
	}

	public void SetDOB(String d) {
		DOB = d;
	}

	public void SetEmail(String E) {
		email = E;
	}
}