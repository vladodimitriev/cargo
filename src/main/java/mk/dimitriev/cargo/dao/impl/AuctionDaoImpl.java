package mk.dimitriev.cargo.dao.impl;

import org.springframework.stereotype.Repository;

import mk.dimitriev.cargo.dao.AuctionDao;
import mk.dimitriev.cargo.model.Auction;

@Repository("auctionDao")
public class AuctionDaoImpl extends AbstractDaoImpl<Auction> implements AuctionDao {

}
