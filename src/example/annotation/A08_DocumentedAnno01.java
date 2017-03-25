package example.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * <ul>
 * <li>文件名称: A08_DocumentedAnno01.java</li>
 * <li>功能描述: @Document的作用,任何一个自定义的Annotation实际上都是通过@Document进行注释的</li>
 * <li>功能描述: 在生成javadoc时可以通过@Documented将一些文档信息的说明写入</li>
 * </ul>
 */
public class A08_DocumentedAnno01 {
	
	/**
	 * 此方法在对象输出时调用，返回对象的信息
	 */
	@Anno_A08(key="LXH",value="李兴华")
	public String toString(){
		return "hello, LiXingHua";
	}
}


@Documented
@Retention(value=RetentionPolicy.RUNTIME)	//此Annotation在类执行时依然有效
@interface Anno_A08{
	public String key() default "LXH";
	public String value() default "李兴华";
}