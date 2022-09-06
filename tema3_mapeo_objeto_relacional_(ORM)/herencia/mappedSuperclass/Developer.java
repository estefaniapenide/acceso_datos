package teis.dual.hibernate.herencia.mappedSuperclass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
public class Developer extends Technician {

	private String expertLanguajes = null;
	
	public String getExpertLanguajes() {
		return expertLanguajes;
	}

	public void setExpertLanguajes(String expertLanguajes) {
		this.expertLanguajes = expertLanguajes;
	}

	@Override
	public String toString() {
		return "Developer { developerId=" + id + ", expertLanguajes=" + expertLanguajes + " }";
	}
}
