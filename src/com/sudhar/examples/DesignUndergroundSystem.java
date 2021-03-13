package com.sudhar.examples;

import java.util.HashMap;
import java.util.Map;

public class DesignUndergroundSystem {

    //    If you were asked this question in a real interview, you should expect to discuss real-world issues related to it. For example, it would not be realistic to store the data in volatile computer memory. In practice, computers fail (e.g. lose power) so we need to store the data in a permanent medium, such as a database.
    //
    //    Additionally, we might need to consider scalability. In a large city, such as Tokyo, the metro system gets 7 million passenger trips per day! With a little math, we can quickly estimate that during peak travel time, there must be thousands of check-ins and check-outs every second. This is a lot of data that one computer would need to receive through its network connection! To make this work, we'd probably be using more than one computer. This introduces concurrency issues that would need to be addressed.
    //
    //    It's also likely that this module would have to fit in with other code in the passenger-tracking system. It's not likely that a little average time tracker will get exclusive use of all resources.
    //
    //    For your actual implementation, you'll probably be expected to use HashMaps. This is common in system design interview questions: you're given a complex real world problem to explore and then are asked to implement a small piece of it.


    class UndergroundSystem {

        private Map<String, Pair<Double, Double>> journeyData = new HashMap<>();
        private Map<Integer, Pair<String, Integer>> checkInData = new HashMap<>();

        public UndergroundSystem() {
        }

        public void checkIn(int id, String stationName, int t) {
            checkInData.put(id, new Pair<>(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            // Look up the check in station and check in time for this id.
            // You could combine this "unpacking" into the other lines of code
            // to have less lines of code overall, but we've chosen to be verbose
            // here to make it easy for all learners to follow.
            Pair<String, Integer> checkInDataForId = checkInData.get(id);
            String startStation = checkInDataForId.getKey();
            Integer checkInTime = checkInDataForId.getValue();

            // Lookup the current travel time data for this route.
            String routeKey = stationsKey(startStation, stationName);
            Pair<Double, Double> routeStats = journeyData.getOrDefault(routeKey, new Pair<>(0.0, 0.0));
            Double totalTripTime = routeStats.getKey();
            Double totalTrips = routeStats.getValue();

            // Update the travel time data with this trip.
            double tripTime = t - checkInTime;
            journeyData.put(routeKey, new Pair<>(totalTripTime + tripTime, totalTrips + 1));

            // Remove check in data for this id.
            // Note that this is optional, we'll talk about it in the space complexity analysis.
            checkInData.remove(id);
        }

        public double getAverageTime(String startStation, String endStation) {
            // Lookup how many times this journey has been made, and the total time.
            String routeKey = stationsKey(startStation, endStation);
            Double totalTime = journeyData.get(routeKey).getKey();
            Double totalTrips = journeyData.get(routeKey).getValue();
            // The average is simply the total divided by the number of trips.
            return totalTime / totalTrips;
        }

        private String stationsKey(String startStation, String endStation) {
            return startStation + "->" + endStation;
        }
    }

}
