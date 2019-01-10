package annotation.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import annotation.entity.Table_temp;

public class TestRepoRealis implements Test_tableNewFunction {

private final SessionFactory sessionFactory;
	
	public TestRepoRealis(@Autowired SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Table_temp findByPhone(int phone) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Table_temp.class, phone);
	}

}
