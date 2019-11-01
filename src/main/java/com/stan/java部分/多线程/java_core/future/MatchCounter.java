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

public class MatchCounter implements Callable<Integer> {

    private File dir;    //目录路径
    private String keyword;   //关键字

    public MatchCounter(File dir, String keyword) {
        this.dir = dir;
        this.keyword = keyword;
    }


    @Override
    /**
     * 碰到文件夹就新起一个线程去统计
     *
     * 而不是像传统递归方式，碰到文件夹就递归进去找
     */
    public Integer call(){
        int cnt = 0;
        try {
            File[] files = dir.listFiles();  //获取目标目录下的所有文件和文件夹
//            System.out.println(files.length);
//            System.out.println(files);
            List<Future<Integer>> results = new ArrayList<>();
            //遍历
            for (File file : files) {
                if (file.isDirectory()) {
                    //是文件夹，新起一个线程去搜索
                    MatchCounter counter = new MatchCounter(file, keyword);
                    FutureTask<Integer> task = new FutureTask<>(counter);
                    results.add(task);
                    Thread t = new Thread(task);
                    t.start();    //start最后会调用这个call方法，有点像递归
                } else {
                    if (search(file)) ++ cnt;
                }
            }

            for (Future<Integer> result : results) {
                try {
                    cnt += result.get();  //计算完之前会阻塞
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