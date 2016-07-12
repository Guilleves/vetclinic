package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "pets")
public class Pet {

	public enum Sex{
	        F,
	        M,
	    }
	 	@Id
	 	@GeneratedValue(strategy = GenerationType.AUTO)
	 	private Integer id;
	 	@NaturalId
	 	@Column(name = "med_record",
	 			unique = true)
	    private Integer medRecord;
	    private String name;
	    private Sex sex;
	    private Date birthday;
	    @ManyToOne
	    private Owner owner;
	    
	    public Pet(){
	    	
	    }
	    
	    public Pet(Integer medRecord, String name, Sex sex, Date birthday, Owner owner) {
			super();
			this.medRecord = medRecord;
			this.name = name;
			this.sex = sex;
			this.birthday = birthday;
			this.owner = owner;
		}
	    
		public Integer getMedRecord() {
			return medRecord;
		}
		public void setMedRecord(Integer medRecord) {
			this.medRecord = medRecord;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Sex getSex() {
			return sex;
		}
		public void setSex(Sex sex) {
			this.sex = sex;
		}
		public Date getBirthday() {
			return birthday;
		}
		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}
		public Owner getOwner() {
			return owner;
		}
		public void setOwner(Owner owner) {
			this.owner = owner;
		}
		public Integer getId() {
			return id;
		}
}
