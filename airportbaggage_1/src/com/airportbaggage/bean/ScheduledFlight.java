package com.airportbaggage.bean;

import java.util.Date;

/**
 * A flight that has been scheduled. The gate and timing information for the
 * flight can be updated after creation.
 * 
 * @author Shafik Mohammad
 */
public interface ScheduledFlight extends Flight {

	/**
	 * Gets the gate from where the flight will depart.
	 * 
	 * @return The departure gate for the flight.
	 */
	Gate getDepartureGate();

	/**
	 * Sets the gate from where the flight will depart.
	 * 
	 * @param departureGate
	 *            The departure gate for the flight.
	 */
	void setDepartureGate(Gate departureGate);

	/**
	 * Gets the gate where the flight will arrive.
	 * 
	 * @return The arrival gate for the flight.
	 */
	Gate getArrivalGate();

	/**
	 * Sets the gate where the flight will arrive.
	 * 
	 * @param arrivalGate
	 *            The arrival gate for the flight.
	 */
	void setArrivalGate(Gate arrivalGate);

	/**
	 * Gets the time when the flight will depart. Implementations should return
	 * a copy of the member variable to maintain encapsulation.
	 * 
	 * @return The departure time for the flight.
	 */
	Date getDepartureTime();

	/**
	 * Sets the time when the flight will depart. Implementations should make a
	 * copy of the argument to maintain encapsulation.
	 * 
	 * @param departureTime
	 *            The departure time for the flight.
	 */
	void setDepartureTime(Date departureTime);

	/**
	 * Gets the time when the flight will arrive. Implementations should return
	 * a copy of the member variable to maintain encapsulation.
	 * 
	 * @return The arrival time for the flight.
	 */
	Date getArrivalTime();

	/**
	 * Sets the time when the flight will arrive. Implementations should make a
	 * copy of the argument to maintain encapsulation.
	 * 
	 * @param arrivalTime
	 *            The arrival time for the flight.
	 */
	void setArrivalTime(Date arrivalTime);
}