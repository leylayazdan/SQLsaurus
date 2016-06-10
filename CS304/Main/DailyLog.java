package Main;

import java.sql.Date;

public class DailyLog {
	private Date rDate;
	private int SoldQty;
	private int Expenses;
	private int Gross;
	 
	public DailyLog() {
	}

	public Date getrDate() {
		return rDate;
	}

	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}

	public int getSoldQty() {
		return SoldQty;
	}

	public void setSoldQty(int soldQty) {
		SoldQty = soldQty;
	}

	public int getExpenses() {
		return Expenses;
	}

	public void setExpenses(int expenses) {
		Expenses = expenses;
	}

	public int getGross() {
		return Gross;
	}

	public void setGross(int gross) {
		Gross = gross;
	}
}
