package example.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * <ul>
 * <li>文件名称: A06_FuntionAnn02.java</li>
 * <li>功能描述: 取得指定的Annotation中的内容</li>
 * </ul>
 */
public class A06_FuntionAnn02 {
	public static void main(String[] args) {
		Class<?> c=null;
		Method m=null;

		try {
			c=Class.forName("example.annotation.A06_Demo");//取得Class实例
			m=c.getMethod("toString");
			if(m.isAnnotationPresent(Anno_A06.class)){
				
				Anno_A06 anno06=null;//声明自定义的Annotation对象
				//取得自定义的Annotation注解
				anno06=m.getAnnotation(Anno_A06.class);
				String key=anno06.key();	//得到Annotation中指定的变量内容
				String value=anno06.value();
				System.out.println("key="+key);
				System.out.println("value="+value);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
//调用自定义注解
class A06_Demo{
	@Override
	@Anno_A06(key="ZS",value="张三")
	public String toString(){
		return "hello zhangSan!";
	}
}

//定义Runtime范围的注解
@Retention(value=RetentionPolicy.RUNTIME)
@interface Anno_A06{
	public String key() default "LXH";
	public String value() default "李兴华";
}









