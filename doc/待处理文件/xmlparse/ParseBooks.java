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
		//����dom4j���������ļ�����,�������ڴ��е��ĵ�������
		SAXReader reader = new SAXReader();
		//doc�����ĵ�������
		Document doc = reader.read(new File(file));
		//��ȡdoc�ĸ�Ԫ��books
		Element root = doc.getRootElement();
		//��root��Դ�������е�book��Ԫ��
		List<Element> bookList = root.elements("book");
    //root.element("book");//���ص�����Ԫ��
		//ѭ������bookList�е�bookԪ��
		for(Element book : bookList){
			//��ȡbook��id����ֵ
			String idVal = book.attributeValue("id");
			//��ȡbook��name��Ԫ��(������element����)
			Element name = book.element("name");
		  //��ȡname�ڵ���ı�ֵ
			String nameVal = name.getText();
			System.out.println(idVal+" "+nameVal);
		}
	}

}
