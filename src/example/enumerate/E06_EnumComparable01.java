package example.enumerate;

import java.util.EnumMap;
import java.util.Map;

/**
 * 
 * <ul>
 * <li>文件名称: E06_EnumComparable01.java</li>
 * <li>功能描述: JDK1.5后提供两个新的集合操作类：EnumMap EnumSet</li>
 * </ul>
 */
public class E06_EnumComparable01 {

	public static void main(String[] args) {
		E06_EnumComparable01 e06=new E06_EnumComparable01();
		e06.valiadEnumMap();
	}
	
	/**
	 * 验证EnumMap
	 */
	public void valiadEnumMap(){
		Map<E06_Color1,String> desc=null;//定义一个Map对象
		
		desc=new EnumMap<E06_Color1, String>(E06_Color1.class);//实例化EnumMap
		
		desc.put(E06_Color1.RED, "红色");//加入一个内容
		desc.put(E06_Color1.GREEN, "绿色");//加入一个内容
		desc.put(E06_Color1.BLUE, "蓝色");//加入一个内容
		System.out.println("==== 输出全部的内容 ======");
		for(E06_Color1 c:E06_Color1.values()){//取得全部的枚举
			System.out.println(c.name()+"--->"+desc.get(c));
		}
		
		System.out.println("==== 输出全部的键值 =======");
		for(E06_Color1 c:desc.keySet()){
			System.out.print(c.name()+"、");
		}
		
		System.out.println();//换行
		System.out.println("===== 输出全部的内容=====");
		for(String s:desc.values()){
			System.out.print(s+"、");
		}
		System.out.println();
		
	}
	
	/***
	 * <li>验证EnumSet————将全部的集合设置到EnumSet</li>
	 * <li>EnumSet是Set的子类，所以内容是无法重复的，
	 * 使用EnumSet时不能直接使用关键字new为其进行实例化，所以在类中提供许多静态的方法</li>
	 */
	public void validEnumSet(){
		
	}
	
}

enum E06_Color1{
	RED,GREEN,BLUE;
}
