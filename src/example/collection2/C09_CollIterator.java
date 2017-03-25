/**
 * 
 */
package example.collection2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**双向迭代输出：ListIterator
 * Iterator接口的主要功能是由前向后的单向输出，而此时如果想实现由后向前或是由前向后的双向输出，则必须使用Iterator的子接口ListIterator
 * 与Iterator不同的是Listiterator接口只能通过List接口实例化，即只能输出List接口的内容
 */
/**ListIterator接口的定义与常用方法
 * public interface ListIterator<E> extends Iterator<E>,除了Iterator接口中的方法，新增：
 * public void add(); 将指定元素增加集合
 * public boolean hasPrevious(); 判断是否有上一个元素
 * public E previous();取出当前元素
 * public int nextIndex();返回下一个元素的索引
 * public int previous();返回上一个元素的索引
 * public void set;替换元素
 * 
 */

public class C09_CollIterator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		C09_CollIterator c09=new C09_CollIterator();
		// 1.进行双向迭代
		c09.inputListIterator();
		//2.增加及替换元素
		c09.setAndAdd();

	}
	/** 1.进行双向迭代
	 * 由后向前输出时必须先由前向后输出
	 */
	public void inputListIterator(){
		System.out.println("*************研究双向迭代*********************");
		List<String> all=new ArrayList<String>();
		all.add("hello");
		all.add("_");
		all.add("world");
		ListIterator<String> iter=all.listIterator();//实例化ListIterator
		System.out.println("**由前向后输出:");
		while(iter.hasNext()){
			System.out.print(iter.next()+"、");
		}
		System.out.println("\n**由后向前输出:");
		while(iter.hasPrevious()){//先判断上一个元素是否存在
			System.out.print(iter.previous()+"、");
		}
	}

	/** 2.增加及替换元素
	 * 	  使用add()或set()方法可以增加或替换元素，但这样的操作在开发中是不建议使用的
	 */
	public void setAndAdd(){
		System.out.println("*************2.增加及替换元素*********************");
		List<String> all=new ArrayList<String>();
		all.add("hello");
		all.add("_");
		all.add("world");
		ListIterator<String> iter=all.listIterator();//实例化ListIterator
		System.out.println("**由前向后输出:");
		while(iter.hasNext()){
			String str=iter.next();
			System.out.print(str+"、");
			iter.set("LI-"+str);//替换元素
		}
		System.out.println("\n**由后向前输出:");
		iter.add("LXH");//增加元素
		while(iter.hasPrevious()){//先判断上一个元素是否存在
			String str=iter.previous();
			System.out.print(str+"、");
		}
	}
	
	
}
