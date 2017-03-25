package example.collection2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 注意事项二：直接使用非系统类作为key
 * 会出现什么状况
 * 如何通过匿名对象查找对应的value
 */
public class C15_MapNotice {
	public static void main(String[] args) {
		C15_MapNotice c15=new C15_MapNotice();
		//1.String->Person
		c15.strAndPer();
		//2.Person->String
		c15.perAndStr();
		//3.Person->String
		c15.perAndStr2();
		//4.Person->String
		c15.perAndStr3();
	}
	/**
	 * String->Person的映射
	 *
	 */
	public void strAndPer(){
		System.out.println("************* String->Person的映射 String指向隐匿对象Person*****************");
		Map<String,C15_Person1> map=new HashMap<String, C15_Person1>();
		map.put("zhangsan", new C15_Person1("张三","18"));
		map.put("lisi", new C15_Person1("李四","19"));
		System.out.println(map.get("zhangsan"));
			
	}
	/**
	 * Person -> String
	 *
	 */
	public void perAndStr(){
		System.out.println("************* Person->String 隐匿对象指向显示变量 的映射 *****************");
		Map<C15_Person1,String> map=new HashMap<C15_Person1,String>();
		map.put( new C15_Person1("张三","18"),"zhangsan");
		map.put( new C15_Person1("李四","19"),"lisi");
		System.out.println(map.get(new C15_Person1("张三","18")));
	}
	/**
	 * perAndStr()与perAndStr2()的区别在于，前者使用Person的匿名对象进行操作的，而现在是使用Person的实例化对象
	 * 地址没有变化，所以可以找到
	 */
	public void perAndStr2(){
		System.out.println("************* Person->String 隐匿对象指向显示变量 的映射 *****************");
		Map<C15_Person1,String> map=new HashMap<C15_Person1,String>();
		C15_Person1 per1=new C15_Person1("张三","18");
		C15_Person1 per2= new C15_Person1("李四","19");
		map.put( per1,"zhangsan");
		map.put(  per2,"lisi");
		System.out.println(map.get(per1));
	}
	/**
	 * 用户在操作时不可能明确知道其中的引用地址，所以要像String那样通过匿名对象找到对应的value,要想实现这样的功能，
	 * 就得靠Object类和hashCode（）和equals（）的帮助，以便区分是否是同一个对象
	 *
	 */
	public void perAndStr3(){
		System.out.println("************* Person->String 隐匿对象指向显示变量 的映射 *****************");
		Map<C15_Person2,String> map=new HashMap<C15_Person2,String>();
		map.put( new C15_Person2("张三","18"),"zhangsan");
		map.put( new C15_Person2("李四","19"),"lisi");
		System.out.println(map.get(new C15_Person2("张三","18")));
	}
	
	
	

}

//
class C15_Person1{
	private String name;
	private String age;

	C15_Person1(){};
	C15_Person1(String name,String age){
		this.name=name;
		this.age=age;
	}
	public String toString() {	
		return "name:"+name+",age:"+age;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

//
class C15_Person2{
	private String name;
	private String age;
	
	//区别：
	public boolean equals(Object obj) {
		if(this==obj){
			return true;
		}
		if (! (obj instanceof C15_Person2)) {
			return false;
		}
		C15_Person2 c15=(C15_Person2)obj;
		if(c15.getName().equals(this.getName())&&c15.getAge().equals(this.getAge())){
			return true;
		}
		return false;
	}
	
	C15_Person2(String name,String age){
		this.name=name;
		this.age=age;
	}
	public int hashCode(){
		return this.getAge().hashCode()*this.getName().hashCode();
	}
	
	public String toString() {	
		return "name:"+name+",age:"+age;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}