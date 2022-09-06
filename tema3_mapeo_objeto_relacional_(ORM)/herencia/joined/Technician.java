package teis.dual.hibernate.herencia.joined;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="employeeId")
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
