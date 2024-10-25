package fit.iuh.entityManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtil {
	private EntityManagerFactory emf;
	private EntityManager entityManager;

	public EntityManagerFactoryUtil() {
		emf = Persistence.createEntityManagerFactory("Thi");
		entityManager = emf.createEntityManager();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void close() {
		emf.close();
		entityManager.close();
	}

}
