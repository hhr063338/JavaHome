package example.collection2;

import java.util.Enumeration;
import java.util.Vector;

/** 废弃的接口：Enumeration
 * 	JDK1.5推出，是最早的迭代输出的接口，最早使用的Vector时，就是用Enumeration接口进行输出的
 *  public interface Enumeration<E>
 *  Vector实例Enumeration的方法定义：
 *  public Enumeration<E> elements();
 */
/** Enumeration接口中的常用方法:
 * 	public boolean hasMoreElement();判断是否有下一个值
 * 	public E nextElement();取出当前元素
 * 
 */

public class C11_Enumeration {
	public static void main(String[] args) {
		//使用Enumeration输出
		System.out.println("******使用Enumeration输出*********");
		Vector<String> all=new Vector<String>();
		all.add("hello");
		all.add("_");
		all.add("world");
		Enumeration<String> iter=all.elements();
		while(iter.hasMoreElements()){
			System.out.print(iter.nextElement()+",");
		}
		System.out.println();
	}
	/**
	 * 在旧的操作系统中依然会使用Enumeration接口，所以需要掌握其操作
	 */
	

}
