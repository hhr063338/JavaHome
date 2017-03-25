package example.annotation;


import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


/**
 * <ul>
 * <li>文件名称: A05_FunctionAnno01.java</li>
 * <li>功能描述: 取得全部的Annotation </li>
 * <li>功能描述: 想让Annotation起作用，必须结合反射机制，获取指定方法、类中的所有注解</li>
 * </ul>
 */
public class A05_FunctionAnno01 {
	public static void main(String[] args) {
		Class<?> c=null;
		Method m=null;
		Annotation[] n=null;//这里需要注意的是导入的是java.lang.annotation.Annotation;
		
		try {
			c=Class.forName("example.annotation.simpleA05");
			m=c.getMethod("toString");
			n=m.getAnnotations();//获取指定方法的所有注解
			for(Annotation a:n){
				System.out.println(a);
				//虽然toString()方法有三个注解，但只有deprecated打印出来，
				//这是因为只有deprecated的注解生命周期为Runtime级别，信息会保存在源文件和字节码文件并加载到JVM
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}

//编写有注解的简单类
class simpleA05{
	@SuppressWarnings("unchecked")
	@Deprecated
	@Override
	public String toString(){
		return "hello lizhanghua";
	}
}




