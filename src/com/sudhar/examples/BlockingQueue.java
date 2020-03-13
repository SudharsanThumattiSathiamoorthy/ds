package com.sudhar.examples;


import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {

    final Queue<T> queue = new LinkedList<>();
    int threshold = 25;

    public BlockingQueue(int threshold) {
        this.threshold = threshold;
    }

    public void enqueue(T t) throws InterruptedException {
        if (this.queue.size() == threshold) {
            wait();
        }

        if (this.queue.size() == 0) {
            notifyAll();
        }

        this.queue.add(t);
    }

    public T dequeue() throws InterruptedException {
        if (this.queue.size() == 0) {
            wait();
        }

        if (this.queue.size() == threshold) {
            notifyAll();
        }

        return this.queue.poll();
    }

    public static void main(final String[] args) {

    }
}
