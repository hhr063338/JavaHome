package example.collection;

import java.util.*;

import example.eventreflect.entity.Person;



public class IteratorCollection {
	 public static void main(String[] args){
		 
		 Person person1=new Person();
		 person1.setId("1");
		 person1.setName("张三");
		 
		 Person person2=new Person();
		 person2.setId("2");
		 person2.setName("李四");
		 Collection<Person> c=new ArrayList<Person>();
		 c.add(person1);
		 c.add(person2);
	//使用Iterator遍历对象
		 System.out.println("使用Iterator遍历对象");
		 Iterator<Person> iterator=c.iterator();//获得迭代子
		 while(iterator.hasNext()){
			 Person p=iterator.next();
			 System.out.println(p.getId()+"的名字是"+p.getName());
//			 iterator.remove();
		 }
		 iterator.remove();//在执行完next()方法后只能执行一次，删掉游标左边的数
//		 iterator.remove();
	//使用for循环遍历对象
		 System.out.println("使用for循环遍历对象");
		 for(Person p2:c){
			 System.out.println(p2.getId()+"的名字是"+p2.getName());
		 }
		 
		 
	 }
}
/*
 * Collection使用的主要方法：
 * boolean add(Object o)添加对象到集合
 * boolean remove(Object o)删除指定的对象
 * int size()返回当前集合中元素的数量
 * boolean contains(Object o)查找集合中是否有指定的对象
 * boolean isEmpty()判断集合是否为空
 * Iterator iterator()返回一个迭代器
 * boolean containsAll(Collection c)查找集合中是否有集合c中的元素
 * boolean addAll(Collection c)将集合c中所有的元素添加给该集合
 * void clear()删除集合中所有元素
 * void removeAll(Collection c)从集合中删除c集合中也有的元素
 * void retainAll(Collection c)从集合中删除集合c中不包含的元素
 */

	
