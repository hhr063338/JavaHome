package example.collection;

import java.util.*;
public class TestCollection {
	public static void main(String[] args){
	Collection<Object> c =new ArrayList<Object>();
	//可以放入不同类型的对象
	c.add("hello");
	c.add(new Integer(100));
	System.out.println(c.size());
	System.out.println(c);
	c.remove("hello");//挨着盘equals，一样则去掉
	System.out.println(c);
	}
	
}
