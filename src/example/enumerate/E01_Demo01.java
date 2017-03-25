package example.enumerate;


import example.enumerate.Color;

/**
 * <ul>
 * <li>文件名称: E01_Demo01.java</li>
 * <li>功能描述: 使用简单的类完成枚举操作</li>
 * </ul>
 */
public class E01_Demo01 {
	/**
	 * 在枚举中可以限制一个类的对象产生范围，加入了枚举之后，Java又对之前的类集进行了扩充，产生新的枚举支持类
	 * EnumSet/EnumMap
	 * 在JDK1.5之前，Java有两种方式定义新类型:类和接口，但这不能满足需求，例如想定义一个Color类，他只能有
	 * 		Red\Green\Blue 共3种值，其它任何值都非法，JDK1.5之前，虽然可以构造这样的代码，但要做很多操作，
	 * 		就可能带来各种不安全的问题
	 * 
	 * @param args
	 */
	
	
	public static void main(String[] args){
		Color c1=Color.RED;
		System.out.println("c1颜色的名称："+c1.getName());
		Color c2=Color.BLUE;
		System.out.println("c2颜色的名称："+c2.getName());
	}

}

/***
 * <ul>
 * <li>文件名称: E01_Demo01.java</li>
 * <li>功能描述: Color类中的构造方法私有化，之后在类中准备了若干个实例化对象，以后如果要取得Color类的实例</li>
 *  <li>    则只能从RED/GREEN/BLUE三个对象中取得，这样就有效地限制了对象的取值范围</li>
 *  <li>功能描述: 通过常量对指定范围的对象进行编号，就是说可以用常量表示，按照这个思想，也可以直接
 *  		使用一个借口规定出一组常量的范围</li>
 * </ul>
 */
class Color{
	public static final Color RED=new Color("红色");//定义对象，注意这里定义的是对象
	public static final Color GREEN=new Color("绿色");
	public static final Color BLUE=new Color("蓝色");
	
	private String name;
	private Color(String str1){		//构造方法私有化，同时设置颜色的名称
	 this.setName(str1);	
	}
	
	public static Color getInstance(int i){
		switch(i){					//得到一个颜色，只能从固定的颜色范围内选择
			case 1:{return RED;}	//分号没有放在大括号外面
			case 2:{return GREEN;}
			case 3:{return BLUE;}
			default:return null;  
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
