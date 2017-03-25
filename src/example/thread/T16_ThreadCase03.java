package example.thread;

/**
 * <ul>
 * <li>文件名称: T16_ThreadCase03.java</li>
 * <li>文件描述: 线程实例--生产者与消费者</li>
 * <li>帮助： Object类对线程的支持—— 等待wait()与唤醒 notify</li>
 * </ul>
 */
public class T16_ThreadCase03 {

	/**
	 * 一般，所有等待的线程会按照顺序进行排序，如果使用notify则会唤醒第一个等待的线程，如果使用notifyAll()
	 * 		会唤醒所有线程，那时哪个优先级高就有可能先执行
	 * 针对消费者与生产者问题：1如果想让生产者与消费者不重复生产与重复取走，可以增加一个标记位，true可生产不能拿走，false不可生产但可拿走
	 * 
	 */
	public static void main(String[] args) {
		T16_Info info =new T16_Info();
		T16_Proceduer pro=new T16_Proceduer(info);
		T16_Consumer  con=new T16_Consumer(info);
		new Thread(pro).start();//启动生产者的线程
		new Thread(con).start();//启动消费者的线程		
	}
}


/**
 * 作为生产者的产品——信息的载体
 */
class T16_Info{
	private String name="李兴华";//信息名称，指定默认值
	private String content="JAVA讲师";
	private boolean flag=false;//设置标记位

	//同步方法--设值
	public synchronized void set(String name,String content) {
		
		if(!flag){//标志位为false表示不可生产，可拿走
			try {
				super.wait();//Object类中的wait()方法，等待消费者取走
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			this.setName(name);//设置信息名称
			try {
				Thread.sleep(500);//加入延迟
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.setContent(content);
			flag=false;	//修改标记位，表示可以取走
			super.notify();//唤醒等待线程
			
	}
	
	//同步方法--取值
	public synchronized void get() {
		if(flag){//标志位为true表示不可取走
			try{
				super.wait();//等待生产者生产
			
			}catch (Exception e) {
				e.printStackTrace();
			}			
		}
		try {
			Thread.sleep(300);//加入延迟
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" 线程 ："+this.getName()+"---->"+this.getContent());
		flag=true;
		super.notify();
	}	
	
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
class T16_Proceduer implements Runnable{
	private T16_Info info =null;
	public T16_Proceduer(T16_Info info2){//通过构造方法设置info属性
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
class T16_Consumer implements Runnable{
	private T16_Info info=null;//保存Info的引用
	public T16_Consumer(T16_Info info2){//通过构造方法设置info属性
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




