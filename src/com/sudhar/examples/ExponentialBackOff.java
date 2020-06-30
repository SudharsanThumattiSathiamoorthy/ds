package com.sudhar.examples;

import java.util.concurrent.TimeUnit;

public class ExponentialBackOff {

    public static void main(String[] args) {

        int retries = 0;
        int timeSpent = 0;
        int sleepTime = 0;
        int period = 2;

        int maxBackOff = 300;

        while (timeSpent <= maxBackOff) {
            ++retries;

            sleepTime += Math.pow(retries, period);

            timeSpent += sleepTime;

            System.out.println("Retries : " + retries + " sleepTime: " + sleepTime + " timeSpent: " + timeSpent);
        }

        System.out.println("ST : " + sleepTime + " " + TimeUnit.SECONDS.toMillis(sleepTime));
    }
}
