package example.gernerics2;

/**
 * 泛型接口
 *
 */
public class G07_Class06 {


	public static void main(String[] args) {
		Info07 info1=null;		//定义接口对象
		info1=new Info07Impl<String>("李兴华");		//通过子类实例化此对象
		System.out.println("info1内容是："+info1.getVar());
		////////////////////////////////
		Info07 info2=null;		//定义接口对象
		info2=new Info07Impl2("李兴华");		//通过子类实例化此对象
		System.out.println("info2内容是："+info2.getVar());
	}

}

interface Info07<T>{	//定义泛型接口，跟定义泛型类格式差不多
	public T getVar();
}
//定义泛型接口子类的方式有两种
//第一种 在子类的定义上声明泛型类型
class Info07Impl<T> implements Info07<T>{	//定义泛型接口的子类
	private T var;					//定义泛型属性
	public Info07Impl(T var){
		this.setVar(var);
	}
	
	public T getVar(){				
		return this.var;
	}
	public void setVar(T var){
		this.var=var;
	}
	
}
//第二种 直接在接口中指定具体类型
class Info07Impl2 implements Info07<String>{
	private String var;					//定义泛型属性
	public Info07Impl2(String var){
		this.setVar(var);
	}
	
	public String getVar(){				
		return this.var;
	}
	public void setVar(String var){
		this.var=var;
	}
}
