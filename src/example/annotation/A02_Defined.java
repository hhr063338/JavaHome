package example.annotation;

/** 自定义的annotation
 * [public] @interface Annotation名称{
 * 		数据类型  变量名称();//注意这里需要添加“()”
 * }
 *  要定义Annotation必须使用@interface的方式进行定义，但是从上面的格式，可以看出
 *  在定义Annotation时也可以定义各种变量，但是变量定义之后必须使用“()”
 *  用@interface修饰自定义Annotation，相当于该Annotation继承java.lang.annotation.Annotation接口
 */
@Anno_A02
public class A02_Defined {

}
@interface Anno_A02{	//定义Annotation
	
}
