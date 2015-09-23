package mk.dimitriev.cargo.dao;

import java.util.List;

public interface AbstractDao<E> {

	public E getById(Long id);

	public void update(E entity);

	public List<E> list();

	public void persist(E entity);

	public void delete(E entity);

	public void deleteById(Long id);
	
}
