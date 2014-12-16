package org.mihaylov.furniture.dao;

import java.util.List;

import org.mihaylov.furniture.entity.News;

@org.springframework.transaction.annotation.Transactional
public class NewsDao extends GenericDao<News, Integer> {

	public NewsDao() {
		super(News.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<News> selectByLocale(String lang) {
		return (List<News>) hibernateTemplate.findByNamedQueryAndNamedParam("selectNewsByLocale", "lang", lang);
	}
}
