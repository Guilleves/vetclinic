package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prices")
// annotation for a composite PK
@IdClass(TreatmentPriceId.class)
public class TreatmentPrice {
	@Id
	@Column(name = "PRICES_ID")
	private Date date;
	@Column(name = "PRICE",
			nullable = false)
	private Double price;// price is just an attribute
	@Id
	@ManyToOne //many prices correspond to the same Treatment
	@JoinColumn(name = "TREATMENT_ID")
	private Treatment treatment;
	public TreatmentPrice(){	}
	public TreatmentPrice(Date date, Double price, Treatment treatment) {
		super();
		this.date = date;
		this.price = price;
		this.treatment = treatment;
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
