package instance.pdf;

import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;


/*
 * @author:hr
 * function：利用iText的jar包生成pdfwendang 
 * 
 * 
 */

public class CreatePDF {
	public static void main(String[] args) throws Exception{
		System.out.println("开始了");
		//①建立com.lowagie.text.Document对象的实例。
		  Document document = new Document();
		 //　②建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
		  PdfWriter.getInstance(document,new FileOutputStream("HelloWorld.pdf"));
		// ③打开文档。
		  document.open();
		  //④向文档中添加内容。
		  document.add(new Paragraph("Hello World"));
		  //⑤关闭文档。
		  document.close();
		  //通过上面的5个步骤，就能产生一个Helloworld.PDF的文件，文件内容为"Hello World"。
		System.out.println("pdf文件生成结束");
		
		
	}
	
}
