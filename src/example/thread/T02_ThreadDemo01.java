package example.thread;

/***
 * 
 * <ul>
 * <li>文件名称: T02_ThreadDemo01.java</li>
 * <li>文件描述: 继承Thread类实现多线程 </li>
 * <li>内容描述：在java中要实现多线程代码有两种手段,一种是继承Thread类，另一种就是实现Runable接口</li>
 * </ul>
 */
public class T02_ThreadDemo01 extends Thread{

	private String name;
	public T02_ThreadDemo01(){
		
	}
	public T02_ThreadDemo01(String str){
		this.name=str;
	}
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println(name+"运行,i="+i);
		}
	}
	
	//只要继承java.lang.Thread类的类都可以称为多线程操作类
	//在Thread子类中必须明确地覆写run()方法，此方法为线程的主体
	public static void main(String[] args) {
		T02_ThreadDemo01 thread1=new T02_ThreadDemo01("张三");
		T02_ThreadDemo01 thread2=new T02_ThreadDemo01("  李四");
		thread1.run();
		thread2.run();
		System.out.println("如果要正确地启动线程，是不能直接调用run()方法，而应该是调用从Thread类中继承而来的start()方法");
		System.out.println("==================");
		thread1.start();//线程启动时调用的事start()方法,但实现的主体还是run()
		thread2.start();//
		//thread1.start();//继承Thread实现只能调用一次，多次调用会抛出异常
	}
	/*** question：为什么启动线程不能直接使用run()方法
	 *   answer：因为线程的运行需要本机操作系统的支持
	 * 	 其中strart()的定义：private native void start();,在一个类中的start()方法调用时可能会
	 *   抛出“IllegalThreadStateException”异常，一般重复调用start()方法时会抛出这个异常。而且实际
	 *   上此处真正调用的是start()方法,它用native声明表示调用本机的操作系统函数，因为多线程的实现需要依靠
	 *   底层操作系统支持
	 *   notice:如果通过继承Thread类来实现，那么只能调用一次，如果调用多次则会抛出异常
	 */
}
