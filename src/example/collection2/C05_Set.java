package example.collection2;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;



/**
 * Set接口也是Collection的子接口，不同于List接口，Set接口中不能加入重复的元素
 * public interface Set<E> extends Collection<E>
 * Set的方法主要与Collection接口的方法一样，而且也没有像List可以双向输出
 * Set接口常用的子类：HashSet
 */
public class C05_Set {

	public static void main(String[] args) {
		C05_Set c5=new C05_Set();
		//1.验证HashSet
		c5.checkHashSet();
		//2.验证TreeSet
		c5.checkTreeSet();
		//3.验证TreeSet的排序规则
		c5.checkTreeSetSort();
		
	}


	/**
	 * 1.HashSet子类的主要特定：是不能存放重复元素，而且采用散列的存储方式，所以没有顺序
	 */
	public void checkHashSet(){
		System.out.println("************1.验证HashSet类*******************");
		Set<String> set=new HashSet<String>();
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");
		set.add("E");
		set.add("F");//添加A~F
		set.add("D");//添加重复元素"D"
		System.out.println("初始化HashSet："+set);//无顺序排放,无重复
		
	}
	
	/** 2.TreeSet
	 * 如果想对输入的数据进行有序排列，则要使用TreeSet
	 * public class TreeSet<E> extends AbstractSet<E> implements Set<E>,Clonable,Serializable
	 * public class AbstractSet<E> extends AbstractCollection<E> implements Set<E>
	 */
	public void checkTreeSet(){
		System.out.println("************2.验证TreeSet类*******************");
		Set<String> set=new TreeSet<String>();
		set.add("A");
		set.add("B");
		set.add("F");
		set.add("D");
		set.add("C");
		set.add("E");//添加A~F
		set.add("D");//添加重复元素"D"
		System.out.println("TreeSet初始化："+set);
	}
	/**
	 * 3.探讨TreeSet的排序原理，假设对我们添加的自定义对象进行排序了,再看一次TreeSet实现的接口或继承的类
	 */
	public void checkTreeSetSort(){
		System.out.println("==============3.验证TreeSet类的排序原理=================");
		Set<C05_Person> set=new TreeSet<C05_Person>();
		set.add(new C05_Person("张三", 18));
		set.add(new C05_Person("李四", 17));
		set.add(new C05_Person("王五", 21));
		set.add(new C05_Person("张三", 20));//只重名
		set.add(new C05_Person("吴六", 18));//只重龄
		set.add(new C05_Person("张三", 18));//重名重龄
		System.out.println(set);
		//排序规则只对年龄排序，所以年龄重复的去掉，重名不用去掉
		//这是因为比较器操作时如果某个属性没有进行比较的指定，则也会认为是同一个对象
		//加入对象不是想Comparable接口，会报下面的错误
		//Exception in thread "main" java.lang.ClassCastException: sample.collection.C05_Person cannot be cast to java.lang.Comparable
	}
}

class C05_Person implements Comparable<C05_Person>{	//定义C05_Person类实现Comparable接口
	private String name;
	private int age;
	
	public C05_Person() {

	}
	C05_Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString(){
		return "姓名:"+name+",年龄:"+age;
	}
	
	@Override
	public int compareTo(C05_Person o) {	//覆写compareTo方法
		if(this.age<o.getAge()){	//只对年龄进行排序
			return -1;
		}else if(this.age==o.getAge()){
			if(this.name.equals(o.getName())){
				return 0;
			}
			return -1; 
		}else{
			return 1;
		}
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
