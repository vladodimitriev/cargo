package mk.dimitriev.cargo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Auction {

	@Id
	@GeneratedValue
	private Long id;
	
	private String auctionName;
	
	private String description;
	
	private String auctionNumber;
	
	private Float price;
	
	private boolean isFinished;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuctionName() {
		return auctionName;
	}

	public void setAuctionName(String auctionName) {
		this.auctionName = auctionName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuctionNumber() {
		return auctionNumber;
	}

	public void setAuctionNumber(String auctionNumber) {
		this.auctionNumber = auctionNumber;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}
		
}
