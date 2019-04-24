package com.stan.leetcode;

public class _71简化路径 {
    public static void main(String[] args) {
        String str = "/home/";
        System.out.println(new Solution_71().simplifyPath(str));

    }
}
class Solution_71 {
    public String simplifyPath(String path) {

        String[] arr = path.split("/");

        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i +"]= " + arr[i]);
            if (arr[i].equals(".")) arr[i] = "";
            else if (arr[i].equals("..")) {
                arr[i] = "";
                int k = i -1;
                while (k >= 0) {
                    if (arr[k].equals("")) {
                        k--;
                        continue;
                    }
                    arr[k] = "";  //..要消除前一个目录
                    break;
                }
            }

        }
        System.out.println(arr[1]);
        String rlt = "";
        for (String s : arr) {
            if (!s.equals(""))
                rlt = rlt + "/" + s;
        }
        return rlt;

    }
}