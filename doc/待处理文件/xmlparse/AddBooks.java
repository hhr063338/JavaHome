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
		//�ҵ���Ԫ��books
		Element root = doc.getRootElement();
		//׷��book�ڵ�
		Element newbook = root.addElement("book");
		//׷��name
		Element newname = newbook.addElement("name");
		newname.setText("�����˲�");
		//׷��author
		Element newathor = newbook.addElement("author");
		newathor.setText("��ӹ");
		
		//���ڴ���doc���µ��ļ���
		OutputStream os = new FileOutputStream(file);
		XMLWriter writer = new XMLWriter(os);
		writer.write(doc);//��doc�ĵ����������osָ�����ļ���
		writer.flush();
		writer.close();
	}

}
