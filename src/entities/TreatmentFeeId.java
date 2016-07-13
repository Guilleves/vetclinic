package entities;

import java.io.Serializable;
import java.util.Date;

public class TreatmentFeeId implements Serializable{
	//required by the class
	private static final long serialVersionUID = 1L;
	//composite PK
	private Date date;
	private Treatment treatment;
	
	//constructors
	public TreatmentFeeId(){
		
	}
	
	public TreatmentFeeId(Date date, Treatment treatment) {
		super();
		this.date = date;
		this.treatment = treatment;
	}
	//getters & setters
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Treatment getTreatment() {
		return treatment;
	}
	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}
	//overrude hashcode and equals
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
		TreatmentFeeId other = (TreatmentFeeId) obj;
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
