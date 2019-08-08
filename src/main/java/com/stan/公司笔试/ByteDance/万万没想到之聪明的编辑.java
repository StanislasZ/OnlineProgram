package com.stan.公司笔试.ByteDance;

import java.util.Scanner;

public class 万万没想到之聪明的编辑 {

    /*
        我叫王大锤，是一家出版社的编辑。我负责校对投稿来的英文稿件，这份工作非常烦人，因为每天都要去修正无数的拼写错误。但是，优秀的人总能在平凡的工作中发现真理。我发现一个发现拼写错误的捷径：

        1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
        2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
        3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC

        我特喵是个天才！我在蓝翔学过挖掘机和程序设计，按照这个原理写了一个自动校对器，工作效率从此起飞。用不了多久，我就会出任CEO，当上董事长，迎娶白富美，走上人生巅峰，想想都有点小激动呢！
        ……
        万万没想到，我被开除了，临走时老板对我说： “做人做事要兢兢业业、勤勤恳恳、本本分分，人要是行，干一行行一行。一行行行行行；要是不行，干一行不行一行，一行不行行行不行。” 我现在整个人红红火火恍恍惚惚的……

        请听题：请实现大锤的自动校对程序


        输入描述:
        第一行包括一个数字N，表示本次用例包括多少个待校验的字符串。

        后面跟随N行，每行为一个待校验的字符串。

        输出描述:
        N行，每行包括一个被修复后的字符串。

        输入例子1:
        2
        helloo
        wooooooow

        输出例子1:
        hello
        woow
     */


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[] arr = new String[N];
        scanner.nextLine();
        Solution_万万没想到之聪明的编辑 s = new Solution_万万没想到之聪明的编辑();
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = scanner.nextLine();
            //System.out.println("原字符串 = " + arr[i]);
            System.out.println(s.process2(arr[i]));
        }
        scanner.close();


    }
}

class Solution_万万没想到之聪明的编辑 {

    /**
     * 抄的
     * @param str
     * @return
     */
    public String process2(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {

            //...aa再来个a不append
            if (sb.length() >= 2) {
                if (c == sb.charAt(sb.length() - 1) && c == sb.charAt(sb.length() - 2))
                    continue;
            }

            //...aab再来个b不append
            if (sb.length() >= 3) {
                if (c == sb.charAt(sb.length() - 1) && sb.charAt(sb.length() - 2) == sb.charAt(sb.length() - 3))
                    continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }


    /**
     * 自己写的，垃圾
     * @param str
     * @return
     */
    public String process(String str) {

        char[] arr = str.toCharArray();
        int N = arr.length;
        if (arr.length <= 2) return str;
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = 1;
        while (left < N) {
            //前后2个不同 或 left已经是最后一个索引， 直接加arr[left] 双指针后移
            if (left == N - 1 || arr[left] != arr[right]) {
                sb.append(arr[left]);
                ++ left;
                ++ right;
            } else {
                //.....aaabbbbc......为例，要变成.....aabc.....
                sb.append(arr[left]);
                sb.append(arr[left]);

                int n = getNextDifferent(arr, right);  //第一个b的索引
                int nn = getNextDifferent(arr, n);  //第一个c的索引

                if (n < N) sb.append(arr[n]);
                left = nn;
                right = left + 1;


            }

        }
        return sb.toString();


    }
    //获取第一个与arr[curr]不同的索引
    private int getNextDifferent(char[] arr, int curr) {
        if (curr >= arr.length) return arr.length;
        int next = curr + 1;
        while (next < arr.length) {
            if (arr[next] != arr[curr]) {
                break;
            }
            ++ next;
        }
        return next;
    }
}
