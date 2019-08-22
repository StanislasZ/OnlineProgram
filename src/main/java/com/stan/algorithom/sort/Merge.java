package com.stan.algorithom.sort;

import static com.stan.algorithom.utils.ArrayUtils.*;

public class Merge {

    private static Comparable[] aux;

    /**
     * 原地归并， 需要一个附加空间，占用和原数组一样的空间。
     * a[head,mid]有序， a[mid+1, tail]有序
     * @param a ： 被排序数组
     * @param head ： 头指针
     * @param mid ： 尾指针
     * @param tail
     */
    public static void merge(Comparable[] a, int head, int mid, int tail){

        int i = head;
        int j = mid + 1;
        //Comparable[] aux = new Comparable[tail - head + 1];
        for (int k = i; k <= tail; k++){
            aux[k] = a[k];
        }

        for (int k = i; k <= tail; k++){

            if (i > mid) a[k] = aux[j++];
            else if (j > tail) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];

        }

    }


    public static void sort(Comparable[] a){

        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    // 自顶向下
    // 最终会被拆成单个数的形式 ， 再合并起来
    private static void sort(Comparable[] a, int head, int tail){

        if (tail <= head) return;
        int mid = (head + tail) / 2;

        sort(a, head, mid);
        sort(a, mid+1, tail);
        merge(a, head, mid ,tail);

    }

    // 自底向上
    // 容易搞错的边界值： mid = left+span-1
    // 右索引要考虑数组长度不是刚好是2的n次放，所以要Math.min()
    public static void sort_from_bottom(Comparable[] a){
        aux = new Comparable[a.length];

        // 第一次span =1
        for (int span = 1; span <  a.length; span = span * 2){

            for (int left = 0; left < a.length - span; left = left + span*2){
                // span =1,内第一次排序[0,1]， 第二次排序[2,3]
                merge(a, left, left+span-1, Math.min(left + span*2 -1, a.length-1));
            }
        }
    }



    public static void main(String[] args){

        Integer[] a = new Integer[]{2,5,9,1,3,7};
        //sort(a);
        sort_from_bottom(a);
        assert isSorted(a);
        printArray(a);


    }
}
