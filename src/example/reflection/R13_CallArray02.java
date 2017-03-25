package example.reflection;

import java.lang.reflect.Array;

/**
 * 通过Array类根据已有的数组类型来开辟新的数组对象
 * 范例：修改数组的大小
 *
 */
public class R13_CallArray02 {

	public static void main(String[] args) {
		int temp[]={1,3,5};
		int newTemp[]=(int[])arrayInc(temp, 5);
		print(newTemp);
		System.out.println("\n--------------------------------------------");
		String str[]={"abc","efg","hij"};
		String str2[]=(String[])arrayInc(str, 8);
		print(str2);

	}
	
	//修改数组的大小
	public static Object arrayInc(Object obj ,int len){
		Class<?> c=obj.getClass();			//通过数组得到class对象
		Class<?> arr=c.getComponentType();	//得到数组的class对象
		Object new0=Array.newInstance(arr, len);	//重新开辟数组的大小
		int co=Array.getLength(obj);
		System.arraycopy(obj, 0, new0, 0, co);
		return new0;
	}
	//输出数组
	public static void print(Object obj){
		Class<?> c=obj.getClass();
		if(!c.isArray()){
			return;
		}
		Class<?> arr=c.getComponentType();
		System.out.println(arr.getName()+" 数组长度："+Array.getLength(obj));//输出数组信息
		for(int i=0;i<Array.getLength(obj);i++){
			System.out.println(Array.get(obj, i)+"  ");
		}
	}

}
