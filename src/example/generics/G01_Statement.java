package example.generics;

/*
 * 从本包中主要讲解泛型的声明、应用
 * 在这里通过坐标寻位置的例子讲解
 */
public class G01_Statement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Point<T>{
	private T var;
	public T getVar(){
		return var;
	}
	public void setVar(T var){
	   this.var=var;
	}
}
