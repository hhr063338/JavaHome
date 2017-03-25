package example.date;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Timer;

/**
 * 在java中如何获取本机当前时间 ？要满足以下要求：
	1、代码越简单越好
	2、需要用system.out println打印出来
	3、打印的结果一秒自动更新一次
 * @author Administrator
 *
 */

public class ListenDate {

	public static void main(String[] args) 
	{ 
		ActionListener time = new ActionListener() {  // 监听事件,不然实现不了动态改变时间
			
		public void actionPerformed(ActionEvent e) { 
	//date对象代表当前的系统时间(毫秒) 
			Date date = new Date(); 
	//format对象是用来以指定的时间格式格式化时间的 
			SimpleDateFormat from = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //这里的格式可以自己设置 
	//format()方法是用来格式化时间的方法 
			String times = from.format(date); 
			System.out.println(times); 
			System.out.println("是吗");
				} 
			}; 
		Timer tim = new Timer(1000, time); //这里表示1000毫秒更新一下时间 ,导入的javax.swing.Timer
		tim.start(); //启动
	 } 
}
