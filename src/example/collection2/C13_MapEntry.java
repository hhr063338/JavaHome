package example.collection2;

/** Map.Entry接口简介
 *  Entry是Map接口内部定义的接口，专门用来保存key-value，它的定义
 *  public static interface Map.Entry<K,V>
 *  因为是static关键字声明的内部接口，在外部可以由”外部类.内部类“的形式直接调用
 */
/**	Map.Entry接口常用的方法：
 * 	public boolean equals(Object o);对象比较
 *  public K getKey(); public V getValue();
 *  public int hashCode();返回哈希码
 *  public V setValue(V value);设置value的值
 * 
 */
/**
 * 对Map来讲，实际是将key-value的数据保存在Map.Entry的实例，再在Map集合中插入一个Map.Entry的实例化对象
 * 在Map中的数据全部输出时必须使用Map.Entry接口，平常不需要用
 */
public class C13_MapEntry {

}
