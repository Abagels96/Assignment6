package com.coderscampus.assignment6;

import java.io.IOException;

public class VehicleApplication {
public static void main (String[]args) throws IOException {
	VehicleService service= new VehicleService();
	
service.compileArray("src/modelX.csv","src/model3.csv","src/modelS.csv");

}
}
