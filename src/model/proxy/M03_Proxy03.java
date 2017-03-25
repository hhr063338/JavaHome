package model.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 范例：完成动态代理
 *
 */
public class M03_Proxy03 {
	//测试动态代理
	public static void main(String[] args) {
		InvocationHandlerM03 handler=new InvocationHandlerM03();//实例化代理操作类
		RealSubject realSub=new RealSubject();
		Subject sub=(Subject)handler.bind(realSub);//绑定操作
		System.out.println("含实现对象的代理类:"+sub.getClass().getName());
		System.out.println("执行具体操作的实现类:"+realSub.getClass().getName());
		String info=sub.say("李忠", 22);//通过动态代理调用方法
		System.out.println(info);
	}



}

//首先定义一个InvocationHandler接口的子类，以完成代理的具体操作
/**
 *  通过bind()方法接收被代理对象的真实主题实现，
 *  之后覆写InvocationHandler接口中的invoke()方法，完成具体的方法调用
 */
class InvocationHandlerM03 implements InvocationHandler{
	private Object obj;	//真实主题
	public Object bind(Object obj){//绑定真实操作主题
		this.obj=obj;
		//取得代理对象
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
		
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {	//动态地调用方法
		Object temp=method.invoke(this.obj, args);//调用方法，传入真实主题和参数
		return temp;	//返回方法和返回信息
	}
	
}

//定义接口
interface Subject{
	public String say(String name,int age);
}

//定义真实主题实现类
class RealSubject implements Subject{
	public String say(String name ,int age){
		return "咱们班的"+name+"今年"+age+"岁";
	}
}