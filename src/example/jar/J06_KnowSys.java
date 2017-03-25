package example.jar;

/**
 * System类是一些与系统相关属性和方法的集合，而且在System类中所有的属性都是静态的
 * 要想引用这些属性和方法直接使用System类调用即可
 *
 */
/* System常用方法
 * public static void exit(int status) 退出系统
 * public static void gc() 运行垃圾机制，调用Runtime.gc()
 * public static long currentTimeMills() 返回以毫秒为单位的当前时间
 * public static void arraycopy(Object src,int srcPos,Object dest,int destPost,int length) 数组复制
 * public static Properties getProperties() 取得当前系统的全部属性
 * public static String getProperties(String key) 根据键值取得属性的具体内容
 * 
 */
public class J06_KnowSys {

	public static void main(String[] args) {
		J06_KnowSys j6=new J06_KnowSys();
		//1.计算一个程序的执行时间
		j6.evaluateTime();
		//2.取得本机的全部环境属性
		j6.getAllEnviroment();
		//3.列出指定属性
		j6.getSelectPro();
		
	}
	
	/**
	 * 1.计算一个程序的执行时间
	 */
	public void evaluateTime(){
		System.out.println("**************计算指定程序的执行时间****************************");
		long startTime=System.currentTimeMillis();		//取得开始计算之前的时间
		int sum=0;		//执行累加操作
		for(int i=0;i<30000000;i++){
			sum+=i;
		}
		long endTime=System.currentTimeMillis();
		System.out.println("执行evaluateTime方法所花费的程序时间:"+(endTime-startTime)+"毫秒");
	}
	/**
	 * 2.取得本机的全部环境属性
	 */
	public void getAllEnviroment(){
		System.out.println("************取得本机的全部环境属性*******************");
		System.getProperties().list(System.out);
		//输出内容有两点需要关注：file.encoding=UTF-8 文件默认的编码
		//file.separator=\ 表示文件分隔符
	}
	/**
	 * 3.列出指定属性
	 */
	public void getSelectPro(){
		System.out.println("***************取得指定属性************************");
		System.out.println("系统版本为:"+System.getProperty("os.name")+
				System.getProperty("os.version")+System.getProperty("os.arch"));//取得当前系统版本
		System.out.println("系统用户:"+System.getProperty("user.name"));
		System.out.println("当前用户目录:"+System.getProperty("user.home"));
		System.out.println("当前用户工作目录:"+System.getProperty("user.dir"));
	}


	
}
