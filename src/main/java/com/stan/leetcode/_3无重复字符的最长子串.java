package com.stan.leetcode;

import java.util.*;

public class _3无重复字符的最长子串 {
    public static void main(String[] args){

        /*

            给定一个字符串，找出不含有重复字符的最长子串的长度。

            输入: "abcabcbb"
            输出: 3
            解释: 无重复字符的最长子串是 "abc"，其长度为 3。

            输入: "bbbbb"
            输出: 1
            解释: 无重复字符的最长子串是 "b"，其长度为 1。

            输入: "pwwkew"
            输出: 3
            解释: 无重复字符的最长子串是 "wke"，其长度为 3。
                 请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
         */



    }

    /**
     * 还是用map， if containsKey 不用去删除，只要让i跳到对应的值+1 的位置
     * 但是要注意: i是不能回退的， 可能对应的值+1 < 当前i  ，这时仍取i，也就是取两者的较大者
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring4(String s) {

        char[] arr = s.toCharArray();
        int i = 0;
        int j = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (j < arr.length) {
            if (map.containsKey(arr[j])) {
                //防止i回退
                i = Math.max(i, map.get(arr[j]) + 1);
            }
            map.put(arr[j], j++);
            max = Math.max(max, j - i);
        }
        return max;
    }
    /**
     * 用map存，一旦发现当前的在map中，head跳到对应的值+1，并删除之间的key
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        int head = 0;
        int tail = 0;
        int rlt = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();

        while (tail < arr.length) {
            if (map.containsKey(arr[tail])) {

                int index = map.get(arr[tail]);
                for (int k = head; k <= index; k++) {
                    map.remove(arr[k]);
                }
                head = index + 1;

            }

            map.put(arr[tail], tail);
            rlt = Math.max(rlt, tail - head + 1);
            tail++;


        }
        return rlt;
    }



    /**
     * 使用 HashSet 将字符存储在当前窗口 [i, j)（最初 j = i）中。
     * 然后我们向右侧滑动索引 j，如果它不在 HashSet 中，我们会继续滑动 j。直到 s[j] 已经存在于 HashSet 中。
     *      （关键）若s[j]存在于HashSet中，只有把左侧边界向右移，直到HashSet不包含s[j]
     *
     *
     * 此时，我们找到的没有重复字符的最长子字符串将会以索引 ii 开头。如果我们对所有的 ii 这样做，就可以得到答案。
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (j < arr.length) {
            if (!set.contains(arr[j])) {
                set.add(arr[j]);
                max = Math.max(max, j - i + 1);
                j++;
            } else {
                set.remove(arr[i++]);
            }
        }
        return max;
    }





}
