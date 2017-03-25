/**
 * 
 */
package example.gernerics2;

/**
 * 泛型应用中的构造方法
 * 通过构造方法指定泛型定义的属性
 */
public class G03_Class02 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point03<String> p=null;	//定义泛类型对象
		p=new Point03<String>("李兴华");
		System.out.println("内容是："+p.getVar());

	}

}

class Point03<T>{
	private T var;
	
	Point03(T var){
		this.var=var;
	}

	public T getVar() {
		return var;
	}

	public void setVar(T var) {
		this.var = var;
	}
	
}
