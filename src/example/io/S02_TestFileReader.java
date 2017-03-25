package example.io;
import java.io.*;

/*
 * 读取文件的存储格式对读取出来的数据有明显影响
 * 不同的国家和地区制定了不同的标准，由此产生了 GB2312, BIG5, JIS 等各自的编码标准。
 * 这些使用 2 个字节来代表一个字符的各种汉字延伸编码方式，称为 ANSI 编码。
 * 在简体中文系统下，ANSI 编码代表 GB2312 编码，在日文操作系统下，ANSI 编码代表 JIS 编码。
 */
public class S02_TestFileReader {
  public static void main(String[] args) {
    FileReader utf8 = null; 
    FileReader ansi=null;
    int c1 = 0;
    int c2= 0;
    try {
      utf8 = new FileReader("D:\\Program Files\\workspace\\java_home\\learn\\src\\com\\io\\DataSource\\AA01_utf8.TXT");
      ansi=new FileReader("D:\\Program Files\\workspace\\java_home\\learn\\src\\com\\io\\DataSource\\AA01.TXT");
      System.out.print("源文件是UTF8格式存储的：\n");
      while ((c1 = utf8.read()) != -1 ) {
        System.out.print((char)c1);
      }
      System.out.print("\n源文件是ANSI格式存储的：\n");//会出现中文乱码
      while((c2=ansi.read())!=-1){
    	  System.out.print((char)c2); 
      }
      utf8.close();//释放内存中的管道
      ansi.close();
    } catch (FileNotFoundException e) {
      System.out.println("找不到文件");
    } catch (IOException e) {
      System.out.println("读取文件错误 ");
    }

  }
}