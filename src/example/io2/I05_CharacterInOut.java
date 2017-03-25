package example.io2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * 
 * <ul>
 * <li>文件名称: I05_CharacterInOut.java</li>
 * <li>文件描述: 用字符流读取或写入文件</li>
 * <li>创建日期: 2015-2-2  </li>
 * </ul>

 */
public class I05_CharacterInOut {

	/**
	 * title:测试执行各类方法
	 * 在程序中，一个字符等于两个字节，java提供了Reader和Writer连个专门处理字符流的方法
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		I05_CharacterInOut i05=new I05_CharacterInOut();
		//1.写入文件
		//i05.testWriter();
		//2.写入追加内容
		//i05.testFileWriter();
		i05.readFile01();

		
	}
	
	/** title: 向文件写入数据(Writer的介绍)
	 */
	public void testWriter() throws Exception{
		 // public abstract class Writer extends Object implements Appendable,Coloseable,Flushable
		 //本类是抽象类，使用时要实现子类，文件输出用FileWriter 
		System.out.println("****执行testWriter()写入文件Start******");
		
		//第一步：使用File类找到一个文件
		String filepath=queryPath()+File.separator+"I05_CharacterInOut.txt";
		File file=new File(filepath);
		if(!file.exists()){
			file.createNewFile();
		}
		
		//第二步：通过子类实例化父类对象
		Writer out=null;
		out=new FileWriter(file);
		
		//第三步：进行写操作
		String str=" Welcome to my World! \r\n no do no die (不做死就不会死)";
		out.write(str);
		
		//第四步：关闭流
		out.close();
		System.out.println("****执行testWriter()写入文件End(写入中文会乱码-待解决)********");
		//相对于字节流，好处是可以直接输出字符串，不用变为byte数组之后再输出
	}
	
	/** title: 写入追加内容 
	 * <li>content: 使用FileWriter追加文件内容</li>
	 */
	public void testFileWriter() throws Exception{
		// 构造方法：public FileWriter(File file,boolean append) throws IOException
		// 将append的值设为true，表示追加
		System.out.println("********执行testWriter()写入文件Start******");

		//第一步：使用File类找到一个文件
		String filepath=queryPath()+File.separator+"I05_CharacterInOut.txt";
		File file=new File(filepath);
		if(!file.exists()){
			file.createNewFile();
		}
		
		//第二步：通过子类实例化父类对象
		Writer out=null;
		out=new FileWriter(file,true);//第二个参数表示是否追加内容
		
		//第三步：进行写操作
		String str=" Welcome to my World! \r\n no do no die (不做死就不会死)";
		out.write(str);
		
		//第四步：关闭流
		out.close();
		
		
		System.out.println("********执行testWriter()写入文件End********");
	}
	
	
	/** title:字符输入流(Reader)
	 *  <li>从文件中读取内容</li>
	 */
	public void readFile01()throws Exception{
		 //public abstract class Reader extends Object implements Readable ,Closeable;
		 //Reader本身也是抽象类,如果现在要从文件中读取内容,则可以直接使用FileReader
		/**读取文件四步走
		 * 1.使用File类找到一个文件
		 * 2.通过子类实例化父类
		 * 3.进行读操作
		 * 4.关闭输入流
		 */
		String bootpath=queryPath();
		String filepath=bootpath+"I05_CharacterInOut.txt";
		File file=new File(filepath);
		if(!file.exists()){
			file.createNewFile();
		}
		Reader read=new FileReader(file);
		char[] chr=new char[1024];
		StringBuffer sb=new StringBuffer();
		int len=0;
		while((len=read.read(chr))!=-1){
			sb.append(new String(chr,0,len));
		}

		System.out.println(sb.toString());	
		read.close();
	}
	
	/** title:
	 * 获取文件文本存放路径
	 * <li>D:\Workspaces\learn\doc\test\</li>
	 */
	private String queryPath() throws Exception{
		//获取classpath的路径 "/D:/Workspaces/learn/bin/"
		String filepath=this.getClass().getClassLoader().getResource(".").getPath();
		//System.out.println(filepath);
		String[] paths=filepath.split("/");
		StringBuffer sb_path=new StringBuffer();
		//组建文件创建路径
		for(int i=0;i<paths.length-1;i++){
			if(null!=paths[i]&&!paths[i].trim().equals("")){	
				sb_path.append(paths[i]).append(File.separator);
			}
		}
		String directoryPath=sb_path.toString()+"doc"+File.separator+"test"+File.separator;
		//System.out.println(directoryPath);//"D:\Workspaces\learn\doc\test\"
		return directoryPath;
	}
	

	
	
}
