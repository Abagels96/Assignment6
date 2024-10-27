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
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VehicleService {
	Integer i=0;
	ArrayList<Object> manyCars= new ArrayList();
	String [] another= new String[4];

//	Vehicle vehicle= new Vehicle();
	String[] months= {"January", "February,",
			"March","April","May","June","July","August","September","October","November","December"};
	
	public  int  findMonth(String abbreviation) {
	Optional<Month> theTruth=	Arrays.stream(Month.values())
			                          .filter(month->month.name()
					                  .substring(0,3)
					                  .equalsIgnoreCase(abbreviation))
			                          .findFirst();
	System.out.println(theTruth);
	System.out.println();
//System.out.println( theTruth.orElseThrow(IllegalArgumentException::new).getValue());
	return theTruth.orElseThrow(IllegalArgumentException::new).getValue();
	}
public void readFile() throws IOException {
	try {
		BufferedReader reader= new BufferedReader(new FileReader("src/modelS.csv"));
		
		String lines="";
		reader.readLine();
		while((lines=reader.readLine())!=null) {
			System.out.println(lines);
			
			another=lines.split("-");
		String flarf= Arrays.toString(another);
		System.out.println(flarf);
another=flarf.split(",");
System.out.println(Arrays.toString(another));
				
//
			
			
			
		}
		Integer month= findMonth(another[0]); 
		Integer year=Integer.parseInt(another[1].strip());
		System.out.println(year);
		Integer sales= Integer.parseInt(another[2].replaceAll("[(){}<>\\[\\]]",""));
		System.out.println(sales);
		Vehicle vehicle= new Vehicle(month, year, sales);
		manyCars.add(vehicle);
		for(Object cars:manyCars) {
		System.out.println(cars);
		}
	Optional <Object> year2017=	manyCars.stream()
			                        .filter(a-> vehicle.month
			                        .equals(5))
			                        .findFirst();
	System.out.println(year2017);

	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
