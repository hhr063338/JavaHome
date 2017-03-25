package example.collection2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/** 集合常见的四种输出方式
 * 之前的Collection、Set集合中的内容都可以通过将其转换为对象数组输出，而使用List则可用get()输出，但这些都不是集合的标准输出
 * Iterator：迭代输出，是使用最多的输出方式
 * ListIterator:是Iterator的子接口，专门用于输出List中的内容
 * Enumeration：是一个旧的接口，功能与Iterator类似
 * foreach：JDK1.5提供的新功能，可以 输出数组或集合
 * 
 */
/**迭代输出
 * 所谓的迭代输出就是将元素一个一个进行判断，判断其是否有内容，如果有内容则把内容取出
 * Iterator接口常用的方法定义：
 * public boolean hasNext():判断是否有下一个值
 * public E next():取出当前元素
 * public void remove():移除当前元素
 * 
 */
public class C08_CollIterator {
	public static void main(String[] args) {
		C08_CollIterator c08=new C08_CollIterator();
		//1.输出Collection中的全部内容(标准输出方式)
		c08.inputList();
		//2.删除元素
		c08.deleteElement();
		//3.迭代输出时删除元素的注意点
		c08.errorDeleteElement();
		//4.使用foreach方法输出集合
		c08.inputMethod();
	}
	/**
	 * 1.输出Collection中的全部内容(标准输出方式)
	 */
	public void inputList(){
		System.out.println("============关于集合类的标准输出方式=================");
		//因为Collection定义的iterator()方法为接口Iterator实例化
		List<String> all=new ArrayList<String>();
		all.add("hello");
		all.add("_");
		all.add("world");
		Iterator<String> iter=all.iterator();//实例化
		while(iter.hasNext()){
			System.out.print(iter.next()+"  ");
		}
		System.out.println();
		
	}
	
	/** 2.删除元素
	 * 
	 */
	public void deleteElement(){
		System.out.println("============关于集合类的删除元素=================");
		List<String> all=new ArrayList<String>();
		all.add("hello");
		all.add("_");
		all.add("world");
		Iterator<String> iter=all.iterator();//实例化
		while(iter.hasNext()){
			String element=iter.next();
			if("_".equals(element)){
				iter.remove();
			}else{
				System.out.print(element+" 、 ");
			}
		}
		System.out.println();
		System.out.println("现在集合的长度:"+all.size());//可见Iterator删除元素会影响到集合对象中
		
	}

	/** 3.迭代输出时删除元素的注意点
	 * 正常情况下，一个集合要把内容交给Iterator输出，但是集合操作中也存在一个remove()方法，如果在使用Iterator
	 * 输出时集合自己调用了删除方法，则会出现运行时的错误
	 */
	public void errorDeleteElement(){
		System.out.println("============迭代输出时删除元素的注意点=================");
		List<String> all=new ArrayList<String>();
		all.add("hello");
		all.add("_");
		all.add("world");
		Iterator<String> iter=all.iterator();//实例化
		while(iter.hasNext()){
			String element=iter.next();
			if("_".equals(element)){
				all.remove(element);//通过list删除当前元素
			
			}else{
				System.out.print(element+" 、 ");
			}
		}
		System.out.println("\n删除之后的集合"+all);
		/*
		 * 从程序的运行结果中可以发现,内容确实被删除，但是迭代输出在内容删除之后就终止了
		 * 因为集合本身的内容被破坏掉，所以迭代出现错误，会停止错误
		 */
//		System.out.println("现在集合的长度:"+all.size());//可见Iterator删除元素会影响到集合对象中
		
	}
	/**	4.使用foreach方法输出集合
	 * 	  虽然foreach输出的功能强大，而且操作代码比较简单，但从实际开发来讲，还是建议Iterator接口完成输出功能
	 */
	public void inputMethod(){
		System.out.println("**********4.使用foreach方法输出集合**************");
		List<String> all=new ArrayList<String>();
		all.add("hello");
		all.add("_");
		all.add("world");
		for(String s:all){
			System.out.print(s+",");
		}
		System.out.println();
	}
}
