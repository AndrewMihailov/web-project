package org.mihaylov.furniture.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
@NamedQueries({ @NamedQuery(name = "selectContactsByLocale", query = "from Contact c where c.lang = :lang") })
public class Contact {

	@Id
	@Column(name = "contact_id")
	@GeneratedValue
	private int id;
	
	@Column(name = "lang")
	private String lang;

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	@Column(name = "type")
	private String type;

	@Column(name = "fio")
	private String fio;

	@Column(name = "tel_number")
	private String telNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFio() {
		return fio;
	}

	public void setFio(String fio) {
		this.fio = fio;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
