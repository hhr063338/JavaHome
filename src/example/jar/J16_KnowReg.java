package example.jar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 使用正则表达式可以方便地对数据进行匹配，还可以执行更加复杂的字符串验证、拆分、替换功能
 * 实际上具体的正则表达式操作类是需要通过Pattern和Macher两个类操作的
 * 这两个类都是在java.util.regex包中定义的
 * Pattern类的主要作用是进行正则规范("[0-9]+")的编写,Matcher类主要是执行规范，验证一个字符串是否符合规范
 *
 */
public class J16_KnowReg {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		J16_KnowReg j16=new J16_KnowReg();
		j16.checkNumber();
		j16.checkNumber2();
		//3.验证是否是合法的日期格式yyyy-mm-dd
		j16.checkDate("2014-12-03");//还不严谨，2014-14-02
		//4.按照字符串的数字将字符串拆分
		j16.splitStr("A1BB22CCC3DDDD4444EEEEE5");
		//5. 在String类中有3个方法支持正则操作
		j16.testStringRegex();
		//"LXH:98|MLDN:90|LI:100"转义
		j16.checktRegexStr();
	}
	//1.不适用正则表达式验证字符串是由数字组成的
	public void checkNumber(){
		System.out.println("*********不使用正则表达式来验证某字符串全部由数字组成**********");
		String str1="1234567890";
		boolean flag=true;
		char c[]=str1.toCharArray();
		for(int i=0;i<c.length;i++){
			if(c[i]<'0'||c[i]>'9'){
				flag=false;
				break;
			}
		}
		if(flag){
			System.out.println("字符创\"12345567890\"该字符串都是由数字组成");
			
		}else{
			System.out.println("字符创\"12345567890\"该字符串不是由数字组成的");
		}
	}

	//2.使用正则表达式验证字符串都是由数字组成的
	public void checkNumber2(){
		System.out.println("******使用正则表达式验证字符串是否全部由数字组成***********");
		String str="0123456789";
		if(Pattern.compile("[0-9]+").matcher(str).matches()){
			System.out.println("字符串\"01234556789\"是由数字组成的");
			
		}else{
			System.out.println("字符串\"01234556789\"不是由数字组成的");
		}
	}
	
	//3.验证是否是合法的日期格式
	public void checkDate(String str){
		System.out.println("===========验证是否日期格式yyyy-mm-dd================");
		//"\d"表示数字,"\D"表示非数字,"X{n}"必须出现n次,"X{n,}"必须出现n次以上
		//"X{n,m}"必须出现n次到m次之间
		//在程序中"\"字符是需要进行转义的，两个"\"实际上表示的是一个"\"，所以实际上"\\d"表示的是"\d"
		String pat="\\d{4}-\\d{2}-\\d{2}";//定义验证规则
		Pattern p=Pattern.compile(pat);//实例化Pattern类
		Matcher m=p.matcher(str);		//验证字符串内容是否合法
		if(m.matches()){
			System.out.println("日期格式合法！");
		}else{
			System.out.println("日期格式不合法！");
		}
		
	}
	
	//4.按照字符串的数字将字符串拆分
	public void splitStr(String str){
		String pat="\\d+";//"X+"表示出现一次或多次
		Pattern p=Pattern.compile(pat);
		String s[]=p.split(str);
		for(int i=0;i<s.length;i++){
			System.out.print(s[i]+"\t");
		}
		//在字符串中因为数字的长度不一样，所以这里使用"+d"表示1位或多位数字都可以拆分
		
	}

	//5.String类对正则表达式的支持
	/** 在String类中有3个方法支持正则操作
	 * public boolean matches(String regex) 字符串匹配
	 * public String replaceAll(String regex,String replacement) 字符串替换
	 * public String[] split(String regex);  字符串拆分
	 */
	public void testStringRegex(){
		System.out.println();
		System.out.println("********* 在String类中有3个方法支持正则操作*****************************");
		String str1="A1B22C333D4444EEEEE5";
//		str1.replaceAll("\\d+", "_");//注意是replaceAll()方法而不是replace()方法
		System.out.println(str1.replaceAll("\\d+", "_"));//使用replaceAll()方法返回字符串，不对原有的做处理
		boolean temp="2014-03-20".matches("\\d{4}-\\d{2}-\\d{2}");
		String[] s="A1B22C333D4444EEEEE5".split("\\d+");
		
		System.out.println(temp);
		for(int i=0;i<s.length;i++){
			System.out.print(s[i]+"\t");
		}
	}
	
	//6.对正则转义，注意对"|"的处理
	public void checktRegexStr(){
		System.out.println("\n********对\"LXH:98|MLDN:90|LI:100\"字符串进行转义**************");
		String info="LXH:98|MLDN:90|LI:100";
//		String pat="[a-zA-Z]+";
		String s[]=info.split(":+");//去掉：
		String s2="";
		for(int i=0;i<s.length;i++){
			System.out.print(s[i]);
			s2=s2+s[i];
		}
		System.out.println("\n执行一次分隔");
		//拆分”|“
		String ss[]=s2.split("|");
		for(String st:ss){
			System.out.print(st);
		}
		System.out.println("\n可见\'|\'的特殊");
		String sss=s2.replaceAll("\\|", "    ");
			System.out.print(sss);
		
		

	}
}
