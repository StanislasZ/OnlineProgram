package com.stan.nowcoder;

public class 数组中的逆序对 {

    /*
        在数组中的两个数字，如果前面一个数字大于后面的数字，
        则这两个数字组成一个逆序对。
        输入一个数组,求出这个数组中的逆序对的总数P。
        并将P对1000000007取模的结果输出。 即输出P%1000000007



     */

    /*
     * 思路:
     * 利用归并排序思想
     * 首先利用split函数对数组分解至底
     * 对于某个合并结点, 数组分为 p, q, r
     * p ~ q 有序, q + 1 ~ r 有序
     * 三个指针, p1, p2, p3 分别指向左边的尾, 右边的尾, 原尾
     * 若左边当前小于右边当前, 右边下落
     * 否则, 左边下落, 且cnt 增加 右边所剩元素总数
     * 直到某一边全部下落，然后对未下落的一边进行善后
     *
     * 思路总结就是在归并的同时，进行记录
     */

    private int cnt = 0;
    private int[] aux;  //辅助数组

    public int InversePairs(int [] arr) {
        aux = new int[arr.length];
        split(arr, 0, arr.length - 1);
        return cnt;
    }

    private void split(int[] arr, int head, int tail) {
        if (head < tail) {
            int mid = (head + tail) >> 1;
            split(arr, head, mid);
            split(arr, mid + 1, tail);
            mergeAndCount(arr, head, mid, tail);
        }
    }

    /**
     * [head, mid]有序，[mid + 1, tail]有序，归并的同时记录cnt
     * @param arr
     * @param head
     * @param mid
     * @param tail
     */
    private void mergeAndCount(int[] arr, int head, int mid, int tail) {
        for (int i = head; i <= tail; ++i) {
            aux[i] = arr[i];
        }
        int p1 = mid;  //左边数组的最后一个
        int p2 = tail; //右边数组的最后一个
        int p3 = tail; //整段的最后一个

        while (p1 >= head || p2 >= mid + 1) {
            if (p1 == head - 1) arr[p3--] = aux[p2--];   //左边加完了
            else if (p2 == mid) arr[p3--] = aux[p1--];   //右边加完了
            else if (aux[p1] > aux[p2]) {  //左边大
                //aux[p1]要跨越从mid+1到p2之间的数，装入原数组p3的位置
                //这一步产生的逆序对个数就是 [mid+1,p2]的长度
                cnt = cnt + p2 - mid;
                cnt = cnt % 1000000007;
                arr[p3--] = aux[p1--];
            } else {
                //右边大,正序
                arr[p3--] = aux[p2--];
            }

        }
        while (p1 >= head) arr[p3--] = aux[p1--];
        while (p2 >= (mid + 1)) arr[p3--] = aux[p2--];
    }

}
