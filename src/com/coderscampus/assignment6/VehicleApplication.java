package com.coderscampus.assignment6;

import java.io.IOException;

public class VehicleApplication {
public static void main (String[]args) throws IOException {
	VehicleService service= new VehicleService();
	service.readFile("src/model3.csv");
}
}
