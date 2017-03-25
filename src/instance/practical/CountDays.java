package instance.practical;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;

/**
 * calendar.getTimeInMillis()返回的是 
“当前时间，以从历元至现在所经过的 UTC 毫秒数形式。” 
 */
public class CountDays {
	 public static void main(String[] args) throws Exception {
		 CountDays c=new CountDays();
		 c.countDaysTest();
		 c.countDaysTwo();
		 c.countDaysThree();
		 
/*		 int days=0;
		 DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		 Calendar c_a=Calendar.getInstance();
		 Calendar c_b=Calendar.getInstance();
		 String begin="2013-12-08";
		 String end="2014-02-15";
		 try {
			c_a.setTime(df.parse(begin));
			c_b.setTime(df.parse(end));
			while (c_a.before(c_b)) {
				days++;
				System.out.println(days);
			}
			
		} catch (Exception e) {
			System.out.println("日期格式必须为:yyyy-MM-dd;如：2014-4-4!");
		}finally{
			System.out.println(days);
		}*/
	 }
	 
	 public void countDaysTest() throws Exception{
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
		        long to = 0;  
		         try {  
		             to = df.parse("2011-4-15").getTime();  
		         } catch (ParseException e) {  
		            e.printStackTrace();  
		        }  
		        long from = 0;  
		        try {  
		            from = df.parse("2011-8-20").getTime();  
		        } catch (ParseException e) {  
		             e.printStackTrace();  
		         }  
		        long daysnum=(from - to) / (1000 * 60 * 60 * 24);
		        System.out.println("使用countDaysTest计算两个日期天数："+daysnum);
		   }  

	 public void countDaysTwo() throws Exception{
		 DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		 Calendar start_Calendar=Calendar.getInstance();
		 Calendar end_Calendar=Calendar.getInstance();
		 String begin="2013-12-08";
		 String end="2014-02-15";
		 start_Calendar.setTime(df.parse(begin));
		 end_Calendar.setTime(df.parse(end));
		 int daysNum=getDaysBetween(start_Calendar, end_Calendar);
		 System.out.println("使用countDaysTwo计算两个日期天数："+daysNum);
	 }
	 
	 public int getDaysBetween(Calendar d1, Calendar d2) {   
		 if (d1.after(d2)) {           
			 	java.util.Calendar swap = d1;      
			 	d1 = d2;     
			 	d2 = swap;       
			 }  
		 int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
		 int y2 = d2.get(Calendar.YEAR); 
		 if (d1.get(Calendar.YEAR) != y2) {  
			 d1 = (Calendar) d1.clone(); 
			 do {        
				 days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);// 得到当年的实际天数
				 d1.add(Calendar.YEAR, 1);    
			 	} while (d1.get(Calendar.YEAR) != y2);  
			 }     
		 	return days;  
		 }
	 public void countDaysThree() throws Exception{
		 String begin="2014-03-01";
		 String end="2014-03-31";
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 Calendar startCa=Calendar.getInstance();
		 Calendar endCa=Calendar.getInstance();
		 startCa.setTime(sdf.parse(begin));
		 endCa.setTime(sdf.parse(end));
		 int  countDays=0;
		 while(startCa.before(endCa)){
			 countDays++;
			 startCa.add(Calendar.DAY_OF_YEAR, 1);
		 }
		 System.out.println("使用countDaysThree计算两个日期天数："+countDays);
	 }
}
