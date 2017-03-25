package tool;

import java.awt.BufferCapabilities.FlipContents;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.transform.ToListResultTransformer;

/***
 * 
 * <ul>
 * <li>文件名称: ToolUtil01.java</li>
 * <li>功能描述: 常用工具类</li>
 * </ul>
 */
public class ToolUtil01 {

	public static void main(String[] args) throws Exception{

		ToolUtil01 tool=new ToolUtil01();
		List<File> listall=new ArrayList<File>();
		String filepath="H:\\榕之生";
		File dir=new File(filepath);
		tool.getAllFile(dir, listall);
		for(File file:listall){
			if(file.getName().contains("面试")){
				System.out.println(file);
			}
		}
	}
	/***
	 * 范例：将Date类型转换为String类型，24小时格式：yyyy-MM-dd hh:mm:ss
	 * @param date
	 * @return
	 */
	public static String getDateToStr(Date date){
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
		String dateStr=sdf.format(date);
		return dateStr;
	}
	
	/**
	 * 获取文件文本存放路径
	 */
	public String queryPath() throws Exception{
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
	
	/***范例：获取指定目录下的文件名包含子目录的文件名
	 */
	public void getAllFile(File dir,List<File> listAllFile) throws Exception{

		if(dir.isDirectory()){
			File[] files=dir.listFiles();
			for(File f:files){
				if(f.isFile()){
					listAllFile.add(f);
				}else{
					getAllFile(f, listAllFile);
				}
			}		
		}else{
			listAllFile.add(dir);
		}
		
	}	
}
