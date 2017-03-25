package model.proxy;


/**
 * <ul>
 * <li>文件名称: M01_Proxy01.java</li>
 * <li>功能描述: 介绍代理模式</li>
 * </ul>
 */
public class M01_Proxy01 {
	
	/**
	 * 设计模式——代理设计：其定义是 对其他对象提供一种代理以控制对这个对象的访问
	 * 在代理模式下的角色主要有：抽象角色、代理角色、真实角色
	 * 你不要企图它会帮你干实质性的工作，在生成它的实例时你必须提供一个进行实际操作的对象也就是真实角色
	 */
	public static void main(String[] args) {
		Network net=null;	//定义接口对象
		net=new Proxy(new Real());//实例化代理，同时传入代理的真实操作
		net.browse();		//客户只关心上网浏览一个功能
	}



}

/**抽象接口**/
interface Network{
	public void browse();//定义浏览的抽象方法
	
}

/**真实角色***/
class Real implements Network{
	public void browse() {	//真实的上网操作
		System.out.println("上网浏览信息");
	}			
}

/**代理角色**/
class Proxy implements Network{//代理操作
	private Network newone ;
	public Proxy(Network network){//设置代理的真实操作
		this.newone=network;//设置代理的子类
	}
	
	public void check(){	//与具体上网操作有关
		System.out.println("检查用户是否合格");
		
	}
	public void browse(){
		this.check();
		this.newone.browse();
	}
}