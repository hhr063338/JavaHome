package example.annotation;

/**
 * <ul>
 * <li>文件名称: A01_Deprecated.java</li>
 * <li>功能描述: 使用@Deprecated声明一个不建议使用的方法</li>
 * </ul>
 */
public class A01_Deprecated {

	public static void main(String[] args) {
		A01_Demo demo=new A01_Demo();
		System.out.println(demo.getInfo());
		System.out.println(demo.getSay());
	}
}

class A01_Demo{
	
	@Deprecated   //声明不建议使用的操作，并且除了在方法上也可以在类上使用
	public String getInfo(){
		return "这是一个实例";
	}
	
	public String getSay(){
		return "在说话";
	}
}
