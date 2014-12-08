package org.mihaylov.furniture.dao;

import org.mihaylov.furniture.entity.Offer;

@org.springframework.transaction.annotation.Transactional
public class OfferDao extends GenericDao<Offer, Integer> {

	public OfferDao() {
		super(Offer.class);
	}
}
