package com.airportbaggage.bean;

import com.airportbaggage.bean.ScheduledFlight;

/**
 * A bag.
 * 
 * @author Shafik Mohammad
 */
public interface Bag {
	/**
	 * Gets the bag identifier.
	 * 
	 * @return A String that uniquely identifies the bag.
	 */
	String getId();

	/**
	 * Gets the scheduled flight transporting this bag.
	 * 
	 * @return The scheduled flight transporting this bag.
	 */
	ScheduledFlight getScheduledFlight();
}