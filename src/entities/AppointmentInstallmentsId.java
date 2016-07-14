package entities;

import java.io.Serializable;
import java.util.Date;

public class AppointmentInstallmentsId implements Serializable{
	private static final long serialVersionUID = 1L;
	//composite PK: an Installment can be identified by the expiration date and the appointment 
	private Date expirationDate;
	private Appointment appointment;
	//getters & setters
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	//override hashcode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appointment == null) ? 0 : appointment.hashCode());
		result = prime * result + ((expirationDate == null) ? 0 : expirationDate.hashCode());
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
		AppointmentInstallmentsId other = (AppointmentInstallmentsId) obj;
		if (appointment == null) {
			if (other.appointment != null) {
				return false;
			}
		} else if (!appointment.equals(other.appointment)) {
			return false;
		}
		if (expirationDate == null) {
			if (other.expirationDate != null) {
				return false;
			}
		} else if (!expirationDate.equals(other.expirationDate)) {
			return false;
		}
		return true;
	}
}
