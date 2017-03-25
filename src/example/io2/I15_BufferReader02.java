package example.io2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/***
 * <ul>
 * <li>文件名称: I15_BufferReader02.java</li>
 * <li>功能描述: 菜单显示</li>
 * <li>功能描述: 使用IO操作完成一个简单的菜单程序</li>
 * </ul>
 */
public class I15_BufferReader02 {

	/*** 注意实际问题的解决方法：
	 * 	对于实际的开发来讲，很难一次性开发出完整的类的设计，所以在编写时一定要首先完成基本功能的实现，
	 *  然后再对实现功能的代码结构进行优化，这样就可以设计比较合理的类
	 */
	public static void main(String[] args) {
		new I15_02_Menu();
	}
}



/***
 * <ul>
 * <li>文件名称: I15_BufferReader02.java</li>
 * <li>功能描述: 操作类</li>
 * </ul>
 */
class I15_02_Operate{
	public static void add(){
		System.out.println("**选择的是增加的操作");
	}
	
	public static void delete(){
		System.out.println("**选择的是删除操作");
	}
	
	public static void update(){
		System.out.println("**选择的是修改操作");
	}
	
	public static void query(){
		System.out.println("**选择的是查询操作");
	}
	

}


/***
 * <ul>
 * <li>文件名称: I15_BufferReader02.java</li>
 * <li>功能描述: 菜单显示类，接收选择的数据，同时使用switch判断是哪个操作</li>
 * <li>补充说明：因为该菜单类需要不断地显示，所以使用循环打印的方式，每一次操作完成后都会重新显示出所有的
 * 	          菜单内容以供用户选择</li>
 * </ul>
 */
class I15_02_Menu{
	public I15_02_Menu(){
		while(true){
			this.show();//无限制调用菜单的显示
		}
	}
	
	public void show(){
		System.out.println("=====Xxx系统=======");
		System.out.println(" [1]、增加数据 ");
		System.out.println(" [2]、删除数据 ");
		System.out.println(" [3]、修改数据 ");
		System.out.println(" [4]、查看数据 ");
		System.out.println(" [0]、系统退出\n ");
		
		I15_02_InputData input=new I15_02_InputData();
		int i=input.getInt("请选择:", "请输入正确项");
		switch(i){
		case 1:{
				I15_02_Operate.add(); //调用操作类的增加操作			
			}
		case 2:{
			I15_02_Operate.delete(); //调用操作类的减少操作	
			break;
		}	
		case 3:{
			I15_02_Operate.update(); //调用操作类的修改操作	
			break;
		}	
		case 4:{
			I15_02_Operate.query(); //调用操作类的查询操作		
			break;
		}	
		case 0:{
			System.exit(1); //调用操作类的查询操作
			break;
		}		
		default:{
			System.out.println("请选择正确的操作!");
		}
		}
	}
}



/***
 * <ul>
 * <li>文件名称: I15_BufferReader02.java</li>
 * <li>功能描述: 专门处理数据的类</li>
 * </ul>
 */
class I15_02_InputData{
	
	private BufferedReader buf=null;
	
	public I15_02_InputData(){
		//在构造方法中实例化BufferedReader对象
		this.buf=new BufferedReader(new InputStreamReader(System.in));
	}
	
	/***
	 * 输出提示信息，获取输入的数据并返回
	 * @param info
	 * @return
	 */
	public String getString(String info){//从此方法得到字符串信息
		String temp=null;
		System.out.println(info);//打印提示信息
		try {
			temp=buf.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	/***
	 * 判断用户输入的是否是数字并返回
	 * @param info
	 * @param err
	 * @return
	 */
	public int getInt(String info ,String err){//得到一个整数
		int temp=0;
		String str=null;
		boolean flag=true;//定义一个循环处理标记
		while(flag){
			str=this.getString(info);
			if(str.matches("^\\d+$")){//判断输入的是否数字
				temp=Integer.parseInt(str);
				flag=false;//更改标记位之后,将退出循环
			}else{
				System.out.println(err);//出现错误，则打印传递进的错误信息
			}
		}
		return temp;
		
	}
	
	/***
	 * 判断用户输入的是不是浮点数，是的返回，不是输出错误信息
	 * @param info
	 * @param err
	 * @return
	 */
	public float getFloat(String info,String err){
		float temp=0;
		String str=null;
		boolean flag=true;
		while(flag){
			str=this.getString(info);
			if(str.matches("^\\d+.?\\d+$")){
				temp=Float.parseFloat(str);
				flag=false;
			}else{
				System.out.println(err);
			}
		}
		return temp;
	}
	
	public Date getDate(String info,String err){//得到一个日期的数据
		Date temp=null;
		String str=null;
		boolean flag=true;
		while(flag){
			str=this.getString(info);
			if(str.matches("^\\d{4}-\\d{2}-\\d{2}$")){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				try {
					temp=sdf.parse(str);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				flag=false;
			}else{
				System.out.println(err);
			}
		}
		return temp;
	}
}
