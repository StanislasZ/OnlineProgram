package com.stan.algorithom.sort;

import static com.stan.algorithom.utils.ArrayUtils.*;

/**
 * 选择排序
 */
public class Selection {

    public static void sort(Comparable[] a){

        for (int i = 0; i < a.length - 1; i++) {
            int min_index = i;
            for (int j = i+1; j < a.length; j++) {

                if(less(a[j], a[min_index])){
                    min_index = j;
                }
            }
            exch(a, i, min_index);
        }
    }

    public static void main(String[] args){

        Integer[] a = new Integer[]{2,5,1,3};
        sort(a);
        assert isSorted(a);
        printArray(a);


    }


}
