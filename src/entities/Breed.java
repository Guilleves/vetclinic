package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "breeds")
@IdClass(BreedId.class)
public class Breed {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NaturalId
	@Column(name = "Code",
			nullable = false)
    private Integer code;
	@Column(name = "Description")
    private String description;
	//a breed belongs to a species -- maps the OneToMany in Species
	@ManyToOne
	@JoinColumn(name = "species_id")
	private Species species;
	//a breed can have many pets registered under it 
	@OneToMany(mappedBy = "breed",
			   cascade = CascadeType.ALL)
	private List<Pet> pets = new ArrayList<>();
	
	public Breed(){		}
	
	public Breed(Integer code, String description, Species species) {
		super();
		this.code = code;
		this.description = description;
		this.species = species;
	}
    
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