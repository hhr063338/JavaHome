package example.collection;

import java.util.HashSet;
import java.util.Set;

public class TestSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> s1=new HashSet<String>();
		Set<String> s2=new HashSet<String>();
		s1.add("a");s1.add("b");s1.add("c");
		System.out.println("s1集里含有"+s1);
		s2.add("d");s2.add("a");s2.add("b");
		System.out.println("s2集里含有"+s2);
	//Set和List容器类都具有Constructor(Collection c);
	//构造方法用以初始化容器类
		Set<String> sn=new HashSet<String>(s1);
		sn.retainAll(s2);
		Set<String> su=new HashSet<String>(s1);
		su.addAll(s2);
		System.out.println("sn(s1与s2的交集)"+sn);
		System.out.println("su(s1与s2的并集)"+su);
	}

}
