package com.stan.al.sort;

import com.stan.al.utils.ArrayUtils;



public class Quick {


    public static void sort(Comparable[] a){

        ArrayUtils.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int head, int tail){

        if (head < tail){

            int sep_index = partition(a, head, tail);
            System.out.println("sep_index = "+sep_index);
            show(a);
            sort(a, head, sep_index-1);
            sort(a, sep_index+1, tail);

        }


    }


    public static void sort_3way(Comparable[] a, int head, int tail) {
        if (tail <= head) return;
        int small = head;
        int i = small + 1;
        int big = tail;
        Comparable sep = a[head];
        while (i <= big) {
            int cmp = a[i].compareTo(sep);
            if      (cmp < 0) exch(a, small++, i++);
            else if (cmp > 0) exch(a, i, big--);
            else              i++;
        }
        sort_3way(a, head, small - 1);
        sort_3way(a, big + 1, tail);

    }

    private static int partition(Comparable[] a, int head, int tail){

        //取初始“隔板”
        Comparable sep = a[tail];

        //定义隔板左侧的最大索引
        int left_max_index = head;
        for (int i = head; i < tail; i++){

            //如果当前元素小于隔板元素，隔板索引加1， 并把当前这个小于隔板的元素换到a[head+目前小于隔板元素的个数
            if (less(a[i], sep)){
                exch(a, i, left_max_index++);
            }
        }
        //当前left_max_index就是隔板最终的索引，把初始隔板交换过来
        exch(a, left_max_index, tail);
        return left_max_index;
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
        //sort(a);
        sort_3way(a, 0, a.length -1);
        assert isSorted(a);
        show(a);


    }


}
