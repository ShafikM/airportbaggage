package com.airportbaggage.bean;

import java.util.Date;

import com.airportbaggage.bean.Airport;
import com.airportbaggage.bean.Gate;


/**
 * A standard flight that has been scheduled.
 * 
 * @author Shafik Mohammad
 */
public class StandardScheduledFlight implements ScheduledFlight {

	private final String id;
	private final Airport source;
	private final Airport destination;
	private Gate departureGate;
	private Gate arrivalGate;
	private Date departureTime;
	private Date arrivalTime;

	/**
	 * The canonical constructor.
	 * 
	 * @param id
	 *            A String that uniquely identifies the flight. Cannot be null
	 *            or empty.
	 * @param source
	 *            The source airport for the flight. Cannot be null.
	 * @param destination
	 *            The destination airport for the flight. Cannot be null.
	 * @param departureGate
	 *            The departure gate for the flight.
	 * @param arrivalGate
	 *            The arrival gate for the flight.
	 * @param departureTime
	 *            The departure time for the flight.
	 * @param arrivalTime
	 *            The arrival time for the flight.
	 */
	public StandardScheduledFlight(String id, Airport source, Airport destination, Gate departureGate, Gate arrivalGate,
			Date departureTime, Date arrivalTime) {

		this.id = id;
		this.source = source;
		this.destination = destination;
		this.departureGate = departureGate;
		this.arrivalGate = arrivalGate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	/**
	 * A constructor that initializes gate and timing information to null
	 * values.
	 * 
	 * @param id
	 *            A String that uniquely identifies the flight.
	 * @param source
	 *            The source airport for the flight.
	 * @param destination
	 *            The destination airport for the flight.
	 */
	public StandardScheduledFlight(String id, Airport source, Airport destination) {
		this(id, source, destination, null, null, null, null);
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public Airport getSource() {
		return source;
	}

	@Override
	public Airport getDestination() {
		return destination;
	}

	@Override
	public Gate getDepartureGate() {
		return departureGate;
	}

	@Override
	public void setDepartureGate(Gate departureGate) {
		this.departureGate = departureGate;
	}

	@Override
	public Gate getArrivalGate() {
		return arrivalGate;
	}

	@Override
	public void setArrivalGate(Gate arrivalGate) {
		this.arrivalGate = arrivalGate;
	}

	@Override
	public Date getDepartureTime() {
		Date date = null;

		if (null != departureTime) {
			date = new Date(departureTime.getTime());
		}

		return date;
	}

	@Override
	public void setDepartureTime(Date departureTime) {
		Date date = null;

		if (null != departureTime) {
			date = new Date(departureTime.getTime());
		}

		this.departureTime = date;
	}

	@Override
	public Date getArrivalTime() {
		Date date = null;

		if (null != arrivalTime) {
			date = new Date(arrivalTime.getTime());
		}

		return date;
	}

	@Override
	public void setArrivalTime(Date arrivalTime) {
		Date date = null;

		if (null != arrivalTime) {
			date = new Date(arrivalTime.getTime());
		}

		this.arrivalTime = date;
	}
}