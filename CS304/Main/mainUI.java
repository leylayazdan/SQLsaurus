package Main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;



import java.awt.*;
import java.awt.event.*;

public class mainUI extends JPanel {
	
	//JLabel label1 = new JLabel("Please choose");
	private JButton administrator_button = new JButton("Administrator");
	private JButton customer_button = new JButton("Customer");
	private JButton rmanager_button = new JButton("Restaurant Manager");
	
	
	public mainUI() {
		
	      //setBorder(new TitledBorder
	      //(new EtchedBorder(),"Person Details"));
	      setLayout(new BorderLayout(5, 5));
	      ///add(initFields(), BorderLayout.NORTH);
	      add(initButtons(), BorderLayout.CENTER);
	      //setFieldData(bean.moveFirst());
	   }
	
	 private JPanel initButtons() {
	      JPanel panel = new JPanel();
	      panel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
	      panel.add(administrator_button);
	      administrator_button.addActionListener(new ButtonHandler());
	      panel.add(customer_button);
	      customer_button.addActionListener(new ButtonHandler());
	      panel.add(rmanager_button);
	      rmanager_button.addActionListener(new ButtonHandler());
	      return panel;
	   }
	

	  SingletonFrame j = SingletonFrame.getInstance();
	      
	 private class ButtonHandler implements ActionListener {
		  @Override
		  
	      public void actionPerformed(ActionEvent e) {
	         switch (e.getActionCommand()) {
	         case "Administrator":
	        	 j.setTitle("Welcome Dear Administrator!");
	        	 j.setSize(700,300);
	        	 j.setContentPane(new AdministratorUI());
	        	 j.setVisible(true);
	        	 
	   	         JLabel label_admin = new JLabel("Please sign up or login");
	   	         JPanel panel_admin = new JPanel();
	   	         panel_admin.add(label_admin);
	   	         j.add(panel_admin, BorderLayout.NORTH);
	        	 break;
	         case "Customer":
	        	 j.setTitle("Welcome Dear Customer!");
	        	 j.setSize(700,300);
	        	 j.setContentPane(new CustomerUI());
	        	 j.setVisible(true);
	        	 break;
	         case "Restaurant Manager":
	        	 j.setTitle("Welcome Dear Restaurant Manager!");
	        	 j.setSize(700,300);
	        	 j.setContentPane(new RManagerUI());
	        	 j.setVisible(true);
	        	 break;
	        	 
	         }
	      }
	 }
	 
}
