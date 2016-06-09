import java.sql.*; 
 
class DC
   //note that to make this run, you may need to load the classes for the driver below
   //just add the line below in your .bashrc file, which is located in your home directory on the ugrad machines
   //export CLASSPATH=.:$ORACLE_HOME/jdbc/lib/classes12.zip:$CLASSPATH
{
    public static void main(String argv[]) 
    {
       Connection con = null;
       //con is the connection object that connects to the oracle database

       if (argv.length != 2)
       {
       //userid and passwd are arguments accepted at runtime
       //to use, type: java DC userid passwd
       //userid = ora_r2d2 where r2d2 is your cpscid
       //passwd = a12345674 where the numbers are replaced by your student number
	   System.out.println("Usage: DatabaseTest test <userid> <pass>");
	   System.exit(-1);
       }

       String userid = argv[0];
       String passwd = argv[1];
       
       String url = "jdbc:oracle:thin:@localhost:1522:ug";

       try
       {
	   System.out.println("Loading driver ...");

	   //Class.forName("oracle.jdbc.driver.OracleDriver");
       //If the code below doesnt work use the commented code above
	   DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
       //this code loads the driver and registers it with JDBC
       //driverManager acts as a "facade" to the drivers, which are themselves interfaces, by ensuring that the correct driver function is called

	   System.out.println("Driver loaded.");
       }
       catch (Exception e)
       {
	   System.out.println("Unable to load driver\n" + e);
	   System.exit(-1);
       }

       try 
       {  
	   System.out.println("Connecting to Oracle ...");
       //once the driver has been registered and loaded from above, we set up a connection to Oracle database
       //The url above is specific to the Oracle database on the Ugrad machine.
 
	   con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:ug", "ora_csid", "a12312323");
 
	   System.out.println("Connection successful.");
	    
       } 
       catch( Exception e ) 
       {
	   System.out.println("Connection failed\n" + e);
       }

       try
       {
	   System.out.println("Selecting amount sold from dailyLog where gross is greater than 60");
       //below is a querry example
       //connection object has a create statement method which returns a statement object.
       //use executeQuerry to obtain a response object
       //the rs.next moves a cursor through the data returned so that one can retrieve it
       //more in tutorial, which is where all this is from :)

	   Statement stmt = con.createStatement();
	   ResultSet rs = stmt.executeQuery("SELECT amt_sold FROM DailyLog WHERE Gross > 60");

	   while(rs.next())
	   {
	       System.out.println(rs.getString(1));
	   }
       }
       catch (SQLException ex)
       {
	   System.out.println(ex);
       }
    }
}