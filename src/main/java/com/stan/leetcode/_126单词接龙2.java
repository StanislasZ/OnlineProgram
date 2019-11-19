package com.stan.leetcode;

import java.util.*;

public class _126单词接龙2 {

    /**
     * 真的太难了。。
     */


    List<List<String>> res = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();


    public  List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        if(wordList == null) return res;
        //bfs搜索所用的字典
        Set<String> dicts = new HashSet<>(wordList);
        if(!dicts.contains(endWord)) return res;
        if(dicts.contains(beginWord)) dicts.remove(beginWord);
        //bfs搜索最短路径所用的开始和结束的字典
        Set<String> endList = new HashSet<>(),
                beginList = new HashSet<>();


        beginList.add(beginWord);
        endList.add(endWord);
        bfs(map, beginList, endList, dicts, false);

        //dfs的前进路线保存list
        List<String> subList = new ArrayList<>();
        subList.add(beginWord);
        dfs(subList, beginWord, endWord);
        return res;
    }


    /**
     * bfs完成了邻接map的数据填充
     *
     *
     * @param subList
     * @param beginWord
     * @param endWord
     */
    private void dfs(List<String> subList, String beginWord, String endWord) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(subList));
            return;
        }
        if (!map.containsKey(beginWord)) return;

        for (String word : map.get(beginWord)) {
            subList.add(word);
            dfs(subList, word, endWord);
            subList.remove(subList.size() - 1);
        }
    }

    /**
     * 因为需要在最后直到每个方案的具体路径，这里需要辅助变量reverse
     * @param map
     * @param from
     * @param to
     * @param wordList
     * @param reverse
     */
    private void bfs(Map<String, List<String>> map, Set<String> from, Set<String> to, Set<String> wordList, boolean reverse){

        if(from.size() == 0) return;

        if (from.size() > to.size()) {
            bfs(map, to, from, wordList, !reverse);   //改变搜索的方向
            return;
        }

        wordList.removeAll(from);
        boolean finish = false;
        Set<String> temp = new HashSet<>();
        for(String str : from){
            char[] arr = str.toCharArray();
            for (int i = 0; i < arr.length; i++){
                char old = arr[i];
                for(char c = 'a'; c <= 'z'; ++ c){
                    if(c == old) continue;
                    arr[i] = c;
                    String newstr = new String(arr);

                    if (!wordList.contains(newstr)) continue;  //不属于中间形态

                    //若是在某一层找到了最后的节点，就直接标记找到了，即一票决定。这里因为要找所有的最短路径，所以循环还是要继续的。
                    if (to.contains(newstr)) finish = true;
                    else temp.add(newstr);    //这个else无所谓写不写，只有继续搜索下一层才需要temp

                    //无论怎么变换方向，永远用开始方向的字符做key，是为了后面的dfs，单一方向搜索
                    String key = reverse? newstr : str;
                    String value = reverse? str : newstr;

                    if (!map.containsKey(key)) map.put(key, new ArrayList<>());
                    map.get(key).add(value);   //因为最后begin->.....->end 有方向，所以就一句
                    //不能写  map.get(value).add(key);
                }
                arr[i] = old;  //改回去
            }
        }
        //如果找到了，下一层肯定是不需要继续的
        if (!finish) bfs(map, temp, to, wordList, reverse);

    }
}
