package example.io2;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import tool.ToolUtil01;

/**
 * <ul>
 * <li>文件名称: I17_DataOperateStream01.java</li>
 * <li>功能描述: 介绍数据操作流</li>
 * <li>补充描述：关键类：DataInputStream 和 DataOutputStream 数据输入流</li>
 * </ul>
 */
public class I17_DataOperateStream01 {

	//添加工具类
	ToolUtil01 tool=new ToolUtil01();
	
	/***
	 *
	 */
	public static void main(String[] args) throws Exception{
		I17_DataOperateStream01 i17=new I17_DataOperateStream01();
		i17.writeByDataOutputStream01();
		i17.readByDataInputStream01();
	}
	
	/** 范例：将订单数据写入文件 order.txt
	 * 补充：DataOutputStream本来就是用来写二进制数据的，你直接打开data.txt当然
	 *     看到的是乱码，你在用DataInputStream按你写的顺序读进来看就对了
	 */
	private void writeByDataOutputStream01() throws Exception{
		System.out.println("====将订单数据写入文件=========");
		//声明数据输出流对象
		DataOutputStream dos=null;
		//指定文件的保存路径
		String filepath=tool.queryPath()+"I17_DataOperateStream01.txt";
		File file=new File(filepath);
		if(!file.exists()){
			file.createNewFile();
		}
		//实例化数据输出流对象
		dos=new DataOutputStream(new FileOutputStream(file));
		//商品名称、商品价格
		String names[]={"衬衣","手套","围巾"};
		float price[]={98.3f,30.3f,50.5f};
		int nums[]={3,2,1};
		//将商品名称和商品价格写入文件
		for(int i=0;i<names.length;i++){
			dos.writeChars(names[i]);//写入字符串
			dos.writeChar('\t');//加入分隔符
			dos.writeFloat(price[i]);
			dos.writeChar('\t');//加入分隔符
			dos.writeInt(nums[i]);
			dos.writeChar('\n');//加入分隔符
		}
		dos.close();//关闭输出流
		System.out.println("已成功保存订单数据到文件中");
	}
	
	/*** 读取DataOutputStream写入的数据
	 * 补充描述：DataInputStream是InputStream的子类，专门负责读取使用DataOutputStream输出的数据
	 * 		   因为读取的每条记录之间使用“\n”作为分隔,每行记录之间使用"\n"作为分隔，所以需要分别使用
	 *         readChar()读取这两个分隔符，才能将数据正确地还原
	 */
	private void readByDataInputStream01() throws Exception{
		System.out.println("=========readByDataInputStream01()执行");
		//声明数据输入流对象
		DataInputStream dis=null;
		//声明file对象
		String filepath=tool.queryPath()+"I17_DataOperateStream01.txt";
		File file=new File(filepath);
		//实例化数据输入流对象
		dis=new DataInputStream(new FileInputStream(file));
		//接收定价单
		String name=null;//接收名称
		float price=0.0f;//接收价格
		int num=0;//接收数量
		char temp[]=null;//接收字符串数据
		char c=0;//声明字符串变量
		int len=0;//接收读取数据
		try{
			while(true){//循环读取
				temp=new char[2000];//开辟空间
				len=0;
				while((c=dis.readChar())!='\t'){//读取字符
					temp[len]=c;//接收内容
					len++;
				}
				name=new String(temp,0,len);
				price=dis.readFloat();
				dis.readChar();
				num=dis.readInt();
				dis.readChar();
				System.out.printf("名称: %s;价格： %5.2f;数量： %d\n",name,price,num);
			}
		}catch (Exception e) {//如果读到底则会抛出异常

		}
		dis.close();
	}
}
