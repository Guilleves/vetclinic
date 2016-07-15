package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pets")
public class Pet {
	public static enum Sex{
	        F,
	        M,
	 }
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "PET_ID")
	 private Integer id;
	 @Column(name = "NAME",
			 nullable = false)
	 private String name;
	 @Column(name = "SEX",
			 nullable = false)
	 private Sex sex;
	 @Column(name = "BIRTHDAY")
	 private Date birthday;
	 @ManyToOne //maps the pet to a single owner
	 @JoinColumn(name = "owner_id")
	 private Owner owner;
	 @ManyToMany(mappedBy = "pets")	 //maps the bidirectional ManyToMany to the pets array in Vet
	 private List<Vet> vets = new ArrayList<>();
	 @ManyToOne //also, a pet has a Breed
	 @JoinColumns({@JoinColumn(name = "BREED_ID"),
		 		   @JoinColumn(name = "SPECIES_ID")})
	 private Breed breed;
	 @OneToMany(mappedBy = "pet") //u can have many appointments for the same pet
	 private List<Appointment> appointments = new ArrayList<>();
	 //constructors   
	 public Pet(){   }
	 public Pet(String name, Sex sex){
		 super();
		 this.name = name;
		 this.sex = sex;
	 }
	 public Pet(String name, Sex sex, Date birthday, Owner owner, List<Vet> vets, Breed breed,
				List<Appointment> appointments) {
		super();
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.owner = owner;
		this.vets = vets;
		this.breed = breed;
		this.appointments = appointments;
	}
	//getters & setters    
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public List<Vet> getVets() {
		return vets;
	}
	public void setVets(List<Vet> vets) {
		this.vets = vets;
	}
	public Breed getBreed() {
		return breed;
	}
	public void setBreed(Breed breed) {
		this.breed = breed;
	}
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

}
