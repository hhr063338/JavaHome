package example.io;
import java.io.*;
/*
 * Title：使用转换流（处理流之一）
 * function:将字节流转换为字符流
 */
public class S06_TestTransForm1 {
	
	  public static String filePath="D:\\Program Files\\workspace\\java_home\\learn\\src\\com\\io\\DataSource\\";

  public static void main(String[] args) {
	
    try {
    	//下句语句，通过输出流对象转换为字符流对象
      OutputStreamWriter osw = new OutputStreamWriter(
           new FileOutputStream(filePath+"AA03_S06.TXT"));
      //如果不经设置，就是当前操作系统默认使用的字符集编码GBK
      osw.write("mircosoftibmsunapplehp,在这里的是当前IDE默认的字符集编码GBK");
      //上面这句就是用转换流的好处，直接往输入流管道内输入字符串，记住write方法
      System.out.println(osw.getEncoding());
      osw.close();
      osw = new OutputStreamWriter(
      		new FileOutputStream(filePath+"AA03_S06.TXT", true),"ISO8859_1");
      //这里的True表示会保存原有文本的内容
      //"ISO8859_1"包含所有西欧语言，又叫 latin-1
      
      osw.write("mircosoftibmsunapplehp");
      System.out.println(osw.getEncoding());
      osw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}