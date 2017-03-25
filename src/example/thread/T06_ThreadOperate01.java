package example.thread;

/**
 * <ul>
 * <li>文件名称: T06_ThreadOperate01.java</li>
 * <li>文件描述: 线程操作的相关方法 </li>
 * <li>内容描述：本类是 线程名设置</li>
 * </ul>
 */
public class T06_ThreadOperate01 implements Runnable{

	
	
	public void run() {
		String name=Thread.currentThread().getName();//获取当前线程的名称
		for(int i=0;i<3;i++){
			System.out.println(name+"运行，i="+i);
		}	
	}
	/**线程名称设置与获取***/
	//线程的名称一般在启动线程前设置，但也允许已经运行的线程设置名称，允许两个thread对象有相同的名称，但应该避免
	//没有设置线程名称的线程对象的名称都是很有规律的，分别为Thread-0，Thread-1，Thread-2
	//在Thread类中必然存在一个static类型的属性，用于为线程自动命名
	
	public static void main(String[] args) {
		T06_ThreadOperate01 runableOperate01=new T06_ThreadOperate01();
		Thread thread01=new Thread(runableOperate01);
		thread01.start();
		new Thread(runableOperate01,"  线程-01").start();
		runableOperate01.run();//验证main也是一个线程
	}
	//在java中所有的线程都是同时启动的，哪个线程先抢到了CPU资源哪个就先运行。
	/***question:Java程序每次允许至少启动多少个线程
	 *  answer:  至少两个线程，每当java执行一个类时，实际上都会启动一个JVM，每一个JVM实际上就是在操作系统
	 *  		中启动了一个进程，Java本身具备了垃圾收集机制。
	 *  		所以在Java运行时至少启动两个线程，一个是main线程，一个是垃圾收集线程
	 */
	
	
}
