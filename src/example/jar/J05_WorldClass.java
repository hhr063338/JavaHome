package example.jar;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

public class J05_WorldClass {
	//如何调用资源类
	public static void main(String[] args) {
		Locale zg=new Locale("zh", "CN");//表示中国地区
		ResourceBundle rb=ResourceBundle.getBundle("Message_zh_CN", zg);//找到属性文件
		String str1=rb.getString("info");
		System.out.println("中文内容："+str1);
		
		
	}


}
/**
 * 资源类的创建
 * 如果用类来保存资源信息，也必须按照Key-Value的形式出现，而且类名必须与属性文件一致
 * 而且此类必须继承ListResourceBundle类，继承之后要覆写此类的getContent()方法
 * 在资源类中的属性一定是一个二维数组
 *
 */
//建立中文的资源类
class Message_zh_CN extends ListResourceBundle{

	private final Object data[][]={
			{"info","你好,{0}"}
	};
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return data;
	}
	
}
