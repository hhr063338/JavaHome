package instance.practical;


import java.io.File;
 
/**
  * 

 *自动扫描文件夹下的文件
  *用途：自动扫描脚本输入路径，输出要执行的sql导入数据库；
  */
 public class OutSql { 
 /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String path ="D:\\Program Files\\workspace5.5\\orclCode\\procedure";
    GetSql(path);
  }
  /*
   * 递归调用查找指定文件加下所有文件
   */
  public static  String GetSql(String path){
   File rootDir = new File(path);
    if(!rootDir.isDirectory()){
     System.out.println("文件名"+rootDir.getAbsolutePath());
    }else{
     String[] fileList =  rootDir.list();
     for (int i = 0; i < fileList.length; i++) {
      path = rootDir.getAbsolutePath()+"\\"+fileList[i];
      GetSql(path);      
       } 
   }    
  return null;    
 }
 }
