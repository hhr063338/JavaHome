package example.io;
import java.io.*;

/*
 * author：hr
 * function：采用字符流复制文件
 */

public class S01_FileCopy {
	  public static void main(String[] args) {
		  int b = 0;
		  FileReader in = null;
		  FileWriter out = null;
		  try {
			  //注意在输入路径的时候，需要注意转义字符的区别；可以用“/”代替“\”
		    in = new FileReader("D:\\Program Files\\workspace\\java_home\\learn\\src\\com\\io\\DataSource\\AA01_utf8.TXT");
		    //假如没有指定文件,FileWriter可以帮你建文件，但没办法建目录,FileReader不能建立文件、目录
		    out = new FileWriter("D:/Program Files/workspace/java_home/learn/src/com/io/DataSource/AA01_COPY2.TXT");
		    while((b=in.read())!=-1){ //判断，在读取字符之前判断是否已经读完了
		    	System.out.print((char)b);//强制将读取的字符以字符的形式输出,这里是一个一个字符读出来的
		    	
		    	out.write(b);//将读取的字符写入到out指向的数据源
		    }

		    out.close();//管道用完了，记得要关闭
		    in.close(); 
		    
		  } catch (FileNotFoundException e2) {
		    System.out.println("找不到指定文件"); System.exit(-1);
		  } catch (IOException e1) {
		    System.out.println("文件复制错误"); System.exit(-1);
		  }
		  System.out.println("\n文件已复制");
	  }
	}
