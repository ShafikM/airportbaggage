package com.airportbaggage.bean;

import com.airportbaggage.bean.BaggagePoint;

/**
 * A bag that has been checked-in.
 * 
 * @author Shafik Mohamamd
 */
public interface CheckedBag extends Bag {

	/**
	 * Gets the baggage point where this bag was first scanned.
	 * 
	 * @return The baggage point where this bag was first scanned.
	 */
	BaggagePoint getEntryPoint();
}