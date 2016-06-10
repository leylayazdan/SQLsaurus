package Main;

import java.sql.*;
import java.sql.SQLException;
import javax.sql.rowset.*;
import javax.sql.rowset.JdbcRowSet;

public class RestaurantManagerBean {
	   static final String JDBC_DRIVER =
			      "com.mysql.jdbc.Driver";
	   static final String DB_URL =
	      "jdbc:mysql://localhost:3306/mydatabase";
	   static final String DB_USER = "user1";
	   static final String DB_PASS = "secret";
	   private JdbcRowSet rowSet = null;
	   public RestaurantManagerBean() {
	      try {
	         Class.forName(JDBC_DRIVER);
	         rowSet = new JdbcRowSetImpl();
	         rowSet.setUrl(DB_URL);
	         rowSet.setUsername(DB_USER);
	         rowSet.setPassword(DB_PASS);
	         rowSet.setCommand("SELECT * FROM RESTAURANT MANAGER");
	         rowSet.execute();

	      catch (SQLException | ClassNotFoundException ex) {
	         ex.printStackTrace();
	      }
	   }
	   public RestaurantManager create(RestaurantManager r) {
	      try {
	         rowSet.moveToInsertRow();
	         rowSet.updateString("Username", r.getUsername());
	         rowSet.updateString("Password", r.getPassword());
	         rowSet.updateString("Name", r.getName());
	         rowSet.updateString("Email", r.getEmail());
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

	   public RestaurantManager update(RestaurantManager r) {
	      try {
	    	 rowSet.updateString("Username", r.getUsername());
	         rowSet.updateString("Password", r.getPassword());
	         rowSet.updateString("Name", r.getName());
	         rowSet.updateString("Email", r.getEmail());
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

	   public RestaurantManager getCurrent() {
	      RestaurantManager r = new RestaurantManager();
	      try {
	         rowSet.moveToCurrentRow();
	         r.setUsername(rowSet.getString("Username"));
	         r.setPassword(rowSet.getString("Password"));
	         r.setName(rowSet.getString("Name"));
	         r.setEmail(rowSet.getString("Email"));
	      } catch (SQLException ex) {
	         ex.printStackTrace();
	      }
	      return r;
	   }
}
