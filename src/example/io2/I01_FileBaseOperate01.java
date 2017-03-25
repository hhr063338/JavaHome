package example.io2;

import java.io.File;
/***
 * <ul>
 * <li>文件名称: I01_FileBase01.java</li>
 * <li>功能描述: 创建与删除文件</li>
 * <li>内容描述：File类是整个io包中唯一与文件本身有关的类，可以通过它进行文件的创建与删除等操作</li>
 * <li>File的构造方法： public File(String path) 实例化File类，必须设置好路径
 * </ul>
 */
public class I01_FileBaseOperate01 {
	
	//测试
	public static void main(String[] args) {
		
		int count=1;//0.各种基本用法;1.综合运用;2将GBK改为utf	
		I01_FileBaseOperate01 test_I01=new I01_FileBaseOperate01();
		if(count==0){//File的基本用法
			//输出File类提供的分隔符（会自动根据系统来识别）,移值性高		
			test_I01.printStaticVariable();	
			//创建文件的目录路径
			//String dirpath=
				test_I01.queryDirectorPath();
			//新建文件
			test_I01.createFile();
			//删除文件
			test_I01.deleteFile();
			//创建目录
			test_I01.createDirectory();
			//列出指定目录下的文件名
			test_I01.listUnderDir("");			
		}else if(count==1){
			//File的综合运用
			test_I01.listUnderDirAllFile("");
		}else if(count==2){
			
		}
		/**注意：
		 ***1.每次程序执行之后，文件并不会立刻创建或删除,会有一些延迟,这是因为所有的操作
		 *		都需要通过JVM完成造成
		 */


		

	}
	/***
	 * 输出File类中常用的静态变量（主要是分隔符）
	 */
	private void printStaticVariable(){
		System.out.println("************执行printStaticVariable()方法输出本操作系统的分隔符**********************");
		System.out.println("File.separator: "+File.separator);
		System.out.println("File.pathSeparator: "+File.pathSeparator);
		System.out.println("File.pathSeparatorChar: "+File.pathSeparatorChar);
	}
	
	/****
	 * 创建文件的路径目录名(即本项目的绝对路径)
	 */
	private String queryDirectorPath(){
		//System.out.println("---执行queryDirectorPath()方法 获取java项目的绝对路径---");
		//获取class对象所在目录（不是绝对目录,在本项目中就是bin目录的路径）
		String filepath=this.getClass().getClassLoader().getResource(".").getPath();
		//System.out.println(filepath);
		String[] paths=filepath.split("/");
		StringBuffer sb_path=new StringBuffer();
		//组建文件创建路径
		for(int i=0;i<paths.length-1;i++){
			if(null!=paths[i]&&!paths[i].trim().equals("")){	
				sb_path.append(paths[i]).append(File.separator);
			}
		}
		String directoryPath=sb_path.toString()+"doc"+File.separator+"test"+File.separator;
		File dirFile=new File(directoryPath);
		System.out.println("queryAvaildPath方法获取文件目录路径,返回值："+directoryPath);
		if(dirFile.exists()){
			
		}else{
			if(dirFile.mkdir()){
				System.out.println("文件保存目录已经生成,目录名:"+directoryPath);
			}
		}
		
		
		return directoryPath;
	}

	/***
	 * 创建文件
	 */
	private void createFile(){
		System.out.println("============执行createFile()方法创建新文件================");
		//其中"\\"表示一个"\"
		//File f=new File("D:\\Workspaces\\learn\\doc\\test\\I01_FileBase01.txt");//必须给出完整路径
		String directorPath=queryDirectorPath();//目录路径
		String filePath=directorPath+"I01_FileBase01.txt";
		System.out.println("创建的文件路径名："+filePath);

		File f=new File(filePath);
		try {
			boolean flag=f.createNewFile();//如果存在则会创建失败
			System.out.println("是否成功创建文件目录:"+flag);
			//根据给定的路径创建新的文件,因为该方法使用了throws关键字，所以在使用中必须进行异常处理
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/***
	 * 删除文件
	 */
	private void deleteFile(){
		System.out.println("=============执行deleteFile()方法删除指定文件======================");

		String path=queryDirectorPath()+"I01_FileBase01.txt";
		System.out.println("删除文件路径："+path);
		File f=new File(path);
		if(f.exists()){	//判断文件是否存在
			boolean flag=f.delete();
			System.out.println("是否删除文件或目录："+flag);
		}else{
			System.out.println("指定文件不存在");
		}
	}
	
	/**
	 * 创建目录（文件夹）
	 */
	private void createDirectory(){
		
		String directoryPath=queryDirectorPath()+"testI01";
		System.out.println("========createDirectory使用并生成目录===");
		File directoryFile=new File(directoryPath);
		System.out.println("创建目录的路径名："+directoryPath);
		if(directoryFile.exists()&&directoryFile.isDirectory()){//判断目录是不是目录,且是否存在
			
		}else if(!directoryFile.exists()){//目录不存在,则新建
			directoryFile.mkdirs();//可以在不存在的目录中创建文件夹。
			//directoryFile.mkdir(); //只能在已经存在的目录中创建创建文件夹。 
			
		}
	}
	
	/***
	 * 列出指定目录下的文件名
	 * File提供的方法：String[] list():列出全部的名称
	 *    File[] listFiles(): 列出完整的路径，返回一个File对象数组
	 */
	private void listUnderDir(String path){
		System.out.println("=======listUnderDir()方法列出指定目录下的文件名==================");
		if(null==path||path.trim().equals("")){
			path="D:/";
		}
		File director=new File(path);
		String filesName[]=director.list();
		System.out.println("输出"+path+"目录下的所有文件名称:");
		for(int i=0;i<filesName.length;i++){
			System.out.print(filesName[i]+"    ");
			if(i%10==0){
				System.out.println("");
			}		
		}
		System.out.println("");
		System.out.println("");
		System.out.println("使用listFile()方法列出一个目录中的全部内容:");
		File[] files=director.listFiles();
		for(int j=0;j<files.length;j++){
			//直接打印File对象可以把一个完整的路径取出来 
			System.out.println(files[j]);
		}

	}
	
	/***
	 * 列出指定目录和子目录下的文件名
	 *
	 */
	private void listUnderDirAllFile(String path){
		System.out.println("=======listUnderDir()方法列出指定目录下的文件名==================");
		if(null==path||path.trim().equals("")){
			path="D:\\驱动";
		}		
		File isDir=new File(path);
		listUnderDirAllFile_add(isDir);
		/**
		 * 利用递归的调用方式不断地判断传进来的路径是否是目录，如果是目录，则继续列出子文件夹
		 * 如果不是，则直接打印路径名称
		 */
	}
	
	private void listUnderDirAllFile_add(File file){
		if(file.exists()){
			if(file.isDirectory()){
				File[] fileArray=file.listFiles();
				for(File testFile:fileArray){
					listUnderDirAllFile_add(testFile);
				}
			}else{
				System.out.println(file);
			}
		}
	}

}
