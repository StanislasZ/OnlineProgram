package com.stan.shine_task;

import java.io.*;

public class ReadCsv {

    public static void main(String[] args){
        try {
			File file = new File("D:\\zry\\guidang\\wuyou_jobs_20.csv");
			InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
			BufferedReader bf = new BufferedReader(inputReader);
			// 按行读取字符串
			String str;
			int count=0;
			while ((str = bf.readLine()) != null) {
				count++;
                System.out.println(str);

				if(count>100)break;
			}
			bf.close();
			inputReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
