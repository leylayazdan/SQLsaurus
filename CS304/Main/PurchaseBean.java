package Main;

import java.sql.*;
import java.sql.SQLException;
import javax.sql.rowset.*;
import javax.sql.rowset.JdbcRowSet;

public class PurchaseBean {
	   static final String JDBC_DRIVER =
			      "com.mysql.jdbc.Driver";
	   static final String DB_URL =
	      "jdbc:mysql://localhost:3306/mydatabase";
	   static final String DB_USER = "user1";
	   static final String DB_PASS = "secret";
	   private JdbcRowSet rowSet = null;
	   public PurchaseBean() {
	      try {
	         Class.forName(JDBC_DRIVER);
	         rowSet = new JdbcRowSetImpl();
	         rowSet.setUrl(DB_URL);
	         rowSet.setUsername(DB_USER);
	         rowSet.setPassword(DB_PASS);
	         rowSet.setCommand("SELECT * FROM PURCHASE");
	         rowSet.execute();

	      catch (SQLException | ClassNotFoundException ex) {
	         ex.printStackTrace();
	      }
	   }
	   public Purchase create(Purchase p) {
	      try {
	         rowSet.moveToInsertRow();
	         rowSet.updateString("ConfNum", p.getConfNum());
	         rowSet.updateDate("rDate", p.getrDate());
	         rowSet.updateString("Username", p.getUsername());
	         rowSet.insertRow();
	         rowSet.moveToCurrentRow();
	      } catch (SQLException ex) {
	         try {
	            rowSet.rollback();
	            p = null;
	         } catch (SQLException e) {

	         }
	         ex.printStackTrace();
	      }
	      return p;
	   }

	   public Purchase update(Purchase p) {
	      try {
	    	 rowSet.updateString("ConfNum", p.getConfNum());
		     rowSet.updateDate("rDate", p.getrDate());
		     rowSet.updateString("Username", p.getUsername());
	         rowSet.updateRow();
	         rowSet.moveToCurrentRow();
	      } catch (SQLException ex) {
	         try {
	            rowSet.rollback();
	         } catch (SQLException e) {

	         }
	         ex.printStackTrace();
	      }
	      return p;
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

	   public Purchase getCurrent() {
	      Purchase p = new Purchase();
	      try {
	         rowSet.moveToCurrentRow();
	         p.setConfNum(rowSet.getString("ConfNum"));
	         p.setrDate(rowSet.getDate("rDate"));
	         p.setUsername(rowSet.getString("Username"));
	      } catch (SQLException ex) {
	         ex.printStackTrace();
	      }
		  return p;
	   }
}
