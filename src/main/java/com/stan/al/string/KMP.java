package com.stan.al.string;

public class KMP {

    /**
     * KMP算法:
     * next[i] 表示模式串的 0 ~ i 中 前缀后缀相同的最大长度
     *
     * 我们用 i 指针指向主串, j 指针指向模式串。如果我们发现当前位置不匹配，使用暴力法会同时回溯 i, j 两指针
     * 但是，更加高效的做法应该是保持 i 指针不动, 移动 j 指针
     * 因为，我们匹配的时候，虽然有时遭遇失败，但不代表这次匹配全是无用的
     * 起码，我们验证了模式串 j 之前的子串能够与主串匹配。
     * 我们移动 j， 使得与后缀相同的前缀移动到后缀的位置，则这一部分仍然是匹配的，可以继续往后尝试
     * 用 next[j] 去表示每次匹配失败时 j 应该移到的位置
     */



    public static void main(String[] args) {


        String pattern = "aabb";
//        String text = "abcaabbcabcaabb";
        String text = "abcabbcabcaabb";

//        kmp_search(text, pattern);
        System.out.println(KMP(text, pattern));
//        KMP2(text, pattern);
    }

    public static void getNext(String pattern, int[] next) {
        next[0] = -1;
        int i = 0, len = -1;
        //循环内有next[++i]，防止数组越界，i < len - 1
        while (i < pattern.length() - 1) {

            if (len == -1 || pattern.charAt(i) == pattern.charAt(len)) {
                next[++i] = ++len;
            } else {
                len = next[len];
            }
        }
        System.out.println("**");
        for (int ele : next) System.out.println(ele);
        System.out.println("**");
    }


    //打印模式串出现的所有位置
    public static void KMP2(String text, String pattern) {
        int i = 0, j = 0;
        int[] next = new int[pattern.length()];
        getNext(pattern, next);

        int len1 = text.length();
        int len2 = pattern.length();
        while (i < len1) {
            if (j == len2 - 1 && text.charAt(i) == pattern.charAt(j)) {
                System.out.println("Found pattern at " + (i - j));
                j = next[j];  //不退出，仍继续搜索
            }

            if (j == -1 || text.charAt(i) == pattern.charAt(j)) {
                ++i;
                ++j;
            } else {
                j = next[j];   //j回退
            }
        }

    }

    //返回模式串第一次出现在text中的位置 即String的indexOf()方法
    public static int KMP(String text, String pattern) {
        int i = 0, j = 0;
        int[] next = new int[pattern.length()];
        getNext(pattern, next);

        int len1 = text.length();
        int len2 = pattern.length();
        while (i < len1) {
            if (j == len2 - 1 && text.charAt(i) == pattern.charAt(j)) {
                return i - j;   //匹配到，直接退出
            }
            if (j == -1 || text.charAt(i) == pattern.charAt(j)) {
                ++i;
                ++j;
            } else {
                j = next[j];   //j回退
            }
        }
        return -1;
    }







//    //from bilibili
//    public static void prefix_table(String pattern, int[] prefix) {
//        char[] pattern_char = pattern.toCharArray();
//        int n = prefix.length;
//        prefix[0] = 0;
//        int len = 0;
//        int i = 1;   //从索引=1开始比较
//        while (i < n) {
//            System.out.println("i = " + i + ", len = " + len);
//            if (pattern_char[i] == pattern_char[len]) {
//                len++;
//                prefix[i++] = len;
//            } else {
//                if (len > 0)
//                    len = prefix[len - 1];
//                else
//                    prefix[i++] = len;
//            }
//        }
//    }
//    //from bilibili
//    public static void move_prefix(int[] prefix) {
//        int length = prefix.length;
//
//        for (int i = length - 1; i > 0; i--) {
//            prefix[i] = prefix[i - 1];
//        }
//        prefix[0] = -1;
//
//
//    }
//    //from bilibili
//    public static void kmp_search(String text, String pattern) {
//        int m = text.length();
//        int n = pattern.length();
//        int[] prefix = new int[n];
//        prefix_table(pattern, prefix);
//        for (int ele : prefix) System.out.println(ele);
//        move_prefix(prefix);
//        System.out.println("prefix往右移一位，0位为-1");
//        for (int ele : prefix) System.out.println(ele);
//
//
//
//        //开始kmp
//        //text[i]   ,text长度为m
//        //pattern[j] ，pattern长度为n
//        int i = 0;
//        int j = 0;
//
//        while (i < m) {
//            if (j == n - 1 && text.charAt(i) == pattern.charAt(j)) {
//                System.out.println("Found pattern at " + (i - j));
//                j = prefix[j];
//            }
//            if (text.charAt(i) == pattern.charAt(j)) {
//                i++;
//                j++;
//            } else {
//                j = prefix[j];
//                if (j == -1) {
//                    i++;
//                    j++;
//                }
//            }
//        }
//    }
}
