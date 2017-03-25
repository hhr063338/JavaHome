package example.jar;
/**finalize()方法的使用
 * 一个对象如果不再被任何栈内存所引用，那么此对象就可以称为垃圾对象
 * 实际上在Object类中有一个finalize()方法
 * （protected void finalize() throws Throwable），
 * 一个子类只需要覆写此方法即可在释放对象前进行某些操作
 *
 */
public class J07_KnowFinalize {
	public static void main(String[] args) {
//		J07_KnowFinalize j07=new J07_KnowFinalize();
//		//1.观察对象释放
//		j07.testGc();
		System.out.println("**********观察对象释放*********************");
		J07_Person j7=new J07_Person("李三", 25);

		j7=null;//断开引用，释放空间
		System.gc();//强制释放空间
		
	}
	
	//观察对象释放
	public void testGc(){
		System.out.println("**********观察对象释放*********************");
		J07_Person j7=new J07_Person("李三", 25);
		j7=null;//断开引用，释放空间
		System.gc();//强制释放空间
	}


}

class J07_Person{
	private String name;
	private int age;
	
	public J07_Person(String str1,int age){
		this.name=str1;
		this.age=age;
	}
	public String toString(){
		return "姓名:"+name+",年龄:"+age;
	}
	
	protected void finalize() throws Throwable {//对象释放空间，默认调用此方法
		// TODO Auto-generated method stub
//		super.finalize();
		System.out.println("J07_Person对象被释放-->"+this);//直接打印调用toString方法
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
