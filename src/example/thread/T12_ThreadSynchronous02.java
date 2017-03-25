package example.thread;

/**
 * <ul>
 * <li>文件名称: T12_ThreadSynchronous02.java</li>
 * <li>文件描述: 同步代码块 同步方法块</li>
 * </ul>
 */
public class T12_ThreadSynchronous02 {
	
	/**
	 * 解决资源共享的同步操作，可以使用同步代码块和同步方法两种方式
	 * 代码块：所谓的代码块就是指用“{}”括起来的一段代码，根据其位置和声明的不同，可以分为普通代码块、构造块、静态块3种
	 * 同步代码块的格式：
	 *  synchronized(同步对象){ 需要同步的代码 }
	 *  由此可见，在使用同步代码块时必须指定一个需要同步的对象，但一般都将当前对象(this)设置成同步对象
	 *  同步：所谓同步就是多个操作在同一个时间段内只能有一个线程进行，其他线程要等待此线程完成之后才可以
	 * 		继续进行
	 */
	public static void main(String[] args) {
		T12_ThreadSynchronous02 t12=new T12_ThreadSynchronous02();
		t12.synchronousBlock();
		t12.synchronousMethod();
		
	}
	
	/**
	 * 利用代码块解决 资源共享的同步问题
	 */
	private void synchronousBlock(){
		Runnable_Synchronous02 run1=new Runnable_Synchronous02();
		Thread thread1=new Thread(run1);
		Thread thread2=new Thread(run1);
		Thread thread3=new Thread(run1);
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
	/**
	 * 利用同步方法块 解决 资源共享的同步问题
	 */
	private void synchronousMethod(){
		Runnable_Synchronous02_01 run2=new Runnable_Synchronous02_01();
		Thread thread1=new Thread(run2);
		Thread thread2=new Thread(run2);
		Thread thread3=new Thread(run2);
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
}

/**
 * 同步代码块解决实现Runnable接口多线程数据同步问题
 */
class Runnable_Synchronous02 implements Runnable{
	private int ticket=5;//一共五张票
	public void run() {
		for(int i=0;i<100;i++){//超出票数的循环
		  synchronized (this) {  //设置需要同步的操作
				if(ticket>0){	 //判断是否有剩余票
					try {
						Thread.sleep(400);//加入延迟
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("  卖票(同步代码块)：ticket="+ticket--);
				}			
		  }

		}	
	}
}
/***
 * 同步方法块 解决实现Runnable接口线程数据共享出现的同步问题
 * 可以使用synchronized关键字，格式
 * 访问权限（public/private/protected/default） 访问修饰符（final/static/synchronized） 返回值类型 方法块
 */
class Runnable_Synchronous02_01 implements Runnable{
	private int ticket =5;
	public void run() {
		for(int i=0;i<5;i++){
			this.sale();
		}
		
	}
	private synchronized void sale(){//声明同步方法
		if(ticket>0){
			try {
				Thread.currentThread().sleep(300);
			} catch (Exception e) {e.printStackTrace();}
			System.out.println("卖票(同步方法块)：ticket="+ticket--);
		}
	}
}

