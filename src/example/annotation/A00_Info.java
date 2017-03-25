package example.annotation;

/** 
 * JDK5.0以后添加对元数据的支持，这种元数据成为注释（Annotation），
 * 通过使用注释，程序员可以在不改变原有逻辑的情况下，在源文件嵌入一些补充信息
 * 
 *	本章就java中提供的3种内建Annotation及自定义的Annotation进行讲解，并在最后结合Java的反射机制让读者
 *  理解Annotation的实际作用
 */

/**** Annotation的配置 
 * java.lang.annotation.Annotation接口,只要是Annotation都必须实现此接口，
 * 其中Annotation可以用来修饰类、方法、属性，且不影响程序运行，下面是该接口的定义
	public interface Annotation{
		public Class<? extends Annotation> annotationType();//返回此annotation的注释类型
		public boolean equals(Object obj);
		public int hashcode();
		String toString();
	}
****/
public class A00_Info {

}

