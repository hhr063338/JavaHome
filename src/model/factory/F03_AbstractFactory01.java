package model.factory;

/**
 * <ul>
 * <li>文件名称: F03_AbstractFactory01.java</li>
 * <li>功能描述: 抽象工厂模式</li>
 * </ul>
 */
public class F03_AbstractFactory01 {

	/**工厂模式有一个问题，类的创建依赖工厂，就是说如果想要拓展程序，必须对工厂类进行修改，这违背了闭包原则
	 * 所以从设计的角度考虑，有一定问题，怎么解决？我们可以用到抽象工厂模式，创建多个工厂类，这样一旦增加新的
	 * 功能，直接增加新的工厂类就可以了，不需要修改之前的代码
	 * 
	 * 优点：这个模式的好处，是如果你现在想增加一个功能，发即时信息，只需要做一个实现类，实现Sender接口，
	 *     同时做一个工厂类，实现Provider接口，就OK了，无须改动现有的代码，拓展性好
	 */
	public static void main(String[] args) {
		
		System.out.println("使用抽象工厂模式来拓展程序");
		F03_Provider factory=new F03_SendMailFactory();
		F03_Sender sender=factory.produce();
		sender.Send();
		
	}
}

/**
 * <ul>
 * <li>文件名称: F03_AbstractFactory01.java</li>
 * <li>功能描述: 共享的接口 </li>
 * </ul>
 */
interface F03_Sender {  
    public void Send();  
}  
/**
 * <ul>
 * <li>文件名称: F03_AbstractFactory01.java</li>
 * <li>功能描述: 实现接口的实体类</li>
 * </ul>
 */
class F03_MailSender implements F03_Sender {  
    @Override  
    public void Send() {  
        System.out.println("this is mailsender!");  
    }  
}  
/**
 * <ul>
 * <li>文件名称: F03_SmsSender.java</li>
 * <li>功能描述: 实现接口的实体类</li>
 * </ul>
 */
class F03_SmsSender implements F03_Sender {  
	  
    @Override  
    public void Send() {  
        System.out.println("this is sms sender!");  
    }  
}  

/***
 * <ul>
 * <li>文件名称: F03_AbstractFactory01.java</li>
 * <li>功能描述: 提供接口</li>
 * </ul>
 */
interface F03_Provider {  
    public F03_Sender produce();  
} 
/***
 * 
 * <ul>
 * <li>文件名称: F03_AbstractFactory01.java</li>
 * <li>功能描述: </li>
 * </ul>
 */
class F03_SendMailFactory implements F03_Provider {  
    
	public F03_SendMailFactory(){};
    @Override  
    public F03_Sender produce(){  
        return new F03_MailSender();  
    }  
}  

class F03_SendSmsFactory implements F03_Provider{  
	  
	public F03_SendSmsFactory(){};
    @Override  
    public F03_Sender produce() {  
        return new F03_SmsSender();  
    }  
}  





