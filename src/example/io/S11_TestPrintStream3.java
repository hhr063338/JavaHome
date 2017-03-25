package example.io;
import java.util.*; 
import java.io.*;

/*
 * function:利用Print打印日志文件记录操作，记得输入英文字符
 */
public class S11_TestPrintStream3 {
	public static String filepath="D:\\Program Files\\workspace\\java_home\\learn\\src\\com\\io\\DataSource\\";
  public static void main(String[] args) {
    String s = null;
    BufferedReader br = new BufferedReader(
                        new InputStreamReader(System.in));
    try {
      FileWriter fw = new FileWriter(filepath+"AA01_S11.txt", true); //Log4J
      PrintWriter log = new PrintWriter(fw);
      while ((s = br.readLine())!=null) {
        if(s.equalsIgnoreCase("exit")) break;
        System.out.println(s.toUpperCase());
        log.println("-----");
        log.println(s.toUpperCase()); 
        log.flush();
      }
      log.println("==="+new Date()+"==="); 
      log.flush();
      log.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}