package example.jar;

import java.util.Arrays;

public class J12_KnowArray {
	/**
	 * Arrays是数组的操作类，主要功能是实现数组元素的查找、数组内容的填充、排序等
	 */
	public static void main(String[] args) {
		int temp[]={3,5,7,9,1,2,4,6,8};//声明一个整型数组
		char[] ctemp={'a','c','b','5','1','d'};
		Arrays.sort(temp);//数组排序
		Arrays.sort(ctemp);
		System.out.println("整数排序后:"+Arrays.toString(temp));//以字符串的形式输出数组
		System.out.println("字符排序后:"+Arrays.toString(ctemp));
		int point3=Arrays.binarySearch(temp, 3);//检索数据位置
		int cpoint3=Arrays.binarySearch(ctemp,'b');
		System.out.println("检索整数数组3的位置:"+point3);
		System.out.println("检索字符数组b的位置:"+cpoint3);
		Arrays.fill(temp, 10);
		Arrays.sort(temp);
		System.out.println("填充后"+Arrays.toString(temp));//fill填充是覆盖原有数据的填充
	}
	


	
}
