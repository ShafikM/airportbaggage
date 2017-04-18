package com.airportbaggage.bean;

import com.airportbaggage.bean.Airport;

/**
 * A flight.
 * 
 * @author Shafik Mohammad
 */
public interface Flight {
	/**
	 * Gets the flight identifier.
	 * 
	 * @return A String that uniquely identifies the flight.
	 */
	String getId();

	/**
	 * Gets the airport from where the flight will depart.
	 * 
	 * @return The source airport for the flight.
	 */
	Airport getSource();

	/**
	 * Gets the airport where the flight will arrive.
	 * 
	 * @return The destination airport for the flight.
	 */
	Airport getDestination();
}