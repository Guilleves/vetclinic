package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "vets")
public class Vet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "VET_ID")
	private Integer id;
	@NaturalId
	@Column(name = "LICENSE",
			unique = true,
			nullable = false)
	private Integer license;
	@Column(name = "DNI",
			unique = true,
			nullable = false)
	private Integer dni;
	@Column(name = "NAME",
			nullable = false)
    private String name;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "BIRTHDAY")
	private Date birthday;
    @Column(name = "PHONE")
    private Double phone;
    @ManyToMany(cascade = {CascadeType.PERSIST, //a Vet may have treated many pets
    					   CascadeType.MERGE}) //don't delete the Pet when you delete the Vet
    private List<Pet> pets = new ArrayList<>();
    @OneToMany(mappedBy = "vet") //a Vet may have taken part in many appointments
    private List<Appointment> appointments = new ArrayList<>();
    
    public Vet(){    }
	public Vet(Integer license, Integer dni, String name){
		super();
		this.license = license;
		this.dni = dni;
		this.name = name;
	}
    public Vet(Integer dni, String name, String address, Integer license, Double phone, Date birthday) {
		super();
		this.dni = dni;
		this.name = name;
		this.address = address;
		this.license = license;
		this.phone = phone;
		this.birthday = birthday;
	}
    
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
	public Integer getLicense() {
		return license;
	}
	public void setLicense(Integer license) {
		this.license = license;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	//debugging purposes
	public String toString() {
		return "Vet [dni=" + dni + ", name=" + name + ", address=" + address + ", license=" + license + ", phone="
				+ phone + ", birthday=" + birthday + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	//natural key Vet.dni
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Vet other = (Vet) obj;
		if (dni == null) {
			if (other.dni != null) {
				return false;
			}
		} else if (!dni.equals(other.dni)) {
			return false;
		}
		return true;
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
