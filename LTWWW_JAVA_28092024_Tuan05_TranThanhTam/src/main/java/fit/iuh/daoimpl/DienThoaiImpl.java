package fit.iuh.daoimpl;

import java.util.List;

import fit.iuh.dao.DienThoaiDao;
import fit.iuh.entity.DienThoai;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DienThoaiImpl implements DienThoaiDao{
	private EntityManager entityManager;
	
	public DienThoaiImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	public List<DienThoai> dsDienThoai() {
		List<DienThoai> dsDT =entityManager.createNamedQuery("listDienThoai", DienThoai.class).getResultList();
		return dsDT;
	}
	@Override
	public boolean addPhone(DienThoai dienThoai) {
		EntityTransaction trans = null;
		try {
			trans = entityManager.getTransaction();
			trans.begin();
			entityManager.persist(dienThoai);
			trans.commit();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(trans != null && trans.isActive()){
				trans.rollback();
			}
		}
		return false;
	}
	@Override
	public boolean updateSp() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean removeSp(int id) {
		EntityTransaction trans = null;
		try {
			trans = entityManager.getTransaction();
			trans.begin();
			DienThoai sp = entityManager.find(DienThoai.class, id);
			entityManager.remove(sp);
			trans.commit();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(trans != null && trans.isActive()) {
				trans.rollback();
			}
		}
		return false;
	}	
}
