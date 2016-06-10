package Main;

public class Delivers {
	 private String ConfNum;
	 private String DroneID;
	 private String Status;
	 
	 public Delivers() {
	 }
	 
	 public String getDroneID(){
		 return DroneID;
	 }
	 
	 public void setDroneID(String DroneID){
		 this.DroneID = DroneID;
	 }
	 
	 public String getConfNum(){
		 return ConfNum;
	 }
	 
	 public void setConfNum(String ConfNum){
		 this.ConfNum = ConfNum;
	 }
	 
	 public String getStatus(){
		 return Status;
	 }
	 
	 public void setStatus(String Status){
		 this.Status = Status;
	 }
}
