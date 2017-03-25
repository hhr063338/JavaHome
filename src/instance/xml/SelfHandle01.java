package instance.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/****
 * 
 * <ul>
 * <li>文件名称: SelfHandle01.java</li>
 * <li>文件描述: 用SAX解析XML的Handler</li>
 * </ul>
 */
public class SelfHandle01 extends DefaultHandler{
	
	//存储正在解析的元素的数据
	private Map<String,String> map=null;
	
	//存储所有解析的元素的数据
	private List<Map<String ,String >> list=null;
	
	//正在解析的元素的名字
	private String currentTag=null;
	//正在解析的元素的元素值
	private String currentValue=null;
	private StringBuffer sb=null;
	//开始解析的元素
	private String nodeName=null;
	
	//声明变量控制输出标签名
	private Integer num=0;
	//存放标签名字
	private Map<String,String> map_name=new HashMap<String, String>();
	
    public SelfHandle01(String nodeName) {
		     this.nodeName=nodeName;
	}
	/****
	 * 开始解析文档，即开始解析XML根元素时调用该方法
	 * 覆写方法
	 */
	@Override
	public void startDocument() throws SAXException {//覆写方法
		//super.startDocument();
		System.out.println("---------startDocument()开始解析XML文档------------");
		//初始化Map
		list=new ArrayList<Map<String,String>>();
	}

	/****
	 * 开始解析每个元素时都会调用该方法
	 * param:uri          =>命名空间
	 * param:localName    =>是不带命名前缀的标签名
	 * param:qName        =>带命名空间的标签名
	 * param:attribute    =>通过该对象可以获得所有的属性和名和相应的值
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		//super.startElement(uri, localName, qName, attributes);
		//判断正在解析的元素是不是开始解析的元素
		System.out.println("---startElement()开始解析节点:"+qName);
		if(qName.equals(nodeName)){
			map=new HashMap<String, String>();
		}
		
		//判断正在解析的元素是否有属性值,如果有则将其全部取出并保存到map对象中
		//如:<person id="00001"></person>
		if(attributes!=null && map!=null){
			for(int i=0;i<attributes.getLength();i++){
				map.put(attributes.getQName(i), attributes.getValue(i));
			}
		}
		//正在解析的元素
		currentTag=qName;	
		sb=new StringBuffer();
		
		//控制存放标签名
		num=num+1;
		map_name.put(num.toString(), qName);
	}
	
	/**
	 * 解析到每个元素的内容时会调用此方法
	 * param:ch			=>
	 * param:start		=>
	 * param:length		=>
	 * 
	 * String s = new String(ch,start,length)
	 * 并不一定就能完整的表示 元素的值. 如果xml文档交长, 有可能一个元素的值会被分两次读入,
	 * 所以如果只使用用上面的方法去获得元素的值,很可能得到的不完整的数据.在这里可以通过StringBuffer来求
	 * 
	 * SAX parser 分块读取流, 默认为一次读取2K字节. 
	 * (ch 里面不仅包含元素的值信息,其实它是整个xml文档的一个部分，
	 * 也就是说，分析器每次从文档中读取2K字节，放到这个数组中，
	 * 然后通过start和length来划分出属于value的部分.这样的话,
	 * 不能保证最后一个元素的值是完全被包含在这个ch中的).
	 * 所以我们还是要进行一些额外的操作才能通过 
	 * characters(char ch[],int start,int length)获得完整的element 
	 * 
	 * Parser每次读取2K字节去填充ch. 填充顺序是从开头到结尾来覆盖原有的值,
	 *  所以在最后一次读取文档的时候,可能剩余部分不足2K，所以就会出现ch 中，
	 *  前半部分是 文档的末尾部分， 而ch后半部分还有多余的信息，
	 *  这个是倒数第二个ch中未被覆盖掉的部分。==？怎么解决（现在可能提高不止2k字节？）
	 * 
	 * 注意：
	 * 读到xml文档前半部分开始标签时，会经常在startElemnt()方法与character()方法间循环
	 * 读到xml文档后半部分结束标签时，会经常在endElement()方法与characters()方法间循环
	 * 每次读到下一个标签不区分开始结束标签
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		//super.characters(ch, start, length);
		System.out.println("-characters()存放节点内容:");
		if(currentTag!=null && null!=map){
			currentValue=new String(ch,start,length);
			//如果内容不为空和空格，也不是换行符则将该元素名和值存入map中
			if(currentValue!=null && !currentValue.trim().equals("") && !currentValue.trim().equals("\n")){
				//map.put(currentTag, currentValue);
				//System.out.println("标签名:"+currentTag+"  标签值:"+currentValue);
				sb.append(currentValue);
				
			}
			//当前的元素已解析过,将其置空用于下一个元素的解析
			//currentTag=null;
			//currentValue=null;
			currentValue=null;
		}

	}
	
     //每个元素结束的时候都会调用该方法
     @Override
     public void endElement(String uri, String localName, String qName) throws SAXException {
      
    	  System.out.println("标签名:"+map_name.get(num.toString())+",标签值:"+sb.toString());
    	  num=num-1;
    	  
    	  map.put(currentTag, sb.toString());   	  
    	  sb=new StringBuffer();
    	  currentValue=null;
    	  currentTag=null;
          System.out.println("--endElement()结束解析节点:"+qName);
         //判断是否为一个节点结束的元素标签
          if(qName.equals(nodeName)){
             list.add(map);
              map=null;
         }
     }	
     
     //结束解析文档，即解析根元素结束标签时调用该方法
     @Override
     public void endDocument() throws SAXException {
         System.out.println("--endDocument()结束解析文档--");
         super.endDocument();
     }
     
     
	public List<Map<String, String>> getList() {
		return list;
	}

	public void setList(List<Map<String, String>> list) {
		this.list = list;
	}

}
