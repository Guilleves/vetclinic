package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "appointments")
@IdClass(AppointmentId.class)
public class Appointment {
	@Id //date time is PK because a Vet may have treated a Pet twice
	@Column(name = "DATE_TIME",
			nullable = false)
    private Date dateTime;
	@Column(name = "RESULT")
    private String result;
	public enum PaymentMethod{
        SPOT,
        INSTALLMENT,
    }
	@ManyToOne //a vet may have participated in several appointments
	@JoinColumn(name = "vet_id")
	private Vet vet;
	@ManyToOne //a pet may have been to several appointments
	@JoinColumn(name = "pet_id")
	private Pet pet;
	@OneToMany(mappedBy = "appointment",//you can pay in installments 
			   cascade = CascadeType.ALL,
			   fetch = FetchType.LAZY) //Lazy = fetch when needed
	private List<AppointmentInstallments> installments = new ArrayList<>();
	@ManyToMany(cascade = {CascadeType.PERSIST, 
						   CascadeType.MERGE},
				fetch = FetchType.LAZY) //an appointment may indicate several treatments
	private List<Treatment> treatments = new ArrayList<>();
	public Appointment(){	}
	public Appointment(Date dateTime, Vet vet, Pet pet){
		super();
		this.dateTime = dateTime;
		this.vet = vet;
		this.pet = pet;
	}
	public Appointment(Date dateTime, String result, Vet vet, Pet pet, List<AppointmentInstallments> installments,
			List<Treatment> treatments) {
		super();
		this.dateTime = dateTime;
		this.result = result;
		this.vet = vet;
		this.pet = pet;
		this.installments = installments;
		this.treatments = treatments;
	}	
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
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
	public List<AppointmentInstallments> getInstallments() {
		return installments;
	}
	public void setInstallments(List<AppointmentInstallments> installments) {
		this.installments = installments;
	}
	public List<Treatment> getTreatments() {
		return treatments;
	}
	public void setTreatments(List<Treatment> treatments) {
		this.treatments = treatments;
	}

	
	
    
    
	
}
