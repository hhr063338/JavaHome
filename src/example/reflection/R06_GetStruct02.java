package example.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
/**
 * 完整的取出一个类的全部构造函数（包含访问权限、参数）
 * 下面是取出权限返回的是整数值对应的权限
 * PUBLIC: 1
 * PRIVATE: 2
 * PROTECTED: 4
 * STATIC: 8
 * FINAL: 16
 * SYNCHRONIZED: 32
 * VOLATILE: 64
 * TRANSIENT: 128
 * NATIVE: 256
 * INTERFACE: 512
 * ABSTRACT: 1024
 * STRICT: 2048
 */
public class R06_GetStruct02 {

	public static void main(String[] args) {
		Class<?> c1=null;
		Constructor<?> cst[]=null;
		Class<?> paramType[]=null;
		
		try {
			c1=Class.forName("sample.reflection.RPerson06");//实例化Class对象
			cst=c1.getConstructors();	//取得全部的构造函数，这里的变狼是数组
			
			//下面是该类RPerson05的全部构造函数还有参数输出
			System.out.println("下面是该类RPerson05的所有构造函数：");
			for(Constructor<?> ct:cst){		//循环输出
				paramType=ct.getParameterTypes();	//列出构造函数中的参数类型
				System.out.print("输出构造方法： ");
				System.out.print(ct.getModifiers()+"  ");//取出权限，在这里返回的是整数值
				System.out.print(Modifier.toString(ct.getModifiers())+"  ");//通过Modifier还原访问权限
				System.out.print(ct.getName()+"(");//输出构造方法名称
				
				for(int i=0;i<paramType.length;i++){//循环输出参数
					System.out.print(paramType[i].getName()+" arg"+i);//输出参数类型
					if(i<paramType.length-1){
						System.out.print(",");
					}
				}
				System.out.println(");");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace());
		}
	}
	


}

//声明类
class RPerson06 implements China05{
	private String name;
	private int age;
	public RPerson06(){}
	public RPerson06(String str){
		this.name=str;
	}
	public RPerson06(String name,int age){
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
