package com.stan.nowcoder;

public class 构建乘积数组 {

    /*
        给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
        其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
        不能使用除法。


        思路：

            设有数组大小为5。
            对于第一个for循环
            第一步：b[0] = 1;
            第二步：b[1] = b[0] * a[0] = a[0]
            第三步：b[2] = b[1] * a[1] = a[0] * a[1];
            第四步：b[3] = b[2] * a[2] = a[0] * a[1] * a[2];
            第五步：b[4] = b[3] * a[3] = a[0] * a[1] * a[2] * a[3];
            然后对于第二个for循环
            第一步
            temp *= a[4] = a[4];
            b[3] = b[3] * temp = a[0] * a[1] * a[2] * a[4];
            第二步
            temp *= a[3] = a[4] * a[3];
            b[2] = b[2] * temp = a[0] * a[1] * a[4] * a[3];
            第三步
            temp *= a[2] = a[4] * a[3] * a[2];
            b[1] = b[1] * temp = a[0] * a[4] * a[3] * a[2];
            第四步
            temp *= a[1] = a[4] * a[3] * a[2] * a[1];
            b[0] = b[0] * temp = a[4] * a[3] * a[2] * a[1];
            由此可以看出从b[4]到b[0]均已经得到正确计算。
     */



    public int[] multiply(int[] A) {

        int N = A.length;
        int[] B = new int[N];
        if (N == 0) return B;

        B[0] = 1;
        //第一次遍历 间隔点之前的乘起来 B[i] = A[0]*A[1]*...*A[i-1]
        for (int i = 1; i < N; ++i) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = 1;
        //第二次遍历 间断点之后的乘起来 B[i] = B[i] * A[i+1]*A[i+2]*...*A[N-1]
        for (int i = N - 1; i >= 0; --i) {
            B[i] = B[i] * temp;
            temp = temp * A[i];
        }
        return B;

    }
}
