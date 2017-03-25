package example.io2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * <ul>
 * <li>文件名称: I09_MemoryStreamOperate01.java</li>
 * <li>功能描述: 内存操作流 的使用与用途</li>
 * </ul>
 */
public class I09_MemoryStreamOperate01 {

	/***
	 * 前几章讲解的程序中输入输出都是从文件中来的，当然，也可以将输入输出的位置设置在内存上
	 * 此时就要用 ByteArrayInputStream/ByteArrayOutputStream来完成输入输出功能
	 */
	public static void main(String[] args) throws Exception{
		I09_MemoryStreamOperate01 i09=new I09_MemoryStreamOperate01();
		i09.lowerToUpper();
	}
	
	/** 范例：使用内存操作流完成一个大写字母转换为小写字母的程序
	 * 
	 * @throws Exception
	 */
	private void lowerToUpper() throws Exception{
		
		String upperCase="HENRY";
		System.out.println("要转换的字符："+upperCase);
		ByteArrayInputStream bis=null;//声明一个内存输入流
		ByteArrayOutputStream bos=null;//声明一个内存输出流
		bis=new ByteArrayInputStream(upperCase.getBytes());//向内存中输入内容
		bos=new ByteArrayOutputStream();//准备从ByteArrayOutputStream中读取数据
	
		int temp=0;
		while((temp=bis.read())!=-1){
			char c=(char)temp;
			bos.write(Character.toLowerCase(c));//将字符变小写			
		}
		String newStr=bos.toString();//取出内容
		try {
			bis.close();
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("转换为小写："+newStr);
		/*** 注意 内存操作流的用途
		 * 1.内存操作流一般在生成一些临时信息时才会使用，而这些临时的信息如果保存在文件中，则代码
		 *   执行完后肯定还要删除这个临时文件，那么此时使用内存操作流是最合适的
		 */
	}
	

}
