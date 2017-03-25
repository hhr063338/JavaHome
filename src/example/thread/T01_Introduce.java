package example.thread;

/***
 * <ul>
 * <li>文件名称: T01_Introduce.java</li>
 * <li>文件描述: java的多线程、线程与进程的区别</li>
 * </ul>
 */
public class T01_Introduce {

	/***
	 * Java是少数几种支持多线程的语言，可以让不同的程序块一起执行，让程序运行更为流畅，同时达到多任务处理的目的
	 */
	public static void main(String[] args) {
		
	}
	
	/***title：进程介绍
	 * 进程是程序的一次动态执行过程，经历了从代码加载、执行到完毕的一整个过程，这个过程也是进程本身从产生、
	 * 发展到最终消亡的过程。
	 * 多进程操作系统能同时运行多个进程（程序），由于cpu具备分时机制，所以每个进程都能循环获得自己的CPU时间片
	 * 由于cpu执行速度非常快，使得所有程序好像是在“同时”运行一样
	 */
	/*** title:线程介绍
	 * 多线程是实现并发机制的一种有效手段，进程和线程一样，都是实现并发的一个基本单位。线程是比进程更小的
	 * 执行单位，线程是在进程的基础上进一步划分。
	 * 所谓的多线程是指一个进程在执行过程中可以产生多个线程，这些线程可以同时存在、同时运行，一个进程可能包含
	 * 多个同时执行的线程。
	 */
}