package com.stan.公司笔试.ByteDance;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 万万没想到 {

    /*
        万万没想到之抓捕孔连顺
     */

    static int res = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); //埋伏点个数
        if (N < 3) {
            System.out.println(0);
            return;
        }
        int D = scanner.nextInt();  //两两之间的最大值

        Deque<Integer> deque = new LinkedList<>();
        int[] position = new int[N];
        for (int i = 0; i < N; ++i) {
            position[i] = scanner.nextInt();
        }
        Solution_万万没想到 s = new Solution_万万没想到();
        s.dfs(-1, 0, D, position, deque);

        System.out.println(s.res);
    }


}


class Solution_万万没想到 {
    long res = 0;


    public long getTotal(int[] position, int limit) {
        for (int left = 0, right = 2; right < position.length; ++right) {
            while (position[right] - position[left] > limit)
                left++;
            //[j, i]中取3个，为了保证不重复，i是必取的，[j,i-1]中取2个 ，个数是i-1-j+1 = i-j
            //这里不用再写 if (right - left >= 2)
            //因为不满足时，getCn2返回的也是0
            res += getCn2(right - left);
        }
        return res % 99997867;
    }
    private long getCn2(long n) {
        return n * (n - 1) / 2;
    }





    /**
     * dfs + 回溯， 太慢
     * @param curr: 上个添加的索引
     * @param cnt： 已埋伏个数
     */
    public void dfs(int curr, int cnt, int limit, int[] position, Deque<Integer> deque) {
        //递归终点
        if (cnt == 3) {
            res += 1;
            res = res % 99997867;
            return ;
        }
        for (int i = curr + 1; i < position.length; ++i) {
            if (deque.isEmpty() ||position[i] - position[deque.peekFirst()] <= limit) {
                deque.addLast(i);
                dfs(i, cnt+1, limit, position, deque);
                //回溯
                deque.pollLast();
            }
        }
    }

}
