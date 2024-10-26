package com.coderscampus.assignment6;

import java.time.YearMonth;

public class Vehicle {
Integer sales;
Enum months;
YearMonth date;
public void setDate(YearMonth date) {
	this.date = date;
}
public Enum getMonth() {
	return months;
}
public void setMonth( Enum months) {
	this.months = months;
}
public Integer getSales() {
	return sales;
}public Vehicle(YearMonth date, Integer sales) {
	super();
	this.sales = sales;
	this.date = date;
}

public void setSales(Integer sales) {
	this.sales = sales;
}
public YearMonth getDate() {
	return date;
}


}
