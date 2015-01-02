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
	public List<Category> list(Integer first, Integer limit) {
		return categoryDao.list(first, limit == null ? 5 : limit);
	}
	
	@Transactional
	public Integer count() {
		return categoryDao.count();
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
		result.put(null, root);
		/*
		 * бежим по не рутам
		 * если родака нет в резулте
		 *	 пихаем тудойть родака
		 * пихаем к родаку всех чилдренов
		 */
		List<Category> list = categoryDao.list();
		for (Category category : list) {
			if (category.getParent() != null) {
				if (!result.containsKey(category.getParent()))
					result.put(category.getParent(), categoryDao.selectByParent(category.getParent().getId()));
			}
		}
		return result;
	}

	public List<Category> listRoot() {
		return categoryDao.selectRoot();
	}
}
