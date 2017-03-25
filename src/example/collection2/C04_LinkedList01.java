package example.collection2;

import java.util.LinkedList;

/**LinkedList与Queue接口
 * LinkedList表示的是一个链表的操作类，
 * 从类的定义上看，此类不仅实现了List接口，还实现了Queue接口
 * Queue接口表示队列操作接口，采用FIFO(先进先出)的方式操作
 */
/**LinkedList的定义
 *  public class LinkedList<E> extends AbstractSequentiaList<E> implements List<E>,Queue<E>,Clonable,Serializable
 */
public class C04_LinkedList01 {

	public static void main(String[] args) {
		C04_LinkedList01 c04=new C04_LinkedList01();
		c04.addData();
		c04.deleteElement();
		c04.listFIFO();
	}
	
	/**
	 * 
	 */
	String s1=" who ";
	String s2=" are ";
	String s3=" you ";
	
	/**
	 * 2.在链表的开头和结尾增加数据
	 * 为了达到操作链表的目的，直接使用LinkedList类
	 */
	public void addData(){
		System.out.println("==================在链表的开头和结尾增加数据======================");
		LinkedList<String> list=new LinkedList<String>();

		list.add(s1);//向链表中添加数据
		list.add(s2);
		list.add(s3);
		System.out.println("初始化链表:"+list);//输出链表内容，调用toString()
		list.addFirst(s3);//在链表的表头添加数据
		list.addLast(s1);//在链表的表尾添加数据
		System.out.println("增加头和尾之后的链表"+list);
		
	}
	/**
	 * 3.找到表头
	 * public E element();找到表头
	 * public E peek();找到不删除表头
	 * public E poll;找到并删除表头
	 */
	public void deleteElement(){
		System.out.println("====================找到表头=============================");
		LinkedList<String> link=new LinkedList<String>();
		link.add(s1);
		link.add(s2);
		link.add(s3);
		System.out.println("1.使用link.element()方法找到表头，返回值:"+link.element());
		System.out.println("1-2.找完之后的内容:"+link);
		System.out.println("2.使用link.peek()方法找到表头，返回值:"+link.peek());
		System.out.println("2-2.找完之后的内容:"+link);
		System.out.println("3.使用link.poll()方法找到表头，返回值:"+link.poll());
		System.out.println("3-2.找完之后的内容:"+link);
	}
	/**
	 * 4.以先进先出的方式去取出全部的数据
	 * 在LinkedList类中存在poll()方法，通过循环操作，就可以把内容全部取出（FIFO方式）
	 */
	public void listFIFO(){
		System.out.println("***************以先进先出的方式去取出全部的数据******************");
		LinkedList<String> link=new LinkedList<String>();
		link.add(s1);
		link.add(s2);
		link.add(s3);
		System.out.println("初始集合:"+link+"\t包含元素:");
//		System.out.println(link.size());
		for(int i=0;i<3;i++){	//link.size()的长度在这里充当判断条件，没执行一次循环，它的值都会产生变化
			System.out.println(link+"\t"+link.poll());
//			System.out.print("\t"+link.poll());
		}
	}


}
