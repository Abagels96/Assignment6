package com.coderscampus.assignment6;

//need to read file
//need to add file's lines to vehicle class and turn it into an object
//need to add to arrayList so I can use stream
//need to filter cars by dates containing 17,18, and 19 in them return that list
///need to get number of cars in 2017,2018,2019 and add them
// need to compare the whole list and see which month/year had the best/worst sales 
//need to repeat for two more models

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VehicleService {
	Integer i=0;
	ArrayList<Vehicle> manyCars= new ArrayList();
	String [] another= new String[4];

//	Vehicle vehicle= new Vehicle();
	String[] months= {"January", "February,",
			"March","April","May","June","July","August","September","October","November","December"};
	
	public  int  findMonth(String abbreviation) {
	Optional<Month> theTruth= Arrays.stream(Month.values())
		      .filter(months -> months.name().substring(0, 3).equalsIgnoreCase(abbreviation))
		      .findFirst();
	System.out.println(theTruth);
//System.out.println( theTruth.orElseThrow(IllegalArgumentException::new).getValue());
	return theTruth.orElseThrow(IllegalArgumentException::new).getValue();}
public void readFile() throws IOException {
	
	BufferedReader reader=null;
	try {
	reader= new BufferedReader(new FileReader("src/modelS.csv"));
		
		String lines="";
		reader.readLine();
		while((lines=reader.readLine())!=null) {
			System.out.println(lines);
			
			another=lines.split("-");
		String flarf= Arrays.toString(another);
		System.out.println(flarf);
another=flarf.split(",");
System.out.println(Arrays.toString(another));
System.out.println( another[0].getClass().getName());
Integer month= findMonth(another[0].replaceAll("[(){}<>\\[\\]]",""));		
//System.out.println(month);
			
Integer year=Integer.parseInt(another[1].strip());
System.out.println(year);
Integer sales= Integer.parseInt(another[2].replaceAll("[(){}<>\\[\\]]",""));
System.out.println(sales);
System.out.println(another[0].replaceAll("[(){}<>\\[\\]]", ""));
			
Vehicle vehicle= new Vehicle(month, year, sales);
System.out.println(vehicle.getSales().getClass().toString());
			
manyCars.add(vehicle);		}
	
	for(Object cars:manyCars) {
		System.out.println(cars);
		}
	System.out.println(manyCars.getClass().getName());
	List<Vehicle> year2016=	manyCars.stream()
			.filter(vehicle->vehicle.getYear()
					.equals(16)).collect(Collectors.toList());	
	System.out.println(year2016);
Integer total=	year2016.stream().map(Vehicle::getSales).collect(Collectors.summingInt(x->x));
System.out.println(total);
	
	List<Vehicle> year2017=	manyCars.stream()
			 .filter(vehicle->vehicle.getYear()
			                        .equals(17)).collect(Collectors.toList());	
	
	
	System.out.println(year2017);
	Integer total2=	year2017.stream().map(Vehicle::getSales).collect(Collectors.summingInt(x->x));
	System.out.println(total2);
	List<Vehicle> year2018=	manyCars.stream()
			.filter(vehicle->vehicle.getYear()
					.equals(18)).collect(Collectors.toList());	
	System.out.println(year2018);
	Integer total3=	year2018.stream().map(Vehicle::getSales).collect(Collectors.summingInt(x->x));
	System.out.println(total3);
	List<Vehicle> year2019=	manyCars.stream()
			.filter(vehicle->vehicle.getYear()
					.equals(19)).collect(Collectors.toList());	
	System.out.println(year2019);
	Integer total4=	year2019.stream().map(Vehicle::getSales).collect(Collectors.summingInt(x->x));
	System.out.println(total4);

	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		reader.close();
	}
	
	}
}
