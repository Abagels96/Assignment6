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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VehicleService {
	Integer i = 0;
	ArrayList<Vehicle> manyCars = new ArrayList();
	String[] another = new String[4];

//	Vehicle vehicle= new Vehicle();
	String[] months = { "January", "February,", "March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December" };

	public int findMonth(String abbreviation) {
		Optional<Month> theTruth = Arrays.stream(Month.values())
				.filter(months -> months.name().substring(0, 3).equalsIgnoreCase(abbreviation)).findFirst();
//		System.out.println(theTruth);
//System.out.println( theTruth.orElseThrow(IllegalArgumentException::new).getValue());
		return theTruth.orElseThrow(IllegalArgumentException::new).getValue();
	}

	public void readFile(String fileName) throws IOException {

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));

			String lines = "";
			reader.readLine();
			while ((lines = reader.readLine()) != null) {
//				System.out.println(lines);

				another = lines.split("-");
				String flarf = Arrays.toString(another);
//				System.out.println(flarf);
				another = flarf.split(",");
//				System.out.println(Arrays.toString(another));
				Integer month = findMonth(another[0].replaceAll("[(){}<>\\[\\]]", ""));
//System.out.println(month);

				Integer year = Integer.parseInt(another[1].strip());
//				System.out.println(year);
				Integer sales = Integer.parseInt(another[2].replaceAll("[(){}<>\\[\\]]", ""));
//				System.out.println(sales);

				Vehicle vehicle = new Vehicle(month, year, sales);

				manyCars.add(vehicle);
			}
			Collections.sort(manyCars, Comparator.comparingInt(Vehicle::getSales));

//			for (Object cars : manyCars) {
//				System.out.println(cars);
//			}

			List<Vehicle> year2016 = manyCars.stream().filter(vehicle -> vehicle.getYear().equals(16))
					.collect(Collectors.toList());
			Integer total = year2016.stream().map(Vehicle::getSales).collect(Collectors.summingInt(x -> x));

			List<Vehicle> year2017 = manyCars.stream().filter(vehicle -> vehicle.getYear().equals(17))
					.collect(Collectors.toList());

			Integer total2 = year2017.stream().map(Vehicle::getSales).collect(Collectors.summingInt(x -> x));
			List<Vehicle> year2018 = manyCars.stream().filter(vehicle -> vehicle.getYear().equals(18))
					.collect(Collectors.toList());
			Integer total3 = year2018.stream().map(Vehicle::getSales).collect(Collectors.summingInt(x -> x));
			List<Vehicle> year2019 = manyCars.stream().filter(vehicle -> vehicle.getYear().equals(19))
					.collect(Collectors.toList());
			Integer total4 = year2019.stream().map(Vehicle::getSales).collect(Collectors.summingInt(x -> x));

			generateReport(fileName, total, total2, total3, total4);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			reader.close();
		}

	}

	public void generateReport(String fileName, Integer total, Integer total2, Integer total3, Integer total4) {
		Vehicle loser = manyCars.get(0);
		Integer loserMonth = loser.getMonth();
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("20yy-MM");
		Integer loserYear = loser.getYear();
//		System.out.println(loserMonth);
//		System.out.println(loserYear);
		Vehicle winner = manyCars.get(manyCars.size() - 1);
//		System.out.println(winner);
		Integer winnerMonth = winner.getMonth();
		Integer winnerYear = winner.getYear();
String variable="";
		if(fileName.contains("S")) {
		
		variable = "S";
		}
		else if(fileName.contains("X")) {
			variable="X";
		}
		else variable="3";
		
		System.out.println("MODEL " + variable + " YEARLY SALES REPORT ");
		System.out.println("---------------");
		System.out.println("2016->" + total);
		System.out.println("2017->" + total2);
		System.out.println("2018->" + total3);
		System.out.println("2019->" + total4);
		String bestYearMonth = YearMonth.of(winnerYear, winnerMonth).format(pattern);
		String worstYearMonth = YearMonth.of(loserYear, loserMonth).format(pattern);
		System.out.println("The best month for the Model" + variable + " was: " + bestYearMonth);
		System.out.println("The worst month for the Model" + variable + " was: " + worstYearMonth);
	}
}
