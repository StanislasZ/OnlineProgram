package com.stan.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _490迷宫 {

    /*
        由空地和墙组成的迷宫中有一个球。球可以向上下左右四个方向滚动，但在遇到墙壁前不会停止滚动。当球停下时，可以选择下一个方向。

        给定球的起始位置，目的地和迷宫，判断球能否在目的地停下。

        迷宫由一个0和1的二维数组表示。 1表示墙壁，0表示空地。你可以假定迷宫的边缘都是墙壁。起始位置和目的地的坐标通过行号和列号给出。

         

        示例 1:

        输入 1: 迷宫由以下二维数组表示

        0 0 1 0 0
        0 0 0 0 0
        0 0 0 1 0
        1 1 0 1 1
        0 0 0 0 0

        输入 2: 起始位置坐标 (rowStart, colStart) = (0, 4)
        输入 3: 目的地坐标 (rowDest, colDest) = (4, 4)

        输出: true

        解析: 一个可能的路径是 : 左 -> 下 -> 左 -> 下 -> 右 -> 下 -> 右。

        示例 2:

        输入 1: 迷宫由以下二维数组表示

        0 0 1 0 0
        0 0 0 0 0
        0 0 0 1 0
        1 1 0 1 1
        0 0 0 0 0

        输入 2: 起始位置坐标 (rowStart, colStart) = (0, 4)
        输入 3: 目的地坐标 (rowDest, colDest) = (3, 2)

        输出: false


     */

    public static void main(String[] args) {
        int[][] maze = new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = new int[]{0, 4};
        int[] des = new int[]{4, 4};

        System.out.println(new _490迷宫().hasPath(maze, start, des));
    }


    int[][] directions;
    boolean[][] visited;

    /**
     * dfs 抄的， 把4个方向弄成一个二维数组，代码较为简洁
     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public boolean hasPath2(int[][] maze, int[] start, int[] destination) {
        directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        visited = new boolean[maze.length][maze[0].length];
        for (int i = 0; i < 4; i++)
            if (dfs2(maze, start[0], start[1], destination, i)) return true;

        return false;
    }

    public boolean dfs2(int[][] maze, int x, int y, int[] dest, int dIdx){
        int next_x = x + directions[dIdx][0];
        int next_y = y + directions[dIdx][1];
        // cannot move in this direction
        if (next_x < 0
                || next_x > maze.length -1
                || next_y < 0 || next_y > maze[0].length -1
                || maze[next_x][next_y] == 1)
            return false;

        while(next_x >= 0
                && next_x <=  maze.length - 1
                && next_y >= 0 && next_y <= maze[0].length - 1
                && maze[next_x][next_y] == 0){
            x = next_x;
            y = next_y;
            next_x = x + directions[dIdx][0];
            next_y = y + directions[dIdx][1];
        }
        //ball stop at {x,y}
        if (x == dest[0] && y == dest[1]) return true;
        if (!visited[x][y]){
            visited[x][y] = true;
            //change direction
            if (dIdx == 0 || dIdx == 1){
                if(dfs2(maze, x, y, dest, 2) || dfs2(maze, x, y, dest, 3)) return true;
            }else {
                if(dfs2(maze, x, y, dest, 0) || dfs2(maze, x, y, dest, 1)) return true;
            }
        }
        return false;
    }


    boolean[][] vis;
    int rows;
    int cols;
    boolean flag = false;

    /**
     * dfs
     * 自己写的，剪纸后，击败80%
     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public boolean hasPath3(int[][] maze, int[] start, int[] destination) {

        rows = maze.length;
        cols = maze[0].length;

        vis = new boolean[rows][cols];
        vis[start[0]][start[1]] = true;

        return dfs(maze, start[0], start[1], destination);

    }

    public boolean dfs(int[][] maze, int row, int col, int[] dest){

        //递归终点
        if (flag) return true;
        if (row == dest[0] && col == dest[1]) return true;

        for (int ele : getDestination(maze, row, col)) {
            int r = ele / cols;
            int c = ele % cols;
            if (dfs(maze, r, c, dest)) return true;
        }
        return false;
    }



    /**
     * bfs 队列  击败30%
     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        int rows = maze.length;
        int cols = maze[0].length;

        System.out.println("rows = " + rows + ", cols = " + cols);
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] vis = new boolean[rows][cols];

        queue.add(start[0] * cols + start[1]);
        vis[start[0]][start[1]] = true;
        System.out.println(queue);
        while (!queue.isEmpty()) {
            int top = queue.poll();
            if (top == destination[0] * cols + destination[1]) return true;
            int row = top / cols;
            int col = top % cols;

            System.out.println("队列得到row = " + row + ", col = " + col);


            for (int ele : getDestination(maze, row, col)) {
                queue.add(ele);
            }

        }
        return false;

    }

    private List<Integer> getDestination(int[][] maze, int row, int col) {

        List<Integer> list = new ArrayList<>();
        int temp = row;
        for (; temp - 1 >= 0 && maze[temp - 1][col] == 0; -- temp);
        if (!vis[temp][col]) {
            vis[temp][col] = true;
            list.add(temp * cols + col);
        }


        temp = row;
        for (; temp + 1 < rows && maze[temp + 1][col] == 0; ++ temp);
        if (!vis[temp][col]) {
            vis[temp][col] = true;
            list.add(temp * cols + col);
        }


        temp = col;
        for (; temp - 1 >= 0 && maze[row][temp - 1] == 0; -- temp);
        if (!vis[row][temp]) {
            vis[row][temp] = true;
            list.add(row * cols + temp);
        }


        temp = col;
        for (; temp + 1 < cols && maze[row][temp + 1] == 0; ++ temp);
        if (!vis[row][temp]) {
            vis[row][temp] = true;
            list.add(row * cols + temp);
        }

        System.out.print("row = " + row + ", col = " + col + " 对应 ");
        System.out.println(list);
        return list;


    }
}
