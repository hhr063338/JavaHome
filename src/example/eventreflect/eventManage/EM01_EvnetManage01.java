package example.eventreflect.eventManage;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <ul>
 * <li>文件名称: EM01_Evnet01.java</li>
 * <li>功能描述: 用java语言实现事件委托模式</li>
 * </ul>
 */
public class EM01_EvnetManage01 {

	
	/***
	 * 1。放哨者完全不知道做游戏者的存在，完全解耦。（当然，功劳归功于Event和EventHandler，且这两个类具有通用性）
	 * 2。老师来了后游戏者停止游戏回到座位，看电视着关闭电视。（一次通知，执行了不同类的不同方法）
	 * 3。扩展性很高，再来一个打篮球的学生就先写个打篮球学生类，并在测试代码中告诉放哨者一下就好，放哨者完全没有变。重用性好
	 * @param args
	 */
	public static void main(String[] args) {
//		创建一个尽职尽责的放哨者   
		Em01_good_Notifier goodNotifier=new Em01_good_Notifier();   
		  
//		创建一个玩游戏的同学，开始玩游戏   
		EM01_PlayingGameListener01 playingGameListener=new EM01_PlayingGameListener01();   
//		创建一个看电视的同学，开始看电视   
		EM01_WatchingTVListener01 watchingTVListener=new EM01_WatchingTVListener01();   
//		玩游戏的同学告诉放哨的同学，老师来了告诉一下   
		goodNotifier.addListener(playingGameListener, "stopPlayingGame",new Date());   
//		看电视的同学告诉放哨的同学，老师来了告诉一下   
		goodNotifier.addListener(watchingTVListener, "stopWatchingTV",new Date());   
		try{   
		    //一点时间后   
		    Thread.sleep(1000);   
		}catch(Exception e){   
		    e.printStackTrace();   
		}   
//		老师出现，放哨的人通知所有要帮忙的同学:老师来了   
		goodNotifier.notifyX();  
	}
}

class EM01_Event01{
	//要执行方法的对象
	private Object obj;
	//要执行的方法名称
	private String methodName;
	//要执行方法的参数
	private Object[] params;
	//要执行方法的参数类型
	private Class[] paramTypes;
	
	/*无参构造函数*/
	public EM01_Event01(){};
	/*有参参构造函数*/
	public EM01_Event01(Object object,String methodName,Object...args){
		this.obj=object;
		this.methodName=methodName;
		this.params=args;
		contractParamTypes(this.params);
	}
	
	//根据参数数组生成参数类型数组
	public void contractParamTypes(Object[] params){
		this.paramTypes=new Class[params.length];
		for(int i=0;i<params.length;i++){
			this.paramTypes[i]=params[i].getClass();
		}
	}
	
	//执行该对象的方法
	public void invoke() throws Exception{
		Method method=obj.getClass().getMethod(this.getMethodName(),this.getParamTypes());
		if(null==method){
		
		}
		method.invoke(this.getObj(), this.getParams());
		
	}
	
	//省略若干set get方法
	public Object getObject(){
		return obj;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public Object[] getParams() {
		return params;
	}
	public void setParams(Object[] params) {
		this.params = params;
	}
	public Class[] getParamTypes() {
		return paramTypes;
	}
	public void setParamTypes(Class[] paramTypes) {
		this.paramTypes = paramTypes;
	}
	
}

class EM01_EventHandle01{
	//使用一个List
	private List<EM01_Event01> objects;
	
	//无参构造函数
	public EM01_EventHandle01(){
		objects=new ArrayList<EM01_Event01>();
	}
	
	//添加某个对象要执行的事件，及需要的参数
	public void addEvent(Object object,String methodName,Object...args){
		objects.add(new EM01_Event01(object,methodName,args));
	}
	
	//通知所有的对象要执行指定的事件
	public void notifyX() throws Exception{
		for(EM01_Event01 event:objects){
			event.invoke();
		}
	}
}


abstract class Em01_Notifier01{
    private EM01_EventHandle01 eventHandler=new EM01_EventHandle01();   
    
    public EM01_EventHandle01 getEventHandler() {   
        return eventHandler;   
    }   
    public void setEventHandler(EM01_EventHandle01 eventHandler) {   
        this.eventHandler = eventHandler;   
    }   
    //增加需要帮忙放哨的学生   
    public abstract void addListener(Object object,String methodName,Object...args);   
    //告诉所有要帮忙放哨的学生：老师来了   
    public abstract void notifyX();   
}

class Em01_good_Notifier extends Em01_Notifier01{
    @Override  
    public void addListener(Object object, String methodName, Object... args) {   
        System.out.println("有新的同学委托尽职尽责的放哨人!");   
        this.getEventHandler().addEvent(object, methodName, args);   
    }   
  
    @Override  
    public void notifyX() {   
        System.out.println("尽职尽责的放哨人告诉所有需要帮忙的同学：老师来了");   
        try{   
            this.getEventHandler().notifyX();   
        }catch(Exception e){   
            e.printStackTrace();   
        }   
    }
    

}

/***
 * <ul>
 * <li>文件名称: EM01_EvnetManage01.java</li>
 * <li>功能描述: 玩游戏的学生</li>
 * </ul>
 */
class EM01_PlayingGameListener01 {   
    public EM01_PlayingGameListener01(){   
        System.out.println("我正在玩游戏 开始时间"+new Date());   
    }   
    public void stopPlayingGame(Date date){   
        System.out.println("老师来了，快回到座位上，结束时间"+date);   
    }   
}  

/**
 * <ul>
 * <li>文件名称: EM01_EvnetManage01.java</li>
 * <li>功能描述: 看电视的学生</li>
 * </ul>
 */
class EM01_WatchingTVListener01 {   
    public EM01_WatchingTVListener01(){   
        System.out.println("我正在看电视 "+new Date());   
    }   
    public void stopWatchingTV(Date date){   
        System.out.println("老师来了，快关闭电视 。 结束时间"+date);   
    }   
}  

