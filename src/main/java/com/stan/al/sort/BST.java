package com.stan.al.sort;

import java.util.*;

public class BST<K extends Comparable<K>, V> {

    private Node<K,V> root;

    // 内部类：结点
    private class Node<K,V>{

        private K key;
        private V value;
        private Node<K,V> left, right;   // 左右子树的引用
        private int N;

        public Node(K key, V value, int N){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.N = N;
        }
    }

    // 返回bst的大小(结点数)
    public int size(){
        return size(root);
    }
    private int size(Node<K,V> x){
        if (x == null) return 0;
        else           return x.N;
    }

    // get：获取指定键对应的值
    public V get(K key){
        return get(root, key);
    }
    private V get(Node<K,V> x, K key){

        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        if (cmp > 0) return get(x.right, key);

        //key相同
        return x.value;
    }

    // put: 若指定键存在，更新值； 若不存在，则添加一个新的Node
    public void put(K key, V value){
        root = put(root, key, value);
    }
    private Node<K,V> put(Node<K,V> x, K key, V value){

        if (x == null) return new Node<K,V>(key, value, 1);  //1就是0（左子树为0）+0（右子树为0）+自己

        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;   //若key相同，则更新

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }


    // 找到最小键
    public K min(){
        return min(root).key;
    }
    private Node<K,V> min(Node<K,V> x){

        if (x.left == null) return x;
        return min(x.left);
    }
    //找到最大键
    public K max(){
        return max(root).key;
    }
    private Node<K,V> max(Node<K,V> x){

        if(x.right == null) return x;
        return max(x.right);

    }

    // 向下取整
    public K floor(K key){
        Node<K,V> x = floor(root, key);
        return x == null? null : x.key;
    }
    private Node<K,V> floor(Node<K,V> x, K key){

        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);

        // cmp > 0 的情况， 比x.key大，所以在右子树中找，进入递归
        Node<K,V> temp = floor(x.right, key);   //在右子树中找floor

        if (temp != null) return temp;  //若找到了，直接返回
        return x;   //else ,找不到，返回x

    }

    // 返回指定排名的键
    public K select(int k){
        return select(root, k).key;
    }
    private Node<K,V> select(Node<K,V> x, int k){

        if (x == null) return null;
        int left_size = size(x.left);
        if (k < left_size) return select(x.left, k);
        else if (k > left_size) return select(x.right, k - left_size - 1); //在右子树
        else return x;



    }




    // 删除最小键
    public void deleteMin(){
        root = deleteMin(root);
    }
    private Node<K,V> deleteMin(Node<K,V> x){
        //能运行到这里，x肯定不等于null， 左子树为空，就是删自己，即 让右儿子代替自己
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }


    // 删除指定键 ！！ 重要！！
    public void delete(K key){
        root = delete(root, key);
    }
    private Node<K,V> delete(Node<K,V> x, K key){

        if (x == null) return null;
        //x != null
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);    //比当前x.key小，递归去左子树找
        else if (cmp > 0) x.right = delete(x.right, key);  //比当前x.key大，递归去右子树找
        else{
            //命中！！！
            if (x.left  == null) return x.right;
            if (x.right == null) return x.left;

            //同时存在左子树和右子树
            //为了维护二叉树的性质，一个结点的左子树要比它小，右子树要比他大
            //所以在右子树中找到一个最小的结点来代替被删除的结点

            Node<K,V> temp = x;
            x = min(temp.right);  //x变成右子树中最小的结点, 这个结点要代替被删除的结点，所以下一步是设置它的右儿子和左儿子
            x.right = deleteMin(temp.right);
            x.left = temp.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    // 返回所有键
    public Iterable<K> keys(){
        return keys(min(), max());
    }
    public Iterable<K> keys(K left, K right){

        Queue<K> queue = new LinkedList<>();
        keys(root ,queue, left, right);
        return queue;
    }

    // 中序遍历key----递归写法
    private void keys(Node<K,V> x, Queue<K> queue, K left, K right){

        if (x == null) return;
        int cmp_left = left.compareTo(x.key);
        int cmp_right = right.compareTo(x.key);

        if (cmp_left < 0) keys(x.left, queue, left, right);
        //当前值在[left,right]内，则打印
        if (cmp_left <= 0 && cmp_right >= 0) queue.add(x.key);
        if (cmp_right > 0) keys(x.right, queue, left, right);

        // 若要返回全部Key, 上面3个if是全部满足的
    }


    // 先序遍历key----循环写法 ，这里简单点，直接遍历所有的key
    private void keys_preorder_loop(Node<K,V> x, Queue<K> queue) {

        if (x == null) return;
        Stack<Node<K,V>> stack = new Stack<>();
        while (x != null || !stack.empty()) {
            if (x != null) {
                queue.add(x.key);  //先打印根的key
                stack.push(x.right); //存储右儿子
                x = x.left;      //指向左儿子
            }else {
                x = stack.pop();
            }
        }
    }
    // 中序遍历key----循环写法 ，这里简单点，直接遍历所有的key
    private void keys_inorder_loop(Node<K,V> x, Queue<K> queue) {

        if (x == null) return;
        Stack<Node<K,V>> stack = new Stack<>();
        while (x != null || !stack.empty()) {

            if (x != null) {
                stack.push(x);   //沿着左测，一路到底，并入栈
                x = x.left;
            }
            else {
                Node<K,V> temp = stack.pop();  //栈顶是最深最left的结点

                queue.add(temp.key);  //打印该结点

                x = temp.right;   //指向右侧
            }
        }
    }
    // 后序遍历key----循环写法 ，这里简单点，直接遍历所有的key
    // 转化为根->右->左， 然后reverse
    private void keys_postorder_loop(Node<K,V> x, Queue<K> queue) {

        if (x == null) return;
        Stack<Node<K,V>> stack = new Stack<>();
        while (x != null || !stack.empty()) {

            if (x != null) {
                queue.add(x.key);
                stack.push(x.left);
                x = x.right;
            }
            else {
                x = stack.pop();
            }
        }
        //反转queue
        //TODO
    }





    // 层次遍历键
    public List<K> levelOrder(){
        return levelOrder(root);
    }
    //一开始想到优先队列，这里queue插入的顺序就是按照结点深度，退化成普通队列即可。
    private List<K> levelOrder(Node<K,V> x){

        List<K> list = new ArrayList<>();
        Queue<Node<K,V>> queue = new LinkedList<>();
        queue.add(x);
        while (!queue.isEmpty()){
            Node<K,V> head = queue.poll();
            list.add(head.key);
            if (head.left  != null) queue.add(head.left);
            if (head.right != null) queue.add(head.right);
        }
        return list;
    }

    // 获得树的深度，根到最下面那个结点的数量（包括根和这个结点）
    public int depth(){
        return depth(root);
    }
    private int depth(Node<K,V> x){
        if (x == null) return 0;
        return Math.max(1 + depth(x.left), 1 + depth(x.right));
    }


    public static void main(String[] args) {

        BST<Integer, Integer> bst = new BST<>();
        bst.put(5, 5);
        bst.put(3, 3);
        bst.put(9, 9);
        bst.put(1, 1);
        bst.put(7, 7);
        bst.put(4, 4);

        Iterator<Integer> iterator = bst.keys(2,8).iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("---");
        List<Integer> l2 = bst.levelOrder();
        for (int i=0;i<l2.size();i++){
            System.out.println(l2.get(i));
        }

        System.out.println("depth is "+ bst.depth());

    }




}
