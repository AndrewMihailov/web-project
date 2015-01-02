package org.mihaylov.furniture.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		if (!image.isEmpty())
			product.setImage(saveImage(image));
		productDao.save(product);
	}

	@Transactional
	public List<Product> list() {
		return productDao.list();
	}
	
	@Transactional
	public Integer count() {
		return productDao.count();
	}
	
	@Transactional
	public List<Product> list(Integer first, Integer limit) {
		return productDao.list(first, limit == null ? 5 : limit);
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
	public List<Product> searchByCategoryId(Integer id, Integer first, Integer limit) {
		Category root = categoryDao.load(id);
		List<Category> categories = categoryDao.selectByParent(id);
		categories.add(root);
		
		List<Product> list = new ArrayList<Product>();
		for (Category category : categories) {
			list.addAll(productDao.searchByCategoryId(category.getId(), first, limit));
		}
		/*
		Category root = categoryDao.load(id);
		List<Product> list = new ArrayList<Product>();
		List<Category> categories = categoryDao.selectByParent(id);
		categories.add(root);
		
		while (categories.size() > 0) {
			Category category = categories.get(0);
			List<Category> children = categoryDao.listChildren(category);
			categories.addAll(children);
			
			list.addAll(productDao.searchByCategoryId(category.getId()));
			categories.remove(0);
		}
		
		Integer i = first;
		while (i > 0) {
			list.remove(0);
			i--;
		}
		while (list.size() > limit)
			list.remove(list.size() - 1);
		*/
		return list;
	}
	
	@Transactional
	public List<Product> searchByCategoryId(Integer id) {
		Category root = categoryDao.load(id);
		List<Product> list = new ArrayList<Product>();
		List<Category> categories = categoryDao.selectByParent(id);
		categories.add(root);
		
		while (categories.size() > 0) {
			Category category = categories.get(0);
			categories.addAll(categoryDao.listChildren(category));
			list.addAll(productDao.searchByCategoryId(category.getId()));
			categories.remove(0);
		}
		return list;
	}
	
	@Transactional
	public void update(Product product) {
		productDao.update(product);
	}
	
	@Transactional
	public void update(Product product, MultipartFile image, String oldImg)
			throws IOException {
		product.setImage(oldImg);
		if (image != null && !image.isEmpty() && oldImg == null) {
			product.setImage(saveImage(image));
		}
		productDao.update(product);
	}
	/*
	@Transactional
	public Map<String, List<Product>> listGrouppedProducts() {
		Map<String, List<Product>> groupedProducts = new HashMap<String, List<Product>>();
		
		for (Category category : categoryDao.list()) {
			groupedProducts.put(category.getNameRu(), productDao.searchByCategoryId(category.getId()));
		}
		return groupedProducts;
	}
	*/
	private String saveImage(MultipartFile file) throws IOException {
		return FileSystemUtils.saveMultipart(file, "product");
	}
	
	public void deleteOldImage(Integer id) {
		FileSystemUtils.deleteFile(load(id).getImage());
	}

}
