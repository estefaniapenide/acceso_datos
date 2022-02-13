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
@Table(name = "USERS_SOL2")
public class User_sol2 {
	private long id;
	private String username;
	private String password;
	private String email;	

	private Set<UserGroup_sol2> userGroups = new HashSet<UserGroup_sol2>();

	public User_sol2() {
	}

	public User_sol2(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public void addGroup(UserGroup_sol2 group) {
		this.userGroups.add(group);
	}

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(mappedBy = "primaryKey.user", 
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