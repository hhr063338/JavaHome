package example.io2;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * <ul>
 * <li>文件名称: I02_RandomAccessFiles.java</li>
 * <li>功能名称: 用RandomAccessFile类进行读写文件</li>
 * </ul>
 */
public class I02_RandomAccessFiles {
	

	/***
	 * File类只能针对文件本身进行操作，如果要对文件内容进行操作，则可以使用RandomAccessFiles类
	 * 此类可以随机读取一个文件中指定位置的数据
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
	
		I02_RandomAccessFiles i02_test=new I02_RandomAccessFiles();
		//使用RandomAccessfile的读取数据
		i02_test.writeFile();
		i02_test.readFile();
	}
	
	
	/****
	 * title：读取文件(随机读取)
	 * description：使用RandomAccessFile类读取文件 
	 */
	private void readFile() throws Exception{
		String filepath=queryPath()+"I02_Random.txt";
		File file=new File(filepath);
		//声明一个RandomAccessFile类对象
		RandomAccessFile rdf=null;
		//以读的方式打开文件，会自动创建新文件
		rdf=new RandomAccessFile(file,"r");
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
	/***
	 * title:使用RandomAccessFile类读取数据
	 * description: 在文本中输入 zhangsan,30   lisi,31   wangwu,32
	 *              如果要读取"lisi"信息时，就可以将“zhangsan”的信息跳过，相当于在文件中设置了一个指针
	 *              ，根据此指针进行读取。但是想实现这样的功能，则每个数据的长度应该保持一致,所以在设置姓名时
	 *              应该统一设置为8位，数字4位
	 */
	private void writeFile() throws Exception{
		String selectFilePath=queryPath()+"I02_Random.txt";
		
		//指定要操作的文件
		File file=new File(selectFilePath);
		//声明一个RandomAccessFile对象
		RandomAccessFile rdf=null;
		//以读写的方式打开文件，会自动创建新的文件  new RandomAccessFile(File file,String model) r表示只读 w表示只写 rw表示读写 
		rdf=new RandomAccessFile(file,"rw");
		String name=null;
		//Integer age=null;//无作用
		int age=0;
		if(file.exists()){
			name="zhangsan"; //字符串长度为8
			age=30  ;//数字长度为4
			rdf.writeBytes(name);
			rdf.writeInt(age);
			name="lisi    "; //字符串长度为8
			age=31  ;//数字长度为4
			rdf.writeBytes(name);
			rdf.writeInt(age);
			name="wangwu  "; //字符串长度为8
			age=97  ;//数字长度为4
			rdf.writeBytes(name);
			rdf.writeInt(age);		
			rdf.close();//关闭文件
			System.out.println("*****writeFile方法执行完毕,写入文件*****");
		}else{
			System.out.println("该文件不存在");
		}
	}
	
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
