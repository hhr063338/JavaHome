package instance.encode;

import java.io.File;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;

/***
 * 文件工具类FileUtils的使用
 * 将GBK编码的java与xml文件转为utf
 * @author Administrator
 *
 */
public class GBK_TO_UTF8_01 {

	/** 待完善（为什么else块里写入会出现乱码）
	 * 
	 */
	public static void main(String[] args) throws Exception{

		GBK_TO_UTF8_01 gbkToUtf=new GBK_TO_UTF8_01();
		List<File> listAllFile=new ArrayList<File>();
		//声明目录
		String bootPath="D:\\新文件\\src";//被复制的目录
		File dir= new File(bootPath);
		String moveToPlace="D:\\新文件\\SpringHome";//目的地
		File saveDirFile=new File(moveToPlace);
		if(saveDirFile.mkdirs()){}//确保存在这样的目录
		//获取所有的文件路径,顺便创建相应的目录
		gbkToUtf.listFileSelectDirectory(dir, listAllFile,bootPath.length(),moveToPlace);

		Reader read=null;
		Writer writer=null;
//		InputStream read=null;
//		OutputStream writer=null;

		for(int i=0;i<listAllFile.size();i++){//循环文件名
			
			File selectfile=listAllFile.get(i);
			String filePath=selectfile.toString();
			if(filePath.matches(".*\\.java")){//获取java文件或xml文件
				String dirmake=moveToPlace+filePath.substring(bootPath.length());
				System.out.println("java文件"+dirmake);
				File javaFile=new File(dirmake);
				if(!javaFile.exists()){
					javaFile.createNewFile();
				}
				//使用GBK读取数据，然后用UTF-8写入数据 
			    FileUtils.writeLines(javaFile, "UTF-8", FileUtils.readLines(selectfile, "GBK"));  
			}else if(filePath.matches(".*\\.xml")){//获取java文件或xml文件
				String dirmake=moveToPlace+filePath.substring(bootPath.length());
				System.out.println("xml文件"+dirmake);
				File javaFile=new File(dirmake);
				if(!javaFile.exists()){
					javaFile.createNewFile();
				}
				//使用GBK读取数据，然后用UTF-8写入数据 
			    FileUtils.writeLines(javaFile, "UTF-8", FileUtils.readLines(selectfile, "GBK"));  
			}else{//复制非java文件
				String realPath=moveToPlace+filePath.substring(bootPath.length());
				System.out.println(realPath);
				File movetoFile=new File(realPath);

				if(!movetoFile.exists()){
					movetoFile.createNewFile();
				}
				
				FileUtils.copyFile(selectfile, movetoFile); 
				/**8
				read=new FileReader(selectfile);
				writer=new FileWriter(movetoFile);
				char[] b=new char[1024];
				int len=0;
				while((len=read.read(b))!=-1){
					writer.write(b);
					writer.flush();
				}	
				**/
				
//				byte[] b=new byte[1024];
//				read=new FileInputStream(selectfile);
//				writer=new FileOutputStream(movetoFile);
//				
//				while((read.read(b))!=-1){
//					writer.write(b);
//				}
//				writer.flush();
			}
		}
		if(read!=null){
			read.close();
		}
		
		if(writer!=null){
			writer.close();
		}
		
		

		
	}
	public void yy() throws Exception{
		//最好能检索父目录下的子目录中的java源文件，然后相应的创建
		//GBK编码格式源码路径 
		String srcDirPath = "H:\\榕之生\\刑天（兴添）\\马士兵Spring\\尚学堂马士兵_Spring_00_项目源码\\src"; 
		//转为UTF-8编码格式源码路径 
		String utf8DirPath = "D:\\UTF8\\src\\za"; 
		
		
		//获取所有java文件 
		Collection<File> javaGbkFileCol =  FileUtils.listFiles(new File(srcDirPath), new String[]{"java"}, true); 
		        
		try{
		for (File javaGbkFile : javaGbkFileCol) { 
		      //UTF8格式文件路径 
		      String utf8FilePath = utf8DirPath+javaGbkFile.getAbsolutePath().substring(srcDirPath.length()); 
		       //使用GBK读取数据，然后用UTF-8写入数据 
		      FileUtils.writeLines(new File(utf8FilePath), "UTF-8", FileUtils.readLines(javaGbkFile, "GBK"));        
		}
		}catch(Exception e){
			System.out.println("出错了");
		}
		
	}

	/***
	 * 获取所有的文件路径,顺便创建相应的目录
	 * @param dir 被复制的目录
	 * @param addlist
	 * @param length
	 * @param saveBootPath
	 * @return
	 * @throws Exception
	 */
	private List<File> listFileSelectDirectory(File dir,List<File> addlist,int length,String saveBootPath) throws Exception{
	
		File[] files=dir.listFiles();
		String createDirStr=saveBootPath+dir.toString().substring(length);//更换目录		
		new File(createDirStr).mkdirs();//创建目录
		for(int i=0;i<files.length;i++){
			if(files[i].isFile()){//录入文件
				addlist.add(files[i]);
			}else{//获取所有的文件路径,顺便创建相应的目录
				listFileSelectDirectory(files[i], addlist,length,saveBootPath);
			}
		}
		return addlist;
	}
	
	

}
