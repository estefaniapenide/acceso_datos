package gal.mrnovoa.hibernate.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GROUPS")
public class Group {
	private long id;
	private String name;

	private Set<User> users = new HashSet<User>();

	public Group(String name) {
		this.name = name;
	}
	
	public void addUser(User user) {
		this.users.add(user);
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

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "USERS_GROUPS",
			joinColumns = @JoinColumn(name = "GROUP_ID"),
			inverseJoinColumns = @JoinColumn(name = "USER_ID")
	)
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}