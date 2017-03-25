package example.collection2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/**	List讲解
 * List是Collection的子接口，主要可保存各个重复的内容，定义如下
 * Public interface List<T> implements Collection<T>,拓展Collection
 */
/** ArrayList类
 *  ArrayList是List的子类，可以直接通过对象的多态性为list接口实例化，此类的定义如下：
 *  public class ArrayList<E> extends AbstractList<E> implements List<E> ,RandomAccess,Cloneable,Serializable
 */
public class C01_List01 {
	public static void main(String[] args) {
		C01_List01 c01=new C01_List01();
		c01.methodCollect();//常用方法集合
		c01.listTeach();//list教学

		
	}
	public void methodCollect(){
		System.out.println("********利用List的常用方法集合*************************");

//		List list2=new ArrayList();
//		Collection<Demo01> coll=null;	//实例化Collection对象
		List<String> list=new ArrayList<String>();	//实例化List对象
		String s1=" we ";
		String s2=" are ";
		String s3=" hero!";
		list.add(s1);//增加元素（对象）
		list.add(s3);
		System.out.println(list);
		list.add(1, s2);//在这指定位置添加元素
		System.out.println(list);
		System.out.println(list.get(1));//返回指定位置的元素
		System.out.println("list.indexOf(s3)返回:"+list.indexOf(s3));//取出指定元素的位置
		System.out.println("list.lastIndexOf(s3)返回:"+list.lastIndexOf(s3));//从后向前找到指定元素的位置（可见不是倒数位置，只是从后面开始检索）
		System.out.println("list.remove(s2)返回:"+list.remove(s2));//删除指定元素对象，并返回boolean值
		System.out.println(list);
		list.add(1, s2);//恢复数组
		System.out.println("list.remove(1)返回:"+list.remove(1));//删除指定位置的元素，但如果没有该位置则报错
		list.add(1, s2);//恢复数组
		List<String> listSon=list.subList(1, 2);//取出集合中的子集合,从指定位置到结束位置之间（包头不包尾）,当截取的元素不存在时报错
		System.out.println("list.subList(1, 2)方法后的子集："+listSon);
		System.out.println("list.set(0, \"They\")的返回值:"+list.set(0, "They"));//替换指定元素
		System.out.println(list);	
		
	}
	public void listTeach(){
		System.out.println("******************list教学方法*******************************");
		List<String> allList=null;  //定义List对象，List是接口
		Collection<String> collections=null;
		
		allList=new ArrayList<String>();	//实例化实体类
		collections=new ArrayList<String>();
		
		allList.add("hello");			//从collection继承的方法
		allList.add(0, "world");		//扩展的方法
		System.out.println("allList:\t"+allList);
		
		collections.add("LXH");
		collections.add("www.midn.com");
		System.out.println("collections:\t"+collections);
		
		allList.addAll(collections);	//从Collection继承的方法，增加一组对象
		allList.addAll(0,collections);	//此方法List自定义的，增加一组对象
		System.out.println("allList:\t"+allList);//输出对象，调用toString()方法	
	}
}

