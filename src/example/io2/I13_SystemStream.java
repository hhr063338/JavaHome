package example.io2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/***
 * <ul>
 * <li>文件名称: I13_SystemStream.java</li>
 * <li>功能描述: System类对IO的支持</li>
 * <li>补充描述: public static final PrintStream out 对应系统标准输出，一般指显示器</li>
 * <li>补充描述: public static final PrintStream err 错误信息输出</li>
 * <li>补充描述: public static final PrintStream in  对应着标准输入，一般是键盘</li>
 * </ul>
 */
public class I13_SystemStream {

	public static void main(String[] args) throws Exception {
		//OutputStream的哪个子类为其实例化，就具备了向哪里输出的能力。如果使用了FileOutputStream则表示向文件输出
		//使用了system.out则表示向屏幕输出，这里完全显示出了java的多态性好处
		I13_SystemStream i13=new I13_SystemStream();
		boolean flag=true;
		//int i=3;
		//System.out.println((++i)-(i++)-((i++)*(++i)));
		InputStream input=System.in;
		PrintStream out=System.out;


		if(flag){
			//使用OutputStream向屏幕输出
			i13.screenInput(out);
			//使用system.in从键盘上读取数据
			i13.getKey(input);
			//使用system.in从键盘上读取数据，循环读取
			i13.getKey01(input);
		}else{

			//使用system.err输出错误信息
			i13.getEorrMsg();			
		}

		input.close();
		out.close();//注意这里的对象时system.out如果后面程序会用到就不要关闭
		


		


	}
	
	/***
	 * 范例：使用OutputStream向屏幕上输出
	 * @throws Exception
	 */
	private void screenInput(OutputStream out) throws Exception{
		System.out.println("====范例：使用OutputStream向屏幕上输出");
		//OutputStream out=System.out;

		out.write("welcome to our world !!!".getBytes());//向屏幕上输出
		System.out.println();

	}
	
	/***
	 * 范例：错误信息输出
	 * @throws Exception
	 */
	private void getEorrMsg() throws Exception{
		System.out.println("====范例：错误信息输出");
		String str="welcome to our world!!!";
		try {
			System.out.println(Integer.parseInt(str));
		} catch (Exception e) {
			System.err.println(e);
		}
		/** system.out与system.err的区别
		 *  两者都是PrintStream的实例化对象，两者都可以输出错误信息,但一般来讲system.out是将信息显示给
		 *  	用户看，而system.err的信息正相反，是不希望用户看到的会直接在后台打印，是专门显示错误的，
		 *  	在Eclipse中system.err输出的信息标红
		 * 
		 */
	}
	
	/**
	 * 范例：从键盘上读取数据
	 * @throws Exception
	 */
	private void getKey(InputStream input) throws Exception{
		System.out.println("====范例：从键盘上读取数据");
			
		//InputStream input=System.in;//从键盘接收数据
		byte[] b=new byte[1024];//开辟控件接收数据
		System.out.print("\n请输入内容:");//信息提示
		int len=input.read(b);//接收数据
		System.out.print("\n输入的内容为："+(new String(b,0,len)));
		//input.close();//关闭输出流

		
		/** 本范例的限制：
		 *  1.指定了输入数据的长度，如果现在输入的数据超出了其长度的范围，则只能输入部分数据
		 *  2.如果指定了byte数组的长度为奇数，则可能出现中文乱码
		 * 
		 */
	}
	
	/***
	 * 范例：从键盘上读取数据(另一种方式)
	 * @throws Exception
	 */
	private void getKey01(InputStream input) throws Exception{
		System.out.println("=======getKey01()=======");
		//InputStream input=System.in;
		System.out.print("请输入内容:");
		byte[] b=new byte[1024];
		int len=0;
		StringBuffer sb=new StringBuffer();
		while((len=input.read(b))!=-1){
			sb.append(new String(b,0,len));
			char c=(char)b[len-1];
			if(c=='\n'){
				break;
			}		
		}
		System.out.println("输入的内容："+sb.toString());
		//input.close();
	}
	/****
	 * 这个方法是对这个流一个一个字节的读，返回的int就是这个字节的int表示方式以下是代码片段，
	 * 经过测试当eclipse的编码为gbk时，转化出的字符串不需经过重新编码，如果eclipse的编码为utf-8时则由byte转成字符串需重新编成utf-8的
	 */
	
	/***
	 * 2.read(byte[] b)这个方法是先规定一个数组长度，将这个流中的字节缓冲到数组b中，
	 * 返回的这个数组中的字节个数，这个缓冲区没有满的话，则返回真实的字节个数，到未尾时都返回-1
	 */
	
	/***
	 * 3.read(byte[] b, int off, int len)此方法其实就是多次调用了read()方法
	 */
}
