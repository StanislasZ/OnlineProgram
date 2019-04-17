package com.stan.al.sort;


/**
 * 插入排序
 */
public class Insertion {


    //类似一张张拿牌
    //手上牌是全的，装作先拿了最左边那张，又拿了1张，总共2张，这2张排序，又拿了1张，总共3张，这3张排序……
    public static void sort(Comparable[] a){

        int N = a.length;
        for(int i = 1; i < a.length; i++){

//            for(int j = i; j > 0 && less(a[j], a[j-1]); j--){
//                exch(a, j, j-1);
//            }


            // 左边的数都是排好序的，新的数是最右边一个，这个数要是比左边的小就不断左移，一旦不比左边的小，这就是它最后的为止，不动了，break，
            // 效果同上
            /*
            for(int j = i; j > 0; j--){
                if(less(a[j], a[j-1])){
                    exch(a, j, j-1);
                }else{
                    break;
                }
            }
            */

            // 挪步法
            Comparable temp = a[i];  //备份
            int j = i - 1;
            for (; j >= 0 && a[j].compareTo(temp) > 0; j--){
                a[j+1] = a[j];
            }
            a[j+1] = temp;
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
