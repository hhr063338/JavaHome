package example.gernerics2;
/**
 * 泛型的嵌套设置
 *
 */
public class G11_Class10 {

	public static void main(String[] args) {
		Demo11<Info11<String, Integer>> d=null;//将info11作为Demo的泛型参数
		Info11<String,Integer> i=null;
		i=new Info11<String, Integer>("李兴华", 30);
		d=new Demo11<Info11<String,Integer>>(i);
		System.out.println("内容一："+d.getInfo().getVar());
		System.out.println("内容二："+d.getInfo().getValue());
		
	}


}
//假设在一个类中指定另外一个类的泛型
class Info11<K,V>{	//指定两个泛型类型
	private K var;		//第一个泛型属性
	private V value;	//第二个泛型属性
	public Info11(K var,V value){	//通过构造方法设置
		this.setVar(var);
		this.setValue(value);
	}
	public K getVar() {
		return var;
	}
	public void setVar(K var) {
		this.var = var;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
}

class Demo11<S>{
	private S info;
	public Demo11(S info){
		this.setInfo(info);
	}
	public S getInfo() {
		return info;
	}
	public void setInfo(S info) {
		this.info = info;
	}
	
}