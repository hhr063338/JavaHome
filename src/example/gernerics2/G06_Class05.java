package example.gernerics2;

/**
 * 
 * 受限泛型，限制泛型的范围
 * 限使用extends关键字声明，表示参数化的类型可能是所指定的类型或者是此类型的子类
 * 范围下限使用super进行声明，表示参数化的类型可能是所指定的类型，或者是此类型的父类型，或是Object类
 * 泛型与子类继承的限制：new Info<String> != new Info<Object>
 */
public class G06_Class05 {
	public static void main(String[] args){
		Info06<String> i=new Info06<String>();
		Info06<Integer> i2=new Info06<Integer>();
		i.setVar("活该");
		i2.setVar(33);
//		fun(i);//在这里是只有继承Number类的子类才可以当参数
		fun(i2);
		fun2(i);
	}
	public static void fun(Info06<? extends Number> temp){
		System.out.println("结果是数字吗？："+temp.getVar());
	}
	public static void fun2(Info06<? super String> temp){//上限，只能接收String类型或Object类型
		System.out.println("内容是"+temp);
	}
}


class Info06<T>{
	private T var;
	public T getVar() {
		return var;
	}
	public void setVar(T var) {
		this.var = var;
	}
	
}