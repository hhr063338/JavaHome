package example.thread;

/***
 * <ul>
 * <li>文件名称: T03_RunableDemo01.java</li>
 * <li>文件描述: 实现Runable接口,是实现多线程的第二种方式和如何调用</li>
 * <li>Runable接口只定义了一个抽象方法：public void run() </li>
 * </ul>
 */
public class T03_RunnableDemo01 implements Runnable{

	private String name;
	public T03_RunnableDemo01(){};
	public T03_RunnableDemo01(String str){ this.name=str;};
	
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println(name+"运行："+i);
		}
	}
	
	/**
	 * 实现的Runnable接口中只有run()方法并没有start()方法，那如何调用实现Runnable接口的多线程类
	 * 还是要依靠Thread类完成，它提供public Thread(Runnable target);
	 * public Thread(Runnable target,String name)两个构造方法接收Runnable实例，并依此启动多线程
	 * @param args
	 */
	public static void main(String[] args) {
		T03_RunnableDemo01 runnable01=new T03_RunnableDemo01("张三");
		T03_RunnableDemo01 runnable02=new T03_RunnableDemo01("  李四");
		Thread thread1=new Thread(runnable01);
		Thread thread2=new Thread(runnable02);
		thread1.start();
		thread2.start();
	}
	
}
