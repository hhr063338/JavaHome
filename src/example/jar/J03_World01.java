package example.jar;

import java.util.Locale;
import java.util.ResourceBundle;



/**国际化实质
 * 国际化操作实际上就是让一个程序适应多国语言
 * 要想实现国际化操作程序只靠Local类是不够的，还需要属性文件和ResourceBundle类的支持
 * 所谓的属性文件(.properties),文件中的内容保存结构为“key=value”形式（关于属性文件的具体操作可以参考Java类集部分）
 * 资源文件有时也称为属性文件
 */

/* 要实现java的国际化操作主要依靠的类：
 * java.util.Local:用于表示一个国家的语种类
 * java.util.ResourceBundle:用于访问资源文件
 * java.text.MessageFormat:格式化资源文件的占位符
 * 操作流程：通过Local类所指定的区域码，然后ResourceBundle根据Local类所指定的区域码找到相应的资源文件
 * 如果资源文件中存在动态文本，则使用MessageFormat进行格式化
 * 
 */
public class J03_World01 {

	public static void main(String[] args) {
		J03_World01 j3=new J03_World01();
		//
		j3.readProperties();
		//Java国际化操作实现
		j3.javaWorld();
	}
	
	/**
	 * ResourceBundle读取属性文件，需要文件名但不用后缀
	 */
	public void readProperties(){
		System.out.println("************使用ResourceBundle类读取属性文件****************");
		ResourceBundle rb=ResourceBundle.getBundle("sample.jar.message");//找到资源文件,与原路径对比
		System.out.println("该资源文件中的数据"+rb.getString("info"));	//从资源文件中读取数据
	}
	
	/**
	 * java国际化程序实现
	 * 在这里使用三种语言，所以定义三种属性文件，文件定义时按“名称_国家代码”的形式命名
	 */
	//在属性文件中是不能直接写入中文的，读取出来的也必然是乱码，因此必须将相应的中文变为Unicode编码才可以
	//要成功地将一个中文编码变为Unicode编码，可以在运行处执行native2ascii.exe
	public void javaWorld(){
		System.out.println("**************java国际化程序实现**********************");
		//Local(language,country)
		Locale zg=new Locale("zh", "CN");//表示中国地区
		Locale yg=new Locale("en", "US");//表示美国地区
		Locale fg=new Locale("fr", "FR");//表示法国地区
		//找到地区对应的属性文件
		ResourceBundle rbzg=ResourceBundle.getBundle("Message_zh_CN", zg);
		ResourceBundle rbyg=ResourceBundle.getBundle("Message_en_US", yg);
		ResourceBundle rbfg=ResourceBundle.getBundle("Message_fr_FR", fg);
		
		System.out.println("中文："+rbzg.getString("info"));
		System.out.println("英文："+rbyg.getString("info"));
		System.out.println("法文："+rbfg.getString("info"));		
	}
	

}