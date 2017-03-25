package example.io;
import java.io.*;

/*
 * function:探讨缓冲流的作用BufferedInputStream与mark方法
 * 回车符也会以整数形式输出
 */
public class S04_TestBufferStream1 {
  public static void main(String[] args) {
    try {
      FileInputStream fis = 
              new FileInputStream("D:\\Program Files\\workspace\\java_home\\learn\\src\\com\\io\\DataSource\\AA02.TXT");
      BufferedInputStream bis = 
              new BufferedInputStream(fis);
      int c = 0;
//      while ((c = bis.read()) != -1 ) {
//          System.out.print((char)c);//为什么会不一样
//        }
      System.out.println(bis.read());//读取的字符以整数形式出现
      System.out.println((char)bis.read());
      bis.mark(100);//将读取的标记放在第100个字符，接下来的读取从这个字符开始
      for(int i=0;i<=10 && (c=bis.read())!=-1;i++){
        System.out.print((char)c+" ");//查看一次性读取的字符
      }
      System.out.println(); 
      bis.reset();
      for(int i=0;i<=10 && (c=bis.read())!=-1;i++){
        System.out.print((char)c+" ");
      }
      bis.close();
    } catch (IOException e) {e.printStackTrace();}
  }
}