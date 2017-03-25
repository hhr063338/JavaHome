package instance.path;

public class Path01_test01 {

	public static void main(String[] args) {
		Path01_test01 path=new Path01_test01();
		System.out.println(path.getPath());
	}
	
	public String getPath(){
		String path01="";
		path01=this.getClass().getClassLoader().getResource("").getPath();
		return path01;
	}
}
