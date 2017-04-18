package com.airportbaggage.bean;

import java.util.Date;
import java.util.Map;

import com.airportbaggage.bean.ScheduledFlight;

/**
 * An airport.
 * 
 * @author Shafik Mohammad
 */
public interface Airport {
	/**
	 * Gets the airport identifier.
	 * 
	 * @return A String that uniquely identifies the airport.
	 */
	String getId();

	/**
	 * Gets the airport name.
	 * 
	 * @return A descriptive name for the airport.
	 */
	String getName();

	/**
	 * Gets the scheduled flights.
	 * 
	 * @return A map of scheduled flights indexed by the flight-identifier.
	 */
	Map<String, ScheduledFlight> getScheduledFlights();

	/**
	 * Adds a scheduled flight.
	 * 
	 * @param flightId
	 *            A String that uniquely identifies the flight.
	 * @param departureGateId
	 *            A String that uniquely identifies the departure gate for the
	 *            flight.
	 * @param destinationAirportId
	 *            A String that uniquely identifies the destination airport for
	 *            the flight.
	 * @param departureTime
	 *            The departure time for the flight.
	 */
	void addScheduledFlight(String flightId, String departureGateId, String destinationAirportId, Date departureTime);

	/**
	 * Gets the gate corresponding to the gate identifier.
	 * 
	 * @param gateId
	 *            A String that uniquely identifies the gate.
	 * @return The gate, if found; null, otherwise.
	 */
	Gate getGate(String gateId);

	/**
	 * Gets the scheduled flight corresponding to the flight identifier.
	 * 
	 * @param flightId
	 *            A String that uniquely identifies the flight.
	 * @return The flight, if found; null, otherwise.
	 */
	ScheduledFlight getScheduledFlight(String flightId);
}