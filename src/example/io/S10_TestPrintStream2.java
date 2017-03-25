package example.io;
import java.io.*;

/*
 * function :利用print打印流，把指定文件的内容打印出来
 */
public class S10_TestPrintStream2 {
	
  public static void main(String[] args) {
	  
    //String filename = args[0];//命令行参数
	  String  filename="D:\\Program Files\\workspace\\java_home\\learn\\src\\com\\io\\DataSource\\AA03_S06.TXT";
    if(filename!=null){list(filename,System.out);}
  }
  public static void list(String f,PrintStream fs){
    try {
      BufferedReader br = new BufferedReader(new FileReader(f));
      String s = null; 
      while((s=br.readLine())!=null){
        fs.println(s);            
      }
      br.close();
    } catch (IOException e) {
      fs.println("无法读取文件");
    }
  }
}