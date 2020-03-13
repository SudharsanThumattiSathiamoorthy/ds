package com.sudhar.examples;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureEx {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<String> completableFuture = calculateAsync();

        System.out.println(completableFuture.get());
    }

    public static Future<String> calculateAsync() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newFixedThreadPool(1)
                .submit(() -> {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    completableFuture.complete("completed");

                    return null;
                });

        return completableFuture;
    }

}
