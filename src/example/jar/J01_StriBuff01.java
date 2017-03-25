package example.jar;
/**StringBuffer类的用法
 * String的内容一旦被声明则不可改变，如果要改变，改变的肯定是String的引用地址
 *
 */

public class J01_StriBuff01 {
	
	public static void main(String[] args) {
		J01_StriBuff01 jsb=new J01_StriBuff01();
		
		//1.测试字符串连接
		jsb.append();
		//2.在任意位置插入数据
		jsb.casualInsert();
		//3.反转字符串
		jsb.reversionOpperate();
		//4.指定范围内替换
		jsb.replaceLimit();
		//5.截取指定范围的内容
		jsb.subStr();
		//6.删除指定范围内的数据
		jsb.deleteLimit();
		//7.查找指定的内容是否存在
		jsb.findContent();
		//8.探讨String与StringBuffer的区别运用
		jsb.stringAdd();
		jsb.strBuffAdd();
		
	}
	
	/**
	 * 1.字符串连接操作
	 */
	public void append(){
		System.out.println("============任意连接数据====================");
		StringBuffer sb=new StringBuffer();
		sb.append("hello");//在StringBuffer中不像String使用“+”而是用方法append，可以添加任何类型的数据
		sb.append(", my name is ").append(true);//可以连续添加
	
		System.out.println(sb);
	
	}
	
	/**
	 * 2.在任意位置为StringBuffer添加内容
	 */
	public void casualInsert(){
		System.out.println("=================执行casualInsert()任意位置添加数据================");
		StringBuffer sb=new StringBuffer();
		sb.append("welcome to StringBuffer World!!!");
		System.out.println("sb变量："+sb);
		System.out.println("在0位置处插入hello");
		sb.insert(0, "hello");//插入数据
		System.out.println("此时sb变量："+sb);
		System.out.println("通过sb.length()在末尾添加\"why\"");
		sb.insert(sb.length(), "why");
		System.out.println(sb);
	}
	
	/**
	 * 3.字符串反转操作
	 * "hello"反转操作为"olleh"
	 */
	public void reversionOpperate(){
		System.out.println("*********利用sb.reverse().toString反转字符串****************");
		StringBuffer sb=new StringBuffer("hello");
		sb.append(" world!");
		System.out.println("将反转字符串\""+sb+"\"");
		String s=sb.reverse().toString();//将内容反转为String类型
		System.out.println(s);
	}
	
	/**
	 * 4.替换指定范围内的内容
	 * 在String中使用replaceAll()来进行替换，而StringBuffer用replace()方法
	 */
	public void replaceLimit(){
		System.out.println("==============替换指定范围的内容====================");
		StringBuffer sb=new StringBuffer();
		sb.append("welcome to ").append("my world!");
		sb.replace(0, 1, "y");//将w换成y
		String ss=sb.substring(8, 10);//注意含开头不含尾
		System.out.println(ss);
	}
	/**
	 * 5.截取指定范围内的字符串
	 */
	public void subStr(){
		System.out.println("****************截取指定范围的字符串**********************");
		StringBuffer sb=new StringBuffer("012345678");
		System.out.println(sb);
		System.out.println(sb.substring(3));//截取含头不含尾
		System.out.println(sb.substring(4, 7));
	}
	/**
	 * 6.删除指定范围的StringBuffer
	 */
	public void deleteLimit(){
		System.out.println("*******************删除指定范围的数据*************************");
		StringBuffer sb=new StringBuffer("hello , who are you?");
		sb.delete(sb.length()-8, sb.length()-4);
		System.out.println(sb);
	}
	/**
	 * 7.查找的指定内容是否存在
	 * 用indexOf方法查找，查到返回内容位置，否则返回-1
	 */
	public void findContent(){
		System.out.println("******************查找指定内容是否存在*************************");
		StringBuffer sb=new StringBuffer("hello,this is my world!");
	
		System.out.println(	sb.indexOf("world"));
		System.out.println(sb.indexOf("hello", 6));
	}
	/**
	 * 8.下面两个方法比较映射String与StringBuffer的不同（区别）
	 */
	public void stringAdd(){
		System.out.println("******************************String与StringBuffer的区别应用：**************************");
		String s="hello";
		for(int i=0;i<100;i++){
			s=s+i;
		}
		System.out.println(" String应用:"+s);
	}
	public void strBuffAdd(){
		StringBuffer sb=new StringBuffer("hello");
		for(int i=0;i<100;i++){
			sb.append(i);
		}
		System.out.println("StrBuff应用:"+sb);
	}


}
