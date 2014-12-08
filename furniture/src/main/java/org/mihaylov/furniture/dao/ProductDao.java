package org.mihaylov.furniture.dao;

import java.util.List;

import org.mihaylov.furniture.entity.Product;

@org.springframework.transaction.annotation.Transactional
public class ProductDao extends GenericDao<Product, Integer> {

	public ProductDao() {
		super(Product.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> searchByCategoryId(Integer id) {
		return (List<Product>) hibernateTemplate.findByNamedQueryAndNamedParam("searchByCategoryId", "categoryId", id);
	}

}
