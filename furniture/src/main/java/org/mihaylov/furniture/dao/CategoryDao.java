package org.mihaylov.furniture.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
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
	
	@SuppressWarnings("unchecked")
	public List<Category> listChildren(Category parent) {
		return (List<Category>) hibernateTemplate
				.findByCriteria(DetachedCriteria.forClass(Category.class)
						.add(Restrictions.eq("parent.id", parent.getId()))
						.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY));
	}
}
