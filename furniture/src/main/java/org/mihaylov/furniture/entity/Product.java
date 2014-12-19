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
@Table(name = "product")
@NamedQueries({ @NamedQuery(name = "searchByCategoryId", query = "select p from Product p join p.category c where c.id = :categoryId or c.parent.id = :categoryId") })
public class Product {

	@Id
	@Column(name = "product_id")
	@GeneratedValue
	private Integer id;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "designer_id")
	private Designer designer;

	@Column(name = "name_ru")
	private String nameRu;
	
	@Column(name = "name_en")
	private String nameEn;

	@Column(name = "description_ru")
	private String descriptionRu;
	
	@Column(name = "description_en")
	private String descriptionEn;

	@Column(name = "price")
	private Integer price;

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Column(name = "image")
	private String image;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Designer getDesigner() {
		return designer;
	}

	public void setDesigner(Designer designer) {
		this.designer = designer;
	}

	public String getNameRu() {
		return nameRu;
	}

	public void setNameRu(String nameRu) {
		this.nameRu = nameRu;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getDescriptionRu() {
		return descriptionRu;
	}

	public void setDescriptionRu(String descriptionRu) {
		this.descriptionRu = descriptionRu;
	}

	public String getDescriptionEn() {
		return descriptionEn;
	}

	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}

}
