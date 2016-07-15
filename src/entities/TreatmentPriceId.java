package entities;

import java.io.Serializable;
import java.util.Date;

public class TreatmentPriceId implements Serializable {

	private static final long serialVersionUID = 1L;
	//composite PK from Treatment and TreatmentPrice
	private Date date;
	private Treatment treatment;
	//constructors
	public TreatmentPriceId(){    }
	public TreatmentPriceId(Date date, Treatment treatmentPrice) {
		super();
		this.date = date;
		this.treatment = treatmentPrice;
	}
	//getters & setters
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Treatment getTreatmentPrice() {
		return treatment;
	}

	public void setTreatment(Treatment treatmentPrice) {
		this.treatment = treatmentPrice;
	}
	//override hashcode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((treatment == null) ? 0 : treatment.hashCode());
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
		TreatmentPriceId other = (TreatmentPriceId) obj;
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
		if (treatment == null) {
			if (other.treatment != null) {
				return false;
			}
		} else if (!treatment.equals(other.treatment)) {
			return false;
		}
		return true;
	}
}
