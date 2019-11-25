package com.stan.algorithom.string;

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
     *
     */



    public static void main(String[] args) {


        String pattern = "aabb";
        String text = "abcabbcabcaabb";

        System.out.println(KMP(text, pattern));

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
        for (int p = 0; p < next.length; ++p) System.out.println("next[" + p + "] = " + next[p]);
        System.out.println("**");
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


}
