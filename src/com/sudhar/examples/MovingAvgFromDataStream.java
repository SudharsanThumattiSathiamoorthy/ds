package com.sudhar.examples;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MovingAvgFromDataStream {

    class MovingAverage {

        Queue<Integer> queue;
        int size;
        double avg;

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.size = size;
            queue = new LinkedList<>();
        }

        public double next(int val) {
            if (queue.size() < 3) {
                avg += val;
            } else {
                avg -= queue.poll();
                avg += val;
            }
            queue.add(val);

            return avg/queue.size();
        }
    }

    /**
     * Your MovingAverage object will be instantiated and called as such:
     * MovingAverage obj = new MovingAverage(size);
     * double param_1 = obj.next(val);
     */
}
