package Main;

import java.sql.Date;

public class Reviews {
	private Date rDate;
	private String Username;
	 
	public Reviews() {
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
