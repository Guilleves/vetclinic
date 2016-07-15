package entities;

import java.io.Serializable;
import java.util.Date;

public class TreatmentPriceId implements Serializable {

	private static final long serialVersionUID = 1L;
	//composite PK from Treatment and TreatmentPrice
	private Date date;
	private Integer id;
	
	//constructors
	public TreatmentPriceId(){    }
	public TreatmentPriceId(Date date, Integer id) {
		super();
		this.date = date;
		this.id = id;
	}
	//getters & setters
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setTreatment(Integer id) {
		this.id = id;
	}
	//override hashcode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	
}
