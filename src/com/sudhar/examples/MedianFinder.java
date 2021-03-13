package com.sudhar.examples;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);

    public void insert(Integer val) {
        max.add(val);
        min.add(max.poll());

        if (max.size() < min.size()) {
            max.add(min.poll());
        }

        System.out.println("min : " + min);
        System.out.println("max : " + max);
        System.out.println("");
    }

    public double getMedian() {
        System.out.println("Min peek : " + min.peek());
        System.out.println("Max peek : " + max.peek());
        if (max.size() == min.size()) {
            return (double) ((int)min.peek() + (int) max.peek())/2;
        } else {
            return (double) max.peek();
        }
    }


    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.insert(3);
        System.out.println("Median: " + medianFinder.getMedian());

        medianFinder.insert(5);
        System.out.println(medianFinder.getMedian());

        medianFinder.insert(10);
        System.out.println(medianFinder.getMedian());

        medianFinder.insert(7);
        System.out.println(medianFinder.getMedian());

        System.out.println();
    }
}
