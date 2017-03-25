package example.collection2;

import java.util.ArrayList;
import java.util.List;

public class C02_List02 {


	public static void main(String[] args) {
	
		C02_List02 c02=new C02_List02();
		c02.deleteElement();
		c02.inputElement();
		c02.objToCollect();
		c02.otherCollectOperate();
	}
	/**
	 * 1.删除元素的操作
	 */
	public void deleteElement(){
		System.out.println("***********************删除元素的操作*********************************");
		List<String> allList=null;
		allList=new ArrayList<String>();
		
		allList.add("hello");
		allList.add(1, "welcome");
		System.out.println("第一次输出:"+allList);
		allList.add("to the");
		allList.add("world");
		System.out.println("第二次输出:"+allList);
//		int i=0;
//		for(String str_test:allList){
//			if("welcome".equals(str_test)){
//				allList.remove(str_test);
//			}
//			System.out.println(i++);
//		}
//		System.out.println(allList);
	
		allList.remove("hello");
		System.out.println("第三次输出"+allList);
		allList.remove(2);	//如果前面的元素删掉，后面元素的索引自动往前挪一位
		System.out.println("第四次输出"+allList);
		
	}
	/**
	 * 2.对List进行遍历
	 */
	public void inputElement(){
		System.out.println("=======================输出List中的所有内容=================================");
		List<String> allList=null;
		allList=new ArrayList<String>();
		
		allList.add("hello");
		allList.add(1, "welcome");

		allList.add("to the");
		allList.add("world");
		System.out.println("第一次输出:"+allList);
		
		//第一种
		System.out.println("第一种遍历方法，由前向后输出");
		for(String c:allList){
			System.out.println(c);
		}
	
		System.out.println("第二种遍历方法，由后向前输出");
		for(int i=0;i<allList.size();i++){
			System.out.println(allList.get(i));
//			allList.remove(i);
//			System.out.println(i);
			
		}
	}
	/**
	 * 3.将集合转换为对象数组
	 */
	public void objToCollect(){
		System.out.println("********************将集合转换为对象数组********************");
		List<String> allList=null;
		allList=new ArrayList<String>();		
		allList.add("hello");
		allList.add(1, "welcome");
		allList.add("to the");
		allList.add("world");
		System.out.println("指定数组类型");
		String[] str=allList.toArray(new String[] {});//将对象
		for(int i=0;i<str.length;i++){
			System.out.print(str[i]+" 、");
		}
		System.out.println("\n返回对象数组");
		Object obj[]=allList.toArray();
		for(int j=0;j<obj.length;j++){
			String temp=(String)obj[j];
			System.out.print(temp+"、");
		}
		System.out.println();
	}
	/**
	 * 4.集合的相关操作
	 *   在List中还存在截取集合、查找元素位置、判断元素是否存在、集合是否为空等操作
	 */
	public void otherCollectOperate(){
		System.out.println("==================集合的其它相关操作========================");
		List<String> listTest=null;
		listTest=new ArrayList<String>();
		System.out.println("listTest.isEmpty()是否为空?:"+listTest.isEmpty());
		
		listTest.add("welcome");
		listTest.add(1, "to");
		listTest.add("java");
		listTest.add("world!");
		System.out.println("listTest容器(listTest.contains)是否含有\"hello\":"+listTest.contains("hello"));
		//集合截取
		List<String> str2=listTest.subList(1, 2);
		for(int i=0;i<str2.size();i++){
			System.out.println(str2.get(i));
		}
		System.out.println("求指定的字符world串位置:"+listTest.indexOf("world!"));	
	}


	

}
