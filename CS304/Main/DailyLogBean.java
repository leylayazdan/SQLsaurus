package Main;

import java.sql.*;
import java.sql.SQLException;
import javax.sql.rowset.*;
import javax.sql.rowset.JdbcRowSet;

public class DailyLogBean {
	   static final String JDBC_DRIVER =
			      "com.mysql.jdbc.Driver";
	   static final String DB_URL =
	      "jdbc:mysql://localhost:3306/mydatabase";
	   static final String DB_USER = "user1";
	   static final String DB_PASS = "secret";
	   private JdbcRowSet rowSet = null;
	   public DailyLogBean() {
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
	   public DailyLog create(DailyLog d) {
	      try {
	         rowSet.moveToInsertRow();
	         rowSet.updateDate("rDate", d.getrDate());
	         rowSet.updateInt("Password", d.getSoldQty());
	         rowSet.updateInt("Name", d.getExpenses());
	         rowSet.updateInt("Email", d.getGross());
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

	   public DailyLog update(DailyLog d) {
	      try {
	    	 rowSet.updateDate("rDate", d.getrDate());
		     rowSet.updateInt("Password", d.getSoldQty());
		     rowSet.updateInt("Name", d.getExpenses());
		     rowSet.updateInt("Email", d.getGross());
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

	   public DailyLog getCurrent() {
	      DailyLog d = new DailyLog();
	      try {
	         rowSet.moveToCurrentRow();
	         d.setrDate(rowSet.getDate("Date"));
	         d.setSoldQty(rowSet.getInt("SoldQty"));
	         d.setExpenses(rowSet.getInt("Expenses"));
	         d.setGross(rowSet.getInt("Gross"));
	      } catch (SQLException ex) {
	         ex.printStackTrace();
	      }
	      return d;
	   }
}
