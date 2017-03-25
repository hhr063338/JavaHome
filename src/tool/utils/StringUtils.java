package tool.utils;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class StringUtils {
	public static final String XMLHTTPREQUEST = "XMLHttpRequest";
    private static final Pattern EMAIL = Pattern.compile("^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$");
    private static final Pattern NUMERIC = Pattern.compile("^[0-9]+$");
    private static final Pattern MONEY = Pattern.compile("^[0-9]+$|^[0-9]+\\.[0-9]{1,6}$");
    private static final Pattern PHONE = Pattern.compile("^(\\+?86[-]?)?[1][0-9]{10}$");
    private static final Pattern CH_CHAR = Pattern.compile("^[\u4e00-\u9fa5]+$"); 
    private static final Pattern AREA_TEL = Pattern.compile("^[0][1-9]{2,3}[-]?[0-9]{5,10}$");  // 验证带区号的
    private static final Pattern TEL = Pattern.compile("^[1-9]{1}[0-9]{5,8}|400[-]?[0-9]{3,8}$");         // 验证没有区号的和400号码
	/**
	 * 
	 * @param sourceString
	 *            被替换的字符，类型数组
	 * @param targetString
	 *            替换的字符，类型数组
	 * @param Content
	 *            要被替换的字符内容
	 * @return
	 */
	public static String str_replace(String[] sourceString,
			String[] targetString, String Content) {
		if (targetString.length != sourceString.length
				&& targetString.length != 1) {
			try {
				throw new Exception("字符长度不匹配");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			for (int i = 0; i < sourceString.length; i++) {
				if (targetString.length == 1) {
					Content = Content.replaceAll(sourceString[i],
							targetString[0]);
				} else {
					Content = Content.replaceAll(sourceString[i],
							targetString[i]);
				}
			}

		}
		return Content;

	}

	/**
	 * 字符串按指定符号分割为数组
	 * 
	 * @param str
	 * @param Symbol
	 * @return
	 */
	public static String[] split(String str, String symbol) {
		if (str.length() < 1 || symbol.length() < 1) {
			try {
				throw new Exception("字符错误");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String[] strSplit = str.split(symbol);
		return strSplit;
	}



	public static Long time() {

		return Long.parseLong(String.valueOf(System.currentTimeMillis())
				.substring(0, 9));
	}
	/* 计算不对,如果算整数年份可以使用 DateUtils.getAfterYears()替代
	 * 算月份可以用DateUtils.getAfterNMonths()
	public static Long strtotime(long phpTime, Long monthes) {

		Long time = phpTime + ((31536000L / 12L) * monthes);
		return time;
	}
	 */
	/**
	 * 身份证号码替换(保留前4位、后4位数字,其余的用"*"替代)
	 * 
	 * @param str
	 * @return
	 */
	public static String replace_IDCard(String idCard) {
		if (idCard == null || idCard.length() == 0 || "".equals(idCard)) {
			return idCard;
		}
		String strMid = idCard.substring(4, idCard.length() - 4);
		String strStart = idCard.substring(0, 4);
		String strEnd = idCard.substring(idCard.length() - 4, idCard.length());
		StringBuffer sb = new StringBuffer();
		String str = "";
		for (int i = 0; i < strMid.length(); i++) {
			str += "*";
		}
		sb.append(strStart);
		sb.append(str);
		sb.append(strEnd);
		return sb.toString();
	}

	public static String substr(String str, int beginIndex, int endIndex) {
		return str.substring(beginIndex, endIndex);
	}

	// 验证邮箱
	public static Boolean checkEmail(String email) {
        Matcher m = EMAIL.matcher(email);     
        return m.matches();
	}
	
	/**
	 * 
	 * @Description: 字符串补足自定的长度
	 *
	 * @param str 规定要填充的字符串(必须)
	 * @param len 规定新字符串的长度(必须) 如果该值小于原始字符串的长度，则不进行任何操作。
	 * @param padStr 规定供填充使用的字符串（默认空格）
	 * @param padType 规定填充字符串的那边（默认左边）
	 * @return 
	 */
	public static String strPad(String str,int len,String padStr,padType padType) throws Exception{
		
		if(str == null){
			throw new Exception("规定要填充的字符串不能为空！");
		}
		if(len < 0){
			throw new Exception("规定新字符串的长度不能小于0！");
		}
		if(str.length()< len){
			//原字符串的长度小于新规定的长度时才做处理
				if(StringUtils.padType.STR_PAD_LEFT.equals(padType)){
					str = org.apache.commons.lang3.StringUtils.leftPad(str, len, padStr);
				}else{
					//默认加右侧
					str = org.apache.commons.lang3.StringUtils.rightPad(str, len, padStr);
				}
		}
		return str;
		
	}
    public enum padType{
    	STR_PAD_LEFT,STR_PAD_RIGHT;
    }

	/**
	 * 生成一个随机数，如果没有起始范围，则输入值应为null
	 * @param begin 起始范围
	 * @param end  结束范围
	 * @return
	 */
	public static String random(Integer begin, Integer end) {
		java.util.Random r = new java.util.Random();
		int result = r.nextInt(end);
		if (begin != null) {
			while (result < begin) {
				result = r.nextInt(end);
			}
		}
		return String.valueOf(result);
	}
	/**
	 * 
	 * @Description: 判断字符串是否为数字
	 * @author manb
	 * @date 2014-5-4
	 *
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {  
        Matcher isNum = NUMERIC.matcher(str);  
        if (isNum.matches()) {  
            return true;  
        } else {  
            return false;  
        }  
    }
	
	/**
	 * 是否为金额
	 * @param str
	 * @return
	 */
	public static boolean isMoney(String str) {
		return MONEY.matcher(str).matches();
	}
	
	public static String encode(String str, String fromCharset, String toCharset) {
		try {
			return new String(str.getBytes("fromCharset"), toCharset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static String encode(String str, String charsetName) {
		try {
			return new String(str.getBytes("gb2312"), charsetName);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	/**
	 * 校验手机号
	 * @param phone
	 * @return
	 */
	public static boolean is_phone(String phone) {
		/*return PHONE.matcher(phone).matches();*/
		
		Pattern p = null;  
        Matcher m = null;  
        boolean b = false;   
        p = Pattern.compile("^[1][3,4,5,8,7][0-9]{9}$");
        m = p.matcher(phone);  
        b = m.matches(); 
		return  b;
	}
	/**
	 * 
	 * @Description: 千分位两位小数
	 * @author manb
	 * @date 2014-8-19
	 *
	 * @param s
	 * @return
	 * @throws Exception
	 */
	 public static String getNumKb(Double s) throws Exception {
		NumberFormat formatter = new DecimalFormat("###,##0.00");
		return formatter.format(s);
	}  
	
	/**
	 * 是否是中文字符
	 * @param str
	 * @return
	 */
	public static boolean is_chinese(String str) {
		if(str==null) return false;
        Matcher result=CH_CHAR.matcher(str);                  
        return result.matches();
	}
	/**
	 * 是否是固定电话
	 * @param tel
	 * @return
	 */
	public static boolean is_tel(String tel) {
			/*Matcher m = null;
			boolean b = false;  
			if(tel.length() >9)
			{	m = AREA_TEL.matcher(tel);
	 		    b = m.matches();  
			}else{
				m = TEL.matcher(tel);
	 			b = m.matches(); 
			}  
			return b;*/
			return AREA_TEL.matcher(tel).matches() || TEL.matcher(tel).matches();
	}
	
	public static int byteLength(String str) {
		if(str==null) return 0;
		try {
			return str.getBytes("gb2312").length;
		} catch (UnsupportedEncodingException e) {
			return str.getBytes().length;
		}
	}
	
	/*
	 * 判断字符串,返回一个空串
	 */
	public static String isNull(Object obj){
		//if(null != obj ){
			//return obj.toString();
		//}
		return obj == null ? "" : obj.toString();
	}
	public static void main(String a[]) {
		System.out.println(StringUtils.byteLength("输出12就对了"));
	}
	
    /** 
     * 校验银行卡卡号 
     * @param cardId 
     * @return 
     */  
    public static boolean checkBankCard(String cardId) {  
          char bit = getBankCardCheckCode(cardId.substring(0, cardId.length() - 1));  
          if(bit == 'N'){  
              return false;  
          }  
          return cardId.charAt(cardId.length() - 1) == bit;  
    }  
     
    /** 
     * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位 
     * @param nonCheckCodeCardId 
     * @return 
     */  
    public static char getBankCardCheckCode(String nonCheckCodeCardId){  
        if(nonCheckCodeCardId == null || nonCheckCodeCardId.trim().length() == 0  
                || !nonCheckCodeCardId.matches("\\d+")) {  
         //如果传的不是数据返回N  
            return 'N';  
        }  
        char[] chs = nonCheckCodeCardId.trim().toCharArray();  
        int luhmSum = 0;  
        for(int i = chs.length - 1, j = 0; i >= 0; i--, j++) {  
            int k = chs[i] - '0';  
            if(j % 2 == 0) {  
                k *= 2;  
                k = k / 10 + k % 10;  
            }  
            luhmSum += k;             
        }  
        return (luhmSum % 10 == 0) ? '0' : (char)((10 - luhmSum % 10) + '0');  
    }  
}
