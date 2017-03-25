package example.jar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/** 定时调度（Timer、TimerTask）
 *  Timer类是一种线程设施，可以用来实现在某一个时间或某一段时间后安排某一个任务执行一次或定期重复执行
 *  这功能与TimerTask配合使用，TimerTask类用来实现由Timer安排的一次或重复执行的某一个任务
 *  每一个Timer对象对应的是一个线程，因此计时器所执行的任务应该迅速完成，否则可能会延迟后续任务的执行
 *  而这些后续任务就有可能堆积在一起，等到该任务完成后才能快速连续执行
 *
 */
/**
 * 要执行具体的任务，则必须使用TimerTask类，TimerTask类是一个抽象类，如果要使用该类，需要自己建立一个类来
 * 继承此类，并实现其中的抽象方法
 */
/**	TimerTask抽象类中常用的方法
 * 
 * 
 */
public class J17_KnowTimer01 {

	public static void main(String[] args) {
		System.out.println("=============程序的主要功能是定时打印系统的当前时间========================");
		//建立测试类，进行任务调度
		Timer time=new Timer();//建立Timer类对象
		J17_TimeTask mytask=new J17_TimeTask();//定义任务
		time.schedule(mytask, 1000, 2000);//设置任务的执行,1秒后执行，每2秒重复
	}


}
//建立TimeTask的子类
class J17_TimeTask extends TimerTask{

	//执行任务的主体
	public void run() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH/mm/ss/sss");
		System.out.println("现在系统的当前时间为:"+sdf.format(date));
	}
	
}
