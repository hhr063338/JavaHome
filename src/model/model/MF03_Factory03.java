package model.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;


/**
 *  结合属性文件的工厂模式
 *  在上个文件中，需要输入完整的包.类，而用户又不知道一个接口有多少个子类可以用，
 *  所以我们可以通过属性文件的形式配置所要的子类信息
 *
 */
//范例：属性操作类
public class MF03_Factory03 {
	public static void main(String[] args) {
		Properties pro=Init.getPro();//初始化属性类
		//通过工厂类取得接口实例，通过属性的key传入完整的包.类名称
		FruitMF04 f=FactoryMF03.getInstance(pro.getProperty("apple"));
		f.eat();
	}
	/**
	 * 在本程序中，程序很好地实现了代码与配置的分离，通过配置文件使用要使用的类
	 * 之后通过程序读取配置文件，已完成具体功能
	 */


}
//属性操作类
class Init{
	public static Properties getPro(){
		Properties pro=new Properties();	//实例化属性类
		File f=new File("D:\\Program Files\\workspace\\java_home\\learn\\factory.properties");//找到属性文件
		try {
			if(f.exists()){	//属性文件已存在
				pro.load(new FileInputStream(f));			
			}else{
				pro.setProperty("apple", "sample.mode.AppleMF04");
				pro.setProperty("Orange", "sample.mode.OrangeMF04");
				pro.store(new FileOutputStream(f), "Fruit Class");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pro;
	}
}

//接口
interface FruitMF04{
	public void eat();
}
//苹果子类
class AppleMF04 implements FruitMF04{
	public void eat(){
		System.out.println("我要吃苹果!");
	}
}

class OrangeMF04 implements FruitMF04{
	public void eat(){
		System.out.println("我要吃橘子");
	}
}

//工厂类
class FactoryMF03{
	public static FruitMF04 getInstance(String classname){//取得接口实例
			FruitMF04 fruit=null;	//定义接口对象
			try {
				fruit=(FruitMF04)Class.forName(classname).newInstance();//实例化对象
			} catch (Exception e) {
				e.printStackTrace();
			}
			return fruit;
	}
}


