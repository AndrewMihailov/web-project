package org.mihaylov.furniture.service;

import java.util.List;

import org.mihaylov.furniture.dao.NewsDao;
import org.mihaylov.furniture.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("newsService")
public class NewsService {

	@Autowired
	private NewsDao newsDao;
	
	@Transactional
	public void save(News news) {
		newsDao.save(news);
	}

	@Transactional
	public List<News> list() {
		return newsDao.list();
	}

	@Transactional
	public void delete(Integer id) {
		newsDao.delete(newsDao.load(id));
	}
	
	public News get(Integer id) {
		return newsDao.load(id);
	}
}
