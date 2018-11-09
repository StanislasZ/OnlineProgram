package com.stan.algorithm;

import java.util.HashMap;
import java.util.Map;

public class 整数转罗马数字 {
    public static void main(String[] args){

        /*

            罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

            字符          数值
            I             1
            V             5
            X             10
            L             50
            C             100
            D             500
            M             1000

            例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

            通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
            数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
            同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

            I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
            X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
            C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。

            给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。

            示例 1:

            输入: 3
            输出: "III"
            示例 2:

            输入: 4
            输出: "IV"
            示例 3:

            输入: 9
            输出: "IX"
            示例 4:

            输入: 58
            输出: "LVIII"
            解释: L = 50, V = 5, III = 3.
            示例 5:

            输入: 1994
            输出: "MCMXCIV"
            解释: M = 1000, CM = 900, XC = 90, IV = 4

         */

        int num=58;
        String rlt=intToRoman(num);
        System.out.println(rlt);





    }
    public static String intToRoman(int num) {

        Map<Integer, String> map = new HashMap<Integer, String>() {
            {
                put(1,"I");
                put(5,"V");
                put(10,"X");
                put(50,"L");
                put(100,"C");
                put(500,"D");
                put(1000,"M");
            }
        };
        int[] key={1,5,10,50,100,500,1000};
        String rlt="";

        while(num!=0){
            int chushu=0;
            for (int i=key.length-1;i>=0;i--){
                int shang=num/key[i];
                for(int j=0;j<shang;j++){
                    rlt=rlt+map.get(key[i]);
                }
                int remaining=num-key[i]*shang;
                if(key[i]==1000){
                    if(remaining>=900){
                        rlt=rlt+"CM";
                        remaining=remaining-900;
                    }
                }else if (key[i]==500){
                    if(remaining>=400){
                        rlt=rlt+"CD";
                        remaining=remaining-400;
                    }
                }else if (key[i]==100){
                    if(remaining>=90){
                        rlt=rlt+"XC";
                        remaining=remaining-90;
                    }
                }else if (key[i]==50){
                    if(remaining>=40){
                        rlt=rlt+"XL";
                        remaining=remaining-40;
                    }
                }else if (key[i]==10){
                    if(remaining>=9){
                        rlt=rlt+"IX";
                        remaining=remaining-9;
                    }
                }else if (key[i]==5){
                    if(remaining>=4){
                        rlt=rlt+"IV";
                        remaining=remaining-4;
                    }
                }





                num=remaining;


            }





        }


        return rlt;
    }

    private static boolean isRemainingSpecial(int remaining) {

        return true;
    }



}
