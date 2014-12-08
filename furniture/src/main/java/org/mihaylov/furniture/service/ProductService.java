package org.mihaylov.furniture.service;

import java.util.List;
import org.mihaylov.furniture.dao.ProductDao;
import org.mihaylov.furniture.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("productService")
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Transactional
	public void save(Product product) {
		productDao.save(product);
	}

	@Transactional
	public List<Product> list() {
		return productDao.list();
	}

	@Transactional
	public void delete(Integer id) {
		productDao.delete(productDao.load(id));
	}
	
	@Transactional
	public Product get(Integer id) {
		return productDao.load(id);
	}
	
	@Transactional
	public List<Product> searchByCategoryId(Integer id) {
		return productDao.searchByCategoryId(id);
	}

}
