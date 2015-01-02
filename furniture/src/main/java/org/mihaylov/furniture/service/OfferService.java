package org.mihaylov.furniture.service;

import java.util.List;
import java.util.Locale;

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
	public List<Offer> list(Locale locale) {
		return offerDao.selectByLocale(locale.toString());
	}

	@Transactional
	public Integer count(Locale locale) {
		return offerDao.count(locale.toString());
	}

	@Transactional
	public Integer count() {
		return offerDao.count();
	}
	
	@Transactional
	public List<Offer> list(Integer first, Integer limit) {
		return offerDao.list(first, limit == null ? 5 : limit);
	}

	@Transactional
	public List<Offer> list(Integer first, Integer limit, Locale locale) {
		return offerDao.selectDiapasonByLocale(first, limit, locale.toString());
	}

	@Transactional
	public void delete(Integer id) {
		offerDao.delete(offerDao.load(id));
	}

	@Transactional
	public void update(Offer offer) {
		offerDao.update(offer);
	}

	@Transactional
	public Offer load(Integer id) {
		return offerDao.load(id);
	}
}
