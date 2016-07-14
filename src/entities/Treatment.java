package entities;

import java.util.ArrayList;
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
@Table(name = "treatments")
public class Treatment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NaturalId
	@Column(name = "CODE",
			nullable = false)
    private Integer code;
	@Column(name = "DESCRIPTION")
    private String description;
	@OneToMany(cascade = CascadeType.ALL, //prices history through time
						 mappedBy = "treatment")
	private List<TreatmentPrice> prices = new ArrayList<>();
	@ManyToMany(mappedBy = "treatments") //a treatment can be applied in many appointments
	private List<Appointment> appointments = new ArrayList<>();
	
	public Treatment(){		}
	public Treatment(Integer code, String description) {
		super();
		this.code = code;
		this.description = description;
	}
	public Treatment(Integer code, String description, List<TreatmentPrice> prices, List<Appointment> appointments) {
		super();
		this.code = code;
		this.description = description;
		this.prices = prices;
		this.appointments = appointments;
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
	public List<TreatmentPrice> getPrices() {
		return prices;
	}
	public void setPrices(List<TreatmentPrice> prices) {
		this.prices = prices;
	}
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	public Integer getId() {
		return id;
	}
}
