package com.stan.data_structure.跳表;


import java.util.Random;

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
public class Skiplist {

    class Node {
        Integer val;
        Node left;
        Node right;
        Node up;
        Node down;

        public Node(int val) {
            this.val = val;
        }
        public Node() {
            this.val = null;
        }

    }

    private Node header;    //最上面那条链表的伪头
    private Node tailer;    //最上面那条链表的伪尾
    private Integer levels;

    static class RandomGenerator{

        private static Random random = new Random();

        public static boolean getRandomBoolean(float probability){
            return random.nextFloat() < probability;
        }
    }

    /**
     * 把target插入到source的后面
     * @param source
     * @param target
     */
    private static void insertNodeHorizon(Node source, Node target) {
        target.left = source;
        target.right = source.right;
        source.right.left = target;
        source.right = target;
    }

    /**
     * 把target放到source下面
     * @param source
     * @param target
     */
    private static void insertNodeVertical(Node source, Node target) {
        source.down = target;
        target.up = source;
    }

    /**
     * 比如某层是 1->3->5->7->9  要找8，
     *     下层是 .........7->8->9
     *
     * 第一次，发现9 > 8,curr = 7这个节点,  进入递归
     * 第二次，发现9> 8 ，curr = 8这个节点，但8.down = null ，不进入递归，结束
     *
     * 返回8这个节点
     *
     *
     * @param start
     * @param val
     * @return
     */
    private Node findNode(Node start, int val) {

        Node curr = start;
        while (curr.right.val != null && curr.right.val <= val) {
            curr = curr.right;
        }
        if (curr.down != null)
            return findNode(curr.down, val);
        else
            return curr;  //已经最底层，直接返回
    }

    /**
     * 新开一条链表，放最上面
     */
    private void createEmptyLevel() {

        Node newHeader = new Node();
        Node newTailer = new Node();

        newHeader.right = newTailer;
        newTailer.left = newHeader;

        //Create connections
        insertNodeVertical(newHeader,this.header);  //原来的header放在最新header下面
        insertNodeVertical(newTailer,this.tailer);  //原来的tailer放在最新tailer下面

        //Update head and tail
        this.header = newHeader;
        this.tailer = newTailer;

        ++ levels;
    }


    public Skiplist() {
        header = new Node();
        tailer = new Node();
        header.right = tailer;
        tailer.left = header;

        levels = 0;
    }

    /**
     * 值为val的Node是否存在
     * @param val
     * @return
     */
    public boolean search(int val) {

        Node res = findNode(header, val);
        if (res.val == null || res.val != val) return false;
        return true;

    }

    /**
     * 自底向上添加一个Node
     * 从最下层开始加，上面层要不要加看随机函数
     * @param val
     */
    public void add(int val) {

        Node searchRes = findNode(header, val);
        Node newNode = new Node(val);

        insertNodeHorizon(searchRes, newNode);  //插入最底层

        int level = 1;
        while (RandomGenerator.getRandomBoolean(0.5f)) {

            if (level > this.levels) createEmptyLevel();  //已经在最上面的链表，还要往上弄，就整一条新的

            while (searchRes.up == null) searchRes = searchRes.left;   //水平向左，找到一个能上去的

            searchRes = searchRes.up;

            Node duplicate = new Node(val);
            insertNodeHorizon(searchRes, duplicate);
            insertNodeVertical(duplicate, newNode);   //newNode放在dup下面

            newNode = duplicate;
            ++ level;
        }
    }

    /**
     * 自底向上删除节点
     * @param val
     * @return
     */
    public boolean erase(int val) {

        Node searchRes = findNode(header, val);
        if (searchRes.val == null || searchRes.val != val) return false;

        while (searchRes != null) {

            //水平方向上删掉
            searchRes.left.right = searchRes.right;
            searchRes.right.left = searchRes.left;
            //向上
            searchRes = searchRes.up;
        }
        return true;
    }
}
