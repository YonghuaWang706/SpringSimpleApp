package com.example.spinrgrest_yonghua.dao;

import com.example.spinrgrest_yonghua.domain.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

@Repository
public class UserDao extends AbstractDao<User>{

	public UserDao() {
		super.setClazz(User.class);
	}

	@Override
	public List<User> getAll() {
		Session session = getCurrentSession();
		return  session.createQuery("from User").list();
	}

	@Override
	public int deleteGivenID(Long id) {
		Session session = getCurrentSession();
		return session.createQuery("delete from User where id = :id").
				setParameter("id", id)
		  		.executeUpdate();
	}

	@Transactional
	public int updateStatus(boolean newStatus, Long id){
		Session session = getCurrentSession();
		return session.createQuery("update User set status = :status where id = :id")
				.setParameter("id", id)
				.setParameter("status", newStatus)
				.executeUpdate();
	}

//	@Transactional
//	@Override
//	public User findById(Long id){
//		Session session = getCurrentSession();
//		List<User> list = session.createQuery("from User u  where u.id = :id").setParameter("id", id).getResultList();
//		if(list.size() < 1){
//			return null;
//		}
//		return list.get(0);
//	}
}
