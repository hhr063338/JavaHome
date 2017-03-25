package example.annotation;

/**
 * <ul>
 * <li>文件名称: A01_SysBuild.java</li>
 * <li>功能描述: 观察@Override注释的作用————系统内建的Annotation （3种）</li>
 * <li>*@Override：覆写的Annotation</li>
 * <li>*@Deprecated:不赞成使用的Annotation </li>
 * <li>*@SuppressWarning：压制安全警告的Annotation</li>
 * </ul>
 */
public class A01_SuppressWarnings {
	//此时压制两条警告，以数组形式添加要压制警告的类型，
	//第一种表示不检查，第二种压制使用了不赞成使用的类或方法时的警告
	@SuppressWarnings({"unchecked","deprecated"})
	public static void main(String[] args) {
		Demo_A01 d=new Demo_A01();//编译时的警告信息被压制
		d.setVar("李中兴");
		System.out.println("内容"+d.getVar());
	}

}
/*** @SuppressWarnings的关键字，添加进属性时，以数组形式添加
 *   depression：使用了不赞成使用的类或方法时的警告
 *   unchecked :执行了未检查的转换时警告，例如，泛型中没有指定泛型类型
 *   fallthrough：当使用了switch操作时，case后未加入break操作，而导致程序继续执行其他case语句时出现的警告
 *   path      ：当设置了一个错误的类路径、源文件路径时出现的警告
 *   serial    ：当在可续化类上缺少serialVersionUID定义时的警告
 *   finally   ：任何finally子句不能正常完成时的警告
 *   all       ：关于以上所有的警告
 * 
 */

/**
 * <ul>
 * <li>文件名称: A01_SuppressWarnings.java</li>
 * <li>功能描述: 用于验证@SuppressWarnings的使用</li>
 * </ul>
 */
class Demo_A01<T>{
	private T var;
	public T getVar(){
		return var;
	}
	@Deprecated
	public void setVar(T t){
		var=t;
	}
}
