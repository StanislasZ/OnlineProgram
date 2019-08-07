package com.stan.algorithom.sort;


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


    public static boolean less(Comparable v , Comparable w){
        return v.compareTo(w) < 0;
    }

    //exchange
    public static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void show(Comparable[] a){
        //单行打印数组
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a){
        //测试数组元素是否有序
        for (int i = 1; i < a.length; i++) {
            if(less(a[i], a[i-1])) return false;
        }
        return true;
    }

    public static void main(String[] args){

        Integer[] a = new Integer[]{2,5,1,3};
        sort(a);
        assert isSorted(a);
        show(a);


    }


}
