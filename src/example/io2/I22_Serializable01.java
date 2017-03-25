package example.io2;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

import tool.ToolUtil01;

/**
 * <ul>
 * <li>文件名称: I22_Serializable01.java</li>
 * <li>功能描述: 对象序列化与Serializable接口</li>
 * <li>功能描述: 对象输出流（ObjectOutputStream）和对象输入流（ObjectInputStream）</li>
 * <li>功能描述: 序列化的不同主要表现在实体类构建的不同</li>
 * </ul>
 */
public class I22_Serializable01 {

	ToolUtil01 tool=new ToolUtil01();
	/***
	 * 对象序列化：就是把一个对象变为二进制的数据流的一种方法，通过对象序列化可以方便地实现对象的传输或存储
	 * 如果一个对象想被序列化，必须实现序列化接口，所以此接口是一个标识接口
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		I22_Serializable01 i22=new I22_Serializable01();
//		System.out.println("===执行objectToDataStream()将对象序列化保存===");
//		i22.objectToDataStream();
//		System.out.println("===执行dataStreamToObject()将对象反序列化读取===");
//		i22.dataStreamToObject();
//		System.out.println("===执行objectToDataStreamSelect()将对象有选择的序列化保存===");
//		i22.objectToDataStreamSelect();
//		System.out.println("===执行objectToDataStream()将对象有选择的反序列化===");
//		i22.dataStreamToObjectSelect();
//		System.out.println("===执行objectToDataStreamSelect2()通过关键字transient将对象有选择的序列化保存===");
//		i22.objectToDataStreamSelect2();
//		System.out.println("===执行objectToDataStream2()通过关键字transient将对象有选择的反序列化===");
//		i22.dataStreamToObjectSelect2();
		System.out.println("===执行objectToDataStreamSelect3()序列化一组对象===");
		i22.objectToDataStreamSelect3();
		System.out.println("===执行objectToDataStream3()反序列化一组对象===");
		i22.dataStreamToObjectSelect3();		
		
	}
	/***1.对象序列化和对象反序列化操作时的版本兼容问题：
	 * 在对象进行序列化或反序列化操作时，要考虑JDK版本的问题，如果序列化的JDK版本和反序列化的JDK版本不同意
	 * 则有可能造成异常，所以在序列化操作中引入了一个serialVersionUID的常量，可以通过此常量验证版本的
	 * 一致性。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与
	 * 本地相应实体（类）的serialVersionUID进行比较，如果相同就认为一致的，可以进行反序列化，
	 * 否则就会和出现序列化版本不一致的异常。当实现java.io.Serializable接口实体（类）没有显示地定义一个
	 * 名为serialVersionUID、类型为long型的变量时，Java序列化机制在编译时会自动生成一个此版本
	 * 的serialVersionUID。当然，如果不希望通过编译来自动生成，也可以直接地显示地定义一个
	 * 名为serialVersionUID类型为long的常量，只要不修改这个变量值的序列化实体，
	 * 都可以互相进行串行化和反串行化
	 */
	//使用对象输出流输出序列化对象的步骤有时也称序列化，而使用对象输入流读入对象的过程有时也被称为反序列化
	/**范例：将Person类的对象保存在文件中
	 */
	private void objectToDataStream() throws Exception{
		String filePath=tool.queryPath()+"I22_Serializable01.txt";
		File file=new File(filePath);
		//声明对象输出流并实例化
		ObjectOutputStream oos=null;
		oos=new ObjectOutputStream(new FileOutputStream(file));
		//保存对象到文件中
		oos.writeObject(new I22_Person01("张三",18));
		oos.close();
		//通过以上代码可以将内容保存到文件中，保存的内容全是二进制数据，但是保存的文件本身不可以直接修改，
		//因为会破坏其保存格式
	}
	/**范例：从文件中将Person对象反序列化（读取）
	 */
	private void dataStreamToObject() throws Exception{
		String filePath=tool.queryPath()+"I22_Serializable01.txt";
		File file=new File(filePath);
		if(!file.exists()){
			System.out.println("指定路径的文件不存在!");
		}
		//声明对象输入流
		ObjectInputStream ois=null;
		InputStream input=new FileInputStream(file);
		ois=new ObjectInputStream(input);
		Object obj=ois.readObject();//读取对象
		ois.close();
		System.out.println(obj);//调用Object中的toString()方法
	}
	
	/***范例：序列化和反序列化Person对象
	 *  描述：实现序列化接口的类在对象进行序列化的时候，只有属性被序列化，如果用户根据自己的需要选择被序列化
	 *      的属性，则可以使用另外一种序列化接口——Externalizable接口
	 *  描述：writeExternal(ObjectOutput out):此方法中指定要保存的属性信息，对象序列化时调用
	 *      readExternal(ObjectInput in):此方法读取被保存的信息，对象反序列化时调用
	 */
	private void objectToDataStreamSelect() throws Exception{
		String filePath=tool.queryPath()+"I22_Serializable02.txt";
		File file=new File(filePath);
		ObjectOutputStream out=null;
		OutputStream  output=new FileOutputStream(file);
		out=new ObjectOutputStream(output);
		I22_Person02 person=new I22_Person02("李四",19);
		out.writeObject(person);
		out.close();
	}
	private void dataStreamToObjectSelect() throws Exception{
		String filePath=tool.queryPath()+"I22_Serializable02.txt";
		File file=new File(filePath);
		ObjectInputStream input=new ObjectInputStream(new FileInputStream(file));
		Object obj=input.readObject();
		input.close();
		System.out.println(obj);
	}
	
	/***范例：Person中的name属性不希望被序列化
	 * 描述：除了通过实现Externalizable接口实现部分属性的序列化，也可以通过关键字transient来
	 *      如果一个对象中的某个属性不希望被序列化，则可以使用transient关键字进行声明
	 */
	private void objectToDataStreamSelect2() throws Exception{
		String filePath=tool.queryPath()+"I22_Serializable03.txt";
		File file=new File(filePath);
		ObjectOutputStream out=null;
		OutputStream  output=new FileOutputStream(file);
		out=new ObjectOutputStream(output);
		I22_Person03 person=new I22_Person03("李四",19);
		out.writeObject(person);
		out.close();
	}
	private void dataStreamToObjectSelect2() throws Exception{
		String filePath=tool.queryPath()+"I22_Serializable03.txt";
		File file=new File(filePath);
		ObjectInputStream input=new ObjectInputStream(new FileInputStream(file));
		Object obj=input.readObject();
		input.close();
		System.out.println(obj);
	}
	
	/*** 范例：序列化一组对象
	 *   描述：因为对象输出流只提供一个对象输出的操作writeObject(Object obj) ，所以要同时序列化多个对象
	 *        可以使用对象数组进行操作，因为数组属于引用数据类型，可以直接使用Object类型进行接收
	 */
	private void objectToDataStreamSelect3() throws Exception{
		String filePath=tool.queryPath()+"I22_Serializable04.txt";
		File file=new File(filePath);
		ObjectOutputStream out=null;
		OutputStream  output=new FileOutputStream(file);
		out=new ObjectOutputStream(output);
		I22_Person01[] persons={new I22_Person01("张三",18),new I22_Person01("李四",19),new I22_Person01("王五",20)};
		out.writeObject(persons);//如果过个对象，直接组成数组做成一个对象插入
		out.close();
	}
	private void dataStreamToObjectSelect3() throws Exception{
		String filePath=tool.queryPath()+"I22_Serializable04.txt";
		File file=new File(filePath);
		ObjectInputStream input=new ObjectInputStream(new FileInputStream(file));
		Object[] objs=(Object[])input.readObject();//如果读取数组
		input.close();
		for(Object obj:objs){
			System.out.println(obj);
		}
		
	}	
}

/**
 * <ul>
 * <li>文件名称: I22_Serializable01.java</li>
 * <li>功能描述: 此类实现序列化接口，所以它的对象可以经过二进制数据流进行传输的，而如果要完成对象的输入与输出</li>
 * <li>功能描述: ，还需要依靠对象输出流（ObjectOutputStream）和对象输入流（ObjectInputStream）</li>
 * </ul>
 */
class I22_Person01 implements Serializable{//此类的对象可以被序列化
	
	private String name;
	private int age;
	public I22_Person01(){
		
	}
	public I22_Person01(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString(){
		return "姓名："+this.name+"; 年龄："+this.age;
	}
}

/**
 * <ul>
 * <li>文件名称: I22_Serializable01.java</li>
 * <li>功能描述:修改Person类并实现Externalizable接口</li>
 * <li>功能描述:如果一个类要使用Externalizable实现序列化时，在此类中必须存在一个无参构造方法，
 * 		因为在反序列化时会默认调用无参构造实例化对象，如果没有无参构造，则运行将会出现异常</li> 
 * </ul>
 */
class I22_Person02 implements Externalizable{//此类的对象可以被序列化
	
	private String name;
	private int age;
	public I22_Person02(){
		
	}
	public I22_Person02(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString(){
		return "姓名："+this.name+"; 年龄："+this.age;
	}
	/**覆写此方法，根据需要读取内容，反序列化时使用**/
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.name=(String)in.readObject();//读取姓名属性,可以有选择的注释掉，这样就不能读取到相应的信息
		//this.age=in.readInt();
		
	}
	
	/**根据需要可以保存属性或具体内容，序列化时使用**/
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(this.name);//写入属性值，可以有选择的注释掉，这样就不能写入相应信息
		//out.writeInt(this.age);
		
	}
}

/**
 * <ul>
 * <li>文件名称: I22_Serializable01.java</li>
 * <li>功能描述: 利用transient声明不希望被序列化的属性</li>
 * </ul>
 */
class I22_Person03 implements Serializable{//此类的对象可以被序列化
	
	private transient String name;//此属性不被序列化
	private int age;

	public I22_Person03(){
		
	}
	public I22_Person03(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString(){
		if(this.age==0){
			return "姓名："+this.name;
		}
		return "姓名："+this.name+"; 年龄："+this.age;
	}
}




