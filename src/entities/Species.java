package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "species")
public class Species {
	
	@Id
	@Column(name = "Code",
			nullable = false)
    private Integer code;
	@Column(name = "Description",
			nullable = false)
    private String description;
	//a species englobes multiple breeds
	@OneToMany(mappedBy = "species",
			   cascade = CascadeType.ALL, 
			   orphanRemoval = true)
	private List<Breed> breeds = new ArrayList<>();
    
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
