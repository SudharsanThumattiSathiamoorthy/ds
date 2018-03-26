package com.sudhar.examples;

class Queue<T> {
    T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public T get() {
        synchronized (t) {
        }
        return null;
    }
}
public class BlockingQueue {

    public static void main(final String[] args) {

    }
}
