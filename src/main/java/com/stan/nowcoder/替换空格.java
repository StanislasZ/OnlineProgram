package com.stan.nowcoder;

public class 替换空格 {
    public String replaceSpace(StringBuffer str) {

        /*
            StringBuffer的方法：
                insert(int offset, 各种类型)
                setCharAt(int index, char ch)
        */


        int spacenum = 0;//spacenum为计算空格数
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' ')
                spacenum++;
        }
        int indexold = str.length()-1; //indexold为为替换前的str下标
        int newlength = str.length() + spacenum*2;//计算空格转换成%20之后的str长度
        int indexnew = newlength-1;//indexold为为把空格替换为%20后的str下标
        str.setLength(newlength);//使str的长度扩大到转换成%20之后的长度,防止下标越界

        while (indexold < indexnew) {
            if(str.charAt(indexold) == ' '){  //
                str.setCharAt(indexnew--, '0');
                str.setCharAt(indexnew--, '2');
                str.setCharAt(indexnew--, '%');
            }else{
                str.setCharAt(indexnew--, str.charAt(indexold));
            }
            indexold--;
        }
        return str.toString();



    }
}
