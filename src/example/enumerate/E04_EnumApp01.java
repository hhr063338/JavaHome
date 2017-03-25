package example.enumerate;


/***
 * <ul>
 * <li>文件名称: E04_EnumApp01.java</li>
 * <li>功能描述: 每个枚举类中都有其指定好的若干个对象，当然每个对象也可以包含多个属性，并赋值</li>
 * <li>可以通过构造方法为其赋值</li>
 * <li>可以通过setter方法为其赋值</li>
 * </ul>
 */
public class E04_EnumApp01 {
	
	public  static void main(String[] args){
		
		//1.用构造方法为枚举对象的属性赋值
		System.out.println("1.用构造方法为枚举对象的属性赋值");
		for(E04_Color c1:E04_Color.values()){
			System.out.println(c1.ordinal()+"号为颜色："+c1.getName()+"  引用名："+c1.name());
		}
		
		//2.用属性为枚举对象的属性赋值
		System.out.println("2.用属性为枚举对象的属性赋值");
		E04_Color2 color=E04_Color2.BLUE;
		color.setName("蓝色");
		color.setName("兰色");		
		System.out.println(color.getName());
		
		//如果不想通过 枚举.对象 的形式取得枚举对象，也可以通过 枚举类.valueOf() 方法找到一个枚举对象
		System.out.println("== 用 枚举类.valueOf()取得枚举对象 ==");
		E04_Color2 c1=E04_Color2.valueOf(E04_Color2.class, "BLUE");
		c1.setName("蓝色");
		c1.setName("兰色");
		System.out.println(c1.getName());
		
	}

}

/***
 * <ul>
 * <li>文件名称: E04_EnumApp01.java</li>
 * <li>功能描述: 通过构造方法为枚举类内的属性赋值</li>
 * </ul>
 */
enum E04_Color{
	GREEN("绿色"),RED("红色"),BLUE("蓝色"),YELLOW("黄色");
	
	private String name;
	private E04_Color(String str1){
		this.setName(str1);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

enum E04_Color2{
	RED,GREEN,BLUE;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		switch(this){
			case RED:{
				if("红色".equals(name)){this.name=name;}
				else{System.out.println("RED设置内容错了");}
				break;
			}			
			case BLUE:{
				if("蓝色".equals(name)){this.name=name;}
				else{System.out.println("BLUE设置内容错了");}
				break;
			}
			case GREEN:{
				if("绿色".equals(name)){this.name=name;}
				else{System.out.println("GREEN设置内容错了");}
				break;
			}
		}
	
	}
	
}

