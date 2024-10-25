package test;

import fit.iuh.dao.PhongBanDao;
import fit.iuh.daoimpl.PhongBanDaoImpl;
import fit.iuh.entityManager.EntityManagerFactoryUtil;

public class TestMain {

	public static void main(String[] args) {
		EntityManagerFactoryUtil emf = new EntityManagerFactoryUtil();
		PhongBanDao pbDao = new PhongBanDaoImpl(emf.getEntityManager());
		System.out.println(pbDao.findPhongBanById(1));
	}

}
