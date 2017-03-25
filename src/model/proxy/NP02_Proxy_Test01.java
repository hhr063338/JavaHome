package model.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/***
 * <ul>
 * <li>文件名称: NP02_Proxy_Test01.java</li>
 * <li>功能描述: 动态代理</li>
 * </ul>
 */
public class NP02_Proxy_Test01 {

	/***
	 * Java动态代理主要涉及到两个类：
	 * InvocationHandler：该接口中仅定义了一个Object : 
	 * 	invoke(Object proxy, Method method, Object[] args);
	 *  参数proxy指代理类，method表示被代理的方法，args为method中的参数数组，返回值Object为代理实例的方法调用返回的值。这个抽象方法在代理类中动态实现。
	 *  Proxy：所有动态代理类的父类，提供用于创建动态代理类和实例的静态方法。
	 *  
	 *  所谓动态代理类是在运行时生成的class，在生成它时，你必须提供一组interface给它，则动态代理类就宣称它实现了这些interface。
	 *  当然，动态代理类就充当一个代理，你不要企图它会帮你干实质性的工作，在生成它的实例时你必须提供一个handler，由它接管实际的工作
	 */
	public static void main(String[] args) {
		//客户端测试
		
		//创建目标对象，也就是被代理对象
		NP02_Subject realProject=new NP02_RealSubject();
		
		//将目标对象交给代理,构建代理对象
		InvocationHandler handler=new NP02_DynamicProxy(realProject);
		
		//      Class<?> proxyClass = Proxy.getProxyClass(Subject.class.getClassLoader()  
		//      , new Class[]{Subject.class});  
		//Subject subject = (Subject)proxyClass.getConstructor(new Class[]{InvocationHandler.class})  
		//      .newInstance(new Object[]{handler});  
		  
		/**返回代理对象，相当于上面两句
		 * ClassLoader: 指定哪个ClassLoader产生代理对象，这里应该与被代理对象同一个ClassLoader
		 * interface[]: 指被代理对象实现的接口，用来宣称代理对象以实现的接口
		 * InvocationHandler:指代理对象调用的业务逻辑
		 */  
		NP02_Subject proxy = (NP02_Subject)Proxy.newProxyInstance(handler.getClass().getClassLoader(),  //用到ClassLoader，代理对象与被代理对象应该使用同一个
				realProject.getClass().getInterfaces(),  //被代理对象实现的接口，这里采用组合方式
		        handler);  //最后实现的代理对象调用的方法是由谁处理，所以传入handler
		  
		//叫代理对象去doSomething()，其实在代理对象中的doSomething()中还是会  
		//用handler来调用invoke(proxy, method, args) 参数proxy为调用者subject(this)，  
		//method为doSomething()，参数为方法要传入的参数，这里没有  
		proxy.doSomething(); 
		/***
		 * 所谓动态代理类是在运行时生成的class，在生成它时，你必须提供一组interface给它，则动态代理类就宣称它实现了这些interface。
		 *  当然，动态代理类就充当一个代理，你不要企图它会帮你干实质性的工作，在生成它的实例时你必须提供一个handler，由它接管实际的工作
		 */
	}
}

/***
 * <ul>
 * <li>文件名称: NP02_Proxy_Test01.java</li>
 * <li>功能描述: 抽象角色：声明真实对象和代理对象的共同接口 </li>
 * </ul>
 */
interface NP02_Subject{
	public void doSomething();
}

/**
 * <ul>
 * <li>文件名称: NP02_Proxy_Test01.java</li>
 * <li>功能描述: 真实对象：定义目标操作</li>
 * </ul>
 */
class NP02_RealSubject implements NP02_Subject{
	
	public void doSomething(){
		System.out.println("NP02_RealSubject's doSomething method !");
	}
}

/***
 * <ul>
 * <li>文件名称: NP02_Proxy_Test01.java</li>
 * <li>功能描述: 处理类由代理对象调用，并不是代理类，因为没有与真实类共同实现的接口</li>
 * </ul>
 */
class NP02_DynamicProxy implements InvocationHandler{
	
	private Object object;
	
	public NP02_DynamicProxy(Object object){
		this.object=object;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("NP02_DynamicProxy Before Invoke ! method:"+method);
		
		//我们可以再代理方法调用前后添加功能
		Object result=method.invoke(object, args);
		
		System.out.println("object:"+object+"\tresult:"+result+"\targs:"+args);
		System.out.println("NP02_DynamicProxy After Invoke!");
		return result;
	}

}
