package com.stan.algorithm;

public class Z字形变换 {

    public static void main(String[] args){

        String str="PAYPALISHIRING";
        System.out.println("str's length is "+str.length());
        int numRows = 3;
        String result=convert2(str,numRows);
        System.out.println(result);


    }








    /**
     * 只需遍历一次目标字符串，仍使用row_index和row_step
     * @param s
     * @param numRows
     * @return
     */
    public static String convert2(String s, int numRows) {
        if(numRows==1) return s;
        String[] sb=new String[numRows];
        for(int i=0;i<sb.length;i++){
            sb[i]="";
        }


        int row_index=0;
        int row_step=1;

        for(int i=0;i<s.length();i++){
            if(row_index==numRows-1){  //碰到下面
                row_step=-1;
                }else if(row_index==0&&i!=0){  //碰到上面
                row_step=1;

            }
            System.out.println("row_index="+row_index);
            sb[row_index]+=s.charAt(i);
            row_index+=row_step;

        }
        String result="";
        for(String ele:sb){
            System.out.println(ele);
            result=result+ele;
        }


        return result;
    }






    /**
     * 垃圾方法
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if(numRows==1) return s;

        char[][] z=new char[numRows][s.length()];

        int row_index=0;
        int column_index=0;
        int row_step=1;
        int column_step=0;

        int s_index=0;
        //boolean isDown=true;

        while(s_index<s.length()){
            if(row_index==numRows-1){  //碰到下面
                row_step=-1;
                column_step=1;
            }else if(row_index==0&&s_index!=0){  //碰到上面
                row_step=1;
                column_step=0;
            }
            System.out.println("row_index="+row_index+"  ,  column_index="+column_index);
            z[row_index][column_index]=s.charAt(s_index);
            row_index+=row_step;
            column_index+=column_step;
            s_index++;



        }

        StringBuffer sb=new StringBuffer();





        for(int i=0;i<z.length;i++){
            for(int j=0;j<z[i].length;j++){
                if(z[i][j]=='\0'){
                    System.out.print(" ");
                }else {
                    System.out.print(z[i][j]);
                    sb.append(z[i][j]);
                }
            }
            System.out.println();
        }





        return sb.toString();
    }


}
