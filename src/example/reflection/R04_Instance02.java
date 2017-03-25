package example.reflection;

import java.lang.reflect.Constructor;

/**
 * 利用反射机制实例不含无参构造类的对象
 *
 */
public class R04_Instance02 {
	public static void main(String[] args){
		Class<?> c1=null;
		RPerson4 p4=null;
		Constructor<?> cons[]=null; //声明一个构造方法数组
		
		try {
			c1=Class.forName("sample.reflection.RPerson4");//声明Class对象
			cons=c1.getConstructors();
			p4=(RPerson4)cons[0].newInstance("李再兴",24);//显示调用第一个构造方法
			
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		System.out.println(p4.toString());
		
	}

}


class RPerson4{
	private String name;
	private int age;
	public RPerson4(String str,int a){
		this.name=str;
		this.age=a;
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
	}
	@Override
	public String toString() {
		
		return "姓名："+this.getName()+",年龄："+this.getAge();
	}
	
	
	
}