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

@Entity
@Table(name = "treatments")
public class Treatment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "Code",
			nullable = false)
    private Integer code;
	@Column(name = "Description")
    private String description;
	@OneToMany(cascade = CascadeType.ALL,
						 mappedBy = "treatment")
	private List<TreatmentPrice> prices = new ArrayList<>();
	@ManyToMany(mappedBy = "treatments")
	private List<Appointment> appointments = new ArrayList<>();
    
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
}
