package com.airportbaggage.bean;

/**
 * A zone denotes a physical location within an airport.
 * 
 * @author Shafik Mohammad
 */
public interface Zone {
	/**
	 * Gets the zone identifier.
	 * 
	 * @return A String that uniquely identifies the zone.
	 */
	String getId();

	/**
	 * Gets the zone name.
	 * 
	 * @return A descriptive name for the zone.
	 */
	String getName();
}