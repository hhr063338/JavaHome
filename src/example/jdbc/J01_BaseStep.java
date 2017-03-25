package example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import com.mysql.jdbc.Driver;

/**
 * JDBC操作步骤：
 * 1.加载数据库驱动程序
 * 2.连接数据库
 * 3.使用语句进行数据库操作
 * 4.关闭数据库连接：数据库操作完毕之后需要关闭连接以释放资源
 *
 */
/*	数据库打开之后必须关闭
 *  在程序操作中，数据库的资源是非常有限的，这就要求开发者在操作完成数据库之后必须将其关闭
 *  如果没有这样，在程序运行中就会产生无法连接到数据库的异常
 */
public class J01_BaseStep {
	public static String DRIVER="oracle.jdbc.driver.OracleDriver";//驱动类名
	public static String URL="jdbc:oracle//127.0.0.1:1521/orcl";//数据库连接地址
	public static String USER="scott";
	public static String PASSWORD="tiger";
	
	public static void main(String[] args) throws Exception {
		Connection conn=null;
		//加载驱动程序
		try{
			Class.forName(DRIVER);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//连接Oracle数据库时，需要写上相应的用户名/密码
		try {
				conn=DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(conn);
		try{
			conn.close();
		}catch (SQLException E) {
			E.printStackTrace();
		}
		
	}


	//加载驱动程序
	public void checkDriver() throws Exception{
		Class.forName(J01_BaseStep.DRIVER);
	}
	//使用DriverManage类连接数据库 jdbc:oracle://ip地址:端口号/数据库名称
	//getConnection(url,user,password);getConnection(url);
	public void checkGetConnection(){
		
//		Connection=DriverManager.getConnection(, user, password)
	}

}
