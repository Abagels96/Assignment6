package com.coderscampus.assignment6;


public class Vehicle {
Integer sales;
Integer year;
Integer month;
public Integer getYear() {
	return year;
}
public void setYear(Integer year) {
	this.year = year;
}






public Integer getSales() {
	return sales;
}public Vehicle(Integer month, Integer year,Integer sales) {
	super();
	this.month=month;
	this.year=year;
	this.sales = sales;
}
 

public Integer getMonth() {
	return month;
}
public void setMonth(Integer month) {
	this.month = month;
}
public void setSales(Integer sales) {
	this.sales = sales;
}
@Override
public String toString() {
	return "Vehicle [sales=" + sales + ", year=" + year + " ,month=" + month+"]";
}



}
