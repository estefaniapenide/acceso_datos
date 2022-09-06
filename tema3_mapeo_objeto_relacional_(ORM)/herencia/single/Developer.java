package teis.dual.hibernate.herencia.single;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("Developer")
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
