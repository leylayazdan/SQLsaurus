package Main;

import java.sql.*;
import java.sql.SQLException;
import javax.sql.rowset.*;
import javax.sql.rowset.JdbcRowSet;
import com.sun.rowset.JdbcRowSetImpl;

public class isSelectedBean {
	   static final String JDBC_DRIVER =
			      "com.mysql.jdbc.Driver";
	   static final String DB_URL =
	      "jdbc:mysql://localhost:3306/mydatabase";
	   static final String DB_USER = "user1";
	   static final String DB_PASS = "secret";
	   private JdbcRowSet rowSet = null;
	   public isSelectedBean() {
	      try {
	         Class.forName(JDBC_DRIVER);
	         rowSet = new JdbcRowSetImpl();
	         rowSet.setUrl(DB_URL);
	         rowSet.setUsername(DB_USER);
	         rowSet.setPassword(DB_PASS);
	         rowSet.setCommand("SELECT * FROM isSelected");
	         rowSet.execute();
	      }

	      catch (SQLException | ClassNotFoundException ex) {
	         ex.printStackTrace();
	      }
	   }
	   public isSelected create(isSelected s) {
	      try {
	         rowSet.moveToInsertRow();
	         rowSet.updateString("ConfNum", s.getConfNum());
	         rowSet.updateString("RestaurantName", s.getRestaurantName());
	         rowSet.updateString("FoodName", s.getFoodName());
	         rowSet.insertRow();
	         rowSet.moveToCurrentRow();
	      } catch (SQLException ex) {
	         try {
	            rowSet.rollback();
	            s = null;
	         } catch (SQLException e) {

	         }
	         ex.printStackTrace();
	      }
	      return s;
	   }

	   public isSelected update(isSelected s) {
	      try {
	    	 rowSet.updateString("ConfNum", s.getConfNum());
		     rowSet.updateString("RestaurantName", s.getRestaurantName());
		     rowSet.updateString("FoodName", s.getFoodName());
	         rowSet.updateRow();
	         rowSet.moveToCurrentRow();
	      } catch (SQLException ex) {
	         try {
	            rowSet.rollback();
	         } catch (SQLException e) {

	         }
	         ex.printStackTrace();
	      }
	      return s;
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

	   public isSelected getCurrent() {
	      isSelected s = new isSelected();
	      try {
	         rowSet.moveToCurrentRow();
	         s.setConfNum(rowSet.getString("ConfNum"));
	         s.setRestaurantName(rowSet.getString("RestaurantName"));
	         s.setFoodName(rowSet.getString("FoodName"));
	      } catch (SQLException ex) {
	         ex.printStackTrace();
	      }
		  return s;
	   }
}
