package example.gernerics2;

/**
 * 指定多个泛类型
 *
 */
public class G04_Class03 {

	public static void main(String[] args){
		Point04<String,Integer> p=null;
		p=new Point04<String,Integer>();
		p.setX("李兴华");
		p.setY(30);
		System.out.println("姓名："+p.getX()+" ,年龄："+p.getY());
	}
}

class Point04<K,V>{
	private K x;
	private V y;
	public K getX() {
		return x;
	}
	public void setX(K x) {
		this.x = x;
	}
	public V getY() {
		return y;
	}
	public void setY(V y) {
		this.y = y;
	}
	
}