package shop.utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import shop.model.Hoadonsanpham;


public class ChitietDAO {
	public void insert(Hoadonsanpham hoadonsanpham) {
		EntityManager em= JpaUtils.getEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			
			em.persist(hoadonsanpham);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		}finally {
			em.close();
		}
	}
	public void update(Hoadonsanpham hoadonsanpham) {
		EntityManager em= JpaUtils.getEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			
			em.merge(hoadonsanpham);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		}finally {
			em.close();
		}
	}
	public void delete(int id) throws Exception {
		EntityManager em= JpaUtils.getEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			
			Hoadonsanpham hoadonsanpham = em.find(Hoadonsanpham.class, id);
			if(hoadonsanpham != null) {
				em.remove(hoadonsanpham);
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
	public Hoadonsanpham findByID(int id) {
		EntityManager em= JpaUtils.getEntityManager();
			Hoadonsanpham hoadonsanpham = em.find(Hoadonsanpham.class, id);
			return hoadonsanpham;
	}
	public List<Hoadonsanpham> findAll() {
		EntityManager em= JpaUtils.getEntityManager();
		TypedQuery<Hoadonsanpham> query = em.createNamedQuery("Hoadonsanpham.findAll", Hoadonsanpham.class);
			return  query.getResultList();
	}
}
