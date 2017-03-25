package example.collection;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> l1=new LinkedList<String>();
//		List<String> l2=new LinkedList<String>();
		for(int i=0;i<=9;i++){
			l1.add("a"+i);
		}
		System.out.println("l1的集合"+l1);
		System.out.println("Collections.shuffle()随机排序");
		Collections.shuffle(l1);//随机排序
		System.out.println("经操作后l1的集合"+l1);
		System.out.println("Collections.reverse()逆序排序");
		Collections.reverse(l1);//逆序排序
		System.out.println("经操作后l1的集合"+l1);
		System.out.println("Collections.sort()排序");
		Collections.sort(l1);//排序
		System.out.println("经操作后l1的集合"+l1);
		System.out.println(Collections.binarySearch(l1, "a5"));
	}

}
