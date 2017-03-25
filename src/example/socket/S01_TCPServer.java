package example.socket;
import java.net.*;
import java.io.*;

public class S01_TCPServer {
	public static void main(String[] args) throws Exception {
		//在Server端，首先实例一个ServerSocket，server一般是不间断的在运行，在等待客户端的连接，所以在里面应该是死循环构造
		//构造器的参数是端口Port，下面是将ServerSocket与端口6666绑定
		ServerSocket ss = new ServerSocket(6666);
		while(true) {
			//下面是阻塞式连接，没有反应就会傻傻的在那边等着，不过一般阻塞式的效率都不高
			Socket s = ss.accept();//表示Server端同意Client的访问请求，只有允许才允许建立连接
			//工作原理：是server端接收Client会新建一个端口负责与这个Client端通信，所以一有client端请求就建立新的端口死循环
			System.out.println("a client connect!");
			//当建立连接后，可以通过流来通话
			DataInputStream dis = new DataInputStream(s.getInputStream());//对应client端获取的输出管道OutputStream
			System.out.println(dis.readUTF());
			dis.close();
			s.close();
		}
		
	}
}