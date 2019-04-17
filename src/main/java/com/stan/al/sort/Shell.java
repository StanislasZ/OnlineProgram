package com.stan.al.sort;

public class Shell {

    public static void sort(Comparable[] a){

        int N = a.length;
        int h = 1;
        while(h < N / 3){
            h = h * 3 + 1;
        }

        while(h >= 1) {
            for (int i = h; i < a.length; i++) {
                /*
                for (int j = i; j >= h && less(a[j], a[j-h]) ; j-=h) {
                    exch(a, j , j-h);
                }
                */

                // 挪步法, 效果同上
                Comparable temp = a[i]; //备份
                int j = i - h;
                for (; j >= 0 && a[j].compareTo(temp) >0; j -= h){
                    a[j + h] = a[j];
                }
                a[j + h] = temp;
            }
            h = h/3;
            //前几次h大，分成多个小的序列，每个序列元素较少，分别排序，形成了部分有序
            //最后一次h =1 ,就是插入排序，由于整个数组已经部分有序，这一次效率仍然较高。
        }



    }

    public static boolean less(Comparable v , Comparable w){
        return Selection.less(v, w);
    }

    //exchange
    public static void exch(Comparable[] a, int i, int j){
        Selection.exch(a, i, j);
    }

    public static void show(Comparable[] a){
        Selection.show(a);
    }

    public static boolean isSorted(Comparable[] a){
        return Selection.isSorted(a);
    }

    public static void main(String[] args){

        Integer[] a = new Integer[]{2,5,9,1,3,7};
        sort(a);
        assert isSorted(a);
        show(a);


    }
}
