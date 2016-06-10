package Main;

import java.sql.*;
import java.sql.SQLException;
import javax.sql.rowset.*;
import javax.sql.rowset.JdbcRowSet;

public class FoodItemBean {
	   static final String JDBC_DRIVER =
			      "com.mysql.jdbc.Driver";
	   static final String DB_URL =
	      "jdbc:mysql://localhost:3306/mydatabase";
	   static final String DB_USER = "user1";
	   static final String DB_PASS = "secret";
	   private JdbcRowSet rowSet = null;
	   public FoodItemBean() {
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
	   public FoodItem create(FoodItem f) {
	      try {
	         rowSet.moveToInsertRow();
	         rowSet.updateString("RestaurantName", f.getRestaurantName());
	         rowSet.updateString("FoodName", f.getFoodName());
	         rowSet.updateString("ItemID", f.getItemID());
	         rowSet.updateString("Category", f.getCategory());
	         rowSet.updateString("Price", f.getPrice());
	         rowSet.updateString("Description", f.getDescription());
	         rowSet.insertRow();
	         rowSet.moveToCurrentRow();
	      } catch (SQLException ex) {
	         try {
	            rowSet.rollback();
	            f = null;
	         } catch (SQLException e) {

	         }
	         ex.printStackTrace();
	      }
	      return f;
	   }

	   public FoodItem update(FoodItem f) {
	      try {
	    	 rowSet.updateString("RestaurantName", f.getRestaurantName());
	         rowSet.updateString("FoodName", f.getFoodName());
	         rowSet.updateString("ItemID", f.getItemID());
	         rowSet.updateString("Category", f.getCategory());
	         rowSet.updateString("Price", f.getPrice());
	         rowSet.updateString("Description", f.getDescription());
	         rowSet.updateRow();
	         rowSet.moveToCurrentRow();
	      } catch (SQLException ex) {
	         try {
	            rowSet.rollback();
	         } catch (SQLException e) {

	         }
	         ex.printStackTrace();
	      }
	      return f;
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

	   public FoodItem getCurrent() {
	      FoodItem f = new FoodItem();
	      try {
	         rowSet.moveToCurrentRow();
	         f.setRestaurantName(rowSet.getString("RestaurantName"));
	         f.setFoodName(rowSet.getString("FoodName"));
	         f.setItemID(rowSet.getString("ItemID"));
	         f.setCategory(rowSet.getString("Category"));
	         f.setPrice(rowSet.getString("Price"));
	         f.setDescription(rowSet.getString("Description"));
	      } catch (SQLException ex) {
	         ex.printStackTrace();
	      }
		  return f;
	   }
}

