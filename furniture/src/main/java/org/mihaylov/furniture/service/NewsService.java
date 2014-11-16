package org.mihaylov.furniture.service;

import java.util.List;

import org.mihaylov.furniture.dao.NewsDao;
import org.mihaylov.furniture.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NewsService {

	@Autowired
	private NewsDao newsDao;
	
	@Transactional
	public void addNews(News news) {
		newsDao.saveNews(news);
	}

	@Transactional
	public List<News> listNews() {
		return newsDao.list();
	}

	@Transactional
	public void removeNews(Integer id) {
	}

	public NewsDao getNewsDao() {
		return newsDao;
	}

	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}
}
