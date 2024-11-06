package com.coderscampus.assignment6;

import java.time.YearMonth;

public class Vehicle {
Integer sales;
YearMonth yearMonth;
public YearMonth getYearMonth() {
	return yearMonth;
}
public void setYearMonth(YearMonth yearMonth) {
	this.yearMonth = yearMonth;
}







public Integer getSales() {
	return sales;
}public Vehicle( YearMonth year,Integer sales) {
	super();
	this.yearMonth=year;
	this.sales = sales;
}
 


public void setSales(Integer sales) {
	this.sales = sales;
}
@Override
public String toString() {
	return "Vehicle [sales=" + sales + ", year and month=" + yearMonth + " ]";
}



}
