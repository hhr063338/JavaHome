package instance.practical;

import java.util.Date;



public class Test_Extend {

}

class Test_Son extends Test_Person{
	private String name;
	private String date;
	public Test_Son(){}
	public Test_Son(String name,String date){
		this.name=name;
		this.date=date;
	}
//	public String getDate() {
//		return date;
//	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

class Test_Person{
	private String name;
	private Date date;
	public Test_Person(){}
	public Test_Person(String name,Date date){
		this.name=name;
		this.date=date;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
