package test;

public class Test01_Parent01 extends Grandfathrer{

	private String intresting;
	public Test01_Parent01(){
		super("张三");
	
	}
	public static void main(String[] args) {
		
		Test01_Parent01 test01=new Test01_Parent01();
		//test01.setName("是真的嘛");
		System.out.println(test01.getName());
	}
	
	protected String getIntresting() {
		return intresting;
	}
	void setIntresting(String intresting) {
		this.intresting = intresting;
	}
	
	
}
class Grandfathrer{
	private String name;

	public Grandfathrer(String name){
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
