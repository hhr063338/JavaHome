package example.jdbc;
import java.sql.*;

public class TestScroll {
	public static void main(String args[]) {

		try {
//			new oracle.jdbc.driver.OracleDriver();
			String url = "jdbc:oracle:thin:@192.168.0.1:1521:SXT";
			Connection conn = DriverManager
					.getConnection(url, "scott", "tiger");
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,//����resultset��һ����̬������ָ�����Իع������У���֧�ֽ��ع���
					ResultSet.CONCUR_READ_ONLY	//��ָ���������ʵ�ʱ��ֻ�ܶ�ȡ��������ݲ��ܸı�
					);
			ResultSet rs = stmt
					.executeQuery("select * from emp order by sal");
			rs.next();
			System.out.println(rs.getInt(1));
			rs.last();
			System.out.println(rs.getString(1));
			System.out.println(rs.isLast());
			System.out.println(rs.isAfterLast());//����ڶ���
			System.out.println(rs.getRow());//rs.getRow()��ǰ��¼�ǵڼ�����¼
			rs.previous();//rs�����ǰ��
			System.out.println(rs.getString(1));
			rs.absolute(6);//��ת����������¼����Ե�
			System.out.println(rs.getString(1));
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
