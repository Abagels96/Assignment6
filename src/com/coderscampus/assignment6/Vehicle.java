package com.coderscampus.assignment6;

public class Vehicle {
Integer sales;
Integer date;
public Integer getSales() {
	return sales;
}public Vehicle(Integer sales, Integer date) {
	super();
	this.sales = sales;
	this.date = date;
}

public void setSales(Integer sales) {
	this.sales = sales;
}
public Integer getDate() {
	return date;
}
public void setDate(Integer date) {
	this.date = date;
}

}
