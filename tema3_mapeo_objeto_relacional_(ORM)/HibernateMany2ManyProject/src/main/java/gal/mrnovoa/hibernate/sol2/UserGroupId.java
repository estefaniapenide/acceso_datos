package gal.mrnovoa.hibernate.sol2;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class UserGroupId implements Serializable {//hace falta serializarlo para que esté disponible
	private User_sol2 user;
	private Group_sol2 group;

	@ManyToOne(cascade = CascadeType.ALL)
	public User_sol2 getUser() {
		return user;
	}

	public void setUser(User_sol2 user) {
		this.user = user;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public Group_sol2 getGroup() {
		return group;
	}

	public void setGroup(Group_sol2 group) {
		this.group = group;
	}

}
