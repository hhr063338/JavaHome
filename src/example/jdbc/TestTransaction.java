package example.jdbc;
import java.sql.*;
public class TestTransaction {


	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:SXT", "scott", "tiger");
			/*
			 * �κ�DML��䣬�����Զ��ύ����ԭ�����������ݿ�����Connection�У���һ������autoCommit����Ϊ���Ĭ��ֵ��true
			 * ���������е���Ҫ��SQL������һ������transaction�У���Ӧ�ð�autoCommit������ֵ��Ϊfalse����Connection.setAutoCommit(false))
			 * ��Ϊȡ���Զ��ύ����ôһ��������Ҫ�ύ����������������е�sql��䣬��Ȼ��Ҫһ��������ύ����Connetion.commit())
			 * �ڱ�̹���У��ı�����ã���Ҫһ������ٸĻ�������Connetion.setAutoCommit(true))
			 */
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.addBatch("insert into dept2 values (51, '500', 'haha')");
			stmt.addBatch("insert into dept2 values (52, '500', 'haha')");
			stmt.addBatch("insert into dept2 values (53, '500', 'haha')");
			stmt.executeBatch();
			conn.commit();
			conn.setAutoCommit(true);
		} catch (ClassNotFoundException e) {//���������Ҳ������쳣
			e.printStackTrace();
		} catch(SQLException e) {//��ִ���й�sql�������쳣
			
			e.printStackTrace();
			
			try {
				if(conn != null)
				{
					conn.rollback();//�������Ѿ�����һ��sql��䣬��ͨ��������Իظ���δ���룬��null��״̬
					conn.setAutoCommit(true);//��Ϊ�����Զ��ύ����Ϊfalse����û�Ļ�����������Ӹ����
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				if(stmt != null)
					stmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}

}
