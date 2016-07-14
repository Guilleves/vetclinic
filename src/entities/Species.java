package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "species")
public class Species {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NaturalId
	@Column(name = "CODE",
			nullable = false)
    private Integer code;
	@Column(name = "DESCRIPTION",
			nullable = false)
    private String description;
	@OneToMany(mappedBy = "species", //a species includes multiple breeds
			   cascade = CascadeType.ALL, 
			   orphanRemoval = true)
	private List<Breed> breeds = new ArrayList<>();
	//constructors
	public Species(){	}
	public Species(Integer code, String description, List<Breed> breeds) {
		super();
		this.code = code;
		this.description = description;
		this.breeds = breeds;
	}
    //getters & setters
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
	public List<Breed> getBreeds() {
		return breeds;
	}
	public void setBreeds(List<Breed> breeds) {
		this.breeds = breeds;
	}
	public Integer getId() {
		return id;
	}
}
