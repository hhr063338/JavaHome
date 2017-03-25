package example.thread;

/**
 * <ul>
 * <li>文件名称: T04_RunnableFunction.java</li>
 * <li>文件描述: Runnable与Thread实现多线程的区别，前者如何共享多线程资源 </li>
 * </ul>
 */
public class T04_RunnableFunction implements Runnable{

	private int ticket=5;
	public void run() {
		for(int i=0;i<100;i++){
			if(ticket>0){
				System.out.println("Runnable卖票：ticket= "+ticket--);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.out.println("==以下执行继承Thread的多线程类，不能资源共享======");
		T04_Thread t1=new T04_Thread();
		T04_Thread t2=new T04_Thread();
		T04_Thread t3=new T04_Thread();
		t1.start();
		t2.start();
		t3.start();
		//解析：上面代码中程序中启动了三个线程，但线程却分别卖了5张票
		Thread.sleep(1000);
		System.out.println("==实现Runnable接口的多线程，能资源共享=======");
		T04_RunnableFunction runnable=new T04_RunnableFunction();
		new Thread(runnable).start();
		new Thread(runnable).start();
		new Thread(runnable).start();
		//解析：上面代码程序中启动了三个线程，但是三个线程才卖了5张票
		
	}
	/***通过实现Runnable接口实现多线程的优点
	 *  1.适合多个相同程序代码的线程去处理同一资源的情况
	 *  2.可以避免由于java的单继承特性带来的局限
	 *  3.增强了程序的健壮性，代码能够被多个线程共享，代码与数据是独立的
	 */
}

/**
 * <ul>
 * <li>文件名称: T04_RunnableFunction.java</li>
 * <li>文件描述: 继承Thread类实现多线程类</li>
 * </ul>
 */
class T04_Thread extends Thread{
	private int ticket=5;
	public void run() {
		for(int i=0;i<100;i++){
			if(ticket>0){
				System.out.println("卖票：ticket= "+ticket--);
			}
		}
	}
}