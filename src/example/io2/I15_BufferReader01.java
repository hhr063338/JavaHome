package example.io2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <ul>
 * <li>文件名称: I15_BufferReader01.java</li>
 * <li>功能描述: 介绍BufferedReader类的使用</li>
 * <li>补充： 该类是用于从缓冲区中读取内容，所有的输入字节数据都放在缓冲区中</li>
 * </ul>
 */
public class I15_BufferReader01 {

	/*** BufferReader类常用的方法
	 * public BufferReader(Reader in) 接受一个Reader类的实例
	 * public String readLine() throws IOException 一次性从缓冲区中将内容全部读取进来
	 * @param args
	 */
	/*** BufferReader方法使用提示：
	 *   它只能接收字符流的缓冲区，因为每一个中文要占两个字节，所以需要将System.in这个字节输入流变为字符输入流
	 */
	public static void main(String[] args) throws Exception {
		I15_BufferReader01 i15=new I15_BufferReader01();
		i15.getSysInToBufferRead();
	}
	
	/*** 范例：从键盘输入数据
	 *  描述：实例BufferedReader来读取数据
	 *  评价：可以发现,程序非但没有了长度的限制，也可以正确接收中文了，这就是键盘输入数据的标准格式
	 * @throws IOException
	 */
	private void getSysInToBufferRead() throws IOException{
		//声明BufferedReader对象
		BufferedReader buf=null;
		//实例化BufferedReader，接收输入内容
		buf=new BufferedReader(new InputStreamReader(System.in));
		
		String str=null;
		System.out.println("请输入内容:");
		try {
			str=buf.readLine();//读取输入内容
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("输入的内容为:"+str);
	}
}
