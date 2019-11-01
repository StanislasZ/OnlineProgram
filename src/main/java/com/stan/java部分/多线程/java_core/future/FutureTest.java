package com.stan.java部分.多线程.java_core.future;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTest {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter base dir: ");
            String dir = scanner.nextLine();
            System.out.print("enter keyword: ");
            String keyword = scanner.nextLine();

            MatchCounter counter = new MatchCounter(new File(dir), keyword);
            FutureTask<Integer> task = new FutureTask<>(counter);
            Thread t = new Thread(task);
            t.start();
            try {
                System.out.println(task.get() + " matching files.");
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {

            }

        }
    }
}

