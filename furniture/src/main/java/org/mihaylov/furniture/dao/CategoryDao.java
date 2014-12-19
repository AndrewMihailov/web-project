package org.mihaylov.furniture.dao;

import java.util.List;

import org.mihaylov.furniture.entity.Category;

@org.springframework.transaction.annotation.Transactional
public class CategoryDao extends GenericDao<Category, Integer> {

	public CategoryDao() {
		super(Category.class);
	}

	@SuppressWarnings("unchecked")
	public List<Category> selectByParent(Integer parentId) {
		return (List<Category>) hibernateTemplate
				.findByNamedQueryAndNamedParam("selectCategoryByParentId",
						"parentId", parentId);
	}

	@SuppressWarnings("unchecked")
	public List<Category> selectRoot() {
		return (List<Category>) hibernateTemplate
				.findByNamedQuery("selectRootCategory");
	}
}
