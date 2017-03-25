package model.model;




/**
 * 之前的工厂模式，在增加一个接口实现类的时候需要修改工厂类，
 * 但在这里我们通过反射机制来改善工厂类，让其在增加子类时可以不用任何的修改，就可以达到功能的扩充
 *
 *
 */
//范例：使用反射完成工厂设计
public class MF02_Factory02 {
		//测试工厂类
		public static void main(String[] args) {
			//通过工厂类取得接口实例，传入完整的包.类名称
			FruitMF02 f=FactoryMF02.getInstance("sample.mode.AppleMF02");
			f.eat();
		}


}

//接口
interface FruitMF02{
	public void eat();
}
//苹果子类
class AppleMF02 implements FruitMF02{
	public void eat(){
		System.out.println("我要吃苹果!");
	}
}

class OrangeMF02 implements FruitMF02{
	public void eat(){
		System.out.println("我要吃橘子");
	}
}
//工厂类
class FactoryMF02{
	public static FruitMF02 getInstance(String classname){//取得接口实例
			FruitMF02 fruit=null;	//定义接口对象
			try {
				fruit=(FruitMF02)Class.forName(classname).newInstance();//实例化对象
			} catch (Exception e) {
				e.printStackTrace();
			}
			return fruit;
	}
}