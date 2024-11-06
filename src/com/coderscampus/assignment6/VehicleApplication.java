package com.coderscampus.assignment6;

import java.io.IOException;

public class VehicleApplication {
public static void main (String[]args) throws IOException {
	VehicleService service= new VehicleService();
	
service.compileArray("src/model3.csv","src/modelX.csv","src/modelS.csv");

}
}
