package instance.encode;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;


/***
 * 
 * <ul>
 * <li>文件名称: GBK_TO_UTF.java</li>
 * <li>文件描述: 批量将gbk存储格式文件转化为utf存储格式文件</li>
 * </ul>

 */
public class GBK_TO_UTF {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//最好能检索父目录下的子目录中的java源文件，然后相应的创建
		//GBK编码格式源码路径 
		String srcDirPath = "G:\\刑天（兴添）\\J2SE\\源代码"; 
		//转为UTF-8编码格式源码路径 
		String utf8DirPath = "D:\\UTF8\\src\\za"; 
		        
		//获取所有java文件 
		Collection<File> javaGbkFileCol =  FileUtils.listFiles(new File(srcDirPath), new String[]{"java"}, true); 
		        
		try{
		for (File javaGbkFile : javaGbkFileCol) { 
		      //UTF8格式文件路径 
		      String utf8FilePath = utf8DirPath+javaGbkFile.getAbsolutePath().substring(srcDirPath.length()); 
		       //使用GBK读取数据，然后用UTF-8写入数据 
		      FileUtils.writeLines(new File(utf8FilePath), "UTF-8", FileUtils.readLines(javaGbkFile, "GBK"));        
		}
		}catch(Exception e){
			System.out.println("出错了");
		}

	}

}
