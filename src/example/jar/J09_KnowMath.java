package example.jar;

import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

/**
 * 
 * @author Administrator
 *
 */
public class J09_KnowMath {
	
	public static void main(String[] args) {
		J09_KnowMath j9=new J09_KnowMath();
		//1.Math类
		j9.compulate();
		//2.Random类
		j9.recordRandom();
		//3.NumberFormat类
		j9.recordNumberFormat();
		//4.DecimalFormat
		j9.recordDecimalFormat();
		
		
	}
	/**
	 * 1.Math类
	 */
	public void compulate(){
		System.out.println("***********Math类中常用的方法********************");
		//Math类中的方法都是静态方法，直接使用“类名.方法名称()”的形式调用
		System.out.println("求平方根:"+Math.sqrt(4.0));
		System.out.println("求两数最大值:"+Math.max(3.5, 7.8));
		System.out.println("求两数最小值:"+Math.min(2.3, 2.34));
		System.out.println("2的三次方:"+Math.pow(2, 3));
		System.out.println("四舍五入:"+Math.round(33.6));
		//Math.round的四舍五入会将小数点后面的数字都忽略掉，如果想精确到小数点后的准确位数，
		//则必须使用BigDecimal类完成
	}
	/**
	 * 2.Random类是随机产生类，可以指定一个随机数的范围，然后产生在此范围中的数字
	 * public boolean nextBoolean() 随机产生boolean值；public double nextDouble()随机产生double值
	 * public float nextFloat();public int nextInt();public long nextLong();
	 * public int nextInt(int)随机生成给定最大值的int值
	 */
	public void recordRandom(){
		System.out.println("******************Random类的使用**************************");
		//范例：生成10个随机数字，且字数不大于100
		Random r=new Random();
		for(int i=0;i<10;i++){
			System.out.println(r.nextInt(100));
		}
	}
	/* NumberFormat类的常用方法
	 * public static Locale[] getAvailableLocales()	返回所有语言环境的数组
	 * public static final	NumberFormat getInstance() 返回当前默认语言的数字格式
	 * public static NumberFormat getInstance(Locale inLocale)	返回指定语言环境的数字格式
	 * public static final NumberFormat getCurrenctyInstance()	返回当前默认环境的货币格式
	 * public static NumberFormat getCurrencyInstance(Locale inLocale)	返回指定语言环境的数字格式
	 * 
	 */
	/**
	 * 3.NumberFormat类的基本使用
	 * 	 表示数字的格式化类，即可以按照本地的风格习惯进行数字的显示
	 *  定义：public abstract class NumberFormat extends Format
	 *  NumberFormat是抽象类，在这里可以通过它提供的静态方法为其实例化
	 *  因为操作系统是中文系统，默认是中文语言环境
	 */
	public void recordNumberFormat(){
		System.out.println("****************NumberFormat使用不同语言环境格式化数字***********************");
		NumberFormat nf=null;
//		nf=NumberFormat.getInstance(inLocale);
		nf=NumberFormat.getInstance();	//得到默认的数字格式显示
		NumberFormat nf2=NumberFormat.getInstance(new Locale("fr","FR"));
		System.out.println("格式化之后的数字:"+nf.format(1000000));
		System.out.println("格式化之后的数字:"+nf2.format(1000000));
	}
	/** 4.DecimalFormat
	 * 	NumberFormat的一个比较常用的子类DecimalFormat，主要作用是格式化数字，
	 *在格式化数字方面，比NumberFormat更方便，因为可以直接指定按用户自定义的方式进行格式化操作，
	 *与SimpleDateFormat类似，如果进行自定义格式化操作，则必须按照指定格式化操作的模板
	 */
	public void recordDecimalFormat(){
		System.out.println("**************Decimal***********************");
		DecimalFormat df=null;	//声明一个DecimalFormat对象
		String pattern1="###,###.###";
		String pattern2="000,000.000";
		String pattern3="###,###.###$";
		df=new DecimalFormat();//实例化对象
		String str1=df.format(99999999);
		System.out.println(str1);
	}
	
	
}
