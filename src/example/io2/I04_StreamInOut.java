package example.io2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * <ul>
 * <li>文件名称: I04_StreamInput.java</li>
 * <li>功能描述: 字节流与字符流的基本操作</li>
 * </ul>
 */
public class I04_StreamInOut {
	/***
	 * 1.随机读取流可以实现对文件内容的操作,但一般操作文件内容往往会使用字节或字符流
	 * 2.在程序中所有的数据都是以流的方式进行传输或保存,程序需要数据时要使用输入流读取数据,
	 *   而当程序需要将一些数据保存起来时,就要使用输出流
	 */	

	/* 
	 * 在java.io包中主要有字节流和字符流，两类都有输出和输入操作
	 *   字节流中输出使用OutputStream类完成，输入使用的是InputStream类，主要以byte类型数据、byte数组操作
	 *   字符流中输出使用Writer类完成,输入使用的是Reader类完成
	 * 以文件操作为例，主要流程：
	 * 1.使用File类打开一个文件
	 * 2.通过字节流或字符流的子类指定输出位置
	 * 3.进行读/写操作
	 * 4.关闭输入/输出
	 */
	public static void main(String[] args) throws Exception {
		I04_StreamInOut i04=new I04_StreamInOut();
		//1.向文件中写入字符串
		//i04.writeFile();
		//2.向文件循环写入内容
		//i04.writeFileByCycle();
		//3.向文件追加内容
		//i04.fileAppendWrite();
		//4.读取内容
		//i04.readFileByStream();
		//5.读取内容
		//i04.readFileByStream2();
		//6.另一种读取内容方式
		i04.readFileByStreamCycle();
	}
	
	/***
	 * title:向文件中写入字符串
	 * 1.字节输出流:OutputStream是整个IO包中字节输出流中最大的父类,是抽象类
	 * 2.如果操作的是文件，可以使用FileOutputStream来实例化对象
	 */
	public void writeFile() throws Exception{
		System.out.println("*****开始writeFile方法*******");
		String filepath=queryPath()+"I04_StreamInput.txt";
		//第一步:使用File类找到一个文件
		File file=new File(filepath);

		
		//第二步:通过子类实例化父类对象
		OutputStream out=null;//准备好一个输出对象
		out=new FileOutputStream(file);//通过对象多态性,进行实例化（如果文件不存在会直接创建）

		//第三步:进行写操作
		String str=" Hello Word!!!";
		String strCh=" \n欢迎来到数据流世界 ";
		byte b[]=str.getBytes();//只能输出byte数组,所以将字符串变更为byte数组
		
		out.write(b);//将内容输出
		out.write(strCh.getBytes());
		//第四部：关闭输出流
		out.flush();//保证输出流中的数据写入文件，文件大时使用
		out.close();
		System.out.println("*****结束writeFile方法*******");
	}
	
	
	/***
	 * title:2.向文件循环中写入字符串
	 * 1.字节输出流:OutputStream是整个IO包中字节输出流中最大的父类,是抽象类
	 * 2.如果操作的是文件，可以使用FileOutputStream来实例化对象
	 */
	public void writeFileByCycle() throws Exception{
		System.out.println("***writeFileByCycle利用输出流循环写入文件start****");
		String filename=queryPath()+"I04_StreamInput2.txt";
		//第一步:使用File类找到一个文件
		File file=new File(filename);		
		//第二步:通过子类实例化父类对象
		OutputStream out=null;//准备好一个输出对象
		out=new FileOutputStream(file);//通过对象多态性R,进行实例化（如果文件不存在会直接创建）
		//第三步:进行写操作
		String str=" Hello Word!!! /n there are no peace!";
		byte b[]=str.getBytes();//只能输出byte数组,所以将字符串变更为byte数组
		for(int i=0;i<b.length;i++){
			out.write(b[i]);
		}
		out.flush();
		out.close();
		System.out.println("***writeFileByCycle利用输出流循环写入文件end****");
		
	}
	/***
	 * title:3.给指定文件追加内容
	 * 1.之前的操作,如果重新执行,会覆盖原有的内容,此时可以通过FileOutputStream的另外一个构造法追加内容
	 * new FileOutputStream(File file,boolean append);
	 */	
	public void fileAppendWrite() throws Exception{
		System.out.println("***3.fileAppendWrite()追加写入内容start****");
		
		String filepath=queryPath()+"I04_StreamInput.txt";
		File file=new File(filepath);
		//第二个参数表示是否追加内容,true表示是
		OutputStream out=new FileOutputStream(file,true);
		String appendstr="\r\n此处省略500字追加内容";
		//在windows下的换行符是:"/r/n"在unix下的是"/n";
		out.write(appendstr.getBytes());
		out.close();
		System.out.println("***3.fileAppendWrite()追加写入内容end******");
	}
	
	/**
	 * title:4.读取数据
	 * 1.可以通过inputStream从文件中读取内容,同outputStream一样,inputStream也是一个抽象类
	 */
	public void readFileByStream() throws Exception{
		System.out.println("****readFileByStream()方法读取数据start*********");
		String filepath=queryPath()+"I04_StreamInput.txt";
		//第一步：声明File对象
		File file=new File(filepath);
			//不比写入文件，如果不存在该文件会出现异常
			if(!file.exists()){
				file.createNewFile();
			}
		
		//第二步：通过子类实例化父类对象
		InputStream in =null;//准备好一个输入的对象
		in=new FileInputStream(file);//通过对象多态性进行实例化
		//第三步：进行读操作
		byte[] b=new byte[1024];//所有内容读到此数组中
		int len=in.read(b);//把内容取出，内容读到byte数组,并返回读取内容的长度
		//第四步：关闭输出流
		in.close();
		System.out.println("读取内容:");
		System.out.println(new String(b));
		//因为开辟控件1024个字节，但实际文本内容远远小于，那么在将byte转为字符串也会将这无用的空间转为字符串
		//解决输出空字符串
		System.out.println("读取内容（正确输出）:");
		if(len>0){
			System.out.println(new String(b,0,len));
		}
		
		System.out.println("****readFileByStream()方法读取数据end***********");
		
	}
	
	/***
	 * title：5.读取文件内容
	 * @throws Exception
	 */
	public void readFileByStream2() throws Exception{
		System.out.println("****readFileByStream2()方法读取数据start***********");
		
		String filepath=queryPath()+"I04_StreamInput.txt";
		File file=new File(filepath);
		if(!file.exists()){
			file.createNewFile();
		}
		InputStream input=new FileInputStream(file);
		byte[] b=new byte[Integer.parseInt(((Long)file.length()).toString())];
		int len=input.read(b);//也可以循环遍历
		input.close();
		System.out.println("内容为：");
		if(len>0){
			System.out.println(new String(b,0,len));
		}
		
		System.out.println("****readFileByStream2()方法读取数据end*************");
	}

	/**
	 * title:6.另一种读取文件的方式
	 * 
	 */
	public void readFileByStreamCycle() throws Exception{
		System.out.println("****readFileByStreamCycle()方法读取数据start*************");
		File file=new File(queryPath()+"I04_StreamInput.txt");
		if(!file.exists()){
			file.createNewFile();
		}
		InputStream input=new FileInputStream(file);
		byte[] b=new byte[1024];//所有的内容读到此数组中
		int len=0;//用于记录读取的数据个数
		int temp=0;//接收读取的每一个内容
		while((temp=input.read())!=-1){
			//将每一次读取到的内容给temp变量，如果temp的值不是-1，则表示文件没有读完
			b[len]=(byte)temp;
			len++;
		}
		input.close();
		System.out.println(new String(b,0,len));
		System.out.println("****readFileByStreamCycle()方法读取数据end***************");
	}
	/**
	 * 获取文件文本存放路径
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
