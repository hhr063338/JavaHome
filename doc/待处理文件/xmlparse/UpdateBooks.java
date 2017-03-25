package day01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class UpdateBooks {

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
		//从books下找所有的book
		List<Element> bookList = root.elements("book");
		//循环找出id=1002的book元素
		for(Element book : bookList){
			String id = book.attributeValue("id");
			//如果是1001删除book节点
			if("1001".equals(id)){
				root.remove(book);//从books节点中将book移除
			}
			
			//如果是1002修改price值
			if("1002".equals(id)){
				//定位book的price子元素
				Element price = book.element("price");
				//修改price文本值
				price.setText("60");
//				book.setAttributeValue("id", "1005");
				break;
			}
		}
		//------------------------
		//将内存中文档树对象状态更新到xml文件中
		OutputStream os = new FileOutputStream(file);
		XMLWriter writer = new XMLWriter(os);
		writer.write(doc);//将doc文档对象输出
		writer.flush();
		writer.close();
	}

}
