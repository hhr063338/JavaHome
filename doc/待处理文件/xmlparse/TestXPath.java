package day01;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestXPath {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String file = "src/depts.xml";
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File(file));
		//����xpath������λ���е�DNAME
		List<Element> dnameList = 
						doc.selectNodes("//DNAME");
		for(Element dname : dnameList){
			System.out.println(dname.getText());
		}
		//����xpath������λDEPTNO=20��DNAME��LOCֵ
		Element dept = (Element)
			doc.selectSingleNode("//DEPT[@DEPTNO='20']");
		//��ȡdept�ڵ��dname�ӽڵ�ֵ
		String name = dept.element("DNAME").getText();
	  //��ȡdept�ڵ��loc�ӽڵ�ֵ
		String loc = dept.elementText("LOC");
		System.out.println(name+" "+loc);
		//����xpath��������DNAME="SALES"��LOCֵ
		dept = (Element)doc.selectSingleNode(
				"//DEPT[DNAME='SALES']");
		loc = dept.elementText("LOC");
		System.out.println(loc);
	}

}
