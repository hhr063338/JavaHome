package model.model;

import java.util.Observable;
import java.util.Observer;

/**	观察者设计模式
 *  java.util包中提供Observable类和Observer接口，使用它们即可完成观察者模式
 *  需要被观察的类必须继承Observable类，Observable常用的方法：
 *
 */
/*
 * public void addObserver(Observer o) 添加一个观察者
 * public void deleteObserver(Observer o) 删除一个观察者
 * public void setChanged()	被观察者状态发生改变
 * public void notifyObservers(Object arg) 通知所有观察者状态改变
 * 每一个观察者类都需要实现Observer接口，Observer接口定义如下：
 * public interface Observer{
 * 		void update(Observable o,Object arg);
 * 	//第一个参数表示被观察者实例，第二个参数表示修改的内容
 * }
 */
public class MO01_Obsever {
	//范例：观察者模式的实现
	/**
	 * 用观察者买房
	 */
	public static void main(String[] args) {
		MO01_House h=new MO01_House(100);
		MO01_HousePriceObserver m1=new MO01_HousePriceObserver("购买者1");
		MO01_HousePriceObserver m2=new MO01_HousePriceObserver("购买者2");
		MO01_HousePriceObserver m3=new MO01_HousePriceObserver("购买者3");
		h.addObserver(m1);	//加入观察者
		h.addObserver(m2);
		h.addObserver(m3);
		System.out.println("现在房价："+h.getPrice()+"万");
		h.setPrice(1345);
		System.out.println(h);
		
	}


	
}
//观察者，必须实现Observer接口
class MO01_HousePriceObserver implements Observer{
	private String name;
	public MO01_HousePriceObserver(String name){
		this.name=name;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(arg instanceof Float){	//判断参数类型
			System.out.print(this.name+"观察到价格更改为:");
			System.out.println(((Float)arg).floatValue());
		}
		
	}
	
}

//被观察者（观察物）,需要继承Observable
class MO01_House extends Observable{
	private float price;
	public MO01_House(){};
	public MO01_House(float price){
		this.price=price;
	}
	public void setPrice(float price){
		super.setChanged();//设置变化点
//		super.notifyObservers((double)price);
		//通知所有观察者价格改变，这里传递的参数为改变的内容
		super.notifyObservers(price);
		this.price=price;
	}
	public float getPrice(){
		return price;
	}
	public String toString(){
		return "房子价格为"+price+"万";
	}
}