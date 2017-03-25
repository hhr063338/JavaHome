package day01;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ParseBooks {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String file = "src/books.xml";
		//利用dom4j解析器将文件载入,构建成内存中的文档树对象
		SAXReader reader = new SAXReader();
		//doc就是文档树对象
		Document doc = reader.read(new File(file));
		//获取doc的根元素books
		Element root = doc.getRootElement();
		//从root根源下找所有的book子元素
		List<Element> bookList = root.elements("book");
    //root.element("book");//返回单个子元素
		//循环访问bookList中的book元素
		for(Element book : bookList){
			//获取book的id属性值
			String idVal = book.attributeValue("id");
			//获取book的name子元素(单个用element方法)
			Element name = book.element("name");
		  //获取name节点的文本值
			String nameVal = name.getText();
			System.out.println(idVal+" "+nameVal);
		}
	}

}
