package com.sudhar.examples;

import java.util.LinkedList;
import java.util.Queue;

public class DesignHitCounter {

    Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public DesignHitCounter() {
        queue = new LinkedList();
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        expire(timestamp);
        queue.add(timestamp);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        expire(timestamp);
        return queue.size();
    }

    void expire(int timestamp) {
        while (!queue.isEmpty() && queue.peek() <= timestamp - 300) {
            queue.poll();
        }
    }

}
