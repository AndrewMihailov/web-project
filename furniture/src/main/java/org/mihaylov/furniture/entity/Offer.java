package org.mihaylov.furniture.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "offer")
@NamedQueries({ @NamedQuery(name = "selectOffersByLocale", query = "from Offer o where o.lang = :lang") })
public class Offer {

	@Id
	@Column(name = "offer_id")
	@GeneratedValue
	private int id;
	
	@Column(name = "lang")
	private String lang;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "category_id")
	private Category category;

	@Column(name = "size")
	private int size;

	@Column(name = "text")
	private String text;
	
	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
