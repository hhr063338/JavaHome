package example.collection2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/** Map接口的使用注意事项
 *  对Map接口来说,其本身不能直接使用迭代（如Iterator、foreach）进行输出的,因为Map中的每个位置存放的是一对值（key-value）
 *  而Iterator中每次只能找一个值，所以如果非要使用迭代进行输出，则必须完成以下步骤（以Iterator输出方法为例）
 *  1.将Map的实例通过entrySet()方法变为Set接口对象
 *  2.通过Set接口实例为Iterator实例化
 *  3.通过Iterator迭代输出,每个内容都是map.entry的对象
 *  4.通过Map.Entry进行key-value的分离
 *  注：Map.Entry是Map的内部类，存储Map的每对数据，支持方法：equals（Object）,getKey(),getValue,setValue(V),hashCode()
 **/

public class C14_MapNotice {

	public static void main(String[] args) {
		C14_MapNotice c14=new C14_MapNotice();
		//1.Map的输出方式之一：Iterator输出Map实例
		c14.mapInput1();
	}
	/**
	 * 1.Map的输出方式之一：Iterator输出Map实例
	 */
	public void mapInput1(){
		System.out.println("************ Map的输出方式之一：Iterator输出Map实例 *****************");
		Map<String,String> map=new HashMap<String, String>();
		addElement(map);
		Set<Map.Entry<String, String>> setMap=map.entrySet();
		Iterator<Entry<String, String>> iter=setMap.iterator();
		while(iter.hasNext()){
			Map.Entry<String, String> entry=iter.next();
			System.out.println("Map中\tkey:"+entry.getKey()+"\tvalue:"+entry.getValue());
			
		}
	}
	/**
	 * 2.Map的输出方式之二：foreach输出
	 * 	 既然可以用Iterator()接口进行输出，那么也可以使用foreach方法输出
	 */
	public void mapInput2(){
		System.out.println("************ 2.Map的输出方式之二：foreach输出 *****************");
		Map<String,String> map=new HashMap<String, String>();
		addElement(map);
		for(Map.Entry<String, String> me:map.entrySet()){
			System.out.println("Map中\tkey:"+me.getKey()+"\tvalue:"+me.getValue());
		}
		
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
