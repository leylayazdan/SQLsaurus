package Main;

public class Drone {
	 private String DroneID;
	 private String Manufacturer;
	 private String Model;
	 
	 public Drone(String DroneID, String Manufacturer, String Model){
		 this.DroneID = DroneID;
		 this.Manufacturer = Manufacturer;
		 this.Model = Model;
	 }
	 
	 public String getDroneID(){
		 return DroneID;
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
