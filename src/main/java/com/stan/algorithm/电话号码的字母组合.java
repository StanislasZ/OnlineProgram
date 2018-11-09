package com.stan.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合 {
    public static void main(String[] args){

        /*

            给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

            给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

            输入："23"
            输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
            说明:
            尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

         */
        String digits="23";
//        System.out.println("".length());
        System.out.println(letterCombinations(digits));
    }
    public static List<String> letterCombinations(String digits) {
        if (digits.equals("")) return new ArrayList<>();

        Map<Character,String> map =new HashMap<Character,String>(){
            {
                put('2',"abc");
                put('3',"def");
                put('4',"ghi");
                put('5',"jkl");
                put('6',"mno");
                put('7',"pqrs");
                put('8',"tuv");
                put('9',"wxyz");

            }
        };
        char[] arr=digits.toCharArray();
        List<String> rlt=new ArrayList<>();

        dfs(rlt,arr,map,"");


        return rlt;
    }

    public static void dfs(List<String> rlt,char[] arr,Map<Character,String> map,String temp){
        if(temp.length()==arr.length){
            rlt.add(temp);
            System.out.println("temp长度达到，加入rlt");
            System.out.println("rlt="+rlt);
            return;
        }


        int len_curr=temp.length();
        System.out.println("当前temp长度为"+len_curr);
        String res=map.get(arr[len_curr]);
        System.out.println("可增加的有:"+res);

        char[] res_arr=res.toCharArray();
        for(int i=0;i<res_arr.length;i++){

            temp=temp+res_arr[i];
            System.out.println("加了一个"+res_arr[i]+"，temp="+temp+",进入下一层");
            dfs(rlt,arr,map,temp);

            //go back
            temp=temp.substring(0,temp.length()-1);
            System.out.println("go back, now temp is "+temp);


        }







    }

}
