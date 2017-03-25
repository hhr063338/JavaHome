package example.collection2;
/**类集与数组的区分
 * 类集是java中一个很重要的特性，在实际开发中占有很大的地位，如果写一个好的程序，则一定要将类集的作用和
 * 各个组成部分的特点掌握清楚
 * 
 * 在此之前要保存一组对象，是使用对象数组，但对象数组有长度限制，而通过一些数据结构的操作，如链表，则可以
 * 动态地完成对象数组的操作，这全让开发人员做，无疑显得比较麻烦
 * 
 * 类集框架很少的解决上面的问题，所谓的类集就是一个动态的对象数组，是对实现好的数据结构进行了包装，这样在
 * 使用时会比较方便，而且类集框架不受长度影响
 *
 */

/** 类集框架被设计成的特性
 * 1.高性能的，对基本类集(动态数组、链接表、树和散列表)的实现是高效率的
 * 2.框架必须允许不同类型的类集以相同的方式和高度互操作方式工作
 * 3.类集必须是容易扩展和修改的，为实现这目标，类集框架被设计成包含了一组标准接口
 */
/**常用接口
 * 在整个Java类集中最常使用的类集接口是：Collection、List、Set、Map、Iterator、
 * ListIterator、Enumeration、SortedSet、SortedMap、Queue、Map.Entry
 */
/**Collection的说明
 * Collection:是存放一组单值的最大父接口，所谓的单值是指集合中的每个元素都是一个对象（单个的对象），一般很少直接使用此接口直接操作
 * 在实际中，基本上都是使用其子接口进行开发，子接口主要List/Set/Queue和SortedSet
 */
/**List/Set/Queue/SortedSet的简单说明
 * List:可以存放重复的内容
 * Set：不能存放重复的内容，所有的重复内容靠hashCode()和equals()两个方法区分
 * Queue：队列接口
 * SortedSet:可以对集合中的数据进行排序
 */

public class C00_ClassCollect {
	public static void main(String[] args) {
		
	}
	

	


}
