package example.io2;

import java.io.File;
import java.io.RandomAccessFile;

/** 
 * <ul>
 * <li>文件名称: I03_FileContentBase01.java</li>
 * <li>功能描述: 利用RandomAccessFile类读取一个文件中指定位置的数据</li>
 * </ul>
 */
public class I03_FileContentBase01 {
//	想实现读取第二个数据的功能，则每个数据的长度应该保持一致，
//	这就需要依靠RandomAccess中的几种设计模式，然后在构造方法中传递此模式
	/*
	 * 设置模式，r为只读，w为只写，rw为读写，如果使用rw声明RandomAccessFile对象时，
	 * 要写入的文件不存在，系统将自行创建
	 * public RandomAccessFile(File file,String mode) throws
	 * public RandomAccessFile(String name,String mode) throws
	 */	
	//直接抛出异常，程序中不用再抛出异常
	public static void main(String[] args) throws Exception {
		I03_FileContentBase01 i3=new I03_FileContentBase01();
		i3.writeFile();
		i3.redFile();
	}


	
	//
	//声明路径常量
	String path="D:"+File.separator+"Program Files"+File.separator+"workspace"
	+File.separator+"java_home"+File.separator
	+"learn"+File.separator+"file"+File.separator+"filecontent";
	/**
	 * 使用RandomAccessFile类对文件进行写入操作
	 */
	public void writeFile(){
		System.out.println("******** writeFile()对文件进行写入操作********************");
		File f =new File(path+File.separator+"ContentOperate.txt");//指定要操作的文件
		try {
			RandomAccessFile raf=new RandomAccessFile(f, "rw");//因为是以rw模式打开，若没有指定文件会自动创建
			String name=null;
			int age=0;
			name="zhangsan";//8位
			age=30;
			raf.writeBytes(name);	//将姓名写入文件
			raf.writeInt(age);		//将年龄写入文件中
			
			name="lisi    ";//也要8位，加四个空格
			age=31;
			raf.writeBytes(name);
			raf.writeInt(age);
			
			name="wangwu  ";//也要8位，加两个空格
			age=32;
			raf.writeBytes(name);
			raf.writeInt(age);
			
			raf.close();
			
		} catch (Exception e) {
			System.out.println("写入文件出错");
		}
		
		
		
	}

	/**
	 * 利用RandomAccessFile类对文件进行读取操作
	 */
	public void redFile() throws Exception{
		System.out.println("********redFile()对文件进行读取操作********************");
		String ff =path+File.separator+"ContentOperate.txt";//指定要操作的文件
		
		RandomAccessFile rdf=new RandomAccessFile(ff, "r");//以只读的方式实例化rdf对象
		String name=null;
		int age=0;
		byte[] b=new byte[8];	//准备空间读取数据
		rdf.skipBytes(12);
		for(int i=0;i<b.length;i++){
			b[i]=rdf.readByte();//循环读取出前8个内容
		}
		name=new String(b);
		age=rdf.readInt();
		System.out.println("第二个人的姓名："+name+",年龄："+age);
		rdf.seek(0);	//指针回到文件的开头
		b=new byte[8]; 	//准备空间读取姓名
		for(int i=0;i<b.length;i++){
			b[i]=rdf.readByte();//循环读取出前8个内容
		}
		name=new String(b);
		age=rdf.readInt();
		System.out.println("第一个人的姓名："+name+",年龄："+age);
		rdf.skipBytes(12);//跳过第一个人的信息
		b=new byte[8]; 	//准备空间读取姓名
		for(int i=0;i<b.length;i++){
			b[i]=rdf.readByte();//循环读取出前8个内容
		}
		name=new String(b);
		age=rdf.readInt();
		System.out.println("第三个人的姓名："+name+",年龄："+age);
		
		
		
	}


}



