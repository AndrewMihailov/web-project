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
@Table(name = "category")
@NamedQueries({
		@NamedQuery(name = "selectCategoryByParentId", query = "from Category c where c.parent.id= :parentId"),
		@NamedQuery(name = "selectRootCategory", query = "from Category c where c.parent is null") })
public class Category {

	@Id
	@Column(name = "category_id")
	@GeneratedValue
	private Integer id;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "parent_id")
	private Category parent;

	@Column(name = "name_ru")
	private String nameRu;

	@Column(name = "name_en")
	private String nameEn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

}
