package org.mihaylov.furniture.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "news")
@NamedQueries({ @NamedQuery(name = "selectNewsByLocale", query = "from News n where n.lang = :lang")})
public class News {

	@Id
	@Column(name = "news_id")
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

	@Column(name = "date")
	private Date date;
	
	@Column(name= "title")
	public String title;
	
	@Column(name = "preview")
	private String preview;
	
	@Column(name = "text")
	private String text;
	
	@Column(name = "image")
	private String image;
	
	@PrePersist
    protected void onCreate() {
		date = new Date(new java.util.Date().getTime());
    }
	
	@PreUpdate
	protected void onUpdate() {
		date = new Date(new java.util.Date().getTime());
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
