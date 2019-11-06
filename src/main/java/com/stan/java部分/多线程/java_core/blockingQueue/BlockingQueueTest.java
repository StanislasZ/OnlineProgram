package com.stan.java部分.多线程.java_core.blockingQueue;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingQueueTest {

    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREADS = 100;
    private static final File DUMMY = new File("");
    private static BlockingQueue<File> queue = new LinkedBlockingDeque<>(FILE_QUEUE_SIZE);

    public static void main(String[] args) {

        //BlockingQueue的put(), take() 在不满足条件时被阻塞

        try (Scanner in = new Scanner(System.in)) {
            System.out.print("enter base dir: ");
            String dir = in.nextLine();
            System.out.print("enter keyword: ");
            String keyword = in.nextLine();

            Runnable enumerator = () -> {
                try {
                    enumerate(new File(dir));
                    queue.put(DUMMY);  //后进后出，只有当前面的文件都被搬光了才能拿到这个dummy
                } catch (InterruptedException e) {
                    System.out.println("put....被中断");
                }
            };
            new Thread(enumerator).start();

            for (int i = 1; i <= SEARCH_THREADS; ++i) {
                Runnable searcher = () -> {
                    try {
                        boolean done = false;
                        while (!done) {
                            File file = queue.take();
                            if (file == DUMMY) {
                                //找到的是dummy说明没了，把dummy再放回去，并结束
                                queue.put(file);
                                done = true;
                            } else {
                                search(file, keyword);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        System.out.println("searcher....被中断");
                    }
                };
                new Thread(searcher).start();
            }


        }
    }

    /**
     * 递归，把所有文件放进队列
     * @param dir
     * @throws InterruptedException
     */
    public static void enumerate(File dir) throws InterruptedException {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) enumerate(file);
            else queue.put(file);
        }
    }

    /**
     * 读文件每行，若出现keyword，打印该行
     * @param file
     * @param keyword
     * @throws IOException
     */
    public static void search(File file, String keyword) throws IOException {
        try (Scanner in = new Scanner(file, "UTF-8")) {
            int lineNumber = 0;
            while (in.hasNextLine()) {
                ++ lineNumber;
                String line = in.nextLine();
                if (line.contains(keyword))
                    System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
            }
        }
    }
}
