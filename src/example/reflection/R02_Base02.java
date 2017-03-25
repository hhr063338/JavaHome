package example.reflection;
/**
 *  三种实例化的Class对象的方式是三种，使用forName()的静态方法实例化class是最常用的
 *
 */
public class R02_Base02 {
	public static void main(String[] args) throws Exception{
		
		Class<?> c1=null;
		Class<?> c2=null;
		Class<?> c3=null;
		
		c1=Class.forName("sample.reflection.X");//词句会抛出异常//
		c2=new X().getClass();		//通过Object类中的getClass()方法获得实例
		c3=X.class;					//通过类.class实例化
		
		System.out.println("c1====>"+c1.getName());
		System.out.println("c2====>"+c2.getName());
		System.out.println("c3====>"+c3.getName());
	}
	

}
class X{
	
}