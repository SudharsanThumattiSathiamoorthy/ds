package com.sudhar.examples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintOddEven {
    boolean oddFlag = true;

    int count = 1;
    int MAX = 20;

    public void printOdd() throws InterruptedException {
        synchronized (this) {
            while (count < MAX) {
                //System.out.println("checking odd loop: ");
                if (!oddFlag) {
                    System.out.print(Thread.currentThread().getName() + " : " + count);
                    wait();
                }

                System.out.println("Odd count " + count++);
                oddFlag = false;
                notifyAll();
            }
        }
    }

    public void printEven() throws InterruptedException {
        synchronized (this) {
            while (count < MAX) {
                //System.out.println("checking even loop: ");
                if (oddFlag) {
                    System.out.print(Thread.currentThread().getName() + " : " + count);
                    wait();
                }

                System.out.println("even count " + count++);
                oddFlag = true;
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {

//        PrintOddEven poe = new PrintOddEven();
//        poe.oddFlag = true;
//
//        Thread t1 = new Thread(() -> {
//            try {
//                poe.printOdd();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        Thread t2 = new Thread(() -> {
//            try {
//                poe.printEven();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        t1.start();
//        t2.start();
//
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        ExecutorService ex = Executors.newFixedThreadPool(5);
//        for (int i =1; i <=5; i++) {
//            PrintUsingExecutor pue = new PrintUsingExecutor();
//            ex.execute(pue);
//        }
//
//        ex.shutdown();

        OddEven even = new OddEven(0);
        OddEven odd = new OddEven(1);

        Thread oddThread = new Thread(odd, "Odd");
        Thread evenThread = new Thread(even, "Even");
//
//         oddThread.start();
//         evenThread.start();

        System.out.println("From executor service : Odd even" + "\n");
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(even);
        es.execute(odd);

        es.shutdown();
    }
}

class PrintUsingExecutor implements Runnable {

    static  int threadName = 1;
    static int max = 20;
    static int count = 1;
    static Object lock = new Object();

    @Override
    public void run() {

        synchronized (lock) {
            while(count < max) {
                if (!Thread.currentThread().getName().contains("" + threadName)) {
                    // System.out.println("waiting for the thread : " + Thread.currentThread().getName());
                    try {
                        lock.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    if (++threadName == 6) {
                        threadName = 1;
                    }
                    System.out.println(Thread.currentThread().getName() + " value is  " + ++count);
                    lock.notifyAll();

                }
            }
        }
    }
}

class OddEven implements Runnable {
    static Object lock = new Object();

    int name;
    static int count = 1;
    int max = 20;


    OddEven(int name) {
        this.name = name;
    }

    @Override
    public void run() {

        synchronized (lock) {
            while (count < max) {
                if (count % 2 != name) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + " - " + count);
                count++;
                lock.notifyAll();
            }
        }
    }
}