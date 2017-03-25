package example.collection2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**Collection类的使用与意义
 *在集合的应用开发中，集合的若干个接口和子类是最常用的，但是在JDK中提供了一种集合操作的工具类-Collections
 *可以直接通过此类方便地操作集合
*/
/** Collections类的定义
 * 	public class Collections extend Object;
 */
/**Collections类常用的方法及类型
 * public static final List EMPTY_LIST;返回空的List集合
 * public static final Map EMPTY_MAP;返回空的Map集合
 * public static final Set EMPTY_SET;返回空的Set集合
 * public static <T extends Object & Comparable<? super T>> T max(Collection < ? extends T> coll);找到最大的内容，按比较器排序
 * 
 */
public class C18_Collections {

	public static void main(String[] args) {
		C18_Collections c18=new C18_Collections();
		//实例1：返回不可变的集合
		c18.fixedCollection();
		//实例2：为集合增加内容
		c18.verificationAddAll();
		//实例3：反转集合中的内容
		c18.testReverse();
		//实例4：检索内容
		c18.testBinarySearch();
		//实例5：替换集合中的内容
		c18.testReplace();
		//实例6.集合排序
		c18.testSort();
		//实例7：交换指定位置的内容
		c18.testSwap();
	}
	
	/*
	 * 虽然Collections类可以
	 */
	
	/**
	 * 实例1：返回不可变的集合
	 * 虽然Collections类可以返回Set/Map/List子类，但是这种方式返回的对象是无法增加数据的
	 * 因为在这些操作中并没有实现add()方法
	 */
	public void fixedCollection(){
		System.out.println("**********实例1：返回不可变的集合***************");
		List<String> list= Collections.EMPTY_LIST;
		try{
			list.add("wu");
		}catch (Exception e) {
			System.out.println("出现异常");
			System.out.println(e.getMessage());
			
		}
	}
	
	/**
	 * 实例2：为集合增加内容
	 * 使用addAll()方法可以为一个集合增加内容。此方法可以接收可变参数,所以可以传递任意多的参数作为集合的内容
	 */
	public void verificationAddAll(){
		System.out.println("********** 实例2：为集合增加内容***************");
		List<String> list=new ArrayList<String>();
		Collections.addAll(list, "wang","zhang","san");//注意其注释方法
		Iterator<String> iter=list.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
	/**
	 * 实例3：反转集合中的内容
	 * 直接使用Collections工具类中的reverse()方法即可将集合类中的内容反转保存
	 */
	public void testReverse(){
		System.out.println("********** 实例3：反转集合中的内容***************");
		List<String> list=new ArrayList<String>();
		Collections.addAll(list, "wang","zhang","san");//注意其注释方法
		Collections.reverse(list);//内容反转保存
		Iterator<String> iter=list.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
	}
	/**
	 * 实例4：检索内容
	 * 直接使用Collections工具类中的binarySearch()方法即可以完成内容的检索,检索之后返回内容的位置
	 */
	public void testBinarySearch(){
		System.out.println("********** 实例:4：检索内容***************");
		List<String> list=new ArrayList<String>();
		Collections.addAll(list, "wang","zhang","san");
		int point=Collections.binarySearch(list, "wang");
		System.out.println("当检索结果存在,返回检索位置:"+point);
		point=Collections.binarySearch(list, "li");
		System.out.println("当检索结果不存在,返回值"+point);

		
	}
	/**
	 * 5.替换集合中的内容
	 * Collections类提供replaceAll()方法，可以替换一个集合中的指定内容
	 */
	public void testReplace(){
		System.out.println("********* 实例5：替换集合中的内容*******************");
		List<String> all=new ArrayList<String>();
		Collections.addAll(all, "张三","李四","王五");
		System.out.println(all);
		if(Collections.replaceAll(all, "李四", "吴六")){
			System.out.println("替换内容成功");;
		}
		System.out.println(all);
	}
	
	/**
	 * 6.实例六：集合排序
	 * 可通过Collections类中的sort()方法对一个集合进行排序操作，但是要求集合中的每个对象所在的类必须实现Comparable接口
	 * 否则会出现类型转换异常
	 */
	public void testSort(){
		System.out.println("********** 实例六：集合排序 ***********************");
		//String 是实现Comparable接口的类
		List<String> all=new ArrayList<String>();
		Collections.addAll(all, "3:张三","6:吴六","4:李四");
		System.out.println("未排序："+all);
		Collections.sort(all);
		System.out.println("排序后"+all);
	}
	/**
	 * 7.实例7：交换指定位置的内容
	 * 直接使用swap()方法可以把集合中两个位置的内容进行交换
	 */
	public void testSwap(){
		System.out.println("********** 实例7：交换指定位置的内容  ***********************");
		//String 是实现Comparable接口的类
		List<String> all=new ArrayList<String>();
		Collections.addAll(all, "3:张三","6:吴六","4:李四");
		System.out.println("未交换前："+all);
		Collections.swap(all,0,1);//将集合中的第一元素与第二元素位置调换
		System.out.println("交换后"+all);
	}
}
