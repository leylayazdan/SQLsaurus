package Main;

import java.sql.Connection;

public class Administrator {
	 private String EmployeeID;
	 private String Username;
	 private String Password;
	 private String Email;
	 private String Name;
	 
	 public Administrator() {
		 
	 }
	 
	 public String getEmployeeID(){
		 return EmployeeID;
	 }
	 
	 public void setEmployeeID(String EmployeeID){
		 this.EmployeeID = EmployeeID;
	 }
	 
	 public String getUsername(){
		 return Username;
	 }
	 
	 public void setUsername(String Username){
		 this.Username = Username;
	 }
	 
	 public String getPassword(){
		 return Password;
	 }
	 
	 public void setPassword(String Password){
		 this.Password = Password;
	 }
	 
	 public String getEmail(){
		 return Email;
	 }
	 
	 public void setEmail(String Email){
		 this.Email = Email;
	 }
	 
	 public String getName(){
		 return Name;
	 }
	 
	 public void setName(String Name){
		 this.Name = Name;
	 }
}
