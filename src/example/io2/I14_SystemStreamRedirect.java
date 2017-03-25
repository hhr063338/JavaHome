package example.io2;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;

import tool.ToolUtil01;

/***
 * <ul>
 * <li>文件名称: I14_SystemStreamRedirect.java</li>
 * <li>功能描述: 对System支持的输入流输出流重定向</li>
 * </ul>
 */
public class I14_SystemStreamRedirect {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		I14_SystemStreamRedirect i14=new I14_SystemStreamRedirect();
		PrintStream out=System.out;
		InputStream in=System.in;
		PrintStream err=System.err;
		//对system.out输出重定向
		i14.setSystemOut();
		//恢复原来的输出对象
		System.setOut(out);
		//重定向保存用户信息
		i14.saveUserInfo();
		//恢复原来的输出对象
		System.setOut(out);
		//对system.err重定向
		i14.setSysEorr();
		System.setErr(err);
		//对system.in的重定向
		i14.setSysIn();
		System.setIn(in);
		
		

	}
	
	/***
	 * 范例：为System.out输出重定向
	 * @param out
	 */
	private void setSystemOut() throws Exception{
		System.out.println("========执行setSystemOut()方法=======");
		String filepath=queryPath()+"I14_SystemStreamRedirect.txt";
		//system.out输出重定向
		System.setOut(new PrintStream(new FileOutputStream(filepath,true)));
		System.out.println(ToolUtil01.getDateToStr(new Date())+" :System类是不是输出重定向了!");//输出时不再向屏幕输出了,而是在指定文本中输出
	}
	
	/****
	 * 范例：为用户保存错误信息
	 * @throws Exception
	 */
	private void saveUserInfo() throws Exception{
		System.out.println("========执行saveUserInfo()方法=======");
		String str="welcome to my world!!!";
		try{
			System.out.println(Integer.parseInt(str));
		}catch (Exception e) {
			try {
				System.setOut(new PrintStream(new FileOutputStream(queryPath()+"I14_SystemStreamRedirect.log",true)));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			System.out.println(ToolUtil01.getDateToStr(new Date())+e);
		}
		
	}
	
	/***
	 *  范例：为system.err重定向
	 *  补充：以下操作，将System.err的输出定位到内存输出流，
	 *  	所以此时使用System.err完成的各个输出操作的输出结果都保存到内存中
	 * 
	 */
	private void setSysEorr() throws Exception{
		System.out.println("========执行setSysEorr()方法=======");
		//定义内存输出流
		ByteArrayOutputStream bos=null;
		//实例化内存输出流
		bos=new ByteArrayOutputStream();
		//为system.err输出重定向
		System.setErr(new PrintStream(bos));
		//错误输出时，不再向屏幕上输出
		System.err.println(ToolUtil01.getDateToStr(new Date())+"www.mldnjava.cn,李兴华");
		System.out.println(bos);//打印错误信息
		
	}
	
	/***
	 * 范例：设置System.in的输入重定向
	 * 补充：代码修改了System.in的输入的位置，而将其输入重定向到文件中读取，所以读取时会将
	 * 	   文件中的内容读取进来
	 */
	private void setSysIn() throws Exception{
		
		System.out.println("========执行setSysIn()方法=======");
		
		//设置输入重定向
		System.setIn(new FileInputStream((queryPath()+"I14_SystemStreamRedirect.txt")));
		//从文件中接收数据
		InputStream input=System.in;
		byte[] b=new byte[1024];
		int len=0;
		StringBuffer sb=new StringBuffer();
		while((len=input.read(b))!=-1){
			sb.append(new String(b,0,len));
		}
		System.out.println("输入的内容："+sb.toString());
	}
	
	
	
	
	
	
	/**
	 * 获取文件文本存放路径
	 */
	private String queryPath() throws Exception{
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
