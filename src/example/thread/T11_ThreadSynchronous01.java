package example.thread;

/**
 * <ul>
 * <li>文件名称: T11_ThreadSynchronous01.java</li>
 * <li>文件描述: 同步与死锁 问题引出</li>
 * </ul>
 */
public class T11_ThreadSynchronous01 {

	/**
	 * 一个多线程的程序如果通过Runnable接口实现的，则意味着类中的属性将被多个线程共享，
	 * 那么这样一来会造成一种问题，如果这多个线程要操作同一资源时就有可能出现资源同步问题
	 * 
	 * 同步：所谓同步就是多个操作在同一个时间段内只能有一个线程进行，其他线程要等待此线程完成之后才可以
	 * 		继续进行
	 */
	public static void main(String[] args) {
		Runnable_Synchronous01 run1=new Runnable_Synchronous01();
		Thread thread1=new Thread(run1);
		Thread thread2=new Thread(run1);
		Thread thread3=new Thread(run1);
		
		thread1.start();
		thread2.start();
		thread3.start();
		//执行之后，可能会出现负数
	}
}

class Runnable_Synchronous01 implements Runnable{
	private int ticket=5;//一共五张票
	public void run() {
		for(int i=0;i<100;i++){//超出票数的循环
			if(ticket>0){
				try {
					Thread.sleep(400);//加入延迟
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("卖票：ticket="+ticket--);
			}
		}
		
	}
}
