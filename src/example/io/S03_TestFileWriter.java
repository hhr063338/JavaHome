package example.io;
import java.io.*;

/*
 * function：将java采用的字符集中前50000个字符输出
 */
public class S03_TestFileWriter {
  public static void main(String[] args) {
    FileWriter fw = null;
    try {
      fw = new FileWriter("D:\\Program Files\\workspace\\java_home\\learn\\src\\com\\io\\DataSource\\AA01_unicode.TXT");
      for(int c=0;c<=50000;c++){//char在计算机内部是两个字节，用数字表示最大为65535
        fw.write(c);
      }
      fw.close();
    } catch (IOException e1) {
    	e1.printStackTrace();
      System.out.println("文件写入错误");
      System.exit(-1);
    }
  }
}
