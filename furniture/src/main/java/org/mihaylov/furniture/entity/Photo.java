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
@Table(name = "photo")
@NamedQueries({ @NamedQuery(name = "searchByProductId", query = "select p from Photo p join p.product pr where pr.id = :productId") })
public class Photo {

	@Id
	@Column(name = "photo_id")
	@GeneratedValue
	private int id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "product_id")
	private Product product;

	@Column(name = "image")
	private String image;

	@Column(name = "description_ru")
	private String descriptionRu;
	
	@Column(name = "description_en")
	private String descriptionEn;

	@Column(name = "width")
	private Integer width;

	@Column(name = "height")
	private Integer height;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
