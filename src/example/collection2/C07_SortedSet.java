package example.collection2;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * SortedSet接口
 * SortedSet接口用来进行排序，所以所有实现SortedSet的子类都可以进行排序，比如TreeSet
 * 
 */
/** SortedSort接口定义的方法
 * public Comparator<? super E> comparator();返回与排序有关联的比较器
 * public E first();返回集合中的第一个元素
 * public SortedSet<E> headSet(E toElement);返回从开始到指定元素的集合
 * public E last();返回最后一个元素
 * public SortedSort<E> subSet(E fromElement ,E toElement);返回指定对象间的元素
 * public SortedSort<E> tailSet(E fromElement);从指定元素到最后
 * 
 */

public class C07_SortedSet {

	public static void main(String[] args) {
		C07_SortedSet s=new C07_SortedSet();
		s.sort();
	}
	
	//1.验证SortedSet接口
	public void sort(){
		SortedSet<String> allset=new TreeSet<String>();
		allset.add("a");
		allset.add("b");
		allset.add("c");//增加重复元素，看是否能加入
		allset.add("c");
		allset.add("d");
		allset.add("e");
		allset.add("f");
		allset.add("g");
		System.out.println("第一个元素："+allset.first());
		System.out.println("最后一个元素："+allset.last());
		System.out.println("headSet元素："+allset.headSet("d"));//返回从开始到指定元素间的集合,不包含指定uansu
		System.out.println("tail元素："+allset.tailSet("c"));//从指定元素到最后的集合
		System.out.println("subSet元素："+allset.subSet("c", "d"));//截取指定元素间的集合，不包含末尾元素
	}
	//2
}
