package instance.stack;

/***
 * <ul>
 * <li>文件名称: S01_Stack01.java</li>
 * <li>功能描述: 用java代码填写堆栈</li>
 * </ul>
 */
public class S01_StackTest01 {

	/**
	 * 栈(stack):是一个先进后出的数据结构,通常用于保存方法(函数)中的参数,局部变量. 
	 * java中,所有基本类型和引用类型都在栈中存储.栈中数据的生存空间一般在当前scopes内(就是由{...}括起来的区域). 
	 * stack: 空间小，速度比较快， 用来放对象的引用
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		S01_Stack stack=new S01_Stack(1000);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		while(stack.top>=0){
			System.out.println(stack.pop());
		}
	}

}

/**
 * <ul>
 * <li>文件名称: S01_StackTest01.java</li>
 * <li>功能描述: 模拟栈</li>
 * </ul>
 */
class S01_Stack{
	int[] data;
	int maxSize;
	int top;
	public S01_Stack(int maxSize){
		this.maxSize=maxSize;
		data=new int[maxSize];
		top=-1;
	}	
	
	/**
	 * 依次加入数据
	 * @param data 要加入的数据
	 * @return 添加是否成功
	 */
	public boolean push(int data){
		if(top+1==maxSize){
			System.out.println("栈已满");
			return false;
		}
		this.data[++top]=data;
		return true;
	}
	
	/**
	 * 从栈中取出数据
	 * @return 取出的数据
	 * @throws Exception
	 */
	public int pop() throws Exception{
		if(top==-1){
			throw new Exception("栈已空");
		}
		return this.data[top--];
	}
}
