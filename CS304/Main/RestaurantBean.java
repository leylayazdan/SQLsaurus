package Main;

import java.sql.*;
import java.sql.SQLException;
import javax.sql.rowset.*;
import javax.sql.rowset.JdbcRowSet;
import com.sun.rowset.JdbcRowSetImpl;

public class RestaurantBean {
	   static final String JDBC_DRIVER =
			      "com.mysql.jdbc.Driver";
	   static final String DB_URL =
	      "jdbc:mysql://localhost:3306/mydatabase";
	   static final String DB_USER = "user1";
	   static final String DB_PASS = "secret";
	   private JdbcRowSet rowSet = null;
	   public RestaurantBean() {
	      try {
	         Class.forName(JDBC_DRIVER);
	         rowSet = new JdbcRowSetImpl();
	         rowSet.setUrl(DB_URL);
	         rowSet.setUsername(DB_USER);
	         rowSet.setPassword(DB_PASS);
	         rowSet.setCommand("SELECT * FROM FOODITEM");
	         rowSet.execute();
	      }

	      catch (SQLException | ClassNotFoundException ex) {
	         ex.printStackTrace();
	      }
	   }
	   public Restaurant create(Restaurant r) {
	      try {
	         rowSet.moveToInsertRow();
	         rowSet.updateString("RestaurantName", r.getRestaurantName());
	         rowSet.updateString("Username", r.getUsername());
	         rowSet.updateBoolean("isOpen", r.getIsOpen());
	         rowSet.updateString("CuisineType", r.getCuisineType());
	         rowSet.insertRow();
	         rowSet.moveToCurrentRow();
	      } catch (SQLException ex) {
	         try {
	            rowSet.rollback();
	            r = null;
	         } catch (SQLException e) {

	         }
	         ex.printStackTrace();
	      }
	      return r;
	   }

	   public Restaurant update(Restaurant r) {
	      try {
	    	 rowSet.updateString("RestaurantName", r.getRestaurantName());
		     rowSet.updateString("Username", r.getUsername());
		     rowSet.updateBoolean("isOpen", r.getIsOpen());
		     rowSet.updateString("CuisineType", r.getCuisineType());
	         rowSet.updateRow();
	         rowSet.moveToCurrentRow();
	      } catch (SQLException ex) {
	         try {
	            rowSet.rollback();
	         } catch (SQLException e) {

	         }
	         ex.printStackTrace();
	      }
	      return r;
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

	   public Restaurant getCurrent() {
	      Restaurant r = new Restaurant();
	      try {
	         rowSet.moveToCurrentRow();
	         r.setRestaurantName(rowSet.getString("RestaurantName"));
	         r.setUsername(rowSet.getString("Username"));
	         r.setIsOpen(rowSet.getBoolean("isOpen"));
	         r.setCuisineType(rowSet.getString("CuisineType"));
	      } catch (SQLException ex) {
	         ex.printStackTrace();
	      }
		  return r;
	   }
}
