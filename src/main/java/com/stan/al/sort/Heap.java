package com.stan.al.sort;


import com.stan.al.utils.ArrayUtils;

/**
 * 堆排序
 */
public class Heap {

    public static void sort(Comparable[] a){

        sort(a, 0, a.length - 1);
    }


    // 每次维护，根节点就是最大的，与遍历时的i交换，也就是每次把最大的放后面，heapSize--
    private static void sort(Comparable[] a, int head, int tail){

       int heapSize = build_max_heap(a);  //已经维护了一次

        // 因为最后要和a[heapSize-1]交换，所以i从a.length-1开始
        for (int i = a.length - 1; i > 0; i--){
            exch(a, 0, i);
            max_heapify(a, 0, --heapSize);
        }
    }


    //建堆
    //就是从下到上维护一遍
    private static int build_max_heap(Comparable[] a){

        int heapSize = a.length;

        //i的初始值取heapSize/2 -1， 因为这个大于索引的没有儿子，无需再搞
        for (int i = heapSize/2 -1; i>=0; i--){
            max_heapify(a, i, heapSize);
        }
        return heapSize;
    }



    /**
     * 维护最大堆， i的左儿子和右儿子已经是最大堆，i如果比较小，就逐级下沉
     * @param a ： 堆
     * @param i ： 以i为父节点的树要符合最大堆性质
     * @Param heapSize
     */
    private static void max_heapify(Comparable[] a, int i, int heapSize){

        int left_child_index = left(i);
        int right_child_index = right(i);
        int max_index = i;

        if (left_child_index < heapSize && more(a[left_child_index], a[i])){
            max_index = left_child_index;
        }
        if (right_child_index < heapSize && more(a[right_child_index], a[max_index])){
            max_index = right_child_index;
        }
        if (max_index != i){
            exch(a, max_index, i);  //下沉到某个儿子节点
            max_heapify(a, max_index, heapSize);  //把这个儿子节点作为树的根结点，递归调用
        }
    }

    private static int parent(int i){
        return (i-1)/2;
    }
    private static int left(int i){
        return 2*i+1;
    }
    private static int right(int i){
        return 2*i+2;
    }




    public static boolean less(Comparable v , Comparable w){
        return Selection.less(v, w);
    }

    private static boolean more(Comparable v, Comparable w){
        return v.compareTo(w) > 0;
    }

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
