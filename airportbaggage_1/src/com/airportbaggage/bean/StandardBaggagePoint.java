package com.airportbaggage.bean;

/**
 * A standard baggage point.
 * 
 * @author Shafik Mohammad
 */
public class StandardBaggagePoint implements BaggagePoint {

	private final String id;
	private final String name;

	/**
	 * The canonical constructor.
	 * 
	 * @param id
	 *            A String that uniquely identifies the baggage point.
	 * @param name
	 *            A descriptive name for the baggage point.
	 */
	public StandardBaggagePoint(String id, String name) {

		this.id = id;
		this.name = name;
	}

	/**
	 * The canonical constructor.
	 * 
	 * @param id
	 *            A String that uniquely identifies the baggage point.
	 */
	public StandardBaggagePoint(String id) {
		this(id, "");
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}
}