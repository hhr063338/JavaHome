package model.build;

import java.util.ArrayList;
import java.util.List;



/***
 * <ul>
 * <li>文件名称: B01_Build01.java</li>
 * <li>功能描述: 建造者模式（Builder）</li>
 * </ul>
 */
public class B01_Build01 {

	/**工厂模式提供的是创建单个类的模式，而建造者模式则是将各种产品集中起来进行管理，用来创建复合对象
	 * 所谓的复合对象，就是指某个类具有不同的属性，其实建造者模式就是抽象工厂类与主方法结合起来的
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		B01_BuilderClass01 buidls=new B01_BuilderClass01();
		buidls.produceMailSender(10);
		for(B01_Sender send:buidls.getList()){
			send.send();
		}
	}
	/** 工厂模式与建造者模式的区别：
	 * 工厂模式关注的是创建单个产品，而建造者模式则关注创建符合对象，多个部分。因此，是选择工厂模式还是建造者模式
	 */
}


/**
 * <ul>
 * <li>文件名称: B01_AbstractFactory01.java</li>
 * <li>功能描述: 共享的接口 </li>
 * </ul>
 */
interface B01_Sender {  
    public void send();  
}  
/**
 * <ul>
 * <li>文件名称: B01_AbstractFactory01.java</li>
 * <li>功能描述: 实现接口的实体类</li>
 * </ul>
 */
class B01_MailSender implements B01_Sender {  
    @Override  
    public void send() {  
        System.out.println("this is mailsender!");  
    }  
}  
/**
 * <ul>
 * <li>文件名称: B01_SmsSender.java</li>
 * <li>功能描述: 实现接口的实体类</li>
 * </ul>
 */
class B01_SmsSender implements B01_Sender {  
	  
    @Override  
    public void send() {  
        System.out.println("this is sms sender!");  
    }  
}  

class B01_BuilderClass01{
	private List<B01_Sender> list=new ArrayList<B01_Sender>();
	
	/**生产发送邮件操作类***/
	public void produceMailSender(int count){
		for(int i=0;i<count;i++){
			list.add(new B01_MailSender());
		}
	}
	/**生产发送短信操作类***/
	public void produceSmsSender(int count){
		for(int i=0;i<count;i++){
			list.add(new B01_MailSender());
		}
	}
	
	public List<B01_Sender> getList(){
		return list;
	}

}

