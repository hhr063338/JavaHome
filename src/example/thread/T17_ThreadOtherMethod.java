package example.thread;

/**
 * 
 * <ul>
 * <li>文件名称: T17_ThreadOtherMethod.java</li>
 * <li>文件描述: 停止线程运行</li>
 * <li>大部分线程生命周期的方法基本已经学过，其中三个方法       suspend()/resume()/stop()</li>
 * </ul>
 */
public class T17_ThreadOtherMethod implements Runnable{
	
	private boolean flag=true; //定义标志位属性
	public void run() {
		int i=0;
		while(this.flag){	
			//while(true){//里面多嵌套这样的循环会进入死循环
				System.out.println(Thread.currentThread().getName()+"线程在运行，i="+i++);
			//}
		}
		
	}
	
	public void stop(){//编写停止方法
		this.flag=false;
	}
	/***
	 * 对于线程的 suspend():暂时挂起线程；  resume():恢复挂起进程；  stop():停止线程 
	 * 这三种方法并不推荐，因为这三种方法在操作时会产生死锁等问题，打开Thread类的源代码上，会发现这三种的方法
	 * 声明上会添加@Deprecated注释，表示此操作不建议使用
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		T17_ThreadOtherMethod run=new T17_ThreadOtherMethod();

		Thread thread=new Thread(run," 线程A ");
		//thread.setPriority(Thread.MIN_PRIORITY);
		thread.start();
		Thread.currentThread().sleep(500);
		if(Thread.currentThread().isAlive()){
			
			run.stop();
			System.out.println("====================="+run.flag+"==================================");
		}

	}


}
