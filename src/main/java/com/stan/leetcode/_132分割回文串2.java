package com.stan.leetcode;

import java.util.*;

public class _132分割回文串2 {

    public static void main(String[] args) {

//        System.out.println(new _132分割回文串2().minCut_dfs("abababababababababababababababababababababa"));
        System.out.println(new _132分割回文串2().minCut("abc"));

    }

    Map<String, Integer> map = new HashMap<>();


    public int minCut_dfs(String s) {
        return dfs(s, 0, s.length() - 1);
    }


    /**
     * dp
     * dp[j] 代表 s[0,j]最少切的次数
     * 对于一个确定的j, 若存在k1, k2 ,k3 , s[k1, j]， s[k2, j], s[k3, j]都是回文
     * 则dp[j] 可以从3个方向过来， 分别是 dp[k1 - 1] + 1, dp[k2 - 1] + 1, dp[k3 - 1] + 1
     * 取三者的最小者即可
     *
     *
     * @param s
     * @return
     */
    public int minCut(String s) {
        System.out.println("****");

        if(s == null || s.length() <= 1) return 0;
        int len = s.length();
        int[] dp = new int[len];
        Arrays.fill(dp, len-1);
        for(int i = 0; i < len; i++){
            // 注意偶数长度与奇数长度回文串的特点
            mincutHelper(s , i , i , dp);  // 奇数回文串以1个字符为中心
            mincutHelper(s, i , i+1 , dp); // 偶数回文串以2个字符为中心
        }
        return dp[len-1];
    }
    private void mincutHelper(String s, int i, int j, int[] dp){
        int len = s.length();
        while(i >= 0 && j < len && s.charAt(i) == s.charAt(j)){
            System.out.println("****");
            dp[j] = Math.min(dp[j] , i == 0? 0: dp[i-1] + 1);
            -- i;
            ++ j;
        }
    }

    /**
     * 带有记忆的dfs， 击败5%， 不理想
     * @param s
     * @param left
     * @param right
     * @return :返回s[left, right]最少切成几块，每块都是回文
     */
    private int dfs(String s, int left, int right) {

        if (map.containsKey(s.substring(left, right + 1)))
            return map.get(s.substring(left, right + 1));

        if (left == right) return 1;
        if (left > right) return 0;

        int min = s.length();
        for (int i = left; i <= right; ++i) {
            if (isHui(s, left, i)) {
                //[left, i]是回文
                min = Math.min(min, 1 + dfs(s, i + 1, right));
            }
        }
        map.put(s.substring(left, right + 1), min);
        return min;
    }

    //是否为回文
    private boolean isHui(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
