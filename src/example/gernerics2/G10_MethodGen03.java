package example.gernerics2;
/**
 * 通过泛型方法返回泛型数组
 *
 */
public class G10_MethodGen03 {
	public static <T> T[] fun1(T...arg){//可变参数(表示参数个数可以是0至多个)，返回泛型
		return arg;		//返回数组
	}
	public static <T> void fun2(T param[]){//接收泛型数组
		System.out.println("接收泛型数组：");
		for(T t:param){
			System.out.print(t+"、");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Integer i[]=fun1(1,2,3,4,5);
		fun2(i);
	}


}
