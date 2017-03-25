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
		//�ҵ���Ԫ��books
		Element root = doc.getRootElement();
		//��books�������е�book
		List<Element> bookList = root.elements("book");
		//ѭ���ҳ�id=1002��bookԪ��
		for(Element book : bookList){
			String id = book.attributeValue("id");
			//�����1001ɾ��book�ڵ�
			if("1001".equals(id)){
				root.remove(book);//��books�ڵ��н�book�Ƴ�
			}
			
			//�����1002�޸�priceֵ
			if("1002".equals(id)){
				//��λbook��price��Ԫ��
				Element price = book.element("price");
				//�޸�price�ı�ֵ
				price.setText("60");
//				book.setAttributeValue("id", "1005");
				break;
			}
		}
		//------------------------
		//���ڴ����ĵ�������״̬���µ�xml�ļ���
		OutputStream os = new FileOutputStream(file);
		XMLWriter writer = new XMLWriter(os);
		writer.write(doc);//��doc�ĵ��������
		writer.flush();
		writer.close();
	}

}
