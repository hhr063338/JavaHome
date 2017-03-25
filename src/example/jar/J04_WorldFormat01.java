package example.jar;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 在国际化操作中，写入读取动态文本
 *
 */
/**
 * 在之前的程序中，所有的资源内容都是固定的，假如输出的信息包含一些动态文本，
 * 则必须使用占位符清楚地表示出动态文本的位置，占位符使用“{编号}”的格式出现
 * 在使用占位符后可以通过MessageFormat对信息进行格式化，为占位符动态设置文本
 * Format、MessageFormat、DateFormat、NumberFormat
 */
public class J04_WorldFormat01 {
	
	public static void main(String[] args) {
		J04_WorldFormat01 j4=new J04_WorldFormat01();
		//1.读取动态文本资源
		j4.worldFormat();
		
		//2.测试可变参数传递输出
		j4.fun("李一","李二","李三");
		j4.fun("y1","y2");
		
		//3.使用数组来测试可变参数传递输出
		Object[] arg1={"李一","李二","李三"};
		j4.fun(arg1);
	}


	/**
	 * 设置读取动态文本
	 * public static String format(String pattern ,Object...arguments)
	 * 第一个参数表示要匹配的字符串
	 * 第二个参数“Object...arguments”表示输入参数可以任意多个，没有个数限制
	 */
	public void worldFormat(){
		System.out.println("***************读取动态文本***************************");
		Locale zg=new Locale("zh", "CN");
		Locale yg=new Locale("en", "US");
		ResourceBundle rbzg=ResourceBundle.getBundle("Message_zg", zg);
		ResourceBundle rbyg=ResourceBundle.getBundle("Message_mg", yg);
		
		//依次读取各个属性文件的内容，通过键值读取
		String str1=rbzg.getString("info");
		String str2=rbyg.getString("info");
		System.out.println("中文："+MessageFormat.format(str1, "李兴华"));
		System.out.println("英文："+MessageFormat.format(str2, "lixinghua"));
	}
	
	/**
	 * 测试可变参数传递
	 */
	public void fun(Object...yy){
		System.out.println("**********研究传递参数的输出********************************");
		System.out.println("传入的参数有以下：");
		int count=1;
		for(Object o:yy){
			System.out.println("第"+count+"个参数为："+o.toString());
			count++;
		}
	}
	
}
