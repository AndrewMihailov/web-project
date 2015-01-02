package org.mihaylov.furniture.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.mihaylov.furniture.entity.Product;

@org.springframework.transaction.annotation.Transactional
public class ProductDao extends GenericDao<Product, Integer> {

	public ProductDao() {
		super(Product.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> searchByCategoryId(Integer id, Integer first, Integer limit) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class)
				.add(Restrictions.eq("category.id", id))
				.addOrder(Order.desc("id"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<Product>) hibernateTemplate.findByCriteria(criteria, first, limit);
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> searchByCategoryId(Integer id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class)
				.add(Restrictions.eq("category.id", id))
				.addOrder(Order.desc("id"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<Product>) hibernateTemplate.findByCriteria(criteria);
	}

}
