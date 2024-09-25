package org.example;

import java.time.Duration;
import java.time.Instant;

public class Main {
    private final static int lenArray = 50000000;
    private final static int[] colsThread = new int[]{1, 2, 3, 4, 8, 16, 32};

    public static void main(String[] args) {
        testThreads();
    }

    private static void testThreads() {
        for (int j : colsThread) {
            ThreadSum threadSum = new ThreadSum(lenArray, j);
            var startTime = Instant.now();
            threadSum.wave();
            var stopTime = Instant.now();
            var time = Duration.between(startTime, stopTime);
            System.out.println("Sum with " + j + " threads is " + threadSum.getArray()[0]
                    + ". This continues " + time + " milliseconds");
        }
    }
}

