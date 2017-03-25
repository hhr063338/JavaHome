package example.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Inherited的作用
 * 用于标注一个父类的注释是否可以被子类所继承，如果一个Annotation需要被其子类所继承，
 * 则在声明时直接使用@Inherited注释即可
 * @Inherited元注解，用来修饰注解，表示被修饰的注解修饰类时，该类的注解会被子类继承
 *
 */

//范例：通过反射取出全部的Annotation
public class A09_InheritedAnno {
		public static void main(String[] args) {
			Class<?> c=null;
			Annotation[] annos=null;
			try {
				c=Class.forName("example.annotation.Son_A09");
				annos=c.getAnnotations();
				for(Annotation a:annos){//输出全部的annotation
				System.out.println(a);
				}
				if(c.isAnnotationPresent(Anno_A09.class)){
					Anno_A09 an=null;	//声明自定义的Annotation
					an=c.getAnnotation(Anno_A09.class);//取得自定义的Annotation，此Annotation是从父亲继承而来
					String name=an.name();
					System.out.println("name="+name);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
}

//定义一个annotation
@Documented
@Inherited	//将其注释掉，就输出不了非空值
@Retention(RetentionPolicy.RUNTIME)
@interface Anno_A09{
	public String name();
}


//定义Person子类
@Anno_A09(name="王五")
class Person_A09{
}

class Son_A09 extends Person_A09{
	//为了验证之前的Annotation是否被继承，可以直接通过反射机制取出全部的Annotation
}
