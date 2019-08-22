package com.stan.algorithom.utils;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtils {

    private static Random rand = new Random();

    //交换
    public static <T> void exch(T[] a, int i, int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //v是否小于w
    public static boolean less(Comparable v , Comparable w){
        return v.compareTo(w) < 0;
    }

    public static boolean more(Comparable v, Comparable w){
        return v.compareTo(w) > 0;
    }

    /**
     * 打乱一个数组
     * @param arr
     * @param <T>
     */
    public static <T> void shuffle(T[] arr) {
        int length = arr.length;
        for (int i = length; i > 0; i-- ){
            int randInd = rand.nextInt(i);
            exch(arr, randInd, i - 1);
        }
    }

    public static boolean isSorted(Comparable[] a){
        //测试数组元素是否有序
        for (int i = 1; i < a.length; i++) {
            if(less(a[i], a[i-1])) return false;
        }
        return true;
    }

    public static void printArray(Comparable[] a){
        //单行打印数组
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};
        shuffle(arr);
        System.out.println(Arrays.toString(arr));
    }

}
