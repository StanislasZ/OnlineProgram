package com.stan.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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




    }

    /**
     * 递归
     * bfs -> 双端bfs -> 临近点查找方式
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (wordList == null || wordList.size() == 0) return 0;
        //起点
        Set<String> start = new HashSet<>();
        //终点
        Set<String> end = new HashSet<>();
        //方法参数 list -> hashset
        Set<String> dict = new HashSet<>(wordList);
        start.add(beginWord);
        end.add(endWord);
        if (! dict.contains(endWord)) return 0;
        return bfs(start, end, dict, 2);
    }

    public int bfs(Set<String> start, Set<String> end, Set<String> dict, int cnt) {
        //双端查找，若任意一段出现断裂，则不存在
        if (start.size() == 0) return 0;
        //优化：用少的去找多的
        if (start.size() > end.size()) return bfs(end, start, dict, cnt);

        //bfs标记行为：只能用一次
        dict.removeAll(start);
        //收集下一层临近点
        Set<String> next = new HashSet<>();
        for (String s : start) {
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; ++i) {
                char tmp = arr[i];
                //变化
                for (char c = 'a'; c <= 'z'; ++c) {
                    if (tmp == c) continue;
                    arr[i] = c;
                    String next_str = new String(arr);
                    if (dict.contains(next_str)) {
                        if (end.contains(next_str)) return cnt;
                        else next.add(next_str);
                    }
                }
                //复原
                arr[i] = tmp;
            }
        }
        return bfs(next, end, dict, cnt + 1);
    }
}
