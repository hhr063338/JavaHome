package example.jdbc;

import java.sql.*;
/*<Title>�����JDBC����
 * <Description>:��ݿ����ӵ�������
 */
public class JDbc {
   public static void main(String[] args){
	   String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf8";
	   String user="root";
	   String password="root";
	   String sql="select * from test.student";
	  
	   Connection conn=null;
	   Statement smt=null;
	   ResultSet rs=null;
	   try{
		   Class.forName("com.mysql.jdbc.Driver");
		   conn=DriverManager.getConnection(url, user, password);
		   smt=conn.createStatement();
		   rs=smt.executeQuery(sql);
		   while(rs.next()){
			   System.out.println("id="+rs.getInt("id")+",name="+ rs.getString("name"));
		   }
	   }catch(Exception e){
		   System.out.println("��ݿ����ӳ�����"+e.getStackTrace());
	   }finally{
		   try{
			   if( conn!=null){
				   conn.close();
				   conn=null;
			   }
			   if( smt!=null){
				   smt.close();
				   smt=null;
			   }
			   if( rs!=null){
				   rs.close();
				   rs=null;
			   }
		   }catch(Exception e){
			   System.out.println("�ر������Դ����"+e.getMessage());
		   }
	   }
	   
   }

}
