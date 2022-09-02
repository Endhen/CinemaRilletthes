package dal;

import java.util.List;

public interface DAO<T> {
	
	List<T> findAll();
	T findById(int id);
	DAOHibernateImpl<T> insert(T entity);
	DAOHibernateImpl<T> update(T entity);
	DAOHibernateImpl<T> delete(T entity);
}
