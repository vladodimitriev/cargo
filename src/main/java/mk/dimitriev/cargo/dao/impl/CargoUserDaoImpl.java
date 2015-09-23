package mk.dimitriev.cargo.dao.impl;

import mk.dimitriev.cargo.dao.CargoUserDao;
import mk.dimitriev.cargo.model.CargoUser;

import org.springframework.stereotype.Repository;

@Repository("cargoUserDao")
public class CargoUserDaoImpl extends AbstractDaoImpl<CargoUser> implements CargoUserDao {

}
