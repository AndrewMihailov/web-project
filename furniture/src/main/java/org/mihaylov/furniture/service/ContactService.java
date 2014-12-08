package org.mihaylov.furniture.service;

import java.util.List;

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
}
