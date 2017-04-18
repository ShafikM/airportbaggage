package com.airportbaggage.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Logger;

import com.airportbaggage.util.InputFileProcessing;

/**
 * @author Shafik Mohammad
 *
 */
/** This is the main class which reads the input file and provide the output file
 */ 
public class MainClass {

	private static final String INPUT_FILE = "input.txt"; // Externalize later to a properties files
	private static final String OUTPUT_FILE = "output.txt";
	static final Logger LOGGER = Logger.getLogger(MainClass.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 1.Read the complete input file 
		Scanner scanner = new Scanner( MainClass.class.getResourceAsStream(INPUT_FILE));
		String inputString = new String();
		while(scanner.hasNextLine()){
			inputString = inputString + scanner.nextLine();
		}
		System.out.println("inputString data: " + inputString); // <TODO> - Remove SOPs
		LOGGER.fine("inputString data: " + inputString);
		
		// 2. Check if the input file data is not empty, invoke the process method 
		if (inputString != null) {
			InputFileProcessing processor = new InputFileProcessing();
			try {
				processor.processInputFile(inputString);
			} catch (Exception e) {
				LOGGER.severe("Could not inputFileReader the conveyor system. " + e.getMessage());
			}
			try {
				Files.write(Paths.get(new File("").getAbsolutePath().concat(OUTPUT_FILE)),
						processor.routeBags().getBytes());
			} catch (IOException e) {
				//LOGGER.severe("Could not write output data. " + e.getMessage());
			} catch (Exception e) {
				LOGGER.severe("Could not route the bags. " + e.getMessage());
			}
		}
	}

}
