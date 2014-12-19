package org.mihaylov.furniture.dao;

import java.util.List;

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
}
