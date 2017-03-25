package example.io2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import tool.ToolUtil01;

/**
 * <ul>
 * <li>文件名称: I16_Scancer01.java</li>
 * <li>功能描述: </li>
 * </ul>
 */
public class I16_Scancer01 {
	
	ToolUtil01 tool=new ToolUtil01();
	/*** Scancer类 java.util.Scancer
	 * JDK 5.0以后提供了专门的输入数据类,此类不只可以完成输入数据的操作，也可以方便地对输入的数据进行验证
	 * Scancer类通过public Scancer(InputStream in) 表示只要是字节输入流的子类都可以构造Scancer对象
	 * 
	 * 
	 */
	public static void main(String[] args) {
		
		I16_Scancer01 i16=new I16_Scancer01();
		//基本数据的输入——Scancer.next()
		//i16.inputData01();
		//基本数据的输入——分隔符变更
		//i16.inputData02();
		//输入并获取int float
		//i16.inputIntFloat();
		//输入数据，判断是否是时间类型，规定格式yyyy-mm-dd
		//i16.dealDate();
		//读取文件中的数据
		i16.dealFileData();
		
	}

	/*** 范例：实现基本的数据输入
	 *   补充：最简单的数据输入直接使用Scancer类的next()方法
	 *	 注意：next()方法是将空格符当做一个分隔符
	 *   测试码：hello world
	 */
	private void inputData01(){
		Scanner scan=new Scanner(System.in);//以键盘输入流为构造参数，构建scancer对象
		System.out.println("请输入数据：");
		String str=scan.next();//读取输入的数据
		System.out.println("输入的数据为："+str);		
	}
	
	/*** 范例：修改数据的分隔符
	 *   scancer.next()方法的分隔符是空格即读取到空格完，可更改为‘\n’换行
	 *   
	 */
	private void inputData02(){
		Scanner scan=new Scanner(System.in);//以键盘输入流为构造参数，构建scancer对象
		System.out.println("请输入数据：");
		scan.useDelimiter("\n");//修改输入数据的分隔符
		String str=scan.next();
		System.out.println("输入的数据为："+str);
	}
	
	/*** 范例：输入int float
	 *   如果此时更改分隔符，那么读取到的是 实数+分隔符
	 */
	private void inputIntFloat(){
		Scanner scan=new Scanner(System.in);//以键盘输入流为构造参数，构建scancer对象
		System.out.println("请输入实数：");
		//scan.useDelimiter("\n");//修改输入数据的分隔符,若是变更该分隔符可能会一起识别分隔符
		int i=0;
		float j=0.0f;
//		byte[] bs=scan.next().getBytes();
//		for(byte b:bs){
//			//char c=(char)b;
//			System.out.println(b);
//		}
		//System.out.println(scan.next());
		if(scan.hasNextInt()){
			i=scan.nextInt();//在获取之前最好用hasNextInt()方法判断，否则会出现异常java.util.InputMismatchException
			System.out.println("输入的实数是："+i);
		}else if(scan.hasNextFloat()){
			j=scan.nextFloat();
			System.out.println("输入的实数是："+j);
		}else{
			System.out.println("请正确输入实数!!!");
		}		
	}
	
	/***范例：实现日期格式的数据输入
	 *  功能描述：自定义接收“yyyy-MM-dd”格式的为Date类型
	 *  在Scancer类中没有提供专门的日期格式输入操作，所以，若果想得到一个日期类型的数据，
	 *  则必须自己编写正则验证，并手工转换
	 *  注意：如果更改分隔符，注意末位正则表达式要计算在内，如果分隔符为回车，那么匹配的正则表达式末加“\r”
	 *  
	 */
	private void dealDate(){
		
		Scanner scan=new Scanner(System.in);
		scan.useDelimiter("\\n");
		System.out.println("请正确输入yyyy-mm-dd格式的日期：");
		if(scan.hasNext("\\d{4}-\\d{2}-\\d{2}\\r?")){
			String strDate=scan.next();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date date=null;
			try {
				date=sdf.parse(strDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			System.out.println(date);
		}else{
			System.out.println(scan.next().matches(".*\\n{1}$"));
			System.out.println("请正确输入时间（格式：yyyy-mm-dd）");
		}
	}
	
	/***范例：从文件中读取数据
	 *  补充：如果从文件直接读取数据，可以将File类的实例传入到Scancer类的构造函数直接获得scan对象
	 *		 
	 */
	private void dealFileData(){
		String readFilePath=null; 
		try {
			readFilePath=tool.queryPath()+"I14_SystemStreamRedirect.txt";
					
		} catch (Exception e) {
			// TODO: handle exception
		}
		File readFile=new File(readFilePath);
		Scanner scan=null;
		try {
			scan=new Scanner(readFile);
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		}
		
		if(scan.hasNext()){
			
			System.out.println("该文件的内容：");
			System.out.println(scan.nextLine());
			while(scan.hasNext()){
				System.out.println(scan.nextLine());
			};
		}else{
			System.out.println("该文件没有内容!");
		}
		
		
	}
	
	
}
