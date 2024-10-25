package fit.iuh.entityManagerFactoryUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtil {

	private EntityManagerFactory emf;
	private EntityManager entityManager;

	public EntityManagerFactoryUtil() {
		emf = Persistence.createEntityManagerFactory("Tuan05");
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
