package org.mihaylov.furniture.service;

import java.util.List;

import org.mihaylov.furniture.dao.OfferDao;
import org.mihaylov.furniture.entity.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("offerService")
public class OfferService {

	@Autowired
	private OfferDao offerDao;
	
	@Transactional
	public void save(Offer offer) {
		offerDao.save(offer);
	}
	
	@Transactional
	public List<Offer> list() {
		return offerDao.list();
	}
	
	@Transactional
	public void delete(Integer id) {
		offerDao.delete(offerDao.load(id));
	}
}
