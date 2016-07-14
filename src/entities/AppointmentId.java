package entities;

import java.io.Serializable;
import java.util.Date;

public class AppointmentId implements Serializable{
	private static final long serialVersionUID = 1L;
	//composite PK: a Vet, a Pet and the DateTime the appointment took place
	private Date dateTime;
	private Vet vet;
	private Pet pet;
	//constructors
	public AppointmentId(){ 	}
	public AppointmentId(Date dateTime, Vet vet, Pet pet) {
		super();
		this.dateTime = dateTime;
		this.vet = vet;
		this.pet = pet;
	}
	//getters&setters
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public Vet getVet() {
		return vet;
	}
	public void setVet(Vet vet) {
		this.vet = vet;
	}
	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	//Override hashcode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + ((pet == null) ? 0 : pet.hashCode());
		result = prime * result + ((vet == null) ? 0 : vet.hashCode());
		return result;
	}
	@Override
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
		AppointmentId other = (AppointmentId) obj;
		if (dateTime == null) {
			if (other.dateTime != null) {
				return false;
			}
		} else if (!dateTime.equals(other.dateTime)) {
			return false;
		}
		if (pet == null) {
			if (other.pet != null) {
				return false;
			}
		} else if (!pet.equals(other.pet)) {
			return false;
		}
		if (vet == null) {
			if (other.vet != null) {
				return false;
			}
		} else if (!vet.equals(other.vet)) {
			return false;
		}
		return true;
	}
	
	
	

}
