package example.reflection;

import java.lang.reflect.Field;

/**
 * 除了利用setter与getter方法来调用属性，我们也可以直接调用属性
 * 不过需要注意的是因为属性都是私有的，所以在访问的时候需要使用Field类的setAccessible(true)方法
 * 将需要操作的属性设置成可以被外部访问
 *
 */
public class R11_CallProp {
		/*
		 * 范例：直接操作类中的属性
		 */
		public static void main(String[] args) {
			Class<?> cls=null;
			Object obj=null;
			try {
				cls=Class.forName("sample.reflection.RPerson11");
				obj=cls.newInstance();
				Field nameField=null;	//用来表示name属性
				Field ageField=null;	//用来表示age属性
				
				nameField=cls.getDeclaredField("name");	//取得name属性
				ageField=cls.getDeclaredField("age");
				
				nameField.setAccessible(true);//将name属性设置成可被外部访问
				nameField.set(obj, "李兴华");
				ageField.setAccessible(true);
				ageField.set(obj, 22);
				
				System.out.println("姓名："+nameField.get(obj));//通过get取得属性内容
				System.out.println("年龄："+ageField.get(obj));
				
				RPerson11 rp=(RPerson11)obj;
				System.out.println("姓名："+rp.getName());
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


}




//声明类
class RPerson11 implements China05{
	private String name;
	private int age;
	public RPerson11(){}
	public RPerson11(String str){
		this.name=str;
	}
	public RPerson11(String name,int age){
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