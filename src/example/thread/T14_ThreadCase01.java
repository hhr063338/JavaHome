package example.thread;

/**
 * 
 * <ul>
 * <li>文件名称: T14_Instance01.java</li>
 * <li>文件描述: 线程操作案例—— 生产者及消费者 </li>
 * <li>文件内容： 会出现数据混乱问题
 * </ul>
 */
public class T14_ThreadCase01 {

	/**生产者与消费者
	 * 生产者生产出信息后将其放到一个区域之中，消费者从此区域中取出数据，但是在本程序中因为牵扯到线程运行的不确定性，
	 * 所以会出现以下两个问题：
	 * 1.假设生产者线程刚向数据存储空间添加了信息名称，还没有加入该信息的内容，程序就切换到消费者的线程
	 * 		消费者线程将把信息名称和上一个信息内容联系起来
	 * 2.生产者放了若干次数据，消费者才开始取数据，或者是，消费者取完一个数据后，还没等到生产者放入新的数据，
	 * 		又重复取出已经读取过的数据
	 * @param args
	 */
	public static void main(String[] args) {
		T14_Info_Instance01 info =new T14_Info_Instance01();
		T14_Proceduer pro=new T14_Proceduer(info);
		T14_Consumer  con=new T14_Consumer(info);
		new Thread(pro).start();//启动生产者的线程
		new Thread(con).start();//启动消费者的线程

		//方法传参数，对象传地址，值改变会跟着改变；基础数据传值，值改变不会跟着改变
		//changeValue(info);
		//System.out.println(info.getName());
	}
	public static void changeValue(T14_Info_Instance01 info){
		info.setName("9999");
		
	}
	
}

/**
 * 作为生产者的产品——信息的载体
 */
class T14_Info_Instance01{
	private String name="李兴华";//信息名称，指定默认值
	private String content="JAVA讲师";
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

/**
 * <ul>
 * <li>文件名称: T14_Instance01.java</li>
 * <li>文件描述: 生产者</li>
 * </ul>
 */
class T14_Proceduer implements Runnable{
	private T14_Info_Instance01 info =null;
	public T14_Proceduer(T14_Info_Instance01 info2){//通过构造方法设置info属性
		this.info=info2;
	}
	
	
	public void run() {
		boolean flag=false;//定义标记位
		for(int i=0;i<10;i++){
			if(flag){//如果为true，则设置第1个信息
				this.info.setName("  李兴华"+i);//设置信息名称
				try {
					Thread.sleep(500);//加入延迟
				} catch (Exception e) {
					e.printStackTrace();
				}
				this.info.setContent("  JAVA讲师"+i);//设置信息内容
				flag=false;//修改标记位
			}else{
				 this.info.setName("mldn"+i);//设置信息名称
				 try{
					 Thread.sleep(500);//加入延迟
				 }catch(Exception e){e.printStackTrace();}
				 flag=true;
			}			
		}		
	}
}

/**
 * <ul>
 * <li>文件名称: T14_Instance01.java</li>
 * <li>文件描述: 定义消费者线程</li>
 * <li>文件内容： 在消费者线程类中也同样接收了一个Info对象的引用，并采用循环的方式取出50次信息并输出</li>
 * </ul>
 */
class T14_Consumer implements Runnable{
	private T14_Info_Instance01 info=null;//保存Info的引用
	public T14_Consumer(T14_Info_Instance01 info2){//通过构造方法设置info属性
		this.info=info2;
	}
	public void run() {
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(this.info.getName()+"--->"+this.info.getContent());//取出信息
		}
		
	}
}
