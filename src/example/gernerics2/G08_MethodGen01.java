package example.gernerics2;
/**
 * 泛型方法的定义，泛型参数的应用,普通格式如下
 *  [访问权限] <泛型标识> 方法名称([泛型标识] 参数名称);
 *  注意：具有泛型方法的类，不需要在类上声明泛型标识
 *  
 */
public class G08_MethodGen01 {
	public <T> void fun(T t){	//可以接收任意类型的参数，无返回值
		System.out.println(t.toString());
	}
	public static <T extends Number> Info08<T> fun2(T var){//返回泛型实例
		Info08<T> temp=new Info08<T>();	//根据传入的数据类型实例化Info对象
		temp.setVar(var);			//将传递的内容设置到Info类中的var属性之中
		return temp;				//返回实例化对象
	}

	public static void main(String[] args) {
		G08_MethodGen01 gg=new G08_MethodGen01();
		gg.fun("there is a question");
		Info08<Integer> yy=gg.fun2(33);//利用泛型方法返回泛型对象
		System.out.println(yy.getVar());
		
		
	}



}

class Info08<T extends Number>{//此处泛型只能是数字
	private T var;		//此变量的类型由外部指定

	public T getVar() {
		return var;
	}

	public void setVar(T var) {
		this.var = var;
	}
	
}
