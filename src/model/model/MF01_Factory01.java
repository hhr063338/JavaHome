package model.model;

/**
 * 设计模式--工厂模式
 * 程序在接口和子类之间加入了一个过渡端，通过彼此过渡端取得接口的实例化对象，
 * 一般都会称这个过渡端为工厂类
 * 
 *
 */
//范例：工厂设计模式
public class MF01_Factory01 {
		//测试工厂类
		public static void main(String[] args) {
			FruitMF01 f=null;
			f=FactoryMF01.getInstance("apple");
			f.eat();
		}



}

//工厂类
class FactoryMF01{
	public static FruitMF01 getInstance(String className){
		FruitMF01 fruit=null;	//定义接口对象
		if("apple".equals(className)){
			fruit=new AppleMF03();
		}
		if("orange".equals(className)){
			fruit=new OrangeMF03();
		}
		return fruit;
		
	}
}

interface FruitMF01{
	public void eat();
}
class AppleMF03 implements FruitMF01{
	public void eat(){
		System.out.println("正在吃水果!");
	}
}
class OrangeMF03 implements FruitMF01{
	public void eat(){
		System.out.println("正在吃橘子");
	}
}


