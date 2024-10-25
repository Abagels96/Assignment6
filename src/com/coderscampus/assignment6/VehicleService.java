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
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleService {
//YearMonth yearMonth=  new YearMonth();
	ArrayList<Object> manyCars= new ArrayList();
	Integer[] pieces= new Integer[32];
	public void readFile() throws IOException {
	try {
		BufferedReader reader= new BufferedReader(new FileReader("src/modelS.csv"));
		
		String lines="";
		reader.readLine();
		while((lines=reader.readLine())!=null) {
			System.out.println(lines);
//			Integer number=Integer.parseInt(lines);
//			pieces= number;
			manyCars.add(lines);
			
		}
		
//	List<Object> dates=	manyCars.stream().filter(a-> a.date().equals(17)).collect(Collectors.toList());
//		for(Object cars:manyCars) {
//			System.out.println(cars);
//		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
