package com.stan.data_structure;

import java.util.Map;
import java.util.TreeMap;


//下面是一些很好的问题，供您练习使用 Trie 数据结构。
//
//添加与搜索单词 - 一个 Trie 树的直接应用。
//单词搜索 II - 类似 Boggle 的游戏。



//前缀树
public class Trie {

    //私有内部节点类
    private class Node {


        boolean isEnd;   //比如insert一个"hello" 只有o的isEnd是true
        Map<Character, Node> next;

        public Node(boolean isWord) {
            this.isEnd = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;  //根节点


    public Trie() {
        root = new Node();
    }

    /**
     * 向Trie中添加单词
     *
     * 遍历单词，比如hello  先h， 在h.next 的字典中加入 e 。。。。
     *
     * 时间复杂度：O(m), m为要查询字符串的长度
     * 空间复杂度：O(m), 最坏情况下没有公共节点，需要添加 m 个节点
     * @param word
     */
    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        cur.isEnd = true;
    }

    /**
     * 判断单词是否在 Trie 中
     * 时间复杂度：O(m), m为要查询字符串的长度
     * 空间复杂度：O(1)
     * @param word
     * @return
     */
    public boolean search(String word) {

        Node cur = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) return false;
            cur = cur.next.get(c);
        }
        return cur.isEnd;
    }

    /**
     * 查询是否在Trie中有单词以preifx为前缀
     * 时间复杂度：O(m), m为要查询字符串的长度
     * 空间复杂度：O(1)
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {

        Node cur = root;
        for (int i = 0; i < prefix.length(); ++i) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) return false;
            cur = cur.next.get(c);
        }
        return true;

    }
}
