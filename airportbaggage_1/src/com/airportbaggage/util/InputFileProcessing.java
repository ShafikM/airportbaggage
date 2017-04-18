package com.airportbaggage.util;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * This file is to read the 
 * @author Shafik Mohammad
 *
 */
public class InputFileProcessing {
	static final Logger LOGGER = Logger.getLogger(InputFileProcessing.class.getName());
	
	private static final String INPUT_DELIMITER_PREFIX = "# Section:";

	
	private static final int INPUT_CONVEYER_NETWORK = 1;
	private static final int INPUT_DEPARTURE_LIST = 2;
	private static final int INPUT_BAG_LIST = 3;

	/**
	 * Process the input file, separate the Conveyer items, departure items and bagItems
	 * Add all these items to the bean.
	 * @param inputString
	 */
	public void processInputFile(String inputString) {

		// ensure that the scanner resource closes after use
		try (Scanner lineScanner = new Scanner(inputString)) {
			// read from the console, one line at a time
			lineScanner.useDelimiter(INPUT_DELIMITER_PREFIX);

			int inputSectionIndex = 0;

			do {
				// trim leading and trailing whitespace
				String inputLine = lineScanner.next().trim();

				// is this a new section?
				if (!inputLine.isEmpty()) {
					inputSectionIndex++;
					// non-empty line
					System.out.println("inputSectionIndex:"+inputSectionIndex);// <TODO> - Remove SOPs

					switch (inputSectionIndex) {
					case 0:
						// log input that will be ignored since first section
						// hasn't started
						System.out.println("INPUT_CONVEYER_NETWORK:"+inputLine);// <TODO> - Remove SOPs
						LOGGER.info("Ignoring this input line since first section hasn't started: " + inputLine);
						break;
					case INPUT_CONVEYER_NETWORK:
						System.out.println("INPUT_CONVEYER_NETWORK:"+inputLine);// <TODO> - Remove SOPs
						addToConveyorNetwork(inputLine);
						break;
					case INPUT_DEPARTURE_LIST:
						System.out.println("INPUT_DEPARTURE_LIST:"+inputLine);// <TODO> - Remove SOPs
						addToDepartureList(inputLine);
						break;
					case INPUT_BAG_LIST:
						System.out.println("INPUT_BAG_LIST:"+inputLine);// <TODO> - Remove SOPs
						addToBagList(inputLine);
						break;
					default:
						// log input that will be ignored since last section has
						// finished
						LOGGER.info("Ignoring this input line since all sections are processed: " + inputLine);
						break;
					}
				}
			} while (lineScanner.hasNext());
		} catch (Exception e) {
			LOGGER.severe("Could not process the input. " + e.getMessage());
		}		
	}

	private void addToBagList(String inputLine) {
		// TODO Auto-generated method stub
		
	}

	private void addToDepartureList(String inputLine) {
		// TODO Auto-generated method stub
		
	}

	private void addToConveyorNetwork(String inputLine) {
		// TODO Auto-generated method stub
		
	}

	public String routeBags() {
		StringBuffer shortestPaths = new StringBuffer();
		// Iterate the ConveyorNetwork bags with checked bags
		// Compare with Destination Airport
		// Map the source and destinattion airports
		

		return shortestPaths.toString();
	}
	
}
