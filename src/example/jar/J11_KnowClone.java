package example.jar;


public class J11_KnowClone {
	public static void main(String[] args) throws Exception {
		J11_KnowClone j11=new J11_KnowClone();
		//1.对象的克隆操作
		j11.learnClone();
		
	}
/**
 * 在java中支持对象的克隆操作，直接使用Object类中的clone()方法即可
 * 方法定义：protected Object clone() throws CloneNotSupportedException
 * 很明显，该方法是受保护的方法，所以在子类中必须覆写此方法，且覆写之后扩大访问权限，这样才能被外部调用
 * 但具体的实现还是在Object中，所以在覆写的方法中只需要Object类的clone()方法即可完成操作
 * 而且对象所在的类必须实现Cloneable接口才可以完成对象的克隆操作
 * Cloneable接口没有定义方法，此接口在设计上称为是一种标识接口，表示对象可以被克隆
 */
	public void learnClone() throws Exception{
		System.out.println("***********学习clone克隆对象************");
		//对象的克隆操作
		Person p=new Person("张三");
		
		
		System.out.println("原始对象:"+p);
		System.out.println("克隆对象:"+p.clone().toString());
	}
	

}

//实现Cloneable接口的Person类
class Person implements Cloneable{
	private String name;
	private int age;
	
	//需要子类覆写clone方法
	@Override
	public Object clone() throws CloneNotSupportedException {//扩大访问权限
		return super.clone();//具体的克隆操作由父类完成
	}
	public Person(){}
	public Person(String name){
		this.name=name;
		this.age=25;
	}
	

	public String toString() {
		return "姓名:"+name+",年龄:"+age;
	
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