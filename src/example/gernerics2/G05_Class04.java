package example.gernerics2;
/**
 * 泛型应用中的通配符
 *
 */
public class G05_Class04 {
	public static void main(String[] args){
		Info05<String> i=new Info05<String>();
		i.setVar("李兴华");
		fun(i);
	}
//	public static void fun(Info05<Object> temp){//
//		System.out.println("内容是"+temp);
//	}
	public static void fun(Info05<?> temp){//注意这是当泛类型当参数的时候，这个类本身并不是
	System.out.println("内容是"+temp);
}
}

class Info05<T>{
	private T var;
	public T getVar() {
		return var;
	}
	public void setVar(T var) {
		this.var = var;
	}
	
}
