package model.model;

/**
 * 设计模式--适配器设计
 * 当接口定义的抽象方法太多，而子类又用不到这么多的抽象方法，此时就需要一个中间过渡，
 * 而且此过渡类又不希望直接被使用，所以将此过渡类定义为抽象类最适合，此抽象类常被称为适配器类
 * 
 * 即一个接口首先被抽像类实现（适配器类），并在此抽象类实现若干方法（方法体为空），
 * 则此后的子类直接继承此抽象类，就可以有选择地覆盖所需要的方法
 * 
 * 范例：适配器的设计
 */
public class MA01_Adapter01 {
	public static void main(String[] args) {
		Window win=new WindowImpl();
		win.open();
		win.close();
	}


	
}


interface Window{	//定义window接口，表示窗口操作
	public void open();	//
	public void close();
	public void activated();//窗口活动
	public void iconfied();//最小化
	public void deiconfied();//窗口恢复大小
}

//定义抽象类实现接口，在此类中覆写方法，但所有的方法体为空
abstract class WindowAdapter implements Window{
	public void activated() {}
	public void close() {}
	public void deiconfied() {}
	public void iconfied() {	}
	public void open() {}	
}
//子类直接继承WindowAdapter类，有选择地实现需要的方法
class WindowImpl extends WindowAdapter{
	public void open(){
		System.out.println("窗口打开");
	}
	public void close(){
		System.out.println("窗口关闭");
	}
}
