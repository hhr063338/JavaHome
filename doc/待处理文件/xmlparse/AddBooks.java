package day01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class AddBooks {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String file = "src/books.xml";
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File(file));
		//找到根元素books
		Element root = doc.getRootElement();
		//追加book节点
		Element newbook = root.addElement("book");
		//追加name
		Element newname = newbook.addElement("name");
		newname.setText("天龙八部");
		//追加author
		Element newathor = newbook.addElement("author");
		newathor.setText("金庸");
		
		//将内存中doc更新到文件中
		OutputStream os = new FileOutputStream(file);
		XMLWriter writer = new XMLWriter(os);
		writer.write(doc);//将doc文档对象输出到os指定的文件中
		writer.flush();
		writer.close();
	}

}
