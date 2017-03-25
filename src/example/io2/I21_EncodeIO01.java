package example.io2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import tool.ToolUtil01;

/***
 * <ul>
 * <li>文件名称: I21_EncodeIO01.java</li>
 * <li>功能描述: 字符编码</li>
 * </ul>
 */
public class I21_EncodeIO01 {

	ToolUtil01 tool=new ToolUtil01();
	
	/**** java 常见编码简介***/
	/*** 
	 * ISO8859-1：属于单字节编码，最多只能表示0~255的字符范围，主要在英文上应用
	 * GBK/GBK2312：中文的国际编码，专门用来表示汉字、是双字节编码，如果在此编码中出现中文，
	 *   则使用ISO8859-1编码，GBK可以表示简体中文和繁体中文，而GBK2312只能表示简体中文，GBK兼容GBK2312
	 * unicode：Java中使用此编码方式，是最标准的一种编码，使用十六进制表示编码，但此编码不兼容ISO8859-1
	 * UTF:由于unicode不兼容ISO8859-1编码，而且容易占用更多的空间，而且对于英文字母也使用两个字节编码，
	 *    这样使用unicode不便于传输和存储，因为产生UTF编码。UTF编码兼容了ISO8859-1编码，
	 *    同时也可以用表示所有的语言字符，不过UTF编码是不定长编码，每一个字符的长度为1~6个字节不等，
	 *    一般在中文网页使用此编码，可以节省空间
	 * 
	 */	
	public static void main(String[] args) throws Exception {
		
		I21_EncodeIO01 i21=new I21_EncodeIO01();
		System.out.println("===执行getEncodeByLocal()获取本机的编码==");
		i21.getEncodeByLocal();
		System.out.println("===执行使用ISO8859-1编码进行输出==");
		i21.setEncodeISO();
	}
	
	/***范例：得到本机的编码显示==得到JVM的默认编码
	 * 
	 */
	private void getEncodeByLocal() throws Exception{
		String localEncode=System.getProperty("file.encoding");//获得当前系统编码
		System.out.println("系统默认编码："+localEncode);
	}
	
	
	/***范例：使用ISO8859-1编码
	 *  描述：本地默认编码是GBK，如果要实现编码转换，可以使用String类中的getBytes(String charset)方法，
	 *  	此方法可以设置指定的编码
	 * @throws Exception
	 */
	private void setEncodeISO() throws Exception{
		
		String filepath=tool.queryPath()+"I21_EncodeIO.txt";
		File file=new File(filepath);
		OutputStream  output=new FileOutputStream(file);
		//byte[] b="中国,你好".getBytes("ISO8859-1");
		byte[] b="中国,你好".getBytes("utf8");
		output.write(b);
		output.close();
		//因为编码不一致，保存时出现乱码，乱码的产生就有一个原因，即输出内容的编码（例如:程序的指定）
		//与接收内容的编码（如本机环境默认）不一致
	}
	

}
