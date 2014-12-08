package org.mihaylov.furniture.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
@NamedQueries({ @NamedQuery(name = "findByLogin", query = "from Admin where login=:login") })
public class Admin {

	@Id
	@Column(name = "admin_id", unique = true, nullable = false)
	@GeneratedValue
	private int id;

	@Column(name = "login", unique = true, nullable = false)
	private String login;

	@Column(name = "password")
	private String password;

	@Column(name = "role")
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
