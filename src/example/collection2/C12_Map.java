package example.collection2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;

/** Map接口
 *	Collection、List、Set接口都属于单值操作，即每一次只能操作一个对象，而Map每次操作的是一对对象，即二元偶对象，
 *	Map中的每个元素都使用key-value的形式存储在集合中
 */
/**	Map接口的定义与常用方法
 * 	public interface Map<K,V>
 * 	public void clear();清空map集合
 * 	public Set<Map.Entry<K,V>> entrySet();将Map对象变为Set集合
 * 	public Set<K> keySet();取得所有的key
 * 	public void putAll(Map<? extends K,? extends V> t);将一个Map集合中的内容加入到另一个Map
 *  public Collection<V> values();取出全部的的value 
 */
/** Map接口常用子类：
 *  HashMap:无序存放，key不允许重复，是新的操作类
 *  HashTable：无序存放，key不允许重复，是旧的操作类
 *  TreeMap：可以排序，按集合中的key值排序，key不允许有重复
 *  WeakHashMap：弱引用的Map集合，当集合中的某些内容不再使用时清除掉无用的数据，使用gc进行回收
 *  IdentityHashMap:key可以重复的Map集合
 * 
 */
public class C12_Map {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		C12_Map c12=new C12_Map();
		//1.增加和取得内容
		c12.addAndGet();
		//2.判断指定的内容（key或value）是否存在
		c12.decodeMap();
		//3.输出全部的key值
		c12.inputKeys();
		//4.输出全部的value
		c12.inputValues();
		//5.Hashtable类的使用
		c12.inputAll();
		//6.TreeMap类的使用
		c12.sortTree();
		//7.探讨弱引用类WeakHashMap
		c12.testWeakHashMap();

	}
	/**
	 * 1.增加和取得内容
	 */
	public void addAndGet(){
		System.out.println("**********1.增加和取得内容******************");
		Map<String,String> map= new HashMap<String, String>();
		String[] ip={"Ip:121.11.149.156","Ip:61.135.169.125","Ip:58.241.250.40"};
		map.put(ip[0], "www.qiqidu.com");//增加元素
		map.put(ip[1], "www.baidu.com");
		map.put(ip[2],  "www.qidian.com");
		System.out.println("根据key求出value:"+map.get(ip[1]));
		
	}
	/**
	 * 2.判断指定的内容（key或value）是否存在
	 */
	public void decodeMap(){
		System.out.println("**********2.判断指定的内容（key或value）是否存在*****************");
		Map<String,String> map=new HashMap<String, String>();
		String[] ip={"Ip:121.11.149.156","Ip:61.135.169.125","Ip:58.241.250.40"};
		String[] value={"www.qiqidu.com","www.baidu.com","www.qidian.com"};
		map.put(ip[0], value[0]);//增加元素
		map.put(ip[1], value[1]);
		map.put(ip[2], value[2]);
		//查找指定的key是否存在，存在则输出对应的value
		if(map.containsKey(ip[2])){
			System.out.println("指定key值存在，对应的value:"+map.get(ip[2]));
		}else{
			System.out.println("指定的key值不存在");
		}
		//查找指定的value是否存在，存在则输出对应的key
		if(map.containsValue(value[2])){
			//取得value[2]对应的key值方法?
			System.out.println("指定的value(\'"+value[2]+"\')的值存在");
		}else{
			System.out.println("指定的value值不存在");
		}
	}
	/**
	 * 3.输出全部的key值
	 */
	public void inputKeys(){
		System.out.println("**********3.输出全部的key值*****************");
		Map<String,String> map=new HashMap<String, String>();
		addElement(map);
		Set<String> sets=map.keySet();
		System.out.print("所有的key值:\t");
		for(String s:sets){
			System.out.print(s+";\t");
		}
		
	}
	
	/** 4.输出全部的value
	 *    如果要输出全部的value，则使用values()方法，此方法返回类型是Collection，在进行操作时也同样需要注意泛型的类型
	 */
	public void inputValues(){
		System.out.println("\n**********4.输出全部的value*****************");
		Map<String,String> map=new HashMap<String, String>();
		addElement(map);
		//因为返回的是Collection类型
		System.out.print("所有的value值:\t");
		Collection<String> values=map.values();
		Iterator<String> iter=values.iterator();
		while(iter.hasNext()){
			System.out.print(iter.next()+"\t");
		}
	}
	/** 5.Hashtable的使用
	 * 	  在使用上与Hashmap没有什么差别，与Vector类推出的时间一样，都属于旧的操作类
	 * 	  HashMap采用异步处理方式，性能更高，属于线程非安全的操作类
	 * 	  Hashtable采用同步处理，性能较低，属于线程安全的操作类
	 * 	  从实际开发来看，HashMap类使用较多，读者应该重点掌握
	 * 
	 */
	public void inputAll(){
		System.out.println("\n******5.Hashtable的使用******");
		Map<String,String> map=new Hashtable<String,String>();
		addElement(map);
		Set<String> coll1=map.keySet();
		Iterator<String> iter=coll1.iterator();
		System.out.println("所有的key值：\t");
		while(iter.hasNext()){
			System.out.print(iter.next()+"\t");
		}
		Collection<String> coll2=map.values();
		System.out.println("\n所有的value值:\t");
		for(String s2:coll2){
			System.out.print(s2+"\t");
		}
		
	}
	
	/**
	 * 6.排序的子类:TreeMap
	 * 	 观察之前的Map输出可以发现其是无序的，TreeMap子类是按key排序
	 * 	注意：使用自定义类作为key时需要实现Comparable接口，否则将出现类转换异常
	 */
	public void sortTree(){
		System.out.println("\n**********6.排序的子类:TreeMap,看输出的顺序**********************");
		Map<String, String> map=new TreeMap<String, String>();
		addElement(map);//添加元素
		Set<String> keys=map.keySet();
		Iterator<String> iter=keys.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
	}
	/**
	 * 7.弱引用类:WeakHashMap
	 *   之前讲解的都是强引用类，即集合里的内容不管是否使用都始终保存在集合中，
	 *   如果希望集合自动清理暂时不用的数据就使用WeakHashMap类，当进行垃圾收集时会自动释放掉集合中的垃圾信息
	 */
	public void testWeakHashMap(){
		System.out.println("**********7.弱引用类:WeakHashMap**********************");
		Map<String, String> map=new WeakHashMap<String, String>();
//		addElement(map);
		map.put(new String("key0001"), new String("value0001"));
		map.put(new String("key0002"), new String("value0002"));
		map.put(new String("key0003"), new String("value0003"));
		System.gc();//进行垃圾收集器
		map.put(new String("key0004"), new String("value0004"));
		System.out.println("剩下的内容："+map);//一般只会剩下一个内容
		//为什么使用map.put("key0003", "value0003")的赋值方式就没有什么效果
		//system.gc();清理的是什么样的数据
		
	}
	/**
	 *  param：Map
	 *  function：添加元素
	 *  return:Map
	 */
	public Map<String,String> addElement(Map<String,String> map){
		String[] ip={"Ip:61.135.169.125","Ip:121.11.149.156","Ip:58.241.250.40"};
		String[] value={"www.baidu.com","www.qiqidu.com","www.qidian.com"};
		map.put(ip[0], value[0]);//增加元素
		map.put(ip[1], value[1]);
		map.put(ip[2], value[2]);

		return map;
	}

}
