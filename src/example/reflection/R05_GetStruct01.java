package example.reflection;

import java.lang.reflect.Constructor;

/**
 * 反射的应用——取得类的结构
 * Constructor表示类中的构造方法
 * Filed表示类中的属性
 * Method表示类中的方法
 *
 */
public class R05_GetStruct01 {
	
	public static void main(String[] args) {
			Class<?> c1=null;
			Constructor<?> cons[]=null;
			Class<?> c2[]=null;
			
			try {
				c1=Class.forName("sample.reflection.RPerson05");
				c2=c1.getInterfaces();		//取得全部实现的接口
				for(Class<?> c3:c2){
					System.out.println("sample.reflection.RPerson05实现的接口类有："+c3.getName());
				}
				Class<?> c4=c1.getSuperclass();//取得父类
				System.out.println("取得sample.reflection.RPerson05的父类:"+c4.getName() );
				
				//取得全部的构造方法
				cons=c1.getConstructors();
				for(int i=0;i<cons.length;i++){
					System.out.println("构造方法："+cons[i]);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}


	

	

}


interface China05{
	public static final String NATIONAL="CHINA";//定义全局变量
	public static final String AUTHOR="李兴华";
	public void sayChina();						//定义抽象方法
	public String sayHello(String name,int age);
}

class RPerson05 implements China05{
	private String name;
	private int age;
	public RPerson05(){}
	public RPerson05(String str){
		this.name=str;
	}
	public RPerson05(String name,int age){
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
	@Override
	public void sayChina() {
		System.out.println("我是中国人\n");
		
	}
	@Override
	public String sayHello(String name, int age) {
	
		return "hello,my name is "+name+" and I'm "+age;
	}
	
	
}