package example.io2;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * <ul>
 * <li>文件名称: I10_PipedStream.java</li>
 * <li>功能描述: 管道流 的使用</li>
 * <li>功能描述: 管道流 是两个线程间的通信，由线程1通向线程2，需通过线程1的输出流进入线程2的输入流流通线程2</li>
 * </ul>
 */
public class I10_PipedStream {

	
	/** title：验证管道流——两个线程间的通信
	 *  描述：管道流的主要作用是可以进行两个线程间的通信，管道输出流与输入流：PipedOutputStream/PipedInputStream
	 *       如果要进行管道输出，则必须把输出流连接到输入流上
	 */
	public static void main(String[] args) {
		
		I10_Thread1Runnable run1=new I10_Thread1Runnable();
		I10_Thread2Runnable run2=new I10_Thread2Runnable();
		Thread thread1=new Thread(run1,"线程1");
		Thread thread2=new Thread(run2,"线程2");
		
		try {
			run1.getPos().connect(run2.getPis());//连接管道
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		thread1.start();//启动线程
		thread2.start();
		
		/***
		 * 在操作时只需要使用PipedOutputStream类中提供的
		 * connection()方法就可以将两个线程管道连接在一起，
		 * 线程启动后就可以将两个线程管道连接在一起，
		 * 线程启动后会自动进行管道的输入与输出操作
		 */
	}
	
}

/***
 * <ul>
 * <li>文件名称: I10_PipedStream.java</li>
 * <li>功能描述: 线程1 负责发送信息 </li>
 * </ul>
 */
class I10_Thread1Runnable implements Runnable{
	
	private PipedOutputStream pos=null;//管道输出流
	public I10_Thread1Runnable(){
		this.pos=new PipedOutputStream();//实例化输出流
	}
	
	public void run() {
		String str="Hello World!!!";
		try {
			this.pos.write(str.getBytes());//输出信息
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			this.pos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public PipedOutputStream getPos(){//通过线程类得到输出流
		return pos;
	}	

}
/***
 * <ul>
 * <li>文件名称: I10_PipedStream.java</li>
 * <li>功能描述: 线程2 负责接收信息</li>
 * </ul>
 */
class I10_Thread2Runnable implements Runnable{
	
	private PipedInputStream pis=null;
	public I10_Thread2Runnable(){
		pis=new PipedInputStream();//实例化输入流
	}
	
	public void run() {
		byte[] b=new byte[1024];
		int len=0;
		try {
			len=this.pis.read(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			this.pis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("接收到的内容："+new String(b,0,len));
	}
	public PipedInputStream getPis(){
		return this.pis;
	}

}