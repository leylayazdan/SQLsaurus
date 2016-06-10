package Main;

import java.sql.*;
import java.sql.SQLException;
import javax.sql.rowset.*;
import javax.sql.rowset.JdbcRowSet;

public class AdministratorBean {
	   static final String JDBC_DRIVER =
			      "com.mysql.jdbc.Driver";
	   static final String DB_URL =
	      "jdbc:mysql://localhost:3306/mydatabase";
	   static final String DB_USER = "user1";
	   static final String DB_PASS = "secret";
	   private JdbcRowSet rowSet = null;
	   public AdministratorBean() {
	      try {
	         Class.forName(JDBC_DRIVER);
	         rowSet = new JdbcRowSetImpl();
	         rowSet.setUrl(DB_URL);
	         rowSet.setUsername(DB_USER);
	         rowSet.setPassword(DB_PASS);
	         rowSet.setCommand("SELECT * FROM ADMINISTRATOR");
	         rowSet.execute();

	      catch (SQLException | ClassNotFoundException ex) {
	         ex.printStackTrace();
	      }
	   }
	   public Administrator create(Administrator a) {
	      try {
	         rowSet.moveToInsertRow();
	         rowSet.updateString("Username", a.getUsername());
	         rowSet.updateString("Password", a.getPassword());
	         rowSet.updateString("Name", a.getName());
	         rowSet.updateString("Email", a.getEmail());
	         rowSet.updateString("EmployeeID", a.getEmployeeID());
	         rowSet.insertRow();
	         rowSet.moveToCurrentRow();
	      } catch (SQLException ex) {
	         try {
	            rowSet.rollback();
	            a = null;
	         } catch (SQLException e) {

	         }
	         ex.printStackTrace();
	      }
	      return a;
	   }

	   public Administrator update(Administrator a) {
	      try {
	    	 rowSet.updateString("Username", a.getUsername());
		     rowSet.updateString("Password", a.getPassword());
		     rowSet.updateString("Name", a.getName());
		     rowSet.updateString("Email", a.getEmail());
		     rowSet.updateString("EmployeeID", a.getEmployeeID());
	         rowSet.updateRow();
	         rowSet.moveToCurrentRow();
	      } catch (SQLException ex) {
	         try {
	            rowSet.rollback();
	         } catch (SQLException e) {

	         }
	         ex.printStackTrace();
	      }
	      return a;
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

	   public Administrator getCurrent() {
	      Administrator a = new Administrator();
	      try {
	         rowSet.moveToCurrentRow();
	         a.setUsername(rowSet.getString("Username"));
	         a.setPassword(rowSet.getString("Password"));
	         a.setName(rowSet.getString("Name"));
	         a.setEmail(rowSet.getString("Email"));
	         a.setEmployeeID(rowSet.getString("EmployeeID"));
	      } catch (SQLException ex) {
	         ex.printStackTrace();
	      }
	      return a;
	   }
}
