package com.stan.公司笔试.alibaba;

import java.util.*;

public class 优惠券 {


    static int max = 0;
/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int getMaxLength(String[] board, String[] chars) {

        Set<String> set = new HashSet<>();
        for (String s : chars) {
            set.add(s);
        }

        int rows = board.length;


        boolean[][] vis = new boolean[rows][];
        for (int i = 0; i < vis.length; ++i) {
            vis[i] = new boolean[board[i].length()];
        }

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length(); ++j) {
                dfs(board, i, j, 0, vis, set);
            }
        }

        return max;


    }

    static void dfs(String[] board, int row, int col, int cnt, boolean[][] vis, Set<String> set) {

        //递归终点
        if (!canMove(board, row, col, vis, set)) {
            max = Math.max(max, cnt);
            return;
        }
        //当前点能走
        vis[row][col] = true;
        dfs(board, row + 1, col , cnt + 1, vis, set);
        dfs(board, row - 1, col , cnt + 1, vis, set);
        dfs(board, row, col + 1, cnt + 1, vis, set);
        dfs(board, row, col - 1 , cnt + 1, vis, set);
        vis[row][col] = false;
    }

    static boolean canMove(String[] board, int row, int col, boolean[][] vis, Set<String> set) {
        if (row < 0 || row >= board.length) return false;
        if (col < 0 || col >= board[row].length()) return false;
        if (vis[row][col]) return false;
        return set.contains(board[row].charAt(col) + "");
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] board = split(in.nextLine().trim(), ",");
        String[] chars = split(in.nextLine().trim(), ",");
        int maxLength = getMaxLength(board, chars);

        System.out.println(maxLength);
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

    public static String[] split(String str, String separatorChars) {
        return splitWorker(str, separatorChars, -1, false);
    }
}