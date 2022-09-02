package dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOHibernateImpl<T>  implements DAO<T> {

	private EntityManagerFactory emf;
	public Class<T> entityType;
	public String entityTypeName;
	
	
	public DAOHibernateImpl(Class<T> entityType) {
		this.entityType = entityType;
		this.entityTypeName = entityType.getSimpleName();
		this.emf = Persistence.createEntityManagerFactory("cinema_rilletthes");
	}
	
	@Override
	public List<T> findAll() {
		EntityManager em = emf.createEntityManager();
		
		List<T> results = em
				.createNamedQuery("findAll" + entityTypeName, entityType)
				.getResultList();
		
		em.close();
		
		return results;
	}

	@Override
	public T findById(int id) {
		EntityManager em = emf.createEntityManager();
		
		T result = em
				.createNamedQuery("find" + entityTypeName + "ById", entityType)
				.setParameter("id", id)
				.getSingleResult();
		
		em.close();
		
		return result;
	}

	@Override
	public DAOHibernateImpl<T> insert(T entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(entity);
		
		em.getTransaction().commit();
		em.close();
		return this;
	}

	@Override
	public DAOHibernateImpl<T> update(T entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(entity);
		
		em.getTransaction().commit();
		em.close();
		
		return this;
	}

	@Override
	public DAOHibernateImpl<T> delete(T entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.remove(em.merge(entity));
		
		em.getTransaction().commit();
		em.close();
		
		return this;
	}
}
