package model.adapter;


/**
 * <ul>
 * <li>文件名称: A02_Adapter02.java</li>
 * <li>功能描述: 对象的适配器模式</li>
 * </ul>
 */
public class A02_Adapter_Test01 {

	/**
	 * 基本思路和类的适配器模式相同，只是将Adapter类作修改，这次不继承Source类，而是持有Source类的实例，
	 * 已达到兼容性问题
	 * @param args
	 */
	public static void main(String[] args) {
        A02_Source01 source = new A02_Source01();  
        A02_Target01 target = new A02_Adapter01(source);  
        target.method01();  
        target.method02();
	}
}
/***
 * <ul>
 * <li>文件名称: A02_Adapter_Test01.java</li>
 * <li>功能描述: 被适配的类（Adaptee）</li>
 * </ul>
 */
class A02_Source01{
	public void method01(){
		System.out.println("this is original method!");  
	}
}

/***
 * <ul>
 * <li>文件名称: A02_Adapter_Test01.java</li>
 * <li>功能描述: 目标接口(Target):客户希望的接口</li>
 * </ul>
 */
interface A02_Target01{
	/*与原来中的方法一样**/
	public void method01();
	
	/*新类的方法*/
	public void method02();
}

/**
 * <ul>
 * <li>文件名称: A02_Adapter01.java</li>
 * <li>角色扮演： 适配器(Adapter):通过包装一个需要适配的对象，把原接口转换成目标接口</li>
 * <li>功能描述: Adapter类继承Source类，实现Targetble接口</li>
 * <li>对象的适配器模式：这里不集成Source类，而是持有Source实例</li>
 * </ul>
 */
class A02_Adapter01 implements A02_Target01{
	
	private A02_Source01 source;
	
	public A02_Adapter01(A02_Source01 source){
		super();
		this.source=source;
	}
	@Override
	public void method02(){
		 System.out.println("this is the targetable method!");  
	}
	@Override
	public void method01() {
		  source.method01(); 
		
	}
}
