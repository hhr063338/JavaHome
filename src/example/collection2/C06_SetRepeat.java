package example.collection2;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * C05_Set的例子并不是真正意义上的去掉重复元素，因为它靠的是Comparable完成的
 * 换成HashSet则会出现重复的内容，想要真正意义上的去掉重复元素，则必须深入探究Object类
 */
public class C06_SetRepeat {
/**
 * 想要让Set接口像其规定那样不允许重复元素的，则首先要进行对象是否重复的判断，而要进行这样的判读，
 * 必须覆写Object类中的equals()方法，才能完成对象是否相等，但只覆写equals()方法是不够的还需要
 * 覆写hashCode()方法，此方法表示一个哈希编码，可以简单地理解为表示一个对象的编码。
 * 一般的哈希码是通过公式进行计算的，可以将类中的全部的属性进行适当的计算，以求出不会重复的哈希码
 */
	public static void main(String[] args) {
		System.out.println("==============去掉重复对象=================");
		Set<C06_Person> set=new HashSet<C06_Person>();
		set.add(new C06_Person("张三", 18));
		set.add(new C06_Person("李四", 17));
		set.add(new C06_Person("王五", 21));
		set.add(new C06_Person("张三", 20));//只重名
		set.add(new C06_Person("吴六", 18));//只重龄
		set.add(new C06_Person("张三", 18));//重名重龄(共6个对象)
		System.out.println(set);
		//集合中的重复内容消失了，就是因为equals和hashCode方法的共同作用
	}
	//范例：去掉重复元素

}

class C06_Person{
	private String name;
	private int age;
	public C06_Person(){
		
	}
	public  C06_Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString(){
		return "姓名:"+name+";年龄:"+age;
	}

	public boolean equals(Object obj) {	//覆写equals()方法
		if(this==obj){	//假设地址相同是同一个对象
			return true;
		}
		if(!(obj instanceof C06_Person)){	//传递进来的不是本来对象就不是同个对象，探讨obj是Object类还是对象实质
			return false;		
		}
		C06_Person person=(C06_Person)obj;
		if(this.name.equals(person.name)&&this.age==person.age){
			return true;
		}else{
			return false;
		}
	}

	public int hashCode() {	//覆写hashCode()方法
		// TODO Auto-generated method stub
		return super.hashCode();//指定编码公式
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}