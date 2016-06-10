package Main;

import java.sql.Date;

public class Purchase {
	private String ConfNum;
	private Date rDate;
	private String Username;
	 
	public Purchase() {
	
	}

	public String getConfNum() {
		return ConfNum;
	}

	public void setConfNum(String confNum) {
		ConfNum = confNum;
	}

	public Date getrDate() {
		return rDate;
	}

	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}
	
	
}
