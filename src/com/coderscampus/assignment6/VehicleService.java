
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
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VehicleService {
	Integer i = 0;
	ArrayList<Vehicle> firstArray = new ArrayList<Vehicle>();
	ArrayList<Vehicle> secondArray = new ArrayList<Vehicle>();
	ArrayList<Vehicle> thirdArray = new ArrayList<Vehicle>();
	String[] mainArray0 = new String[4];
	String[] mainArray1 = new String[4];
	String[] mainArray2 = new String[4];

//	Vehicle vehicle= new Vehicle();
	String[] months = { "January", "February,", "March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December" };

	public int findMonth(String abbreviation) {
		Optional<Month> theTruth = Arrays.stream(Month.values())
				.filter(months -> months.name().substring(0, 3).equalsIgnoreCase(abbreviation)).findFirst();
		return theTruth.orElseThrow(IllegalArgumentException::new).getValue();
	}

	public void compileArray(String fileName, String fileName2, String fileName3) throws IOException {

		Vehicle vehicle = new Vehicle();
		BufferedReader reader = null;
		BufferedReader reader2 = null;
		BufferedReader reader3 = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			reader2 = new BufferedReader(new FileReader(fileName2));
			reader3 = new BufferedReader(new FileReader(fileName3));

			String lines = "";
			reader.readLine();
			while ((lines = reader.readLine()) != null) {

				mainArray0 = lines.split("-");
				String secondaryArray = Arrays.toString(mainArray0);
				mainArray0 = secondaryArray.split(",");

				YearMonth yearMonth = YearMonth.of(Integer.parseInt(mainArray0[1].strip()),
						findMonth(mainArray0[0].replaceAll("[(){}<>\\[\\]]", "")));
				Integer sales = Integer.parseInt(mainArray0[2].replaceAll("[(){}<>\\[\\]]", ""));

				Vehicle vehicle0 = new Vehicle(yearMonth, sales);

				firstArray.add(vehicle0);

			}

			String lines1 = "";
			reader2.readLine();
			while ((lines1 = reader2.readLine()) != null) {
//				.out.println(lines1);
				mainArray1 = lines1.split("-");
				String secondaryArray = Arrays.toString(mainArray1);
				mainArray1 = secondaryArray.split(",");

				vehicle.setSales(Integer.parseInt(mainArray1[2].replaceAll("[(){}<>\\[\\]]", "")));
				vehicle.setYearMonth(YearMonth.of(Integer.parseInt(mainArray1[1].strip()),
						findMonth(mainArray1[0].replaceAll("[(){}<>\\[\\]]", ""))));
				Vehicle vehicle1 = new Vehicle(vehicle.getYearMonth(), vehicle.getSales());

				secondArray.add(vehicle1);
			}

			String lines2 = "";
			reader3.readLine();
			while ((lines2 = reader3.readLine()) != null) {
				mainArray2 = lines2.split("-");
				String secondaryArray = Arrays.toString(mainArray2);
				mainArray2 = secondaryArray.split(",");

				YearMonth yearMonth = YearMonth.of(Integer.parseInt(mainArray2[1].strip()),
						findMonth(mainArray2[0].replaceAll("[(){}<>\\[\\]]", "")));
				Integer sales = Integer.parseInt(mainArray2[2].replaceAll("[(){}<>\\[\\]]", ""));

				Vehicle vehicle2 = new Vehicle(yearMonth, sales);
				thirdArray.add(vehicle2);

			}

			Collections.sort(firstArray, Comparator.comparingInt(Vehicle::getSales));
			for (Vehicle vehicles : firstArray) {
			}
			Collections.sort(secondArray, Comparator.comparingInt(Vehicle::getSales));
			for (Vehicle vehicles1 : secondArray) {
			}
			Collections.sort(thirdArray, Comparator.comparingInt(Vehicle::getSales));
			for (Vehicle vehicles2 : thirdArray) {
			}

			streamSales(fileName, fileName2, fileName3);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			reader.close();
			reader2.close();
			reader3.close();
		}

	}

	public void streamSales(String fileName, String fileName2, String fileName3) {
		Map<YearMonth, Integer> year2016 = firstArray.stream()
				.filter(vehicle0 -> vehicle0.getYearMonth().getYear() == (0016))
				.collect(Collectors.toMap(vehicle0 -> vehicle0.getYearMonth(), vehicle0 -> vehicle0.getSales()));

		Map<YearMonth, Integer> secondYear2016 = secondArray.stream()
				.filter(vehicle1 -> vehicle1.getYearMonth().getYear() == (16))
				.collect(Collectors.toMap(vehicle1 -> vehicle1.getYearMonth(), vehicle1 -> vehicle1.getSales()));
		Map<YearMonth, Integer> thirdYear2016 = thirdArray.stream()
				.filter(vehicle2 -> vehicle2.getYearMonth().getYear() == (16))
				.collect(Collectors.toMap(vehicle2 -> vehicle2.getYearMonth(), vehicle2 -> vehicle2.getSales()));

		Integer total = year2016.values().stream().reduce(0, Integer::sum);
		Integer totalB = secondYear2016.values().stream().reduce(0, Integer::sum);
		Integer totalC = thirdYear2016.values().stream().reduce(0, Integer::sum);

		Map<YearMonth, Integer> year2017 = firstArray.stream()
				.filter(vehicle -> vehicle.getYearMonth().getYear() == (17))
				.collect(Collectors.toMap(vehicle -> vehicle.getYearMonth(), vehicle -> vehicle.getSales()));
		Map<YearMonth, Integer> secondYear2017 = secondArray.stream()
				.filter(vehicle1 -> vehicle1.getYearMonth().getYear() == (17))
				.collect(Collectors.toMap(vehicle1 -> vehicle1.getYearMonth(), vehicle1 -> vehicle1.getSales()));
		Map<YearMonth, Integer> thirdYear2017 = thirdArray.stream()
				.filter(vehicle2 -> vehicle2.getYearMonth().getYear() == (17))
				.collect(Collectors.toMap(vehicle2 -> vehicle2.getYearMonth(), vehicle2 -> vehicle2.getSales()));
		int total2 = year2017.values().stream().reduce(0, Integer::sum);
		int total2B = secondYear2017.values().stream().reduce(0, Integer::sum);
		int total2C = thirdYear2017.values().stream().reduce(0, Integer::sum);
		Map<YearMonth, Integer> year2018 = firstArray.stream()
				.filter(vehicle -> vehicle.getYearMonth().getYear() == (18))
				.collect(Collectors.toMap(vehicle -> vehicle.getYearMonth(), vehicle -> vehicle.getSales()));
		Map<YearMonth, Integer> secondYear2018 = secondArray.stream()
				.filter(vehicle1 -> vehicle1.getYearMonth().getYear() == (18))
				.collect(Collectors.toMap(vehicle1 -> vehicle1.getYearMonth(), vehicle1 -> vehicle1.getSales()));
		Map<YearMonth, Integer> thirdYear2018 = firstArray.stream()
				.filter(vehicle2 -> vehicle2.getYearMonth().getYear() == (18))
				.collect(Collectors.toMap(vehicle2 -> vehicle2.getYearMonth(), vehicle2 -> vehicle2.getSales()));
		Integer total3 = year2018.values().stream().reduce(0, Integer::sum);
		Integer total3B = secondYear2018.values().stream().reduce(0, Integer::sum);
		Integer total3C = thirdYear2018.values().stream().reduce(0, Integer::sum);

		Map<YearMonth, Integer> year2019 = firstArray.stream()
				.filter(vehicle -> vehicle.getYearMonth().getYear() == (19))
				.collect(Collectors.toMap(vehicle -> vehicle.getYearMonth(), vehicle -> vehicle.getSales()));
		Map<YearMonth, Integer> secondYear2019 = secondArray.stream()
				.filter(vehicle1 -> vehicle1.getYearMonth().getYear() == (19))
				.collect(Collectors.toMap(vehicle1 -> vehicle1.getYearMonth(), vehicle1 -> vehicle1.getSales()));
		Map<YearMonth, Integer> thirdYear2019 = thirdArray.stream()
				.filter(vehicle2 -> vehicle2.getYearMonth().getYear() == (19))
				.collect(Collectors.toMap(vehicle2 -> vehicle2.getYearMonth(), vehicle2 -> vehicle2.getSales()));

		Integer total4 = year2019.values().stream().reduce(0, Integer::sum);
		Integer total4B = secondYear2019.values().stream().reduce(0, Integer::sum);
		Integer total4C = thirdYear2019.values().stream().reduce(0, Integer::sum);
		generateReport(fileName, fileName2, fileName3, total, total2, total3, total4, totalB, totalC, total2B, total2C,
				total3B, total3C, total4B, total4C);
	}

	public void generateReport(String fileName, String fileName2, String fileName3, Integer total, Integer total2,
			Integer total3, Integer total4, Integer totalB, Integer totalC, Integer total2B, Integer total2C,
			Integer total3B, Integer total3C, Integer total4B, Integer total4C) {

		Vehicle loser = firstArray.get(0);
		Vehicle loser1 = secondArray.get(0);
		Vehicle loser2 = thirdArray.get(0);
		YearMonth loserTime = loser.getYearMonth();
		YearMonth loserTimea = loser1.getYearMonth();
		YearMonth loserTimeb = loser2.getYearMonth();
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("20yy-MM");
		Vehicle winner = firstArray.get(firstArray.size() - 1);
		Vehicle winner1 = secondArray.get(secondArray.size() - 1);
		Vehicle winner2 = thirdArray.get(thirdArray.size() - 1);
		YearMonth winnerTime = winner.getYearMonth();
		YearMonth winnerTimea = winner1.getYearMonth();
		YearMonth winnerTimeb = winner2.getYearMonth();

		String newName = fileName.toString().toUpperCase().substring(4, 10);
		String newName1 = fileName2.toString().toUpperCase().substring(4, 10);
		String newName2 = fileName3.toString().toUpperCase().substring(4, 10);

		System.out.println(newName + " YEARLY SALES REPORT ");
		System.out.println("---------------");
		if (total == 0) {
			System.out.println("");

		} else {

			System.out.println("2016->" + total);
		}
		System.out.println("2017->" + total2);
		System.out.println("2018->" + total3);
		System.out.println("2019->" + total4);
		String bestYearMonth = winnerTime.format(pattern);
		String worstYearMonth = loserTime.format(pattern);
		System.out.println("The best month for the Model " + fileName + " was: " + bestYearMonth);
		System.out.println("The worst month for the Model " + fileName + " was: " + worstYearMonth);

		System.out.println(newName1 + " YEARLY SALES REPORT ");
		System.out.println("---------------");
		if (totalB == 0) {
			System.out.println("");

		} else {

			System.out.println("2016->" + totalB);
		}
		System.out.println("2017->" + total2B);
		System.out.println("2018->" + total3B);
		System.out.println("2019->" + total4B);
		String bestYearMontha = winnerTimea.format(pattern);
		String worstYearMontha = loserTimea.format(pattern);
		System.out.println("The best month for the Model" + fileName2 + " was: " + bestYearMontha);
		System.out.println("The worst month for the Model " + fileName2 + " was: " + worstYearMontha);

		System.out.println(newName2 + " YEARLY SALES REPORT ");
		System.out.println("---------------");
		if (totalC == 0) {
			System.out.println("");

		} else {

			System.out.println("2016->" + totalC);
		}
		System.out.println("2017->" + total2C);
		System.out.println("2018->" + total3C);
		System.out.println("2019->" + total4C);
		String bestYearMonthb = winnerTimeb.format(pattern);
		String worstYearMonthb = loserTimeb.format(pattern);
		System.out.println("The best month for the Model " + fileName3 + " was: " + bestYearMonthb);
		System.out.println("The worst month for the Model " + fileName3 + " was: " + worstYearMonthb);
	}
}
