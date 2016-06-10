package Main;

import java.sql.*;
import java.sql.SQLException;
import javax.sql.rowset.*;
import javax.sql.rowset.JdbcRowSet;

public class DroneBean {
	   static final String JDBC_DRIVER =
			      "com.mysql.jdbc.Driver";
	   static final String DB_URL =
	      "jdbc:mysql://localhost:3306/mydatabase";
	   static final String DB_USER = "user1";
	   static final String DB_PASS = "secret";
	   private JdbcRowSet rowSet = null;
	   public DroneBean() {
	      try {
	         Class.forName(JDBC_DRIVER);
	         rowSet = new JdbcRowSetImpl();
	         rowSet.setUrl(DB_URL);
	         rowSet.setUsername(DB_USER);
	         rowSet.setPassword(DB_PASS);
	         rowSet.setCommand("SELECT * FROM DAILYLOG");
	         rowSet.execute();

	      catch (SQLException | ClassNotFoundException ex) {
	         ex.printStackTrace();
	      }
	   }
	   public Drone create(Drone d) {
	      try {
	         rowSet.moveToInsertRow();
	         rowSet.updateString("DroneID", d.getDroneID());
	         rowSet.updateString("Manufacturer", d.getManufacturer());
	         rowSet.updateString("Model", d.getModel());
	         rowSet.insertRow();
	         rowSet.moveToCurrentRow();
	      } catch (SQLException ex) {
	         try {
	            rowSet.rollback();
	            d = null;
	         } catch (SQLException e) {

	         }
	         ex.printStackTrace();
	      }
	      return d;
	   }

	   public Drone update(Drone d) {
	      try {
	    	 rowSet.updateString("DroneID", d.getDroneID());
		     rowSet.updateString("Manufacturer", d.getManufacturer());
		     rowSet.updateString("Model", d.getModel());
	         rowSet.updateRow();
	         rowSet.moveToCurrentRow();
	      } catch (SQLException ex) {
	         try {
	            rowSet.rollback();
	         } catch (SQLException e) {

	         }
	         ex.printStackTrace();
	      }
	      return d;
	   }

	   public void delete() {
	      try {
	         rowSet.moveToCurrentRow();
	         rowSet.deleteRow();
	      } catch (SQLException ex) {
	         try {
	            rowSet.rollback();
	         } catch (SQLException e) { }
	         ex.printStackTrace();
	      }

	   }

	   public Drone getCurrent() {
	      Drone d = new Drone();
	      try {
	         rowSet.moveToCurrentRow();
	         d.setDroneID(rowSet.getString("DroneID"));
	         d.setManufacturer(rowSet.getString("Manufacturer"));
	         d.setModel(rowSet.getString("Model"));
	      } catch (SQLException ex) {
	         ex.printStackTrace();
	      }
	      return d;
	   }
}
