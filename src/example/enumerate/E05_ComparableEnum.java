package example.enumerate;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


/**
 * <ul>
 * <li>文件名称: E05_ComparableEnum.java</li>
 * <li>功能描述: 验证枚举比较器</li>
 * <li>补充描述: 在Enum类的定义中实现了Comparable接口，所以枚举类的内容本身是可以进行排序的</li>
 * </ul>
 */
public class E05_ComparableEnum {
	public static void main(String[] args){
		
		E05_ComparableEnum e05=new E05_ComparableEnum();
		//验证枚举中的比较器
		e05.comparableEnum();

	}
	
	/**
	 * 辅助： TreeSet 可以直接进行排序，排序的规则是通过 Comparable 接口完成的
	 * 说明： 放入的顺序是 GREEN BLUE RED 但是输出的是使用Enum中的ordinal属性排序的
	 */
	public void comparableEnum(){
		Set<E05_Color> t=new TreeSet<E05_Color>();//只能加入Color类型
		t.add(E05_Color.GREEN);
		t.add(E05_Color.BLUE);
		t.add(E05_Color.RED);
		Iterator<E05_Color> iter=t.iterator();
		while(iter.hasNext()){
			System.out.print(iter.next()+"、");
		}
		
	}
}

enum E05_Color{
	RED,GREEN,BLUE;//可见分别表示的常量0,1,2
}
