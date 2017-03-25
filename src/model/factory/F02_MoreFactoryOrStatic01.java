package model.factory;

/***
 * <ul>
 * <li>文件名称: F02_MoreFactory01.java</li>
 * <li>功能描述: 多个工厂方法模式 与 静态工厂模式</li>
 * <li>总结: 工厂模式适合，凡是出现了大量的产品需要创建，并且具有共同的接口时，可以通过工厂方法模式进行创建</li>
 * </ul>
 */
public class F02_MoreFactoryOrStatic01 {

	/**
	 * 多个工厂方法模式：是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确
	 * 创建对象，而多个工厂模式是提供多个工厂方法，分别创建对象
	 * 目前，我们举一个发送邮件和短信的例子
	 */
	public static void main(String[] args) {
	
		System.out.println("调用多工厂方法模式");
		F02_SendFactory factory=new F02_SendFactory();
		F02_Sender sendMail=factory.produceMail();
		F02_Sender sendSms=factory.produceSms();
		sendMail.send();
		//sendSms.send();
		System.out.println("调用静态工厂方法模式");
		//F02_StaticSendFactory factory2=new F02_StaticSendFactory();
		F02_Sender sendMail2=F02_StaticSendFactory.produceMail();
		sendMail2.send();
	}
}
/**
 * 
 * <ul>
 * <li>文件名称: F02_SimpleFactory01.java</li>
 * <li>功能描述: 1.首先创建二者的共同接口</li>
 * </ul>
 */
interface F02_Sender{
	public void send();//定义抽象方法，发送邮件
}
/**
 * <ul>
 * <li>文件名称: F02_MailSender.java</li>
 * <li>功能描述: 2.1创建实现类</li>
 * </ul>
 */
class F02_MailSender implements F02_Sender{
	
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
class F02_SmsSender implements F02_Sender{
	
	  public void send() {//发送短信  
	        System.out.println("this is sms sender!");  
	    }  
}

/***
 * <ul>
 * <li>文件名称: F02_SimpleFactory01.java</li>
 * <li>功能描述: 多个工厂方法模式</li>
 * </ul>
 */
class F02_SendFactory{
	
	 public F02_Sender produceMail() {   //发送邮件 
	            return new F02_MailSender();  

	    }  
	 public F02_Sender produceSms() {  //发送短信
	            return new F02_SmsSender();  

	    } 	 
}
/***
 * <ul>
 * <li>文件名称: F02_MoreFactoryOrStatic01.java</li>
 * <li>功能描述: 静态工厂模式</li>
 * </ul>
 */
class F02_StaticSendFactory {  
    
    public static F02_Sender produceMail(){  
        return new F02_MailSender();  
    }  
      
    public static F02_Sender produceSms(){  
        return new F02_SmsSender();  
    }  
}  
