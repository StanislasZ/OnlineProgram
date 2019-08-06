package com.stan.公司笔试;
import java.util.*;

public class Tengxun1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String[] str = s.nextLine().split(" ");
		int money = Integer.parseInt(str[0]);
		int nums = Integer.parseInt(str[1]);
		// ����Ӳ����ֵ���飬���Դ�����е�Ӳ����ֵ
		Integer[] coinValues = new Integer[nums];
		for(int i = 0; i < nums; i++) {
			coinValues[i] = Integer.parseInt(s.nextLine());
		}
		// ��Ӳ����ֵ�����ɴ�С����
		Arrays.sort(coinValues, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
			
		});
		System.out.println(Arrays.toString(coinValues));
		// ʹ�ú������õ����ٵ�Ӳ��ʹ����
		int res =minCoin(money, nums, coinValues);
		System.out.println(res);

	}

	private static int minCoin(int money, int nums, Integer[] coinValues) {
		// �õ����ٵ�Ӳ������
		/*����Ҫʹ�����ٵ�Ӳ������ϳ�һԪ��������ֵ֮���������ֵ,�������û��һԪӲ�ҿ϶����з��ظ�һ,
		 *����ÿ��һ����ֵ�����ж�ʱ������Ҫ��Ŀǰʹ�õ�Ӳ������ܹ���ϳɶ����ֵ�������ǰ��ֵС����������ֵ���Ͳ�������Ӳ�ң�������������ֵ��
		 *���������������ֵ��Ӳ����ƴ�ճ������ֵ���������ܱ�֤Ӳ��ʹ������С */
		
		// Ŀǰʹ�õ�Ӳ������ɵ������ֵ 
		int maxValue = 0;
		// ����һ����СΪ������ֵ��һ��������ÿ������ֵ���õ�����Ӳ������
		int[] minValues = new int[money+1];
		minValues[0] = 0;
		// Ӳ�ҵ�����
		int count = 0;
		// ���Ӳ�ҵ���ֵ��û��һ,�ǾͲ�����
		if (coinValues[nums-1] != 1) {
			return -1;
		}
		// ��Ҫ����ֵ����������ֵ������һ��
		for (int i = 1; i <= money; i++) {
			// �����ǰ��ֵҪС��Ŀǰʹ��Ӳ���ܱ��������ֵ,��ô�������ֱ��ʹ����һ����ֵ��Ӳ������
			if (i <= maxValue) {
				minValues[i] = minValues[i-1];
			}
			else {
				// ѡ���ܱ�ﵱǰ��ֵ�����Ӳ����ֵ
				for (int j = 0; j < nums; j++) {
					// �ҵ���һ��С�ڵ��ڵ�ǰ��ֵ����
					if (coinValues[j] <= i) {
						count++;
						maxValue += coinValues[j];
						break;
					}
				}
				minValues[i] = count;
			}
			
			
		}
		return minValues[money];
	}

}
