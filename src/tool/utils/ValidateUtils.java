package tool.utils;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;

/**
 * 
 * @Description: 校验工具类
 * @author manb
 * @date 2014-5-4
 *
 */
public class ValidateUtils {

	/**
	 * 
	 * @Description: 身份证号码验证
	 * @author manb
	 * @date 2014-5-4
	 *
	 * @param IDStr
	 * @return
	 * @throws NumberFormatException
	 * @throws ParseException
	 */
	@SuppressWarnings("unchecked")
	public static boolean isIdCard(String IDStr) {
        String[] ValCodeArr = { "1", "0", "X", "9", "8", "7", "6", "5", "4",  
                "3", "2" };  
        String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7",  
                "9", "10", "5", "8", "4", "2" };  
        String Ai = "";  
        // ================ 号码的长度 15位或18位 ================  
        if (IDStr==null || (IDStr.length() != 15 && IDStr.length() != 18)) {  
        	//身份证号码长度应该为15位或18位
            return false;  
        }  
        // =======================(end)========================  
 
        // ================ 数字 除最后以为都为数字 ================  
        if (IDStr.length() == 18) {  
            Ai = IDStr.substring(0, 17);  
        } else if (IDStr.length() == 15) {  
            Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);  
        }  
        if (StringUtils.isNumeric(Ai) == false) {  
        	//身份证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字
            return false;  
        }  
        // =======================(end)========================  
 
        // ================ 出生年月是否有效 ================  
        String strYear = Ai.substring(6, 10);// 年份  
        String strMonth = Ai.substring(10, 12);// 月份  
        String strDay = Ai.substring(12, 14);// 月份  
        if (DateUtils.isDataFormat(strYear + "-" + strMonth + "-" + strDay) == false) {  
        	//身份证生日无效
            return false;  
        }  
        GregorianCalendar gc = new GregorianCalendar();  
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");  
        try {
        	if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150 
        			|| (gc.getTime().getTime() - s.parse(strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {  
        		//身份证生日不在有效范围。  
        		return false;  
        	}  
        } catch(Exception e) {
        	return false;
        }
        if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {  
            //身份证月份无效  
            return false;  
        }  
        if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {  
            //身份证日期无效  
            return false;  
        }  
        // =====================(end)=====================  
 
        // ================ 地区码时候有效 ================  
        Hashtable h = GetAreaCode();  
        if (h.get(Ai.substring(0, 2)) == null) {  
            //身份证地区编码错误。  
            return false;  
        }  
        // ==============================================  
 
        // ================ 判断最后一位的值 ================  
        int TotalmulAiWi = 0;  
        for (int i = 0; i < 17; i++) {  
            TotalmulAiWi = TotalmulAiWi  
                    + Integer.parseInt(String.valueOf(Ai.charAt(i)))  
                    * Integer.parseInt(Wi[i]);  
        }  
        int modValue = TotalmulAiWi % 11;  
        String strVerifyCode = ValCodeArr[modValue];  
        Ai = Ai + strVerifyCode;  
 
        if (IDStr.length() == 18) {  
             if (Ai.equals(IDStr) == false) {  
                 //身份证无效，不是合法的身份证号码  
                 return false;  
             }  
         } 
         // =====================(end)=====================  
         return true;   
	}
	  /** 
     * 功能：设置地区编码 
     * @return Hashtable 对象 
     */ 
    @SuppressWarnings("unchecked")
	private static Hashtable GetAreaCode() {  
        Hashtable hashtable = new Hashtable();  
        hashtable.put("11", "北京");  
        hashtable.put("12", "天津");  
        hashtable.put("13", "河北");  
        hashtable.put("14", "山西");  
        hashtable.put("15", "内蒙古");  
        hashtable.put("21", "辽宁");  
        hashtable.put("22", "吉林");  
        hashtable.put("23", "黑龙江");  
        hashtable.put("31", "上海");  
        hashtable.put("32", "江苏");  
        hashtable.put("33", "浙江");  
        hashtable.put("34", "安徽");  
        hashtable.put("35", "福建");  
        hashtable.put("36", "江西");  
        hashtable.put("37", "山东");  
        hashtable.put("41", "河南");  
        hashtable.put("42", "湖北");  
        hashtable.put("43", "湖南");  
        hashtable.put("44", "广东");  
        hashtable.put("45", "广西");  
        hashtable.put("46", "海南");  
        hashtable.put("50", "重庆");  
        hashtable.put("51", "四川");  
        hashtable.put("52", "贵州");  
        hashtable.put("53", "云南");  
        hashtable.put("54", "西藏");  
        hashtable.put("61", "陕西");  
        hashtable.put("62", "甘肃");  
        hashtable.put("63", "青海");  
        hashtable.put("64", "宁夏");  
        hashtable.put("65", "新疆");  
        hashtable.put("71", "台湾");  
        hashtable.put("81", "香港");  
        hashtable.put("82", "澳门");  
        hashtable.put("91", "国外");  
        return hashtable;  
    }   
}
