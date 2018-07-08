package com.intellizest.security.data.user;

import java.io.Serializable;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.intellizest.security.data.IntelliDao;

@Repository
public class UserDaoImpl extends IntelliDao implements UserDao{

	@Override
	public void save(User user) {
		Serializable save = getSession().save(user);
		System.out.println("User Saved in DB "+save.toString());
	}

	@Override
	public List<User> list() {
		@SuppressWarnings("unchecked")
		TypedQuery<User> query = getSession().createQuery("from User");
		return query.getResultList();
	}

	@Override
	public User findByUsername(String username) {
		
		String jpql = "select user from User user where user.username = :username";
		TypedQuery<User> query = getSession().createQuery(jpql, User.class);
	    query.setParameter("username", username);
	    try {
	        return query.getSingleResult();
	    } catch (NoResultException e) {
	        return null;
	    }
	}

}
