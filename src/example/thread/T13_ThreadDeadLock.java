package example.thread;

/**
 * <ul>
 * <li>文件名称: T13_ThreadDeadLock.java</li>
 * <li>文件描述: 死锁</li>
 * </ul>
 */
public class T13_ThreadDeadLock implements Runnable{

	private static ZhangSan zs=new ZhangSan();//实例化static型对象，数据共享
	private static LiSi ls=new LiSi();//实例化static型对象，数据共享
	private boolean flag=false;//声明标记用于判断哪个对象先执行
	
	public void run() {
		if(flag){//控制操作对象
			synchronized(zs){
				zs.say();
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			synchronized (ls) {
				zs.get();
			}
		}else{
			synchronized (ls){
				ls.say();
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			synchronized (zs) {
				ls.get();
			}
		}
		
	}
	/**
	 * 同步可以保证资源共享操作的正确性，但过多同步会产生死锁现象
	 * 死锁: 所谓的死锁是指两个线程都在等待彼此先完成，造成了程序的停滞，一般程序的死锁都是在程序运行时出现的
	 * 
	 * 本例子，两个线程都在彼此等待着对方的执行完成，这样程序就无法相信向下继续执行，从而造成了死锁的现象
	 * 
	 * notice:多个线程共享同一资源时需要进行同步，以保证资源操作的完整性，但是过多的同步就有可能产生死锁
	 */
	public static void main(String[] args) {
		T13_ThreadDeadLock run1=new T13_ThreadDeadLock();
		T13_ThreadDeadLock run2=new T13_ThreadDeadLock();
		run1.flag=true;
		run2.flag=false;
		Thread thread01=new Thread(run1);
		Thread thread02=new Thread(run2);
		thread01.start();
		thread02.start();
	}
	
	
}

class ZhangSan{
	public void say(){
		System.out.println("张三对李四说:\"你给我画，我就把书给你\"");
	}
	public void get(){
		System.out.println("张三得到画了!");
	}
}

class LiSi{
	public void say(){
		System.out.println("李四对张三说:\"你给我书，我就把画给你\"");
	}
	public void get(){
		System.out.println("李四得到书了!");
	}
}
