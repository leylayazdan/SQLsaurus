package Main;

public class Drone {
	 private String DroneID;
	 private String Manufacturer;
	 private String Model;
	 
	 public Drone() {
	 }
	 
	 public String getDroneID(){
		 return DroneID;
	 }
	 
	 public void setDroneID(String DroneID){
		 this.DroneID = DroneID;
	 }
	 
	 public String getManufacturer(){
		 return Manufacturer;
	 }
	 
	 public void setManufacturer(String Manufacturer){
		 this.Manufacturer = Manufacturer;
	 }
	 
	 public String getModel(){
		 return Model;
	 }
	 
	 public void setModel(String Model){
		 this.Model = Model;
	 }
}
