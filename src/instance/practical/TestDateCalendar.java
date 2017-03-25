package instance.practical;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DayDV;

/****
 * <title>主要介绍通过Calendar类取得本周一、周日/本月第一天/本月最后一天
 * <ul>
 * </ul>
 * @author honghr
 * @version 1.0.0
 */
public class TestDateCalendar {

	/*
	 * 字符串，Date，Calendar三者之间的转换关系
	 * 
	 * String ---SimpleDateFormat.parse()---> Date
	 * Date   ---Calendar.setTime()---> Calendar
	 * Calendar ---Calendar.getTime()---> Date
	 * Date   ---SimpleDateFormat.format() --->String
	 */	
	public static void main(String[] args) throws Exception{
		//TestDateCalendar testdate=new TestDateCalendar();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date casualDate=sdf.parse("2012-02-24");
		System.out.println("Calendar的基础操作:"+
				TestDateCalendar.getCaldendarBaseOperator(casualDate));
		
		
		System.out.println("取得本周一:"+TestDateCalendar.getMondayOfThisWeek());
		System.out.println("取得本周日:"+TestDateCalendar.getSundayOfThisWeek());
		System.out.println("取得本月第一天:"+TestDateCalendar.getFristDateOfMonth());
		System.out.println("取得本月最后一天:"+TestDateCalendar.getLastDateOfMonth());
		
	}
	
	
	/*****
	 * Calendar的基本用法
	 */
	public static String getCaldendarBaseOperator(Date date) throws Exception{
		  //通过工厂方法获取实例  推荐做法
		  Calendar calendar = Calendar.getInstance();//默认是当前日期,因为Calendar是抽象类，可以new GregorianCalendar()方式实现
		  //System.out.println("默认情况下创建的Calendar表示的是当前系统时间\n"+calendar);

		  //将Calendar转换为Date对象
		  //Date currentdate=calendar.getTime();
		  
		  //设置日历中的日期对象
		  if(date==null){
			  calendar.setTime(new Date());
		  }else{
			  calendar.setTime(date);
		  }
		  
		  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		  //获得设置的日期在当周的第几天（默认星期日为第一天,值为1）
		  int casualWeekNum=calendar.get(Calendar.DAY_OF_WEEK);
		  int casualMonNum=calendar.get(Calendar.DAY_OF_MONTH);
		  int casualYearNum=calendar.get(Calendar.DAY_OF_YEAR);		  
		  	
		  System.out.println("设置的日期为"+sdf.format(calendar.getTime())
				  +",是当周的第"+casualWeekNum+"天,"
				  +"是当周的星期"+(casualWeekNum==1?7:casualWeekNum-1)+","
				  +"是当月的第"+casualMonNum+"天,"
				  +"是当年的第"+casualYearNum+"天");

		  //取得年月日
		  //Calendar获取其表示的时间中某个时间单位的值 使用的是一个统一的方法
		  //int get(int field) 该参数对应Calendar提供的若干常量，每个常量表示一个 不同的时间单位
		  int year=calendar.get(Calendar.YEAR);
		  int month=calendar.get(Calendar.MONTH)+1;//获取到的月份是从0开始到11
		  int monthday=calendar.get(Calendar.MONDAY);
		  System.out.println("设置的日期为 "+sdf.format(calendar.getTime())
				  +",是"+year+"年"+month+"月");
		  /*
		   * Calendar里对应的星期几其实是一周的第几天！而不是星期几！里面有相应方法可以设置一周第一天是星期几的方法！
		   *因为不同国家，第一天是星期几不一样，所以要想判断是不是星期一，一般是这样的
		   *if(cal.get(Calendar.dayOfWeek)==Calendar.MONDAY）{      }
		   *而不是用cal.get(Calendar.dayOfWeek)==1
		   */
		  
			/*void set(int field,int value)
			 * 设置当前Calendar的指定时间分量的值
			 */
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month-1);
			calendar.set(Calendar.DAY_OF_MONTH, casualMonNum);
			/*当给定的时间分量对应的值超出了当前时间分量所允许的
			 * 最大值时，会自动进位
			 */
			//calendar.set(Calendar.DAY_OF_MONTH, 32);
			
			/*
			//设置为1号
			calendar.set(Calendar.DAY_OF_MONTH, 1);			
			//再减去1天即可  减法只需要传入负数即可
			calendar.add(Calendar.DAY_OF_YEAR, -1);
			*/
			
			/*Calendar支持一个方法，可以获取给定时间分量所允许的最大值
			 * int getActualMaximum(int field)
			 */
			int maxDayMonth= calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			System.out.println(year+"年"+month+"月的月底是:"+maxDayMonth+"号");			
					  
		return "";
	}
	/**
	  * 得到本周周一
	  * @return yyyy-MM-dd
	  */
	 public static String getMondayOfThisWeek() throws Exception{
	  
	  //通过工厂方法获取实例  推荐做法
	  Calendar calendar = Calendar.getInstance();//默认是当前日期,因为Calendar是抽象类，可以new GregorianCalendar()方式实现
	  
	  //取得今天的星期值(以星期日为第一天,设置的时间为这周的第几天)
	  int dayofweekEn = calendar.get(Calendar.DAY_OF_WEEK) ;
	  int dayofweek=dayofweekEn-1;//以星期一为第一天,取得设置的时间为第几天
	  
	  //判断是否设置的日期是否为星期天,是的话,dayofweek为7
	  if (dayofweek == 0){
	   dayofweek = 7;
	  }
	  calendar.add(Calendar.DATE, -dayofweek + 1);//将日历中的日期对象修改
	  //c.add(Calendar.DATE, 0);
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	  //calendar.getTime();//返回日历中的日期对象Date
	  return sdf.format(calendar.getTime());
	 }
	 /***
	 * Calendar类是一个抽象类，在实际使用时实现特定的子类的对象。由于Calendar类是抽象类，且Calendar类的构造方法是protected的，所以无法使用Calendar类的构造方法来创建对象，API中提供了getInstance方法用来创建对象。
	 * 如创建一个代表系统当前日期的Calendar对象
	 * Calendar c = Calendar.getInstance();//默认是当前日期
	 ****/
	 /**
	  *得到本周周日 
	  * @return yyyy-MM-dd
	  */
	 public static String getSundayOfThisWeek() {
	  Calendar c = Calendar.getInstance();
	  int dayofweek = c.get(Calendar.DAY_OF_WEEK) ;
	  c.add(Calendar.DATE, -dayofweek + 1);
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	  return sdf.format(c.getTime());
	 }	 
	 
	 /**
	  * 得到本月最后一天
	  * @return
	  */
	 public static String getLastDateOfMonth()
	 {
	  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	  Date dt = new Date();
	  if (dt == null)
	   return null;
	  Calendar cal = Calendar.getInstance();
	  cal.setTime(dt);
	  int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	  cal.set(Calendar.DAY_OF_MONTH, days);
	  String result = format.format(cal.getTime());
	  System.out.println("一个月最后一天" + result);
	  return result;
	 }
	 
	 /**
	  * 得到本月第一天
	  * 
	  */
	 public static String getFristDateOfMonth()
	 {
	  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	  Date dt = new Date();

	  if (dt == null)
	   return null;
	  Calendar cal = Calendar.getInstance();
	  cal.setTime(dt);
	  int days = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
	  cal.set(Calendar.DAY_OF_MONTH, days);
	  String result = format.format(cal.getTime());
	  System.out.println("一个月第一天" + result);
	  return result;
	 }	 
}
