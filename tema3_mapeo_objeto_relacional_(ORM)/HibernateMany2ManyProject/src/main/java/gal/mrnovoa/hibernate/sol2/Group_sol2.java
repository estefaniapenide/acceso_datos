package gal.mrnovoa.hibernate.sol2;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GROUPS_SOL2")
public class Group_sol2 {
	private long id;
	private String name;

	private Set<UserGroup_sol2> userGroups = new HashSet<UserGroup_sol2>();
	
	public Group_sol2() {
	}

	public Group_sol2(String name) {
		this.name = name;
	}
		
	@Id
	@GeneratedValue
	@Column(name = "GROUP_ID")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "primaryKey.group",
			cascade = CascadeType.ALL)
	public Set<UserGroup_sol2> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(Set<UserGroup_sol2> groups) {
		this.userGroups = groups;
	}
	
	public void addUserGroup(UserGroup_sol2 userGroup) {
		this.userGroups.add(userGroup);
	}

}