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
		//利用xpath技术定位所有的DNAME
		List<Element> dnameList = 
						doc.selectNodes("//DNAME");
		for(Element dname : dnameList){
			System.out.println(dname.getText());
		}
		//利用xpath技术定位DEPTNO=20的DNAME和LOC值
		Element dept = (Element)
			doc.selectSingleNode("//DEPT[@DEPTNO='20']");
		//获取dept节点的dname子节点值
		String name = dept.element("DNAME").getText();
	  //获取dept节点的loc子节点值
		String loc = dept.elementText("LOC");
		System.out.println(name+" "+loc);
		//利用xpath技术根据DNAME="SALES"找LOC值
		dept = (Element)doc.selectSingleNode(
				"//DEPT[DNAME='SALES']");
		loc = dept.elementText("LOC");
		System.out.println(loc);
	}

}
