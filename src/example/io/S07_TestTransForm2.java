package example.io;
import java.io.*;
/*
 * function：转换流：将字节输入流转换为字符输入流
 * result：输入小写英文字母，输出大写字母
 */
public class S07_TestTransForm2 {
	
	
  public static void main(String args[]) {
	  //in的数据类型是InputStream类型
    InputStreamReader isr = new InputStreamReader(System.in);
  //为何还用BufferReader套接，是因为想使用BufferReader里面的readLine方法
    BufferedReader br = new BufferedReader(isr);	
    String s = null;
    try {
      s = br.readLine();
      while(s!=null){
        if(s.equalsIgnoreCase("exit")) break;	//忽视大小写来进行比较，当为exit退出
        System.out.println(s.toUpperCase());//转换为大写
        s = br.readLine();
      }
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
} //����