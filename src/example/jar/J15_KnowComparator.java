package example.jar;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 另一种比较器Comparator
 * 当类建立的时候没有实现Comparable接口，但又想进行对象排序，此时可以使用Comparator接口
 *
 */
/**java.util.Comparator接口定义
 * public interface Comparator<T>{
 * 		public int compare(To1,To2);
 * 		boolean equals(Object obj);
 * }
 * 与Comparable接口的compareTo()方法类似，只是compare方法需要接收两个参数，然后返回1,0，-1
 */
public class J15_KnowComparator {

	public static void main(String[] args) {
		//为对象数组排序
		System.out.println("***********使用compare(To1,To2)方法来定义排序规则********************");
		J15_Student[] js={new J15_Student("张三", 22),new J15_Student("李四", 23),new J15_Student("王五", 22)};
		Arrays.sort(js, new J15_StudentComparator());//排序，指定排序规则
		System.out.println("输出数组是否已经按年龄大小排序");
		for(J15_Student s:js){
			System.out.println(s.toString());
		}
		
	}
	
	
}
//定义比较规则
class J15_StudentComparator implements Comparator<J15_Student>{//实现比较器接口

	@Override
	public int compare(J15_Student o1, J15_Student o2) {	//为学生定义比较规则
		if(o1.equals(o2)){
			return 0;
		}else if(o1.getAge()<o2.getAge()){
			return 1;	
		}else{
			return -1; //表示o1.getAge()>o2.getAge() 按年龄由大到小排序
		}
		
	
	}
	
	
}

//定义学生类，具有年龄与姓名，按照年龄排序
class J15_Student{
	private String name;
	private int age;
	J15_Student(){};
	public J15_Student(String name,int age){
		this.name=name;
		this.age=age;
	}
	//覆写equals方法，来区分对象
	@Override
	public boolean equals(Object obj) {
		if(this==obj){
			return true;
		}
		if(!(obj instanceof J15_Student)){
			return false;
		}
		J15_Student js=(J15_Student)obj;
		if(js.name.equals(this.name)&&js.age==this.age){
			return true;
		}else{
			return false;
		}
	}
	
	public String toString(){
		return "name:"+this.name+"\tage:"+this.age;
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
