package example.thread;

/**
 * 
 * <ul>
 * <li>文件名称: T07_ThreadOperate02.java</li>
 * <li>文件描述: 判断线程是否启动</li>
 * </ul>
 */
public class T07_ThreadOperate02 implements Runnable{
	public void run() {
		String name=Thread.currentThread().getName();//获取当前线程的名称
		for(int i=0;i<3;i++){
			System.out.println(name+"运行，i="+i);
		}	
	}
	
	public static void main(String[] args) {
		T07_ThreadOperate02 runnable01=new T07_ThreadOperate02();
		Thread thread01=new Thread(runnable01);
		System.out.println("**T07_ThreadOperate02测试判断线程是否启动*******");
		System.out.println(thread01.getName()+"线程是否正在运行："+thread01.isAlive());
		thread01.start();
		System.out.println(thread01.getName()+"线程已经启动，是否正在运行："+thread01.isAlive());
		for(int i=0;i<3;i++){
			System.out.println(Thread.currentThread().getName()+"线程(main)运行-->"+i);
		}
		System.out.println("代码执行之后,"+thread01.getName()+"线程还在运行:"+thread01.isAlive());//多线程，结果不确定

	}

}
