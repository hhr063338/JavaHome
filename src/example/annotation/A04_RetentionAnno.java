package example.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/***title:深入学习注解，元注解
 *content： 要深入学习注解，必须能定义自己的注解并使用它，
 *  在定义自己的注解之前，我们必须了解Java为我们提供的 元注解 和 相关定义注解的方法
 * 元注解的作用就是负责注解其他注解，Java5.0定义了4个标准的meta-annotation类型，被用来描述说明注解
 * 1.@Target,作用：用于描述注解的使用范围（即：被描述的注解可以用在什么地方）
 * 2.@Retention,作用：表示需要在什么级别保存该注释信息，用于描述注解的生命周期（即：被描述的注解在什么范围内有效）
 * 3.@Documented,作用：修饰的注解应该被 javadoc工具记录. 默认情况下,javadoc是不包括注解的. 
 * 					但如果声明注解时指定了 @Documented,则它会被 javadoc 之类的工具处理, 
 * 					所以注解类型信息也会被包括在生成的文档中
 * 4.@Inherited,作用：
 */

//之前学过的注解override、SuppressWarning的注解范围都是SOURCE，而deprecated是RUNTIME，运行时，也会出现
/**
 * 注意Retention关键字的使用
 *	Annotation的保存范围由Retention注解决定，其唯一属性value的类型RetentionPolicy 保留策略
 *  RetentionPolicy有三大枚举值：
 *  Source   只保留在源文件*.java，编译后不会保存在字节码文件.class
 *  CLASS    可以保存在源文件和字节码文件，但不会加载到JVM，属于默认值
 *  RUNTIME  信息会保存在源文件和字节码文件并加载到JVM
 *  像@Override/@SuppressWarning定义用到的就是@Retention(value=Source),@Depretected是Runtime
 *  
 */
public class A04_RetentionAnno {
	
}

/**
 * 
 * <ul>
 * <li>文件名称: Anno_A04</li>
 * <li>功能描述: 通过元注解@Retention来声明注解的生命周期</li>
 * </ul>
 */
@Retention(value=RetentionPolicy.RUNTIME)
@interface Anno_A04{
	String value() default "洁癖";
}


