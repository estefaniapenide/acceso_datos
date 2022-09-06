package teis.dual.hibernate.herencia.joined;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name="employeeId")
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
