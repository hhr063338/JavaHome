package example.io2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

import org.junit.Test;

/**
 * <ul>
 * <li>文件名称: I08_TransformStream01.java</li>
 * <li>功能描述: 字节流与字符流的转换输入输出</li>
 * </ul>
 */
public class I08_TransformStream01 {

	/**
	 * 在java.io中除了字符流与字节流,还存在着一组 字节流--字符流 的 转换流
	 * OutputStreamWriter:是Writer的子类，将输出的字符流变为字节流，即将一个字符流的输出对象变为字节流输出对象
	 * InputStreamReader:是Reader的子类，将输入的字节流变为字符流，即将一个字节流的输入对象变为字符流的输入对象
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		I08_TransformStream01 i08=new I08_TransformStream01();
		i08.transStreamToCharOut();
		i08.transCharToStreamIn();
	}
	
	/*** 范例：将字节输出流变为字符输出流，写入文件
	 *   关键词：OutputStreamWriter
	 * @throws Exception
	 */
	private void transStreamToCharOut() throws Exception{
	   
		String testFilePath=queryPath()+"I08_TransformStream01.txt";
		File testFile=new File(testFilePath);
		
		Writer out=null;
		out=new OutputStreamWriter(new FileOutputStream(testFile),Charset.forName("utf-8"));
		
		out.write("hello world 欢迎来到我的世界!");//使用字符流输出
		out.close();
		
		
	}
	
	/***范例：将字节输入流变为字符输入流，读取文件
	 *  
	 * @throws Exception
	 */
	private void transCharToStreamIn() throws Exception{
		
		//获取文件路径并实例File对象
		String testFilePath=queryPath()+"I08_TransformStream01.txt";
		File testFile=new File(testFilePath);
		
		//将字节流变为字符流,按utf8的编码格式读取文件内容
		Reader in=new InputStreamReader(new FileInputStream(testFile),Charset.forName("utf-8"));
		
		char[] chr=new char[1024];
		int len=0;
		
		while((len=in.read(chr))!=-1){
		  System.out.print(new String(chr,0,len));	
		}
		
		in.close();
		
	}
	

	/****
	 * 读入：        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileFrom), Charset.forName("GBK")));

		写出：       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileTo), Charset.forName("UTF-8")));
	 */	
	/**
	 * 获取文件文本存放路径
	 */
	public String queryPath() throws Exception{
		//获取classpath的路径 "/D:/Workspaces/learn/bin/"
		String filepath=this.getClass().getClassLoader().getResource(".").getPath();
		String[] paths=filepath.split("/");
		StringBuffer sb_path=new StringBuffer();
		//组建文件创建路径
		for(int i=0;i<paths.length-1;i++){
			if(null!=paths[i]&&!paths[i].trim().equals("")){	
				sb_path.append(paths[i]).append(File.separator);
			}
		}
		String directoryPath=sb_path.toString()+"doc"+File.separator+"test"+File.separator;
		return directoryPath;
	}
	

}
