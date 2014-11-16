package org.mihaylov.furniture.dao;

import java.util.List;

import org.mihaylov.furniture.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

@org.springframework.transaction.annotation.Transactional
public class NewsDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void saveNews(News news) {
		hibernateTemplate.save(news);
	}

	public List<News> list() {
		return hibernateTemplate.loadAll(News.class);
	}
	
}
