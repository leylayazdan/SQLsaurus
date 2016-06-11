package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AppMain {
	
public static Connection con;


public AppMain(){
	
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());	
System.out.println("Driver Working");
}
catch (SQLException ex)
{
	System.out.println("Message:        " + ex.getMessage());
	System.exit(-1);
}
}

private static boolean connect(String username, String password){
	String connectURL = "jdbc:oracle:thin:@localhost:1522:ug";
	
	try
	{
		con = DriverManager.getConnection(connectURL, username, password);
		
		System.out.println("\n Connected to Oracle!");
		return true;
	}
	catch (SQLException ex)
	{
		System.out.println("Message: " + ex.getMessage());
		return false;
	}
}
	
	
	public static void main(String[] args) {
		AppMain am = new AppMain();
	
		//Use your oracle username and password
		connect("ora_y0d9", "a39006127");
		//JFrame f=new JFrame("Welcome to Food Delivery Using Drones!");
		SingletonFrame f = SingletonFrame.getInstance();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      f.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
	      //f.setBackground(new Color(53, 86, 64));
	      //f.getContentPane().add(new mainUI());
	      f.setTitle("Welcome to Food Delivery Using Drones!");
	      f.setContentPane(new mainUI());
	      f.setSize(600, 280);
	      f.setVisible(true);
	      
	      JLabel label1 = new JLabel("Please choose one of the following");
	      JPanel panel1 = new JPanel();
	      panel1.add(label1);
	      f.getContentPane().add(panel1, BorderLayout.NORTH);
		
	}

}
