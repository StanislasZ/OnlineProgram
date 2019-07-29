package com.stan.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class 字符串的排列 {

    public static void main(String[] args) {
        System.out.println(new 字符串的排列().Permutation("ab"));
    }

    private ArrayList<String> rlt = new ArrayList<>();
    private boolean[] vis;
    private char[] temp;

    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0) return rlt;

        char[] arr = str.toCharArray();
        vis = new boolean[arr.length];
        temp = new char[arr.length];
        Arrays.sort(arr);
        dfs(arr, 0);
        return rlt;

    }
    private void dfs(char[] arr, int i) {
        if (i == arr.length) {
            rlt.add(new String(temp));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int j = 0; j < arr.length; j++) {
            if (!vis[j] && !set.contains(arr[j])) {
                temp[i] = arr[j];
                vis[j] = true;
                //第i位用过哪些数字，加进去，通过if里的判断保证第i位用过的数字不重复
                set.add(arr[j]);
                dfs(arr, ++i);
                --i;
                //回溯
                vis[j] = false;
            }
        }
    }


    /**
     * 交换法，现在写的不能保证字典序，爆炸
     * @param str
     * @return
     */
    public ArrayList<String> Permutation2(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        Permutation(arr, 0);
        return rlt;

    }
    private void Permutation(char[] arr, int i) {
        if (i == arr.length) {
            rlt.add(new String(arr));
            return;
        }

        for (char c : arr) System.out.print(c + " ");

        //set只用于下面的for循环，只在当前第i位起作用，进入递归后是全新的set
        //Arrays.sort(arr, i+1, arr.length);
        HashSet<Character> set = new HashSet<>();
        for (int j = i; j < arr.length; j++) {
            if (!set.contains(arr[j])) {
                swap(arr, i, j);
                Permutation(arr, i + 1);
                swap(arr, i, j);
            }
        }

    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
