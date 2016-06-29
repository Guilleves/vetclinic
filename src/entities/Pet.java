package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pets")
public class Pet {
	 public enum Sex{
	        F,
	        M,
	    }
	 	@Id
	 	@Column(name = "med_record")
	    private Integer medRecord;
	    private String name;
	    private Sex sex;
	    private Date birthday;
	    
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
}
