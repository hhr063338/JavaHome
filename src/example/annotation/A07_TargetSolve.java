package example.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation出现的位置（注解的使用范围）
 * 1.一般定义的Annotation，若没有指明位置，则可以在任意的位置上调用
 * 2.可以通过@Target来定义自定义Annotation调用的位置
 *
 */

/* @Target的定义
 * @Retention(value=runtime)
 * @Target(value=annotation_type)
 * public @interface Target{
 * 	public abstract ElementType[] value;//表示可以接收一个数组
 * }
 */

/* @Target定义位置的范围属性值为ElementType枚举限定范围.
 * ANNOTATION_TYPE:只能用在注释的声明上
 * CONSTRUCTOR:只能用在构造方法的声明上
 * FIELD:只能用在字段的声明上
 * Local_variable:只能用在局部变量的声明上
 * METHOD：只能用在方法的声明上
 * PACKAGE:只能用在包的声明上
 * Parameter：只能用在参数的声明上
 * type:只能用在类、接口、枚举类型上
 * 
 */

public class A07_TargetSolve {
	
}


//定义调用此Annotation的类
@Anno_A07
class Demo_A07{
	//@Anno_A07  //如果放在方法上就会报错
	public String toString(){
		return "Demo_A07";
	}
}






@Documented
@Target(ElementType.TYPE)	//该元注解定义注解只能用在类、接口、枚举类型上
@Retention(value=RetentionPolicy.RUNTIME)	//该元注解修饰注解，表示注解在被编译后加载到JVM中仍然保存注解信息
@interface Anno_A07{
	public String key() default "LXH";
	public String value() default "李兴华";
}
