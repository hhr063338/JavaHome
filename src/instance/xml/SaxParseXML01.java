package instance.xml;

import java.util.ArrayList;
import java.util.Map;

/**
 * 
 * <ul>
 * <li>文件名称: SaxParseXML01.java</li>
 * <li>文件描述: 主程序入口</li>
 * <li>辅助类：SaxService01.java  /  SelfHandle01.java</li>
 * </ul>

 */
public class SaxParseXML01 {

	
	/***
	 * 分析：用SAX解析XML采用的是从上而下的基于事件驱动的解析方式，
	 * 在解析过程中会视情况自动调用()startDocument()、startElement()、
	 * 		characters()、endElement()、endDocument()等相关的方法。(继承DefaultHandler接口实现的方法)
	 *  由编译执行的结果来看：
	 *  startDocument()方法：(开始解析文档)只会在文档开始解析的时候被调用，每次解析只会调用一次。
	 *  startElement()方法 ：(开始解析节点)每次在开始解析一个元素，即遇到元素标签开始的时候都会调用。
	 *  characters()方法   ：(保存节点内容)也是在每次解析到元素标签携带的内容时都会调用，即使该元素标签的内容为空或换行。而且如果元素内嵌套元素，在父元素结束标签前， characters()方法会再次被调用，此处需要注意。
	 *  endElement()方法   ：(结束解析节点)每次在结束解析一个元素，即遇到元素标签结束的时候都会调用。
	 *  endDocument() 方法 ：(文档解析结束)只会在文档解析结束的时候被调用，每次解析只会调用一次。
	 */
	     public static void main(String[] args) {
	         ArrayList<Map<String, String>> list=(ArrayList<Map<String, String>>)
	         SaxService01.ReadXML("D:\\Workspaces\\learn\\doc\\xml\\example01_xml.xml","emps");
	         /**
	         for(int i=0;i<list.size();i++){
	             HashMap<String, String> temp=(HashMap<String, String>) list.get(i);
	                 Iterator<String> iterator=temp.keySet().iterator();
	                 while(iterator.hasNext()){
	                     String key=iterator.next().toString();
	                     String value=temp.get(key);
	                     System.out.print(key+" "+value+"--");
	                 }
	         }
	         **/
	         System.out.println(list.toString());
	     }
}
