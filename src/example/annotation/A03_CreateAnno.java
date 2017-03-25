package example.annotation;


/**
 * 创建Annotation中的属性声明与简单调用
 *  1.向annotation中设置内容（单个参数，多个参数，默认值）
 *  2.在Annotation中定义的属性，在使用时没有指定具体的内容，则在编译时也会出现错误,此时可以设置默认值
 *  3.使用default关键字来定义默认值
 *  4.使用枚举来限制取值范围
 *  
 *
 */
@Anno_A03_01("23")
@Anno_A03_02(value=13,key="索引13")//指定属性赋值
@Anno_A03_03(values={"张三","李四","王五"})//单个属性多个内容，用数组
@Anno_A03_04(name="孙乾")
@Anno_A03_05(evaluate=ValueScope.LK)
public class A03_CreateAnno {

	public static void main(String[] args) {
	}

}

/**
 * <ul>
 * <li>文件名称: Anno_A03_01</li>
 * <li>功能描述: 向自定义的Annotation中传递参数，则其必须使用变量接收参数</li>
 * </ul>
 */
@interface Anno_A03_01 {
	public String value();//注意这里的访问限制符，还有属性后面的括号
	
}
/***
 * <ul>
 * <li>文件名称: Anno_A03_02</li>
 * <li>功能描述: 在Annotation中定义多个变量</li>
 * </ul>
 */
@interface Anno_A03_02{
//	public Interger value();
	public  int value();	//注意声明的类型局限
	public String key();
}
/**
 * <ul>
 * <li>文件名称: Anno_A03_03</li>
 * <li>功能描述: 如果要为一个属性设置多个内容，则必须可以将一个属性定义成一个数组</li>
 * </ul>
 */
@interface Anno_A03_03{
	public String[] values();//设置数组
}

/***
 * <ul>
 * <li>文件名称: Anno_A03_04</li>
 * <li>功能描述: 给Annotation属性默认值</li>
 * </ul>
 */
@interface Anno_A03_04{
	String value() default "李中兴";//设置默认值
	String key() default "第一名";
	String name();
	
}
/**
 * <ul>
 * <li>文件名称: Anno_A03_05</li>
 * <li>功能描述: 通过枚举来限制Annotation的取值范围</li>
 * </ul>
 */
@interface Anno_A03_05{
	ValueScope evaluate() default ValueScope.EN;  //只能设置枚举中的取值，默认值为Enum中的内容
	//注意返回值的设定是枚举类型	
}
//定义枚举类型
enum ValueScope{
	EL,EN,LK;
}

/**
 * Invalid type Integer for the annotation attribute Anno_A03_02.value; only primitive type, String, Class, annotation,
 *  enumeration are permitted or 1-dimensional arrays thereof
 *  注解里的属性类型只能是基本数据类型，字符串，Class,注释和一维数组
 */
