package mk.dimitriev.cargo.dao.impl;

import org.springframework.stereotype.Repository;

import mk.dimitriev.cargo.dao.LoadDao;
import mk.dimitriev.cargo.model.Load;

@Repository("loadDao")
public class LoadDaoImpl extends AbstractDaoImpl<Load> implements LoadDao {

}
