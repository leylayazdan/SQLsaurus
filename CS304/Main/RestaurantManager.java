package Main;

public class RestaurantManager {
	 private String Username;
	 private String Password;
	 private String Name;
	 private String Email;
	 
	 public RestaurantManager(){
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
