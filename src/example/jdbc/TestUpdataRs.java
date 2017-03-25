package example.jdbc;
import java.sql.*;
public class TestUpdataRs {
    public static void main(String args[]){
	
	try{
//	    new oracle.jdbc.driver.OracleDriver();
	    String url="jdbc:oracle:thin:@192.168.0.1:1521:SXT";
	    Connection conn=DriverManager.getConnection(url,"scott","tiger");
	    Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	    
	    ResultSet rs=stmt.executeQuery("select * from emp2");
	    
	    rs.next();
	    //����һ����ݣ�����ݱ��浽�����н����޸ģ��ڸ��µ���ݿ���
	    rs.updateString("ename","AAAA");//���ֶ�ename,�ĳ�AAAA
	    rs.updateRow();//������ı仯���µ���ݿ���

	    //��������
	    rs.moveToInsertRow();//ר����һ�н�InsertRow����������Ϊ���һ�е���һ�У������������������
	    rs.updateInt(1, 9999);//����һ���ֶ����9999
	    rs.updateString("ename","AAAA");//ename�ֶ����AAAA�ֶ�
	    rs.updateInt("mgr", 7839);
	    rs.updateDouble("sal", 99.99);
	    rs.insertRow();
	    //������ƶ����½�����
	    rs.moveToCurrentRow();

	    //ɾ����
	    rs.absolute(5);
	    rs.deleteRow();

	    //ȡ�����
	    //rs.cancelRowUpdates();

	  }catch(SQLException e){
	    e.printStackTrace();
	  }
    }
}
