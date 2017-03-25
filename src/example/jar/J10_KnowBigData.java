package example.jar;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * BigInteger类与BigDecimal类的使用
 * 当一个数字非常大时，是无法用基本数据类型接收的，早期是用String，然后拆分，
 * 现在通过BigInteger来解决问题，它表示大整数类，在java.math
 *
 */
public class J10_KnowBigData {

	public static void main(String[] args) {
		J10_KnowBigData j10=new J10_KnowBigData();
		//1.BigInteger类的
		j10.explainBigInteger();
		//2.BigDecimal的作用
		j10.explainBigDecimal(4567.88,222.34);
		
		
	}
	/**BigInteger类的作用
	 * public BigInteger(String val)：将一个字符串变为BigInteger类型的数据
	 * public BigInteger[] divideAndRemainder(BigInteger val):除法操作，
	 * 	数组的第一个元素为除法的商，第二个元素为除法的余数
	 * BigInteger中常用的方法比较多，可以查阅JDK文档
	 * 
	 */
	public void explainBigInteger(){
		System.out.println("*******************BigInteger类的使用******************************");
		BigInteger b1=new BigInteger("123456789");
		BigInteger b2=new BigInteger("987654321");
		System.out.println("b2:"+b2+",b1:"+b1);
		System.out.println("加法操作public BigInteger add(BigInteger v)："+b2.add(b1));
		System.out.println("减法操作public BigInteger subtract(BigInteger v)："+b2.subtract(b1));
		System.out.println("乘法操作public BigInteger multiply(BigInteger v)："+b2.multiply(b1));
		System.out.println("除法操作public BigInteger divide(BigInteger v)："+b2.divide(b1));
		System.out.println("返回两个值中的最大值:public BigInteger max(BigInteger v):"+b2.max(b1));

	}

	/** BigDecimal
	 * 对于不需要任何精确的数字可以直接使用float与double，
	 * 但如果需要精确计算的结果，则需要BigDecimal类，而且BigDecimal类也可进行大数的操作
	 * publig BigDecimal(double d|int v|String v)
	 */
	public void explainBigDecimal(double d1,double d2){
		System.out.println("***************BigDecimal的用法********************");
		//进行四舍五入的算法
		BigDecimal bb1=new BigDecimal(d1);
		BigDecimal bb2=new BigDecimal(d2);
		System.out.println("执行加法add："+bb1.add(bb2).doubleValue());
		System.out.println("执行减法subtract："+bb1.subtract(bb2).doubleValue());
		System.out.println("执行乘法multiply："+bb1.multiply(bb2).doubleValue());
		//BigDecimal.ROUND_HALF_UP表示进行四舍五入的操作
		System.out.println("执行除法divide："+bb1.divide(bb2,BigDecimal.ROUND_HALF_UP).doubleValue());
		
	}

}
