package example.gernerics2;
/**
 * 基本泛型的定义与实现
 *
 */

public class G02_Class01 {
	public static void main(String[] args){
		Point2<Integer> p=new Point2<Integer>();
		p.setX(33);//只能用Integer类型做参数，在这里设置整数，自动装箱，将整数包装成Integer
		p.setY(20);
		//p.setY("执行这句会出错");//错误不能设置字符串
		System.out.println("这个店(x,y)的坐标：( "+p.getX()+" , "+p.getY()+" )");
	}
	

}

class Point2<T>{		//指定泛型类型
	private T x;		//指定x坐标，具体类型由外部指定
	private T y;		//指定y坐标，具体类型由外部指定
	public T getX() {
		return x;
	}
	public void setX(T x) {
		this.x = x;
	}
	public T getY() {
		return y;
	}
	public void setY(T y) {
		this.y = y;
	}
	
}
