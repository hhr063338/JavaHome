package example.annotation;
/**
 * <ul>
 * <li>文件名称: A01_Override.java</li>
 * <li>功能描述: 观察@Override的作用</li>
 * </ul>
 */
public class A01_Override extends A01_Person{

	@Override  //此处明确地指出方法覆写操作
	public String getInfo() {//如果将覆写方法名写错，因为注释会出现错误警告
		
		return "这是一个继承Person的类";
		//注意：@Override的限制：在使用时只能在方法上应用，而其他元素，如类、属性等上是不能使用此Annotation
	}
	

	public static void main(String[] args) {
		A01_Person a01Person=new A01_Override();//父类引用子类实例
		System.out.println(a01Person.getInfo());
	}
}

class A01_Person{

	public String getInfo(){
		return "这是一个Person类";
	}
}
