package example.reflection;
/**
 * 利用反射机制生成对象（实例）newInstance()
 * 目标类必须含有无参构造函数
 */
public class R03_Intance01 {
	public static void main(String[] args){
		RPerson3 p=null;//声明RPerson3对象
		Class<?> c1=null;	//指定泛型
		try {
			
			c1=Class.forName("sample.reflection.RPerson3");//实例一个Class对象
			//传入要实例化类的完整包.类名称
			p=(RPerson3)c1.newInstance();
			//通过class对象实例化对应的类，注意使用这个方法则对应类必须含有无参构造函数,这个方法也会抛出异常
			//假如try语句块里抛出的异常是catch语句块所不能捕捉的异常，仍然会报错
			p.setAge(25);
			p.setName("李再兴");
			System.out.println(p.toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e2){
			e2.printStackTrace();
		}
	
	}
}

class RPerson3{
	private String name;
	private int age;
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
	@Override
	public String toString() {
		
		return "姓名："+this.getName()+",年龄："+this.getAge();
	}
	
	
	
}
