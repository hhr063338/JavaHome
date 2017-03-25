package instance.practical;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJNDI {
	/***

	public static void main(String[] args) {
	    ResultSet rSet=null;
	    PreparedStatement ps=null;
	    Connection conn=null;
	    try {
	      Context ctx=new InitialContext();
	  
	  DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/jndi");
	    //Class.forName("oracle.jdbc.driver.OracleDriver");
	   //Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","scott","lxp123");
	    conn=ds.getConnection();
	   sqlString="select * from emp";
	   ps=conn.prepareStatement(sqlString);
	   rSet=ps.executeQuery();
	   while(rSet.next()){
	    System.out.println(rSet.getString(2));
	   }
	  } catch (Exception e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }finally{
	   ps.close();
	   rSet.close();
	   conn.close();
	  }
	}
	*****/
}
