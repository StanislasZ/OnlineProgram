package com.stan.algorithom.utils;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtils {

    private static Random rand = new Random();

    public static <T> void swap(T[] a, int i, int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static <T> void shuffle(T[] arr) {
        int length = arr.length;
        for ( int i = length; i > 0; i-- ){
            int randInd = rand.nextInt(i);
            swap(arr, randInd, i - 1);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};
        shuffle(arr);
        System.out.println(Arrays.toString(arr));
    }

}
