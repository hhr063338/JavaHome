package model.single;

/**
 * <ul>
 * <li>文件名称: S01_SinglePattern01.java</li>
 * <li>功能描述: 单例模式</li>
 * </ul>
 */
public class S01_SinglePattern01 {
	/***单例模式介绍
	 * 单例对象（singleton）是一种常用的设计模式，在Java应用中，单例对象能保证在一个JVM中，该对象只有一个
	 * 实例存在，这样的模式有几个好处：
	 * 1.某些类创建比较频繁，对一些大型的对象，这是一笔很大的系统开销
	 * 2.省去new操作符，降低了系统内存的使用频率，减轻GC压力
	 * 3.有些类如交易所的核心交易引擎，控制着交易流程，如果该类可以创建多个的话，系统完全乱了
	 */

}

/***
 * <ul>
 * <li>文件名称: S01_Singleton01.java</li>
 * <li>功能描述: 简单的单例类</li>
 * <li>功能描述: 这个类满足基本要求，像这样毫无线程安全保护的类，如果我们把他们放入多线程的环境
 * 				肯定就会出现问题，如何解决？
 * </li>
 * </ul>
 */
class S01_Singleton01 {  
	  
    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */  
    private static S01_Singleton01 instance = null;  
  
    /* 私有构造方法，防止被实例化 */  
    private S01_Singleton01() {  
    }  
  
    /* 静态工程方法，创建实例 */  
    public static S01_Singleton01 getInstance() {  
        if (instance == null) {  
            instance = new S01_Singleton01();  
        }  
        return instance;  
    }  
  
    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
    public Object readResolve() {  
        return instance;  
    }  
}  
