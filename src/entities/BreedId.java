package entities;

import java.io.Serializable;

public class BreedId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Species species;
	private Breed breed;
	
	private BreedId(){	}
	
	public BreedId(Species species, Breed breed) {
		super();
		this.species = species;
		this.breed = breed;
	}
	public Species getSpecies() {
		return species;
	}
	public void setSpecies(Species species) {
		this.species = species;
	}
	public Breed getBreed() {
		return breed;
	}
	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
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
		if (breed == null) {
			if (other.breed != null) {
				return false;
			}
		} else if (!breed.equals(other.breed)) {
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
