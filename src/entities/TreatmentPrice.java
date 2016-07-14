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
	private Date date;
	@Column(name = "PRICE",
			nullable = false)
	private Double price;// price is just an attribute
	@Id
	@ManyToOne //many prices correspond to the same Treatment
	@JoinColumn(name = "treatment_id")
	private Treatment treatment;

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
