package example.io2;

import java.io.ByteArrayInputStream;
import java.io.PushbackInputStream;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

/***
 * <ul>
 * <li>文件名称: I20_PushBackInputStream01.java</li>
 * <li>功能描述: 回退流</li>
 * <li>功能描述: 在java中提供一种回退输入流(PushbackInputStream/ PushbackReader)，可以把读取进来
 * 的某些不需要的数据重新回退到输入流的缓冲区</li>
 * </ul>
 */
public class I20_PushBackInputStream01 {

	public static void main(String[] args) throws Exception {
		
		I20_PushBackInputStream01 i20=new I20_PushBackInputStream01();
		
		i20.backInput01();
	}
	
	/** 范例：操作回退流
	 * 描述 ：对于不需要的数据可以使用unread()方法将内容重新送回到输入流的缓冲区。
	 * 下面以pushbackinputstream进行详解
	 * 现象：现在内存中有一个“www.mldnjava.cn”字符串，只要输入的内容是“.”则执行回退操作，即不读取“.”
	 *      为了看清楚哪些内容是被回退的，将回退部分打印输出
	 * @throws Exception
	 */
	private void backInput01() throws Exception{
		System.out.println("====操作回退流基本操作backInput01()================");
		String str="www.mldnjava.cn";
		//定义回退流对象
		PushbackInputStream push=null;
		//定义内存输入流
		ByteArrayInputStream bai=null;
		//实例化内存输入流对象、回退流对象
		bai=new ByteArrayInputStream(str.getBytes());
		push=new PushbackInputStream(bai);
		System.out.println("读取之后的数据为：");
		//接收数据、读取内容
		int temp=0;
		while((temp=push.read())!=-1){
			if(temp=='.'){
				push.unread(temp);
				temp=push.read();
				System.out.print("(退回"+(char)temp+")");
				
			}else{
				System.out.print((char)temp);//输出内容
			}
		}
		System.out.println("\n******操作回退流基本操作backInput01()******执行完毕");
		
	}
	
	

}
