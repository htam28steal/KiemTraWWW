package fit.iuh.daoimpl;

import java.util.List;

import fit.iuh.dao.PhongBanDao;
import fit.iuh.entity.PhongBan;
import jakarta.persistence.EntityManager;

public class PhongBanDaoImpl implements PhongBanDao{
	private EntityManager entityManager;
	public PhongBanDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
		
	@Override
	public List<PhongBan> getAllPhongBan() {
		return entityManager.createNamedQuery("getAllPhongBan",PhongBan.class).getResultList();
	}

	@Override
	public PhongBan findPhongBanById(int id) {
		return entityManager.find(PhongBan.class,id);
	}

}
