package mk.dimitriev.cargo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Load {

	@Id
	@GeneratedValue
	private Long id;
	
	private Float weight;
	
	private Integer paletteCount;
	
	private String loadName;
	
	private String description;
	
	private String loadType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Integer getPaletteCount() {
		return paletteCount;
	}

	public void setPaletteCount(Integer paletteCount) {
		this.paletteCount = paletteCount;
	}

	public String getLoadName() {
		return loadName;
	}

	public void setLoadName(String loadName) {
		this.loadName = loadName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLoadType() {
		return loadType;
	}

	public void setLoadType(String loadType) {
		this.loadType = loadType;
	}
	
}
