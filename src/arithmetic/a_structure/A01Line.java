package arithmetic.a_structure;

import java.util.Scanner;

/***
 * 线性结构-顺序表操作实例
 * @author Administrator
 *
 */
public class A01Line {

	public static void main(String[] args) {
		int i;
		SLType SL=new SLType();//定义顺序表变量
		DATA pdata;//定义结点保存引用变量
		String key;//保存关键字
		
		System.out.println("顺序表操作演示!\n");
		SL.SLInit(SL);
		System.out.println("初始化程序表完成!\n");
		
		Scanner input=new Scanner(System.in);
		do{
			//循环添加结点数据
			System.out.println("输入添加的结点(学号 姓名 年龄):");
			DATA data=new DATA();
			data.key=input.next();
			data.name=input.next();
			data.age=input.nextInt();
			
			if(data.age!=0){
				if(SL.SLAdd(SL, data)==0){
					break;
				}
			}else{
				break;//退出死循环
			}
		}while(true);
		System.out.println("\n 顺序表中的结点顺序为: \n");
		SL.SLAll(SL);
		
		System.out.println("\n 取出结点的序号：");
		i=input.nextInt();
		pdata=SL.SLFindByNum(SL, i);
		if(pdata!=null){
			System.out.printf("第%d个结点为:(%s,%s,%d)\n",
					i,pdata.key,pdata.name,pdata.age);
			
		}
		
		System.out.println("\n 要查找结点的关键字: \n");
		key=input.next();
		i=SL.SLFindByCont(SL, key);
		pdata=SL.SLFindByNum(SL, i);
		if(pdata!=null){
			System.out.printf("第%d个结点为:(%s,%s,%d)\n",
					i,pdata.key,pdata.name,pdata.age);			
		}
	}
}
/***
 * 数据元素
 */
class DATA{
	String key;
	String name;
	int age;
}

/***
 * 定义顺序表结构
 * @author Administrator
 */
class SLType{
	static final int MAXLEN=100;
	DATA[] ListData=new DATA[MAXLEN+1];//保存顺序表的结构数组
	int ListLen;//顺序表已存节点的数量
	
	void SLInit(SLType SL){//初始化顺序表
		SL.ListLen=0;//初始化为空表
	}
	
	/**返回顺序表的元素数量****/
	int SLLength(SLType SL){
		return (SL.ListLen);
	}
	/**插入结点***/
	int SLInsert(SLType SL,int n,DATA data){
		int i;
		if(SL.ListLen>=MAXLEN){
			System.out.println("顺序表已满,不能插入结点!\n");
			return 0;	//返回0，表示插入不成功
		}
		if(n<1||n>SL.ListLen-1){//插入结点序号不正确
			System.out.println("插入元素序号错误,不能插入元素!\n");
			return 0;	//返回0，表示插入不成功
		}
		for(i=SL.ListLen;i>=n;i--){//将顺序表中的数据向后移动
			SL.ListData[i+1]=SL.ListData[i];
		}
		SL.ListData[n]=data;//插入结点
		SL.ListLen++;//顺序表结点数量增加1
		return 1;//成功插入,返回1
	}
	/**添加结点***/
	int SLAdd(SLType SL,DATA data){
		if(SL.ListLen>=MAXLEN){
			System.out.println("顺序表已满,不能再添加结点了!\n");
			return 0;
		}
		SL.ListData[++SL.ListLen]=data;
		return 1;
	}
	
	/**删除结点:删除顺序表中的数据元素***/
	int SLDelete(SLType SL,int n){
		int i;
		if(n<1||n>SL.ListLen+1){
			System.out.println("删除结点序号错误,不能删除结点!\n");
			return 0;
		}
		for(i=n;i<SL.ListLen;i++){//将顺序结构中的数据向前移动
			SL.ListData[i]=SL.ListData[i+1];
		}
		SL.ListLen--;
		return 1;
	}
	
	/**根据序号返回数据元素***/
	DATA SLFindByNum(SLType SL,int n){
		if(n<1||n>SL.ListLen+1){
			System.out.println("结点序号错误,不能返回结点!\n");
			return null;
		}
		return SL.ListData[n];
		
	}
	
	/**按关键字查询结点**/
	int SLFindByCont(SLType SL,String key){
		int i;
		for(i=1;i<SL.ListLen;i++){
			if(SL.ListData[i].key.compareTo(key)==0){//如果找到所需结点
				return 1;
			}
		}	
		return 0;
	}
	
	/**显示顺序表中的所有结点****/
	int SLAll(SLType SL){
		int i;
		for(i=1;i<SL.ListLen;i++){
			System.out.printf("(%s,%s,%d)\n",
					SL.ListData[i].key,SL.ListData[i].name,SL.ListData[i].age);
		}
		return 0;
	}
	
	
}

