package com.stan.java部分.多线程.java_core.future;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
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

class MatchCounter implements Callable<Integer> {
    private File dir;
    private String keyword;

    public MatchCounter(File dir, String keyword) {
        this.dir = dir;
        this.keyword = keyword;
    }


    @Override
    public Integer call(){
        int cnt = 0;
        try {
            File[] files = dir.listFiles();
            System.out.println(files.length);
            System.out.println(files);
            List<Future<Integer>> results = new ArrayList<>();

            for (File file : files) {
                if (file.isDirectory()) {
                    MatchCounter counter = new MatchCounter(file, keyword);
                    FutureTask<Integer> task = new FutureTask<>(counter);
                    results.add(task);
                    Thread t = new Thread(task);
                    t.start();
                } else {
                    if (search(file)) ++ cnt;
                }
            }

            for (Future<Integer> result : results) {
                try {
                    cnt += result.get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {

        }
        return cnt;
    }

    public boolean search(File file) {
        try {
            try (Scanner scanner = new Scanner(file, "UTF-8")) {
                boolean found = false;
                while (!found && scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.contains(keyword)) found = true;
                }
                return found;
            }
        } catch (IOException e) {
            return false;
        }
    }
}