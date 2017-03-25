package instance.practical;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.upload.FormFile;

/***
 * 
 * @author honghr
 * @version 1.0.0
 */
public class CreatFindFile {
 /**
  * 
  * @param formFile 上传的文件
  * @param request
  * @param productTypeName 类别名称
  * @param productName 产品名称
  * @param savefileName 保存的文件名
  * @param ext 上传文件的扩展名
  * @throws Exception
  */
 public static void saveProductPic(FormFile formFile,HttpServletRequest request, Integer productTypeId,
   Integer productID, String savefileName, String ext) throws Exception {
	 
  if (formFile != null && formFile.getFileSize() > 0) {
   // 1:保存原大小尺寸的图片
   String pathdir = "/image/product/" + productTypeId + "/"
     + productID + "/prototype";// 构建图片保存的目录
   // 得到图片保存目录的真实路径
   String realpathdir = request.getSession().getServletContext()
     .getRealPath(pathdir);
   // 创建文件目录
   File savedir = new File(realpathdir);
   // 如果目录不存在就创建
   if (!savedir.exists()) {
    savedir.mkdirs();
   }
   File imageFile = new File(savedir, savefileName);
   FileOutputStream fops = new FileOutputStream(imageFile);
   // 将上传的文件信息保存到相应的文件目录里
   fops.write(formFile.getFileData());
   fops.close();
   // 2:保存原压缩尺寸的图片
   String path140 = "/image/product/" + productTypeId + "/"
     + productID + "/140x";// 构建图片保存的目录
   // 得到图片保存目录的真实路径
   String realpath140 = request.getSession().getServletContext()
     .getRealPath(path140);
   // 创建文件目录
   File savedir140 = new File(realpath140);
   // 如果目录不存在就创建
   if (!savedir140.exists()) {
    savedir140.mkdirs();
   }
   File imageFile140 = new File(savedir140, savefileName);
   //ImageSizer.resize(imageFile, imageFile140, 140, ext);//找不到对应类
  }
 }
 /**
  * 
  * @param formFile 上传的品牌图片文件
  * @param request
  * @param saveName 保存的文件的名字
  * @param ext 保存的文件的扩展名
  * @return
  * @throws FileNotFoundException
  * @throws IOException
  */
 public static String saveBrandPic(FormFile formFile, HttpServletRequest request,
   String saveName, String ext) throws FileNotFoundException,
   IOException {
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH");
  String savepath = "/image/brand/" + sdf.format(new Date());//构建图片保存的目录
  //得到图片保存目录的真实路径
  String realsavepath = request.getSession().getServletContext()
    .getRealPath(savepath);
  //创建文件目录
  File logosavedir = new File(realsavepath);
  //如果目录不存在就创建
  if (!logosavedir.exists()) {
   logosavedir.mkdirs();
  }
  FileOutputStream fops = new FileOutputStream(new File(realsavepath,
    saveName));
  fops.write(formFile.getFileData());
  fops.close();
  return savepath;
 }
}
