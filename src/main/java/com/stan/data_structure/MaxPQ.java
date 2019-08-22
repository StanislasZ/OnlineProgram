package com.stan.data_structure;


/**
 * 优先队列（维护最大值）的简单实现
 */
public class MaxPQ<T extends Comparable<T>> {

    private T[] pq;
    private int N = 0;

    //指定容量
    public MaxPQ(int maxN) {
        pq = (T[])new Comparable[maxN];
    }

    public void insert(T t) {
        //扩容
        if (N == pq.length) resize(2 * pq.length);
        pq[N++] = t;
        swim(N - 1);
    }
    public T max() {
        return pq[0];
    }
    public T delMax() {
        T max = pq[0];
        exch(0, --N);
        pq[N] = null;  //防止内存溢出
        sink(0);
        //缩减
        if (N > 0 && N == pq.length / 4) resize(pq.length / 2);
        return max;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }

    //上浮（插入较大的新元素时），不用管同级的
    private void swim(int k) {
        while (k > 0 && less(parent(k), k)) {
            exch(parent(k), k);
            k = parent(k);
        }
    }

    //下沉（数组顶端被换成了数组最后一个元素），需要把这个较小的元素逐级下沉
    private void sink(int k) {

        int l_c = left(k);
        int r_c = right(k);
        int max_i = k;
        if (l_c < N && more(l_c, max_i)) max_i = l_c;
        if (r_c < N && more(r_c, max_i)) max_i = r_c;
        if (max_i != k) {
            exch(k, max_i);
            sink(max_i);
        }


    }

    //重新分配数组空间，并拷贝
    private void resize(int newLen) {
        T[] tmp = (T[]) new Comparable[newLen];
        for (int i = 0; i < N; ++i)
            tmp[i] = pq[i];
        pq = tmp;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }
    private boolean more(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void exch(int i, int j) {
        T tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    private int parent(int i){
        return (i - 1) / 2;
    }
    private int left(int i){
        return 2 * i + 1;
    }
    private int right(int i){
        return 2 * i + 2;
    }

    //打印内部数组，调试
    public void print() {
        for (int i = 0; i < N; ++i)
            System.out.print(pq[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        MaxPQ<Integer> maxPQ = new MaxPQ<>(8);
        maxPQ.insert(4);
        maxPQ.print();
        maxPQ.insert(5);
        maxPQ.print();
        maxPQ.insert(3);
        maxPQ.print();
        maxPQ.delMax();
        maxPQ.print();
        maxPQ.insert(1);
        maxPQ.print();
        maxPQ.insert(9);
        maxPQ.print();

    }
}
