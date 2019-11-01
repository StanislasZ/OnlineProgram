package com.stan.java部分.多线程.java_core.threadPool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;



//之前FutureTest中，产生了大量生命周期很短的线程，这里用线程池
public class ThreadPoolTest {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter base dir: ");
            String dir = scanner.nextLine();
            System.out.print("enter keyword: ");
            String keyword = scanner.nextLine();

            ExecutorService pool = Executors.newCachedThreadPool();
            MatchCounter counter = new MatchCounter(new File(dir), keyword, pool);
            Future<Integer> result = pool.submit(counter);  //丢进线程池

            try {
                System.out.println(result.get() + " matching files");
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {

            }
            pool.shutdown();
            int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
            System.out.println("largest pool size = " + largestPoolSize);


        }
    }
}


class MatchCounter implements Callable<Integer> {

    private File dir;    //目录路径
    private String keyword;   //关键字

    private ExecutorService pool;   //线程池
    private int cnt;

    public MatchCounter(File dir, String keyword, ExecutorService pool) {
        this.dir = dir;
        this.keyword = keyword;
        this.pool = pool;
    }


    @Override
    public Integer call(){
        cnt = 0;
        try {
            File[] files = dir.listFiles();  //获取目标目录下的所有文件和文件夹
//            System.out.println(files.length);
//            System.out.println(files);
            List<Future<Integer>> results = new ArrayList<>();
            //遍历
            for (File file : files) {
                if (file.isDirectory()) {
                    //是文件夹，新起一个线程去搜索
                    MatchCounter counter = new MatchCounter(file, keyword, pool);
                    Future<Integer> result = pool.submit(counter);
                    results.add(result);

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
