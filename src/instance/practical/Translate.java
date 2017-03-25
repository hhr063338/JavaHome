package instance.practical;
/**
 * 各种数据类型间的相互转换
 *
 */
public class Translate {
	public static void main(String[] args) {
		Translate t=new Translate();
		//1.byte[]与String相互转换与原理
		t.stringToByteArray();
		
	}
	/**
	 * 1.String转为byte[]
	 * 在网络传输或其它的应用中常常有同一的中间件（通信的中间件），假设为String类型。
	 * 因此需要把其他类型的数据转换为中间件的类型
	 * 将字符串进行网络传输时，如socket，需要将其再转换为byte[]类型，这中间如果采用不同的编码可能会出现未成预料的问题，如乱码
	 */
	public void stringToByteArray(){
		System.out.println("=====================探讨String与byte[]间相互转换与转换原理=================");
		//把byte转化成String，必须经过编码
		String str1="123abc";
		String str2="中国China";
		byte[] b_str1=str1.getBytes();
		byte[] b_str2=str2.getBytes();
//		System.out.println(b_str1.toString());
//		System.out.println(b_str2.toString());
		
		System.out.println(new String(b_str1));
		System.out.println(new String(b_str2));
	}
}
