package com.stan.leetcode;

public class _32最长有效括号 {

    /*
        给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

        示例 1:

        输入: "(()"
        输出: 2
        解释: 最长有效括号子串为 "()"
        示例 2:

        输入: ")()())"
        输出: 4
        解释: 最长有效括号子串为 "()()"

     */


    /**
     * 动态规划
     * dp[i]: 以i-1位为结尾的最长括号的长度
     *      若s[i - 1] == '(' 不可能有效 ，为0
     *      -----------------------------
     *      若s[i - 1] == ')'，可以和左边某一个'('闭合
     *      定位前一段有效部分的左边一位j，这一位是 (  的话，可以和当前位的 ）闭合
     *
     *      至此，dp[i] 至少= dp[i - 1] + 2 ，即前一段有效长度 加 新的2个
     *      注意： 还要加上以j - 1位为结尾的有效长度
     *
     *      比如： ()()()  (   ()()()   ) <-当前
     *      首先发现前一段有效长度 = 6， 且这一段的前一个是 （
     *      ( ()()() ) 已经有8
     *      再加上更左边的 （）（）（）的长度6
     *      总长度为6+2+6 = 14
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {

        int N = s.length();
        char[] arr = s.toCharArray();
        int[] dp = new int[N + 1];
        int res = 0;
        for (int i = 1; i <= arr.length; ++i) {

            if (arr[i - 1] == '(') dp[i] = 0;
            else {
                //上一个不属于有效括号的索引
                int prev_invalid = (i - 1) - dp[i - 1] - 1;
                //上一个无效处 为左括号才能和当前的右括号闭合起来
                if (prev_invalid >= 0 && arr[prev_invalid] == '(') {

                    //比如：  有效部分(有效部分)
                    //不要遗漏 以prev_invalid- 1为结尾的长度!!!
                    dp[i] = dp[i - 1] + 2 + dp[prev_invalid];
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;

    }

}
