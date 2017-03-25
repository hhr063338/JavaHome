package example.gernerics2;

/**
 *  通过坐标定点，展思泛型
 * 
 */
public class G01_Root {

	public static void main(String[] args){
		Poin01 p=new Poin01();
		p.setX(new Integer(15));
		p.setY(20);
		System.out.println("这个店(x,y)的坐标：( "+p.getX()+" , "+p.getY()+" )");
		
		//
		p.setX("横坐标为10");
		p.setY(20);
		System.out.println("这个店(x,y)的坐标：( "+p.getX()+" , "+p.getY()+" )");
		
		
		
	}
}

class Poin01{
	private Object x;
	private Object y;
	
	public Object getX() {
		return x;
	}

	public void setX(Object x) {
		this.x = x;
	}

	public Object getY() {
		return y;
	}

	public void setY(Object y) {
		this.y = y;
	}
}
