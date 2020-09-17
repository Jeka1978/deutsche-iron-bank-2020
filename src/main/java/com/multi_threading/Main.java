package com.multi_threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        MyPrinter myPrinter = new MyPrinter(1000);
        Thread t1 = new Thread(myPrinter);
        MyPrinter myPrinter2 = new MyPrinter(555);
        Thread t2 = new Thread(myPrinter2);
//        t1.start();
//
//        t2.start();


        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(myPrinter);
        executorService.submit(myPrinter2);


    }
}
