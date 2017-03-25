package example.reflection;

/**
 * 
 * <ul>
 * <li>文件名称: R01_base01.java</li>
 * <li>功能描述: 获取类名</li>
 * </ul>
 */
public class R01_base01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sample01 s=new Sample01();//实例化Sample01
		System.out.println(s.getClass().getName());//得到对象所在类

	}

}
class Sample01{		//定义类
	
}
