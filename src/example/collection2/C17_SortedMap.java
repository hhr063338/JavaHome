package example.collection2;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * SortedMap接口是排序接口，只要实现此接口的子类都属于排序的子类，比如TreeMap也是此接口的一个子类
 * 
 */
public class C17_SortedMap {
	public static void main(String[] args) {
		SortedMap<String, String> map=null;
		map=new TreeMap<String, String>();//实例化Sort接口对象
		map.put("A,张三", "zhangsan");//增加元素对象
		map.put("D,吴六", "wuliu");
		map.put("C,王五", "wangwu");
		map.put("B,李四", "lisi");
		//
		System.out.println("第一个元素内容的key值:"+map.firstKey());//firstKey()返回第一个元素的key值
		System.out.println("第一个元素内容的value值:"+map.get(map.firstKey()));
		System.out.println("最后一个元素内容的key值："+map.lastKey());
		System.out.println("最后一个元素内容的value值："+map.get(map.lastKey()));
		//
		System.out.println("*****返回小于指定范围的集合:(\"C,王五\")****");
		for(Map.Entry<String, String> demo:map.headMap("C,王五").entrySet()){
			System.out.println("key的值："+demo.getKey()+"\t=>\tvalue的值："+demo.getValue());
		}
		System.out.println("*****返回大于指定范围的集合:(\"B,李四\")****");
		for(Map.Entry<String, String> demo:map.tailMap("B,李四").entrySet()){
			System.out.println("key的值："+demo.getKey()+"\t=>\tvalue的值："+demo.getValue());
		}
		System.out.println("*****返回指定范围内的集合:(\"B,李四\"与\"D,吴六\"之间)****");
		for(Map.Entry<String, String> demo:map.subMap("B,李四", "D,吴六").entrySet()){
			System.out.println("key的值："+demo.getKey()+"\t=>\tvalue的值："+demo.getValue());
		}
		
		/**
		 * SortedMap接口规定了很多Map接口没有的方法，但是如果要操作以上的方法，则对象所在的类必须实现Comparable接口
		 */
				
	}
}
