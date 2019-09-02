package com.stan.公司笔试.alibaba;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;



public class 字符串按金字塔 {

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String[] splitWordsLikePyramid(String[] input) {

        List<String> list = new ArrayList<>();
        list.add(input[0]);

        for (int i = 1; i < input.length; ++i) {
            String last = list.get(list.size() - 1);

        }

        int i = 1;
        String curr = "";
        while (i < input.length) {

            String last = list.get(list.size() - 1);
            while (i < input.length && curr.length() <= last.length()) {
                curr = curr.length() == 0?  curr + input[i++]: curr + " " + input[i++];
            }
            list.add(curr);
            curr = "";
        }
        //System.out.println(list);
        if (list.size() > 1 && list.get(list.size() - 1).length() < list.get(list.size() - 2).length()) {
            String end = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            list.set(list.size() - 1, list.get(list.size() - 1) + " " + end);
        }
        //System.out.println(list);


        int len = list.get(list.size() - 1).length();
        String[] res = new String[list.size()];
        for (int j = 0; j < list.size(); ++j) {
            int offset = len - list.get(j).length();

            String prefix = "", suffix = "";
            for (int k = 0; k < offset / 2; ++k) {
                prefix += " ";
                suffix += " ";
            }

            if (offset % 2 == 1)
                prefix += " ";
            res[j] = prefix + list.get(j) + suffix;
        }
        return res;

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        /** 将用户输入以空格分隔,转成字符串数组,作为函数的入参 **/
        String[] inputArray = split(in.nextLine().trim(), " ");
//        for (String s : inputArray) System.out.println(s);
        String[] output = splitWordsLikePyramid(inputArray);
        for (String line : output) {
            System.out.println(line);
        }
    }

    private static String[] splitWorker(String str, String separatorChars, int max, boolean preserveAllTokens) {
        // Performance tuned for 2.0 (JDK1.4)
        // Direct code is quicker than StringTokenizer.
        // Also, StringTokenizer uses isSpace() not isWhitespace()

        if (str == null) {
            return null;
        }
        int len = str.length();
        if (len == 0) {
            return new String[0];
        }
        List list = new ArrayList();
        int sizePlus1 = 1;
        int i = 0, start = 0;
        boolean match = false;
        boolean lastMatch = false;
        if (separatorChars == null) {
            // Null separator means use whitespace
            while (i < len) {
                if (Character.isWhitespace(str.charAt(i))) {
                    if (match || preserveAllTokens) {
                        lastMatch = true;
                        if (sizePlus1++ == max) {
                            i = len;
                            lastMatch = false;
                        }
                        list.add(str.substring(start, i));
                        match = false;
                    }
                    start = ++i;
                    continue;
                }
                lastMatch = false;
                match = true;
                i++;
            }
        } else if (separatorChars.length() == 1) {
            // Optimise 1 character case
            char sep = separatorChars.charAt(0);
            while (i < len) {
                if (str.charAt(i) == sep) {
                    if (match || preserveAllTokens) {
                        lastMatch = true;
                        if (sizePlus1++ == max) {
                            i = len;
                            lastMatch = false;
                        }
                        list.add(str.substring(start, i));
                        match = false;
                    }
                    start = ++i;
                    continue;
                }
                lastMatch = false;
                match = true;
                i++;
            }
        } else {
            // standard case
            while (i < len) {
                if (separatorChars.indexOf(str.charAt(i)) >= 0) {
                    if (match || preserveAllTokens) {
                        lastMatch = true;
                        if (sizePlus1++ == max) {
                            i = len;
                            lastMatch = false;
                        }
                        list.add(str.substring(start, i));
                        match = false;
                    }
                    start = ++i;
                    continue;
                }
                lastMatch = false;
                match = true;
                i++;
            }
        }
        if (match || (preserveAllTokens && lastMatch)) {
            list.add(str.substring(start, i));
        }
        return (String[])list.toArray(new String[list.size()]);
    }

    static String[] split(String str, String separatorChars) {
        return splitWorker(str, separatorChars, -1, false);
    }
}