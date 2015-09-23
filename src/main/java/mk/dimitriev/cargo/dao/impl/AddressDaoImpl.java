package mk.dimitriev.cargo.dao.impl;

import org.springframework.stereotype.Repository;

import mk.dimitriev.cargo.dao.AddressDao;
import mk.dimitriev.cargo.model.Address;

@Repository("addressDao")
public class AddressDaoImpl extends AbstractDaoImpl<Address> implements AddressDao {

}
