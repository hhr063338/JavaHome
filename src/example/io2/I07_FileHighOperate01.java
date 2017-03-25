package example.io2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * <ul>
 * <li>文件名称: I07_FileHighOperate01.java</li>
 * <li>功能描述: 对于文件的高级操作——文件复制</li>
 * </ul>
 */
public class I07_FileHighOperate01 {

	public static void main(String[] args) throws Exception {
		I07_FileHighOperate01 i07=new I07_FileHighOperate01();
		i07.copyFile();
	}
	
	/** title ： 文件复制
	 * content： 
	 * @throws Exception
	 */
	private void copyFile() throws Exception{
		
		String desFilePath=queryPath()+"I06_DifferentCharacterStream01.txt";
		File desFile=new File(desFilePath);//目标文件
		
		if(desFile.exists()&&desFile.isFile()){
			
		}else{
			System.out.println("获取不到指定路径的文件，无法进行复制操作!");
		}
		
		String copyFilePath=queryPath()+"I07_FileHighOperate01.txt";
		File copyFile=new File(copyFilePath);//将目标文件内容复制到该文件
		
		InputStream in=null;
		OutputStream out=null;
		
		try{
			in=new FileInputStream(desFile);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			out=new FileOutputStream(copyFile);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(in!=null&&out!=null){//判断输入输出是否准备好
			int temp=0;
			try {
				while((temp=in.read())!=-1){
					out.write(temp);
				}
				out.flush();
				System.out.println("复制完成!");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("复制失败!");
			}
			
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}
	
	/**
	 * 获取文件文本存放路径
	 */
	private String queryPath() throws Exception{
		//获取classpath的路径 "/D:/Workspaces/learn/bin/"
		String filepath=this.getClass().getClassLoader().getResource(".").getPath();
		String[] paths=filepath.split("/");
		StringBuffer sb_path=new StringBuffer();
		//组建文件创建路径
		for(int i=0;i<paths.length-1;i++){
			if(null!=paths[i]&&!paths[i].trim().equals("")){	
				sb_path.append(paths[i]).append(File.separator);
			}
		}
		String directoryPath=sb_path.toString()+"doc"+File.separator+"test"+File.separator;
		return directoryPath;
	}
}
