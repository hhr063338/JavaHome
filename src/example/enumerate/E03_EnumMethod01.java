package example.enumerate;

/**
 * 
 * <ul>
 * <li>文件名称: E03_EnumMethod01.java</li>
 * <li>功能描述: 探讨枚举类中的name()/ordinal()方法和含义</li>
 * </ul>
 */
public class E03_EnumMethod01 {
	/**
	 * 在枚举类建立完成之后，实际上都会为其调用枚举中的构造方法，为其赋值，
	 * 在Enum类的构造方法中的第一个参数name就是定义枚举的名称，第二个参数ordinal则会从0开始依次进行编号。
	 * 之后可以使用Enum提供的name()与ordinal()方法取得名称和编号
	 * 
	 */	
	public static void main(String[] args){
		//在枚举类建立完成后，都会默认调用枚举类中的构造方法，为其赋值
		//Enum类的构造方法中第一个参数name表示枚举名称
		//第二个参数ordinal表示会从0开始编号
		System.out.println("名称------>编号");
		for(E03_Color c1:E03_Color.values()){
			System.out.println(c1.name()+"------>"+c1.ordinal());
		}
	}

}

/***
 * <ul>
 * <li>文件名称: Color3</li>
 * <li>功能描述: 使用enum关键字可以定义一个枚举，就相当于定义一个类，而此类默认继承java.lang.Enum类</li>
 * <li>Enum定义格式: public abstract class Enum<E extends Enum<E> > extends Object implements Comparable<E> ,java.io.Serializable
 *     从Enum的定义格式可以证明枚举类型可以使用比较器和序列化操作
 * </li>
 * <li>声明枚举类型：[public] enum 枚举类型名称{  枚举对象1,枚举对象2,……,枚举对象n;   }<li>
 * </ul>
 */
enum E03_Color{
		RED,GREEN,BLUE,WHITE;
}