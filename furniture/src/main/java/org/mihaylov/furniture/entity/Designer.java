package org.mihaylov.furniture.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "designer")
public class Designer {

	@Id
	@Column(name = "designer_id")
	@GeneratedValue
	private int id;
	
	@Column(name = "fio")
	private String fio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFio() {
		return fio;
	}

	public void setFio(String fio) {
		this.fio = fio;
	}
}
