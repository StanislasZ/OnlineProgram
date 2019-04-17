package com.stan.algorithm;

import java.util.*;

public class 无重复字符的最长子串 {
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


        String s="abcabc";
        int length=lengthOfLongestSubstring(s);
        System.out.println("length is "+length);

//        String test="abcde";
//        System.out.println(test.substring(1,3));





    }


    /**
     * 使用 HashSet 将字符存储在当前窗口 [i, j)（最初 j = i）中。
     * 然后我们向右侧滑动索引 j，如果它不在 HashSet 中，我们会继续滑动 j。直到 s[j] 已经存在于 HashSet 中。
     *      （关键）若s[j]存在于HashSet中，只有把左侧边界向右移，直到HashSet不包含s[j]！！！！！！！！！！！！！！
     *        滑动！！come on!!
     *
     * 此时，我们找到的没有重复字符的最长子字符串将会以索引 ii 开头。如果我们对所有的 ii 这样做，就可以得到答案。
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        int n=s.length();
        HashSet<Character> set=new HashSet<>();
        int ans=0,i=0,j=0;
        while(i<n&&j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans=Math.max(ans,j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }



    /**
     * dp[i]代表以i为最大Index的子串,  dp[i]和dp[i-1]的关系如下，在dp[i-1]找s[i]最后一次出现的位置
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if(s.equals("")){
            return 0;
        }

        String[] dp=new String[s.length()];   //dp[i]代表以i为最大Index的子串



        dp[0]=s.substring(0,1);   //i=0，以0为最大Index，dp[0]就是第一个字符构成的字符串
        for(int i=1;i<s.length();i++){

            char current=s.charAt(i);
            int different_length=0;

            String former=dp[i-1];
            System.out.println("former is "+former);

            int last_index=former.lastIndexOf(current);
            System.out.println("last_index="+last_index);
            if(last_index==-1){
                different_length=former.length();
            }else{
                different_length=former.length()-last_index-1;
            }

            System.out.println("diff="+different_length);

            dp[i]=s.substring(i-different_length,i+1);
            System.out.println("dp["+i+"]="+dp[i]);


        }

        Arrays.sort(dp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()>o2.length())
                    return -1;
                else if (o1.length()<o2.length())
                    return 1;
                else
                    return 0;
            }
        });

        for(String ss:dp){
            System.out.println(ss);
        }




        return dp[0].length();
    }




}
