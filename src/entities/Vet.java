package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vets")
public class Vet {
	
	@Id
	private Integer dni;
    private String name, address;
    private Integer license, phone;
    private Date birthday;
    
    public Vet(){
    }
    
	public Vet(Integer dni, String name, String address, Integer license, Integer phone, Date birthday) {
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
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
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
}
