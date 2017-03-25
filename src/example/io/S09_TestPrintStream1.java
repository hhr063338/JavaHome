package example.io;
import java.io.*;

/*
 * function:打印流的简单使用Print
 */
public class S09_TestPrintStream1 { 
	public static String filePath="D:\\Program Files\\workspace\\java_home\\learn\\src\\com\\io\\DataSource\\";
  public static void main(String[] args) {
	  
    PrintStream ps = null;//打印字节流
    try {
      FileOutputStream fos = new FileOutputStream(filePath+"AA03_S09.txt");
      ps = new PrintStream(fos);//在输出流上套接打印输出流
      
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    
    if(ps != null){
      System.setOut(ps);//system.out管道默认向控制台输出，这里是重新设置out指向的目标
    }
    
    	int ln = 0;
    for(char c = 0; c <= 60000; c++){
    	System.out.print(c+ " ");
        if(ln++ >=100){ System.out.println(); ln = 0;}
    }
  }
}
