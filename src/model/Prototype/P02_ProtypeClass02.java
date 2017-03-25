package model.Prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class P02_ProtypeClass02 {

	public static void main(String[] args) throws Exception {
		P02_Prototype02 p02=new P02_Prototype02();
		p02.setString(5);
		p02.setObj(new SerializableObject());
		P02_Prototype02 p02_copy=(P02_Prototype02)p02.clone();//浅复制
		P02_Prototype02 p02_deepCopy=(P02_Prototype02)p02.deepClone();//深复制
		System.out.println("浅复制中，基本属性是否一样："+(p02.getString()==p02_copy.getString()));
		System.out.println("浅复制中，引用数据指向对象是同一个吗:"+(p02.getObj()==p02_copy.getObj()));
		System.out.println("深复制中，基本属性是否一样："+(p02.getString()==p02_copy.getString()));
		System.out.println("深复制中，引用数据指向对象是同一个吗:"+(p02.getObj()==p02_deepCopy.getObj()));
				
	}
}

class P02_Prototype02 implements Cloneable, Serializable {  
	  
    private static final long serialVersionUID = 1L;  
    private int string;  
  
    private SerializableObject obj;  
  
    /* 浅复制，对象基本数据类型重新创建，但引用指向的还是原来的 */  
    public Object clone() throws CloneNotSupportedException {  
    	P02_Prototype02 proto = (P02_Prototype02) super.clone();  
        return proto;  
    }  
  
    /* 深复制 ，利用IO进行复制，所以使用的对象都必须实现Serializable接口，不管属性或引用指向的对象都是重新创建的*/  
    /*要实现深复制，需要采用流的形式读入当前对象的二进制输入，再写出二进制数据对应的对象*/
    public Object deepClone() throws IOException, ClassNotFoundException {  
  
        /* 写入当前对象的二进制流 */  
        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
        ObjectOutputStream oos = new ObjectOutputStream(bos);  
        oos.writeObject(this);  
  
        /* 读出二进制流产生的新对象 */  
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());  
        ObjectInputStream ois = new ObjectInputStream(bis);  
        return ois.readObject();  
    }  
  
    public int getString() {  
        return string;  
    }  
  
    public void setString(int string) {  
        this.string = string;  
    }  
  
    public SerializableObject getObj() {  
        return obj;  
    }  
  
    public void setObj(SerializableObject obj) {  
        this.obj = obj;  
    }  
  
}  
  
class SerializableObject implements Serializable {  
    private static final long serialVersionUID = 1L;  
}  
