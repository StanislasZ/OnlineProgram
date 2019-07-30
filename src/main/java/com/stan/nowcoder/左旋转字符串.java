package com.stan.nowcoder;

public class 左旋转字符串 {

    /*
        汇编语言中有一种移位指令叫做循环左移（ROL），
        现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
        对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
        例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
        即“XYZdefabc”。是不是很简单？OK，搞定它！
     */


    /**
     * 同leetcode189.旋转数组
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str,int n) {
        if (str.length() == 0) return str;
        char[] arr = str.toCharArray();
        int N = arr.length;
        n = n % N;
        reverse(arr,0, N - 1);
        reverse(arr,0, N - n - 1);
        reverse(arr,N - n, N - 1);
        return new String(arr);

    }

    private void reverse(char[] arr, int left, int right) {

        while (left < right) {
            char temp = arr[right];
            arr[right--] = arr[left];
            arr[left++] = temp;
        }
    }
}
