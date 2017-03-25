package example.io;
import java.io.*;
public class S05_TestBufferStream2 {
  public static void main(String[] args) {
    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\Program Files\\workspace\\java_home\\learn\\src\\com\\io\\DataSource\\AA02_S05.TXT"));
      BufferedReader br = new BufferedReader(new FileReader("D:\\Program Files\\workspace\\java_home\\learn\\src\\com\\io\\DataSource\\AA02_S05.TXT"));
      String s = null;
      //往文件写入数据
//      for(int i=1;i<100;i++){
//    	  char c=(char)i;
//    	  bw.write(c);
//    	  bw.newLine();
//      }
      for(int i=1;i<=100;i++){
        s = String.valueOf(Math.random());//将随机数以字符串形式输出
        bw.write(s);
        bw.newLine();
      }
      bw.flush();
      //将文件中的数据读取出来并输出到屏幕上
      while((s=br.readLine())!=null){
        System.out.println(s);
      }
      bw.close(); 
      br.close();
    } catch (IOException e) { e.printStackTrace();}
  }
}