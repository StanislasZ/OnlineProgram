package com.stan.leet_week_game;

public class _1138字母板上的路径 {
    public String alphabetBoardPath(String target) {
        String rlt = "";
        char pre = 'a';
        char[] arr = target.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == pre) {
                rlt = rlt + "!";
            } else {
                //从z到其他地方，先往上一次
                if (pre == 'z') {
                    pre = 'u';
                    rlt = rlt + 'U';
                }

                int row_delta = getRow(arr[i]) - getRow(pre);
                int col_delta = getCol(arr[i]) - getCol(pre);

                char row_move = row_delta > 0? 'D': 'U';
                char col_move = col_delta > 0? 'R': 'L';
                row_delta = row_delta > 0? row_delta : - row_delta;
                col_delta = col_delta > 0? col_delta : - col_delta;
                //先左右移动，避免了从其他点到z 出现到不可达的情况
                while (col_delta > 0) {
                    rlt = rlt + col_move;
                    col_delta--;
                }
                while (row_delta > 0) {
                    rlt = rlt + row_move;
                    row_delta--;
                }

                rlt = rlt + '!';
            }
            pre = arr[i];
        }
        return rlt;
    }




    private int getRow(char c) {
        int offset = c - 'a';
        return offset / 5;
    }
    private int getCol(char c) {
        int offset = c - 'a';
        return offset % 5;
    }
}
