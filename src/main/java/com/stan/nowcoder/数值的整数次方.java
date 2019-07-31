package com.stan.nowcoder;

public class 数值的整数次方 {

    public double Power(double base, int n) {

        if (n == 0) {
            if (base == 0) throw new RuntimeException("0的0次不存在");
            return 1;
        }
        if (base== 0) {
            if (n < 0) throw new RuntimeException("分母不能为0");
            return 0;
        }
        double res = 1;
        double curr = base;
        int e = n > 0?  n : -n;

        //快速幂求法
        //a的11次 = a 的 (2的0次 + 2的1次 + 2的3次)
        //        = a的(2的0次) * a的(2的1次) * a的(2的3次)
        while (e > 0) {
            if ((e & 1) == 1) //奇数
                res = res * curr;    //原来的数二进制为1的位就是不停右移时的最低位=1
            curr = curr * curr;
            e = e >> 1;

        }
        return n > 0? res : 1 /res;
    }
}
