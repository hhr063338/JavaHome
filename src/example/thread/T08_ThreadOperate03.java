package example.thread;

/**
 * <ul>
 * <li>文件名称: T08_ThreadOperate03.java</li>
 * <li>文件描述: 线程的强制运行、休眠、中断</li>
 * </ul>
 */
public class T08_ThreadOperate03 {


	public static void main(String[] args) throws Exception{
		T08_ThreadOperate03 operate=new T08_ThreadOperate03();
		//测试join强制执行
		//operate.haveToRun();
		//测试休眠
		//operate.sleepThread();
		//测试线程中断
		operate.interruptThread();
	}
	
	/**title：线程的强制运行
	 * content：在线程操作中,可以使用join()方法让一个线程强制运行,线程强制运行期间，其他线程无法运行,
	 *          必须等到此线程完成
	 */
	private void haveToRun() throws Exception{
		Runnable_join t08_runnable=new Runnable_join ();
		Thread thread01=new Thread(t08_runnable,"线程01");
		System.out.println("****开始展示‘线程的强制运行’*******");
		thread01.start();
		for(int i=0;i<50;i++){
			if(i>10){
				try{
					thread01.join();//强制执行thread01线程，其他线程暂且搁置					
				}catch(Exception e){}
			}
		System.out.println(Thread.currentThread().getName()+" 线程在运行");
		
		}			
	}
	/**title:线程的休眠
	 * content：在程序中允许一个线程暂时的休眠，直接使用Thread.sleep()方法即可实现休眠
	 * notice:线程原本是要休眠10秒，但在主线程启动后两秒后就将其中断，休眠一旦中断将执行catch中的代码
	 */
	private void sleepThread() throws Exception{
		System.out.println("****测试线程的休眠***");
		Runnable_sleep runnable02=new Runnable_sleep();
		Thread thread02=new Thread(runnable02," 线程(测试休眠)");
		thread02.start();
	}
	
	/**title  ：线程中断
	 * content：当一个线程运行时，另外一个线程可以直接通过interrupt（）方法直接中断其运行状态
	 */
	private void interruptThread() throws Exception{
		Runnable_suspend runable03=new Runnable_suspend();
		Thread tread03=new Thread(runable03," 线程(测试中断)");
		tread03.start();
		try{
			Thread.sleep(1000);
		}catch(Exception e){}
		tread03.interrupt();//中断执行线程程序
	}
}

/**
 * 用于测试 线程强制执行
 */
class Runnable_join implements Runnable{
	public void run() {
		for(int i=0;i<50;i++){
			System.out.println(Thread.currentThread().getName()+" 线程在运行-->"+i);
		}
	}
}
/***
 * 用于线程休眠
 */
class Runnable_sleep implements Runnable{
	public void run() {
		for(int i=0;i<5;i++){
			try{
				Thread.sleep(500);//线程休眠，间隔500ms
			}catch(Exception e){}
			System.out.println(Thread.currentThread().getName()+" 线程运行,i="+i);
			
		}
		
	}
}
/**
 * 线程中断
 */
class Runnable_suspend implements Runnable{
	public void run(){
		System.out.println("1.进入run方法");
		try{
			Thread.sleep(10000);
			System.out.println("2、已经完成休眠");
		}catch (Exception e) {
			System.out.println("3、休眠被终止");
			return ;
		}
		System.out.println("run方法正常结束");
	}
}

