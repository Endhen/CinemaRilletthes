package bll;

import java.util.List;

import dal.DAOHibernateImpl;

public class BLL<T> {
	protected DAOHibernateImpl<T> dao;
	
	public BLL(Class<T> entityType) {
		this.dao = new DAOHibernateImpl<> (entityType);
	} 
	
	public List<T> findAll() {
		return dao.findAll();
	}
	
	public T findById(int id) {
		return dao.findById(id);
	}
	
	public BLL<T> insert(T entity) {
		dao.insert(entity);
		return this;
	}
	
	public BLL<T> update(T entity) {
		dao.update(entity);
		return this;
	}
	
	public BLL<T> delete(T entity) {
		dao.delete(entity);
		return this;
	}
}
