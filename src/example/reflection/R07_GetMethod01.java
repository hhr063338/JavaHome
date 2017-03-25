package example.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 取得一个类的全部方法定义
 * 观看运行结果可以知道，不仅把RPerson07中的方法输出，还将其继承
 * 来的Object方法也输出来
 * 在使用IDE程序开发时，输入'.'时会提示方法的就是利用此种方式完成的
 */
public class R07_GetMethod01 {
	public static void main(String[] args) {
		Class<?> cls=null;
		Method mtd[]=null;
		Class<?> paramType[]=null;
		Class<?> throwException[]=null;
		
		try {
			cls=Class.forName("sample.reflection.RPerson07");
			mtd=cls.getMethods();
			System.out.println("下面是类RPerson07的所有方法");
			
			for(int i=0;i<mtd.length;i++){
				System.out.print("方法"+i+":  ");
				System.out.print(Modifier.toString(mtd[i].getModifiers())+"  ");//访问控制符
				System.out.print(mtd[i].getReturnType()+"  ");		//取得返回值类型
				System.out.print(mtd[i].getName()+"(");//取得方法名
				
				
				//取出所有的方法签名(参数类型)
				paramType=mtd[i].getParameterTypes();
				for(int j=0;j<paramType.length;j++){
					System.out.print(paramType[j].getName()+" arg"+j);
					if(j<paramType.length-1){
						System.out.print(",");
					}
				}
				System.out.print(")");
				//取出方法抛出的全部异常
				throwException = mtd[i].getExceptionTypes();
				if (throwException.length > 0) {
					System.out.print(" throws ");
				}
				for (int z = 0; z < throwException.length; z++) {
					System.out.print(" " + throwException[z].getName() );
					if (z < throwException.length - 1) {
						System.out.print(", ");
					}
				}
				System.out.println();//换行
				
			
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}




	
	

}

//声明类
class RPerson07 implements China05{
	private String name;
	private int age;
	public RPerson07(){}
	public RPerson07(String str){
		this.name=str;
	}
	public RPerson07(String name,int age){
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
