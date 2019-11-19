package com.stan.leetcode;

import java.util.*;

public class _127单词接龙 {

    /*
        给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

        每次转换只能改变一个字母。
        转换过程中的中间单词必须是字典中的单词。
        说明:

        如果不存在这样的转换序列，返回 0。
        所有单词具有相同的长度。
        所有单词只由小写字母组成。
        字典中不存在重复的单词。
        你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
        示例 1:

        输入:
        beginWord = "hit",
        endWord = "cog",
        wordList = ["hot","dot","dog","lot","log","cog"]

        输出: 5

        解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
             返回它的长度 5。
        示例 2:

        输入:
        beginWord = "hit"
        endWord = "cog"
        wordList = ["hot","dot","dog","lot","log"]

        输出: 0

        解释: endWord "cog" 不在字典中，所以无法进行转换。

     */

    public static void main(String[] args) {

        String beginWord = "cog";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

        System.out.println(new _127单词接龙().ladderLength(beginWord, endWord, wordList));


    }

    /**
     * 递归 <100ms
     * bfs -> 双端bfs -> 临近点查找方式
     *
     *
     *
     * start = [hit],       end = [cog],        dict = [lot, log, dot, cog, hot, dog]
     * start = [hot],       end = [cog],        dict = [lot, log, dot, cog, hot, dog]
     * start = [lot, dot],  end = [cog],        dict = [lot, log, dot, cog, dog]
     * start = [cog],       end = [lot, dot],   dict = [lot, log, dot, cog, dog]
     * start = [log, dog],  end = [lot, dot],   dict = [lot, log, dot, dog]
     *
     *
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> from = new HashSet<>();
        Set<String> to   = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);

        from.add(beginWord);
        to.add(endWord);

        if (!dict.contains(endWord)) return 0;
        return bfs(from, to, dict, 2);
    }

    public int bfs(Set<String> from, Set<String> to, Set<String> dict, int cnt) {

        //递归终点
        if (from.isEmpty()) return 0;   //断裂了，找不到
        if (from.size() > to.size()) return bfs(to, from, dict, cnt);  //从少的去找多的，不然类似于邻接表太大

        dict.removeAll(from);  //对应 队列写法中 节点用过的要标记vis = true 就不能再用了

        Set<String> next_layer = new HashSet<>();

        for (String s : from) {
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; ++i) {
                char curr = arr[i];
                for (char c = 'a'; c <= 'z'; ++ c) {
                    if (curr == c) continue;
                    arr[i] = c;
                    String newWord = new String(arr);

                    if (dict.contains(newWord)) {
                        if (to.contains(newWord)) return cnt;
                        next_layer.add(newWord);
                    }
                }
                arr[i] = curr;  //改回去
            }
        }
        return bfs(next_layer, to, dict, cnt + 1);
    }


    /**
     * bfs的优先队列写法,500ms
     *
     * 上面的递归写法，可以很自如地在 搜索过程中 转换 from 和 to , 即转换搜索方向
     *
     * 这里用队列，暂时没想到怎么转换方向，肯定比较复杂
     *
     *
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        boolean[] vis = new boolean[wordList.size()];
        PriorityQueue<MyNode> pq = new PriorityQueue<>(Comparator.comparingInt(MyNode::getStep));
        pq.add(new MyNode(1, beginWord));
        while (!pq.isEmpty()) {
            MyNode curr = pq.poll();
            for (int i = 0; i < wordList.size(); ++i) {
                if (!vis[i] && diff(curr.str, wordList.get(i)) == 1) {
                    if (wordList.get(i).equals(endWord)) return curr.step + 1;
                    pq.add(new MyNode(curr.step + 1, wordList.get(i)));
                    vis[i] = true;
                }
            }
        }
        return 0;
    }

    private int diff(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i)) ++ cnt;
        }
        return cnt;
    }

}

class MyNode {
    int step;
    String str;
    public MyNode(int step, String str) {
        this.step = step;
        this.str = str;
    }

    public int getStep() {
        return step;
    }
}
