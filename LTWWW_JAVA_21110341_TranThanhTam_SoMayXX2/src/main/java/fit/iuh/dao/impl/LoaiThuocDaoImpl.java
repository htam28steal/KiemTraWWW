package fit.iuh.dao.impl;

import java.util.List;

import fit.iuh.dao.LoaiThuocDao;
import fit.iuh.entity.LoaiThuoc;
import jakarta.persistence.EntityManager;
public class LoaiThuocDaoImpl implements LoaiThuocDao{
	private EntityManager entityManager;
	public LoaiThuocDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	public List<LoaiThuoc> getAllLoaiThuoc() {
		return entityManager.createNamedQuery("getAllLoaiThuoc",LoaiThuoc.class).getResultList();
	}
	@Override
	public LoaiThuoc findLoaiThoaiById(int id) {
		return entityManager.find(LoaiThuoc.class, id);
	}
}
