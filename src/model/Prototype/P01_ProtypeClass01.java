package model.Prototype;

import org.apache.commons.lang3.exception.CloneFailedException;

/***
 * <ul>
 * <li>文件名称: P01_Protype01.java</li>
 * <li>功能描述: 原型模式</li>
 * </ul>
 */
public class P01_ProtypeClass01 {

	/***
	 * 原型模式：是将一个对象作为原型，对其进行复制、克隆，产生一个和原对象类似的新对象
	 * 本小节会通过对象的复制，进行讲解，在java中，复制对象是通过clone()实现的
	 */
	/***了解对象的深、浅复制的概念
	 * 浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的
	 * 深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。简单来讲，就是深复制进行了完全彻底的复制，而浅复制不完全
	 */
}

/***
 * <ul>
 * <li>文件名称: P01_ProtypeClass01.java</li>
 * <li>功能描述: 简单的原型类</li>
 * </ul>
 */
class P01_Protype01 implements Cloneable{
	/**在Java中，复制对象是通过clone()实现的，先创建一个原型类**/
	public Object clone() throws CloneNotSupportedException{
		P01_Protype01 proto=(P01_Protype01)super.clone();
		return proto;
	}
	/****
	 * 一个简单的原型类只需实现Cloneable接口，覆写clone方法，因为它是空接口，所以此处clone方法名可以随便写，
	 * 此处的super.clone调用的是Object的clone（）方法，而在Object类中，clone()是native的
	 */
}


