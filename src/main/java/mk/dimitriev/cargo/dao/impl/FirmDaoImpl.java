package mk.dimitriev.cargo.dao.impl;

import org.springframework.stereotype.Repository;

import mk.dimitriev.cargo.dao.FirmDao;
import mk.dimitriev.cargo.model.Firm;

@Repository("firmDao")
public class FirmDaoImpl extends AbstractDaoImpl<Firm> implements FirmDao {

}
