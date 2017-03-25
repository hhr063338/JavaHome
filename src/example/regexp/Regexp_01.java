package example.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 * 
 * <ul>
 * <li>文件名称: D04_String_Regexp.java</li>
 * <li>文件描述: 学习正则表达式 </li>
 * <li>引用：D04_String_Regexp</li>
 * </ul>
 * @author honghr
 * @version 1.0.0
 */
public class  Regexp_01{

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Regexp_01 regxp=new Regexp_01();
		//如果直接调用String中的match方法，是判断整个字符串是否匹配指定模式
		//但是如果用Pattern来匹配，是判断是否含有匹配指定模式的字符串
		//使用Matcher.find()连续执行的结果并不一定相同
		
		//1.正则表达式的调用方法一
		regxp.testbase01();
		//2.正则表达式的调用方法二
		regxp.testbase02();
		//3.正则表达式学习1： content:匹配自身、字符类匹配、重复类匹配、选择符
		regxp.regLearn01();
		//4.正则表达式学习2： content：定位符、分组、引用、标记
		regxp.regLearn02();
	}
	
	
	/***
	 * title:1.正则表达式调用方法一
	 *
	 */
	private void testbase01(){
        //matches()判断字符串是否匹配某个表达式，"."表示任何一个字符
        System.out.println("abc".matches("..."));
        //将字符串"a2389a"中的数字用*替换，\d 表示“0--9”数字
        System.out.println("a2389a".replaceAll("\\d", "*"));
        //将任何是a--z的字符串长度为3的字符串进行编译，这样可以加快匹配速度
        Pattern p = Pattern.compile("[a-z]{3}");
        //进行匹配，并将匹配结果放在Matcher对象中
        Matcher m = p.matcher("abc");
        System.out.println(m.matches());
        //上面的三行代码可以用下面一行代码代替
        System.out.println("abc".matches("[a-z]{3}"));
        
        //String上可使用正则表达式的操作，实际上是利用了java.util.regex.Pattern
        //与java.util.regex.Matcher的功能。
        //当调用String的matches()方法时，实际上是调用Pattern的静态方法matches()，
        //这个方法会返回boolean值，表示字符串是否符合正则表达式  
	}
	
	/**
	 * title:正则表达式的用法02
	 * @param str
	 */
	private void testbase02(){
		String s = "@Shang Hai Hong Qiao Fei Ji Chang"; 
		String regEx = "a|F"; //表示a或F  
		//static Pattern compile(String regex) 将给定的正则表达式编译并赋予给Pattern类 
		Pattern pat = Pattern.compile(regEx);  
		//使用Pattern.matcher返回符合条件的Matcher实例
		Matcher mat = pat.matcher(s);  
		//find()方法表示是否有符合的字符串，group()方法可以将符合的字符串返回
		boolean rs = mat.find();   
		if(rs){
			System.out.println("符合条件的字符串:"+mat.group());
		}
		//如果字符串s中含有符合regEx表达式的字符,那么rs为true,否则为false
		//如果想在查找时忽略大小写，则可以写成Pattern pat=Pattern.compile(regEx,Pattern.CASE_INSENSITIVE);
	}
	
	/**
	 * title:与自身匹配-正则表达式学习1
	 * content:匹配自身、字符类匹配、重复类匹配、选择符
	 */
	private void regLearn01(){
		
		/**与自身匹配****/
		//正常自身匹配，只需要要匹配的字符放在一对斜杠中间，
		//直接用String.matches(regex)其中regex直接省略开闭合标签斜杠
		System.out.println("4sx的自身匹配："+"4sx".matches("4sx"));
		//匹配具有特殊含义的字符，如！ $  ^  *  +  =  |  .  ?  \  /  (  )  [  ]  {  },可以利用反斜杠\
		System.out.println("匹配特殊字符(!$\\n)："+"!$\n".matches("\\!\\$\\n"));//其中java转译一次，然后正则表达式又转译一次
		
		/**用字符类匹配***/
		//正则表达式中的字符类（character class）可以以代表一系列的字符，一个字符类可以与其包含的任何字符相匹配
		//创建字符类的方式：只要将要匹配的字符放入方括号（“[ ]”）中即可
		//除了将要匹配的字符直接放在方括号中，还可以用“-”来制定要匹配的字幕范围（“/[a-h/”或“/[A-Z]/”或 “/[1-100]/”）
		//在字符类中，可以使用“^”来代表排除性的匹配，类似于“非”，包括在方括号之中（“/[^ace]/”引号内的正则表达式表示可以匹配除小写字母a、c、e之外的所有字符）
		//在正则表达式中还添加集中有特殊含义的字符类:
		// [\w]可以匹配任何ASCII单字字符,相当于[a-zA-Z0-9]  [\W]可以匹配ASCII单字字符外的字符
		// [\s]可以匹配Unicode空白符					    [\S]可以匹配任何Unicode空白符之外的字符
		// [\d]可以匹配任何数字							[\D]可以匹配任何数字之外的字符，相当于[^0-9]
		System.out.println("匹配任意的数字(3)："+"3".matches("[\\d]")+",这是字符匹配");
		//Pattern pat=Pattern.compile("[\\d]");
		//Matcher mat=pat.matcher("2ewef23");
		
		/**重复类匹配****/
		//之前讲过的方法都只能匹配单个字符，为了可以多次匹配，这里提供了重复类
		//重复类可以指定字符要重复的次数，最常见的重复类为“？”代表可以匹配前一个字符0次或1次，“*”代表可以匹配前一个字符0次或多次
		//下面是正则表达式中的重复类及其含义:
		//{n}:匹配前一项n次                                    {n,}:匹配前一项至少n次                   {n,m}:匹配前一项，至少n次，最多m次
		//? :匹配前一项1次或0次 ，相当于{0,1}；     +：匹配前一项至少1次，相当于{1,};      *:匹配前一项0次或多次
		System.out.println("(1222332)其中2重复三次："+"1222332".matches("12{1,}332"));
		System.out.println("(1222332)其中2重复三次："+"1222332".matches("12+332"));
		
		/**选择符*******/
		//regular expression 的选择符为“|”，该选择符用于分隔可以用来选择的文字（“/index| default| list/”该式可以匹配字符串“index”、“default”或“list”）
		//注意：regular expression选择符的匹配方式是从左至右，一旦发现可以匹配的字符就会停止匹配
		String testSel="medium";
		Pattern patsel=Pattern.compile("small|medium|big");
		Matcher match=patsel.matcher(testSel);
		System.out.println("(medium)匹配正则表达式('small|medium|big'):"+match.find()+" 匹配的字符串:"+match.group());

		
	}
	
	/***
	 * title:正则表达式学习2
	 * content：定位符、分组、引用、标记
	 */
	private void regLearn02(){
		/**定位符****/
		//正则表达式中一种较为独特的专用字符——定位符，用于规定匹配模式在目标对象中出现的位置
		//常用的定位符：^ 规定匹配模式必须出现在目标常用字符串的开头  $ 规定匹配模式必须出现在目标对象的结尾
		// (\b)规定匹配模式必须出现在目标字符串的开头或结尾的两个边界之一
		//(\B)规定匹配模式必须位于目标字符串的开头和结尾两个边界之内,即匹配对象既不能作为开头，也不能作为结尾
		//"(?=p)"正向声明，要求接下来的字符都与模式p匹配
		//"(?!p)"反向声明，要求接下来的字符都不与模式p匹配
		System.out.println("=========校验【定位符】的使用==========");
		//System.out.println("(sfe23dse)是否符合指定校验规则："+"sfe23dse".matches("[sfe]+[\\d]+dse"));
		//System.out.println("(sfe23dse)是否符合指定校验规则："+"sfe23dse".matches("[sfe]+.*e$"));
		Pattern pat=Pattern.compile("aaa");
		Pattern pat2=Pattern.compile("^aaa");
		Matcher match=pat.matcher("xxx aaa xxx");
		Matcher match2=pat2.matcher("xxx aaa xxx");
		System.out.println("(xxx aaa xxx)是否符合指定校验规则："+(match.find()==true?match.group():"不符合"));		
		System.out.println("(xxx aaa xxx)是否符合指定校验规则："+(match2.find()==true?match2.group():"不符合"));
		//System.out.println("(xxx aaa xxx)是否符合指定校验规则："+"xxx aaa xxx".matches("aaa"));
		
		/**分组*******/
		//在Regexp中使用小括号()可以对匹配符进行分组，若将匹配符进行分组之后，可以像一个独立的字符那样进行重复类的操作
		System.out.println("=========校验【分组()】的使用==========");
		System.out.println("boyboyfriend是否符合匹配模式/(boy)+friend/:"+"boyboyfriend".matches("(boy)+friend"));

		/**引用*******/
		//在regular expression 中，将分配符分组之后，还可以再同一个regular expression正则表达式中引用分组之后的分配符
		//在regular expression中，可以使用反斜杠加数字的方法引用分组，例如“\1”可以引用第一个分组
		//“/(['"])[^'"]*['"]/”与“/(['"])[^'"]*\1/”的区别是后者匹配字符串开头与结尾一样
		//注意：可见使用引用方式时不是单纯的重复正则表达式的匹配模式，而是重复内容
		System.out.println("=========校验【引用】的使用==========");
		System.out.println("friendboyfriend的正则匹配模式 /(friend)boy\\1/:"+"friendboyfriend".matches("(friend)boy\\1"));
		
		/**标记*********/
		//正则表达式中的标志用于说明匹配的规则，regular expression中的标志一共有三个，
		//i不区分大小写,g匹配时执行全局匹配，即找出所有的匹配，而不是在找到第一个匹配后就停止匹配，m匹配执行多行匹配，即使用^匹配一行的开头，$匹配一行的结尾
		//regular的标记（i,g,m）通常写在“/”符号之外，用于对整个表达式的匹配情况进行说明
		//“/class/i”“/class/gi”“/class/m”这三个表达式中，需要说明的是第三个，
		//m标志在JavaScript 1.5之后才支持的标志，可执行多行匹配，在这种模式下也可以通过使用^与$定位符匹配，可匹配“class”或“class\ndefinition”
		System.out.println("=========校验【标记】的使用==========");
		Pattern pattern_bz=Pattern.compile("dsf", Pattern.CASE_INSENSITIVE);
		Matcher match_bz=pattern_bz.matcher("DSF");
		System.out.println("DSF 的正则匹配模式 /dsf/i :"+match_bz.find());
		System.out.println("DSF 的正则匹配模式 /dsf/ :"+"DSF".matches("dsf"));
	}
	
}
