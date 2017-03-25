package tool.utils;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DateUtils {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd");
	private static SimpleDateFormat calenderFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	// 获取当前日期,到天
	public static String getCurrentDate() {
		Date d = new Date();
		return dateFormat.format(d);
	}
	
	public static String dataFormat(Long time){
		if(time != null){
			return dateFormat.format(new Date(time));
		}
		return "";
	}

	// 获取当前时间,到时分秒
	public static String getCalenderTime() {
		Date d = new Date();
		return calenderFormat.format(d);
	}

	/*
	 * 当前时间转换为PHP的10位时间戳
	 */
	public static Long getCurrentTime() {
		// return new Date().getTime() / 1000;
		return System.currentTimeMillis();
	}

	/**
	 * 将指定日期转换为时间戳(PHP的时间戳是10位)
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static Long ConvertTime(String date) throws Exception {
		if (date == null) {
			return null;
		}
		// 带时分秒
		if (date.length() > 10) {
			return (calenderFormat.parse(date)).getTime();
		}
		return (dateFormat.parse(date)).getTime();
	}
	
	//获取当前日期0点0分0秒时的时间戳
	public static Long getCurrentTimeMillisFromZero(){
		Calendar cal = Calendar.getInstance();        
		cal.set(Calendar.HOUR, 0);        
		cal.set(Calendar.SECOND, 0);        
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTimeInMillis();
	}
	/**
	 * 
	 * @return
	 */
	public static Long getCurrentTimeMillisFirst(){
		Calendar cal = Calendar.getInstance();        
		cal.set(Calendar.HOUR,23);        
		cal.set(Calendar.SECOND, 59);        
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTimeInMillis();
	}
	
	// 将PHP的时间戳转换为时间,转换的时间是否要带"时分秒"
	public static String convertPHPTimestamp(String template, Long phpTimestamp) {
		if (phpTimestamp == null) {
			return null;
		}
		if(phpTimestamp.toString().length() == 10){
			phpTimestamp = phpTimestamp * 1000L;
		}
		if (template.equals("yyyy-MM-dd")) {
			//return dateFormat.format(new Date(phpTimestamp * 1000L));
			return dateFormat.format(new Date(phpTimestamp));
		} else {
			// yyyy-MM-dd HH:mm:ss
			//return calenderFormat.format(new Date(phpTimestamp * 1000L));
			return calenderFormat.format(new Date(phpTimestamp));
		}
	}

	// 当前时间加一天的时间戳
	public static Long getTimestampByAddOneDay(String date) throws Exception {
		if (date == null) {
			Calendar c = Calendar.getInstance();
			c.add(c.DATE, 1);// 把日期往后增加一天
			return ConvertTime(dateFormat.format(c.getTime()));
		} else {
			// 指点的某个日期加一天
			return null;
		}
	}

	/**
	 * 
	 * @Description: 根据时间戳（PHP）获取周几
	 * 
	 * @param time（php时间戳）
	 * @return
	 */
	public static int getWeekOfDate(long time) {
		int weekOfDate = 0;
		Calendar c = getCalendar(time);
		weekOfDate = c.get(Calendar.DAY_OF_WEEK);
		return weekOfDate;
	}

	/**
	 * 
	 * @Description: 获取时间(H:i:s)
	 * 
	 * @param time
	 *            （php时间戳）
	 * @return
	 */
	public static String getTimes(long time) {
		Calendar c = getCalendar(time);
		int hours = c.get(Calendar.HOUR_OF_DAY); // 获取当前小时
		int min = c.get(Calendar.MINUTE); // 获取当前分钟
		int seconds = c.get(Calendar.SECOND); // 获取当前秒
		return hours + ":" + min + ":" + seconds;
	}

	/**
	 * 
	 * @Description: 时间戳转换为Calendar
	 * 
	 * @param time
	 *            (time为0时默认获取当前时间)
	 * @return
	 */
	public static Calendar getCalendar(long time) {
		Calendar c = Calendar.getInstance();
		if (time != 0) {
//			time = time * 1000;
			Date date = new Date(time);
			c.setTime(date);
		}
		return c;
	}

	/**
	 * 
	 * @Description: 得到指定日期的前n小时
	 * 
	 * @param time
	 * @param n
	 * @return
	 */
	public static long getBeforeNHours(long time, int n) {
		Calendar calendar = getCalendar(time);
		long offset = n * 60 * 60 * 1000L;
		calendar.setTimeInMillis(calendar.getTimeInMillis() - offset);
		return calendar.getTimeInMillis();
	}

	/**
	 * 
	 * @Description: 得到指定时间的前n天
	 * 
	 * @param time
	 * @param n
	 * @return
	 */
	public static long getBeforeNDays(long time, int n) {
		Calendar calendar = getCalendar(time);
		long offset = n * 24 * 60 * 60 * 1000L;
		calendar.setTimeInMillis(calendar.getTimeInMillis() - offset);
		return calendar.getTimeInMillis();

	}

	/**
	 * 
	 * @Description: 得到指定时间的后n天
	 * 
	 * @param time
	 * @param n
	 * @return
	 */
	public static long getAfterNDays(long time, int n) {
//		Calendar calendar = getCalendar(time);
		long offset = n * 24 * 60 * 60 * 1000L;
//		calendar.setTimeInMillis(calendar.getTimeInMillis() + offset);
//		return calendar.getTimeInMillis();
		time = time + offset;
		return time;
	}

	/**
	 * 
	 * @Description: 得到指定日期的后n周
	 * 
	 * @param time
	 * @param n
	 * @return
	 */
	public static long getAfterNWeeks(long time, int n) {
		Calendar calendar = getCalendar(time);
		long offset = n * 7 * 24 * 60 * 60 * 1000L;
		calendar.setTimeInMillis(calendar.getTimeInMillis() + offset);
		return calendar.getTimeInMillis();
	}

	/**
	 * 
	 * @Description: 得到指定日期的前n周
	 * 
	 * @param time
	 * @param n
	 * @return
	 */
	public static long getBeforeNWeeks(long time, int n) {
		Calendar calendar = getCalendar(time);
		long offset = n * 7 * 24 * 60 * 60 * 1000L;
		calendar.setTimeInMillis(calendar.getTimeInMillis() - offset);
		return calendar.getTimeInMillis();
	}

	/**
	 * 
	 * @Description: 获取指定日期月的第一天
	 * 
	 * @param time
	 * @return
	 */
	public static long getFirstDayOfMonth(long time) {
		Calendar calendar = getCalendar(time);
		calendar.set(Calendar.DATE, 1);
		return calendar.getTimeInMillis();
	}
	
	public static long getFirstDayOfYear(long time) {
		Calendar calendar = getCalendar(time);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DATE, 1);
		return calendar.getTimeInMillis();
	}
	/**
	 * 
	 * @Description: 获取指定日期的前n月
	 * 
	 * @param time
	 * @param n
	 * @return
	 */
	public static long getBeforeNMonths(long time, int n) {
		Calendar calendar = getCalendar(time);
		calendar.add(Calendar.MONTH, -n);
		return calendar.getTimeInMillis();
	}
	
	/**
	 * 获取指定日期的后n月
	 * @param time
	 * @param n
	 * @return
	 */
	public static long getAfterNMonths(long time, int n) {
		return getBeforeNMonths(time, -n);
	}

	/**
	 * 
	 * @Description: 获取指定日期的前n年
	 * 
	 * @param time
	 * @param n
	 * @return
	 */
	public static long getBeforeNYears(long time, int n) {
		Calendar calendar = getCalendar(time);
		calendar.add(Calendar.YEAR, -n);
		return calendar.getTimeInMillis();
	}
	//当前日期的之后的N年
	public static long getAfterYears(long time, int n) {
		Calendar calendar = getCalendar(time);
		calendar.add(Calendar.YEAR, n);
		return calendar.getTimeInMillis();
	}

	/**
	 * 
	 * @Description: 自定义格式化
	 * 
	 * @param time
	 * @param format
	 * @return
	 */
	public static String getCustomFormat(long time, String format) {
		if (format == null) {
			return dateFormat.format(new Date(time));
		}
		SimpleDateFormat df = new SimpleDateFormat(format);
		Calendar calendar = getCalendar(time);
		Date date = calendar.getTime();
		return df.format(date);

	}
	public static String getCustomFormat(Date date, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(date);
		
	}
	/**
	 * 
	 * @Description: 自定义格式时间戳
	 *
	 * @param dateTime
	 * @param formatType
	 * @return
	 * @throws ParseException
	 */
	public static long getConvertCustomFormat(String dateTime,String formatType){
		if(dateTime == null){
			return -1;
		}
		if(formatType.length()>0){
			SimpleDateFormat formatDate = new SimpleDateFormat(formatType);
			try {
				return formatDate.parse(dateTime).getTime();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			return dateFormat.parse(dateTime).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return 0L;
		}
	}
	/**
	 * 
	 * @Description: 验证日期字符串是否是YYYY-MM-DD格式
	 * @author manb
	 * @date 2014-5-4
	 *
	 * @param str
	 * @return
	 */
	public static boolean isDataFormat(String str){
		  boolean flag=false;
		  //String regxStr="[1-9][0-9]{3}-[0-1][0-2]-((0[1-9])|([12][0-9])|(3[01]))";
		  String regxStr="^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
		  Pattern pattern1=Pattern.compile(regxStr);
		  Matcher isNo=pattern1.matcher(str);
		  if(isNo.matches()){
		   flag=true;
		  }
		  return flag;
		 }
	
	public static String GET_YMD_DATE(Long time){
		if(time.toString().length()==10){
			time=time*1000;
		}
		Date date = new Date(time);
		return dateFormat.format(date) ;
	}  
	
	public static String GET_YMD_HSM_DATE(Long time){
		if(time.toString().length()==10){
			time=time*1000;
		}
		Date date = new Date(time);
		return dateFormat.format(date) ;
	}
	
	
	public static void main(String[] ags){
		DateUtils  d = new DateUtils();
		/*System.out.println("星期:"+d.getWeekOfDate(d.getCurrentTime()));

	public static void main(String[] ags) {
		DateUtils d = new DateUtils();
		/*
		 * System.out.println("星期:"+d.getWeekOfDate(d.getCurrentTime())); long
		 * time = d.getCurrentTime(); long beforeNDays =
		 * d.getBeforeNYears(time,1)*1000;
		 * 
		 * System.out.println(beforeNDays); Calendar s = Calendar.getInstance();
		 * s.setTimeInMillis(beforeNDays); Date date=s.getTime();
		 * System.out.println(calenderFormat.format(date));
		 */

		/*long time = d.getCurrentTime();
		Calendar s = Calendar.getInstance();
		s.setTimeInMillis(time);
		Date date = s.getTime();

		String sf = d.getCustomFormat(time, "y-m-d H");
		System.out.println(sf);*/
//		try {
//			Long time = DateUtils.ConvertTime("2014-10-10");
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//	    	Date data = new Date();
//	    	data.setTime(time);
//	    	System.out.println(dateFormat.format(data));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		Long time = DateUtils.getCurrentTime();
		String date = DateUtils.getCustomFormat(time, "y");
		System.out.println("/////////////////:"+date);
	}
	/*
     * 获取交易日期
     */
    public static String getTrdingDate(){
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    	Date data = new Date();
		return dateFormat.format(data);
    }
}
