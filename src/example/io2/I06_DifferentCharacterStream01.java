package example.io2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;

/**
 * <ul>
 * <li>文件名称: I06_DifferentCharacterStream01.java</li>
 * <li>功能描述: 字节流与字符流的区别</li>
 * </ul>
 */
public class I06_DifferentCharacterStream01 {

	/**
	 * 实际上字节流在操作时本身不会用到缓冲区（内存），是文件本身直接操作，而字符流在操作时使用了缓冲区，
	 * 通过缓冲区再操作文件
	 * @param args
	 */

	public static void main(String[] args) throws Exception{
		I06_DifferentCharacterStream01 i06=new I06_DifferentCharacterStream01();
		//1.使用字节流写入文件，不关闭字节流
		i06.writeFileByStream();
		//2.使用字符流写入文件，不关闭字符流
		//i06.writeFileByChar();
		/*** 在开发中，使用字节流比字符流更好，因为所有的文件在硬盘或传输时都是以字节的形式进行，
		 * 	 包括图片等都是按字节流的方式存储的
		 * 
		 */
	}
	

	/**
	 * 使用字节流写入文件且不关闭字节流
	 * 延伸：FileOutputStream与OutputStream的区别
	 */
	private void writeFileByStream() throws Exception{
		String writeFilePath=queryPath()+"I06_DifferentCharacterStream01.txt";
		File writeFile=new File(writeFilePath);//1.使用File类找到一个文件
		OutputStream out=null;//准备好一个输出对象
		out=new FileOutputStream(writeFile);//2.通过对象多态性进行实例化,如果不存在file会自动创建
		String str="这条说说以平实的真情打动读者，语流畅，一气 呵成，从文学的叫的来讲，选材很是新颖，角度清晰可见，语言平实而不失风采，简洁而富有寓意，堪称现代说说之典范！";
		byte[] b=str.getBytes();
		out.write(b);//3.进行写操作
		//4.关闭输出流
		//out.close();
		//此时没有关闭字节流，文件中依然存在输出的内容，证明字节流是直接操作文件本身
	}
	
	/**
	 * 使用字符流写入文件且不关闭字符流
	 * @throws Exception
	 */
	private void writeFileByChar() throws Exception{
		String writeFilePath=queryPath()+"I06_DifferentCharacterStream01.txt";
		File writeFile=new File(writeFilePath);
		Writer write=null;
		write=new FileWriter(writeFile);
		String str="真不愧为无厘界新一代开山祖师！逐字地看完你的说说后，我的心久久 不能平静！这世间怎么可能还有如此精辟的说说？我不敢相信自己的眼睛。自从改革开放以后，我就以为再也不会有任何说说能打动我，没想到今天看到这条如此精妙绝伦的说说，你让我深深理解了 ‘人外有人，天外有天’这句话，在看完说说后，我不敢轻易回复，我担心我庸俗不堪的语言会玷污了这世间少有的说说。";
		write.write(str);
		//write.flush();
		//write.close();
		//不关闭流，不仅写入不了内容还会清空原本的内容
		//结果分析：程序运行后会发现文件中没有任何内容，这是因为字符流操作时使用了缓冲区，而关闭字符流时会强制
		//       性地将缓冲区中的内容进行输出，但是如果程序没有关闭字符流，则缓冲区的内容无法输出，所以得出
		//       结论：字符流使用了缓冲区，而字节流没有使用缓冲区
		//       如果想在不关闭时将内容全部输出，可以使用Writer类中的flush()
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
