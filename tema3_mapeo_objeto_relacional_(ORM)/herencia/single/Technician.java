package teis.dual.hibernate.herencia.single;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Technician")
public class Technician extends Employee {

	private int experienceYears = 0;

	
	public int getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}

	@Override
	public String toString() {
		return "Technician { technicianId=" + id + ", experienceYears=" + experienceYears + " }";
	}
}
