package instance.excel;
import java.io.*; 
import jxl.*; 
/*
 * 二、读取文件 
 *	以刚才我们创建的Excel文件为例，做一个简单的读取操作，程序代码如下： 
 *	读取Excel的类 
 */
public class ReadXLS 
{ 
public static void main(String args[]) { 
	try { 
			Workbook book= 
			Workbook.getWorkbook(new File("测试.xls")); 
			//获得第一个工作表对象 
			Sheet sheet=book.getSheet(0); 
			//得到第一列第一行的单元格 
			Cell cell1=sheet.getCell(0,0); 
			String result=cell1.getContents(); 
			System.out.println(result); 
			book.close(); 
	}catch(Exception e) { 
		System.out.println(e); 
		} 
	} 
} 
//程序执行结果：test 