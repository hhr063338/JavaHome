package model.factory;

/***
 * <ul>
 * <li>文件名称: F01_SimpleFactory01.java</li>
 * <li>功能描述: 简单工厂模式 </li>
 * </ul>
 */
public class F01_SimpleFactory01 {

	/***
	 * 普通工厂模式，就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建
	 * 简单工厂模式是由一个工厂对象决定创建出哪一种产品类的实例
	 * 就拿登录功能来说，加入应用系统需要支持多种登录方式，如口令认证，域认证（前者通常是在数据库中认证，后者则要到微软的域中认证）
	 * 目前，我们举一个发送邮件和短信的例子
	 */
    public static void main(String[] args) {  
        F01_SendFactory factory = new F01_SendFactory();  
        F01_Sender sender = factory.produce("sms");  
        sender.send();
    }  
}

/**
 * 
 * <ul>
 * <li>文件名称: F01_SimpleFactory01.java</li>
 * <li>功能描述: 1.首先创建二者的共同接口</li>
 * </ul>
 */
interface F01_Sender{
	public void send();//定义抽象方法，发送邮件
}
/**
 * <ul>
 * <li>文件名称: F01_MailSender.java</li>
 * <li>功能描述: 2.1创建实现类</li>
 * </ul>
 */
class F01_MailSender implements F01_Sender{
	
	public void send() {//发送邮件
		System.out.println("this is mailsender!");
	}
}
/**
 * <ul>
 * <li>文件名称: SmsSender.java</li>
 * <li>功能描述: 2.2创建实现类</li>
 * </ul>
 */
class F01_SmsSender implements F01_Sender{
	
	  public void send() {//发送短信  
	        System.out.println("this is sms sender!");  
	    }  
}

/***
 * <ul>
 * <li>文件名称: F01_SimpleFactory01.java</li>
 * <li>功能描述: 建工厂类 </li>
 * </ul>
 */
class F01_SendFactory{
	
	 public F01_Sender produce(String type) {  
	        if ("mail".equals(type)) {  
	            return new F01_MailSender();  
	        } else if ("sms".equals(type)) {  
	            return new F01_SmsSender();  
	        } else {  
	            System.out.println("请输入正确的类型!");  
	            return null;  
	        }  
	    }  
}

