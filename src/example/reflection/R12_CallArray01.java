package example.reflection;

import java.lang.reflect.Array;

/**
 * 反射机制不仅仅只能用在类上，还可以用在任意的引用数据类型的数据上
 * 所以可以通过反射机制操作数组
 * 通过Class类的public Class<?> getComponentType()方法取得一个数组的Class对象
 *
 */
public class R12_CallArray01 {
	public static void main(String[] args) throws Exception {
		int[] temp={2,4,6,8};
		Class<?> c=temp.getClass().getComponentType();//取得数组的class对象
		System.out.println("数组的类型"+c.getName());	//取得数组类型名称
		System.out.println("数组的长度"+Array.getLength(temp));
		System.out.println("第一个元素:"+Array.get(temp, 0));
		//修改第一个元素内容
		Array.set(temp, 0, 10);
		System.out.println("第一个元素："+Array.get(temp, 0));
	}



}
