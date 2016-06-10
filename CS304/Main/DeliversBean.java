package Main;

import java.sql.*;
import java.sql.SQLException;
import javax.sql.rowset.*;
import javax.sql.rowset.JdbcRowSet;
import com.sun.rowset.JdbcRowSetImpl;

public class DeliversBean {
	   static final String JDBC_DRIVER =
			      "com.mysql.jdbc.Driver";
	   static final String DB_URL =
	      "jdbc:mysql://localhost:3306/mydatabase";
	   static final String DB_USER = "user1";
	   static final String DB_PASS = "secret";
	   private JdbcRowSet rowSet = null;
	   public DeliversBean() {
	      try {
	         Class.forName(JDBC_DRIVER);
	         rowSet = new JdbcRowSetImpl();
	         rowSet.setUrl(DB_URL);
	         rowSet.setUsername(DB_USER);
	         rowSet.setPassword(DB_PASS);
	         rowSet.setCommand("SELECT * FROM DAILYLOG");
	         rowSet.execute();
	      }

	      catch (SQLException | ClassNotFoundException ex) {
	         ex.printStackTrace();
	      }
	   }
	   public Delivers create(Delivers d) {
	      try {
	         rowSet.moveToInsertRow();
	         rowSet.updateString("ConfNum", d.getConfNum());
	         rowSet.updateString("DroneID", d.getDroneID());
	         rowSet.updateString("Status", d.getStatus());
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

	   public Delivers update(Delivers d) {
	      try {
	    	 rowSet.updateString("ConfNum", d.getConfNum());
		     rowSet.updateString("DroneID", d.getDroneID());
		     rowSet.updateString("Status", d.getStatus());
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

	   public Delivers getCurrent() {
	      Delivers d = new Delivers();
	      try {
	         rowSet.moveToCurrentRow();
	         d.setConfNum(rowSet.getString("ConfNum"));
	         d.setDroneID(rowSet.getString("DroneID"));
	         d.setStatus(rowSet.getString("Status"));
	      } catch (SQLException ex) {
	         ex.printStackTrace();
	      }
	      return d;
	   }
}
