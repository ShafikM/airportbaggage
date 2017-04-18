package com.airportbaggage.bean;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.airportbaggage.bean.BaggagePoint;
import com.airportbaggage.bean.StandardBaggagePoint;
import com.airportbaggage.bean.CheckedBag;
import com.airportbaggage.bean.StandardCheckedBag;
import com.airportbaggage.bean.ScheduledFlight;

/**
 * The conveyer network holding information about the connected baggage points,
 * and bags that need to be routed.
 * 
 * @author Shafik Mohammad
 */
public class ConveyerNetwork {

	private static final Logger LOGGER = Logger.getLogger(ConveyerNetwork.class.getName());

	private Map<String, CheckedBag> bags;
	private Map<String, BaggagePoint> baggagePoints;

	/**
	 * adjacency-lists representation of the conveyer network
	 */
	private Map<BaggagePoint, Map<BaggagePoint, Double>> network;

	/**
	 * The default constructor.
	 */
	public ConveyerNetwork() {
		bags = new LinkedHashMap<String, CheckedBag>();
		baggagePoints = new HashMap<String, BaggagePoint>();
		network = new HashMap<BaggagePoint, Map<BaggagePoint, Double>>();
	}

	/**
	 * Adds a bag. If a bag is added again, its details are updated.
	 * 
	 * @param bagId
	 *            A String that uniquely identifies the bag.
	 * @param entryPoint
	 *            The baggage point where this bag was first scanned.
	 * @param scheduledFlight
	 *            The scheduled flight that will carry bag.
	 */
	public void addBag(String bagId, BaggagePoint entryPoint, ScheduledFlight scheduledFlight) {

		if (bags.containsKey(bagId)) {
			LOGGER.info("Updating scheduled flight and entry point for bag: " + bagId);
		} else {
			LOGGER.info("Adding a new bag: " + bagId);
		}

		bags.put(bagId, new StandardCheckedBag(bagId, scheduledFlight, entryPoint));
	}

	/**
	 * Adds the connection between two baggage points.
	 * 
	 * @param baggagePointId
	 *            A String that uniquely identifies a baggage point.
	 * @param connectedBaggagePointId
	 *            A String that uniquely identifies another baggage point.
	 * @param distance
	 *            The distance between the baggage points.
	 */
	public void addConnection(String baggagePointId, String connectedBaggagePointId, double distance) {


		if (baggagePointId.equals(connectedBaggagePointId)) {
			LOGGER.info("Ignoring connection between same source and destination point: " + baggagePointId);
		} else {
			BaggagePoint baggagePoint = addBaggagePoint(baggagePointId);
			BaggagePoint connectedBaggagePoint = addBaggagePoint(connectedBaggagePointId);

			addConnection(baggagePoint, connectedBaggagePoint, distance);
		}
	}

	/**
	 * Gets the baggage point corresponding to the baggage point identifier.
	 * 
	 * @param baggagePointId
	 *            A String that uniquely identifies the baggage point.
	 * @return The baggage point, if found; null, otherwise.
	 */
	public BaggagePoint getBaggagePoint(String baggagePointId) {

		if (!baggagePoints.containsKey(baggagePointId)) {
			LOGGER.severe("Could not find a baggage point with id: " + baggagePointId);
		}

		return baggagePoints.get(baggagePointId);
	}

	/**
	 * Gets a "view" of the bags in the conveyer network.
	 * 
	 * @return An unmodifiable collection of bags.
	 */
	public Collection<CheckedBag> getBags() {
		return Collections.unmodifiableCollection(bags.values());
	}

	/**
	 * Gets a "view" of the connected baggage points in the conveyer network.
	 * 
	 * @return An unmodifiable map of baggage point connections.
	 */
	public Map<BaggagePoint, Map<BaggagePoint, Double>> getNetwork() {
		Map<BaggagePoint, Map<BaggagePoint, Double>> unmodifiableNetwork = new HashMap<BaggagePoint, Map<BaggagePoint, Double>>();

		for (Map.Entry<BaggagePoint, Map<BaggagePoint, Double>> entry : network.entrySet()) {
			unmodifiableNetwork.put(entry.getKey(), Collections.unmodifiableMap(entry.getValue()));
			LOGGER.info("Creating unmodifiable map for: " + entry.getKey().getId());
		}

		return Collections.unmodifiableMap(unmodifiableNetwork);
	}

	private void addConnection(BaggagePoint baggagePoint, BaggagePoint connectedBaggagePoint, double distance) {

		Map<BaggagePoint, Double> adjacencyListForBaggagePoint = getAdjacencyListForBaggagePoint(baggagePoint);
		Map<BaggagePoint, Double> adjacencyListForConnectedBaggagePoint = getAdjacencyListForBaggagePoint(
				connectedBaggagePoint);

		addConnection(adjacencyListForBaggagePoint, connectedBaggagePoint, distance);
		addConnection(adjacencyListForConnectedBaggagePoint, baggagePoint, distance);
	}

	private void addConnection(Map<BaggagePoint, Double> adjacencyListForBaggagePoint,
			BaggagePoint connectedBaggagePoint, double distance) {
		if (adjacencyListForBaggagePoint.containsKey(connectedBaggagePoint)) {
			LOGGER.fine("Updating distance in existing connection for : " + connectedBaggagePoint.getId());
		} else {
			LOGGER.info("Adding connection for : " + connectedBaggagePoint.getId());
		}

		adjacencyListForBaggagePoint.put(connectedBaggagePoint, distance);
	}

	private Map<BaggagePoint, Double> getAdjacencyListForBaggagePoint(BaggagePoint baggagePoint) {

		Map<BaggagePoint, Double> adjacencyListForBaggagePoint;

		if (!network.containsKey(baggagePoint)) {
			adjacencyListForBaggagePoint = new HashMap<BaggagePoint, Double>();
			network.put(baggagePoint, adjacencyListForBaggagePoint);
		} else {
			adjacencyListForBaggagePoint = network.get(baggagePoint);
		}

		return adjacencyListForBaggagePoint;
	}

	private BaggagePoint addBaggagePoint(String baggagePointId) {
		BaggagePoint baggagePoint;

		if (baggagePoints.containsKey(baggagePointId)) {
			baggagePoint = baggagePoints.get(baggagePointId);
		} else {
			LOGGER.info("Adding a new baggagePoint: " + baggagePointId);
			baggagePoint = new StandardBaggagePoint(baggagePointId);
			baggagePoints.put(baggagePointId, baggagePoint);
		}

		return baggagePoint;
	}
}