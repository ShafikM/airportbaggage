package com.airportbaggage.bean;

import com.airportbaggage.bean.BaggagePoint;
import com.airportbaggage.bean.ScheduledFlight;

/**
 * A standard bag that has been checked-in.
 * 
 * @author Shafik Mohammad
 */
public class StandardCheckedBag implements CheckedBag {

	private String id;
	private ScheduledFlight scheduledFlight;
	private BaggagePoint entryPoint;

	/**
	 * The canonical constructor.
	 * 
	 * @param id
	 *            A String that uniquely identifies the bag.
	 * @param scheduledFlight
	 *            The scheduled flight transporting this bag.
	 * @param entryPoint
	 *            The baggage point where this bag was first scanned.
	 */
	public StandardCheckedBag(String id, ScheduledFlight scheduledFlight, BaggagePoint entryPoint) {

		this.id = id;
		this.scheduledFlight = scheduledFlight;
		this.entryPoint = entryPoint;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public ScheduledFlight getScheduledFlight() {
		return scheduledFlight;
	}

	@Override
	public BaggagePoint getEntryPoint() {
		return entryPoint;
	}
}