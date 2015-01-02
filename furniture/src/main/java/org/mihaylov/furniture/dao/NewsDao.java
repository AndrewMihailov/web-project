package org.mihaylov.furniture.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
	
	public Integer count(String lang) {
		DetachedCriteria criteria = DetachedCriteria.forClass(News.class).add(Restrictions.eq("lang", lang))
				.setProjection(Projections.rowCount());
		return ((Long) hibernateTemplate.findByCriteria(criteria).get(0)).intValue();
	}
	
	@SuppressWarnings("unchecked")
	public List<News> selectDiapasonByLocale(Integer first, Integer limit, String lang) {
		DetachedCriteria criteria = DetachedCriteria.forClass(News.class).add(Restrictions.eq("lang", lang))
				.addOrder(Order.desc("id"));
		return (List<News>) hibernateTemplate.findByCriteria(criteria, first, limit);
	}
}
