package Main;

import java.sql.*;
import java.sql.SQLException;
import javax.sql.rowset.*;
import javax.sql.rowset.JdbcRowSet;

public class ReviewsBean {
	   static final String JDBC_DRIVER =
			      "com.mysql.jdbc.Driver";
	   static final String DB_URL =
	      "jdbc:mysql://localhost:3306/mydatabase";
	   static final String DB_USER = "user1";
	   static final String DB_PASS = "secret";
	   private JdbcRowSet rowSet = null;
	   public ReviewsBean() {
	      try {
	         Class.forName(JDBC_DRIVER);
	         rowSet = new JdbcRowSetImpl();
	         rowSet.setUrl(DB_URL);
	         rowSet.setUsername(DB_USER);
	         rowSet.setPassword(DB_PASS);
	         rowSet.setCommand("SELECT * FROM FOODITEM");
	         rowSet.execute();

	      catch (SQLException | ClassNotFoundException ex) {
	         ex.printStackTrace();
	      }
	   }
	   public Reviews create(Reviews r) {
	      try {
	         rowSet.moveToInsertRow();
	         rowSet.updateDate("rDate", r.getrDate());
	         rowSet.updateString("Username", r.getUsername());
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

	   public Reviews update(Reviews r) {
	      try {
	    	 rowSet.updateDate("rDate", r.getrDate());
		     rowSet.updateString("Username", r.getUsername());
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

	   public Reviews getCurrent() {
	      Reviews r = new Reviews();
	      try {
	         rowSet.moveToCurrentRow();
	         r.setrDate(rowSet.getDate("rDate"));
	         r.setUsername(rowSet.getString("Username"));
	      } catch (SQLException ex) {
	         ex.printStackTrace();
	      }
		  return r;
	   }
}
