package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vets")
public class Vet {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//private Integer id;
	private Integer dni;
    private String name, address, birthday;
    private Integer license;
    private Double phone;
    
    public Vet(){
    }
    
	public Vet(Integer dni, String name, String address, Integer license, Double phone, String birthday) {
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	//debugging purposes
	public String toString() {
		return "Vet [dni=" + dni + ", name=" + name + ", address=" + address + ", license=" + license + ", phone="
				+ phone + ", birthday=" + birthday + "]";
	}
}
