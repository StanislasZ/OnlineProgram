package com.stan.nowcoder;

public class InsertTest1 {

    public static void main(String[] args){

        int[] arr = {4,7,1,9,5};
        //insertSort(arr, 0, arr.length - 1);
        quickSort(arr, 0, arr.length - 1);
        for (int ele: arr) {
            System.out.println(ele);
        }
    }



    public static void quickSort(int[] a, int head, int tail) {

        if (head >= tail) return;
        int p = partition(a, head, tail);
        quickSort(a, head, p - 1);
        quickSort(a, p + 1, tail);

    }


    public static int partition(int[] a, int head, int tail) {

        int sep = a[tail];
        int i = head;  //切分元素左侧的最大索引
        for (int j = head; j <= tail - 1; j++) {
            if (a[j] < sep) {
                exch(a, i++, j); //保证sep左边的都比它小
            }
        }
        exch(a, i, tail);
        return i;


    }


    public static void insertSort(int[] a, int head, int tail) {

        if (head >= tail) return;

        for (int i = head + 1; i <= tail; i++) {

            int temp = a[i];
            int j = i - 1;
            for (; j >= head && a[j] > temp; j--) {

                    a[j + 1] = a[j]; //挪步
            }
            a[j + 1] = temp;

        }


    }
    public static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

