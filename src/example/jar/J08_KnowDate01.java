package example.jar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 日期操作类
 * java.util包中的Date、Calendar以及java.text.SimpleDateFormat
 *
 */
public class J08_KnowDate01 {
	
	public static void main(String[] args) {
		J08_KnowDate01 j8=new J08_KnowDate01();
		//1.获取系统当前的时间
		j8.getCurrentTime();
		//2.获取系统当前日期
		j8.getCurrentCalendar();
		//3.格式化Date
		j8.getDate_Format();
		//4.指定显示风格
		j8.getSelectDate();
		//5.Date与String还有Date格式间的转换
		j8.dateAndString();
		//6.StringToDate
		j8.stringToDate();
		
	}
	
	/**
	 * 1.得到系统当前的时间
	 */
	public void getCurrentTime(){
		System.out.println("************得到系统当前的时间********************");
		Date date=new Date();
		System.out.println("当前日期为:"+date);
	}
	
	/**
	 * 2.取得系统的当前日期
	 * 通过GregorianCalendar子类实例化Calendar类，然后通过Calendar类中的各种常量及方法取得系统的当前时间
	 * 但如果按这种方式获取会比较复杂，可以通过其他方式获取
	 */
	public void getCurrentCalendar(){
		System.out.println("*************通过Calendar子类来获取系统的当前日期**********************************");
		Calendar c=new GregorianCalendar();//通过子类为其实例化
		System.out.println("年:"+c.get(Calendar.YEAR));
		System.out.println("月:"+(c.get(Calendar.MONTH)+1));//注意c.get(Calendar.MONTH)取得的是上个月的月数
		System.out.println("日:"+c.get(Calendar.DAY_OF_MONTH));
		System.out.println("时:"+c.get(Calendar.HOUR_OF_DAY));
		System.out.println("分:"+c.get(Calendar.MINUTE));
		System.out.println("秒:"+c.get(Calendar.SECOND));
		System.out.println("毫秒:"+c.get(Calendar.MILLISECOND));
		
	}
	
	/**
	 * 3.
	 * 通过Date类取得的时间已经是一个非常准确的时间，但其显示方式却不合国人习惯
	 * 因此可以通过DateFormat来用国人习惯展现的方式
	 * DateFormat是抽象类，但提供了一个静态方法可以直接取得本类的实例
	 */
	public void getDate_Format(){
		System.out.println("************使用DateFormat格式化时间*****************");
		DateFormat df1=DateFormat.getDateInstance();//取得日期
		DateFormat df2=DateFormat.getDateTimeInstance();//取得日期时间
		System.out.println("Date:"+df1.format(new Date()));
		System.out.println("DateTime"+df2.format(new Date()));
	}
	/**4.指定显示风格
	 * 想构建更加合理的时间，必须在DateFormat对象时传递若干个参数
	 */
	public void getSelectDate(){
		System.out.println("*********使用DateFormat来改变展示风格****************");
		//取得日期，按指定的日期格式显示
		DateFormat df1=
			DateFormat.getDateInstance(DateFormat.YEAR_FIELD,new Locale("zh","CN"));
		//取得日期与时间，设置日期和时间的显示格式
		DateFormat df2=DateFormat.getDateTimeInstance
		(DateFormat.YEAR_FIELD,DateFormat.ERA_FIELD, new Locale("zh","CN"));

		System.out.println("Date:"+df1.format(new Date()));
		System.out.println("DateTime:"+df2.format(new Date()));
		
		
	}
	/**
	 * 5.日期格式间的转换
	 * 日期格式的转换必须会使用SimpleDateFormat
	 * yyyy年MM月dd日  HH时mm分ss秒SS毫秒
	 */
	/**SimpleDateFormat常用的方法
	 * public SimpleDateFormat(String pattern) 通过指定的模板构造对象
	 * public Date pars(String source)  将一个包含日期的字符串变为Date类型
	 * public final String format(Date date)  将一个Date类型按照指定格式变为String类型
	 */
	public void dateAndString(){
		System.out.println("************日期格式间转换*********************");
		String sdate="2014-3-13 17:22:41.345";//定义日期时间的字符串
		System.out.println("旧的日期格式:"+sdate);
		//准备第一个模板，从字符串中提取日期数字
		String pat1="yyyy-MM-dd HH:mm:ss.SSS";
		//准备第二个模板，将提取后的日期数字变为指定的格式
		String pat2="yyyy年MM月dd日 HH时mm分ss秒SSS毫秒";
		//实例化模板对象
		SimpleDateFormat sdf1=new SimpleDateFormat(pat1);
		SimpleDateFormat sdf2=new SimpleDateFormat(pat2);
		Date d=null;
		try {
			//将给定的字符串中的日期提取出来
			d=sdf1.parse(sdate);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("新的日期格式:"+sdf2.format(d));//将日期变为新的格式
	}
	
	/**6.将String转换为Date
	 * 
	 */
	public void stringToDate(){
		System.out.println("**********利用SimpleDateFormat将字符串转换为Date型****************");
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日      HH时mm分ss秒SSS毫秒");
		String sdate=sdf.format(d);
		System.out.println(sdate);//将Date转换为String
		try {
			d=sdf.parse(sdate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(d);//将String转换为date
		
	}
	
	
	


}
