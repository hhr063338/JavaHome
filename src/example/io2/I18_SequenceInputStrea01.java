package example.io2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;

import tool.ToolUtil01;

/**
 * <ul>
 * <li>文件名称: I18_SequenceInputStrea01.java</li>
 * <li>功能描述: 合并流 ：主要功能是将两个文件内容合并一个文件</li>
 * <li>补充描述: 如果要实现合并流，则必须使用SequenceInputStream类</li> 
 * </ul>
 */
public class I18_SequenceInputStrea01 {

	ToolUtil01 tool=new ToolUtil01();
	//SequenceInputStream常用两个方法
	//1. public SequenceInputStream(InputStream s1,InputStream s2) 使用两个输入流对象实例化本类对象
	//2. public int available() throws IOException 返回文件大小
	public static void main(String[] args) throws Exception{
		I18_SequenceInputStrea01 i18=new I18_SequenceInputStrea01();
		i18.merge();
	}
	
	/**范例：合并两个文件
	 * 
	 */
	public void merge() throws Exception{
		//输入流1
		InputStream i1=null;
		//输入流2
		InputStream i2=null;
		//输出流
		OutputStream out=null;
		//合并流
		SequenceInputStream sis=null;
		i1=new FileInputStream(tool.queryPath()+"I02_Random.txt");
		i2=new FileInputStream(tool.queryPath()+"I04_StreamInput.txt");
		out=new FileOutputStream(tool.queryPath()+"I18_SequenceInputStrea01.txt");
		//实例化合并流
		sis=new SequenceInputStream(i1,i2);
		int temp=0;
		while((temp=sis.read())!=-1){
			out.write(temp);//循环输出内容
		}
		sis.close();
		i1.close();
		i2.close();
		out.close();
			
	}
}
