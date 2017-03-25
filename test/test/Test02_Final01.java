package test;

public class Test02_Final01  {

	/***
	 * final修饰的类，具有属性常量，方法不可以重载overloading，类中的属性方法不可以继承
	 * @param args
	 */
	public static void main(String[] args) {
		 String str1=String.format("%04d",  10000000);
		 System.out.println(str1);
		 String str2="350582199003294713";
		 String str3=str2.substring(str2.length()-2,str2.length()-1);
		 System.out.println("###"+str3);
		
	}
}

class Test02_son extends Test02_Final01{
	
	public Test02_son(){
		super();
		
	}
}

final class Test02_parent{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
