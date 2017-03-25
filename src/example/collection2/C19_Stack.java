package example.collection2;

import java.util.Stack;

/**Stack类
 * 栈是采用先进后出的数据存储方式,每一个栈都包含一个栈顶，每次出栈是将栈顶的数据取出
 * 在java中使用Stack类进行栈操作，Stack类是Vector的子类
 * public class Stack<T> extends Vector<T>
 */
/** 栈的应用
 * 	在浏览器中存在一个后退的按钮，每次后退都是后退到上一步的操作，那么实际上就是一个栈的应用，采用的是一个先进后出的操作
 */
/**
 * Stack类常用的方法
 * public boolean empty():测试栈是否为空
 * public E peek():查看栈顶，但不删除
 * public E pop():出栈，同时删除
 * public E push(E item):入栈
 * public int search(Object o):在栈中查找
 */
public class C19_Stack {	
	/**
	 * 范例：完成入栈和出栈程序
	 * 注意:如果栈已经为空,则无法再弹出，会出现空栈异常
	 */
	public static void main(String[] args) {
		Stack<String> stack=new Stack<String>();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		System.out.println("当前的栈顶:"+stack.peek());
		System.out.print("栈元素:"+stack.pop()+"、");
		System.out.print(stack.pop()+"、");
		System.out.print(stack.pop()+"、");
		System.out.print(stack.pop()+"、");
		System.out.println(stack.pop()+"、");//错误，出栈，出现异常，栈为空
	}
	
	
}
