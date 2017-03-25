package example.reflection;

import java.lang.reflect.Method;

/**
 * 反射除了可以取得一个类的完整结构外，还可以调用类中的指定方法或指定属性
 * 并且可以通过反射完成对数组的操作
 *
 */
public class R09_CallMethod01 {
	/**
	 * 通过反射调用类中的方法,在这里演示调用RPerson09.sayChina()无参方法和sayHello(String,int)有参方法
	 * 通过getMethod取得方法并设置参数，通过invoke进行调用并向该方法中传递参数
	 */
	public static void main(String[] args) {
		Class<?> cls=null;		
		try {
			cls=Class.forName("sample.reflection.RPerson09");
			Method mtd=cls.getMethod("sayChina");		//获取指定无参方法，该方法没有参数
			mtd.invoke(cls.newInstance());				//调用方法，必须传递实例
			
			//下面是调用是有参方法
			Method sH=cls.getMethod("sayHello", String.class,int.class);//获取有参方法的方式,.class是实例化
			String rv=null;		//接收方法的返回值
			rv=(String)sH.invoke(cls.newInstance(), "李兴华",30);//调用该方法，传递实例、参数
			System.out.println(rv);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}



}
//声明类
class RPerson09 implements China05{
	private String name;
	private int age;
	public RPerson09(){}
	public RPerson09(String str){
		this.name=str;
	}
	public RPerson09(String name,int age){
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
