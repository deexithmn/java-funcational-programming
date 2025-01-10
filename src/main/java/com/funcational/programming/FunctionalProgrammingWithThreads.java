package com.funcational.programming;

import java.util.stream.IntStream;

public class FunctionalProgrammingWithThreads {

    public static void main(String[] args) {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getId() + " : " + i);
                }
            }
        };

        Thread thread = new Thread(run);
        thread.start();

        Thread thread1 = new Thread(run);
        thread1.start();

        Thread thread2 = new Thread(run);
        thread2.start();

        System.out.println("Using Functional Programming");

        Runnable runFunc = () -> {
            IntStream.rangeClosed(1, 10).forEach(i -> System.out.println(Thread.currentThread().getId() + "Func" + " : " + i));
        };
        Thread funcThread = new Thread(runFunc);
        funcThread.start();

        Thread funcThread2 = new Thread(runFunc);
        funcThread2.start();

    }
}
