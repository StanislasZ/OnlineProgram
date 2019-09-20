package com.stan.公司笔试.小马智行;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pony_Ai {

    static Map<Character, Integer> map = new HashMap<>();
    static int cnt = 0;

    public static void main(String[] args) {

        map.put('F', 1);
        map.put('Z', 2);
        map.put('Y', 3);
        map.put('G', 4);


        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            cnt = 0;
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int start_row = scanner.nextInt();
            int start_col = scanner.nextInt();
            scanner.nextLine();
            char[][] matrix = new char[rows][cols];
            int[] key = new int[4];  //有没有拿到钥匙
            int[] go = new int[4];  //有没有去过

            for (int i = 0; i < rows; ++i) {
                String s = scanner.nextLine();
                //System.out.println(s);
                for (int j = 0; j < cols; ++j) matrix[i][j] = s.charAt(j);
            }
            dfs(matrix, key, go, rows, cols, start_row, start_col);
            System.out.println(cnt);
        }
    }

    public static void dfs(char[][] matrix, int[] key, int[] go, int rows, int cols, int row, int col) {
        System.out.println("row = " + row + ", col = " + col);
        //递归终点
        if (success(go)) return;

        if (!canMove(matrix, key, rows, cols, row, col)) return;

        //能走
        char c = matrix[row][col];
        if (map.containsKey(c)) {
            go[map.get(c)]++;
        } else if (c - '0' >=1 && c - '0' <= 4) {
            key[c - '1']++;
        }
        ++ cnt;
        if (success(go)) return;

        dfs(matrix, key, go, rows, cols, row + 1, col);
        dfs(matrix, key, go, rows, cols, row - 1, col);
        dfs(matrix, key, go, rows, cols, row, col + 1);
        dfs(matrix, key, go, rows, cols, row, col - 1);

        //回溯
        if (map.containsKey(c)) {
            go[map.get(c)]--;
        } else if (c - '0' >=1 && c - '0' <= 4) {
            key[c - '0']--;
        }
        -- cnt;




    }

    //能否走这个格子
    public static boolean canMove(char[][] matrix, int[] key, int rows, int cols, int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || matrix[row][col] == '#') return false;
        if (matrix[row][col] == '-') return true;
        if (matrix[row][col] - '1' >=0 && matrix[row][col] - '1' <= 3) return true;
       // System.out.println(matrix[row][col]);
        int i = map.get(matrix[row][col]);
        return key[i] > 0;
    }

    public static boolean success(int[] go) {
        for (int b: go) {
            if (b <= 0) return false;
        }
        return true;
    }
}
