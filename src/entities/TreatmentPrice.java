package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prices")
//annotation for a composite PK
@IdClass(TreatmentPriceId.class)
public class TreatmentPrice {
	@Id
	private Date date;
	//price is just an attribute
    private Double price;
    @Id
    @ManyToOne
    @JoinColumn(name = "treatment_id")
    //the date and the Treatment are the identifiers of the instance
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
