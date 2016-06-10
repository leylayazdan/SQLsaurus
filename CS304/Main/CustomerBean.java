package Main;

import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;

public class CustomerBean {
	   static final String JDBC_DRIVER =
			      "com.mysql.jdbc.Driver";
	   static final String DB_URL =
	      "jdbc:mysql://localhost:3306/mydatabase";
	   static final String DB_USER = "user1";
	   static final String DB_PASS = "secret";
	   private JdbcRowSet rowSet = null;
	   public CustomerBean() {
	      try {
	         Class.forName(JDBC_DRIVER);
	         rowSet = new JdbcRowSetImpl();
	         rowSet.setUrl(DB_URL);
	         rowSet.setUsername(DB_USER);
	         rowSet.setPassword(DB_PASS);
	         rowSet.setCommand("SELECT * FROM Person");
	         rowSet.execute();

	      catch (SQLException | ClassNotFoundException ex) {
	         ex.printStackTrace();
	      }
	   }
	   public Customer create(Customer c) {
	      try {
	         rowSet.moveToInsertRow();
	         rowSet.updateString("Username", c.getUsername());
	         rowSet.updateString("Password", c.getPassword());
	         rowSet.updateString("Name", c.getName());
	         rowSet.updateString("Email", c.getEmail());
	         rowSet.updateString("CreditCard", c.getCreditCard());
	         rowSet.updateString("Address", c.getAddress());
	         rowSet.updateString("City", c.getCity());
	         rowSet.updateString("Province", c.getProvince());
	         rowSet.updateString("Phone", c.getPhone());
	         rowSet.insertRow();
	         rowSet.moveToCurrentRow();
	      } catch (SQLException ex) {
	         try {
	            rowSet.rollback();
	            c = null;
	         } catch (SQLException e) {

	         }
	         ex.printStackTrace();
	      }
	      return c;
	   }

	   public Customer update(Customer c) {
	      try {
	    	 rowSet.updateString("Username", c.getUsername());
	         rowSet.updateString("Password", c.getPassword());
	         rowSet.updateString("Name", c.getName());
	         rowSet.updateString("Email", c.getEmail());
	         rowSet.updateString("CreditCard", c.getCreditCard());
	         rowSet.updateString("Address", c.getAddress());
	         rowSet.updateString("City", c.getCity());
	         rowSet.updateString("Province", c.getProvince());
	         rowSet.updateString("Phone", c.getPhone());
	         rowSet.updateRow();
	         rowSet.moveToCurrentRow();
	      } catch (SQLException ex) {
	         try {
	            rowSet.rollback();
	         } catch (SQLException e) {

	         }
	         ex.printStackTrace();
	      }
	      return c;
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

	   public Customer getCurrent() {
	      Customer c = new Customer();
	      try {
	         rowSet.moveToCurrentRow();
	         c.setUsername(rowSet.getString("Username"));
	         c.setPassword(rowSet.getString("Password"));
	         c.setName(rowSet.getString("Name"));
	         c.setEmail(rowSet.getString("Email"));
	         c.setCreditCard(rowSet.getString("CreditCard"));
	         c.setAddress(rowSet.getString("Address"));
	         c.setCity(rowSet.getString("City"));
	         c.setProvince(rowSet.getString("Province"));
	         c.setPhone(rowSet.getString("Phone"));
	      } catch (SQLException ex) {
	         ex.printStackTrace();
	      }
	      return c;
	   }
}
