package org.mihaylov.furniture.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mihaylov.furniture.dao.CategoryDao;
import org.mihaylov.furniture.dao.ProductDao;
import org.mihaylov.furniture.entity.Category;
import org.mihaylov.furniture.entity.Product;
import org.mihaylov.furniture.utils.FileSystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service("productService")
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Transactional
	public void save(Product product) {
		productDao.save(product);
	}
	
	@Transactional
	public void save(Product product, MultipartFile image) throws IOException {
		product.setImage(saveImage(image));
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
	public Product load(Integer id) {
		return productDao.load(id);
	}
	
	@Transactional
	public List<Product> searchByCategoryId(Integer id) {
		return productDao.searchByCategoryId(id);
	}
	
	@Transactional
	public void update(Product product) {
		productDao.update(product);
	}
	
	@Transactional
	public void update(Product product, MultipartFile image, String oldImg)
			throws IOException {
		if (oldImg != null) {
			product.setImage(oldImg);
		} else if (image != null) {
			product.setImage(saveImage(image));
		}
		productDao.update(product);
	}
	
	@Transactional
	public Map<String, List<Product>> listGrouppedProducts() {
		Map<String, List<Product>> groupedProducts = new HashMap<String, List<Product>>();
		
		for (Category category : categoryDao.list()) {
			groupedProducts.put(category.getName(), productDao.searchByCategoryId(category.getId()));
		}
		return groupedProducts;
	}
	
	private String saveImage(MultipartFile file) throws IOException {
		return FileSystemUtils.saveMultipart(file, "product");
	}

}
