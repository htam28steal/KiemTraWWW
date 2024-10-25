package fit.iuh.daoimpl;

import java.util.List;

import fit.iuh.dao.NhanVienDao;
import fit.iuh.entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class NhanVienDaoImpl implements NhanVienDao {
	private EntityManager entityManager;

	public NhanVienDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<NhanVien> getAllNhanVien() {
		return entityManager.createNamedQuery("getAllNhanVien", NhanVien.class).getResultList();
	}

	@Override
	public boolean addNhanVien(NhanVien nv) {
		EntityTransaction trans = null;
		trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.persist(nv);
			trans.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (trans != null && trans.isActive()) {
				trans.rollback();
			}
		}
		return false;
	}

	@Override
	public boolean removeNhanVien(int id) {
		EntityTransaction trans = null;
		try {
			trans = entityManager.getTransaction();
			trans.begin();
			NhanVien nv = entityManager.find(NhanVien.class, id);
			entityManager.remove(nv);
			trans.commit();
			return true;
		} catch (Exception e) {
		} finally {
			if (trans != null && trans.isActive()) {
				trans.rollback();
			}
		}
		return false;
	}

	@Override
	public boolean updateNhanVien(NhanVien nv) {
		EntityTransaction trans = null;
		try {
			trans = entityManager.getTransaction();
			trans.begin();
			entityManager.merge(nv);
			trans.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (trans != null && trans.isActive()) {
				trans.rollback();
			}
		}
		return false;
	}

	@Override
	public NhanVien findNhanVienById(int id) {
		return entityManager.find(NhanVien.class, id);
	}

}
