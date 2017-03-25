package instance.usefulClass;

import java.io.File;

/**
 * <ul>
 * <li>文件名称: FindPath.java</li>
 * <li>文件描述: java中获取当前文件的路径</li>
 * </ul>
 */
public class FindPath {

	/**title:获取当前类的所在工程路径
	 * 结果：D:\Workspaces\learn\bin
	 * @return
	 */
	public String getFilePath01(){
		File f = new File(this.getClass().getResource("/").getPath()); 
		return f.toString();
	}
	/** title:获取当前类编译后所在的绝对路径
	 *  结果：D:\Workspaces\learn\bin\instance\ usefulClass
	 * @return
	 */
	public String getFilePath02(){
		File f = new File(this.getClass().getResource("").getPath()); 
		return f.toString();
	}	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindPath filePath=new FindPath();
		System.out.println(filePath.getFilePath01());
		System.out.println(filePath.getFilePath02());
		
	}
	

}
/**
第一种： 
File f = new File(this.getClass().getResource("/").getPath()); 
System.out.println(f); 
结果: 
C:\Documents%20and%20Settings\Administrator\workspace\projectName\bin 
获取当前类的所在工程路径; 
如果不加“/” 
File f = new File(this.getClass().getResource("").getPath()); 
System.out.println(f); 
结果： 
C:\Documents%20and%20Settings\Administrator\workspace\projectName\bin\com\test 
获取当前类的绝对路径； 

第二种： 
File directory = new File("");//参数为空 
String courseFile = directory.getCanonicalPath() ; 
System.out.println(courseFile); 
结果： 
C:\Documents and Settings\Administrator\workspace\projectName 
获取当前类的所在工程路径; 

第三种： 
URL xmlpath = this.getClass().getClassLoader().getResource("selected.txt"); 
System.out.println(xmlpath); 
结果： 
file:/C:/Documents%20and%20Settings/Administrator/workspace/projectName/bin/selected.txt 
获取当前工程src目录下selected.txt文件的路径 

第四种： 
System.out.println(System.getProperty("user.dir")); 
结果： 
C:\Documents and Settings\Administrator\workspace\projectName 
获取当前工程路径 

第五种： 
System.out.println( System.getProperty("java.class.path")); 
结果： 
C:\Documents and Settings\Administrator\workspace\projectName\bin 
获取当前工程路径
**/