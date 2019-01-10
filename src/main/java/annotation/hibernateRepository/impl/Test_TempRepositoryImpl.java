package annotation.hibernateRepository.impl;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import annotation.entity.Table_temp;
import annotation.hibernateRepository.Test_TempRepositoryHib;

@Repository
@Transactional("hibernateTX")
public class Test_TempRepositoryImpl implements Test_TempRepositoryHib{
	
	private final SessionFactory sessionFactory;
	
	public Test_TempRepositoryImpl(@Autowired SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Table_temp findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Table_temp.class, id);
	}

}
