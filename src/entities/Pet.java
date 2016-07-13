package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	    private String name;
	    private Sex sex;
	    private Date birthday;
	    //maps the pet to a single owner
	    @ManyToOne
	    private Owner owner;
	    //maps the bidirectional ManyToMany to the pets array in Vet
	    @ManyToMany(mappedBy = "pets")
	    private List<Vet> vets = new ArrayList<>();
	    
	    public Pet(){
	    	
	    }
	    
	    public Pet(String name, Sex sex, Date birthday, Owner owner) {
			super();
			this.name = name;
			this.sex = sex;
			this.birthday = birthday;
			this.owner = owner;
		}
	    
		public Integer getId() {
			return id;
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

		public List<Vet> getVets() {
			return vets;
		}

		public void setVets(List<Vet> vets) {
			this.vets = vets;
		}

}
