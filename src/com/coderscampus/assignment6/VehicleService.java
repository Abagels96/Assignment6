package com.coderscampus.assignment6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class VehicleService {

	
	public void readFile() throws IOException {
	try {
		BufferedReader reader= new BufferedReader(new FileReader("src/modelS.csv"));
		
		String lines="";
		
		while((lines=reader.readLine())!=null) {
			System.out.println(lines);
		}
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
