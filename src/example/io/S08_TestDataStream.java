package example.io;
import java.io.*;

/*
 * function :数据流的使用（处理流之一），如何处理基本类型的传输
 * result：
 */
public class S08_TestDataStream {
  public static void main(String[] args) {
	  //在内存里开辟一个字节数组
    ByteArrayOutputStream baos =  new ByteArrayOutputStream(); 	
    DataOutputStream dos = new DataOutputStream(baos);
    try {
      dos.writeDouble(Math.random());
      dos.writeBoolean(true);
      ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());//管道通向的数据源（通往哪里去）
      System.out.println(bais.available());//bais.available()是询问有多少个字节可以读取
      DataInputStream dis = new DataInputStream(bais);
      System.out.println(dis.readDouble());//先写进去的先读出来
      System.out.println(dis.readBoolean());
      dos.close();  dis.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}