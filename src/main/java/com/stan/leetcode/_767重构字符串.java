package com.stan.leetcode;

import java.util.*;

public class _767重构字符串 {


    /**
     * 每次加2个 （当次最多和次多的）
     * 获得最多和次多， 用堆，即优先队列
     * @param S
     * @return
     */
    public String reorganizeString(String S) {
        //整理好各个字母对应出现的频率
        int[] counts = new int[26];
        for (int i = 0; i < S.length(); i++) counts[S.charAt(i) - 'a']++;

        Queue<Letter> pq = new PriorityQueue<>(26, Comparator.comparingInt(Letter::getCnt).reversed());


        //往最大堆给我丢
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0 && counts[i] <= (S.length() + 1) / 2)
                pq.add(new Letter(counts[i], (char) (i + 'a')));
            else if (counts[i] > (S.length() + 1) / 2) {   //剪枝
                return "";
            }
        }

        StringBuilder str = new StringBuilder();

        while (pq.size() > 1) {//最后剩下一个字符或者一个不剩，终止

            Letter c1 = pq.poll();  //最多
            Letter c2 = pq.poll();   //次多

            str.append(c1.val);
            str.append(c2.val);

            if (--c1.cnt > 0) pq.add(c1);   //还有的话，刚才弹了，现在再塞回去
            if (--c2.cnt > 0) pq.add(c2);
        }
        //奇数个
        if (pq.size() > 0) str.append(pq.poll().val);
        return str.toString();
    }

    //字母类
    static class Letter {
        int cnt;//出现的频率
        char val;//字母

        public Letter(int count, char letter) {
            this.cnt = count;
            this.val = letter;
        }

        public int getCnt() {
            return cnt;
        }
    }
}
