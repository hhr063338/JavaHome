package example.jar;
/**Runtime类与Process类
 * Runtime表示运行时操作类，是一个封装了JVM进程的操作类，每一个JVM都对应着一个Runtime类的实例
 * 此实例是由JVM运行时为其实例化，采用单例模式（构造私有化）
 * 所以Runtime r=Runtime.getRuntime();
 * 返回Runtime实例后可以用来freeMemory()查询JVM的空闲内存，maxMemory查JVM的最大内存，
 * gc()运行垃圾回收机制释放空间，exec()执行本机命令
 *
 */
public class J02_RuntimeBase01 {

	public static void main(String[] args) {
		J02_RuntimeBase01 j2=new J02_RuntimeBase01();
		//1.得到JVM的内存空间信息
		j2.getMemory();
		//2.利用Runtime打开本机的程序
		j2.execApp();
		//3.初步学习Process类
		j2.closeApp();
	}


	/**
	 * 1.得到JVM的内存空间信息
	 */
	public void getMemory(){
		System.out.println("*****************得到JVM的内存空间信息***********************");
		Runtime rt=Runtime.getRuntime();//通过Runtime静态方法为其实例化操作
		System.out.print("JVM最大内存量：");
		System.out.println(rt.maxMemory());//根据及其环境会有所不同259522560
		System.out.println("JVM空闲内存"+rt.freeMemory());//取得程序运行之前的内存空间
		String s="hello ,this is my world!";
		for(int i=0;i<1000;i++){
			s=s+i;//循环修改String，产生多个垃圾，会占用内存
		}
		System.out.println("操作String之后的，JVM空闲内存量："+rt.freeMemory());//操作String之后的，JVM空闲内存量
		rt.gc();//进行垃圾收集空间，释放资源
		System.out.println("进行垃圾回收，JVM空闲内存量："+rt.freeMemory());
	}

	/**
	 * 2.除了观察内存使用量外，也可以直接使用Runtime类运行本机的可执行程序,在这里调用本机的计算
	 * 本程序notepad.exe
	 */
	public void execApp(){
		System.out.println("****************利用Runtime类打开本机的程序*********************");
		Runtime rt=Runtime.getRuntime();
		try {
			rt.exec("notepad.exe");//调用本机程序，必须进行异常处理
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("打开记事本程序出错");
		}
	}
	/**
	 * 3.初步学习Process类，
	 * Runtime.exec()方法返回的是Process类，表示一个操作的进程类，
	 * 实际上如果一个记事本程序启动后，肯定在操作系统中增加一个进程，此过程可以通过windows任务管理器查看
	 * public void destroy();让进程消失
	 * 
	 */
	public void closeApp(){
		System.out.println("*****************初步学习Process类*******************************");
		Runtime rn=Runtime.getRuntime();
		Process pro=null;
		try {
			pro=rn.exec("calc.exe");
			Thread.sleep(5000);//让此线程存活5秒
			pro.destroy();//结束此进程
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
