package fit.iuh.dao.impl;

import java.util.List;

import fit.iuh.dao.ThuocDao;
import fit.iuh.entity.Thuoc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ThuocDaoImpl implements ThuocDao {
	private EntityManager entitymanager;

	public ThuocDaoImpl(EntityManager entityManager) {
		this.entitymanager = entityManager;
	}

	@Override
	public List<Thuoc> getAllThuoc() {
		return entitymanager.createNamedQuery("listAllThuoc").getResultList();
	}

	@Override
	public List<Thuoc> getThuocTheoTenLoai(String tenLoai) {
		return entitymanager.createNamedQuery("getThuocTheoTheLoai",Thuoc.class).setParameter("tenLoai","%"+ tenLoai+"%").getResultList();
	}

	@Override
	public boolean themThuoc(Thuoc thuoc) {
		EntityTransaction tran = null;
		try {
			 tran = entitymanager.getTransaction();
			 tran.begin();
			 entitymanager.persist(thuoc);
			 tran.commit();
			 return true;
		}catch (Exception e) {
			
		}finally {
			if(tran!=null && tran.isActive()) {
				tran.rollback();
			}
		}
		return false;
	}

}
