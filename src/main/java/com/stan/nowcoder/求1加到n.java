package com.stan.nowcoder;

public class 求1加到n {
}


class Solution_求1加到n_递归 {
    public int Sum_Solution(int n) {
        if (n != 1) return n + Sum_Solution(n - 1);
        else return 1;
    }
}

class Solution_求1加到n {
    public int Sum_Solution(int n) {
        if (n != 1) return n + Sum_Solution(n - 1);
        else return 1;
    }
}