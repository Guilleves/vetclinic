package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "appointment_installments")
@IdClass(AppointmentInstallmentsId.class)
public class AppointmentInstallments {
	@Id
	@Column(name = "INSTALLMENT_ID")
	private Date expirationDate;
	@Column(name = "PAYMENT_DATE") //when the installment is actually paid
	private Date paymentDate;
	@Column(name = "AMOUNT")
	private double amount;
	@ManyToOne//an appointment can be paid in several installments
	@JoinColumns({@JoinColumn(name = "APPOINTMENT_ID"),
				  @JoinColumn(name = "VET_ID"),
				  @JoinColumn(name = "PET_ID")})
	private Appointment appointment;
	//constructors
	public AppointmentInstallments(){ 	}
	public AppointmentInstallments(Date expirationDate, Date paymentDate, double amount, Appointment appointment) {
		super();
		this.expirationDate = expirationDate;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.appointment = appointment;
	}
	//getters & setters
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	
}
