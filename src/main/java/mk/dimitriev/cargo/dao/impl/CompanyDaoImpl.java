package mk.dimitriev.cargo.dao.impl;

import org.springframework.stereotype.Repository;

import mk.dimitriev.cargo.dao.CompanyDao;
import mk.dimitriev.cargo.model.Company;

@Repository("companyDao")
public class CompanyDaoImpl extends AbstractDaoImpl<Company> implements CompanyDao {

}
