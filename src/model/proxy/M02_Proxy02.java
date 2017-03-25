package model.proxy;

import org.junit.Test;


/**
 * 静态代理：每一个代理类只能为一个接口服务
 * 动态代理：通过一个代理类完成全部的代理功能在Java中要实现动态代理机制，
 * 			则需要java.lang.reflect.InvocationHandler接口
 * 			和java.lang.reflect.Proxy类的支持
 * InvocationHandler接口的定义：
 * public interface InvocationHandler{
 * 			public Object invoke(Object proxy,Method method,Object[] args) throws Throwable;
 * }
 * 每一个动态代理类都必须实现InvocationHandler这个接口，并且每个代理类的实例都关联到了一个handler，
 * 当我们通过代理对象调用一个方法的时候，这个方法的调用就会被转发为由InvocationHandler
 * 这个接口的 invoke 方法来进行调用,其中三个参数说明
 * proxy:　　指代我们所代理的那个真实对象 ; method:指代的是我们所要调用真实对象的某个方法的Method对象
 * args:　　指代的是调用真实对象某个方法时接受的参数
 * 
 * Object proxy:被代理的对象；Method method：要调用的方法；Object[] args:方法调用时所需要的参数
 * Proxy类是专门完成代理的操作类，可以通过此类为一个或多个接口动态地生成实现类。Proxy类提供了如下的操作方法：
 * Public static Object newProxyInstance(ClassLoader loader,Class<?>[] interface,InvocationHandler h) throws IllegalArgumentException
 * 通过newProxyInstance方法可以动态地生成实现类，此方法中的参数意义如下：
 * ClassLoader loader：类加载器；Class<?>[] interface:得到全部的接口；
 * InvocationHandler h：得到InvocationHandler接口的子类实例
 * 具体参数说明：
 * loader:　　一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
 * interfaces:　　一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
 * h:　　一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上
 * 求类加载器
 */
public class M02_Proxy02 {

	public static void main(String[] args) {
		M02_Proxy02 m02=new M02_Proxy02();
		m02.getClassLoader();
	}

	//求默认使用的类加载器：负责加载java类字节码到java虚拟机中
	@Test
	public void getClassLoader(){
		PersonM02 p=new PersonM02("李中兴",25);
		System.out.println("类加载器:"+p.getClass().getClassLoader().getClass().getName());
	}
}


//实体类Person
class PersonM02{
	private String name;
	private int age;
	public PersonM02(){}
	public PersonM02(String name){
		this.name=name;
	}
	public PersonM02(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
