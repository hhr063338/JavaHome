package model.proxy;

/***
 * <ul>
 * <li>文件名称: NP01_Proxy01.java</li>
 * <li>功能描述: 介绍代理模式</li>
 * </ul>
 */
public class NP01_Proxy_Test01 {

	/***
	 * 代理模式就是多一个代理类出来，替原对象进行一些操作，
	 * 比如我们在租房子的时候回去找中介，为什么呢？因为你对该地区房屋的信息掌握的不够全面，
	 * 希望找一个更熟悉的人去帮你做，此处的代理就是这个意思。
	 * 
	 * 代理模式中的角色
	 * 抽象角色：声明真实对象和代理对象的共同接口。
	 * 代理角色：代理对象角色内部含有对真实对象的引用，从而可以操作真实对象，
	 *   同时代理对象与真实对象相同的接口以便在任何时刻都能代替真实对象。同时代理独享可以再执行对真实对象的操作时，附加其他操作，相当于对真实对象进行封装。
	 * 真实角色：代理角色所代表的真实对象，是我们最终要引用的对象
	 */
	public static void main(String[] args) {
		
		NP01_Sourceable proxy=new NP01_Proxy01();
		proxy.method();
	}
	/***
	 * 如果已有的方法在使用的时候需要对原有的方法进行改进，此时有两种办法：
	 * 1、修改原有的方法来适应。这样违反了“对扩展开放，对修改关闭”的原则。
	 * 2、就是采用一个代理类调用原有的方法，且对产生的结果进行控制。这种方法就是代理模式。
	 * 使用代理模式，可以将功能划分的更加清晰，有助于后期维护！
	 *
	 */
}

/**抽象角色，代理接口**/
interface NP01_Sourceable{
	public void method();
}
/**真实角色，真实角色***/
class NP01_Source implements NP01_Sourceable{
	
	public void method(){
		System.out.println("the Source's method");
	}

}
/**代理角色，代理类**/
class NP01_Proxy01 implements NP01_Sourceable{
	
	private NP01_Source source;
	
	public NP01_Proxy01(){
		super();
		this.source=new NP01_Source();
	}
	public void method(){
		before();
		source.method();
		after();
	}

	
	
	private void before(){
		System.out.println("the proxy's before");
	}
	
	private void after(){
		System.out.println("the proxy's after");
	}
		
}




