package example.io2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import tool.ToolUtil01;

/***
 * <ul>
 * <li>文件名称: I19_WinRarWinZIP01.java</li>
 * <li>功能描述: 压缩zip 与 解压zip</li>
 * </ul>
 */
public class I19_WinRarWinZIP01 {

	ToolUtil01 tool=new ToolUtil01();
	/***
	 * 补充描述：在java中为了减少传输时的数据量也提供了专门的压缩流，可以将文件压缩成ZIP,JAR,GZIP等文件形式
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		I19_WinRarWinZIP01 i19=new I19_WinRarWinZIP01();
		//压缩文件
		//i19.compressionFile();
		//压缩文件夹
		//i19.compressDir();
		//压缩文件夹（含子目录文件）
		//i19.compressDirAllFile();
		//用ZipFile表示压缩文件
		//i19.initialCase();
		//解压压缩文件（只含有一个Entry）
		//i19.solveCompress();
		//解压（含多个Entry与子目录）
		i19.solveAllCompress();
//		ToolUtil01 tool=new ToolUtil01();
//		File file=new File(tool.queryPath()+"testI01");
//		System.out.println(file.getPath());
		

	}
	
	/***
	 * 描述：zip是一种常见的压缩形式，在java中要实现ZIP的压缩要导入java.util.zip包，
	 *      可以使用此包中的ZipFile、ZipOutputStream、ZipInputstream、ZipEntry几个类完成操作
	 * 补充：在每个压缩文件中都会存在多个子文件，那么每一个子文件在Java中就使用ZipEntry
	 * 补充：压缩的输入流\输出流也属于InputStream与OutputStream的子类，但却没有定义在java.io，而是以
	 * 	    一种工具类的形式提供的，在操作时还需要使用java.io包的支持
	 */
	
	
	/**  范例：压缩文件(压缩成zip格式)
	 * 
	 */
	private void compressionFile() throws Exception{
		System.out.println("====执行compressionFile()压缩文件的操作============");
		//定义要压缩的文件
		File needFile=new File(tool.queryPath()+"I18_SequenceInputStrea01.txt");
		//定义压缩文件名称
		File ziFile=new File(tool.queryPath()+"I19_WinRarWinZIP01.zip");
		//定义输入文件流
		InputStream input=new FileInputStream(needFile);
		//定义压缩输出流
		ZipOutputStream zipOut=null;
		//实例化压缩输出流对象，并指定压缩文件的输出路径
		zipOut=new ZipOutputStream(new FileOutputStream(ziFile));
		//每一个被压缩的文件都用zipEntry表示，需要为每一个压缩后的文件设置名称
		zipOut.putNextEntry(new ZipEntry(needFile.getName()));
		//设置注释
		zipOut.setComment("www.mldnjava.cn");
		int temp=0;
		while((temp=input.read())!=-1){
			zipOut.write(temp);
		}
		input.close();
		zipOut.close();
		System.out.println("====执行完毕compressionFile()压缩文件的操作============");
	}
	
	
	/***范例：压缩一个文件夹
	 *  描述：在实现压缩文件夹的时候就应该列出文件夹的全部内容，并把每一个内容设置成ZipEntry对象，
	 *  	 保存到压缩文件中
	 * @throws Exception
	 */
	private void compressDir() throws Exception{
		System.out.println("====执行compressDir()压缩文件的操作============");
		//要压缩的文件夹
		File file=new File(tool.queryPath()+"testI01");
		//压缩的文件名称
		File zipFile=new File(tool.queryPath()+"I19_WinRarWinZIP02.zip");
		//定义文件输入流
		InputStream input=null;
		ZipOutputStream zipOutput=null;
		//实例化压缩流
		zipOutput=new ZipOutputStream(new FileOutputStream(zipFile));
		
		if(file.isDirectory()){
			File lists[]=file.listFiles();//列出全部文件
			for(int i=0;i<lists.length;i++){
				input=new FileInputStream(lists[i]);//设置文件输入流
				//每一个被压缩的文件都用ZipEntry表示，需要为每一个压缩后的文件设置名称
				zipOutput.putNextEntry(new ZipEntry(file.getName()+File.separator+lists[i].getName()));
				int temp=0;
				while((temp=input.read())!=-1){//读取内容
					zipOutput.write(temp);//压缩文件内容
				}
				input.close();
			}
		}
		zipOutput.close();
		System.out.println("====执行完毕compressDir()压缩文件的操作============");
	}
	/***范例：压缩一个文件夹(含子目录文件)
	 *  描述：在实现压缩文件夹的时候就应该列出文件夹的全部内容，并把每一个内容设置成ZipEntry对象，
	 *  	 保存到压缩文件中
	 * @throws Exception
	 */
	private void compressDirAllFile() throws Exception{
		System.out.println("====执行compressDirAllFile()压缩文件夹(包含子目录文件)的操作============");
		
		//要压缩的文件夹
		File file=new File(tool.queryPath()+"testI01");
		//压缩的文件名称
		File zipFile=new File(tool.queryPath()+"I19_WinRarWinZIP03.zip");
		//定义文件输入流
		InputStream input=null;
		ZipOutputStream zipOutput=null;
		//实例化压缩流
		zipOutput=new ZipOutputStream(new FileOutputStream(zipFile));
		//求指定目录下的所有文件
		List<File> listAllFile=new ArrayList<File>();
		this.getAllFile(file, listAllFile);
		//进行压缩
		for(int i=0;i<listAllFile.size();i++){
			File f=listAllFile.get(i);
			input=new FileInputStream(f);//将文件输入流，输入到程序中
			//为程序设置一个压缩输出流，每一个被压缩的文件都用ZipEntry表示，需要为每一个压缩后的文件设置名称
			zipOutput.putNextEntry(new ZipEntry(f.getPath().substring(tool.queryPath().length())));
			int temp=0;
			while((temp=input.read())!=-1){
				zipOutput.write(temp);
			}
			input.close();
		}

		zipOutput.close();
		System.out.println("====执行完毕compressDir()压缩文件的操作============");
	}	
	
	/**** 范例：实例化ZipFile对象
	 *  描述：在java中每一个压缩文件都可以使用ZipFile表示，还可以使用ZipFile根据压缩后的文件名称找到
	 *       每一个压缩文件中的ZipEntry并将其进行解压缩操作
	 */
	public void initialCase() throws Exception{
		System.out.println("=======利用ZipFile表示压缩文件initialCase==========");
		//找到压缩文件
		File file=new File(tool.queryPath()+"I19_WinRarWinZIP01.zip");
		System.out.println("请问I19_WinRarWinZIP01.zip压缩文件存在吗?==>"+(file.exists()==true?'是':'否'));
		//实例化zipfile对象
		ZipFile zipfile=new ZipFile(file);
		System.out.println("压缩文件的名称："+zipfile.getName());
		//ZipFile.getName()返回的事压缩文件的绝对路径名
	}
	
	/***范例：解压只存在一个ZipEntry的压缩文件
	 * 
	 */
	private void solveCompress() throws Exception{
		System.out.println("=========利用solveCompress解压只含一个ZipEntry压缩的文件");
		//找到只压缩一个文件的压缩文件
		File file=new File(tool.queryPath()+"I19_WinRarWinZIP01.zip");
		//定义解压缩的文件名称
		File outputFile=new File(tool.queryPath()+"I19_WinRarWinZIP"+File.separator+"I18_SequenceInputStrea01_solve01.txt");
		//实例化ZipFile对象
		ZipFile zipfile=new ZipFile(file);
		//得到一个压缩实体
		ZipEntry zipentry=zipfile.getEntry("I18_SequenceInputStrea01.txt");//获取压缩文件中的压缩文件
		//取得ZipEntry的输入流
		InputStream input=zipfile.getInputStream(zipentry);
		//实例化输出流对象
		OutputStream out=new FileOutputStream(outputFile);
		int temp=0;
		while((temp=input.read())!=-1){
			out.write(temp);
		}
		input.close();
		out.close();	
	}
	
	
	/***范例：解压缩复杂压缩文件I19_WinRarWinZIP03.zip
	 * 描述：如果一个压缩文件存在文件夹或多个ZipEntry,上面的方法将不能用来解压，此时必须结合ZipInputStream
	 *     ZipInoutStream是InputStream的子类，通过此类可以方便地读取Zip格式的压缩文件
	 *     借用方法： public ZipInputStream(InputStream in);
	 *     		   public ZipEntry getNextEntry() throws IOException;//取得下一个ZipEntry
	 * 补充描述：在I19_WinRarWinZIP03.zip 压缩文件中，它本身包含压缩的文件夹，所以在进行解压缩前
	 *    应该先根据ZIP文件中的文件夹的名称在硬盘上创建好一个对应的文件夹，然后才能把文件解压缩进去，
	 *    而且在操作时对每一个解压缩的文件都必须先创建（File类的createNewFile()方法可以创建文件）
	 *    后再将内容输出
	 */
	private void solveAllCompress() throws Exception{
		System.out.println("=====解压复杂压缩文件夹=====");
		//找到压缩文件
		String zipFilePath=tool.queryPath()+"I19_WinRarWinZIP03.zip";
		File file=new File(zipFilePath);
		//定义输出的文件对象
		File outFile=null;
		//实例化ZipFile对象
		ZipFile zipfile=new ZipFile(file);
		//实例化zip输入流
		ZipInputStream zipInput=new ZipInputStream(new FileInputStream(file));
		//定义一个ZipEntry对象用于接收压缩文件中的每一个实体
		ZipEntry zipentry=null;
		//定义输入流，用于读取每一个ZipEntry
		InputStream input=null;
		//定义输出流，用于输出每一个实体内容
		OutputStream output=null;
		while((zipentry=zipInput.getNextEntry())!=null){//得到每一个ZipEntry
			System.out.println("解压缩 "+zipentry.getName()+"文件 ");
			//实例化输出文件
			outFile=new File(tool.queryPath()+"I19_WinRarWinZIP"+File.separator+zipentry.getName());
			//判断文件夹是否存在
			//System.out.println(outFile.getParentFile());
			if(!outFile.getParentFile().exists()){
				outFile.getParentFile().mkdirs();
			}
			//判断文件是否存在
			System.out.println(outFile);//后台输出要解压的文件名称
			if(!outFile.exists()){
				outFile.createNewFile();
			}
			//得到压缩实体的输入流
			input=zipfile.getInputStream(zipentry);
			//实例化输出流对象
			output=new FileOutputStream(outFile);
			//读取内容
			int temp=0;
			while((temp=input.read())!=-1){
				output.write(temp);
			}
			input.close();
			output.close();
			
		}
		
		System.out.println("=====解压完毕复杂压缩文件夹=====");
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
