package shop.utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import shop.model.User;

public class UserDAO {
	public void insert(User user) {
		EntityManager em= JpaUtils.getEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			
			em.persist(user);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		}finally {
			em.close();
		}
	}
	public void update(User user) {
		EntityManager em= JpaUtils.getEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			
			em.merge(user);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		}finally {
			em.close();
		}
	}
	public void delete(String userName) throws Exception {
		EntityManager em= JpaUtils.getEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			
			User user = em.find(User.class, userName);
			if(user != null) {
				em.remove(user);
			}else {
				throw new Exception("User can not found");
			}
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		}finally {
			em.close();
		}
	}
	public User findByID(String userName) {
		EntityManager em= JpaUtils.getEntityManager();
			User user = em.find(User.class, userName);
			return user;
	}
	public List<User> findAll() {
		EntityManager em= JpaUtils.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return  query.getResultList();
	}
}
