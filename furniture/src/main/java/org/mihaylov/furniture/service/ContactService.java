package org.mihaylov.furniture.service;

import java.util.List;
import java.util.Locale;

import org.mihaylov.furniture.dao.ContactDao;
import org.mihaylov.furniture.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("contactService")
public class ContactService {
	
	@Autowired
	private ContactDao contactDao;
	
	@Transactional
	public void save(Contact contact) {
		contactDao.save(contact);
	}
	
	@Transactional
	public void delete(Integer id) {
		contactDao.delete(contactDao.load(id));
	}
	
	@Transactional
	public List<Contact> list() {
		return contactDao.list();
	}
	
	@Transactional
	public List<Contact> list(Integer first, Integer limit) {
		return contactDao.list(first, limit == null ? 5 : limit);
	}
	
	@Transactional
	public Integer count() {
		return contactDao.count();
	}
	
	@Transactional
	public List<Contact> list(Locale locale) {
		return contactDao.selectByLocale(locale.toString());
	}
	
	@Transactional
	public Integer count(Locale locale) {
		return contactDao.count(locale.toString());
	}
	
	@Transactional
	public List<Contact> list(Integer first, Integer limit, Locale locale) {
		return contactDao.selectDiapasonByLocale(first, limit, locale.toString());
	}
	
	@Transactional
	public Contact load(Integer id) {
		return contactDao.load(id);
	}
	
	@Transactional
	public void update(Contact contact) {
		contactDao.update(contact);
	}
}
