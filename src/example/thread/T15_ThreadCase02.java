package example.thread;

/**
 * 
 * <ul>
 * <li>文件名称: T15_ThreadCase02.java</li>
 * <li>文件描述: 线程实例——生产者与消费者 </li>
 * <li>文件内容： 通过数据同步操作解决数据混乱问题，但未解决重复问题</li>
 * </ul>
 */
public class T15_ThreadCase02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		T15_Info info =new T15_Info();
		T15_Proceduer pro=new T15_Proceduer(info);
		T15_Consumer  con=new T15_Consumer(info);
		new Thread(pro).start();//启动生产者的线程
		new Thread(con).start();//启动消费者的线程

	}

}

/**
 * 作为生产者的产品——信息的载体
 */
class T15_Info{
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
	
	//同步方法--设值
	public synchronized void set(String name,String content) {
		this.setName(name);
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setContent(content);
	}
	
	//同步方法--取值
	public synchronized void get() {
		try{
			Thread.sleep(500);
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(this.getName()+"---->"+this.getContent());
	}
	
}


/**
 * <ul>
 * <li>文件名称: T14_Instance01.java</li>
 * <li>文件描述: 生产者</li>
 * </ul>
 */
class T15_Proceduer implements Runnable{
	private T15_Info info =null;
	public T15_Proceduer(T15_Info info2){//通过构造方法设置info属性
		this.info=info2;
	}
	
	
	public void run() {
		boolean flag=false;//定义标记位
		for(int i=0;i<10;i++){
			if(flag){//如果为true，则设置第1个信息
				this.info.set("  李兴华"+i,"JAVA讲师");//设置信息名称
				flag=false;//修改标记位
			}else{
				 this.info.set("mldn"+i,"www.mldnjava.cn");//设置信息名称
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
class T15_Consumer implements Runnable{
	private T15_Info info=null;//保存Info的引用
	public T15_Consumer(T15_Info info2){//通过构造方法设置info属性
		this.info=info2;
	}
	public void run() {
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.info.get();
			//System.out.println(this.info.getName()+"--->"+this.info.getContent());//取出信息
		}
		
	}
}

