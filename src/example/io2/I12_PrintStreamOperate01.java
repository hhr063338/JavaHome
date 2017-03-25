package example.io2;

import java.io.File;
import java.io.PrintStream;
import java.nio.charset.Charset;

/**
 * <ul>
 * <li>文件名称: I12_PrintStreamOperate01.java</li>
 * <li>功能描述: 打印流 的 基本操作</li>
 * </ul>
 */
public class I12_PrintStreamOperate01 {

	public static void main(String[] args) throws Exception{
		I12_PrintStreamOperate01 i12=new I12_PrintStreamOperate01();
		//i12.printPrintStream();
		i12.printFactory();
	}
	
	/***
	 * 使用PrintStream输出
	 * @throws Exception
	 */
	private void printPrintStream() throws Exception{
		PrintStream ps=null;
		//此时通过FileOutputStream实例化，意味着所有的输出是向文件中打印
		ps=new PrintStream(new File(queryPath()+"I12_PrintStreamOperate01.txt"));
		ps.print("Hello");
		ps.println(" World!!! ");//输出后换行
		ps.print("1+1="+2);
		ps.close();
	}
	
	/***
	 * 范例：使用打印流进行格式化——格式化输出
	 * 内容补充：%s 表示内容为字符串  %d表示内容为整数  %f表示内容为小数  %c表示内容为字符
	 */
	private void printFactory() throws Exception{
		PrintStream ps=null;
		//此时通过FileOutputStream实例化，意味着所有的输出是向文件中打印
		ps=new PrintStream(new File(queryPath()+"I12_PrintStreamOperate01.txt"),"utf8");
		
		String name="李兴华";
		int age=30;
		float score=990.356f;
		char sex='M';
		//格式化输出
		ps.printf("姓名：%s,年龄：%d,成绩：%f,性别：%c", name,age,score,sex);
		ps.close();
	}
	
	
	/**
	 * 获取文件文本存放路径
	 */
	private String queryPath() throws Exception{
		//获取classpath的路径 "/D:/Workspaces/learn/bin/"
		String filepath=this.getClass().getClassLoader().getResource(".").getPath();
		String[] paths=filepath.split("/");
		StringBuffer sb_path=new StringBuffer();
		//组建文件创建路径
		for(int i=0;i<paths.length-1;i++){
			if(null!=paths[i]&&!paths[i].trim().equals("")){	
				sb_path.append(paths[i]).append(File.separator);
			}
		}
		String directoryPath=sb_path.toString()+"doc"+File.separator+"test"+File.separator;
		return directoryPath;
	}
}
