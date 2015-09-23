package mk.dimitriev.cargo.dao.impl;

import org.springframework.stereotype.Repository;

import mk.dimitriev.cargo.dao.ContactInfoDao;
import mk.dimitriev.cargo.model.ContactInfo;

@Repository("contactInfoDao")
public class ContactInfoDaoImpl extends AbstractDaoImpl<ContactInfo> implements ContactInfoDao {

}
