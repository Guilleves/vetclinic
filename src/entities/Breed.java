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
	@Column(name = "BREED_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NaturalId
	@Column(name = "CODE",
			unique = true,
			nullable = false)
    private Integer code;
	@Column(name = "DESCRIPTION")
    private String description;
	@ManyToOne //a breed belongs to a species -- maps the OneToMany in Species bc it's bidirectional
	@JoinColumn(name = "species_id")
	private Species species;
	@OneToMany(mappedBy = "breed", //a breed can have many pets registered under it 
			   cascade = CascadeType.ALL) //all = propagates all EntityManager ops to the relating entities
	private List<Pet> pets;
	//constructors
	public Breed(){
		this.pets = new ArrayList<Pet>();
	}
	public Breed(Integer code, String description) {
		super();
		this.code = code;
	}
	public Breed(Integer code, String description, Species species, Pet pets) {
		super();
		this.code = code;
		this.description = description;
		this.species = species;
		this.pets = new ArrayList<Pet>();
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
	public Species getSpecies() {
		return species;
	}
	public void setSpecies(Species species) {
		this.species = species;
	}
	public List<Pet> getPets() {
		return pets;
	}
	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
	public Integer getId() {
		return id;
	}
    

}