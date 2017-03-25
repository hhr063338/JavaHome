package model.chainresponsibility;

/***
 * <ul>
 * <li>文件名称: C01_Chain_Test01.java</li>
 * <li>功能描述: 责任链模式（Chain of Responsibility） </li>
 * </ul>
 */
public class C01_Chain_Test01 {
	
	/***责任链模式：有多个对象，每个对象持有对下一个对象的引用，这样就形成一条链，请求在这条链上传递，
	 *     直到某一对象决定处理该请求，但是发出者并不清楚到底最终哪个对象会处理该请求，所以，责任链
	 *     模式可以实现，在隐瞒客户端的情况下，对系统进行动态的调整
	 * 
	 */
	public static void main(String[] args) {
        C01_MyHandler h1 = new C01_MyHandler("h1");  
        C01_MyHandler h2 = new C01_MyHandler("h2");  
        C01_MyHandler h3 = new C01_MyHandler("h3");  
  
        h1.setHandler(h2);  
        h2.setHandler(h3);  
  
        h1.operator();  
        /***
         * 链接上的请求可以是一条链，可以是一个树，还可以是一个环，模式本身不约束这个，
         * 需要我们自己去实现，同时，在一个时刻，命令只允许由一个对象传给另一个对象，而不允许传给多个对象
         */
	}

}

interface C01_Handler{
	public void operator();
}

abstract class  C01_AbstractHandler{
	
	private C01_Handler handler;
	
	public C01_Handler getHandler() {
		return handler;
	}
	
	

	public void setHandler(C01_Handler handler) {
		this.handler = handler;
	}
}

class C01_MyHandler extends C01_AbstractHandler implements C01_Handler{
	
	private String name;
	
	public C01_MyHandler(String name){
		this.name=name;
	}
	
	public void operator() {
		System.out.println(name+" deal !");
		if(getHandler()!=null){
			getHandler().operator();
		}
	}
}



