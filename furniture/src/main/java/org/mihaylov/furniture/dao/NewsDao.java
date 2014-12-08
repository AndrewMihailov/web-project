package org.mihaylov.furniture.dao;

import org.mihaylov.furniture.entity.News;

@org.springframework.transaction.annotation.Transactional
public class NewsDao extends GenericDao<News, Integer> {

	public NewsDao() {
		super(News.class);
	}
}
