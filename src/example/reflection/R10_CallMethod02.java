package example.reflection;

import java.lang.reflect.Method;

/**
 * 通过反射调用类的属性，一般提倡属性私有化
 * 所以通过setter与getter方法调用
 *
 */
public class R10_CallMethod02 {
	
	public static String initStr(String old){	//单词首字母大写
		String str=old.substring(0, 1).toUpperCase()+old.substring(1);
		return str;
	}
	/**
	 * @param obj 操作对象
	 * @param att 操作的属性
	 * @param value 设置的值
	 * @param type 参数的类型
	 */
	public static void setter(Object obj,String att,Object value,Class<?> type){
		try { 
			Method mtd=obj.getClass().getMethod("set"+initStr(att),type);
			mtd.invoke(obj, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getter(Object obj,String att){
		try {
			Method mtd=obj.getClass().getMethod("get"+initStr(att));
			System.out.println(mtd.invoke(obj));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		public static void main(String[] args) {
		
			Class<?> cls=null;
			Object obj=null;
			try {
				cls=Class.forName("sample.reflection.RPerson10");//实例化Class对象
				obj=cls.newInstance();	//实例化RPerson10对象
				setter(obj, "name", "李兴华", String.class);
				setter(obj, "age", 30, int.class);
				System.out.println("姓名：");
				getter(obj, "name");
				System.out.println("年龄：");
				getter(obj, "age");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		


}

//声明类
class RPerson10 implements China05{
	private String name;
	private int age;
	public RPerson10(){
//		name="李中兴";
//		age=32;
	}
	public RPerson10(String str){
		this.name=str;
	}
	public RPerson10(String name,int age){
		this.name=name;
		this.age=age;
		
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
	};
	public String toString(){
		return "姓名:"+this.name+" , 年龄:"+this.age;
	}

	public void sayChina() {
		System.out.println("我是中国人\n");
		
	}

	public String sayHello(String name, int age) {
	
		return "hello,my name is "+name+" and I'm "+age;
	}
	
	
}

