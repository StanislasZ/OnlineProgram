package com.stan.bishi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 程序员 {
    static int rows = 0;
    static int cols = 0;
    static int[][] input = new int[10][10];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rlt = 0;
        int one_num = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        int fa = 0;
        int son = 0;
        while (scanner.hasNextLine()) {


            String temp = scanner.nextLine();
            if (temp.equals("")) break;
            String[] str_arr = temp.split(" ");
            cols = str_arr.length;
            for (int i = 0; i < str_arr.length; i++) {
                input[rows][i] = Integer.parseInt(str_arr[i]);
                if (input[rows][i] == 2) {
                    queue.add(new Coordinate(rows, i));
                    fa++;

                }else if (input[rows][i] == 1) {
                    one_num++;
                }
            }
            rows++;
        }

        System.out.println("**");

        while (!queue.isEmpty()) {
            Coordinate top = queue.poll();
//            System.out.println("进来，top = " + top);
            fa--;

            int r = top.row;
            int c = top.col;

            if (canChange(r, c + 1)) {
//                System.out.println(r + ", " + (c+1) + " 入队列");
                queue.add(new Coordinate(r, c + 1));
                input[r][c + 1] = 2;
                son++;
                one_num--;
            }
            if (canChange(r, c - 1)) {
//                System.out.println(r + ", " + (c-1) + " 入队列");
                queue.add(new Coordinate(r, c - 1));
                input[r][c - 1] = 2;
                son++;
                one_num--;
            }
            if (canChange(r + 1, c)) {
//                System.out.println((r+1) + ", " + c + " 入队列");
                queue.add(new Coordinate(r + 1, c));
                input[r + 1][c] = 2;
                son++;
                one_num--;
            }
            if (canChange(r - 1, c)) {
//                System.out.println((r-1) + ", " + c + " 入队列");
                queue.add(new Coordinate(r - 1, c));
                input[r - 1][c] = 2;
                son++;
                one_num--;
            }

            if (fa == 0) {

                rlt++;
                fa  = son;
                son = 0;
                //System.out.println("fa= 0， rlt+1， rlt="+rlt);
            }

        }
        if (one_num != 0) System.out.println(-1);
        else System.out.println(rlt - 1);

    }
    public static boolean canChange(int row, int col) {

        if (row < 0 || row >= rows || col < 0 || col >= cols) return false;
        return input[row][col] == 1;
    }
}

class Coordinate{
    int row;
    int col;

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
