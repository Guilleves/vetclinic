package entities;

import java.io.Serializable;

public class BreedId implements Serializable {
	private static final long serialVersionUID = 1L;
	//composite PK: a Breed identifies by its ID and the Species it belongs to
	private Species species;
	private Integer id;
	//constructor
	public BreedId(Species species, Integer id) {
		super();
		this.species = species;
		this.id = id;
	}
	//getters and setters
	public Species getSpecies() {
		return species;
	}
	public void setSpecies(Species species) {
		this.species = species;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	//override hashcode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((species == null) ? 0 : species.hashCode());
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
		BreedId other = (BreedId) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (species == null) {
			if (other.species != null) {
				return false;
			}
		} else if (!species.equals(other.species)) {
			return false;
		}
		return true;
	}


}
