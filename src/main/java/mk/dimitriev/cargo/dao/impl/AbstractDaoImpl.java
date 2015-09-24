package mk.dimitriev.cargo.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import mk.dimitriev.cargo.dao.AbstractDao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDaoImpl<E> implements AbstractDao<E>{

	private final Class<E> persistentClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDaoImpl(){
		this.persistentClass =(Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public E getById(Long id) {
		return (E) getSession().get(persistentClass, id);
	}
	
	@Override
	public void persist(E entity) {
		getSession().persist(entity);
	}

	@Override
	public void delete(E entity) {
		getSession().delete(entity);
	}
	
	@Override
	public void update(E entity) {
		getSession().update(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> list() {
		Query query = getSession().createQuery("from " + persistentClass.getName());
		return query.list();
	}

	protected Criteria createEntityCriteria(){
		return getSession().createCriteria(persistentClass);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteById(Long id) {
		E entity = (E) getSession().get(persistentClass, id);
		getSession().update(entity);
	}
}
