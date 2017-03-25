package example.gernerics2;
/**
 * 
 * *  使用泛型统一传入的参数类型
 */
public class G09_MethodGen02 {
	
	public static void main(String[] args) {
		Info09<String> i1=new Info09<String>();
		Info09<String> i2=new Info09<String>();
		Info09<Integer> i3=new Info09<Integer>();
		i1.setVar("the first");
		i2.setVar("the two");
		i3.setVar(33);
		G09_MethodGen02 gg=new G09_MethodGen02();
		gg.check(i1, i2);
//		gg.check(i1, i3);
	
	}
	public static <T> void check(Info09<T> t1,Info09<T> t2){	//传入check()方法中的两个参数数据类型必须一致
		System.out.println(t1+"||"+t2);			//如果传入不一致，在编译时会报错
	}


}

class Info09<T>{
	private T var;

	public T getVar() {
		return var;
	}

	public void setVar(T var) {
		this.var = var;
	}
	
}
