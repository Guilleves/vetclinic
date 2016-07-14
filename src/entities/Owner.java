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
@Table(name = "owners")
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NaturalId
	@Column(name = "DNI",
			unique = true,
			nullable = false)
	private Integer dni;
	@Column(name = "NAME",
			nullable = false)
    private String name;
	@Column(name = "ADDRESS",
			nullable = false)
    private String address;
	@Column(name = "EMAIL")
    private String email;
	@Column(name = "PHONE")
    private Double phone;
    @OneToMany(mappedBy = "owner", //mappedBy points to the attribute name in the ManyToOne side (private Owner owner)
			   cascade = CascadeType.ALL, 
			   orphanRemoval = true)
    private List<Pet> pets = new ArrayList<>();
    //constructors
	public Owner(){ 	}
    public Owner(Integer dni, String name, String address, String email, Double phone, ArrayList<Pet> pets) {
		super();
		this.dni = dni;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.pets = pets;
	}
    //getters & setters
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getPhone() {
		return phone;
	}
	public void setPhone(Double phone) {
		this.phone = phone;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public List<Pet> getPets() {
		return pets;
	}
	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}
	public Integer getId() {
		return id;
	}
	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
}
