package example.enumerate;


/**
 * <ul>
 * <li>文件名称: E02_EnumCase01.java</li>
 * <li>功能描述: 引入关键字-enum，可以直接定义枚举类型</li>
 * <li>定义枚举类型的格式：[public] enum 枚举类型名称{  枚举对象1,枚举对象2,……,枚举类型n;   }</li>
 * <li>补充描述：利用“枚举.variable”的形式取出枚举中的指定内容</li>
 * </ul>
 */
public class E02_EnumCase01 {
	public static void main(String[] args) {
		
		E02_EnumCase01 demo=new E02_EnumCase01();
		//title:取出一个枚举内容
		demo.getEnumDemo01();
		//title:通过"枚举.values()"取出数组形式的枚举元素
		demo.getAllEnum();
		//title:利用Switch进行判断
		demo.getSwitchEnum();
	}

	/**
	 * <li>title：取出一个枚举内容</li>
	 */
	public void getEnumDemo01(){
		Color2 color=Color2.BLUE;
		System.out.println("取一个枚举内容："+color);
	}
	
	/**
	 * <li>title:使用foreach输出枚举内容 </li>
	 * <li>content:枚举类型的数据可以使用“枚举.values()”的形式，将全部的枚举类型变为对象数组的形式之后
	 * 			直接使用foreach进行输出
	 * </li>
	 */
	public void getAllEnum(){
		System.out.println("取出所有的枚举内容：");
		for(Color2 c:Color2.values()){
			System.out.println(c);
		}
	}
	
	/**
	 * <li>title:使用Switch进行判断</li>
	 * <li>content:在Switch语句中使用枚举时，一定不能在枚举类型的值前面加上枚举类型的类名，否则编译器报错</li>
	 */
	public void getSwitchEnum() {
		System.out.println("利用Switch进行判断");
		for(Color2 color2:Color2.values()){
				switch (color2) {
				case RED: {
					System.out.println("红颜色");
					break;
				}
				case BLUE: {
					System.out.println("蓝颜色");
					break;
				}
				case GREEN: {
					System.out.println("绿颜色");
					break;
				}
				default: {
					System.out.println("这是未知颜色");
					break;
					}
				}
		}
	}
}

//定义枚举类，不同于普通类，在这里用enum声明相当于定义一个类，java.lang.Enum是被默认继承的
 enum Color2{
	RED,GREEN,BLUE;
}
