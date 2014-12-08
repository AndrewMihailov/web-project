package org.mihaylov.furniture.service;

import java.util.List;

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
}
