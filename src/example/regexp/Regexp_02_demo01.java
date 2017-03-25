package example.regexp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *查看一个或多个源文件里面的代码，有多少是空行，多少是注释，多少有效代码
 *
 *
 */

public class Regexp_02_demo01 {
	
	static long normalLines = 0;
	static long commentLines = 0;
	static long whiteLines = 0;
	
	public static void main(String[] args) {
		File f = new File("D:\\share\\JavaProjects\\TankWar1.9.11\\src");
	//查看文件夹f里面包含哪些文件,然后分析子文件
		File[] codeFiles = f.listFiles();
	//对子文件的后缀名进行检测
		for(File child : codeFiles){
			if(child.getName().matches(".*\\.java$")) {  
				parse(child);
			}
		}
		
		System.out.println("normalLines:" + normalLines);
		System.out.println("commentLines:" + commentLines);
		System.out.println("whiteLines:" + whiteLines);
		
	}

	private static void parse(File f) {
		BufferedReader br = null;
		boolean comment = false;
		try {
			br = new BufferedReader(new FileReader(f));
			String line = "";
			while((line = br.readLine()) != null) {	
			//因为如果在源文件里使用tab键在注释，可能不会被正则表达式识别注释，在这里需要用String类的trim()方法
				line = line.trim();

			//判断是否是空行，即行首位置是空而且不是换行（回车），且是行尾的是换行
			//在这里因为使用readLine()方法，已经把内容中的“\n”去掉了，所以这里作为匹配条件的行尾不是“\\n”

				if(line.matches("^[\\s&&[^\\n]]*$")) {	
				
					whiteLines ++;
				} else if (line.startsWith("/*") && !line.endsWith("*/")) {
					commentLines ++;
					comment = true;	
				} else if (line.startsWith("/*") && line.endsWith("*/")) {
					commentLines ++;
				} else if (true == comment) {
					commentLines ++;
					if(line.endsWith("*/")) {
						comment = false;
					}
				} else if (line.startsWith("//")) {
					commentLines ++;
				} else {
					normalLines ++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
					br = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
