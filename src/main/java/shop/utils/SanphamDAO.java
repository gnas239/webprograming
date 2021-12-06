package shop.utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import shop.model.Sanpham;

public class SanphamDAO {
	public void insert(Sanpham sanpham) {
		EntityManager em = JpaUtils.getEntityManager();

		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();

			em.persist(sanpham);

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	public void update(Sanpham sanpham) {
		EntityManager em = JpaUtils.getEntityManager();

		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();

			em.merge(sanpham);

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	public void delete(int maSP) throws Exception {
		EntityManager em = JpaUtils.getEntityManager();

		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();

			Sanpham sanpham = em.find(Sanpham.class, maSP);
			if (sanpham != null) {
				em.remove(sanpham);
			} else {
				throw new Exception("User can not found");
			}

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	public Sanpham findByID(int maSP) {
		EntityManager em = JpaUtils.getEntityManager();
		Sanpham sanpham = em.find(Sanpham.class, maSP);
		return sanpham;
	}

	public List<Sanpham> findAll() {
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<Sanpham> query = em.createNamedQuery("Sanpham.findAll", Sanpham.class);
		return query.getResultList();
	}
}
