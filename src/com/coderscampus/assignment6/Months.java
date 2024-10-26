package com.coderscampus.assignment6;

public enum Months {

	
	JAN(" January "),
	FEB("February");
	
	private String monthName;
	


	public String getMonthName() {
		return monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	private  Months (String monthName) {
		this.monthName=monthName;
	}
}
