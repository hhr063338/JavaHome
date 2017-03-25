package example.thread;

/**
 * 
 * <ul>
 * <li>文件名称: T09_ThreadOperate04.java</li>
 * <li>文件描述: 后台线程、线程优先级的设置与获取</li>
 * </ul>
 */
public class T09_ThreadOperate04 {

	public static void main(String[] args) throws Exception{
		T09_ThreadOperate04 t09=new T09_ThreadOperate04();
		//测试后台线程的设置
		//t09.consoleThread();
		//测试线程优先级
		//t09.priorityThread();
		//测试线程的礼让
		t09.yieldThread();
		//主方法的优先级
		Thread currentThread=Thread.currentThread();
		System.out.println(currentThread.getName()+" 线程(获取优先级)的优先级："+currentThread.getPriority());
	}

	/** title : 后台线程的设置
	 * content：在java程序中，只要有一个线程在运行，则整个java进程都不会消失，所以此时设置一个后台线程
	 * 			这样即使java进程结束了，此后台依然会继续执行,想要实现这样的操作，直接使用setDaemon方法即可
	 * notice:尽管run方法中是死循环，但是程序依然可以执行完，因为方法中的死循环已经设置成后台运行
	 */
	private void consoleThread() throws Exception{
		Runnable_console runnable=new Runnable_console();
		Thread thread_console=new Thread(runnable," 线程(测试后台设置)");
		thread_console.setDaemon(true);//此线程是在后台运行
		thread_console.start();
	}
	
	/**  title: 线程的优先级
	 * content：线程优先级分三级，常数表示1代表最低优先级，变量名MIN_PRIORITY
	 * 			常数5表示中等优先级，是线程的默认优先级，变量名NORM_PRIORITY
	 * 			常数10表示最高优先级，是线程的优先级，变量名MAX_PRIORITY
	 * notice :线程将根据优先级的大小决定哪个线程会先运行，但是并非线程的优先级越高就一定会先执行，
	 * 			哪个先执行将由CPU决定
	 */
	private void priorityThread(){
		//Runnable_priority runnable=new Runnable_priority();
		Thread thread1=new Thread(new Runnable_priority(),"线程A " );
		Thread thread2=new Thread(new Runnable_priority(),"  线程B " );
		Thread thread3=new Thread(new Runnable_priority(),"    线程C " );
		thread1.setPriority(Thread.MIN_PRIORITY);//设置线程优先级为最低，thread1.setPriority(1);
		thread2.setPriority(Thread.MAX_PRIORITY);//设置线程优先级为最低，thread1.setPriority(10);
		thread3.setPriority(Thread.NORM_PRIORITY);//设置线程优先级为中等（默认值），thread1.setPriority(5);
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
	/**  title: 线程的礼让
	 * content: 在线程的操作中，也可以通过yield()方法将一个线程的操作暂时让给其他线程
	 * 			造成线程优先级现象
	 * notice : 每当符合条件i=3时，就会将本线程暂停，而让其他线程先执行
	 */
	private void yieldThread(){
		Runnable_yield run1=new Runnable_yield();
		Thread threadA=new Thread(run1," 线程A ");
		Thread threadB=new Thread(run1,"    线程B ");
		threadA.start();
		threadB.start();
	}
}

/**
 * 测试 线程的后台进程
 */
class Runnable_console implements Runnable{
	public void run() {
		while(true){
			System.out.println(Thread.currentThread().getName()+" 正在运行 !");
		}	   
	}
}
/**
 * 测试 线程的优先级
 */
class Runnable_priority implements Runnable{
	public void run() {
		for(int i=0;i<5;i++){
			try{
				Thread.sleep(300);
			}catch(Exception e){
				
			}
			//输出线程名
			System.out.println(Thread.currentThread().getName()+" 线程(测试优先级) 运行 -->"+i);
		}
		
	}
}

/***
 * 测试：线程的礼让
 */
class Runnable_yield implements Runnable{
	public void run() {
		for(int i=0;i<5;i++){
			System.out.println(Thread.currentThread().getName()+" 线程(测试线程的礼让)运行-->"+i);
			if(i==3){
				System.out.println(Thread.currentThread().getName()+" 线程的礼让：=======");
				Thread.currentThread().yield();//线程的礼让
			}
		}
		
	}
}












