package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Appointment_installments")
@IdClass(AppointmentInstallmentsId.class)
public class AppointmentInstallments {
	
	@Id
	@Column(name = "DATE")
	private Date date;
	@Column(name = "INSTALLMENT AMOUNT")
	private double amount;
	@ManyToOne
	private Appointment appointment;
}
