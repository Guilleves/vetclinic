package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(name = "Date and Time")
    private Date dateTime;
	@Column(name = "Result")
    private String result;
	public enum PaymentMethod{
        SPOT,
        INSTALLMENT,
    }
	@ManyToOne
	@JoinColumn(name = "vet_id")
	private Vet vet;
	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;
	@OneToMany(mappedBy = "appointment",
			   cascade = CascadeType.ALL)
	private List<AppointmentInstallments> installments = new ArrayList<>();
	@ManyToMany(cascade = {CascadeType.PERSIST, 
						   CascadeType.MERGE})
	private List<Treatment> treatments = new ArrayList<>();

	
	
    
    
	
}
