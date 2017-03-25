package model.adapter;

/***
 * <ul>
 * <li>文件名称: A01_Adapter01.java</li>
 * <li>功能描述: 适配器模式(本例为类的适配器)</li>
 * </ul>
 */
public class A01_Adapter_Test01 {

	/***范例：类的适配器模式
	 * 适配器模式：将一个类的接口转换成客户希望的另外一个接口。Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以在一起工作。
	 * 模式中的角色：目标接口（Target）:客户所期待的接口，目标可以是具体的抽象类，也可以是接口
	 * 		需要适配的类（Adaptee）：需要适配的类或接口
	 * 		适配器（Adapter）：通过包装一个需要适配的对象，把原接口转换成目标接口
	 * 主要分三类：类的适配器模式、对象的适配器模式、接口的适配器模式
	 * 核心思想就是：有一个Source类，拥有一个方法，待适配，目标接口时Targetable，通过Adapter类，将Source的功能扩展到Targetable里
	 */
	public static void main(String[] args) {
		
		A01_Target01 taget=new A01_Adapter01();
		taget.method01();
		taget.method02();
	}
}

/**
 * <ul>
 * <li>文件名称: A01_Adapter01.java</li>
 * <li>功能描述: </li>
 * </ul>
 */
class A01_Source01{
	public void method01(){
		System.out.println("this is original method!");  
	}
}

/***
 * <ul>
 * <li>文件名称: A01_Adapter01.java</li>
 * <li>功能描述: 客户端需要的接口</li>
 * </ul>
 */
interface A01_Target01{
	/*与原来中的方法一样**/
	public void method01();
	
	/*新类的方法*/
	public void method02();
}

/**
 * <ul>
 * <li>文件名称: A01_Adapter01.java</li>
 * <li>功能描述: 通过包装一个需要适配的对象，把原接口转换成目标接口
 * <li>过程：将Adapter类继承Source类，实现Targetble接口</li>
 * </ul>
 */
class A01_Adapter01 extends A01_Source01 implements A01_Target01{
	public void method02(){
		 System.out.println("this is the targetable method!");  
	}
}



