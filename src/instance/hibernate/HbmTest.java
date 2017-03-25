package instance.hibernate;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import com.mysql.jdbc.*;

public class HbmTest {

	@Test
	public void test() {
		Student s=new Student();
		s.setId(1);
		s.setName("仁者");
		s.setAge(18);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();//事务开始
		session.save(s);
		session.getTransaction().commit();
		
	}
	
	//@Test
	public void teacherTest(){
		Teacher t=new Teacher();
		t.setId(1);
		t.setName("老师");
		t.setProject("数学");
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory(); 
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();//事务开始
		session.save(t);
		session.getTransaction().commit();
	}

}
