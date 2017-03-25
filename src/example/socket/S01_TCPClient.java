package example.socket;
import java.net.*;//编写网络编程需导入相关类包java.net.*;
import java.io.*;

public class S01_TCPClient {
	public static void main(String[] args) throws Exception {
		//这句话一运行，表示客户端已经连接到服务器端的6666端口.客户端是把信息从本机随机端口发送出去
		Socket s = new Socket("127.0.0.1", 6666);//Socket(ServerIp地址,端口号)
	
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		Thread.sleep(30000);
		dos.writeUTF("hello server!");
		dos.flush();
		dos.close();
		s.close();
	}
}