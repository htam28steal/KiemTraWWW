package fit.iuh.daoimpl;

import java.util.List;

import fit.iuh.dao.NhaCungCapDao;
import fit.iuh.entity.NhaCungCap;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class NhaCungCapImpl implements NhaCungCapDao{
	private EntityManager entityManager;
	public NhaCungCapImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	public List<NhaCungCap> dsNhaCungCap() {
		return entityManager.createNamedQuery("listNhaCC", NhaCungCap.class).getResultList();
	}
	@Override
	public NhaCungCap findNhaCungCapById(int id) {
		return entityManager.find(NhaCungCap.class, id);
	}

}
