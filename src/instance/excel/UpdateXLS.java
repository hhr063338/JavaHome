package instance.excel;
import java.io.*; 
import jxl.*; 
import jxl.write.*; 

/*
 *三、修改文件 
 *利用jExcelAPI可以修改已有的Excel文件，修改Excel文件的时候，除了打开文件的方式不同之外，其他操作和创建Excel是一样的。下面的例子是在我们已经生成的Excel文件中添加一个工作表： 
 *修改Excel的类，添加一个工作表 
 */
public class UpdateXLS 
{ 
public static void main(String args[]) { 
	try { 
			//Excel获得文件 
			Workbook wb=Workbook.getWorkbook(new File("测试.xls")); 
			//打开一个文件的副本，并且指定数据写回到原文件 
			WritableWorkbook book= 
			Workbook.createWorkbook(new File("测试.xls"),wb); 
			//添加一个工作表 
			WritableSheet sheet=book.createSheet("第二页",1); 
			sheet.addCell(new Label(0,0,"第二页的测试数据")); 
			book.write(); 
			book.close(); 
	}catch(Exception e) { 
			System.out.println(e); 
		} 
	} 
} 
