package example.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 取得类的全部属性（两种方法）
 * 得到实现的接口或父类中的公共属性：Public Filed[] getFileds() throws SecurityException
 * 得到本类中的所有属性：public Filed[] getDeclaredFileds() throws SecurityException
 */

public class R08_GetProperties {
	public static void main(String[] args) {
		Class<?> cls=null;
		Field[] fld=null;
		Class<?>  casual=null;
		
		try {
			//取出本类的所有属性
			cls=Class.forName("sample.reflection.RPerson08");
			System.out.println("本类属性有：");
			fld=cls.getDeclaredFields();	//获取本类中所有的属性
			for(Field f:fld){
				casual=f.getType();			//取得属性的类型
				int mo=f.getModifiers();	//取得修饰符对应的数值
				String priv=Modifier.toString(mo);//取得修饰符
				System.out.print(priv+"  ");
				System.out.print(casual+"  ");
				System.out.println(f.getName());//获得属性名
			}
			
			//取出实现接口或父类所共有的属性
			System.out.println("-------------------------取出实现接口或父类所共有的属性-------------------------------");
			Field[] ff=cls.getFields();
			for(Field f:ff){
				casual=f.getType();			//取得属性的类型
				int mo=f.getModifiers();	//取得修饰符对应的数值
				String priv=Modifier.toString(mo);//取得修饰符
				System.out.print(priv+"  ");
				System.out.print(casual+"  ");
				System.out.println(f.getName());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}


}


//声明类
class RPerson08 implements China05{
	private String name;
	private int age;
	public RPerson08(){}
	public RPerson08(String str){
		this.name=str;
	}
	public RPerson08(String name,int age){
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