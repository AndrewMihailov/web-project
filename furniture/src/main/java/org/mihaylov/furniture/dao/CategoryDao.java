package org.mihaylov.furniture.dao;

import org.mihaylov.furniture.entity.Category;

@org.springframework.transaction.annotation.Transactional
public class CategoryDao extends GenericDao<Category, Integer> {

	public CategoryDao() {
		super(Category.class);
	}
}
