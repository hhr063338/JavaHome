package instance.xml;

import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * 
 * <ul>
 * <li>文件名称: SaxService01.java</li>
 * <li>文件描述: 用于解析XML的业务类</li>
 * </ul>

 */
public class SaxService01 {
	
    public static List<Map<String,String>> ReadXML(String uri,String NodeName){
    	        try {
    	            //创建一个解析XML的工厂对象
    	             SAXParserFactory parserFactory=SAXParserFactory.newInstance();
    	             //创建一个解析XML的对象
    	             SAXParser parser=parserFactory.newSAXParser();
    	             //创建一个解析助手类
    	             SelfHandle01 myhandler=new SelfHandle01(NodeName);
    	             parser.parse(uri, myhandler);
    	            return myhandler.getList();
    	         } catch (Exception e) {
    	             e.printStackTrace();
    	         }finally{
    	             
    	         }
    	         return null;
    	         
    	    }
}
