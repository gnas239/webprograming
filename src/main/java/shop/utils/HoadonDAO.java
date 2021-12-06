package shop.utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import shop.model.Chitiethoadon;


public class HoadonDAO {
	public void insert(Chitiethoadon chitiethoadon) {
		EntityManager em= JpaUtils.getEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			
			em.persist(chitiethoadon);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		}finally {
			em.close();
		}
	}
	public void update(Chitiethoadon chitiethoadon) {
		EntityManager em= JpaUtils.getEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			
			em.merge(chitiethoadon);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		}finally {
			em.close();
		}
	}
	public void delete(int mahoadon) throws Exception {
		EntityManager em= JpaUtils.getEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			
			Chitiethoadon chitiethoadon = em.find(Chitiethoadon.class, mahoadon);
			if(chitiethoadon != null) {
				em.remove(chitiethoadon);
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
	public Chitiethoadon findByID(int mahoadon) {
		EntityManager em= JpaUtils.getEntityManager();
			Chitiethoadon chitiethoadon = em.find(Chitiethoadon.class, mahoadon);
			return chitiethoadon;
	}
	public List<Chitiethoadon> findAll() {
		EntityManager em= JpaUtils.getEntityManager();
		TypedQuery<Chitiethoadon> query = em.createNamedQuery("Chitiethoadon.findAll", Chitiethoadon.class);
		return  query.getResultList();
	}
}
