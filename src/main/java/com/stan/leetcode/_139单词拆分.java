package com.stan.leetcode;

import java.util.*;

public class _139单词拆分 {



    public static void main(String[] args) {

        String s = "aaaaaaaaaaaaa";
        List<String> list = Arrays.asList("aaa", "aa", "a");
        System.out.println(new _139单词拆分().wordBreak(s, list));
    }

    int[] can;  //0没弄  1可以 2不可以

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> dict = new HashSet<>(wordDict);
        can = new int[s.length()];
        return dfs(s, dict, 0);
    }


    /**
     * dfs + can数组记忆
     * @param s
     * @param dict
     * @param curr
     * @return： s[curr, end]是否可拆分
     */
    private boolean dfs(String s, Set<String> dict, int curr) {

        //递归终点
        if (curr == s.length() || can[curr] == 1) return true;
        if (can[curr] == 2) return false;

        for (int i = curr; i < s.length(); ++ i) {
            if (dict.contains(s.substring(curr, i + 1))) {
                //find
                if (dfs(s, dict, i + 1)) {
                    can[curr] = 1;
                    return true;
                }
            }
        }
        can[curr] = 2;
        return false;
    }


    /**
     * bfs
     *
     * 队列中放置的是以它为起始索引，去匹配dict里的单词，
     * 比如开始是0，匹配到s[0,2] = cat， 就把3入队列，重新开始看
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak_bfs(String s, List<String> wordDict) {

        Set<String> wordDictSet = new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);

        while (!queue.isEmpty()) {
            int start = queue.poll();

            //以start为起始索引，去dict里找单词，  试过的就不用再试了
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {   //终止条件
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }


    /**
     * 动态规划
     * dp[i] 表示 如果s[0, i - 1]能被拆分，为true， 否则为false
     *
     * 对于i， dp[0]到dp[i - 1]都已经确定
     * 要判断dp[i]是否为true， 只要令j = 0到i - 1
     * 只要dp[j] 且 s[j, i - 1]为dict中的一个， dp[i]就为true
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak_dp(String s, List<String> wordDict) {

        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];   //多开一格
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;    //跳出内循环
                }
            }
        }
        return dp[s.length()];
    }


}
