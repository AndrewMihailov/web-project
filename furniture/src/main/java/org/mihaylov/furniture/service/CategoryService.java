package org.mihaylov.furniture.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.mihaylov.furniture.dao.CategoryDao;
import org.mihaylov.furniture.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("categoryService")
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Transactional
	public void save(Category category) {
		categoryDao.save(category);
	}

	@Transactional
	public List<Category> list() {
		return categoryDao.list();
	}

	@Transactional
	public void delete(Integer id) {
		categoryDao.delete(categoryDao.load(id));
	}
	
	@Transactional
	public void update(Category category) {
		categoryDao.update(category);
	}
	
	@Transactional
	public Category load(Integer id) {
		return categoryDao.load(id);
	}
	
	@Transactional
	public Map<Category, List<Category>> listOrganized() {
		Map<Category, List<Category>> result = new LinkedHashMap<Category, List<Category>>();
		List<Category> root = categoryDao.selectRoot();
		for (Category category : root) {
			result.put(category, categoryDao.selectByParent(category.getId()));
		}
		return result;
	}
}
