package example.collection2;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 之前讲解的Map的key值是不能重复的,例如HashMap的key值就不能重复，如果重复肯定覆盖之前的内容
 */
public class C16_MapRep {
	public static void main(String[] args) {
		C16_MapRep c16=new C16_MapRep();
		//
		c16.verificationRepeat();
		//
		c16.verificationRepeat2();
	}
	public void verificationRepeat(){
		System.out.println("**************如果Map的key值重复会怎么样***************");
		Map<C16_Person,String> map= new HashMap<C16_Person, String>();
//		String key[]={"张三","李四","王五"};
//		String value[]={"14","15","16"};		
//		map.put(key[1],value[1]);
//		map.put(key[1],value[2]);
//		System.out.println(map.get(key[1]));//结果为：16,可见重复的key覆盖之前的value	
		map.put(new C16_Person("张三",15),"zhangsan");
		map.put(new C16_Person("张三",15),"lisi");
		map.put(new C16_Person("李四",16),"lisi");
		
		Set<Map.Entry<C16_Person,String>> set=map.entrySet();
		for(Map.Entry<C16_Person, String> demo:set){
			System.out.println("key:"+demo.getKey()+"\t=>\tvalue:"+demo.getValue());
		}
		//从程序上看可以知道，第二个元素覆盖第一元素，所以此时如果使用IdentityHashMap,只要使用此类时只要地址不相等(key1!=key2)
		//就表示不是重复的key,这时就可以添加到集合中
	}
	
	public void verificationRepeat2(){
		System.out.println("************使用IdentityHashMap******************");
		Map<C16_Person, String> map=new IdentityHashMap<C16_Person, String>();//注意这里使用的是IdentityHashMap
		map.put(new C16_Person("张三",15),"zhangsan");
		map.put(new C16_Person("张三",15),"lisi");
		map.put(new C16_Person("李四",16),"lisi");
		Set<Map.Entry<C16_Person,String>> set=map.entrySet();
		for(Map.Entry<C16_Person, String> demo:set){
			System.out.println("key:"+demo.getKey()+"\t=>\tvalue:"+demo.getValue());
		}
	}
}


class C16_Person{
	private String name;
	private int age;
	
	public C16_Person(){};
	public C16_Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	

	public String toString() {
	
		return "name:"+this.name+",age:"+this.age;
	}
	

	public boolean equals(Object obj) {
		if(this==obj){
			return true;
		}
		if(!(obj instanceof C16_Person)){
			return false;
		}
		C16_Person person=(C16_Person)obj;
		if(this.getName().equals(person.getName())&&this.getAge()==person.getAge()){
			return true;
		}
		return false;
	}
	
	public int hashCode() {	
		return this.name.hashCode()*this.age;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}