package example.jar;

import java.util.Arrays;

/**
 * 比较器的使用
 * 清楚comparable接口中compareTo方法定义的规则对排序的影响
 */
public class J13_KnowComparable {

	/*
	 * Arrays.sort()方法重载很多次，可以对任意类型的数组排序，排序时会根据数值的大小进行排序
	 * 但是要想使用此方法也是有要求的，即对象的类必须实现Comparable接口，该接口用于指定对象排序规则的
	 * 
	 */
	/**
	 * Comparable接口的定义：
	 * public interface Comparable<T>{
	 * 	public int compareTo(T o);
	 * }
	 * compareTo方法返回的int型数据，1表示大于，-1表示小于，0表示等于
	 */
	public static void main(String[] args) {
		Student[] ss={new Student("张三",23,95.0f),new Student("李四", 24, 96.5f),new Student("王五", 25, 97.3f),new Student("吴六",24 , 95.00f),
				new Student("郑七",23,95.0f)};
		Arrays.sort(ss);//进行排序操作
		for(Student s:ss){
			System.out.println(s.toString());//输出数组内容
		}
	}
	/**
	 * 分析比较器的排序原理
	 */


}

/**
 * 设计学生类，并产生数组，要求按成绩由高到低排序，如果成绩由低到高排序
 * 当成绩一样的时候，按年龄排序，从高到低
 *
 */
class Student implements Comparable<Student>{
	private String name;
	private int age;
	private float score;
	
	public Student(String name,int age,float score){
		this.name=name;
		this.age=age;
		this.score=score;
	}

	//覆写compareTo()方法，实现排序规则的应用，排序按返回值大小排序（由低到高）
	public int compareTo(Student s) {
		if(this.score<s.score){
			return 1;
		}else if(this.score>s.score){
			//因为排序按返回值大小排序（由低到高），所以当返回值为-1时
			//表示第一个数比第二个数大的排序规则即符合this.score>s.score
			return -1;
		}else{
			if(this.age>s.age){
				return 1;
			}else if(this.age<s.age){
				return -1;
			}else{
				return 0;
			}
		}
		
	
	}
	public String toString(){
		return "name:"+name+"\tage:"+age+"\tscore:"+score;
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

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
	
	
}
