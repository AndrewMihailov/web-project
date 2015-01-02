package org.mihaylov.furniture.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.mihaylov.furniture.entity.Offer;

@org.springframework.transaction.annotation.Transactional
public class OfferDao extends GenericDao<Offer, Integer> {

	public OfferDao() {
		super(Offer.class);
	}

	@SuppressWarnings("unchecked")
	public List<Offer> selectByLocale(String lang) {
		return (List<Offer>) hibernateTemplate.findByNamedQueryAndNamedParam("selectOffersByLocale", "lang", lang);
	}
	
	public Integer count(String lang) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Offer.class).add(Restrictions.eq("lang", lang))
				.setProjection(Projections.rowCount());
		return ((Long) hibernateTemplate.findByCriteria(criteria).get(0)).intValue();
	}
	
	@SuppressWarnings("unchecked")
	public List<Offer> selectDiapasonByLocale(Integer first, Integer limit, String lang) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Offer.class).add(Restrictions.eq("lang", lang))
				.addOrder(Order.desc("id"));
		return (List<Offer>) hibernateTemplate.findByCriteria(criteria, first, limit);
	}
}
