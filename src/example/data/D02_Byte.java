package example.data;

/***
 * 
 * <ul>
 * <li>文件名称: D01Byte.java</li>
 * <li>文件描述: 主要介绍byte数据类型的使用</li>
 * </ul>日期:2015/01/13

 */
public class D02_Byte {
	
	/****
	 * 在今天，byte字节就是一个八位元组，使用其它位数的机器都进了博物馆。
	 * java也提供了一个byte数据类型，并且是基本类型。java byte是做为最小的数字来处理的，
	 * 因此它的值域被定义为-128~127，也就是signed byte（符号字节）。
	 * 不幸的是，byte的用作计数的时间远少于用表达基本内存单元的时间。
	 * 比如从stream里读入一个双字节字符，我们先收到2个byte。
	 * 为了把byte转换成适当的形式，需要对byte值做一些比较，
	 * 比如判断字符集要比较其是否在某个编码范围内，比如GBK 0x8140~0xFEFE，然后new适当的string。
	 */

	/***
	 * 正数的原码、反码、补码是相同的（这是约定）
	 * 负数的反码是原码除符号位各位取反
	 * 负数的补码是原码除符号位各位取反加1
	 */
	public static void main(String[] args) throws Exception{
		
		D02_Byte data_byte=new D02_Byte();
		//在java中byte占用1个字节,而一个字节为8位二进制位
		//data_byte.byteToBinary();
		//将byte数组转换为二进制输出
		//data_byte.bytesToBinary();
		//将byte转换为int输出
		data_byte.unsignedByteToInt();
	}
	
	/***
	 * 在java中byte是数值型数据类型为一个字节共8位二进制位，
	 * 第一位为控制符号，所以数值有7位，数值范围-2^7-+2^7-1(还有0的数值所以-1)
	 * 00000000表示0,00000001表示1,10000000表示-128,11111111表示-1
	 */
	private void byteToBinary() throws Exception{
		String bytestr="00000000";
		byte num1=0;
		byte num2=1;
		byte num4=-1;
		byte num3=-128;
		String binary1=Integer.toBinaryString(num1);
		String binary2=Integer.toBinaryString(num2);
		String binary3=Integer.toBinaryString(num3);
		String binary4=Integer.toBinaryString(num4);
		System.out.println("在java中byte类型，值与二进制的表示如下:");
		if(binary1.length()>8){//类似0、1等00000000,00000001得到的字符串是0,1
			System.out.println("   0的二进制："+binary1.substring(binary1.length()-8));
		}else{
			System.out.println("   0的二进制："+bytestr.substring(binary1.length())+binary1);
		}

		if(binary1.length()>8){//类似0、1等00000000,00000001得到的字符串是0,1
			System.out.println("   1的二进制："+binary2.substring(binary2.length()-8));
		}else{
			System.out.println("   0的二进制："+bytestr.substring(binary2.length())+binary2);
		}
		
		System.out.println("  -1的二进制："+binary3.substring(binary3.length()-8));
		System.out.println("-128的二进制："+binary4.substring(binary4.length()-8));

		System.out.println("**结束querybase方法***");
		//System.out.println(num_byte_binary);
		
	}
	
	/***
	 * 将byte数组转换位二进制
	 * 一个中文字符两个字节
	 * @throws Exception
	 */
	private void bytesToBinary() throws Exception{
		System.out.println("***开始bytesToBinary方法*****");
		String ZERO="00000000";
		String x ="lalala";
		byte[]   bs   =   x.getBytes();
		for   (int i = 0;i<bs.length;i++)   {
			String   s   =   Integer.toBinaryString(bs[i]);
			if(s.length() >8){
				s   =   s.substring(s.length()   -   8);
			}else if (s.length()< 8){
				s   =   ZERO.substring(s.length())   +   s;
			}
			System.out.println(s);
		}
		System.out.println("***结束bytesToBinary方法*****");
	}
	
    /** 
     * 将一个单字节的byte转换成32位的int 
     */  
    private void  unsignedByteToInt() {  
    	System.out.println("***开始unsignedByteToInt的方法将byte转换为int******");
    	byte b=120;
    	int  b_int= (int) b & 0xFF;
    	System.out.println(b_int);
    	System.out.println("***结束unsignedByteToInt的方法******");
 
    }  
  
    /** 
     * 将一个单字节的Byte转换成十六进制的数 
     *  
     * @param b 
     *            byte 
     * @return convert result 
     */  
    private static String byteToHex(byte b) {  
        int i = b & 0xFF;  
        return Integer.toHexString(i);  
    }  
  
    /** 
     * 将一个4byte的数组转换成32位的int 
     *  
     * @param buf 
     *            bytes buffer 
     * @param byte[]中开始转换的位置 
     * @return convert result 
     */  
    private static long unsigned4BytesToInt(byte[] buf, int pos) {  
        int firstByte = 0;  
        int secondByte = 0;  
        int thirdByte = 0;  
        int fourthByte = 0;  
        int index = pos;  
        firstByte = (0x000000FF & ((int) buf[index]));  
        secondByte = (0x000000FF & ((int) buf[index + 1]));  
        thirdByte = (0x000000FF & ((int) buf[index + 2]));  
        fourthByte = (0x000000FF & ((int) buf[index + 3]));  
        index = index + 4;  
        return ((long) (firstByte << 24 | secondByte << 16 | thirdByte << 8 | fourthByte)) & 0xFFFFFFFFL;  
    }  
  
    /** 
     * 将16位的short转换成byte数组 
     *  
     * @param s 
     *            short 
     * @return byte[] 长度为2 
     * */  
    private static byte[] shortToByteArray(short s) {  
        byte[] targets = new byte[2];  
        for (int i = 0; i < 2; i++) {  
            int offset = (targets.length - 1 - i) * 8;  
            targets[i] = (byte) ((s >>> offset) & 0xff);  
        }  
        return targets;  
    }  
  
    /** 
     * 将32位整数转换成长度为4的byte数组 
     *  
     * @param s 
     *            int 
     * @return byte[] 
     * */  
    private static byte[] intToByteArray(int s) {  
        byte[] targets = new byte[2];  
        for (int i = 0; i < 4; i++) {  
            int offset = (targets.length - 1 - i) * 8;  
            targets[i] = (byte) ((s >>> offset) & 0xff);  
        }  
        return targets;  
    }  
  
    /** 
     * long to byte[] 
     *  
     * @param s 
     *            long 
     * @return byte[] 
     * */  
    private static byte[] longToByteArray(long s) {  
        byte[] targets = new byte[2];  
        for (int i = 0; i < 8; i++) {  
            int offset = (targets.length - 1 - i) * 8;  
            targets[i] = (byte) ((s >>> offset) & 0xff);  
        }  
        return targets;  
    }  
  
    /**32位int转byte[]*/  
    private static byte[] int2byte(int res) {  
        byte[] targets = new byte[4];  
        targets[0] = (byte) (res & 0xff);// 最低位  
        targets[1] = (byte) ((res >> 8) & 0xff);// 次低位  
        targets[2] = (byte) ((res >> 16) & 0xff);// 次高位  
        targets[3] = (byte) (res >>> 24);// 最高位,无符号右移。  
        return targets;  
    }  
  
    /** 
     * 将长度为2的byte数组转换为16位int 
     *  
     * @param res 
     *            byte[] 
     * @return int 
     * */  
    private static int byte2int(byte[] res) {  
        // res = InversionByte(res);  
        // 一个byte数据左移24位变成0x??000000，再右移8位变成0x00??0000  
        int targets = (res[0] & 0xff) | ((res[1] << 8) & 0xff00); // | 表示安位或  
        return targets;  
    }  	

}
