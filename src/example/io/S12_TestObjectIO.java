package example.io;
import java.io.*;
/*
 * function:Object流，Object序列化
 */

public class S12_TestObjectIO {
	public static String filePath="D:\\Program Files\\workspace\\java_home\\learn\\src\\com\\io\\DataSource\\";
	public static void main(String args[]) throws Exception {
		T t = new T();
		t.k = 8;
		FileOutputStream fos = new FileOutputStream(filePath+"AA01_S12_Object.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(t);
		oos.flush();
		oos.close();
		
		FileInputStream fis = new FileInputStream(filePath+"AA01_S12_Object.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		T tReaded = (T)ois.readObject();
		System.out.println(tReaded.i + " " + tReaded.j + " " + tReaded.d + " " + tReaded.k);
		
	}
}

class T 
//serializable是表示可序列化的接口，如果你想实现序列化，必须实现该接口
	implements Serializable		
{
	int i = 10;
	int j = 9;
	double d = 2.3;		//externalizable接口，实现该接口，自主控制对象序列化
	transient int k = 15;//transient透明的，对其不可见，在这里是表示不参与序列化
}